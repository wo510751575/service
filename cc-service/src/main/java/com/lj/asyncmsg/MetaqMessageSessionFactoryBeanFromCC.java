package com.lj.asyncmsg;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市杨恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.Map;

import com.lj.cc.dto.FindSystemGroup;
import com.lj.cc.service.ISystemParamsService;
import com.taobao.metamorphosis.client.extension.spring.MetaqMessageSessionFactoryBean;

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
public class MetaqMessageSessionFactoryBeanFromCC extends MetaqMessageSessionFactoryBean{
	
	
	/** The system params service. */
	private ISystemParamsService systemParamsService;

	/**
	 * Gets the system params service.
	 *
	 * @return the system params service
	 */
	public ISystemParamsService getSystemParamsService() {
		return systemParamsService;
	}

	/**
	 * Sets the system params service.
	 *
	 * @param systemParamsService the system params service
	 */
	public void setSystemParamsService(ISystemParamsService systemParamsService) {
		this.systemParamsService = systemParamsService;
		//-----从CC获取参数设置Redis Service--------
		FindSystemGroup fsg = new FindSystemGroup();
		fsg.setSystemAliasName("cc");
		fsg.setGroupName("asyncmsg");
		//----从CC获取参数组------------
		Map<String,String> fsgr = systemParamsService.findSystemGroup(fsg).getGroupMaps();
		String zkConnect = fsgr.get("zkConnect");
		int zkSessionTimeoutMs = Integer.parseInt(fsgr.get("zkSessionTimeoutMs")) ;
		int zkConnectionTimeoutMs = Integer.parseInt(fsgr.get("zkConnectionTimeoutMs"));
		int zkSyncTimeMs = Integer.parseInt(fsgr.get("zkSyncTimeMs"));
		
		super.setZkConnect(zkConnect);
		super.setZkSessionTimeoutMs(zkSessionTimeoutMs);
		super.setZkConnectionTimeoutMs(zkConnectionTimeoutMs);
		super.setZkSyncTimeMs(zkSyncTimeMs);
		
		
	}

}
