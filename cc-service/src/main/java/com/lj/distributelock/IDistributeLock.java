
package com.lj.distributelock;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市杨恩科技 License, Version 1.0 (the "License");
 * 
 */


/**
 * 
 * 
 * 类说明：
 *  
 * 
 * <p>
 * 详细描述：
 * 分布式锁接口（同步互斥机制，只有1个能拿到，在它主动释放之前，其他系统无法拿到）
 * 【注意，分布式锁在10分钟后自动失效，可以被其他申请者抢到】
 * 【2017-06-22：获得锁的同学可以延长锁寿命，用途：用来做类似调度任务，本系统
 * 服务可用，】
 *  
 * @Company: 杨恩科技有限公司
 * @author 彭阳
 *   
 * CreateDate: 2017年7月1日
 */
public interface IDistributeLock {
	
	/**
	 * *
	 * 获取锁（立即返回，得到锁的值（随机生成）），如果得不到抛出异常.
	 *
	 * @param lockName 锁名
	 * @return the lock no wait
	 */
	public String getLockNoWait(String lockName);
	
	/**
	 * 
	 *
	 * 方法说明：获取锁（立即返回，得到锁的值（随机生成）），如果得不到抛出异常.
	 *
	 * @param lockName
	 * @param lockExpireSeconds	锁超时时间，秒
	 * @return
	 *
	 * @author 曾垂瑜 CreateDate: 2018年2月2日
	 *
	 */
	public String getLockNoWait(String lockName, int lockExpireSeconds);
	
	/**
	 * 获取锁，需手动传入锁值和timeout 秒数
	 * @param lockName
	 * @param lockValue
	 * @param lockExpireSeconds
	 * @param timeOut
	 * @return
	 */
	public String getLockNoWait(String lockName,String lockValue, int lockExpireSeconds , Integer timeOut);
	
	/**
	 * *
	 * 获取锁（未得到则等待，得到锁的值（随机生成）），直到超时抛出异常.
	 *
	 * @param lockName 锁名
	 * @param millsTimeout 等待超时时间，毫秒
	 * @return the lock until timeout
	 */
	public String getLockUntilTimeout(String lockName,int millsTimeout);
	
	/**
	 * 
	 *
	 * 方法说明：（未得到则等待，得到锁的值（随机生成）），直到超时抛出异常.
	 *
	 * @param lockName 锁名
	 * @param millsTimeout 等待超时时间，毫秒
	 * @param lockExpireSeconds	锁超时时间，秒
	 * @return
	 *
	 * @author 曾垂瑜 CreateDate: 2018年2月2日
	 *
	 */
	public String getLockUntilTimeout(String lockName,int millsTimeout, int lockExpireSeconds);
	
	/**
	 * *
	 * 释放锁，只有lockValue正确才能释放（get方法获得的值）.
	 *
	 * @param lockName the lock name
	 * @param lockValue the lock value
	 * @return true, if release lock
	 */
	public boolean releaseLock(String lockName,String lockValue);
	
	/**
	 * 
	 *
	 * 方法说明：释放锁
	 *
	 * @param lockName
	 * @return
	 *
	 * @author 曾垂瑜 CreateDate: 2018年2月2日
	 *
	 */
	public boolean releaseLock(String lockName);
	
	/**
	 * *
	 * 延长锁寿命，只有lockValue正确延长（get方法获得的值）.
	 *
	 * @param lockName the lock name
	 * @param lockValue the lock value
	 * @return true, if expand lock time
	 */
	public boolean expandLockTime(String lockName,String lockValue);
	
	/**
	 * *
	 * 判断锁是否还有效.
	 *
	 * @param lockName the lock name
	 * @param lockValue the lock value
	 * @return true, if checks if is lock available
	 */
	public boolean isLockAvailable(String lockName,String lockValue);
}
