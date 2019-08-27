package com.lj.asyncmsg;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市杨恩科技 License, Version 1.0 (the "License");
 * 
 */
import com.taobao.metamorphosis.client.extension.spring.DefaultMessageListener;
import com.taobao.metamorphosis.client.extension.spring.MetaqMessage;

/**
 * 
 * 
 * 类说明：
 *  
 * 
 * <p>
 * 详细描述：
 * 对metaq消息的封装，直接获取消息题的message
 * 需要重载onStringMessage.
 * @Company: 杨恩科技有限公司
 * @author 彭阳
 *   
 * CreateDate: 2017年7月1日
 */
public abstract class MetaqStringMessageListener extends DefaultMessageListener<String>{
	
	/* (non-Javadoc)
	 * @see com.taobao.metamorphosis.client.extension.spring.DefaultMessageListener#onReceiveMessages(com.taobao.metamorphosis.client.extension.spring.MetaqMessage)
	 */
	@Override
	public final void onReceiveMessages(MetaqMessage<String> metaqMsg) { 
		//long msgId = metaqMsg.getId();
		String msgVal  = metaqMsg.getBody();
		//-------转为json-------------
		onStringMessage(msgVal);
	}
	
	/**
	 * On string message.
	 *
	 * @param message the message
	 */
	public abstract void onStringMessage(String message); 
}
