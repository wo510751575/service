package com.lj.cc.domain;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市杨恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.Calendar;
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
public class JobCenter extends BaseEntity{
    
    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4267575109227443056L;

	/**
     * 定时任务英文标识 .
     */
    private String jobEnglishName;

    /**
     * 定时任务中文描述 .
     */
    private String jobName;

    /**
     * 所属系统 .
     */
    private String systemAliasName;

    /**
     * 任务接口 .
     */
    private String jobIntf;
    
    /** 任务参数(JSON格式). */
    private String jobParam;

    /**
     * 是否启用，0禁用，1启用 .
     */
    private String isEnable;

    /**
     * 定时任务配置 .
     */
    private String jobCalender;
    
    /**
     * 
     *
     * 方法说明：根据时间生成调度时间策略
     *
     * @param runTime
     *
     * @author 曾垂瑜 CreateDate: 2018年3月28日
     *
     */
    public void setJobCalenderByTime(Date runTime) {
    	Calendar calendar = Calendar.getInstance(); 
        calendar.setTime(runTime);//设置日历时间
        
        StringBuilder sb = new StringBuilder();
        sb.append(calendar.get(Calendar.SECOND))					// 秒
        .append(" ").append(calendar.get(Calendar.MINUTE))			// 分
        .append(" ").append(calendar.get(Calendar.HOUR_OF_DAY))	// 小时
        .append(" ").append(calendar.get(Calendar.DATE))			// 日
        .append(" ").append(calendar.get(Calendar.MONTH) + 1)		// 月
        .append(" ?")												// 周
        .append(" ").append(calendar.get(Calendar.YEAR));			// 年
        this.jobCalender = sb.toString();	//0 47 11 25 12 ? 2017
    }

    /**
     * 定时任务英文标识 .
     *
     * @return the 定时任务英文标识 
     */
    public String getJobEnglishName() {
        return jobEnglishName;
    }

    /**
     * 定时任务英文标识 .
     *
     * @param jobEnglishName the new 定时任务英文标识 
     */
    public void setJobEnglishName(String jobEnglishName) {
        this.jobEnglishName = jobEnglishName == null ? null : jobEnglishName.trim();
    }

    /**
     * 定时任务中文描述 .
     *
     * @return the 定时任务中文描述 
     */
    public String getJobName() {
        return jobName;
    }

    /**
     * 定时任务中文描述 .
     *
     * @param jobName the new 定时任务中文描述 
     */
    public void setJobName(String jobName) {
        this.jobName = jobName == null ? null : jobName.trim();
    }

    /**
     * 所属系统 .
     *
     * @return the 所属系统 
     */
    public String getSystemAliasName() {
        return systemAliasName;
    }

    /**
     * 所属系统 .
     *
     * @param systemAliasName the new 所属系统 
     */
    public void setSystemAliasName(String systemAliasName) {
        this.systemAliasName = systemAliasName == null ? null : systemAliasName.trim();
    }

    /**
     * 任务接口 .
     *
     * @return the 任务接口 
     */
    public String getJobIntf() {
        return jobIntf;
    }

    /**
     * 任务接口 .
     *
     * @param jobIntf the new 任务接口 
     */
    public void setJobIntf(String jobIntf) {
        this.jobIntf = jobIntf == null ? null : jobIntf.trim();
    }

    /**
     * Gets the 任务参数(JSON格式).
     *
     * @return the jobParam
     */
	public String getJobParam() {
		return jobParam;
	}

	/**
	 * Sets the 任务参数(JSON格式).
	 *
	 * @param jobParam the jobParam to set
	 */
	public void setJobParam(String jobParam) {
		this.jobParam = jobParam;
	}

	/**
	 * 是否启用，0禁用，1启用 .
	 *
	 * @return the 是否启用，0禁用，1启用 
	 */
    public String getIsEnable() {
        return isEnable;
    }

    /**
     * 是否启用，0禁用，1启用 .
     *
     * @param isEnable the new 是否启用，0禁用，1启用 
     */
    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable == null ? null : isEnable.trim();
    }

    /**
     * 定时任务配置 .
     *
     * @return the 定时任务配置 
     */
    public String getJobCalender() {
        return jobCalender;
    }

    /**
     * 定时任务配置 .
     *
     * @param jobCalender the new 定时任务配置 
     */
    public void setJobCalender(String jobCalender) {
        this.jobCalender = jobCalender == null ? null : jobCalender.trim();
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("JobCenter [jobEnglishName=");
		builder.append(jobEnglishName);
		builder.append(", jobName=");
		builder.append(jobName);
		builder.append(", systemAliasName=");
		builder.append(systemAliasName);
		builder.append(", jobIntf=");
		builder.append(jobIntf);
		builder.append(", jobParam=");
		builder.append(jobParam);
		builder.append(", isEnable=");
		builder.append(isEnable);
		builder.append(", jobCalender=");
		builder.append(jobCalender);
		builder.append("]");
		return builder.toString();
	}
}