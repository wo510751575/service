package com.lj.cc.service;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市杨恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.Date;

import com.lj.base.exception.TsfaServiceException;


/**
 * 
 * 
 * 类说明：系统信息获取
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
public interface IHolidayService {
	
	
	/**
	 * 
	 *
	 * 方法说明：获取日期类型
             工作日：0
             休息日：1
             节假日：2
	 *
	 * @param dayStr 格式：yyyyMMdd
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 
	 * CreateDate: 2017年7月1日
	 *
	 */
	public String findDayType_str(String dayStr) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：获取日期类型
             工作日：0
             休息日：1
             节假日：2
	 *
	 * @param dayDate 格式：没有时分秒，只有年月日
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳
	 * CreateDate: 2017年月1日
	 *
	 */
	public String findDayType_date(Date dayDate) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：节假日初始化
	 *
	 * @param dayDate
	 * @return
	 * @throws Exception
	 *
	 * @author 彭阳 
	 * CreateDate: 2017年7月1日
	 *
	 */
	public String initHoliday(Date dayDate) throws TsfaServiceException;
	}
