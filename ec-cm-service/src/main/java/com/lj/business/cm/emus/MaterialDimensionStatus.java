package com.lj.business.cm.emus;

/**
 * 素材类型维度
 * 类说明：
 * 
 * <p>
 * 
 * @Company: 深圳扬恩科技有限公司
 * @author 林进权
 * 
 *         CreateDate: 2017年9月23日
 */
public enum MaterialDimensionStatus {
	/** 官方素材类型*/
	MERCHANT("MERCHANT", "官方"),

	/** 卖家个人素材类型. */
	SHOP("SHOP", "卖家"),

	/** 个人素材类型. */
	PRIVATE("PRIVATE", "个人");
	
	MaterialDimensionStatus(String value, String chName) {
		this.value = value;
		this.chName = chName;
	}

	private String value;// DB 存贮值
	private String chName;// 值对应的中文描述
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getChName() {
		return chName;
	}
	public void setChName(String chName) {
		this.chName = chName;
	}
	
}
