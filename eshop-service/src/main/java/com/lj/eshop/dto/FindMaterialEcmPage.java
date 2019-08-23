package com.lj.eshop.dto;

import java.util.List;

import com.lj.base.core.pagination.PageParamEntity; 

public class FindMaterialEcmPage extends PageParamEntity { 
	
	private static final long serialVersionUID = 1L;
	// 查询条件
	private MaterialCmDto param;
	
	// 动态排序条件 根据需要可自行补充
	// private .... sort;


	private String title;
	
	private String materialCmCode;
	
	private String cmMaterialCode;

	private List<String> inCmMaterialCodes;
	
	public MaterialCmDto getParam() {
		return param;
	}

	public void setParam(MaterialCmDto param) {
		this.param = param;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMaterialCmCode() {
		return materialCmCode;
	}

	public void setMaterialCmCode(String materialCmCode) {
		this.materialCmCode = materialCmCode;
	}

	public String getCmMaterialCode() {
		return cmMaterialCode;
	}

	public void setCmMaterialCode(String cmMaterialCode) {
		this.cmMaterialCode = cmMaterialCode;
	}

	public List<String> getInCmMaterialCodes() {
		return inCmMaterialCodes;
	}

	public void setInCmMaterialCodes(List<String> inCmMaterialCodes) {
		this.inCmMaterialCodes = inCmMaterialCodes;
	}

	
	
	
}
