package com.lj.business.weixin.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.List;
import java.util.Map;

import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.weixin.dto.AddWxChatInfo;
import com.lj.business.weixin.dto.AddWxChatInfoReturn;
import com.lj.business.weixin.dto.FindWxChatInfo;
import com.lj.business.weixin.dto.FindWxChatInfoPage;
import com.lj.business.weixin.dto.FindWxChatInfoPageReturn;
import com.lj.business.weixin.dto.FindWxChatInfoReturn;
import com.lj.business.weixin.dto.UpdateWxChatInfo;
import com.lj.business.weixin.dto.UpdateWxChatInfoReturn;


/**
 * 类说明：接口类
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author 罗书明
 * 
 * 
 * CreateDate: 2017-06-14
 */
public interface IWxChatInfoService {
	
	/**
	 * 
	 *
	 * 方法说明：添加微信朋友圈评论表信息
	 *
	 * @param addWxChatInfo
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 罗书明 CreateDate: 2017年6月9日
	 *
	 */
	public AddWxChatInfoReturn addWxChatInfo(AddWxChatInfo addWxChatInfo) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找微信朋友圈评论表信息
	 *
	 * @param findWxChatInfo
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 罗书明  CreateDate: 2017年6月9日
	 *
	 */
	public FindWxChatInfoReturn findWxChatInfo(FindWxChatInfo findWxChatInfo) throws TsfaServiceException;
	
	

	/**
	 * 
	 *
	 * 方法说明：修改微信朋友圈评论表信息
	 *
	 * @param updateWxChatInfo
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public UpdateWxChatInfoReturn updateWxChatInfo(UpdateWxChatInfo updateWxChatInfo)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：分页查询微信朋友圈评论表信息
	 *
	 * @param findWxChatInfoPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public Page<FindWxChatInfoPageReturn> findWxChatInfoPage(FindWxChatInfoPage findWxChatInfoPage) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：根据导购微信号，获取当前导购最新聊天时间
	 *
	 * @param wxNo
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年7月20日
	 *
	 */
	public long getMaxChatDateByWxNo(String wxNo);
	/**
	 * 
	 *
	 * 方法说明：上传聊天记录
	 *	2017-09-25 UPDATE BY LEOPENG :单体数据处理，不抛出错误
	 * @param paramJson
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年7月20日
	 *
	 */
	public int uploadWxChatInfo(String paramJson);
	
	/**
	 * 
	 *
	 * 方法说明：按年月日分组查询OMS所需
	 *1.memberNo 导购编号
	 *2.startTime 开始时间
	 *3.endTime 结束时间
	 *4.talker 客户微信号
	 *5.start 开始行
	 *6.limit 查询条数
	 * @param parmMap
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年7月20日
	 *
	 */
	Page<Map<String,String>> findWxChatInfoPageOMS(Map<String,Object> parmMap);
	
	/**
	 * 
	 *
	 * 方法说明：统计时间段内的咨询量
	 *
	 * @param findWxChatInfo
	 * @return
	 *
	 * @author 罗书明 CreateDate: 2017年8月8日
	 *
	 */
	public int findWxChantInfoCountTime(FindWxChatInfo findWxChatInfo);

	/**
	 * 
	 *
	 * 方法说明：商户运营日报微信聊天次数
	 *
	 * @param findWxChatInfo
	 * @return
	 *
	 * @author 梅宏博 CreateDate: 2017年9月28日
	 *
	 */
	public List<Map<String, Object>> findCountWxChat(
			Map<String, Object> baseParam);
}
