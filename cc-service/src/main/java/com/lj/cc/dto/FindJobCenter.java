package com.lj.cc.dto;

import com.lj.base.core.pagination.PageParamEntity;



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
 * @author 罗书明
 *   
 * CreateDate: 2017年10月19日
 */
public class FindJobCenter extends PageParamEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8367222023809092711L;
 

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

	public String getJobEnglishName() {
		return jobEnglishName;
	}

	public void setJobEnglishName(String jobEnglishName) {
		this.jobEnglishName = jobEnglishName;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getSystemAliasName() {
		return systemAliasName;
	}

	public void setSystemAliasName(String systemAliasName) {
		this.systemAliasName = systemAliasName;
	}

	public String getJobIntf() {
		return jobIntf;
	}

	public void setJobIntf(String jobIntf) {
		this.jobIntf = jobIntf;
	}

	public String getJobParam() {
		return jobParam;
	}

	public void setJobParam(String jobParam) {
		this.jobParam = jobParam;
	}

	public String getIsEnable() {
		return isEnable;
	}

	public void setIsEnable(String isEnable) {
		this.isEnable = isEnable;
	}

	public String getJobCalender() {
		return jobCalender;
	}

	public void setJobCalender(String jobCalender) {
		this.jobCalender = jobCalender;
	}
	
	
}
