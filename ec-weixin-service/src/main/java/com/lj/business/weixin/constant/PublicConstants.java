package com.lj.business.weixin.constant;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */

/**
 * *
 * 公共常量.
 *
 * @author 彭阳
 */
public class PublicConstants {
	
	/** * 消费额度短信提醒开关关闭：金额. */
	public final static long NOTE_LIMIT_OFF_DEFAULT = 500000L;
	
	/** * 消费额度短信提醒开关打开：金额. */
	public final static long NOTE_LIMIT_ON_DEFAULT = 5000L;
	
	/** * 每日支付限额开关关闭：金额. */
	//public final static long PAY_LIMIT_OFF_DEFAULT = 500000L;
	/***
	 * 每日支付限额开关打开：金额
	 */
	//public final static long PAY_LIMIT_ON_DEFAULT = 100000L;
	/***
	 * 免密支付限额开关关闭：金额
	 */
	public final static long NO_PSW_OFF_DEFAULT = 0L;
	
	/** * 免密支付限额开关打开：金额. */
	public final static long NO_PSW_ON_DEFAULT = 2000L;
	
	
	/** 支持的业务分隔符. */
	public static final String STRING_SPLIT = ",";
	

	/** 资源服务“工号”字段名称. */
	public static final String JOB_NUM_FOXCONN_NAME = "jobNumFoxconn";
	
	/** 资源服务“证件号码”字段名称. */
	public static final String CERTNO = "certNo";
	
	/** 资源服务“繁体会员名称”字段名称. */
	public static final String MEMBER_NAME_TRANT = "memberNameTrant";
	
	/** 资源服务“会员名称”字段名称. */
	public static final String MEMBER_NAME = "memberName";
	
	/** 资源服务组. */
	public static final String MEMFOX = "memfox";
	
	/** 资源服务-查看员工信息接口地址. */
	public static final String FIND_PERSONINFO_ADDR = "findPersonInfoAddr";
	
	/** 资源服务-实名认证接口地址. */
	public static final String AUTHENTICATION_ADDR = "authenticationAddr";
	
	/** 资源服务-盐. */
	public static final String SALT = "salt";
	
	/** 资源服务“secStr”字段名称. */
	public static final String SECSTR = "secStr";
	
	// 企业用户API接入信息缓存前缀
	public static final String MERCHANT_API_KEY_PREFIX = "api-";
	
	/**
	 * 头像访问地址
	 */
	public static final String HEAD_IMG_ADDR = "headImgAddr";	
	/**
	 * 头像存储路径
	 */
	public static final String HEAD_IMG_PATH = "headImgPath";	
	/**
	 * 头像组
	 */
	public static final String HEAD_IMG = "headImg";
	
}
