package com.lj.cc.domain;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市杨恩科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.base.core.BaseEntity;

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
public class SystemParamsKey extends BaseEntity{
    
    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5520252663578660662L;

	/**
     * 分组信息 .
     */
    private String groupName;

    /**
     * 系统参数名 .
     */
    private String sysParamName;

    /**
     * 分组信息 .
     *
     * @return the 分组信息 
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * 分组信息 .
     *
     * @param groupName the new 分组信息 
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    /**
     * 系统参数名 .
     *
     * @return the 系统参数名 
     */
    public String getSysParamName() {
        return sysParamName;
    }

    /**
     * 系统参数名 .
     *
     * @param sysParamName the new 系统参数名 
     */
    public void setSysParamName(String sysParamName) {
        this.sysParamName = sysParamName == null ? null : sysParamName.trim();
    }
}