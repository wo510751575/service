
package com.lj.cc.clientintf;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市杨恩科技 License, Version 1.0 (the "License");
 * 
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * 
 * 类说明：装载线程来执行指定Job
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
public class JobRunnable implements Runnable {
	
	/** The logger. */
	private static Logger logger = LoggerFactory.getLogger(JobRunnable.class);
    
    /** The job. */
    private IJob job;
    
    /** The param job. */
    private IParamJob paramJob;
    
    /** 任务参数. */
    private String param;
    
	/**
	 * Gets the job.
	 *
	 * @return the job
	 */
	public IJob getJob() {
		return job;
	}

	/**
	 * Sets the job.
	 *
	 * @param job the job
	 */
	public void setJob(IJob job) {
		this.job = job;
	}

	/**
	 * Gets the param job.
	 *
	 * @return the paramJob
	 */
	public IParamJob getParamJob() {
		return paramJob;
	}

	/**
	 * Sets the param job.
	 *
	 * @param paramJob the paramJob to set
	 */
	public void setParamJob(IParamJob paramJob) {
		this.paramJob = paramJob;
	}

	/**
	 * Gets the 任务参数.
	 *
	 * @return the param
	 */
	public String getParam() {
		return param;
	}

	/**
	 * Sets the 任务参数.
	 *
	 * @param param the param to set
	 */
	public void setParam(String param) {
		this.param = param;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		if(job != null){
			logger.debug("IJob.runJob " + job.getClass() + "任务开始执行起来了");
			job.runJob();
		} else {
			logger.debug("IParamJob.runJob " + paramJob.getClass() + "任务开始执行起来了");
			paramJob.runParamJob(param);
		}
	}
	
	/**
	 * Gets the job class.
	 *
	 * @return the job class
	 */
	@SuppressWarnings("rawtypes")
	public Class getJobClass() {
		if(job != null){
			return job.getClass();
		} else {
			return paramJob.getClass();
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("JobRunnable [job=");
		builder.append(job);
		builder.append(", paramJob=");
		builder.append(paramJob);
		builder.append(", param=");
		builder.append(param);
		builder.append("]");
		return builder.toString();
	}
}
