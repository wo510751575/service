package com.lj.base.mvc.remote.hession.protocol;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市扬恩科技 License, Version 1.0 (the "License");
 * 
 */

import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;
import java.util.HashMap;
import java.util.Map;

import com.lj.base.mvc.remote.hession.protocol.tcp.Handler;

/**
 * 
 * 
 * 类说明：
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 扬恩科技有限公司
 * @author 彭阳
 *   
 * CreateDate: 2017年7月1日
 */
public class HessianURLStreamHandlerFactory implements URLStreamHandlerFactory {
	
	/** The handlers. */
	protected static Map<String,URLStreamHandler> handlers = new HashMap<String,URLStreamHandler>();
	
	/** The tcp handler. */
	private URLStreamHandler tcpHandler = new Handler();
	

	/* (non-Javadoc)
	 * @see java.net.URLStreamHandlerFactory#createURLStreamHandler(java.lang.String)
	 */
	public URLStreamHandler createURLStreamHandler(String protocol) {	
		
		if("hessiantcp".equals(protocol)){
			return tcpHandler;
		}		
//		URLStreamHandler handler = handlers.get(protocol);
//		if (handler != null) {
//			return handler;
//		}
		return null;
	}
}
