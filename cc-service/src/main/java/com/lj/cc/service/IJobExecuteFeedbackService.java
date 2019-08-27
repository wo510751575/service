package com.lj.cc.service;



import com.lj.base.core.pagination.IPage;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市杨恩科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.cc.domain.JobExecuteLog;
import com.lj.cc.dto.JobExecuteLogParam;

/**
 * 
 * 
 * 类说明：执行调度任务信息反馈
 *  
 * 
 * <p>
 * 详细描述：供各业务系统调用（未来要改造为异步消息平台）
 *   
 * @Company: 杨恩科技有限公司
 * @author 彭阳
 *   
 * CreateDate: 2017年7月1日
 */
public interface IJobExecuteFeedbackService {
    
    /**
     * *
     * 业务系统执行反馈信息（可多次调用），但最后结束需要调用一次status为end.
     *
     * @param jobExecuteLogFeedback the job execute log feedback
     */
	public void pushJobExecuteInfo(JobExecuteLog jobExecuteLogFeedback);
	  /**
     * 方法说明：任务日志分页查询.
     *
     * @param param the param
     * @return the list< job execute log>
     * @author 彭阳
     * 
     * CreateDate: 2017-06-17
     */
    public IPage<JobExecuteLog> queryJobExecuteLogList(JobExecuteLogParam param);

}
