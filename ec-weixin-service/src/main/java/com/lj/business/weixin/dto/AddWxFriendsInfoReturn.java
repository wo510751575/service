package com.lj.business.weixin.dto;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.io.Serializable;

public class AddWxFriendsInfoReturn implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 66647835551416319L; 

	private String code;
	
	/**
     * 朋友圈ID .
     */
    private String idWx;
    
	/**
	 * @return the idWx
	 */
	public String getIdWx() {
		return idWx;
	}

	/**
	 * @param idWx the idWx to set
	 */
	public void setIdWx(String idWx) {
		this.idWx = idWx;
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
	
}
