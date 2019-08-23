package com.lj.eshop.dto;

import com.lj.base.core.pagination.PageParamEntity;

public class FindProductRankPricePage extends PageParamEntity {
	/** 参数 */
	private static final long serialVersionUID = 1L;
	private ProductRankPriceDto param;

	public ProductRankPriceDto getParam() {
		return param;
	}

	public void setParam(ProductRankPriceDto param) {
		this.param = param;
	}

	public FindProductRankPricePage() {
		super();
	}

	public FindProductRankPricePage(ProductRankPriceDto param) {
		super();
		this.param = param;
	}
}
