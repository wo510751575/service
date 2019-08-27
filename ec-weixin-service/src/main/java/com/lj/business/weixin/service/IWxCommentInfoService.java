package com.lj.business.weixin.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.List;

import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.weixin.dto.AddWxCommentInfo;
import com.lj.business.weixin.dto.AddWxCommentInfoReturn;
import com.lj.business.weixin.dto.FindWxCommentInfo;
import com.lj.business.weixin.dto.FindWxCommentInfoPage;
import com.lj.business.weixin.dto.FindWxCommentInfoPageReturn;
import com.lj.business.weixin.dto.FindWxCommentInfoReturn;
import com.lj.business.weixin.dto.UpdateWxCommentInfo;
import com.lj.business.weixin.dto.UpdateWxCommentInfoReturn;


/**
 * 类说明：朋友圈评论服务接口
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
public interface IWxCommentInfoService {
	
	/**
	 * 
	 *
	 * 方法说明：添加微信朋友圈评论表信息
	 *
	 * @param addWxCommentInfo
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月14日
	 *
	 */
	public AddWxCommentInfoReturn addWxCommentInfo(AddWxCommentInfo addWxCommentInfo) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找微信朋友圈评论表信息
	 *
	 * @param findWxCommentInfo
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 罗书明 CreateDate: 2017年6月14日
	 *
	 */
	public FindWxCommentInfoReturn findWxCommentInfo(FindWxCommentInfo findWxCommentInfo) throws TsfaServiceException;
	

	/**
	 * 
	 *
	 * 方法说明：修改微信朋友圈评论表信息
	 *
	 * @param updateWxCommentInfo
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 罗书明 CreateDate: 2017年6月14日
	 *
	 */
	public UpdateWxCommentInfoReturn updateWxCommentInfo(UpdateWxCommentInfo updateWxCommentInfo)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：分页查询微信朋友圈评论表信息
	 *
	 * @param findWxCommentInfoPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 罗书明 CreateDate: 2017年6月14日
	 *
	 */
	public Page<FindWxCommentInfoPageReturn> findWxCommentInfoPage(FindWxCommentInfoPage findWxCommentInfoPage) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：获取微信朋友圈评论列表
	 *
	 * @param findWxCommentInfoPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 段志鹏 CreateDate: 2017年7月24日
	 *
	 */
	public List<FindWxCommentInfoPageReturn> findWxCommentInfos(FindWxCommentInfoPage findWxCommentInfoPage) throws TsfaServiceException;
	

}
