package com.lj.cc.dto;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市杨恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.io.Serializable;


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
public class FindSystemValueRetrun implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5029100910139264672L;
	/** 返回对应的value. */
	private String value = null;
	
	/**
	 * Gets the 返回对应的value.
	 *
	 * @return the 返回对应的value
	 */
	public String getValue() {
		return value;
	}
	
	/**
	 * Sets the 返回对应的value.
	 *
	 * @param value the new 返回对应的value
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){ 
		  return "\n getValue():"+getValue();
		}


}
