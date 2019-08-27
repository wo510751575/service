
package com.lj.cc.clientintf;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市杨恩科技 License, Version 1.0 (the "License");
 * 
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.google.common.collect.Interner;
import com.google.common.collect.Interners;
import com.lj.base.core.util.StringUtils;


/**
 * *
 * 所有调度任务，都需要将本Service配置为hessian服务，供调度中心CC调用
 * 调度任务调动本Service（本身也是一个IJob接口）
 * service负责在业务系统装载线程，执行具体业务（也是一个IJob接口）.
 *
 * @author 彭阳
 */
/**
 * 
 * 
 * 类说明：
 *  
 * 
 * <p>
 * 详细描述：
 * 
 * 所有调度任务，都需要将本Service配置为hessian服务，供调度中心CC调用
 * 调度任务调动本Service（本身也是一个IJob接口）
 * service负责在业务系统装载线程，执行具体业务（也是一个IJob接口）
 * 
 * @Company: 杨恩科技有限公司
 * @author 彭阳
 *   
 * CreateDate: 2017年7月1日
 */
public class JobService implements IParamJob, IJob {
	
	/** The logger. */
	private static Logger logger = LoggerFactory.getLogger(JobService.class);
    
    /** The job runnable. */
	/**
	 * JobRunnable不能再使用全局变量，要不然并发情况下任务参数param有可能被覆盖，从而引起带参数的同一任务，有的被多次执行，有的不会执行
	 */
//    private JobRunnable jobRunnable = new JobRunnable();
	
	private IJob job;
	
	private IParamJob paramJob;
    
    /** The execute thread. */
//    private Thread executeThread;
	
	public static Interner<String> pool = Interners.newWeakInterner();
	
	private ThreadPoolTaskExecutor taskExecutor;
    
	/**
	 * @return the job
	 */
	public IJob getJob() {
		return job;
	}

	/**
	 * @param job the job to set
	 */
	public void setJob(IJob job) {
		this.job = job;
	}

	/**
	 * @return the paramJob
	 */
	public IParamJob getParamJob() {
		return paramJob;
	}

	/**
	 * @param paramJob the paramJob to set
	 */
	public void setParamJob(IParamJob paramJob) {
		this.paramJob = paramJob;
	}

	/**
	 * @return the taskExecutor
	 */
	public ThreadPoolTaskExecutor getTaskExecutor() {
		return taskExecutor;
	}

	/**
	 * @param taskExecutor the taskExecutor to set
	 */
	public void setTaskExecutor(ThreadPoolTaskExecutor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}

	/* (non-Javadoc)
	 * @see com.lj.cc.clientintf.IJob#runJob()
	 */
	@Override
	public void runJob() {
		runParamJob(null);
	}
	
	/* (non-Javadoc)
	 * @see com.lj.cc.clientintf.IParamJob#runParamJob(java.lang.String)
	 */
	@Override
	public void runParamJob(String param) {
		String lockName = null;	// 同步锁(任务class + 任务参数)
		if(this.job != null){
			lockName = this.job.getClass() + StringUtils.toString(param);
		} else {
			lockName = this.paramJob.getClass() + StringUtils.toString(param);
		}
		synchronized (pool.intern(lockName)) {	// 同时只能进入一个
			JobRunnable jobRunnable = new JobRunnable();
			jobRunnable.setJob(this.job);
			jobRunnable.setParamJob(this.paramJob);
			jobRunnable.setParam(param);
			logger.debug("JobService.runJob 调度中心定时任务调起来了： {}", jobRunnable);
			if(taskExecutor != null) {	 // 配置了线程池
				taskExecutor.execute(jobRunnable);
			} else {	 // 没有配置线程池
				Thread executeThread = new Thread(jobRunnable);
				executeThread.start();	//启动线程
			}
			/*if(executeThread==null){//未启动
				logger.debug("JobService.runJob 调度中心定时任务调起来了"+jobRunnable.getJobClass());
				//启动线程
				Thread executeThread = new Thread(jobRunnable);
				executeThread.start();
			}else{
				if(executeThread.isAlive())//已启动
					logger.error("JobService.runJob 不能再度调度，调度中心定时任务正在执行"+jobRunnable.getJobClass());
				else{//启动线程已经失效
					logger.debug("JobService.runJob 重新执行，上次执行已经失效"+jobRunnable.getJobClass()+" thread status:"+executeThread.getState());
					//启动线程
					executeThread = new Thread(jobRunnable);
					executeThread.start();
				}
			}*/
		}
	}
}
