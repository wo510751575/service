
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
public enum SystemAliasName {

	cc("配置中心"),
	ms("会员系统"),
	msg("沟通中心"),
	oms("运营管理平台"),
	api("开放平台"),
	kms("秘钥系统"),
	st("统计系统"),
	weixin("微信系统"),
	cm("客户管理系统"),
	cf("客户跟踪系统"),
	sap("SAP系统"),
	cp("优惠券系统"),
	mec("mec系统"),
	pay("支付系统"),
	recruit("企业直通车"),
	iem("积分商城");
	
	
	private String text;
	
	private SystemAliasName(String text) {
		this.text = text;
	}
	
	public String getText(){
		return text;
	}
}