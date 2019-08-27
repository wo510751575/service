
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
 * 类说明：系统别名
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
public enum GroupName {

	API_LOGIN("api登录相关组"),
	/** CC 配置 微信公众号信息。分组名 */
	mec_weixin("微信公众号信息相关组"),
	MESSAGE_PUSH_TIME("商户推送时间类型"),
	
	SYSPARAM("系统配置"),
	
	ZKVERSION("终端中控版本"),
	
	upload("上传配置"),
	
	;
	
	
	private String text;
	
	private GroupName(String text) {
		this.text = text;
	}
	
	public String getText(){
		return text;
	}
}