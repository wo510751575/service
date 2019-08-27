package com.lj.cc.clientintf;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市杨恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.lj.cc.domain.SystemParams;
import com.lj.cc.service.ISystemParamsService;
import com.lj.base.cache.ICache;
import com.lj.base.cache.LocalCache;
import com.lj.base.core.util.StringUtils;

/**
 * 
 * 
 * 类说明：将cc配置的系统参数缓存到本地
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 杨恩科技有限公司
 * @author 彭阳
 *   
 * CreateDate: 2017年7月14日
 */
public class LocalCacheSystemParamsFromCC implements ICache {
	
	/**
	 * 方法说明：获取系统参数<br>
	 * 注：如果没有设置默认参数查询系统
	 * 1、systemAliasName设置为ALL，则defaultSystemAliasName=ALL，则使用该方法将查询不到对应参数值
	 * 2、systemAliasName指定多个系统，则defaultSystemAliasName=systemAliasName指定的第一个系列别名.
	 *
	 * @param groupName the group name
	 * @param key the key
	 * @return the system param
	 * @author 彭阳
	 * CreateDate: 2017-7-1
	 */
	public String getSystemParam(String groupName, String key){
		return this.getSystemParam(null, groupName, key);
	}
	
	/**
	 * 刷新缓存 用于需要及时响应的场景
	 */
	public void refresh(){
		LocalCache.refresh(LOCAL_CACHE_SYSTEM_PARAMS);
	}
	
	
	/**
	 * 方法说明：获取系统参数.
	 *
	 * @param systemAliasName the system alias name
	 * @param groupName the group name
	 * @param key the key
	 * @return the system param
	 * @author 彭阳
	 * CreateDate: 2017-7-1
	 */
	public String getSystemParam(String systemAliasName, String groupName, String key){
		Map<String,String> map = LocalCache.getCache(LOCAL_CACHE_SYSTEM_PARAMS);
		systemAliasName = StringUtils.isEmpty(systemAliasName) ? this.getDefaultSystemAliasName() : systemAliasName;
		return map.get(systemAliasName + KEY_SPLITTER + groupName + KEY_SPLITTER + key);
	}
	
	/**
	 * 方法说明：根据groupname获取所有参数<br>
	 * 注：如果没有设置默认参数查询系统
	 * 1、systemAliasName设置为ALL，则defaultSystemAliasName=ALL，则使用该方法将查询不到对应参数
	 * 2、systemAliasName指定多个系统，则defaultSystemAliasName=systemAliasName指定的第一个系列别名.
	 *
	 * @param groupName the group name
	 * @return the system param group
	 * @author 彭阳
	 * CreateDate: 2017-7-1
	 */
	public Map<String,String> getSystemParamGroup(String groupName){
		return this.getSystemParamGroup(null, groupName);
	}
	
	/**
	 * 方法说明：根据groupname获取所有参数.
	 *
	 * @param systemAliasName the system alias name
	 * @param groupName the group name
	 * @return the system param group
	 * @author 彭阳
	 * CreateDate: 2017-7-1
	 */
	public Map<String,String> getSystemParamGroup(String systemAliasName, String groupName){
		Map<String,String> map = LocalCache.getCache(LOCAL_CACHE_SYSTEM_PARAMS);
		Map<String,String> groupmap =  new HashMap<String,String>();
		
		//-------遍历获取所有groupName-------
		systemAliasName = StringUtils.isEmpty(systemAliasName) ? this.getDefaultSystemAliasName() : systemAliasName;
		String groupPrefix = systemAliasName + KEY_SPLITTER + groupName + KEY_SPLITTER;
		for(String key : map.keySet()){
			if(key.startsWith(groupPrefix)){
				//group分组的列表放入groupmap
				groupmap.put(key.substring(groupPrefix.length()), map.get(key));
			}
		}
		return groupmap;
	}

	/* (non-Javadoc)
	 * @see com.lj.tsfa.cache.ICache#getNewestData()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Map<String,String> getNewestData() { 
		Map<String,String> map = new HashMap<String,String>();
		// 加载所有系统参数
		if(ALL_SYSTEM_PARAMS.equalsIgnoreCase(systemAliasName)) {
			List<SystemParams> systemParams = systemParamsService.findSystemParams(null);
			if(systemParams != null){
				for(SystemParams sp : systemParams){
					 map.put(sp.getSystemAliasName() + KEY_SPLITTER + sp.getGroupName() + KEY_SPLITTER + sp.getSysParamName(), sp.getSysParamValue());
				}
			}
		} else {  // 加载多个系统参数
			for(String aliasName : this.getSystemAliasNames()) {
				List<SystemParams> systemParams = systemParamsService.findSystemParams(aliasName);
				if(systemParams != null){
					for(SystemParams sp : systemParams){
						map.put(sp.getSystemAliasName() + KEY_SPLITTER + sp.getGroupName() + KEY_SPLITTER + sp.getSysParamName(), sp.getSysParamValue());
					}
				}
			}
		}
		
		return map;
	}
	
	/**
	 * Push cache.
	 */
	@PostConstruct
	public void pushCache(){
		LocalCache.pushCache(LOCAL_CACHE_SYSTEM_PARAMS, cacheMilliseconds, this);
	}
	
	/** * 从CC获取系统参数服务. */
	private ISystemParamsService systemParamsService;
	
	/** * 本地缓存时间. */
	private int cacheMilliseconds;
	
	/** * 系统别名<br> 1、加载多个系统的参数以英文逗号,隔开； 2、如果加载所有参数，则使用ALL，不区分大小写； 3、默认加载所有； 4、为空时加载所有. */
	private String systemAliasName = ALL_SYSTEM_PARAMS;
	
	/** 默认查询参数系统别名. */
	private String defaultSystemAliasName;
	
	/**
	 * Gets the * 从CC获取系统参数服务.
	 *
	 * @return the * 从CC获取系统参数服务
	 */
	public ISystemParamsService getSystemParamsService() {
		return systemParamsService;
	}

	/**
	 * Sets the * 从CC获取系统参数服务.
	 *
	 * @param systemParamsService the new * 从CC获取系统参数服务
	 */
	public void setSystemParamsService(ISystemParamsService systemParamsService) {
		this.systemParamsService = systemParamsService;
	}

	/**
	 * Gets the * 本地缓存时间.
	 *
	 * @return the * 本地缓存时间
	 */
	public int getCacheMilliseconds() {
		return cacheMilliseconds;
	}

	/**
	 * Sets the * 本地缓存时间.
	 *
	 * @param cacheMilliseconds the new * 本地缓存时间
	 */
	public void setCacheMilliseconds(int cacheMilliseconds) {
		this.cacheMilliseconds = cacheMilliseconds;
	}

	/**
	 * Gets the * 系统别名<br> 1、加载多个系统的参数以英文逗号,隔开； 2、如果加载所有参数，则使用ALL，不区分大小写； 3、默认加载所有； 4、为空时加载所有.
	 *
	 * @return the * 系统别名<br> 1、加载多个系统的参数以英文逗号,隔开； 2、如果加载所有参数，则使用ALL，不区分大小写； 3、默认加载所有； 4、为空时加载所有
	 */
	public String getSystemAliasName() {
		return systemAliasName;
	}
	
	/**
	 * 方法说明：得到所有待缓存的系统别名列表.
	 *
	 * @return the system alias names
	 * @author 彭阳
	 * CreateDate: 2017-7-1
	 */
	public String [] getSystemAliasNames() {
		return systemAliasName.split(",");
	}
	
	/**
	 * 方法说明：设置所有待缓存的系统别名<br>
	 * 1、加载多个系统的参数以英文逗号,隔开；
	 * 2、如果加载所有参数，则使用ALL，不区分大小写；
	 * 3、默认加载所有；
	 * 4、为空时加载所有.
	 *
	 * @param systemAliasName the new * 系统别名<br> 1、加载多个系统的参数以英文逗号,隔开； 2、如果加载所有参数，则使用ALL，不区分大小写； 3、默认加载所有； 4、为空时加载所有
	 * @author 彭阳
	 * CreateDate: 2017-7-1
	 */
	public void setSystemAliasName(String systemAliasName) {
		this.systemAliasName = StringUtils.isNotEmpty(systemAliasName) ? systemAliasName : ALL_SYSTEM_PARAMS;
	}

	/**
	 * 方法说明：得到默认查询参数系统别名.
	 *
	 * @return the 默认查询参数系统别名
	 * @author 彭阳
	 * CreateDate: 2017-7-1
	 */
	public String getDefaultSystemAliasName() {
		return StringUtils.isNotEmpty(defaultSystemAliasName) ? defaultSystemAliasName : getSystemAliasNames()[0];
	}
	
	/**
	 * 方法说明：设置默认查询参数系统别名<br>
	 * 注：如果没有设置默认参数查询系统
	 * 1、systemAliasName设置为ALL，则defaultSystemAliasName=ALL
	 * 2、systemAliasName指定多个系统，则defaultSystemAliasName=systemAliasName指定的第一个系统别名.
	 *
	 * @param defaultSystemAliasName the new 默认查询参数系统别名
	 * @author 彭阳
	 * CreateDate: 2017-7-1
	 */
	public void setDefaultSystemAliasName(String defaultSystemAliasName) {
		this.defaultSystemAliasName = defaultSystemAliasName;
	}
	/**
	 * 缓存key
	 */
	private static final String LOCAL_CACHE_SYSTEM_PARAMS = "localCacheSystemAlias";
	/**
	 * 所有系统参数标识
	 */
	private static final String ALL_SYSTEM_PARAMS = "ALL";
	/**
	 * key分隔符
	 */
	private static final String KEY_SPLITTER = "#";	
	
}
