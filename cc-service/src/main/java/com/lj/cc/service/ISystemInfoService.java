package com.lj.cc.service;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市杨恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.List;

import com.lj.cc.domain.SystemInfo;
import com.lj.base.exception.TsfaServiceException;


/**
 * 
 * 
 * 类说明：系统信息获取
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
public interface ISystemInfoService {
	
	
	/**
	 * 根据系统简称获取系统信息.
	 *
	 * @param systemAliasName the system alias name
	 * @return the system info
	 * @throws TsfaServiceException the tsfa service exception
	 */
	public SystemInfo findSystemInfo(String systemAliasName) throws TsfaServiceException;
	
	/**
	 * 方法说明：查询所有系统信息.
	 *
	 * @return the list< system info>
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳
	 * 
	 * CreateDate: 2017-7-1
	 */
	public List<SystemInfo> findAllSystemInfo() throws TsfaServiceException;
	
	}
