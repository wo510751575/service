package com.lj.eshop.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.eshop.dto.ProductRankPriceDto;
import com.lj.eshop.dto.FindProductRankPricePage;

import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;

import java.util.List;
/**
 * 类说明：接口类
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author 段志鹏
 * 
 * 
 * CreateDate: 2017.12.14
 */
public interface IProductRankPriceService {
	
	/**
	 * 
	 *
	 * 方法说明：添加商品特权价格信息
	 *
	 * @param productRankPriceDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 段志鹏 CreateDate: 2017-12-14
	 *
	 */
	public void addProductRankPrice(ProductRankPriceDto productRankPriceDto) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找商品特权价格信息
	 *
	 * @param findProductRankPrice
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 段志鹏 CreateDate: 2017-12-14
	 *
	 */
	public ProductRankPriceDto findProductRankPrice(ProductRankPriceDto productRankPriceDto) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：不分页查询商品特权价格信息
	 *
	 * @param findProductRankPricePage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 段志鹏 CreateDate: 2017-12-14
	 *
	 */
	public List<ProductRankPriceDto>  findProductRankPrices(FindProductRankPricePage findProductRankPricePage)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改商品特权价格信息
	 *
	 * @param updateProductRankPrice
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 段志鹏 CreateDate: 2017-12-14
	 *
	 */
	public void updateProductRankPrice(ProductRankPriceDto productRankPriceDto)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：分页查询商品特权价格信息
	 *
	 * @param findProductRankPricePage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 段志鹏 CreateDate: 2017-12-14
	 *
	 */
	public Page<ProductRankPriceDto> findProductRankPricePage(FindProductRankPricePage findProductRankPricePage) throws TsfaServiceException;
	

}
