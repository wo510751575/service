package com.lj.business.cf.dto.clientFollow;

import java.io.Serializable;
import java.util.Date;

import com.lj.business.cf.emus.Status;

// TODO: Auto-generated Javadoc
/**
 * The Class AddClientFollowReturn.
 */
public class AddClientFollowReturn implements Serializable {

	
	 /** Generate cron. */
	private static final long serialVersionUID = -4393165951953526802L; 
    /**
     * CODE .
     */
    private String code;
    
    /** CF_NO. */
    private String cfNo;

    /**
     * 会员号  .
     */
    private String merchantNo;

    /**
     * 会员号  .
     */
    private String memberNo;

    /**
     * 会员名称 .
     */
    private String memberName;

    /**
     * 导购编号 .
     */
    private String memberNoGm;

    /**
     * 导购姓名 .
     */
    private String memberNameGm;

    /**
     * 跟踪次数 .
     */
    private Integer followNum;

    /**
     * 跟踪类型 .
     */
    private String followType;

    /**
     * 跟踪情况 .
     */
    private String followInfo;

    /**
     * 是否成单
             是：Y
             否：N
              .
     */
    private String deal;

    /**
     * 跟踪状态
             正常：NORMAL
             成单：DEAL
             放弃：ABANDON .
     */
    private Status status;

    /**
     * 订单金额 .
     */
    private Long orderAmount;

    /**
     * 下次跟进提醒时间 .
     */
    private Date nextDate;
    
    /** 未成单原因. */
    private String notDealReason;

    /**
     * 备注 .
     */
    private String remark;

    /**
     * 创建人 .
     */
    private String createId;

    /**
     * 创建时间 .
     */
    private Date createDate;
    
    /** 跟进时间. */
    private Date followTime;
    
    /** The shop no. */
    private String shopNo;
    
    /** The shop name. */
    private String shopName;
    
    /**
     * CODE .
     *
     * @return the cODE 
     */
    public String getCode() {
        return code;
    }

    /**
     * CODE .
     *
     * @param code the new cODE 
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }
    
    /**
     * Gets the cf no.
     *
     * @return the cf no
     */
    public String getCfNo() {
		return cfNo;
	}

	/**
	 * Sets the cf no.
	 *
	 * @param cfNo the new cf no
	 */
	public void setCfNo(String cfNo) {
		this.cfNo = cfNo;
	}

	/**
     * 会员号  .
     *
     * @return the 会员号  
     */
    public String getMerchantNo() {
        return merchantNo;
    }

    /**
     * 会员号  .
     *
     * @param merchantNo the new 会员号  
     */
    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo == null ? null : merchantNo.trim();
    }

    /**
     * 会员号  .
     *
     * @return the 会员号  
     */
    public String getMemberNo() {
        return memberNo;
    }

    /**
     * 会员号  .
     *
     * @param memberNo the new 会员号  
     */
    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo == null ? null : memberNo.trim();
    }

    /**
     * 会员名称 .
     *
     * @return the 会员名称 
     */
    public String getMemberName() {
        return memberName;
    }

    /**
     * 会员名称 .
     *
     * @param memberName the new 会员名称 
     */
    public void setMemberName(String memberName) {
        this.memberName = memberName == null ? null : memberName.trim();
    }

    /**
     * 导购编号 .
     *
     * @return the 导购编号 
     */
    public String getMemberNoGm() {
        return memberNoGm;
    }

    /**
     * 导购编号 .
     *
     * @param memberNoGm the new 导购编号 
     */
    public void setMemberNoGm(String memberNoGm) {
        this.memberNoGm = memberNoGm == null ? null : memberNoGm.trim();
    }

    /**
     * 导购姓名 .
     *
     * @return the 导购姓名 
     */
    public String getMemberNameGm() {
        return memberNameGm;
    }

    /**
     * 导购姓名 .
     *
     * @param memberNameGm the new 导购姓名 
     */
    public void setMemberNameGm(String memberNameGm) {
        this.memberNameGm = memberNameGm == null ? null : memberNameGm.trim();
    }

    /**
     * 跟踪次数 .
     *
     * @return the 跟踪次数 
     */
    public Integer getFollowNum() {
        return followNum;
    }

    /**
     * 跟踪次数 .
     *
     * @param followNum the new 跟踪次数 
     */
    public void setFollowNum(Integer followNum) {
        this.followNum = followNum;
    }

    /**
     * 跟踪类型 .
     *
     * @return the 跟踪类型 
     */
    public String getFollowType() {
        return followType;
    }

    /**
     * 跟踪类型 .
     *
     * @param followType the new 跟踪类型 
     */
    public void setFollowType(String followType) {
        this.followType = followType == null ? null : followType.trim();
    }

    /**
     * 跟踪情况 .
     *
     * @return the 跟踪情况 
     */
    public String getFollowInfo() {
        return followInfo;
    }

    /**
     * 跟踪情况 .
     *
     * @param followInfo the new 跟踪情况 
     */
    public void setFollowInfo(String followInfo) {
        this.followInfo = followInfo == null ? null : followInfo.trim();
    }

    /**
     * 是否成单
     * 是：Y
     * 否：N
     * .
     *
     * @return the 是否成单 是：Y 否：N 
     */
    public String getDeal() {
        return deal;
    }

    /**
     * 是否成单
     * 是：Y
     * 否：N
     * .
     *
     * @param deal the new 是否成单 是：Y 否：N 
     */
    public void setDeal(String deal) {
        this.deal = deal == null ? null : deal.trim();
    }


    /**
     * Gets the 跟踪状态 正常：NORMAL 成单：DEAL 放弃：ABANDON .
     *
     * @return the 跟踪状态 正常：NORMAL 成单：DEAL 放弃：ABANDON 
     */
    public Status getStatus() {
		return status;
	}

	/**
	 * Sets the 跟踪状态 正常：NORMAL 成单：DEAL 放弃：ABANDON .
	 *
	 * @param status the new 跟踪状态 正常：NORMAL 成单：DEAL 放弃：ABANDON 
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * 订单金额 .
	 *
	 * @return the 订单金额 
	 */
    public Long getOrderAmount() {
        return orderAmount;
    }

    /**
     * 订单金额 .
     *
     * @param orderAmount the new 订单金额 
     */
    public void setOrderAmount(Long orderAmount) {
        this.orderAmount = orderAmount;
    }

    /**
     * 下次跟进提醒时间 .
     *
     * @return the 下次跟进提醒时间 
     */
    public Date getNextDate() {
        return nextDate;
    }

    /**
     * 下次跟进提醒时间 .
     *
     * @param nextDate the new 下次跟进提醒时间 
     */
    public void setNextDate(Date nextDate) {
        this.nextDate = nextDate;
    }
    
    /**
     * Gets the not deal reason.
     *
     * @return the not deal reason
     */
    public String getNotDealReason() {
		return notDealReason;
	}

	/**
	 * Sets the not deal reason.
	 *
	 * @param notDealReason the new not deal reason
	 */
	public void setNotDealReason(String notDealReason) {
		this.notDealReason = notDealReason;
	}

	/**
     * 备注 .
     *
     * @return the 备注 
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注 .
     *
     * @param remark the new 备注 
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 创建人 .
     *
     * @return the 创建人 
     */
    public String getCreateId() {
        return createId;
    }

    /**
     * 创建人 .
     *
     * @param createId the new 创建人 
     */
    public void setCreateId(String createId) {
        this.createId = createId == null ? null : createId.trim();
    }

    /**
     * 创建时间 .
     *
     * @return the 创建时间 
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 创建时间 .
     *
     * @param createDate the new 创建时间 
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    
	/**
	 * Gets the follow time.
	 *
	 * @return the follow time
	 */
	public Date getFollowTime() {
		return followTime;
	}

	/**
	 * Sets the follow time.
	 *
	 * @param followTime the new follow time
	 */
	public void setFollowTime(Date followTime) {
		this.followTime = followTime;
	}
	
	/**
	 * Gets the shop no.
	 *
	 * @return the shop no
	 */
	public String getShopNo() {
		return shopNo;
	}

	/**
	 * Sets the shop no.
	 *
	 * @param shopNo the new shop no
	 */
	public void setShopNo(String shopNo) {
		this.shopNo = shopNo;
	}

	/**
	 * Gets the shop name.
	 *
	 * @return the shop name
	 */
	public String getShopName() {
		return shopName;
	}

	/**
	 * Sets the shop name.
	 *
	 * @param shopName the new shop name
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AddClientFollowReturn [code=").append(code)
				.append(", cfNo=").append(cfNo).append(", merchantNo=")
				.append(merchantNo).append(", memberNo=").append(memberNo)
				.append(", memberName=").append(memberName)
				.append(", memberNoGm=").append(memberNoGm)
				.append(", memberNameGm=").append(memberNameGm)
				.append(", followNum=").append(followNum)
				.append(", followType=").append(followType)
				.append(", followInfo=").append(followInfo).append(", deal=")
				.append(deal).append(", status=").append(status)
				.append(", orderAmount=").append(orderAmount)
				.append(", nextDate=").append(nextDate)
				.append(", notDealReason=").append(notDealReason)
				.append(", remark=").append(remark).append(", createId=")
				.append(createId).append(", createDate=").append(createDate)
				.append(", followTime=").append(followTime).append(", shopNo=")
				.append(shopNo).append(", shopName=").append(shopName)
				.append("]");
		return builder.toString();
	}

}
