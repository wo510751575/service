package com.lj.eshop.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.eshop.dto.ProductMaterialDto;
import com.lj.eshop.dto.FindProductMaterialPage;


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
public interface IProductMaterialService {
	
	/**
	 * 
	 *
	 * 方法说明：添加产品素材信息
	 *
	 * @param productMaterialDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 段志鹏 CreateDate: 2017-12-14
	 *
	 */
	public void addProductMaterial(ProductMaterialDto productMaterialDto) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找产品素材信息
	 *
	 * @param findProductMaterial
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 段志鹏 CreateDate: 2017-12-14
	 *
	 */
	public ProductMaterialDto findProductMaterial(ProductMaterialDto productMaterialDto) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：不分页查询产品素材信息
	 *
	 * @param findProductMaterialPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 段志鹏 CreateDate: 2017-12-14
	 *
	 */
	public List<ProductMaterialDto>  findProductMaterials(FindProductMaterialPage findProductMaterialPage)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改产品素材信息
	 *
	 * @param updateProductMaterial
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 段志鹏 CreateDate: 2017-12-14
	 *
	 */
	public void updateProductMaterial(ProductMaterialDto productMaterialDto)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：分页查询产品素材信息
	 *
	 * @param findProductMaterialPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 段志鹏 CreateDate: 2017-12-14
	 *
	 */
	public Page<ProductMaterialDto> findProductMaterialPage(FindProductMaterialPage findProductMaterialPage) throws TsfaServiceException;

	/**   
	 * @Title: updateByProductCode   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param code      
	 * @return: void      
	 * @throws   
	 */
	public void updateByProductCode(String code)throws TsfaServiceException;

	/**   
	 * @Title: updateStatusOpon   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param productCode      
	 * @return: void      
	 * @throws   
	 */
	public void updateStatusOpon(String productCode)throws TsfaServiceException;

	

}
