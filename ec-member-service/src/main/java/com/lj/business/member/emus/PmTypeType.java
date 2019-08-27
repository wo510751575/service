package com.lj.business.member.emus;

public enum PmTypeType {
	
//	/**
//	 * 成单客户
//	 */
//	SUCCESS("成单客户"),
//	/**
//	 * 暂停跟进
//	 */
//	GIVE_UP("暂停跟进"),
//	/**
//	 * 紧急
//	 */
//	URGENCY("紧急客户"),
//	/**
//	 * 交叉客户
//	 */
//	REPEAT("交叉客户"),
//	/**
//	 * 非意向客户
//	 */
//	OTHER("非意向客户"),
//	/**
//	 * 意向客户（到店）
//	 */
//	INTENTION("意向客户(到店)"),
//	
//	/**
//	 * 意向客户（未到店）
//	 */
//	INTENTION_N("意向客户(未到店)"),
//	
	/**
	 * 我的客户
	 */
	MY("我的客户"),
	/**
	 * 钻石客户
	 */
	DIAMONDS("钻石客户"),
	/**
	 * 黄金客户
	 */
	GOLD("黄金客户"),
	/**
	 * 白银客户
	 */
	SILVER("白银客户"),
	;
	
	private String name;

	PmTypeType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
