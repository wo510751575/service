package com.lj.business.weixin.dto;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.Date;

import com.lj.base.core.pagination.PageParamEntity;

/**
 * The Class FindWxFriendsInfoPage.
 */
public class FindWxFriendsInfoPage extends PageParamEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 15227681284814627L; 

	/**
     *导购编号
     */
    private String memberNo;
    /**
     * 导购名称
     */
    private String memberName;
    /** 开始时间. */
	private Date startTime;			
	/** 结束时间. */
	private Date endTime;
	/**
	 * 朋友圈ID
	 */
	private String idWx;
	/**
	 * 微信号
	 */
	private String authorid;
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
	 * @return the memberName
	 */
	public String getMemberName() {
		return memberName;
	}
	/**
	 * @param memberName the memberName to set
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	/**
	 * @return the startTime
	 */
	public Date getStartTime() {
		return startTime;
	}
	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	/**
	 * @return the endTime
	 */
	public Date getEndTime() {
		return endTime;
	}
	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
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
	 * @return the authorid
	 */
	public String getAuthorid() {
		return authorid;
	}
	/**
	 * @param authorid the authorid to set
	 */
	public void setAuthorid(String authorid) {
		this.authorid = authorid;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FindWxFriendsInfoPage [memberNo=" + memberNo + ", memberName="
				+ memberName + ", startTime=" + startTime + ", endTime="
				+ endTime + ", idWx=" + idWx + ", authorid=" + authorid + "]";
	}
	
	
}
