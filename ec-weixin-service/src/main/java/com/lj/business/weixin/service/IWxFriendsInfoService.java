package com.lj.business.weixin.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.weixin.dto.AddWxFriendsInfo;
import com.lj.business.weixin.dto.AddWxFriendsInfoReturn;
import com.lj.business.weixin.dto.FindWxFriendsInfo;
import com.lj.business.weixin.dto.FindWxFriendsInfoPage;
import com.lj.business.weixin.dto.FindWxFriendsInfoPageReturn;
import com.lj.business.weixin.dto.FindWxFriendsInfoReturn;
import com.lj.business.weixin.dto.UpdateWxFriendsInfo;
import com.lj.business.weixin.dto.UpdateWxFriendsInfoReturn;

/**
 * 
 * 
 * 类说明：朋友圈信息服务
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 深圳扬恩科技有限公司
 * @author 段志鹏
 *   
 * CreateDate: 2017年7月21日
 */
public interface IWxFriendsInfoService {
	
	/**
	 * 
	 *
	 * 方法说明：添加微信朋友圈信息信息
	 *
	 * @param addWxFriendsInfo
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public AddWxFriendsInfoReturn addWxFriendsInfo(AddWxFriendsInfo addWxFriendsInfo) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找微信朋友圈信息信息
	 *
	 * @param findWxFriendsInfo
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public FindWxFriendsInfoReturn findWxFriendsInfo(FindWxFriendsInfo findWxFriendsInfo) throws TsfaServiceException;
	
	

	/**
	 * 
	 *
	 * 方法说明：修改微信朋友圈信息信息
	 * 	2017-09-25 UPDATE BY LEOPENG :不抛出错误
	 *
	 * @param updateWxFriendsInfo
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public UpdateWxFriendsInfoReturn updateWxFriendsInfo(UpdateWxFriendsInfo updateWxFriendsInfo)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：分页查询微信朋友圈信息信息
	 *
	 * @param findWxFriendsInfoPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public Page<FindWxFriendsInfoPageReturn> findWxFriendsInfoPage(FindWxFriendsInfoPage findWxFriendsInfoPage) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：根据导购微信号，获取当前导购最新上传时间
	 *
	 * @param wxNo
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年7月20日
	 *
	 */
	public long getNewDateByWxNo(String wxNo);
	/**
	 * 
	 *
	 * 方法说明：上传朋友圈信息
	 *	新增、更新公用
	 *	根据朋友圈ID更新
	 *	2017-09-25 UPDATE BY LEOPENG :单体数据处理，不抛出错误
	 * @param paramJson
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年7月20日
	 *
	 */
	public int uploadWxFriendsInfo(String paramJson);

}
