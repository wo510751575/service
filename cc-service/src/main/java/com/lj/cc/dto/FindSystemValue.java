package com.lj.cc.dto;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市杨恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.io.Serializable;


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
 * @author 彭阳
 *   
 * CreateDate: 2017年7月1日
 */
public class FindSystemValue implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8404982958416000611L;

	/** The Constant serialVersionUID. */
	
	
	/**
     * 分组信息 .
     */
    private String groupName;

    /**
     * 系统参数名 .
     */
    private String sysParamName;
    
    /**
     * 所属系统 .
     */
    private String systemAliasName;

	
	/**
	 * Gets the 分组信息 .
	 *
	 * @return the 分组信息 
	 */
	public String getGroupName() {
		return groupName;
	}

	
	/**
	 * Sets the 分组信息 .
	 *
	 * @param groupName the new 分组信息 
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	
	/**
	 * Gets the 系统参数名 .
	 *
	 * @return the 系统参数名 
	 */
	public String getSysParamName() {
		return sysParamName;
	}

	
	/**
	 * Sets the 系统参数名 .
	 *
	 * @param sysParamName the new 系统参数名 
	 */
	public void setSysParamName(String sysParamName) {
		this.sysParamName = sysParamName;
	}


	/**
	 * Gets the 所属系统 .
	 *
	 * @return the systemAliasName
	 */
	public String getSystemAliasName() {
		return systemAliasName;
	}


	/**
	 * Sets the 所属系统 .
	 *
	 * @param systemAliasName the systemAliasName to set
	 */
	public void setSystemAliasName(String systemAliasName) {
		this.systemAliasName = systemAliasName;
	}
    
    
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){ 
		  return "\n getGroupName():"+getGroupName()+"\n getSysParamName():"+getSysParamName()+"\n getSystemAliasName():"+getSystemAliasName();
		}

}
