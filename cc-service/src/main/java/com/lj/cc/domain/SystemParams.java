package com.lj.cc.domain;

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
 *   
 * @Company: 杨恩科技有限公司
 * @author 彭阳
 *   
 * CreateDate: 2017年7月1日
 */
public class SystemParams extends SystemParamsKey {
    
    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3193689788107050433L;

	/**
     * 系统参数值 .
     */
    private String sysParamValue;

    /**
     * 参数信息备注 .
     */
    private String remark;

    /**
     * 所属系统 .
     */
    private String systemAliasName;

    /**
     * 是否能修改，0代表不能修改，1代表能修改 .
     */
    private String onlyAdminModify;

    /**
     * 系统参数值 .
     *
     * @return the 系统参数值 
     */
    public String getSysParamValue() {
        return sysParamValue;
    }

    /**
     * 系统参数值 .
     *
     * @param sysParamValue the new 系统参数值 
     */
    public void setSysParamValue(String sysParamValue) {
        this.sysParamValue = sysParamValue == null ? null : sysParamValue.trim();
    }

    /**
     * 参数信息备注 .
     *
     * @return the 参数信息备注 
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 参数信息备注 .
     *
     * @param remark the new 参数信息备注 
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 所属系统 .
     *
     * @return the 所属系统 
     */
    public String getSystemAliasName() {
        return systemAliasName;
    }

    /**
     * 所属系统 .
     *
     * @param systemAliasName the new 所属系统 
     */
    public void setSystemAliasName(String systemAliasName) {
        this.systemAliasName = systemAliasName == null ? null : systemAliasName.trim();
    }

    /**
     * 是否只有运维能修改，0代表业务也能修改，1代表只有运维能修改 .
     *
     * @return the 是否能修改，0代表不能修改，1代表能修改 
     */
    public String getOnlyAdminModify() {
        return onlyAdminModify;
    }

    /**
     * 是否只有运维能修改，0代表业务也能修改，1代表只有运维能修改 .
     *
     * @param onlyAdminModify the new 是否能修改，0代表不能修改，1代表能修改 
     */
    public void setOnlyAdminModify(String onlyAdminModify) {
        this.onlyAdminModify = onlyAdminModify == null ? null : onlyAdminModify.trim();
    }

	/* (non-Javadoc)
	 * @see com.lj.tsfa.core.BaseEntity#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SystemParams [sysParamValue=").append(sysParamValue)
				.append(", remark=").append(remark)
				.append(", systemAliasName=").append(systemAliasName)
				.append(", onlyAdminModify=").append(onlyAdminModify)
				.append(", getGroupName()=").append(getGroupName())
				.append(", getSysParamName()=").append(getSysParamName())
				.append("]");
		return builder.toString();
	}


}