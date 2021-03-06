/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.emus;

/**
 * 
 * 类说明：
 *  
 * 
 * <p>
 * 详细描述：商品FLAG。
 *   
 * @Company: 深圳扬恩科技有限公司
 * @author lhy
 *   
 * CreateDate: 2017年8月26日
 */
public enum ProductFlagType {
	/** 专题. */
	SUBJECT("1", "专题"),

	/** 标签. */
	LABEL("2", "标签");
	
	ProductFlagType(String value, String chName) {
		this.value = value;
		this.chName = chName;
	}

	private String value;// DB 存贮值
	private String chName;// 值对应的中文描述
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	/**
	 * @return the chName
	 */
	public String getChName() {
		return chName;
	}
	/**
	 * @param chName the chName to set
	 */
	public void setChName(String chName) {
		this.chName = chName;
	}
	
}
