package com.lj.cc.clientintf;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市杨恩科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.cc.service.ISystemInfoService;
import com.lj.base.mvc.remote.hession.spring.HessianTimeoutProxyFactoryBean;
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
public class SystemHessianFactoryBean extends HessianTimeoutProxyFactoryBean {
	
	/** * 系统信息服务. */
	private ISystemInfoService systemInfo;
	
	/** * 系统简称. */
	private String systemAliasName;
	
	/** * hessian服务名称. */
	private String serviceName;
	
	/**
	 * Gets the * 系统信息服务.
	 *
	 * @return the * 系统信息服务
	 */
	public ISystemInfoService getSystemInfo() {
		return systemInfo;
	}
	
	/**
	 * Sets the * 系统信息服务.
	 *
	 * @param systemInfo the new * 系统信息服务
	 */
	public void setSystemInfo(ISystemInfoService systemInfo) {
		this.systemInfo = systemInfo;
	}
	
	/**
	 * Gets the * hessian服务名称.
	 *
	 * @return the * hessian服务名称
	 */
	public String getServiceName() {
		return serviceName;
	}
	
	/**
	 * Sets the * hessian服务名称.
	 *
	 * @param serviceName the new * hessian服务名称
	 */
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
		setHessianServiceUrl();
	}
	

	/**
	 * Gets the * 系统简称.
	 *
	 * @return the * 系统简称
	 */
	public String getSystemAliasName() {
		return systemAliasName;
	}
	
	/**
	 * Sets the * 系统简称.
	 *
	 * @param systemAliasName the new * 系统简称
	 */
	public void setSystemAliasName(String systemAliasName) {
		this.systemAliasName = systemAliasName;
		setHessianServiceUrl();
	}
	
	/**
	 * *
	 * 设置hessian服务地址.
	 */
	private void setHessianServiceUrl(){
		if(systemAliasName!=null && serviceName!=null){
			String hessinUrl = systemInfo.findSystemInfo(systemAliasName).getRmiUrl();
			String serviceUrl = hessinUrl +(hessinUrl.endsWith(HTTP_SPLITTER)?"": HTTP_SPLITTER) + serviceName;
			super.setServiceUrl(serviceUrl );
		}
	}
	
	/** The Constant HTTP_SPLITTER. */
	private static final String HTTP_SPLITTER = "/";
}
