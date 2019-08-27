package com.lj.cc.dto;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市杨恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.io.Serializable;
import java.util.Map;


/**
 * 
 * 
 * 类说明：
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 杨恩科技有限公司
 * @author 彭阳
 *   
 * CreateDate: 2017年7月1日
 */
public class FindSystemGroupRetrun implements Serializable {
	
	/** 返回GROUP组对应的KV MAP. */
	private Map<String,String> groupMaps = null;

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3813520613701469752L;

	/**
	 * Gets the 返回GROUP组对应的KV MAP.
	 *
	 * @return the 返回GROUP组对应的KV MAP
	 */
	public Map<String, String> getGroupMaps() {
		return groupMaps;
	}

	/**
	 * Sets the 返回GROUP组对应的KV MAP.
	 *
	 * @param groupMaps the new 返回GROUP组对应的KV MAP
	 */
	public void setGroupMaps(Map<String, String> groupMaps) {
		this.groupMaps = groupMaps;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){ 
		  return "\n getGroupMaps():"+getGroupMaps();
		}
	

}
