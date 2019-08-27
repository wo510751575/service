package com.lj.business.weixin.dto;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.io.Serializable;

/**
 * The Class FindWxFriendsInfo.
 */
public class FindWxFriendsInfo implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8764102025332742741L; 
	
	/**
     *  .
     */
    private String code;


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


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FindWxFriendsInfo [code=" + code + "]";
	}

}
