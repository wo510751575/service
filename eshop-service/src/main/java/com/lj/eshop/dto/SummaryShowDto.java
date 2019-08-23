/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 
 * 类说明：统计数据。
 * 
 * <p>
 * 详细描述：
 * 
 * @Company: 深圳扬恩科技有限公司
 * @author lhy
 * 
 *         CreateDate: 2017年9月28日
 */
public class SummaryShowDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5391930719955668707L;
	private BigDecimal sumCnt;//总量 
	/**按日统计*/ 
	private List<SummaryDayDto> daySum;
	/**分类占比*/
	private List<SummaryRadioDto> radios;
	/**
	 * @return the daySum
	 */
	public List<SummaryDayDto> getDaySum() {
		return daySum;
	}
	/**
	 * @param daySum the daySum to set
	 */
	public void setDaySum(List<SummaryDayDto> daySum) {
		this.daySum = daySum;
	}
	/**
	 * @return the radios
	 */
	public List<SummaryRadioDto> getRadios() {
		return radios;
	}
	/**
	 * @param radios the radios to set
	 */
	public void setRadios(List<SummaryRadioDto> radios) {
		this.radios = radios;
	}
	/**
	 * @return the sumCnt
	 */
	public BigDecimal getSumCnt() {
		return sumCnt;
	}
	/**
	 * @param sumCnt the sumCnt to set
	 */
	public void setSumCnt(BigDecimal sumCnt) {
		this.sumCnt = sumCnt;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SummaryShowDto [sumCnt=" + sumCnt + ", daySum=" + daySum
				+ ", radios=" + radios + "]";
	}
	
	
}
