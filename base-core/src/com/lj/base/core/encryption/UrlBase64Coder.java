package com.lj.base.core.encryption;

import org.bouncycastle.util.encoders.UrlBase64;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市扬恩科技 License, Version 1.0 (the "License");
 * 
 */

public class UrlBase64Coder {
    /*
     * Base64算法最初用于电子邮件系统，后经演变成为显示传递Url参数的一种编码方法
     * 将字符映射表中用作补位的"="换成"."
     * 并用"-"代替"+"
     * 用"_"代替"/"
     * 使得Base64编码符合Url参数规则，可以将二进制数据以Get方式进行传输
     * */
    public final static String ENCODING="UTF-8";
    
    /**
     * 
     *
     * 方法说明：编码
     *
     * @param data
     * @return
     * @throws Exception
     *
     * @author 彭阳 CreateDate: 2018年1月11日
     *
     */
    public static String encode(String data) throws Exception{
        byte[] b=UrlBase64.encode(data.getBytes(ENCODING));
        return new String(b,ENCODING);
    }
    
    /**
     * 
     *
     * 方法说明：解码
     *
     * @param data
     * @return
     * @throws Exception
     *
     * @author 彭阳 CreateDate: 2018年1月11日
     *
     */
    public static String decode(String data) throws Exception{
        byte[] b=UrlBase64.decode(data.getBytes(ENCODING));
        return new String(b,ENCODING);
    }
    
    
    public static void main(String args []) throws Exception{
			System.out.println(encode("a123456"));
			System.out.println(decode(encode("a123456")));

	}
    
}
