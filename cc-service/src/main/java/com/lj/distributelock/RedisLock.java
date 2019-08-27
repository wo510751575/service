package com.lj.distributelock;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市杨恩科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.base.core.util.AssertUtils;
import com.lj.base.exception.TsfaServiceException;
import com.lj.distributecache.RedisCache;

/**
 * 
 * 
 * 类说明：
 *  
 * 
 * <p>
 * 详细描述：
 * RedisLock 锁
 * 【客户端只有一个能拿到，超过十分钟客户端没释放，服务器也释放了】
 * @Company: 杨恩科技有限公司
 * @author 彭阳
 *   
 * CreateDate: 2017年7月1日
 */
public class RedisLock implements IDistributeLock{
	

	/** * 分布式锁默认过期时间10分钟（防止长时间未释放）. */
	private static final int DEFAULT_TIMEOUT = 60*10;
	
	/** * 防止分布式缓存使用了相同的KEY. */
	public static final String LOCK_NAME_PREFIX = "TIMESSHARING_DistributeLock_";
	
	/** The redis cache. */
	private RedisCache redisCache;
	
	/**
	 * Gets the redis cache.
	 *
	 * @return the redis cache
	 */
	public RedisCache getRedisCache() {
		return redisCache;
	}

	/**
	 * Sets the redis cache.
	 *
	 * @param redisCache the redis cache
	 */
	public void setRedisCache(RedisCache redisCache) {
		this.redisCache = redisCache;
	}
	
	/* (non-Javadoc)
	 * @see com.lj.distributelock.IDistributeLock#getLockNoWait(java.lang.String)
	 */
	@Override
	public String getLockNoWait(String lockName) {
		return this.getLockNoWait(lockName, DEFAULT_TIMEOUT);
	}

	/* (non-Javadoc)
	 * @see com.lj.distributelock.IDistributeLock#getLockNoWait(java.lang.String, int)
	 */
	@Override
	public String getLockNoWait(String lockName, int lockExpireSeconds) {
		lockExpireSeconds = lockExpireSeconds > 0 ? lockExpireSeconds : DEFAULT_TIMEOUT;
		String newLockName = generateLockName(lockName);
		String lockValue = generateLockValue(newLockName);
		if( redisCache.setNX(newLockName,lockValue,lockExpireSeconds ))
			return lockValue;
		else
			throw new TsfaServiceException("getLockNoWait-error","lockName:"+lockName+"无法获得");
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
		lockExpireSeconds = lockExpireSeconds > 0 ? lockExpireSeconds : timeOut;
		//String newLockName = generateLockName(lockName);
		//String lockValue = generateLockValue(newLockName);
		if( redisCache.setNX(lockName,lockValue,lockExpireSeconds )) {
			return lockValue;
		}
		if( ! redisCache.setNX(lockName,lockValue,lockExpireSeconds )) {
			return null;
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.lj.distributelock.IDistributeLock#getLockUntilTimeout(java.lang.String, int)
	 */
	@Override
	public String getLockUntilTimeout(String lockName, int millsTimeout) {
		String newLockName = generateLockName(lockName);
		String lockValue = null;
		long beginTime = System.currentTimeMillis();
		while(System.currentTimeMillis() - beginTime<millsTimeout){
			try {
				lockValue = getLockNoWait(newLockName);
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
		throw  new TsfaServiceException("getLockUntilTimeout-error","lockName:"+lockName+"等待了"+millsTimeout+"无法获得");
	}

	/* (non-Javadoc)
	 * @see com.lj.distributelock.IDistributeLock#getLockUntilTimeout(java.lang.String, int, int)
	 */
	@Override
	public String getLockUntilTimeout(String lockName, int millsTimeout, int lockExpireSeconds) {
		String newLockName = generateLockName(lockName);
		String lockValue = null;
		long beginTime = System.currentTimeMillis();
		while(System.currentTimeMillis() - beginTime<millsTimeout){
			try {
				lockValue = getLockNoWait(newLockName, lockExpireSeconds);
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
		throw  new TsfaServiceException("getLockUntilTimeout-error","lockName:"+lockName+"等待了"+millsTimeout+"无法获得");
	}

	/* (non-Javadoc)
	 * @see com.lj.distributelock.IDistributeLock#releaseLock(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean releaseLock(String lockName, String lockValue) {
		AssertUtils.notNullAndEmpty(lockName);
		AssertUtils.notNullAndEmpty(lockValue); 
		String newLockName = generateLockName(lockName);
		if( lockValue.equals(redisCache.get(newLockName))){
			//---和服务器保存的值相等，可以释放
			return redisCache.del(newLockName);
		}
		return false;
	}
	
	/* (non-Javadoc)
	 * @see com.lj.distributelock.IDistributeLock#releaseLock(java.lang.String)
	 */
	@Override
	public boolean releaseLock(String lockName) {
		AssertUtils.notNullAndEmpty(lockName);
		String newLockName = generateLockName(lockName);
		//---和服务器保存的值相等，可以释放
		return redisCache.del(newLockName);
	}

	/**
	 * *
	 * 设置锁的值，只有知道值的才能释放.
	 *
	 * @param lockName the lock name
	 * @return the string
	 */
	protected String generateLockValue(String lockName){
		return String.valueOf(System.currentTimeMillis())+lockName.hashCode();
	}
	
	/**
	 * *
	 * 设置锁名，为了防止和缓存冲突，会加入固定前缀.
	 *
	 * @param lockName the lock name
	 * @return the string
	 */
	protected String generateLockName(String lockName){
		if(lockName.startsWith(LOCK_NAME_PREFIX))
			return lockName;
		else
			return LOCK_NAME_PREFIX+lockName;
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
		AssertUtils.notNullAndEmpty(lockName);
		AssertUtils.notNullAndEmpty(lockValue); 
		String newLockName = generateLockName(lockName);
		if( lockValue.equals(redisCache.get(newLockName))){
			//---和服务器保存的值相等，可以延长
			return redisCache.set(newLockName, lockValue, DEFAULT_TIMEOUT);
		}
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
		AssertUtils.notNullAndEmpty(lockName);
		AssertUtils.notNullAndEmpty(lockValue); 
		String newLockName = generateLockName(lockName);
		return lockValue.equals(redisCache.get(newLockName)) ;
	}

}
