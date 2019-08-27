package com.lj.business.weixin.domain;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 */
import java.util.Date;

/**
 * 
 * 
 * 类说明：微信朋友圈信息
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
public class WxFriendsInfo  {
	/**
     * CODE .
     */
    private String code;

    /**
     * 导购编号  .
     */
    private String memberNo;

    /**
     * 导购姓名 .
     */
    private String memberName;

    /**
     * 微信号 .
     */
    private String authorid;

    /**
     * 微信昵称 .
     */
    private String authorname;

    /**
     * 评论JSON .
     */
    private String comments;

    /**
     * 内容 .
     */
    private String content;

    /**
     * 朋友圈ID .
     */
    private String idWx;

    /**
     * 媒体资源LIST .
     */
    private String medialist;

    /**
     * 发朋友圈时间戳 .
     */
    private String timestamp;

    /**
     * 资源类型 .
     */
    private String sourcetype;

    /**
     * 类型 .
     */
    private String type;

    /**
     * 图片地址 .
     */
    private String imgpathLocal;

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
     *  分享链接
     */
    private String shareurl;

    /**
     *  分享标题
     */
    private String sharetitle;
    
    /**
	 * @return the shareurl
	 */
	public String getShareurl() {
		return shareurl;
	}

	/**
	 * @param shareurl the shareurl to set
	 */
	public void setShareurl(String shareurl) {
		this.shareurl = shareurl;
	}

	/**
	 * @return the sharetitle
	 */
	public String getSharetitle() {
		return sharetitle;
	}

	/**
	 * @param sharetitle the sharetitle to set
	 */
	public void setSharetitle(String sharetitle) {
		this.sharetitle = sharetitle;
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
     * 导购编号  .
     *
     */
    public String getMemberNo() {
        return memberNo;
    }

    /**
     * 导购编号  .
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
     * 微信号 .
     *
     */
    public String getAuthorid() {
        return authorid;
    }

    /**
     * 微信号 .
     *
     */
    public void setAuthorid(String authorid) {
        this.authorid = authorid == null ? null : authorid.trim();
    }

    /**
     * 微信昵称 .
     *
     */
    public String getAuthorname() {
        return authorname;
    }

    /**
     * 微信昵称 .
     *
     */
    public void setAuthorname(String authorname) {
        this.authorname = authorname == null ? null : authorname.trim();
    }

    /**
     * 评论JSON .
     *
     */
    public String getComments() {
        return comments;
    }

    /**
     * 评论JSON .
     *
     */
    public void setComments(String comments) {
        this.comments = comments == null ? null : comments.trim();
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
     * 朋友圈ID .
     *
     */
    public String getIdWx() {
        return idWx;
    }

    /**
     * 朋友圈ID .
     *
     */
    public void setIdWx(String idWx) {
        this.idWx = idWx == null ? null : idWx.trim();
    }

    /**
     * 媒体资源LIST .
     *
     */
    public String getMedialist() {
        return medialist;
    }

    /**
     * 媒体资源LIST .
     *
     */
    public void setMedialist(String medialist) {
        this.medialist = medialist == null ? null : medialist.trim();
    }

    /**
     * 发朋友圈时间戳 .
     *
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * 发朋友圈时间戳 .
     *
     */
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp == null ? null : timestamp.trim();
    }

    /**
     * 资源类型 .
     *
     */
    public String getSourcetype() {
        return sourcetype;
    }

    /**
     * 资源类型 .
     *
     */
    public void setSourcetype(String sourcetype) {
        this.sourcetype = sourcetype == null ? null : sourcetype.trim();
    }

    /**
     * 类型 .
     *
     */
    public String getType() {
        return type;
    }

    /**
     * 类型 .
     *
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 图片地址 .
     *
     */
    public String getImgpathLocal() {
        return imgpathLocal;
    }

    /**
     * 图片地址 .
     *
     */
    public void setImgpathLocal(String imgpathLocal) {
        this.imgpathLocal = imgpathLocal == null ? null : imgpathLocal.trim();
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
        builder.append("wxFriendsInfo [code=").append(code);
        builder.append(",memberNo=").append(memberNo); 
        builder.append(",memberName=").append(memberName); 
        builder.append(",authorid=").append(authorid); 
        builder.append(",authorname=").append(authorname); 
        builder.append(",comments=").append(comments); 
        builder.append(",content=").append(content); 
        builder.append(",idWx=").append(idWx); 
        builder.append(",medialist=").append(medialist); 
        builder.append(",timestamp=").append(timestamp); 
        builder.append(",sourcetype=").append(sourcetype); 
        builder.append(",type=").append(type); 
        builder.append(",imgpathLocal=").append(imgpathLocal); 
        builder.append(",createDate=").append(createDate); 
        builder.append(",remark=").append(remark); 
        builder.append(",remark2=").append(remark2); 
        builder.append(",remark3=").append(remark3); 
        builder.append(",remark4=").append(remark4); 
        builder.append("]");
        return builder.toString();
    }
}