package com.lj.sequence;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市杨恩科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.distributecache.RedisCache;

/**
 * *
 * sequence基于Redis的实现
 * RedisCache对象推荐注入RedisCacheConfigFromCC实体.
 *
 * @author 彭阳
 */
/**
 * 
 * 
 * 类说明：
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
public class RedisSequence implements ISequence {
	
	/** * redicCache. */
	private RedisCache redisCache;
	
	/**
	 * Gets the * redicCache.
	 *
	 * @return the * redicCache
	 */
	public RedisCache getRedisCache() {
		return redisCache;
	}

	/**
	 * Sets the * redicCache.
	 *
	 * @param redisCache the new * redicCache
	 */
	public void setRedisCache(RedisCache redisCache) {
		this.redisCache = redisCache;
	}

	/* (non-Javadoc)
	 * @see com.lj.sequence.ISequence#nextval(java.lang.String)
	 */
	@Override
	public long nextval(String sequenceId) { 
		String key = SEQUENCE_INDEX_PREFIX+sequenceId;   
		long afterSet = redisCache.setIncr(key); 
		return afterSet; 
	 } 
	
	/** The Constant SEQUENCE_INDEX_PREFIX. */
	private static final String SEQUENCE_INDEX_PREFIX = "sequenceIndexPrefix";
}
