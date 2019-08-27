package com.lj.asyncmsg;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市杨恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.Map;

import com.taobao.metamorphosis.client.extension.spring.DefaultMessageListener;
import com.taobao.metamorphosis.client.extension.spring.MetaqMessage;
import com.lj.base.mvc.base.json.JsonUtils;

/**
 * 
 * 
 * 类说明：
 *  
 * 
 * <p>
 * 详细描述：
 * 对metaq消息的封装，直接获取消息题的message
 * 转换为map
 * 需要重载onMapMessage.
 * @Company: 杨恩科技有限公司
 * @author 彭阳
 *   
 * CreateDate: 2017年7月1日
 */
@SuppressWarnings("rawtypes") 
public abstract class MetaqMapMessageListener extends DefaultMessageListener<String>{
	
	/* (non-Javadoc)
	 * @see com.taobao.metamorphosis.client.extension.spring.DefaultMessageListener#onReceiveMessages(com.taobao.metamorphosis.client.extension.spring.MetaqMessage)
	 */
	@Override
	public final void onReceiveMessages(MetaqMessage<String> metaqMsg) { 
		//long msgId = metaqMsg.getId();
		String msgVal  = metaqMsg.getBody();
		//-------转为json-------------
		onMapMessage((Map)JsonUtils.objectFromJson(msgVal, Map.class));
	}
	
	/**
	 * On map message.
	 *
	 * @param message the message
	 */
	public abstract void onMapMessage(Map message); 
}
