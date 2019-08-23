package com.lj.base.mvc.remote.hession.spring;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市扬恩科技 License, Version 1.0 (the "License");
 * 
 */

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.remoting.caucho.HessianExporter;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.util.NestedServletException;

/**
 * 
 * 
 * 类说明：增强 spring 的 org.springframework.remoting.caucho.HessianServiceExporter
 *  
 * 
 * <p>
 * 详细描述：在调用服务前后分别打印调用参数及调用花费的时间总数
 *   
 * @Company: 扬恩科技有限公司
 * @author 彭阳
 *   
 * CreateDate: 2017年7月1日
 */
public class HessianServiceExporter extends HessianExporter implements
		HttpRequestHandler {

	/** The logger. */
	private static Logger logger = LoggerFactory
			.getLogger(HessianServiceExporter.class);

	/* (non-Javadoc)
	 * @see org.springframework.web.HttpRequestHandler#handleRequest(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		if (!"POST".equals(request.getMethod())) {
			throw new HttpRequestMethodNotSupportedException(
					request.getMethod(), new String[] { "POST" },
					"HessianServiceExporter only supports POST requests");
		}

		response.setContentType("application/x-hessian");
		try {

			long  beginTime=0;
			if (logger.isDebugEnabled()) {
				  beginTime=System.currentTimeMillis();
				  Map requestMap=request.getParameterMap();
				  logger.debug("begin invoke,request param is "+requestMap + ",RequestURI:" +  request.getRequestURI() +  ",getRequestURL:" +  request.getRequestURL() );
			}

			invoke(request.getInputStream(), response.getOutputStream());
			
			if (logger.isDebugEnabled()) {
				long endTime=System.currentTimeMillis();
				long duration=endTime-beginTime;
				logger.debug("end invoke, duration time="+duration);
			}
			
		} catch (Throwable ex) {
			throw new NestedServletException(
					"Hessian service invocation failed", ex);
		}
	}

}
