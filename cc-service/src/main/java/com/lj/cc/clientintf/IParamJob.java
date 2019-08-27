
package com.lj.cc.clientintf;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市杨恩科技 License, Version 1.0 (the "License");
 * 
 */


/**
 * 
 * 
 * 类说明：Job接口，如定时调度任务需带参数执行，则实现此接口
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
public interface IParamJob {
    
    /**
     * Run param job.
     *
     * @param param the param
     */
    public void runParamJob(String param);
}
