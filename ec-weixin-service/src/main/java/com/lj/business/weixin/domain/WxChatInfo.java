package com.lj.business.weixin.domain;

import java.util.Date;

public class WxChatInfo {
    /**
     * CODE .
     */
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
     * 消息类型 1文本 3图片 34语音 43视频 48定位 49分享 50视频聊天 100系统信息（添加好友）318767153系统安全提示              .
     */
    private String type;

    /**
     * 发送人标识             1自己发的 0对方发的              .
     */
    private String issend;

    /**
     * 微信号 .
     */
    private String talker;

    /**
     * 内容 .
     */
    private String content;

    /**
     * 聊天时间 .
     */
    private Date chatDate;
    
    /**
     *  时间戳
     */
    private String timestamp;

    /**
     * 资源路径，             语音、图片、视频 .
     */
    private String resourcesPath;

    /**
     * 图片地址 .
     */
    private String shareTitle;

    /**
     * 分享描述 .
     */
    private String shareDes;

    /**
     * 创建时间 .
     */
    private String shareUrl;

    /**
     * 消息状态 本人（1 未发送 2发送成功） 对方待定（3, 4） .
     */
    private String status;

    /**
     * 创建时间 .
     */
    private Date createDate;

    /**
     * 备注 .
     */
    private String remark;

    /**
     * 备注 .
     */
    private String remark2;

    /**
     * 备注 .
     */
    private String remark3;

    /**
     * 备注 .
     */
    private String remark4;
    

    /**
	 * @return the timestamp
	 */
	public String getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	/**
     * CODE .
     *
     */
    public String getCode() {
        return code;
    }

    /**
     * CODE .
     *
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 导购编号 .
     *
     */
    public String getMemberNo() {
        return memberNo;
    }

    /**
     * 导购编号 .
     *
     */
    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo == null ? null : memberNo.trim();
    }

    /**
     * 导购姓名 .
     *
     */
    public String getMemberName() {
        return memberName;
    }

    /**
     * 导购姓名 .
     *
     */
    public void setMemberName(String memberName) {
        this.memberName = memberName == null ? null : memberName.trim();
    }

    /**
     * 消息ID服务器 .
     *
     */
    public String getMsgsvrid() {
        return msgsvrid;
    }

    /**
     * 消息ID服务器 .
     *
     */
    public void setMsgsvrid(String msgsvrid) {
        this.msgsvrid = msgsvrid == null ? null : msgsvrid.trim();
    }

    /**
     * 消息类型 1文本 3图片 34语音 43视频 48定位 49分享 50视频聊天 100系统信息（添加好友）318767153系统安全提示              .
     *
     */
    public String getType() {
        return type;
    }

    /**
     * 消息类型 1文本 3图片 34语音 43视频 48定位 49分享 50视频聊天 100系统信息（添加好友）318767153系统安全提示              .
     *
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 发送人标识             1自己发的 0对方发的              .
     *
     */
    public String getIssend() {
        return issend;
    }

    /**
     * 发送人标识             1自己发的 0对方发的              .
     *
     */
    public void setIssend(String issend) {
        this.issend = issend == null ? null : issend.trim();
    }

    /**
     * 微信号 .
     *
     */
    public String getTalker() {
        return talker;
    }

    /**
     * 微信号 .
     *
     */
    public void setTalker(String talker) {
        this.talker = talker == null ? null : talker.trim();
    }

    /**
     * 内容 .
     *
     */
    public String getContent() {
        return content;
    }

    /**
     * 内容 .
     *
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }


    /**
     * 时间戳 .
     *
     */
    public Date getChatDate() {
        return chatDate;
    }

    /**
     * 时间戳 .
     *
     */
    public void setChatDate(Date chatDate) {
        this.chatDate = chatDate;
    }

    /**
     * 资源路径，             语音、图片、视频 .
     *
     */
    public String getResourcesPath() {
        return resourcesPath;
    }

    /**
     * 资源路径，             语音、图片、视频 .
     *
     */
    public void setResourcesPath(String resourcesPath) {
        this.resourcesPath = resourcesPath == null ? null : resourcesPath.trim();
    }

    /**
     * 图片地址 .
     *
     */
    public String getShareTitle() {
        return shareTitle;
    }

    /**
     * 图片地址 .
     *
     */
    public void setShareTitle(String shareTitle) {
        this.shareTitle = shareTitle == null ? null : shareTitle.trim();
    }

    /**
     * 分享描述 .
     *
     */
    public String getShareDes() {
        return shareDes;
    }

    /**
     * 分享描述 .
     *
     */
    public void setShareDes(String shareDes) {
        this.shareDes = shareDes == null ? null : shareDes.trim();
    }

    /**
     * 创建时间 .
     *
     */
    public String getShareUrl() {
        return shareUrl;
    }

    /**
     * 创建时间 .
     *
     */
    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl == null ? null : shareUrl.trim();
    }

    /**
     * 消息状态 本人（1 未发送 2发送成功） 对方待定（3, 4） .
     *
     */
    public String getStatus() {
        return status;
    }

    /**
     * 消息状态 本人（1 未发送 2发送成功） 对方待定（3, 4） .
     *
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 创建时间 .
     *
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 创建时间 .
     *
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 备注 .
     *
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注 .
     *
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 备注 .
     *
     */
    public String getRemark2() {
        return remark2;
    }

    /**
     * 备注 .
     *
     */
    public void setRemark2(String remark2) {
        this.remark2 = remark2 == null ? null : remark2.trim();
    }

    /**
     * 备注 .
     *
     */
    public String getRemark3() {
        return remark3;
    }

    /**
     * 备注 .
     *
     */
    public void setRemark3(String remark3) {
        this.remark3 = remark3 == null ? null : remark3.trim();
    }

    /**
     * 备注 .
     *
     */
    public String getRemark4() {
        return remark4;
    }

    /**
     * 备注 .
     *
     */
    public void setRemark4(String remark4) {
        this.remark4 = remark4 == null ? null : remark4.trim();
    }

    /**
     * 输出BEAN数据信息
     * @author LeoPeng
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("WxChatInfo [code=").append(code);
        builder.append(",memberNo=").append(memberNo); 
        builder.append(",memberName=").append(memberName); 
        builder.append(",msgsvrid=").append(msgsvrid); 
        builder.append(",type=").append(type); 
        builder.append(",issend=").append(issend); 
        builder.append(",talker=").append(talker); 
        builder.append(",content=").append(content); 
        builder.append(",chatDate=").append(chatDate); 
        builder.append(",resourcesPath=").append(resourcesPath); 
        builder.append(",shareTitle=").append(shareTitle); 
        builder.append(",shareDes=").append(shareDes); 
        builder.append(",shareUrl=").append(shareUrl); 
        builder.append(",status=").append(status); 
        builder.append(",createDate=").append(createDate); 
        builder.append(",remark=").append(remark); 
        builder.append(",remark2=").append(remark2); 
        builder.append(",remark3=").append(remark3); 
        builder.append(",remark4=").append(remark4); 
        builder.append("]");
        return builder.toString();
    }
}