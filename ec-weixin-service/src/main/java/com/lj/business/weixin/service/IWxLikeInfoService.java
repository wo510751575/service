package com.lj.business.weixin.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.List;
import java.util.Map;

import com.lj.base.exception.TsfaServiceException;
import com.lj.business.weixin.dto.AddWxLikeInfo;
import com.lj.business.weixin.dto.AddWxLikeInfoReturn;
import com.lj.business.weixin.dto.FindWxLikeInfo;
import com.lj.business.weixin.dto.FindWxLikeInfoReturn;
import com.lj.business.weixin.dto.UpdateWxLikeInfo;
import com.lj.business.weixin.dto.UpdateWxLikeInfoReturn;

/**
 * 
 * 
 * 类说明：朋友圈点赞
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
public interface IWxLikeInfoService {
	
	public AddWxLikeInfoReturn addWxLikeInfo(AddWxLikeInfo addWxLikeInfo) throws TsfaServiceException;
	
	public FindWxLikeInfoReturn findWxLikeInfo(FindWxLikeInfo findWxLikeInfo) throws TsfaServiceException;

	public UpdateWxLikeInfoReturn updateWxLikeInfo(UpdateWxLikeInfo updateWxLikeInfo)throws TsfaServiceException;

	/**
     * 
     *
     * 方法说明：获取列表
     *	1.idWx 朋友圈ID
     * @param map
     * @return
     *
     * @author 段志鹏 CreateDate: 2017年7月24日
     *
     */
    List<Map<String,String>> findWxLikeInfos(Map<String,Object> map);
}
