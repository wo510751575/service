package com.lj.cc.service;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市杨恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.List;

import com.lj.cc.domain.SystemParams;
import com.lj.cc.domain.SystemParamsKey;
import com.lj.cc.dto.FindSystemGroup;
import com.lj.cc.dto.FindSystemGroupRetrun;
import com.lj.cc.dto.FindSystemParam;
import com.lj.cc.dto.FindSystemValue;
import com.lj.cc.dto.FindSystemValueRetrun;
import com.lj.base.core.pagination.IPage;
import com.lj.base.exception.TsfaServiceException;


/**
 * 
 * 
 * 类说明：账户信息查询
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
public interface ISystemParamsService {
	
	
	/**
	 * 获取系统参数组信息（缓存）
	 * 方法说明：获取参数组.
	 *
	 * @param findSystemGroup the find system group
	 * @return the find system group retrun
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳
	 * CreateDate: 2017年7月1日
	 */
	public FindSystemGroupRetrun findSystemGroup(FindSystemGroup findSystemGroup) throws TsfaServiceException;
	
	/**
	 * 获取系统参数值（缓存）
	 * 方法说明：获取具体参数对应的值.
	 *
	 * @param findSystemValue the find system value
	 * @return the find system value retrun
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳
	 * CreateDate: 2017年7月1日
	 */
	public FindSystemValueRetrun findSystemValue(FindSystemValue findSystemValue) throws TsfaServiceException;
	
	/**
	 * *
	 * 获取系统所有参数，无缓存.
	 *
	 * @param systemAliasName the system alias name
	 * @return the list< system params>
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳
	 * CreateDate: 2017年7月1日
	 */
	public List<SystemParams> findSystemParams(String systemAliasName);
	
	/**
	 * 方法说明：系统参数分页查询.
	 *
	 * @param param the param
	 * @return the i page< system params>
	 * @author 彭阳
	 * 
	 * CreateDate: 2017年7月1日
	 */
	public IPage<SystemParams> findSystemParamsPage(FindSystemParam param);
	
	/**
	 * 方法说明：修改系统参数.
	 *
	 * @param systemParams the system params
	 * @author 彭阳
	 * 
	 * CreateDate: 2017年7月1日
	 */
	public void updateSystemParam(SystemParams systemParams);
	
    /**
     * 方法说明：查询修改页面数据
     *
     * @param key the key
     * @return the SystemParams
     */
    public SystemParams selectByPrimaryKey(SystemParamsKey key);
	
	
}
