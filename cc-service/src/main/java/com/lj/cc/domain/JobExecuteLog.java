package com.lj.cc.domain;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市杨恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.Date;

import com.lj.base.core.BaseEntity;

/**
 * 
 * 
 * 类说明：
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
public class JobExecuteLog extends BaseEntity{
    
    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8689357788627938379L;
	
	private String code;

	/**
     * 任务执行code .
     */
    private String jobCode;

    /**
     * 所属调度任务 .
     */
    private String jobEnglishName;

    /**
     * 执行时间 .
     */
    private Date jobExecuteTime;

    /**
     * 执行信息 .
     */
    private String jobExecuteInfo;

    /**
     * 执行状态begin开始，end结束，中间状态由各个系统自定义 .
     */
    private String jobExecuteStatus;
    
    /**
     * The Constructor.
     */
    public JobExecuteLog() {
    	super();
    }
    
    /**
     * The Constructor.
     *
     * @param jobEnglishName the job english name
     * @param jobExecuteTime the job execute time
     * @param jobExecuteInfo the job execute info
     * @param jobExecuteStatus the job execute status
     */
    public JobExecuteLog(String jobEnglishName, Date jobExecuteTime, String jobExecuteInfo, String jobExecuteStatus) {
    	super();
    	this.jobEnglishName = jobEnglishName;
    	this.jobExecuteTime = jobExecuteTime;
    	this.jobExecuteInfo = jobExecuteInfo;
    	this.jobExecuteStatus = jobExecuteStatus;
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

    /**
	 * @return the jobCode
	 */
	public String getJobCode() {
		return jobCode;
	}

	/**
	 * @param jobCode the jobCode to set
	 */
	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}

	/**
     * 所属调度任务 .
     *
     * @return the 所属调度任务 
     */
    public String getJobEnglishName() {
        return jobEnglishName;
    }

    /**
     * 所属调度任务 .
     *
     * @param jobEnglishName the new 所属调度任务 
     */
    public void setJobEnglishName(String jobEnglishName) {
        this.jobEnglishName = jobEnglishName == null ? null : jobEnglishName.trim();
    }

    /**
     * 执行时间 .
     *
     * @return the 执行时间 
     */
    public Date getJobExecuteTime() {
        return jobExecuteTime;
    }

    /**
     * 执行时间 .
     *
     * @param jobExecuteTime the new 执行时间 
     */
    public void setJobExecuteTime(Date jobExecuteTime) {
        this.jobExecuteTime = jobExecuteTime;
    }

    /**
     * 执行信息 .
     *
     * @return the 执行信息 
     */
    public String getJobExecuteInfo() {
        return jobExecuteInfo;
    }

    /**
     * 执行信息 .
     *
     * @param jobExecuteInfo the new 执行信息 
     */
    public void setJobExecuteInfo(String jobExecuteInfo) {
        this.jobExecuteInfo = jobExecuteInfo == null ? null : jobExecuteInfo.trim();
    }

    /**
     * 执行状态begin开始，end结束，中间状态由各个系统自定义 .
     *
     * @return the 执行状态begin开始，end结束，中间状态由各个系统自定义 
     */
    public String getJobExecuteStatus() {
        return jobExecuteStatus;
    }

    /**
     * 执行状态begin开始，end结束，中间状态由各个系统自定义 .
     *
     * @param jobExecuteStatus the new 执行状态begin开始，end结束，中间状态由各个系统自定义 
     */
    public void setJobExecuteStatus(String jobExecuteStatus) {
        this.jobExecuteStatus = jobExecuteStatus == null ? null : jobExecuteStatus.trim();
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("JobExecuteLog [code=");
		builder.append(code);
		builder.append(", jobCode=");
		builder.append(jobCode);
		builder.append(", jobEnglishName=");
		builder.append(jobEnglishName);
		builder.append(", jobExecuteTime=");
		builder.append(jobExecuteTime);
		builder.append(", jobExecuteInfo=");
		builder.append(jobExecuteInfo);
		builder.append(", jobExecuteStatus=");
		builder.append(jobExecuteStatus);
		builder.append("]");
		return builder.toString();
	}

}