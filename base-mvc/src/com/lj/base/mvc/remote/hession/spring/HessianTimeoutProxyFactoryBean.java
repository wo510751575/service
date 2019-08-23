package com.lj.base.mvc.remote.hession.spring;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市扬恩科技 License, Version 1.0 (the "License");
 * 
 */

import org.springframework.remoting.caucho.HessianProxyFactoryBean;

import com.caucho.hessian.client.HessianProxyFactory;
import com.lj.base.core.util.ReflectUtils;

/**
 * 
 * 
 * 类说明：
 * 
 * 
 * <p>
 * 详细描述：能在Spring注入设置Hessian超时时间的HessianProxyFactoryBean
 * 
 * @Company: 扬恩科技有限公司
 * @author 彭阳
 * 
 *         CreateDate: 2017年7月14日
 */
public class HessianTimeoutProxyFactoryBean extends HessianProxyFactoryBean {

	public void setConnectTimeout(long connectTimeout) {
		try {
			HessianProxyFactory proxyFactory = (HessianProxyFactory) ReflectUtils.getValueByFieldName(this,"proxyFactory");
			proxyFactory.setConnectTimeout(connectTimeout); 
			this.setProxyFactory(proxyFactory);
		} catch (Exception e) {
			throw new RuntimeException("set connectTimout throws Excepton,", e);
		}
	}

	public void setReadTimeout(long readTimeout) {
		try {
			HessianProxyFactory proxyFactory = (HessianProxyFactory) ReflectUtils.getValueByFieldName(this,"proxyFactory");
			proxyFactory.setReadTimeout(readTimeout); 
			this.setProxyFactory(proxyFactory);
		} catch (Exception e) {
			throw new RuntimeException("set readTimeout throws Excepton,", e);
		}
	}

}
