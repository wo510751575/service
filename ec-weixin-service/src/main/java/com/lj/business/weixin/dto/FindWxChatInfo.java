package com.lj.business.weixin.dto;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.io.Serializable;
import java.util.Date;

/**
 * The Class FindWxChatInfo.
 */
public class FindWxChatInfo implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -328508040178572212L;

	/** The code. */
     private String code;
     /**
      * 商户编号
      */
     private String merchantNo;
   
   /** 导购编号. */
     private String memberNo;
     
     /** 开始时间. */
     private String startTime;
     
     /** 结束时间. */
     private String endTime;
     
     /**
 	 * 店员姓名 .
 	 */
 	private String memberName;
 	
 	/**
 	 * 咨询数量
 	 */
 	private Integer count;
 	
 	
     /** 区域code. */
     private String areaCode;
     
    /**区域名称 */
     private String areaName;

 	/**
 	 * 入职时间 .
 	 */
 	private Date workDate;
 	
 	/** 分店编号. */
 	private String shopNo;
 	
 	/** 分店名称. */
 	private String shopName;
 	
     /**统计维度*/
 	private String dimensionSt;
 	
     
	public String getDimensionSt() {
		return dimensionSt;
	}

	public void setDimensionSt(String dimensionSt) {
		this.dimensionSt = dimensionSt;
	}

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public Date getWorkDate() {
		return workDate;
	}

	public void setWorkDate(Date workDate) {
		this.workDate = workDate;
	}

	public String getShopNo() {
		return shopNo;
	}

	public void setShopNo(String shopNo) {
		this.shopNo = shopNo;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	/**
	 * Gets the member no.
	 *
	 * @return the member no
	 */
	public String getMemberNo() {
		return memberNo;
	}

	/**
	 * Sets the member no.
	 *
	 * @param memberNo the member no
	 */
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	/**
	 * Gets the start time.
	 *
	 * @return the start time
	 */
	public String getStartTime() {
		return startTime;
	}

	/**
	 * Sets the start time.
	 *
	 * @param startTime the start time
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	/**
	 * Gets the end time.
	 *
	 * @return the end time
	 */
	public String getEndTime() {
		return endTime;
	}

	/**
	 * Sets the end time.
	 *
	 * @param endTime the end time
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the code.
	 *
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Gets the serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "FindWxChatInfo [code=" + code + ", merchantNo=" + merchantNo
				+ ", memberNo=" + memberNo + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", memberName=" + memberName
				+ ", count=" + count + ", areaCode=" + areaCode + ", areaName="
				+ areaName + ", workDate=" + workDate + ", shopNo=" + shopNo
				+ ", shopName=" + shopName + ", dimensionSt=" + dimensionSt
				+ "]";
	}

}
