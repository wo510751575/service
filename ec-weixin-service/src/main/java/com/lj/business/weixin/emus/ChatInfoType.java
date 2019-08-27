/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */

package com.lj.business.weixin.emus;

/**
 * 
 * 
 * 类说明：聊天记录类型枚举
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 深圳扬恩科技有限公司
 * @author 段志鹏
 *   
 * CreateDate: 2017年7月20日
 */
public enum ChatInfoType {
	
	/** 文本 */
	TEXT(1,"文本"),
	/** 图片 */
	IMG(3,"图片"),
	/** 语音. */
	VOICE(34,"语音"),
	/** 名片. */
	CARD(42,"名片"),
	/** 视频. */
	VIDEO(43,"视频"),
	/** 图片表情. */
	IMGBROW(47,"图片表情"),
	/** 定位. */
	LOCATION(48,"定位"),
	/** 分享. */
	SHARE(49,"分享"),
	/** 视频聊天. */
	VIDEOCHAT(50,"视频聊天"),
	/** 系统信息. */
	SYSTEM(10000,"系统信息"),
	/** 系统安全提示. */
	SYSTEMSECURITY(318767153,"系统安全提示"),
	;
	
	ChatInfoType(int code,String name){
		this.code = code;
		this.name = name;
	}
	
	private String name;
	private int code;
	
	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
