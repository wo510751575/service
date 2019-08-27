package com.lj.distributecache;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市杨恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.lj.cc.dto.FindSystemGroup;
import com.lj.cc.service.ISystemParamsService;

/**
 * 
 * 
 * 类说明：从CC读取参数
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
public class RedisCacheConfigFromCC extends RedisCache{
	
	/** The system param service. */
	private ISystemParamsService systemParamService;

	/**
	 * Gets the system param service.
	 *
	 * @return the system param service
	 */
	public ISystemParamsService getSystemParamService() {
		return systemParamService;
	}

	/**
	 * Sets the system param service.
	 *
	 * @param systemParamService the system param service
	 */
	public void setSystemParamService(ISystemParamsService systemParamService) {
		this.systemParamService = systemParamService;
		//-----从CC获取参数设置Redis Service--------
		FindSystemGroup fsg = new FindSystemGroup();
		fsg.setSystemAliasName("cc");
		fsg.setGroupName("redis");
		//----从CC获取参数组------------
		Map<String,String> fsgr = systemParamService.findSystemGroup(fsg).getGroupMaps();
		String ip = fsgr.get("ip");
		String port = fsgr.get("port");
		String timeout = fsgr.get("timeout");
		String password = fsgr.get("password");
		super.setRedisServer(ip);
		super.setPassword(password);
		super.setRedisPort(Integer.valueOf(port));
		if(StringUtils.isNotEmpty(timeout)){//有timeout参数
			super.setTimeout(Integer.valueOf(timeout));
		}
	}

}
