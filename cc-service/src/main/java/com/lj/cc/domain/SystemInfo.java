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
public class SystemInfo extends BaseEntity{
    
    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8133776174802586917L;

	/**
     * 系统简称 .
     */
    private String systemAliasName;

    /**
     * 系统英文全称 .
     */
    private String systemEnglishName;

    /**
     * 系统中文全称 .
     */
    private String systemChineseName;

    /**
     * 备注 .
     */
    private String remark;

    /**
     * 远程服务调用地址 .
     */
    private String rmiUrl;

    /**
     * 系统简称 .
     *
     * @return the 系统简称 
     */
    public String getSystemAliasName() {
        return systemAliasName;
    }

    /**
     * 系统简称 .
     *
     * @param systemAliasName the new 系统简称 
     */
    public void setSystemAliasName(String systemAliasName) {
        this.systemAliasName = systemAliasName == null ? null : systemAliasName.trim();
    }

    /**
     * 系统英文全称 .
     *
     * @return the 系统英文全称 
     */
    public String getSystemEnglishName() {
        return systemEnglishName;
    }

    /**
     * 系统英文全称 .
     *
     * @param systemEnglishName the new 系统英文全称 
     */
    public void setSystemEnglishName(String systemEnglishName) {
        this.systemEnglishName = systemEnglishName == null ? null : systemEnglishName.trim();
    }

    /**
     * 系统中文全称 .
     *
     * @return the 系统中文全称 
     */
    public String getSystemChineseName() {
        return systemChineseName;
    }

    /**
     * 系统中文全称 .
     *
     * @param systemChineseName the new 系统中文全称 
     */
    public void setSystemChineseName(String systemChineseName) {
        this.systemChineseName = systemChineseName == null ? null : systemChineseName.trim();
    }

    /**
     * 备注 .
     *
     * @return the 备注 
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注 .
     *
     * @param remark the new 备注 
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 远程服务调用地址 .
     *
     * @return the 远程服务调用地址 
     */
    public String getRmiUrl() {
        return rmiUrl;
    }

    /**
     * 远程服务调用地址 .
     *
     * @param rmiUrl the new 远程服务调用地址 
     */
    public void setRmiUrl(String rmiUrl) {
        this.rmiUrl = rmiUrl == null ? null : rmiUrl.trim();
    }

    /**
     * 输出BEAN数据信息.
     *
     * @return the string
     */
    public String toString() {
        return "systemAliasName（系统简称）:" + getSystemAliasName()+ "\n" + "systemEnglishName（系统英文全称）:" + getSystemEnglishName()+ "\n" + "systemChineseName（系统中文全称）:" + getSystemChineseName()+ "\n" + "remark（备注）:" + getRemark()+ "\n" + "rmiUrl（远程服务调用地址）:" + getRmiUrl()+ "\n";
    }
}