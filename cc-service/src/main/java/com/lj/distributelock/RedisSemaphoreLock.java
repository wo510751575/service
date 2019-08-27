package com.lj.distributelock;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市杨恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.lj.base.core.util.AssertUtils;
import com.lj.base.exception.TsfaRuntimeException;
import com.lj.base.exception.TsfaServiceException;
import com.lj.cc.dto.FindSystemGroup;
import com.lj.distributecache.RedisCache;
import com.lj.distributecache.RedisCacheConfigFromCC;

/**
 * 
 * 
 * 类说明：
 *  
 * 
 * <p>
 * 详细描述：
 * RedisLock 信号灯机制锁
 * 【无超时，需要客户端自行维护释放，
 * 客户端可以拿到n个，可在CC端配置】 
 * @Company: 杨恩科技有限公司
 * @author 彭阳
 *   
 * CreateDate: 2017年7月1日
 */
public class RedisSemaphoreLock   implements IDistributeLock{
//	private static Logger logger = LoggerFactory.getLogger(RedisSemaphoreLock.class); 
	/** The Constant SEMAPHORE_INDEX_PREFIX. */
private static final String SEMAPHORE_INDEX_PREFIX = "TIMESSHARING_SEMAPHORE_IDX";
	
	/** * redicCache. */
	private RedisCache redisCache;
	
	/** * 分布式锁配置，key:锁允许的最大量. */
	private Map<String,Long> semaphoreCntMap ;
	
	/**
	 * Gets the * 分布式锁配置，key:锁允许的最大量.
	 *
	 * @return the * 分布式锁配置，key:锁允许的最大量
	 */
	public Map<String, Long> getSemaphoreCntMap() {
		return semaphoreCntMap;
	}

	/**
	 * Sets the * 分布式锁配置，key:锁允许的最大量.
	 *
	 * @param semaphoreCntMap the new * 分布式锁配置，key:锁允许的最大量
	 */
	public void setSemaphoreCntMap(Map<String, Long> semaphoreCntMap) {
		this.semaphoreCntMap = semaphoreCntMap;
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
	 * Sets the * redicCache.
	 *
	 * @param redisCache the new * redicCache
	 */
	public void setRedisCache(RedisCache redisCache) {
		this.redisCache = redisCache;
		//----获取配置文件并设置--------
		if(this.redisCache instanceof RedisCacheConfigFromCC){ 
			//-----从CC获取参数设置Redis Service--------
			FindSystemGroup fsg = new FindSystemGroup();
			fsg.setSystemAliasName("cc");
			fsg.setGroupName("semaphoreLock");
			//----从CC获取参数组------------
			Map<String,String> fsgr = ((RedisCacheConfigFromCC)redisCache).getSystemParamService().findSystemGroup(fsg).getGroupMaps();
			semaphoreCntMap = new HashMap<String,Long>();
			//Map<String,String> to Map<String,Long>
			for(String key : fsgr.keySet()){
				semaphoreCntMap.put(key, Long.valueOf(fsgr.get(key)));
			}
		}
	}

	/* (non-Javadoc)
	 * @see com.lj.distributelock.IDistributeLock#getLockNoWait(java.lang.String)
	 */
	@Override
	public String getLockNoWait(String lockName) {
		long maxSemaphore = semaphoreCntMap.get(lockName);
		String key = SEMAPHORE_INDEX_PREFIX+lockName;
		String currentSemaphoreStr = redisCache.get(key);
		long currentSemaphore = 0;
		//不为空则转换
		if(StringUtils.isNotEmpty(currentSemaphoreStr))
			currentSemaphore = Long.valueOf(currentSemaphoreStr);
		
		if(currentSemaphore<maxSemaphore){
			//初步判断还有空闲，计数器预加
			long afterSet = redisCache.setIncr(key);
//			if(logger.isDebugEnabled())
//				logger.debug("【RedisSemaphoreLock】"+lockName+"  maxSemaphore"+maxSemaphore+" currentSemaphore:"+currentSemaphore+" afterSet:"+afterSet);
			//超过了
			if(afterSet>maxSemaphore){
				long afterDecr = redisCache.setDecr(key);//减回去
//				logger.error("【RedisSemaphoreLock】"+lockName+"  maxSemaphore"+maxSemaphore+" currentSemaphore:"+currentSemaphore+" afterSet:"+afterSet+" afterDecr:"+afterDecr);
				throw new TsfaRuntimeException("RedisSemaphoreLock-afterSet",lockName+"资源刚被抢光了"+afterDecr);
			}else{
				//-------------
				return lockName+afterSet;
			}
		}
		throw new TsfaRuntimeException("RedisSemaphoreLock-currentSemaphore",lockName+"资源已经被抢光了");
	}
	
	/* (non-Javadoc)
	 * @see com.lj.distributelock.IDistributeLock#getLockNoWait(java.lang.String, int)
	 */
	@Override
	public String getLockNoWait(String lockName, int lockExpireSeconds) {
		throw new TsfaRuntimeException("RedisSemaphoreLock-currentSemaphore","不支持的方法");
	}
	
	/**
	 * lockValue,timeout  手动传入
	 * @param lockName
	 * @param lockExpireSeconds
	 * @param timeOut  手动传入
	 * @return
	 */
	@Override
	public String getLockNoWait(String lockName,String lockValue, int lockExpireSeconds , Integer timeOut) {
		throw new TsfaRuntimeException("RedisSemaphoreLock-currentSemaphore","不支持的方法");

	}

	/* (non-Javadoc)
	 * @see com.lj.distributelock.IDistributeLock#getLockUntilTimeout(java.lang.String, int)
	 */
	@Override
	public String getLockUntilTimeout(String lockName, int millsTimeout) {
//		String newLockName = SEMAPHORE_INDEX_PREFIX+lockName;
		String lockValue = null;
		long beginTime = System.currentTimeMillis();
		while(System.currentTimeMillis() - beginTime<millsTimeout){
			try {
				lockValue = getLockNoWait(lockName);
				return lockValue;//拿到了，直接返回
			} catch (Throwable e) {
				// 获取锁异常，一般是其他朋友占用了，等待
				try {
					Thread.sleep(50);
				} catch (InterruptedException ei) {
					//休息100毫秒，中断异常什么都不做
				}
			}
		}
		throw  new TsfaRuntimeException("getLockUntilTimeout-error","lockName:"+lockName+"等待了"+millsTimeout+"无法获得");
	
	}

	@Override
	public String getLockUntilTimeout(String lockName, int millsTimeout, int lockExpireSeconds) {
		throw new TsfaRuntimeException("getLockUntilTimeout-error","不支持的方法");
	}

	/* (non-Javadoc)
	 * @see com.lj.distributelock.IDistributeLock#releaseLock(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean releaseLock(String lockName, String lockValue) {
		AssertUtils.state(lockValue.startsWith(lockName));
		long maxSemaphore = semaphoreCntMap.get(lockName);
		long semaphoreIndex = Long.valueOf(lockValue.substring(lockName.length()));
		AssertUtils.state( semaphoreIndex>=0 && semaphoreIndex<= maxSemaphore);
		long afterSet = redisCache.setDecr(SEMAPHORE_INDEX_PREFIX+lockName);
//		if(logger.isDebugEnabled())
//			logger.debug("【RedisSemaphoreLock】"+lockName+" afterSet:"+afterSet);
		AssertUtils.state(afterSet>=0);//小于0，说明有人没get成功就释放了
		return true;
	}
	
	@Override
	public boolean releaseLock(String lockName) {
		throw new TsfaRuntimeException("releaseLock-error","不支持的方法");
	}

	/**
	 * *
	 * 延长锁寿命，只有lockValue正确延长（get方法获得的值）.
	 *
	 * @param lockName the lock name
	 * @param lockValue the lock value
	 * @return true, if expand lock time
	 */
	@Override
	public boolean expandLockTime(String lockName, String lockValue) {
		//暂不支持
		return false;
	}
	
	/**
	 * *
	 * 判断锁是否还有效.
	 *
	 * @param lockName the lock name
	 * @param lockValue the lock value
	 * @return true, if checks if is lock available
	 */
	@Override
	public boolean isLockAvailable(String lockName, String lockValue) {
		//暂不支持
		return false;
	} 
 
 
}
