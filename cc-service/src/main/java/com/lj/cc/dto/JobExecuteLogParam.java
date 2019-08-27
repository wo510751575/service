package com.lj.cc.dto;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市杨恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.Date;

import com.lj.base.core.pagination.PageParamEntity;

/**
 * 
 * 
 * 类说明：任务日志查询参数
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 杨恩科技有限公司
 * @author 彭阳
 *   
 * CreateDate: 2017年7月1日
 */
public class JobExecuteLogParam extends PageParamEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2339914338119314304L;

	/** 任务英文名称. */
	private String jobEnglishName;
	
	/** 执行状态. */
	private String executeStatus;
	
	/** 执行时间-从. */
	private Date beginTime;

	/** 执行时间-到. */
	private Date endTime;

	/**
	 * Gets the 任务英文名称.
	 *
	 * @return the jobEnglishName
	 */
	public String getJobEnglishName() {
		return jobEnglishName;
	}

	/**
	 * Sets the 任务英文名称.
	 *
	 * @param jobEnglishName the jobEnglishName to set
	 */
	public void setJobEnglishName(String jobEnglishName) {
		this.jobEnglishName = jobEnglishName;
	}

	/**
	 * Gets the 执行状态.
	 *
	 * @return the executeStatus
	 */
	public String getExecuteStatus() {
		return executeStatus;
	}

	/**
	 * Sets the 执行状态.
	 *
	 * @param executeStatus the executeStatus to set
	 */
	public void setExecuteStatus(String executeStatus) {
		this.executeStatus = executeStatus;
	}

	/**
	 * Gets the 执行时间-从.
	 *
	 * @return the beginTime
	 */
	public Date getBeginTime() {
		return beginTime;
	}

	/**
	 * Sets the 执行时间-从.
	 *
	 * @param beginTime the beginTime to set
	 */
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	/**
	 * Gets the 执行时间-到.
	 *
	 * @return the endTime
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * Sets the 执行时间-到.
	 *
	 * @param endTime the endTime to set
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("JobExecuteLogParam [jobEnglishName=");
		builder.append(jobEnglishName);
		builder.append(", executeStatus=");
		builder.append(executeStatus);
		builder.append(", beginTime=");
		builder.append(beginTime);
		builder.append(", endTime=");
		builder.append(endTime);
		builder.append("]");
		return builder.toString();
	}

}
