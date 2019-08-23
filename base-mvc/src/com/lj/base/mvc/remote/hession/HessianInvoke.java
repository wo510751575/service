package com.lj.base.mvc.remote.hession;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市扬恩科技 License, Version 1.0 (the "License");
 * 
 */

import java.net.MalformedURLException;

import com.caucho.hessian.client.HessianProxyFactory;

/**
 * 
 * 
 * 类说明：Hession 远程调用类
 *  
 * 
 * <p>
 * 详细描述：用来处理Hessian服务的远程调用，借助此类可以很方便的完成方法的远程调用 针对每一个Hessian服务需要实例化一个对象
 *   
 * @Company: 扬恩科技有限公司
 * @author 邹磊
 *   
 * CreateDate: 2017年7月14日
 */
public final class HessianInvoke {

	/** The remote server. */
	private String remoteServer;

	/** The read timeout. */
	private long readTimeout = -1;

	/** The connect timeout. */
	private long connectTimeout = -1;

	/** The factory. */
	private HessianProxyFactory factory;

	/**
	 * 构造方法.
	 *
	 * @param remoteServer Hessian 服务地址 如：Http://localhost:8080/biz/hessian/
	 */
	public HessianInvoke(String remoteServer) {
		if (remoteServer != null && !remoteServer.endsWith("/")) {
			this.remoteServer = remoteServer + "/";
		} else {
			this.remoteServer = remoteServer;
		}
		factory = new HessianProxyFactory();		
		factory.setConnectTimeout(connectTimeout);
		factory.setReadTimeout(readTimeout);
	}	

	/**
	 * Sets the read timeout.
	 *
	 * @param readTimeout the read timeout
	 */
	public void setReadTimeout(long readTimeout) {		
		this.readTimeout = readTimeout;
		factory.setReadTimeout(readTimeout);		
	}


	/**
	 * Sets the connect timeout.
	 *
	 * @param connectTimeout the connect timeout
	 */
	public void setConnectTimeout(long connectTimeout) {
		this.connectTimeout = connectTimeout;
		factory.setConnectTimeout(connectTimeout);
	}
	
	 /**
 	 * Sets the overload enabled.
 	 *
 	 * @param isOverloadEnabled the overload enabled
 	 */
 	public void setOverloadEnabled(boolean isOverloadEnabled){
		 factory.setOverloadEnabled(isOverloadEnabled);
	  }


	/**
	 * 方法说明： 获取接口的远程实现对象.
	 *
	 * @param interfaceClazz 远程调用接口类，服务名称为接口类名去掉第一个字母并小写化
	 * @return 接口类的远程实现
	 */
	public Object getImpl(Class interfaceClazz) {
		return getImpl(interfaceClazz, null);
	}

	/**
	 * 方法说明： 获取接口的远程实现对象.
	 *
	 * @param interfaceClazz 远程调用接口类，
	 * @param serviceName 远程服务名称，如果为空，则服务名为接口类名去掉第一个字母并小写化
	 * @return the impl
	 */
	public Object getImpl(Class interfaceClazz, String serviceName) {

		String url = null;

		if (serviceName != null) {
			url = getUrl(serviceName);
		} else {
			url = getUrl(interfaceClazz.getName().substring(1).toLowerCase());
		}
		try {
			return factory.create(interfaceClazz, url);
		} catch (MalformedURLException e) {
			throw new RuntimeException(
					"invoke remote service throws exception,", e);
		}
	}

	/**
	 * Gets the url.
	 *
	 * @param serviceName the service name
	 * @return the url
	 */
	private String getUrl(String serviceName) {
		String url = remoteServer + serviceName;
		return url;
	}

}
