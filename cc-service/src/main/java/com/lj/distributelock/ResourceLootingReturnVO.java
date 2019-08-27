package com.lj.distributelock;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市杨恩科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.base.core.BaseEntity;
import com.lj.base.core.encryption.DES;
import com.lj.base.mvc.base.json.JsonUtils;


/**
 * 
 * 
 * 类说明：
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 杨恩科技有限公司
 * @author  彭阳
 * 抢资源锁返回对象
 * 返回已被抢占多少资源
 * 还剩多少资源
 * 本次抢占资源的释放锁标志（释放用）
 * CreateDate: 2017年7月1日
 */
public class ResourceLootingReturnVO  extends BaseEntity { 
	/**
	 * 
	 */
	private static final long serialVersionUID = -6155118572029841004L;
	
	//资源锁Key
	/** The lock name. */
	private String lockName;
	//申请到的资源
	/** The applied resource. */
	private long appliedResource;
	//申请资源请求
	/** The apply resource. */
	private long applyResource;
	//资源池所剩资源
	/** The left resource. */
	private long leftResource;	
	//资源池大小
	/** The total resource. */
	private long totalResource;
	//申请时间
	/** The applied time. */
	private long appliedTime;
	
	/**
	 * Gets the applied time.
	 *
	 * @return the applied time
	 */
	public long getAppliedTime() {
		return appliedTime;
	}
	
	/**
	 * Sets the applied time.
	 *
	 * @param appliedTime the applied time
	 */
	public void setAppliedTime(long appliedTime) {
		this.appliedTime = appliedTime;
	}
	//返回的用来释放资源的锁
	/** The lock value. */
	private String lockValue;
	
	
	/**
	 * Gets the lock name.
	 *
	 * @return the lock name
	 */
	public String getLockName() {
		return lockName;
	}
	
	/**
	 * Sets the lock name.
	 *
	 * @param lockName the lock name
	 */
	public void setLockName(String lockName) {
		this.lockName = lockName;
	}
	
	/**
	 * Gets the applied resource.
	 *
	 * @return the applied resource
	 */
	public long getAppliedResource() {
		return appliedResource;
	}
	
	/**
	 * Sets the applied resource.
	 *
	 * @param appliedResource the applied resource
	 */
	public void setAppliedResource(long appliedResource) {
		this.appliedResource = appliedResource;
	}
	
	/**
	 * Gets the apply resource.
	 *
	 * @return the apply resource
	 */
	public long getApplyResource() {
		return applyResource;
	}
	
	/**
	 * Sets the apply resource.
	 *
	 * @param applyResource the apply resource
	 */
	public void setApplyResource(long applyResource) {
		this.applyResource = applyResource;
	}
	
	/**
	 * Gets the left resource.
	 *
	 * @return the left resource
	 */
	public long getLeftResource() {
		return leftResource;
	}
	
	/**
	 * Sets the left resource.
	 *
	 * @param leftResource the left resource
	 */
	public void setLeftResource(long leftResource) {
		this.leftResource = leftResource;
	}
	
	/**
	 * Gets the lock value.
	 *
	 * @return the lock value
	 */
	public String getLockValue() {
		return lockValue;
	}
	
	/**
	 * Sets the lock value.
	 *
	 * @param lockValue the lock value
	 */
	public void setLockValue(String lockValue) {
		this.lockValue = lockValue;
	}
	
	/**
	 * Gets the total resource.
	 *
	 * @return the total resource
	 */
	public long getTotalResource() {
		return totalResource;
	}
	
	/**
	 * Sets the total resource.
	 *
	 * @param totalResource the total resource
	 */
	public void setTotalResource(long totalResource) {
		this.totalResource = totalResource;
	}
	
	/**
	 * The Constructor.
	 *
	 * @param lockName the lock name
	 * @param appliedResource the applied resource
	 * @param applyResource the apply resource
	 * @param leftResource the left resource
	 * @param totalResource the total resource
	 * @param lockValue the lock value
	 */
	public ResourceLootingReturnVO(String lockName, long appliedResource,
			long applyResource, long leftResource, long totalResource,
			String lockValue) {
		super();
		this.lockName = lockName;
		this.appliedResource = appliedResource;
		this.applyResource = applyResource;
		this.leftResource = leftResource;
		this.totalResource = totalResource;
		this.lockValue = lockValue;
		this.appliedTime = System.currentTimeMillis();
	}
	
	/**
	 * The Constructor.
	 *
	 * @param lockName the lock name
	 * @param applyResource the apply resource
	 */
	public ResourceLootingReturnVO(String lockName, 	long applyResource) {
		super();
		this.lockName = lockName; 
		this.applyResource = applyResource; 
		this.appliedTime = System.currentTimeMillis();
	}

	
	/* (non-Javadoc)
	 * @see com.lj.tsfa.core.BaseEntity#toString()
	 */
	@Override
	public String toString() {
		return "ResourceLootingReturnVO [lockName=" + lockName
				+ ", appliedResource=" + appliedResource + ", applyResource="
				+ applyResource + ", leftResource=" + leftResource
				+ ", totalResource=" + totalResource + ", appliedTime="
				+ appliedTime + ", lockValue=" + lockValue + "]";
	}
	
	/**
	 * *
	 * 对象转换为token.
	 *
	 * @return the string
	 */
	public String toToken(){
		String data = JsonUtils.jsonFromObject(this);
		return DES.encrptyRevised(data, TOKEN_KEY);
	}
	
	/** The Constant TOKEN_KEY. */
	private static final String TOKEN_KEY = "p2p_timessharing";
	
	/**
	 * *
	 * 将token转换为VO.
	 *
	 * @param token the token
	 * @return the resource looting return vo
	 */
	public static ResourceLootingReturnVO fromToken(String token){
		String data = DES.decrptyRevised(token, TOKEN_KEY);
		return (ResourceLootingReturnVO)JsonUtils.objectFromJson(data, ResourceLootingReturnVO.class);
	}
	
	/**
	 * *
	 * 构造函数.
	 */
	public ResourceLootingReturnVO(){
		super();
	}
}
