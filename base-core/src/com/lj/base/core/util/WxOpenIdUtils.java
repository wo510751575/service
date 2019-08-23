package com.lj.base.core.util;

import com.lj.base.core.encryption.MD5;


/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市扬恩科技 License, Version 1.0 (the "License");
 * 
 */

public class WxOpenIdUtils {
	
	private static final String WXOPENID_PRE = "wxopenid_";
	
	private static final String WXOPENID_SALT = "b4060f82f4ed11e7b";

	public static void main(String args []){
		for (int i = 0; i < 10; i++) {
			System.out.println(generateWxOpenId("wxid_vhpyoqvaxca722" + i));
		}
		System.out.println(generateWxOpenId(null));
		System.out.println(generateWxOpenId(null));
	}
	
	/**
	 * 
	 *
	 * 方法说明：生成WXOPENID,加盐后做MD5，取128位长整数，然后做URL BASE64，再去掉末尾.符号；前面添加 wxopenid_
	 *
	 * @param data
	 * @return
	 *
	 * @author 彭阳 CreateDate: 2018年1月11日
	 *
	 */
	public static String generateWxOpenId(String data){
		String wxOpenId = MD5.encryptToUrlBase64(data + WXOPENID_SALT).replace(".", "");
		wxOpenId = WXOPENID_PRE  +  wxOpenId;
		return wxOpenId;
    }

}
