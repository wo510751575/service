package com.lj.eshop.service;

import java.util.List;

import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;
import com.lj.eshop.dto.FindMemberPage;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.eshop.dto.MemberDto;

/**
 * 类说明：接口类
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author lhy
 * 
 * 
 *         CreateDate: 2017-08-22
 */
public interface IMemberService {

	/**
	 * 
	 *
	 * 方法说明：添加会员信息
	 *
	 * @param memberDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public MemberDto addMember(MemberDto memberDto) throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：查找会员信息
	 *
	 * @param findMember
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public MemberDto findMember(MemberDto memberDto) throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：不分页查询会员信息
	 *
	 * @param findMemberPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public List<MemberDto> findMembers(FindMemberPage findMemberPage) throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改会员信息
	 *
	 * @param updateMember
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void updateMember(MemberDto memberDto) throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：分页查询会员信息
	 *
	 * @param findMemberPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public Page<MemberDto> findMemberPage(FindMemberPage findMemberPage) throws TsfaServiceException;

	/**
	 * 
	 * @Title: findMemberCodesByInvite @Description: 获取会员集合，根据邀请人 @param: @param
	 *         myInvite @param: @return @param: @throws
	 *         TsfaServiceException @return: MemberDto @throws
	 */
	public List<String> findMemberCodesByInvite(String myInvite) throws TsfaServiceException;
}
