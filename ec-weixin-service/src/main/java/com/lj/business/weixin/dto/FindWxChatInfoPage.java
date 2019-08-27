package com.lj.business.weixin.dto;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.Date;

import com.lj.base.core.pagination.PageParamEntity; 

/**
 * 
 * 
 * 类说明：聊天信息查询dto
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 深圳扬恩科技有限公司
 * @author 段志鹏
 *   
 * CreateDate: 2017年7月20日
 */
public class FindWxChatInfoPage extends PageParamEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5145026781282640123L; 

    private String code;

    /**
     * 导购编号 .
     */
    private String memberNo;

    /**
     * 导购姓名 .
     */
    private String memberName;

    /**
     * 消息ID服务器 .
     */
    private String msgsvrid;

    /**
     * 发送人标识
             0是TALKER,1是本人 .
     */
    private String issend;

    /**
     * 微信号 .
     */
    private String talker;
    
    private String chatDate;
    
    /**
	 * @return the chatDate
	 */
	public String getChatDate() {
		return chatDate;
	}

	/**
	 * @param chatDate the chatDate to set
	 */
	public void setChatDate(String chatDate) {
		this.chatDate = chatDate;
	}

	/** 开始时间. */
	private Date startTime;			
	
	/** 结束时间. */
	private Date endTime;
	
	/**
	 * 消息类型 1文本 3图片 34语音 43视频 48定位 49分享 50视频聊天 100系统信息（添加好友）318767153系统安全提示
	 */
	private String type;
	
	
	

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the memberNo
	 */
	public String getMemberNo() {
		return memberNo;
	}

	/**
	 * @param memberNo the memberNo to set
	 */
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	/**
	 * @return the memberName
	 */
	public String getMemberName() {
		return memberName;
	}

	/**
	 * @param memberName the memberName to set
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	/**
	 * @return the msgsvrid
	 */
	public String getMsgsvrid() {
		return msgsvrid;
	}

	/**
	 * @param msgsvrid the msgsvrid to set
	 */
	public void setMsgsvrid(String msgsvrid) {
		this.msgsvrid = msgsvrid;
	}

	/**
	 * @return the issend
	 */
	public String getIssend() {
		return issend;
	}

	/**
	 * @param issend the issend to set
	 */
	public void setIssend(String issend) {
		this.issend = issend;
	}

	/**
	 * @return the talker
	 */
	public String getTalker() {
		return talker;
	}

	/**
	 * @param talker the talker to set
	 */
	public void setTalker(String talker) {
		this.talker = talker;
	}

	/**
	 * @return the startTime
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the endTime
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FindWxChatInfoPage [code=" + code + ", memberNo=" + memberNo
				+ ", memberName=" + memberName + ", msgsvrid=" + msgsvrid
				+ ", issend=" + issend + ", talker=" + talker + ", startTime="
				+ startTime + ", endTime=" + endTime + "]";
	}

}
