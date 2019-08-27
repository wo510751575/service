package com.lj.distributelock;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市杨恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lj.cc.dto.FindSystemGroup;
import com.lj.distributecache.RedisCache;
import com.lj.distributecache.RedisCacheConfigFromCC;
import com.lj.base.core.encryption.MD5;
import com.lj.base.core.util.AssertUtils;
import com.lj.base.core.util.StringUtils;
import com.lj.base.exception.TsfaRuntimeException;

/**
 * 
 * 
 * 类说明：
 *  
 * 
 * <p>
 * 详细描述：
 * ResourceLootingLock 抢资源锁
 * 【无超时，需要客户端自行维护释放，
 * 客户端申请资源数，不能拿到返回0，
 * 资源不够返回最后剩余的， 最后一个人可能能拿到部分资源】
 * @Company: 杨恩科技有限公司
 * @author 彭阳
 *   
 * CreateDate: 2017年7月1日
 */
public class RedisResourceLootingLock   implements IResourceLootingLock{
	
	/** The Constant STRING_KEYVALUE_SPLIT. */
	private static final String STRING_KEYVALUE_SPLIT = ":";//key:value
	
	/** The Constant STRING_KEYS_SPLIT. */
	private static final String STRING_KEYS_SPLIT = ",";//key:value
	//未申请到资源返回的信息
	/** The Constant LOCKVALUE_NOT_APPLIED. */
	public static final String LOCKVALUE_NOT_APPLIED = "NOTAPPLIED";
	
	/** The logger. */
	private static Logger logger = LoggerFactory.getLogger(RedisResourceLootingLock.class); 
	
	/** The Constant RESOURCE_LOOTING_LOCK. */
	private static final String RESOURCE_LOOTING_LOCK = "TIMESSHARING_RESOURCE_LOOTING_IDX";

	//设置超时时间
	/** The Constant TIMEOUT_KEY_PREFIX. */
	private static final  String TIMEOUT_KEY_PREFIX = "ts_p2p_timeout_";
	//最好一次部分申请数据的保存信息
	/** The Constant LAST_KEY_PREFIX. */
	private static final  String LAST_KEY_PREFIX = "ts_p2p_part_";
	
	/** The Constant DEFAULT_TIMEOUT. */
	private static final long DEFAULT_TIMEOUT = 60*60*24*365*10*1000;//十年
	
	/** * redicCache. */
	private RedisCache redisCache;
	
	/** * 分布式锁配置，key:锁允许的最大量 key+"timeout":超时时间. */
	private Map<String,Long> resourceLootingMap ; 

	/**
	 * *
	 * 资源大小手工设置，建议配置在CC
	 * 请调用我初始化抢夺资源的资源大小
	 * 【重启要特别注意哦！】.
	 *
	 * @param lockName the lock name
	 * @param resourceLootingMaxValue the resource looting max value
	 */
	@Override
	public void setResourceLootingCntMap(String lockName,long resourceLootingMaxValue) {
		setResourceLootingCntMap(lockName,resourceLootingMaxValue,DEFAULT_TIMEOUT);
	}

	/**
	 * *
	 * 资源大小手工设置，建议配置在CC
	 * 请调用我初始化抢夺资源的资源大小
	 * 【重启要特别注意哦！】.
	 *
	 * @param lockName the lock name
	 * @param resourceLootingMaxValue the resource looting max value
	 * @param resourceLootingTimeout 抢占超时设置,到毫秒
	 */
	@Override
	public void setResourceLootingCntMap(String lockName,long resourceLootingMaxValue,long resourceLootingTimeout) {
		resourceLootingMap.put(lockName, resourceLootingMaxValue);
		resourceLootingMap.put(TIMEOUT_KEY_PREFIX+lockName, resourceLootingTimeout);
		//------通过redis保存起来---------
		String key = RESOURCE_LOOTING_LOCK+"maps";
		String redisMapValue = redisCache.get(key);  
		//key:value保存起来		
		String simpleSerializedStr = STRING_KEYS_SPLIT+lockName+STRING_KEYVALUE_SPLIT;
		if(StringUtils.isNotEmpty(redisMapValue)){			
			if(redisMapValue.contains(simpleSerializedStr)){
				logger.debug("redisMapValue has set "+lockName);
				return;//已经设置了，以后台为准！
			}				
		}
		//资源锁大小设置
		redisMapValue = redisMapValue+simpleSerializedStr+resourceLootingMaxValue;
		//资源锁超时设置
		if(resourceLootingTimeout!=DEFAULT_TIMEOUT)
			redisMapValue = redisMapValue+STRING_KEYS_SPLIT+TIMEOUT_KEY_PREFIX+lockName+STRING_KEYVALUE_SPLIT+resourceLootingTimeout;
		
		redisCache.set(key,redisMapValue );
		
	}
	
	/**
	 * Gets the * redicCache.
	 *
	 * @return the * redicCache
	 */
	public RedisCache getRedisCache() {
		return redisCache;
	}
	
	/**
	 * *
	 * 从CC、redis读取原来的配置信息
	 * 包括资源池大小(key:value)和最后获取部分资源的超时释放时间(TIMEOUT_PREFIX+key:value）.
	 *
	 * @param redisCache the new * redicCache
	 */
	public void setRedisCache(RedisCache redisCache) {
		this.redisCache = redisCache;
		resourceLootingMap = new HashMap<String,Long>(); 
		//----获取配置文件并设置--------
		if(this.redisCache instanceof RedisCacheConfigFromCC){ 
			//-----从CC获取参数设置Redis Service--------
			FindSystemGroup fsg = new FindSystemGroup();
			fsg.setSystemAliasName("cc");
			fsg.setGroupName("resourceLootingCntMap");
			//----从CC获取参数组------------
			Map<String,String> fsgr = ((RedisCacheConfigFromCC)redisCache).getSystemParamService().findSystemGroup(fsg).getGroupMaps();
			
			//Map<String,String> to Map<String,Long>
			for(String key : fsgr.keySet()){
				resourceLootingMap.put(key, Long.valueOf(fsgr.get(key)));
			}
		}
		//------从redis读取数据-----------		
		readMapsFromRedis();
	}

	/**
	 * *
	 * setResourceLootingCntMap方法配置的资源
	 * 系统主动从redis调取.
	 */
	private void readMapsFromRedis(){
		//------通过redis保存起来---------
		String key = RESOURCE_LOOTING_LOCK+"maps";
		String redisMapValue = redisCache.get(key);  //redis read data
		if(StringUtils.isNotEmpty(redisMapValue)){
			for(String redisMap : redisMapValue.split(STRING_KEYS_SPLIT)){
				//STRING_KEYVALUE_SPLIT
				String []keyvalue = redisMap.split(STRING_KEYVALUE_SPLIT);
				//导入key/value
				if(keyvalue.length>1){
					try {
						resourceLootingMap.put(keyvalue[0], Long.valueOf(keyvalue[1]));
					} catch (Throwable e) {
						logger.error("readRedisMapsError:"+redisMap,e);
					}
				}
		}
		}
	}
	
	/* (non-Javadoc)
	 * @see com.lj.distributelock.IResourceLootingLock#getLockNoWait(java.lang.String, long)
	 */
	@Override
	public ResourceLootingReturnVO getLockNoWait(String lockName,long needResource) {
		AssertUtils.notNullAndEmpty(lockName);//锁名不能为空
		AssertUtils.state(needResource>0);//必须大于等于1
		long maxResourceLooting = resourceLootingMap.get(lockName);
		String key = RESOURCE_LOOTING_LOCK+lockName;
		String currentResourceLootingStr = redisCache.get(key);
		long currentResourceLooting = 0;
		//不为空则转换
		if(StringUtils.isNotEmpty(currentResourceLootingStr))
			currentResourceLooting = Long.valueOf(currentResourceLootingStr);
		
		if(currentResourceLooting<maxResourceLooting){
			//1、初步判断还有空闲，计数器预加
			long afterSet = redisCache.setIncr(key,needResource);
			if(logger.isDebugEnabled())
				logger.debug("【RedisResourceLootingLock】"+lockName+"  maxResourceLooting:"+maxResourceLooting+" currentResourceLooting:"+currentResourceLooting+" afterSet:"+afterSet);
			//并发情况，可能虽然过了第一步，第二步多个都抢了！
			long overflowedResource = afterSet - maxResourceLooting;
			if(overflowedResource<=0){
				//抢到了，而且没有溢出，申请到了全部		
				ResourceLootingReturnVO vo = new ResourceLootingReturnVO( lockName, needResource);
				vo.setAppliedResource( needResource);//申请到的资源
				vo.setLeftResource(maxResourceLooting-afterSet);//申请后剩余的资源
				vo.setTotalResource(maxResourceLooting);//最大资源
				vo.setLockValue( generateLockValue(vo) );//资源锁值
				return vo;
			}else if(overflowedResource<needResource){
				//抢到了，有溢出，申请到了部分
				ResourceLootingReturnVO vo = new ResourceLootingReturnVO( lockName, needResource);
				vo.setAppliedResource( needResource-overflowedResource);//申请到的资源
				vo.setLeftResource(0);//申请后不剩余资源
				vo.setTotalResource(maxResourceLooting);//最大资源
				vo.setLockValue( generateLockValue(vo) );//资源锁值
				redisCache.set(LAST_KEY_PREFIX+lockName,vo.toToken());//【保存到redis，最后一笔部分申请的资源】
				return vo;
			}else{		
				//资源用完了，资源锁值减回去
				long afterDecr = redisCache.setDecr(key,needResource);//减回去
				logger.debug("【RedisResourceLootingLock】"+lockName+"  maxResourceLooting"+maxResourceLooting+" currentResourceLooting:"+currentResourceLooting+" afterSet:"+afterSet+" afterDecr:"+afterDecr);
		 
				return timeoutRelease(lockName, needResource,maxResourceLooting);
				
			}
		}
		//没抢到
		return timeoutRelease(lockName, needResource,maxResourceLooting);
//		throw new TsfaRuntimeException("RedisSemaphoreLock-currentSemaphore",lockName+"资源已经被抢光了");
	}
	
	/**
	 * *
	 * 判断超时重新释放（没拿到时调用）.
	 *
	 * @param lockName the lock name
	 * @param needResource the need resource
	 * @param maxResourceLooting the max resource looting
	 * @return the resource looting return vo
	 */
	private ResourceLootingReturnVO timeoutRelease(String lockName, long needResource,long maxResourceLooting) {
		//判断最后申请的部分资源是否超时
		Long timeout = resourceLootingMap.get(TIMEOUT_KEY_PREFIX+lockName);
		String lastResourceLooted = redisCache.get(LAST_KEY_PREFIX+lockName);
		if(timeout!=null && StringUtils.isNotEmpty(lastResourceLooted)){
			//从redis获取最后一次部分获取数据并解析
			ResourceLootingReturnVO vo = ResourceLootingReturnVO.fromToken(lastResourceLooted);
			if(System.currentTimeMillis() - vo.getAppliedTime() > timeout){
				//----超时了对方-----------						
				logger.debug("RedisResourceLootingLockTimeout:"+vo.getAppliedTime());
				if(vo.getAppliedResource()<= needResource) {
					//抢到了，有溢出，申请到了部分,修改下申请时间,更新超时!
					vo.setAppliedTime(System.currentTimeMillis());
					vo.setLockValue( generateLockValue(vo) );//资源锁值
					redisCache.set(LAST_KEY_PREFIX+lockName,vo.toToken());//【保存到redis，最后一笔部分申请的资源】
					return vo;//[拿到它的资源，超时设置要修改下！]
				} else {
					//----资源锁值减回去-------
					this.releaseLock(lockName, vo);
					//---重新抢 -------
					return getLockNoWait(lockName,needResource);
				}
			}
		}
		//没有资源了！
		return new ResourceLootingReturnVO(lockName, 0,needResource,0,maxResourceLooting,LOCKVALUE_NOT_APPLIED);
	}
 
	/* (non-Javadoc)
	 * @see com.lj.distributelock.IResourceLootingLock#getLockUntilTimeout(java.lang.String, long, int)
	 */
	@Override
	public ResourceLootingReturnVO getLockUntilTimeout(String lockName,long needResource, int millsTimeout) {
		ResourceLootingReturnVO vo = null;
		long beginTime = System.currentTimeMillis();
		while(System.currentTimeMillis() - beginTime<millsTimeout){ 
				vo  = getLockNoWait(lockName,needResource);
				if(vo.getAppliedResource()>0)
					return vo;//拿到了，直接返回
				else{
					// 获取锁异常，一般是其他朋友占用了，等待
					try {
						Thread.sleep(50);
					} catch (InterruptedException ei) {
						//休息100毫秒，中断异常什么都不做
					}
				} 
		}
		throw  new TsfaRuntimeException("getResourceLootingLockUntilTimeout-error","lockName:"+lockName+"等待了"+millsTimeout+"无法获得");
	
	}

	/* (non-Javadoc)
	 * @see com.lj.distributelock.IResourceLootingLock#releaseLock(java.lang.String, com.lj.distributelock.ResourceLootingReturnVO)
	 */
	@Override
	public boolean releaseLock(String lockName,ResourceLootingReturnVO vo) {
		synchronized (lockName) {
			//锁值是否和计算所得一致
			AssertUtils.state(vo.getLockValue().equals(generateLockValue(vo) ));
			long maxResourceLooting = resourceLootingMap.get(lockName);
			long resourceLootingIdx = vo.getAppliedResource();
			AssertUtils.state( resourceLootingIdx>=0 && resourceLootingIdx<= maxResourceLooting);
			//	释放资源，把部分资源也释放掉
			if(confirmPartResource(lockName,vo)) {	//把部分资源也释放掉，if vo applied part
				long afterSet = redisCache.setDecr(RESOURCE_LOOTING_LOCK+lockName,vo.getApplyResource());
				//		if(logger.isDebugEnabled())
				//			logger.debug("【RedisSemaphoreLock】"+lockName+" afterSet:"+afterSet);
				AssertUtils.state(afterSet>=0);//小于0，说明有人没get成功就释放了
			} else {	// 已经释放了
				logger.debug("【RedisResourceLootingLock】"+lockName+"： 重复释放！");
			}
			return true;
		}
	}
	
	/**
	 * *
	 * 产生一个LockValue.
	 *
	 * @param vo the vo
	 * @return the string
	 */
	private String generateLockValue(ResourceLootingReturnVO vo){
		return MD5.encryptByMD5Twice(vo.getLockName()+vo.getTotalResource()+vo.getAppliedResource(), vo.getLeftResource()+"ResourceLooting"+vo.getApplyResource());
	}
	
	/**
	 * *
	 * 超时的任务，要去掉还原资源哦！.
	 *
	 * @param lockName the lock name
	 * @param vo the vo
	 * @return true, if confirm part resource
	 */
	@Override
	public boolean confirmPartResource(String lockName, ResourceLootingReturnVO vo) { 
		String lastResourceLooted = redisCache.get(LAST_KEY_PREFIX+lockName);
		if(StringUtils.isNotEmpty(lastResourceLooted) && lastResourceLooted.equals(vo.toToken())){
			redisCache.del(LAST_KEY_PREFIX+lockName);//del
			return true;
		} 
		return false;
	}	
	
}
