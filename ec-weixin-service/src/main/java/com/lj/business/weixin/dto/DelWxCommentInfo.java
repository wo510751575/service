package com.lj.business.weixin.dto;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.io.Serializable;

public class DelWxCommentInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5585366641566697751L;

	/**
	 * @return
	 */
	  private Long id;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "DelWxCommentInfo [id=" + id + ", getId()=" + getId() + "]";
	}

	

}
