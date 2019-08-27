package com.lj.business.weixin.dto;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.io.Serializable;

public class DelWxFriendsInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3654612046965029430L; 
	
	/**
     *  .
     */
    private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DelWxFriendsInfo [id=").append(id).append("]");
		return builder.toString();
	}

}
