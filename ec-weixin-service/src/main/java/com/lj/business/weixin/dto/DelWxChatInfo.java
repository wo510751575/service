package com.lj.business.weixin.dto;

import java.io.Serializable;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
public class DelWxChatInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5390256627539981141L;
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "DelWxChatInfo [id=" + id + ", getId()=" + getId()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}
