package com.lj.business.weixin.domain;

import java.util.Date;

public class WxCommentInfo {
    /**
     * CODE .
     */
    private String code;

    /**
     * 朋友圈信息CODE .
     */
    private String codeWfi;

    /**
     * 导购编号  .
     */
    private String memberNo;

    /**
     * 导购姓名 .
     */
    private String memberName;

    /**
     * 朋友圈ID .
     */
    private String idWx;

    /**
     * 评论人微信号 .
     */
    private String username;

    /**
     * 评论昵称 .
     */
    private String nickname;

    /**
     * 回复人微信号 .
     */
    private String tousername;

    /**
     * 回复人昵称 .
     */
    private String tonickname;

    /**
     * 邮箱 .
     */
    private String content;

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
     * 朋友圈信息CODE .
     *
     */
    public String getCodeWfi() {
        return codeWfi;
    }

    /**
     * 朋友圈信息CODE .
     *
     */
    public void setCodeWfi(String codeWfi) {
        this.codeWfi = codeWfi == null ? null : codeWfi.trim();
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
     * 评论人微信号 .
     *
     */
    public String getUsername() {
        return username;
    }

    /**
     * 评论人微信号 .
     *
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 评论昵称 .
     *
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 评论昵称 .
     *
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * 回复人微信号 .
     *
     */
    public String getTousername() {
        return tousername;
    }

    /**
     * 回复人微信号 .
     *
     */
    public void setTousername(String tousername) {
        this.tousername = tousername == null ? null : tousername.trim();
    }

    /**
     * 回复人昵称 .
     *
     */
    public String getTonickname() {
        return tonickname;
    }

    /**
     * 回复人昵称 .
     *
     */
    public void setTonickname(String tonickname) {
        this.tonickname = tonickname == null ? null : tonickname.trim();
    }

    /**
     * 邮箱 .
     *
     */
    public String getContent() {
        return content;
    }

    /**
     * 邮箱 .
     *
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
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
        builder.append("WxCommentInfo [code=").append(code);
        builder.append(",codeWfi=").append(codeWfi); 
        builder.append(",memberNo=").append(memberNo); 
        builder.append(",memberName=").append(memberName); 
        builder.append(",idWx=").append(idWx); 
        builder.append(",username=").append(username); 
        builder.append(",nickname=").append(nickname); 
        builder.append(",tousername=").append(tousername); 
        builder.append(",tonickname=").append(tonickname); 
        builder.append(",content=").append(content); 
        builder.append(",createDate=").append(createDate); 
        builder.append(",remark=").append(remark); 
        builder.append(",remark2=").append(remark2); 
        builder.append(",remark3=").append(remark3); 
        builder.append(",remark4=").append(remark4); 
        builder.append("]");
        return builder.toString();
    }
}