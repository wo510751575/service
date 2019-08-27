
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
 * 抢占资源锁接口，申请资源后返回申请到多少资源，并且获得锁标志
 * 【注意，资源锁申请后获得全部资源的不主动释放，除非手动释放】
 * 【注意，资源锁申请后获得部分资源的可以设定超时时间，设定后自动释放】
 * lockName自取，千万不要重复哦亲
 * @Company: 杨恩科技有限公司
 * @author 彭阳
 *   
 * CreateDate: 2017年7月14日
 */
public interface IResourceLootingLock {
	
	/**
	 * *
	 * 获取锁（立即返回，得到锁的值（随机生成）），如果得不到返回0.
	 *
	 * @param lockName 锁名
	 * @param needResource the need resource
	 * @return the lock no wait
	 */
	public ResourceLootingReturnVO getLockNoWait(String lockName,long needResource);
	
	/**
	 * *
	 * 获取锁（未得到则等待，得到锁的值（随机生成）），直到超时抛出异常.
	 *
	 * @param lockName 锁名
	 * @param needResource the need resource
	 * @param millsTimeout 超时，毫秒
	 * @return the lock until timeout
	 */
	public ResourceLootingReturnVO getLockUntilTimeout(String lockName,long needResource,int millsTimeout);
	
	/**
	 * *
	 * 释放锁，只有vo正确才能释放（get方法获得的vo）
	 * vo不能篡改！.
	 *
	 * @param lockName the lock name
	 * @param vo the vo
	 * @return true, if release lock
	 */
	public boolean releaseLock(String lockName,ResourceLootingReturnVO vo);
	
	/**
	 * *
	 * 确认获取的部分资源员工需要（不需要此功能的，不设置超时时间）
	 * 【建议前台的超时时间比本系统的超时时间短，以确保并发情况下不会出问题】
	 * 返回false表示超时释放，可能被别人抢走了.
	 *
	 * @param lockName the lock name
	 * @param vo the vo
	 * @return true, if confirm part resource
	 */
	public boolean confirmPartResource(String lockName,ResourceLootingReturnVO vo);
	
	/**
	 * *
	 * 资源大小手工设置，建议配置在CC
	 * 请调用我初始化抢夺资源的资源大小
	 * 【重启要特别注意哦！】.
	 *
	 * @param lockName the lock name
	 * @param resourceLootingMaxValue the resource looting max value
	 */
	public void setResourceLootingCntMap(String lockName,long resourceLootingMaxValue);
	
	/**
	 * *
	 * 资源大小手工设置，建议配置在CC
	 * 请调用我初始化抢夺资源的资源大小
	 * 【重启要特别注意哦！】.
	 *
	 * @param lockName the lock name
	 * @param resourceLootingMaxValue the resource looting max value
	 * @param resourceLootingTimeout the resource looting timeout
	 */
	public void setResourceLootingCntMap(String lockName,long resourceLootingMaxValue,long resourceLootingTimeout) ;
}
