package com.lj.cc.service;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市杨恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.List;

import com.lj.cc.domain.JobCenter;
import com.lj.cc.domain.JobExecuteLog;
import com.lj.cc.dto.FindJobCenter;
import com.lj.cc.dto.JobExecuteLogParam;
import com.lj.base.core.pagination.IPage;
import com.lj.base.exception.TsfaServiceException;

/**
 * 
 * 
 * 类说明：调度任务查询管理接口
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
public interface IJobMgrService {

	/**
	 * 方法说明：查询所有调度任务.
	 *
	 * @return the list< job center>
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳
	 * 
	 * CreateDate: 2017-5-17
	 */
	public List<JobCenter> findAllJobCenter() throws TsfaServiceException;
	
	/**
	 * 方法说明：任务日志查询.
	 *
	 * @param param the param
	 * @return the i page< job execute log>
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳
	 * 
	 * CreateDate: 2017-7-1
	 */
	public IPage<JobExecuteLog> findJobExecuteLog(JobExecuteLogParam param) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：添加临时性任务
	 * 1、只适合那种只执行一次的任务
	 * 2、任务在执行后会删除任务
	 * 3、jobEnglishName要全局唯一
	 * 4、任务执行时，同一任务相同参数做了并发控制。所以如果同一任务注册多次，则需附带不同参数才能同时执行
	 *
	 * @param jc
	 * @throws TsfaServiceException
	 *
	 * @author 曾垂瑜 CreateDate: 2017年12月22日
	 *
	 */
	public void addTempJob(JobCenter jc) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：删除临时性任务
	 *
	 * @param jobEnglishName
	 * @throws TsfaServiceException
	 *
	 * @author 曾垂瑜 CreateDate: 2018年3月27日
	 *
	 */
	public void delTempJob(String jobEnglishName) throws TsfaServiceException;
	
	/**
     * 
    *
    * 方法说明：分页列表
    *
    * @param center
    * @return
    *
    * @author 罗书明 CreateDate: 2017年10月19日
    *
    */
   public IPage<JobCenter> queryJobList(FindJobCenter center);

	/**   
	 * @Title: addJob   
	 * @Description: TODO(新增任务)   
	 * @param: @param jc
	 * @param: @throws TsfaServiceException      
	 * @return: void      
	 * @throws   
	 */
	void addJob(JobCenter jc) throws TsfaServiceException;
}
