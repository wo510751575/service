package com.lj.eshop.dto;

import com.lj.base.core.pagination.PageParamEntity; 

public class FindProductMaterialPage extends PageParamEntity { 
	/** 参数 */
	private ProductMaterialDto param;
	public ProductMaterialDto getParam() { 
	return param;} 
	public void setParam(ProductMaterialDto param) { 
	this.param = param;} 

}
