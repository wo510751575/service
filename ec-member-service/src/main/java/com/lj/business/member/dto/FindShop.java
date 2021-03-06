package com.lj.business.member.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * The Class FindShop.
 */
public class FindShop implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7735336053626341535L; 
	
	/** The code. */
	private String code;
	
	/** 手机. */
	private String mobile;
	
	/** 开始时间. */
	private Date startTime;
	
	/** 结束时间. */
	private Date endTime;
	/**
	 * 分店编号 .
	 */
	private String shopNo;

	/**
	 * 分店名称 .
	 */
	private String shopName;

	/**
	 * 商户编号 .
	 */
	private String memberNoMerchant;

	/** 门店状态 OPENED：已经开业、SUSPEND：暂停营业。INDECORATION：尚在装修. */
	private String status;
    /**
     * 区域code
     */
	private String areaCode;
	/**
	 * 门店编码
	 */
	private String shopNoMerchant;
	


	/**
	 * 省份Code
	 */
	private String provinceCode;
    
	/**
	 * @return the provinceCode
	 */
	public String getProvinceCode() {
		return provinceCode;
	}

	/**
	 * @param provinceCode the provinceCode to set
	 */
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getShopNoMerchant() {
		return shopNoMerchant;
	}

	public void setShopNoMerchant(String shopNoMerchant) {
		this.shopNoMerchant = shopNoMerchant;
	}
	/**
	 * Gets the 分店名称 .
	 *
	 * @return the shopName
	 */
	public String getShopName() {
		return shopName;
	}

	/**
	 * Sets the 分店名称 .
	 *
	 * @param shopName the shopName to set
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	/**
	 * Gets the 手机.
	 *
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * Sets the 手机.
	 *
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * Gets the 商户编号 .
	 *
	 * @return the memberNoMerchant
	 */
	public String getMemberNoMerchant() {
		return memberNoMerchant;
	}

	/**
	 * Sets the 商户编号 .
	 *
	 * @param memberNoMerchant the memberNoMerchant to set
	 */
	public void setMemberNoMerchant(String memberNoMerchant) {
		this.memberNoMerchant = memberNoMerchant;
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
	 * Gets the 开始时间.
	 *
	 * @return the startTime
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * Sets the 开始时间.
	 *
	 * @param startTime the startTime to set
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * Gets the 结束时间.
	 *
	 * @return the endTime
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * Sets the 结束时间.
	 *
	 * @param endTime the endTime to set
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	/**
	 * Gets the 分店编号 .
	 *
	 * @return the shopNo
	 */
	public String getShopNo() {
		return shopNo;
	}

	/**
	 * Sets the 分店编号 .
	 *
	 * @param shopNo the shopNo to set
	 */
	public void setShopNo(String shopNo) {
		this.shopNo = shopNo;
	}

	/**
	 * Gets the 门店状态 OPENED：已经开业、SUSPEND：暂停营业。INDECORATION：尚在装修.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the 门店状态 OPENED：已经开业、SUSPEND：暂停营业。INDECORATION：尚在装修.
	 *
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "FindShop [code=" + code + ", mobile=" + mobile + ", startTime="
				+ startTime + ", endTime=" + endTime + ", shopNo=" + shopNo
				+ ", shopName=" + shopName + ", memberNoMerchant="
				+ memberNoMerchant + ", status=" + status + ", areaCode="
				+ areaCode + "]";
	}
	
}
