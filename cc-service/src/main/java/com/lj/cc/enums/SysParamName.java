
package com.lj.cc.enums;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市杨恩科技 License, Version 1.0 (the "License");
 * 
 */

/**
 * 
 * 
 * 类说明：系统键值
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
public enum SysParamName {
	/**
	 * 上传地址
	 */
	UPLOADURL("uploadUrl"),
	/**
	 * 上传路径
	 */
	UPLOADPATH("uploadPath"),
	;
	
	
	private String text;
	
	private SysParamName(String text) {
		this.text = text;
	}
	
	public String getText(){
		return text;
	}
}