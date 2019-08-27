package com.lj.business.weixin.dto;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.Date;

import com.lj.base.core.pagination.PageParamEntity; 

public class FindWxCommentInfoPage extends PageParamEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5323256553452541839L; 
	
	

    /**
     * 导购编号  .
     */
    private String memberNo;

    /**
     * 导购姓名 .
     */
    private String memberName;


    /**
     * 创建时间START .
     */
    private Date createDateStart;
    
    /**
     * 创建时间END .
     */
    private Date createDateEnd;
    
    /**
     * 朋友圈ID
     */
    private String idWx;

	/**
	 * @return the memberNo
	 */
	public String getMemberNo() {
		return memberNo;
	}

	/**
	 * @param memberNo the memberNo to set
	 */
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	/**
	 * @return the idWx
	 */
	public String getIdWx() {
		return idWx;
	}

	/**
	 * @param idWx the idWx to set
	 */
	public void setIdWx(String idWx) {
		this.idWx = idWx;
	}

	/**
	 * Gets the 导购姓名 .
	 *
	 * @return the 导购姓名 
	 */
	public String getMemberName() {
		return memberName;
	}

	/**
	 * Sets the 导购姓名 .
	 *
	 * @param memberName the new 导购姓名 
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	/**
	 * Gets the 创建时间START .
	 *
	 * @return the 创建时间START 
	 */
	public Date getCreateDateStart() {
		return createDateStart;
	}

	/**
	 * Sets the 创建时间START .
	 *
	 * @param createDateStart the new 创建时间START 
	 */
	public void setCreateDateStart(Date createDateStart) {
		this.createDateStart = createDateStart;
	}

	/**
	 * Gets the 创建时间END .
	 *
	 * @return the 创建时间END 
	 */
	public Date getCreateDateEnd() {
		return createDateEnd;
	}

	/**
	 * Sets the 创建时间END .
	 *
	 * @param createDateEnd the new 创建时间END 
	 */
	public void setCreateDateEnd(Date createDateEnd) {
		this.createDateEnd = createDateEnd;
	}


}
