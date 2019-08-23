/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * 类说明：分类占比数。
 * 
 * <p>
 * 
 * @Company: 深圳扬恩科技有限公司
 * @author lhy
 * 
 *         CreateDate: 2017年9月28日
 */
public class SummaryRadioDto implements Serializable {

	private static final long serialVersionUID = -3187603193481863575L;
	/**占比分类code*/
	private String code;
	/**占比分类名*/
	private String name;
	/**总量*/
	private BigDecimal count;
	/**占比*/
	private BigDecimal radio;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the count
	 */
	public BigDecimal getCount() {
		return count;
	}

	/**
	 * @param count
	 *            the count to set
	 */
	public void setCount(BigDecimal count) {
		this.count = count;
	}

	/**
	 * @return the radio
	 */
	public BigDecimal getRadio() {
		return radio;
	}

	/**
	 * @param radio
	 *            the radio to set
	 */
	public void setRadio(BigDecimal radio) {
		this.radio = radio;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SummaryRadioDto [code=" + code + ", name=" + name + ", count="
				+ count + ", radio=" + radio + "]";
	}

}
