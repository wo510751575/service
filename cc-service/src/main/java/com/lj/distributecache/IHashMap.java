/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市杨恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.distributecache;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * 类说明：HashMap类型
 * 
 * 
 * <p>
 * 详细描述：
 * 
 * @Company: 杨恩科技有限公司
 * @author 曾垂瑜
 * 
 *         CreateDate: 2017年12月22日
 */
public interface IHashMap {

	/**
	 * Set the specified hash field to the specified value.
	 * <p>
	 * If key does not exist, a new key holding a hash is created.
	 * <p>
	 * <b>Time complexity:</b> O(1)
	 * 
	 * @param key
	 * @param field
	 * @param value
	 * @return If the field already exists, and the HSET just produced an update
	 *         of the value, 0 is returned, otherwise if a new field is created
	 *         1 is returned.
	 */
	public Long hset(final String key, final String field, final String value);

	/**
	 * If key holds a hash, retrieve the value associated to the specified
	 * field.
	 * <p>
	 * If the field is not found or the key does not exist, a special 'nil'
	 * value is returned.
	 * <p>
	 * <b>Time complexity:</b> O(1)
	 * 
	 * @param key
	 * @param field
	 * @return Bulk reply
	 */
	public String hget(final String key, final String field);

	/**
	 * Remove the specified field from an hash stored at key.
	 * <p>
	 * <b>Time complexity:</b> O(1)
	 * 
	 * @param key
	 * @param fields
	 * @return If the field was present in the hash it is deleted and 1 is
	 *         returned, otherwise 0 is returned and no operation is performed.
	 */
	public Long hdel(final String key, final String... fields);

	/**
	 * Return the number of items in a hash.
	 * <p>
	 * <b>Time complexity:</b> O(1)
	 * 
	 * @param key
	 * @return The number of entries (fields) contained in the hash stored at
	 *         key. If the specified key does not exist, 0 is returned assuming
	 *         an empty hash.
	 */
	public Long hlen(final String key);

	/**
	 * Return all the fields in a hash.
	 * <p>
	 * <b>Time complexity:</b> O(N), where N is the total number of entries
	 * 
	 * @param key
	 * @return All the fields names contained into a hash.
	 */
	public Set<String> hkeys(final String key);

	/**
	 * Return all the values in a hash.
	 * <p>
	 * <b>Time complexity:</b> O(N), where N is the total number of entries
	 * 
	 * @param key
	 * @return All the fields values contained into a hash.
	 */
	public List<String> hvals(final String key);

	/**
	 * Return all the fields and associated values in a hash.
	 * <p>
	 * <b>Time complexity:</b> O(N), where N is the total number of entries
	 * 
	 * @param key
	 * @return All the fields and values contained into a hash.
	 */
	public Map<String, String> hgetAll(final String key);

	/**
	 * Test for existence of a specified field in a hash. <b>Time
	 * complexity:</b> O(1)
	 * 
	 * @param key
	 * @param field
	 * @return Return 1 if the hash stored at key contains the specified field.
	 *         Return 0 if the key is not found or the field is not present.
	 */
	public Boolean hexists(final String key, final String field);
}
