package com.lj.cc.dto;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市杨恩科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.base.core.pagination.PageParamEntity;

/**
 * 
 * 
 * 类说明：系统参数分页查询参数
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
public class FindSystemParam extends PageParamEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7250063699752788604L;

	 /** 所属系统. */
    private String systemAliasName;
    
    /** 分组信息. */
    private String groupName;
    
    /** 系统参数名. */
    private String sysParamName;
    
    /** 修改标识. */
    private Boolean modifyFlag;

	/**
	 * Gets the 所属系统.
	 *
	 * @return the systemAliasName
	 */
	public String getSystemAliasName() {
		return systemAliasName;
	}

	/**
	 * Sets the 所属系统.
	 *
	 * @param systemAliasName the systemAliasName to set
	 */
	public void setSystemAliasName(String systemAliasName) {
		this.systemAliasName = systemAliasName;
	}

	/**
	 * Gets the 分组信息.
	 *
	 * @return the groupName
	 */
	public String getGroupName() {
		return groupName;
	}

	/**
	 * Sets the 分组信息.
	 *
	 * @param groupName the groupName to set
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	/**
	 * Gets the 系统参数名.
	 *
	 * @return the sysParamName
	 */
	public String getSysParamName() {
		return sysParamName;
	}

	/**
	 * Sets the 系统参数名.
	 *
	 * @param sysParamName the sysParamName to set
	 */
	public void setSysParamName(String sysParamName) {
		this.sysParamName = sysParamName;
	}

	/**
	 * Gets the 修改标识.
	 *
	 * @return the modifyFlag
	 */
	public Boolean getModifyFlag() {
		return modifyFlag;
	}

	/**
	 * Sets the 修改标识.
	 *
	 * @param modifyFlag the modifyFlag to set
	 */
	public void setModifyFlag(Boolean modifyFlag) {
		this.modifyFlag = modifyFlag;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindSystemParam [systemAliasName=");
		builder.append(systemAliasName);
		builder.append(", groupName=");
		builder.append(groupName);
		builder.append(", sysParamName=");
		builder.append(sysParamName);
		builder.append(", modifyFlag=");
		builder.append(modifyFlag);
		builder.append("]");
		return builder.toString();
	}
    
}
