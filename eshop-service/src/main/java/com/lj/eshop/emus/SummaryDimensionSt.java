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
 * 详细描述：
 *   
 * @Company: 深圳扬恩科技有限公司
 * @author lhy
 *   
 * CreateDate: 2017年9月28日
 */
public enum SummaryDimensionSt {
	//统计维度\r\n            订单状态：0\r\n            商品分类：1\r\n            客户量：2\r\n            销售额：3
	/**  订单状态：0. */
	ORDER("0", "订单状态"),
	/** 商品分类：1 */
	PRODUCT("1", "商品分类"),
	/** 客户量：2*/
	CUSTOMER("2", "客户量"),
	/**  销售额：3*/
	SALE_CNT("3", "销售额"),
	;
	
	SummaryDimensionSt(String value, String chName) {
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
