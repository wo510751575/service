
package com.lj.distributecache;

import java.util.List;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市杨恩科技 License, Version 1.0 (the "License");
 * 
 */

/**
 * 
 * 
 * 类说明：队列
 *  
 * 
 * <p>
 * 详细描述：
 * （1、rpush、rpop配合则为后进先出）
 * （2、rpush、lpop配合则为先进先出）
 *   
 * @Company: 杨恩科技有限公司
 * @author 邹磊
 *   
 * CreateDate: 2017年7月14日
 */
public interface IQueue {
	
	/**
	 * *
	 * 从列表最后取出一个数据.
	 *
	 * @param key the key
	 * @return the string
	 */
	public String rpop(String key);
	
	/**
	 * *
	 * 从列表最后添加一个数据.
	 *
	 * @param key the key
	 * @param value the value
	 */
	public void rpush(String key, String... values);

	/**
	 * *
	 * 从列表最前添加一个数据.
	 *
	 * @param key the key
	 * @param value the value
	 */
	public void lpush(String key, String... values);
	
	
	/**
	 * *
	 * 从列表最前取出一个数据.
	 *
	 * @param key the key
	 * @return the string
	 */
	public String lpop(String key);
	
	
	/** 
     * 移出并获取列表的【第一个元素】， 如果列表没有元素会阻塞列表直到等待超时或发现可弹出元素为止。 
     * @param timeout 单位为秒 
     * @param keys 
     * <li>当有多个key时，只要某个key值的列表有内容，即马上返回，不再阻塞。</li> 
     * <li>当所有key都没有内容或不存在时，则会阻塞，直到有值返回或者超时。</li> 
     * <li>当超期时间到达时，keys列表仍然没有内容，则返回Null</li> 
     * @return List<String> 
     */ 
    public List<String> blpop(int timeout, String... keys);
      
    /** 
     * 移出并获取列表的【最后一个元素】， 如果列表没有元素会阻塞列表直到等待超时或发现可弹出元素为止。 
     * @param timeout 单位为秒 
     * @param keys 
     * <li>当有多个key时，只要某个key值的列表有内容，即马上返回，不再阻塞。</li> 
     * <li>当所有key都没有内容或不存在时，则会阻塞，直到有值返回或者超时。</li> 
     * <li>当超期时间到达时，keys列表仍然没有内容，则返回Null</li> 
     * @return List<String> 
     */  
    public List<String> brpop(int timeout, String... keys);
}
