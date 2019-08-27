
package com.lj.cc.common;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市杨恩科技 License, Version 1.0 (the "License");
 * 
 */

/**
 * 
 * 
 * 类说明：账户错误代码定义类
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
public class ErrorCode {

	/** 查询失败. */
	public static final String CC_QUERY_ERROR = "cc_query_error";
	
	/** 更新失败. */
	public static final String CC_UPDATE_ERROR = "cc_update_error";
	
	/** holiday查询失败. */
	public static final String HOLIDAY_QUERY_ERROR = "holiday_query_error";
	
	/** 当日数据不存在. */
	public static final String HOLIDAY_NOT_EXIST_ERROR = "holiday_not_exist_error";
	
	/** holiday初始化失败. */
	public static final String HOLIDAY_INIT_ERROR = "holiday_init_error";
}
