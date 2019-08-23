/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * 类说明：按日统计。
 * <p>
 *   
 * @Company: 深圳扬恩科技有限公司
 * @author lhy
 *   
 * CreateDate: 2017年9月28日
 */
public class SummaryDayDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1072381009703896282L;
	/** 日期 */
	private Date daySt;
	/** 每日的统计数  */
	private BigDecimal count;
	/**
     * 统计维度\r\n            订单状态：0\r\n            商品分类：1\r\n            客户量：2\r\n            销售额：3 .
     */
    private String dimensionSt;

	/**
	 * @return the daySt
	 */
	public Date getDaySt() {
		return daySt;
	}

	/**
	 * @param daySt
	 *            the daySt to set
	 */
	public void setDaySt(Date daySt) {
		this.daySt = daySt;
	}

	/**
	 * @return the count
	 */
	public BigDecimal getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(BigDecimal count) {
		this.count = count;
	}

	/**
	 * @return the dimensionSt
	 */
	public String getDimensionSt() {
		return dimensionSt;
	}

	/**
	 * @param dimensionSt the dimensionSt to set
	 */
	public void setDimensionSt(String dimensionSt) {
		this.dimensionSt = dimensionSt;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SummaryDayDto [daySt=" + daySt + ", count=" + count
				+ ", dimensionSt=" + dimensionSt + "]";
	}
	
	
	
}
