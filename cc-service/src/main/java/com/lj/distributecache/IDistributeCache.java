package com.lj.distributecache;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市杨恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.Map;

/**
 * 
 * 
 * 类说明：分布式缓存接口
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 杨恩科技有限公司
 * @author 彭阳
 *   
 * CreateDate: 2017年7月1日
 */
public interface IDistributeCache {
	
	/**
	 * *
	 * 获取key.
	 *
	 * @param key the key
	 * @return the string
	 */
	public String get(String key);
	
	/**
	 * *
	 * 设置key.
	 *
	 * @param key the key
	 * @param value the value
	 * @return true, if sets the
	 */
	public boolean set(String key,String value);
	
	/**
	 * *
	 * 设置自动过期的key.
	 *
	 * @param key the key
	 * @param value the value
	 * @param expireSeconds the expire seconds
	 * @return true, if sets the
	 */
	public boolean set(String key,String value,int expireSeconds);
	
	/**
	 * *
	 * 计数器-1.
	 *
	 * @param key the decr
	 * @return the long
	 */
    public long setDecr(String key);
    
    /**
     * *
     * 计数器+1.
     *
     * @param key the incr
     * @return the long
     */
    public long setIncr(String key);
    
	/**
	 * *
	 * 计数器-integer.
	 *
	 * @param key the key
	 * @param integer the integer
	 * @return the long
	 */
    public long setDecr(String key,long integer);
    
    /**
     * *
     * 计数器+integer.
     *
     * @param key the key
     * @param integer the integer
     * @return the long
     */
    public long setIncr(String key,long integer);
    
    /**
     * *
     * 删除指定key的缓存.
     *
     * @param key the key
     * @return true, if del
     */
    public boolean del(String key);
    
    /**
     * *
     * 一次获取多个key的值，返回k/v对.
     *
     * @param keys the keys
     * @return the map< string, string>
     * @author 彭阳
     */
    public Map<String,String> mget(String ...keys);

    /**
     * 
     *
     * 方法说明：set集合是否包含指定string
     *
     * @param key
     * @param member
     * @return
     *
     * @author 许新龙 CreateDate: 2018年1月29日
     *
     */
    Boolean sismember(String key, String member);

    /**
     * 
     *
     * 方法说明：set集合添加元素
     *
     * @param key
     * @param members
     * @return
     *
     * @author 许新龙 CreateDate: 2018年1月29日
     *
     */
    Boolean sadd(String key, String... members);
    
    /**
               * 查询key 有效时间
     * @param key
     * @return
     */
    public Long ttl(String key);
}
