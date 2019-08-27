
package com.lj.sequence;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市杨恩科技 License, Version 1.0 (the "License");
 * 
 */

/**
 * 
 * 
 * 类说明：模拟Oracle的Sequence（支持分布式）
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
public interface ISequence {
	
	/**
	 * *
	 * 获取sequence下一个值.
	 *
	 * @param sequenceId the sequence id
	 * @return the long
	 */
	public long nextval(String sequenceId); 
}
