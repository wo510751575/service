package com.lj.distributecache;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市杨恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lj.base.core.util.StringUtils;
import com.lj.base.exception.TsfaRuntimeException;
import com.lj.cc.dto.FindSystemGroup;
import com.lj.cc.service.ISystemParamsService;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 
 * 
 * 类说明：Redis K/V管理器
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 杨恩科技有限公司
 * @author 彭阳
 *   
 * CreateDate: 2017年7月14日
 */
public class RedisCache implements IDistributeCache,IQueue, IHashMap {
	


	/** The logger. */
	private static Logger logger = LoggerFactory.getLogger(RedisCache.class);

	/** The pool. */
	private static JedisPool pool = null;

	/** The redis server. */
	private String redisServer = "127.0.0.1";//redis Server

	/** The redis port. */
	private int redisPort = 6379;//redis port

	/** The timeout. */
	private int timeout = 10000;//default timeout 2seconds
	
	private String password = "";


	public static void main(String[] args) {
		RedisCache redisCache = new RedisCache();
		for (int i = 0; i < 10000; i++) {
			redisCache.set("test_" + i, "test_value_" + i);
			//redisCache.set("test_1", "123");
			System.out.println(redisCache.get("test_" + i));
		}

	}

	
	private ISystemParamsService systemParamService;

	public ISystemParamsService getSystemParamService() {
		return systemParamService;
	}

	public void setSystemParamService(ISystemParamsService systemParamService) {
		this.systemParamService = systemParamService;
		//-----从CC获取参数设置Redis Service--------
		FindSystemGroup fsg = new FindSystemGroup();
		fsg.setSystemAliasName("cc");
		fsg.setGroupName("redis");
		//----从CC获取参数组------------
		Map<String,String> fsgr = systemParamService.findSystemGroup(fsg).getGroupMaps();
		redisServer = fsgr.get("ip");
		redisPort = Integer.valueOf(fsgr.get("port"));
		timeout = Integer.valueOf(fsgr.get("timeout"));
		password = fsgr.get("password");

	}

	/**
	 * 构建redis连接池.
	 *
	 * @return JedisPool
	 */
	public JedisPool getPool() {
		if (pool == null) { 
			logger.debug("redis pool 初始化 start");
			JedisPoolConfig config = new JedisPoolConfig();
			
			
			
			//控制一个pool可分配多少个jedis实例，通过pool.getResource()来获取；
			//如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
			config.setMaxTotal(1024);
			//控制一个pool最多有多少个状态为idle(空闲的)的jedis实例。
			config.setMaxIdle(200);
			//表示当borrow(引入)一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException；http://sh.qihoo.com/pc/home?ch=youlike&sign=360_0ed9f8f8
			config.setMaxWaitMillis(1000 * 10);
			//在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
			config.setTestOnBorrow(true);
			logger.debug("redisServer :" + redisServer + "redisPort:" + redisPort + "password:" + password);
			if(password == null || password.equals("") || password.trim().equals("")) {
				pool = new JedisPool(config,redisServer, redisPort,timeout);
			}else {
			    pool = new JedisPool(config,redisServer, redisPort,timeout, password);
			}
			logger.debug("redis pool 初始化 end");
		}
		return pool;
	}
	
	/**
	 * 返回连接池
	 * @return
	 */
	public  Jedis getJedis() {
		JedisPool pool = null;
		Jedis jedis = null;
		try {
			pool = getPool();
			jedis = pool.getResource();
			return jedis;
		}catch(Exception e) {
			logger.error("redis getJedis error:{}", e);
			return null;
		}
	}
	
	/**
	 * 返还到连接池.
	 *
	 * @param pool the pool
	 * @param redis the redis
	 */
	public void returnResource(JedisPool pool, Jedis redis) {
		if (redis != null/* && redis.isConnected()*/) {
			// pool.returnResource(redis); //update by leopeng jedis升级2.9.0
			try {
				redis.close(); // XXX LEOPENG REDIS升级，CLOSE会引起问题，先屏蔽CLOSE
			} catch (Exception e) {
				logger.error("redis close error:{}", e);
			} finally {
				redis = null;
			}
		}
	}

	/**
	 * 获取数据.
	 *
	 * @param key the key
	 * @return the string
	 */
	public String get(String key){
		String value = null;

		JedisPool pool = null;
		Jedis jedis = null;
		try {
			pool = getPool();
			jedis = pool.getResource();
			value = jedis.get(key);
		} catch (Exception e) {
			//释放redis对象
			//pool.returnBrokenResource(jedis); //update by leopeng jedis升级2.9.0
			if(jedis != null)
				jedis.close();
			logger.error("redis get error"+e);
		} finally {
			//返还到连接池
			returnResource(pool, jedis);
		}

		return value;
	}

	/**
	 * *
	 * set.
	 *
	 * @param key the key
	 * @param value the value
	 * @return true, if sets the
	 */
	public boolean set(String key,String value){
		String setResult = null;
		JedisPool pool = null;
		Jedis jedis = null;
		try {
			pool = getPool();
			jedis = pool.getResource(); 
			setResult = jedis.set(key,value); 
		} catch (Exception e) {
			//释放redis对象
			//pool.returnBrokenResource(jedis); //update by leopeng jedis升级2.9.0;
			if(jedis != null)
				jedis.close();
			logger.error("redis set error"+e);
		} finally {
			//返还到连接池
			returnResource(pool, jedis);
		}

		return "OK".equals(setResult);
	}

	/**
	 * *
	 * set.
	 *
	 * @param key the key
	 * @param value the value
	 * @param expireSeconds the expire seconds
	 * @return true, if sets the
	 */
	public boolean set(String key,String value,int expireSeconds){
		String setResult = null;
		JedisPool pool = null;
		Jedis jedis = null;
		try {
			pool = getPool();
			jedis = pool.getResource(); 
			setResult = jedis.set(key,value); 
			//            jedis.in
			jedis.expire(key, expireSeconds);
		} catch (Exception e) {
			//释放redis对象
			//pool.returnBrokenResource(jedis); //update by leopeng jedis升级2.9.0;
			if(jedis != null)
				jedis.close();
			logger.error("redis set error"+e);
		} finally {
			//返还到连接池
			returnResource(pool, jedis);
		}

		return "OK".equals(setResult);
	}

	/**
	 * *
	 * 不存在才允许set.
	 *
	 * @param key the key
	 * @param value the value
	 * @param expireSeconds the expire seconds
	 * @return true, if sets the nx
	 */
	public boolean setNX(String key,String value,int expireSeconds){
		long setNXResult = 0;
		JedisPool pool = null;
		Jedis jedis = null;
		try {
			pool = getPool();
			jedis = pool.getResource(); 
			setNXResult = jedis.setnx(key,value); 
			jedis.expire(key,expireSeconds);
			Long howlong = jedis.ttl(key);
			logger.info("锁时长："+howlong.toString());
		} catch (Exception e) {
			//释放redis对象
			//pool.returnBrokenResource(jedis); //update by leopeng jedis升级2.9.0;
			if(jedis != null)
				jedis.close();
			logger.error("redis setnx error"+e);
		} finally {
			//返还到连接池
			returnResource(pool, jedis);
		} 
		return setNXResult == 1L;
	}

	/**
	 * *
	 * 计数器+1.
	 *
	 * @param key the incr
	 * @return the long
	 */
	public long setIncr(String key){
		long setNXResult = 0;
		JedisPool pool = null;
		Jedis jedis = null;
		try {
			pool = getPool();
			jedis = pool.getResource(); 
			setNXResult = jedis.incr(key); 
		} catch (Exception e) {
			//释放redis对象
			//pool.returnBrokenResource(jedis); //update by leopeng jedis升级2.9.0;
			if(jedis != null)
				jedis.close();
			logger.error("redis setincr error"+e);
		} finally {
			//返还到连接池
			returnResource(pool, jedis);
		} 
		return setNXResult ;
	}
	
	/**
     * *
     * 计数器+1.
     *
     * @param key the incr
     * @return the long
     */
    public long hIncrBy(String key, String field, long delt){
        long setNXResult = 0;
        JedisPool pool = null;
        Jedis jedis = null;
        try {
            pool = getPool();
            jedis = pool.getResource(); 
            setNXResult = jedis.hincrBy(key, field, delt);
        } catch (Exception e) {
            //释放redis对象
            //pool.returnBrokenResource(jedis); //update by leopeng jedis升级2.9.0;
            if(jedis != null)
                jedis.close();
            logger.error("redis setincr error"+e);
        } finally {
            //返还到连接池
            returnResource(pool, jedis);
        } 
        return setNXResult ;
    }

	/**
	 * *
	 * 计数器-1.
	 *
	 * @param key the decr
	 * @return the long
	 */
	public long setDecr(String key){
		long setNXResult = 0;
		JedisPool pool = null;
		Jedis jedis = null;
		try {
			pool = getPool();
			jedis = pool.getResource(); 
			setNXResult = jedis.decr(key); 
		} catch (Exception e) {
			//释放redis对象
			//pool.returnBrokenResource(jedis); //update by leopeng jedis升级2.9.0;
			if(jedis != null)
				jedis.close();
			logger.error("redis setdecr error"+e);
		} finally {
			//返还到连接池
			returnResource(pool, jedis);
		} 
		return setNXResult ;
	}

	/**
	 * Sets the nx.
	 *
	 * @param key the key
	 * @param value the value
	 * @return true, if sets the nx
	 */
	public boolean setNX(String key,String value){
		long setNXResult = 0;
		JedisPool pool = null;
		Jedis jedis = null;
		try {
			pool = getPool();
			jedis = pool.getResource(); 
			setNXResult = jedis.setnx(key,value); 
		} catch (Exception e) {
			//释放redis对象
			//pool.returnBrokenResource(jedis); //update by leopeng jedis升级2.9.0;
			if(jedis != null)
				jedis.close();
			logger.error("redis setnx error"+e);
		} finally {
			//返还到连接池
			returnResource(pool, jedis);
		} 
		return setNXResult == 1L;
	}

	/**
	 * *
	 * 不存在才允许set.
	 *
	 * @param key the key
	 * @return true, if del
	 */
	public boolean del(String key){
		long setNXResult = 0;
		JedisPool pool = null;
		Jedis jedis = null;
		try {
			pool = getPool();
			jedis = pool.getResource(); 
			setNXResult = jedis.del(key); 
		} catch (Exception e) {
			//释放redis对象
			//pool.returnBrokenResource(jedis); //update by leopeng jedis升级2.9.0;
			if(jedis != null)
				jedis.close();
			logger.error("redis del error"+e);
		} finally {
			//返还到连接池
			returnResource(pool, jedis);
		} 
		return setNXResult >0L;
	}

	/**
	 * Gets the redis server.
	 *
	 * @return the redis server
	 */
	public String getRedisServer() {
		return redisServer;
	}

	/**
	 * Sets the redis server.
	 *
	 * @param redisServer the redis server
	 */
	public void setRedisServer(String redisServer) {
		this.redisServer = redisServer;
	}

	/**
	 * Gets the redis port.
	 *
	 * @return the redis port
	 */
	public int getRedisPort() {
		return redisPort;
	}

	/**
	 * Sets the redis port.
	 *
	 * @param redisPort the redis port
	 */
	public void setRedisPort(int redisPort) {
		this.redisPort = redisPort;
	}

	/**
	 * Gets the timeout.
	 *
	 * @return the timeout
	 */
	public int getTimeout() {
		return timeout;
	}

	
	public void setPassword(String  password) {
		this.password = password;
	}
	
	/**
	 * Sets the timeout.
	 *
	 * @param timeout the timeout
	 */
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	/**
	 * *
	 * 根据多个keys获取结果，
	 * 返回key:value map对象.
	 *
	 * @param keys the keys
	 * @return the map< string, string>
	 * @author 彭阳
	 */
	@Override
	public Map<String,String> mget(String ...keys) {
		Map<String,String> value = new HashMap<String,String>();

		JedisPool pool = null;
		Jedis jedis = null;
		try {
			pool = getPool();
			jedis = pool.getResource();
			List<String> retvalues = jedis.mget(keys);
			int idx =0;//计数器
			for(String retvalue :  retvalues){
				value.put(keys[idx], retvalue);//挨个取出list的value放入map对象
				idx++;//计数器+1
			}
		} catch (Exception e) {
			//释放redis对象
			//pool.returnBrokenResource(jedis); //update by leopeng jedis升级2.9.0;
			if(jedis != null)
				jedis.close();
			logger.error("redis mget error"+e);
		} finally {
			//返还到连接池
			returnResource(pool, jedis);
		} 
		return value;
	}

	/**
	 * *
	 * 计数器-integer.
	 *
	 * @param key the key
	 * @param integer the integer
	 * @return the long
	 */
	@Override
	public long setDecr(String key, long integer) {
		long setNXResult = 0;
		JedisPool pool = null;
		Jedis jedis = null;
		try {
			pool = getPool();
			jedis = pool.getResource(); 
			setNXResult = jedis.decrBy(key,integer); 
		} catch (Exception e) {
			//释放redis对象
			//pool.returnBrokenResource(jedis); //update by leopeng jedis升级2.9.0;
			if(jedis != null)
				jedis.close();
			logger.error("redis setdecr error"+e);
		} finally {
			//返还到连接池
			returnResource(pool, jedis);
		} 
		return setNXResult ;
	}

	/**
	 * *
	 * 计数器+integer.
	 *
	 * @param key the key
	 * @param integer the integer
	 * @return the long
	 */
	@Override
	public long setIncr(String key, long integer) {
		long setNXResult = 0;
		JedisPool pool = null;
		Jedis jedis = null;
		try {
			pool = getPool();
			jedis = pool.getResource(); 
			setNXResult = jedis.incrBy(key,integer);             
		} catch (Exception e) {
			//释放redis对象
			//pool.returnBrokenResource(jedis); //update by leopeng jedis升级2.9.0;
			if(jedis != null)
				jedis.close();
			logger.error("redis setincr error"+e);
		} finally {
			//返还到连接池
			returnResource(pool, jedis);
		} 
		return setNXResult ;
	}

	/* (non-Javadoc)
	 * @see com.lj.distributecache.IQueue#lpop(java.lang.String)
	 */
	@Override
	public String lpop(String key) {
		String value = null;	        
		JedisPool pool = null;
		Jedis jedis = null;
		try {
			pool = getPool();
			jedis = pool.getResource();
			value = jedis.lpop(key);
		} catch (Exception e) {
			//释放redis对象
			//pool.returnBrokenResource(jedis); //update by leopeng jedis升级2.9.0;
			if(jedis != null)
				jedis.close();
			logger.error("redis get error"+e);
		} finally {
			//返还到连接池
			returnResource(pool, jedis);
		}

		return value;
	}

	/* (non-Javadoc)
	 * @see com.lj.distributecache.IQueue#rpop(java.lang.String)
	 */
	@Override
	public String rpop(String key) {
		String value = null;	        
		JedisPool pool = null;
		Jedis jedis = null;
		try {
			pool = getPool();
			jedis = pool.getResource();
			value = jedis.rpop(key);
		} catch (Exception e) {
			//释放redis对象
			//pool.returnBrokenResource(jedis); //update by leopeng jedis升级2.9.0;
			if(jedis != null)
				jedis.close();
			logger.error("redis get error"+e);
		} finally {
			//返还到连接池
			returnResource(pool, jedis);
		}

		return value;
	}

	/* (non-Javadoc)
	 * @see com.lj.distributecache.IQueue#rpush(java.lang.String, java.lang.String)
	 */
	@Override
	public void rpush(String key, String... values) {

		JedisPool pool = null;
		Jedis jedis = null;
		try {
			pool = getPool();
			jedis = pool.getResource();
			jedis.rpush(key, values);
		} catch (Exception e) {
			//释放redis对象
			//pool.returnBrokenResource(jedis); //update by leopeng jedis升级2.9.0;
			if(jedis != null)
				jedis.close();
			logger.error("redis get error"+e);
			throw new TsfaRuntimeException("redis-push-error","rpush-error",e);
		} finally {
			//返还到连接池
			returnResource(pool, jedis);
		}

	}

	/* (non-Javadoc)
	 * @see com.lj.distributecache.IQueue#lpush(java.lang.String, java.lang.String)
	 */
	@Override
	public void lpush(String key, String... values) {
		JedisPool pool = null;
		Jedis jedis = null;
		try {
			pool = getPool();
			jedis = pool.getResource();
			jedis.lpush(key, values);
		} catch (Exception e) {
			//释放redis对象
			//pool.returnBrokenResource(jedis); //update by leopeng jedis升级2.9.0;
			if(jedis != null)
				jedis.close();
			logger.error("redis get error"+e);
			throw new TsfaRuntimeException("redis-push-error","lpush-error",e);
		} finally {
			//返还到连接池
			returnResource(pool, jedis);
		}

	}

	/* (non-Javadoc)
	 * @see com.lj.distributecache.IHashMap#hset(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Long hset(String key, String field, String value) {
		JedisPool pool = null;
		Jedis jedis = null;
		try {
			pool = getPool();
			jedis = pool.getResource();
			return jedis.hset(key, field, value);
		} catch (Exception e) {
			//释放redis对象
			//pool.returnBrokenResource(jedis); //update by leopeng jedis升级2.9.0;
			if(jedis != null)
				jedis.close();
			logger.error("redis hset error: ", e);
			throw new TsfaRuntimeException("redis-hset-error","hset-error",e);
		} finally {
			//返还到连接池
			returnResource(pool, jedis);
		}
	}


	/* (non-Javadoc)
	 * @see com.lj.distributecache.IHashMap#hget(java.lang.String, java.lang.String)
	 */
	@Override
	public String hget(String key, String field) {
		JedisPool pool = null;
		Jedis jedis = null;
		try {
			pool = getPool();
			jedis = pool.getResource();
			return jedis.hget(key, field);
		} catch (Exception e) {
			//释放redis对象
			//pool.returnBrokenResource(jedis); //update by leopeng jedis升级2.9.0;
			if(jedis != null)
				jedis.close();
			logger.error("redis hget error: ", e);
			throw new TsfaRuntimeException("redis-hget-error","hget-error",e);
		} finally {
			//返还到连接池
			returnResource(pool, jedis);
		}
	}


	/* (non-Javadoc)
	 * @see com.lj.distributecache.IHashMap#hdel(java.lang.String, java.lang.String[])
	 */
	@Override
	public Long hdel(String key, String... fields) {
		JedisPool pool = null;
		Jedis jedis = null;
		try {
			pool = getPool();
			jedis = pool.getResource();
			return jedis.hdel(key, fields);
		} catch (Exception e) {
			//释放redis对象
			//pool.returnBrokenResource(jedis); //update by leopeng jedis升级2.9.0;
			if(jedis != null)
				jedis.close();
			logger.error("redis hdel error: ", e);
			throw new TsfaRuntimeException("redis-hdel-error","hdel-error",e);
		} finally {
			//返还到连接池
			returnResource(pool, jedis);
		}
	}


	/* (non-Javadoc)
	 * @see com.lj.distributecache.IHashMap#hlen(java.lang.String)
	 */
	@Override
	public Long hlen(String key) {
		JedisPool pool = null;
		Jedis jedis = null;
		try {
			pool = getPool();
			jedis = pool.getResource();
			return jedis.hlen(key);
		} catch (Exception e) {
			//释放redis对象
			//pool.returnBrokenResource(jedis); //update by leopeng jedis升级2.9.0;
			if(jedis != null)
				jedis.close();
			logger.error("redis hlen error: ", e);
			throw new TsfaRuntimeException("redis-hlen-error","hlen-error",e);
		} finally {
			//返还到连接池
			returnResource(pool, jedis);
		}
	}


	/* (non-Javadoc)
	 * @see com.lj.distributecache.IHashMap#hkeys(java.lang.String)
	 */
	@Override
	public Set<String> hkeys(String key) {
		JedisPool pool = null;
		Jedis jedis = null;
		try {
			pool = getPool();
			jedis = pool.getResource();
			return jedis.hkeys(key);
		} catch (Exception e) {
			//释放redis对象
			//pool.returnBrokenResource(jedis); //update by leopeng jedis升级2.9.0;
			if(jedis != null)
				jedis.close();
			logger.error("redis hkeys error: ", e);
			throw new TsfaRuntimeException("redis-hkeys-error","hkeys-error",e);
		} finally {
			//返还到连接池
			returnResource(pool, jedis);
		}
	}


	/* (non-Javadoc)
	 * @see com.lj.distributecache.IHashMap#hvals(java.lang.String)
	 */
	@Override
	public List<String> hvals(String key) {
		JedisPool pool = null;
		Jedis jedis = null;
		try {
			pool = getPool();
			jedis = pool.getResource();
			return jedis.hvals(key);
		} catch (Exception e) {
			//释放redis对象
			//pool.returnBrokenResource(jedis); //update by leopeng jedis升级2.9.0;
			if(jedis != null)
				jedis.close();
			logger.error("redis hvals error: ", e);
			throw new TsfaRuntimeException("redis-hvals-error","hvals-error",e);
		} finally {
			//返还到连接池
			returnResource(pool, jedis);
		}
	}


	/* (non-Javadoc)
	 * @see com.lj.distributecache.IHashMap#hgetAll(java.lang.String)
	 */
	@Override
	public Map<String, String> hgetAll(String key) {
		JedisPool pool = null;
		Jedis jedis = null;
		try {
			pool = getPool();
			jedis = pool.getResource();
			return jedis.hgetAll(key);
		} catch (Exception e) {
			//释放redis对象
			//pool.returnBrokenResource(jedis); //update by leopeng jedis升级2.9.0;
			if(jedis != null)
				jedis.close();
			logger.error("redis hgetAll error: ", e);
			throw new TsfaRuntimeException("redis-hgetAll-error","hgetAll-error",e);
		} finally {
			//返还到连接池
			returnResource(pool, jedis);
		}
	}


	/* (non-Javadoc)
	 * @see com.lj.distributecache.IHashMap#hexists(java.lang.String, java.lang.String)
	 */
	@Override
	public Boolean hexists(String key, String field) {
		JedisPool pool = null;
		Jedis jedis = null;
		try {
			pool = getPool();
			jedis = pool.getResource();
			return jedis.hexists(key, field);
		} catch (Exception e) {
			//释放redis对象
			//pool.returnBrokenResource(jedis); //update by leopeng jedis升级2.9.0;
			if(jedis != null)
				jedis.close();
			logger.error("redis hexists error: ", e);
			throw new TsfaRuntimeException("redis-hexists-error","hexists-error",e);
		} finally {
			//返还到连接池
			returnResource(pool, jedis);
		}
	}
	
	@Override
    public Boolean sismember(String key, String member) {
        JedisPool pool = null;
        Jedis jedis = null;
        try {
            pool = getPool();
            jedis = pool.getResource();
            return jedis.sismember(key, member);
        } catch (Exception e) {
            //释放redis对象
            //pool.returnBrokenResource(jedis); //update by leopeng jedis升级2.9.0;
            if(jedis != null)
                jedis.close();
            logger.error("redis sismember error: ", e);
            throw new TsfaRuntimeException("redis-sismember-error","sismember-error",e);
        } finally {
            //返还到连接池
            returnResource(pool, jedis);
        }
    }
	
	@Override
    public Boolean sadd(String key, String... members) {
        JedisPool pool = null;
        Jedis jedis = null;
        try {
            pool = getPool();
            jedis = pool.getResource();
            return jedis.sadd(key, members) == members.length;
        } catch (Exception e) {
            //释放redis对象
            //pool.returnBrokenResource(jedis); //update by leopeng jedis升级2.9.0;
            if(jedis != null)
                jedis.close();
            logger.error("redis sadd error: ", e);
            throw new TsfaRuntimeException("redis-sadd-error","sadd-error",e);
        } finally {
            //返还到连接池
            returnResource(pool, jedis);
        }
    }
	
	@Override
    public Long ttl(String key) {
        JedisPool pool = null;
        Jedis jedis = null;
        try {
            pool = getPool();
            jedis = pool.getResource();
            return jedis.ttl(key);
        } catch (Exception e) {
            //释放redis对象
            //pool.returnBrokenResource(jedis); //update by leopeng jedis升级2.9.0;
            if(jedis != null)
                jedis.close();
            logger.error("redis ttl error: ", e);
            throw new TsfaRuntimeException("redis-ttl-error","ttl-error",e);
        } finally {
            //返还到连接池
            returnResource(pool, jedis);
        }
    }
	
	/** 
     * 移出并获取列表的【第一个元素】， 如果列表没有元素会阻塞列表直到等待超时或发现可弹出元素为止。 
     * @param timeout 单位为秒 
     * @param keys 
     * <li>当有多个key时，只要某个key值的列表有内容，即马上返回，不再阻塞。</li> 
     * <li>当所有key都没有内容或不存在时，则会阻塞，直到有值返回或者超时。</li> 
     * <li>当超期时间到达时，keys列表仍然没有内容，则返回Null</li> 
     * @return List<String> 
     */ 
	@Override
    public List<String> blpop(int timeout, String... keys){ 
		List<String> values = null;	        
		JedisPool pool = null;
		Jedis jedis = null;
		try {
			pool = getPool();
			jedis = pool.getResource();
			values = jedis.blpop(timeout, keys); 
		} catch (Exception e) {
			//释放redis对象
			//pool.returnBrokenResource(jedis); //update by leopeng jedis升级2.9.0;
			if(jedis != null)
				jedis.close();
			logger.error("redis get error"+e);
		} finally {
			//返还到连接池
			returnResource(pool, jedis);
		}
        return values;  
    }  
      
    /** 
     * 移出并获取列表的【最后一个元素】， 如果列表没有元素会阻塞列表直到等待超时或发现可弹出元素为止。 
     * @param timeout 单位为秒 
     * @param keys 
     * <li>当有多个key时，只要某个key值的列表有内容，即马上返回，不再阻塞。</li> 
     * <li>当所有key都没有内容或不存在时，则会阻塞，直到有值返回或者超时。</li> 
     * <li>当超期时间到达时，keys列表仍然没有内容，则返回Null</li> 
     * @return List<String> 
     */  
	@Override
    public List<String> brpop(int timeout, String... keys){  
		List<String> values = null;	        
		JedisPool pool = null;
		Jedis jedis = null;
		try {
			pool = getPool();
			jedis = pool.getResource();
			values = jedis.brpop(timeout, keys); 
		} catch (Exception e) {
			//释放redis对象
			//pool.returnBrokenResource(jedis); //update by leopeng jedis升级2.9.0;
			if(jedis != null)
				jedis.close();
			logger.error("redis get error"+e);
		} finally {
			//返还到连接池
			returnResource(pool, jedis);
		}
        return values; 
    }
	
	
	
    // 保存byte类型数据
    public  void setObject(byte[] key, byte[] value, int expireTime){
    	JedisPool pool = null;
		Jedis jedis = null;
		
		
        String result = "";
      
            try{
            	pool = getPool();
        		jedis = pool.getResource();
                if(!jedis.exists(key)){
                    jedis.set(key, value);
                } 
                // redis中session过期时间
                jedis.expire(key,  expireTime );
            } catch(Exception e){
            	if(jedis != null)
    				jedis.close();
    			logger.error("redis get error"+e);
            } finally{
            	if(jedis != null)
    				jedis.close();
            }
            
    } 
    
    // 获取byte类型数据
    public  byte[] getObject(byte[] key){
    	JedisPool pool = null;
		Jedis jedis = null;

		
        byte[] bytes = null;
        
            try{
            	pool = getPool();
        		jedis = pool.getResource();
        		
                bytes = jedis.get(key);;
            }catch(Exception e){
            	if(jedis != null)
    				jedis.close();
    			logger.error("redis get error"+e);
            } finally{
            	if(jedis != null)
    				jedis.close();
            }
            
        return bytes;
        
    }
    
    // 更新byte类型的数据，主要更新过期时间
    public  void updateObject(byte[] key, int expireTime){

    	JedisPool pool = null;
		Jedis jedis = null;

            try{
            	pool = getPool();
        		jedis = pool.getResource();
                // redis中session过期时间
                jedis.expire(key, expireTime);
            }catch(Exception e){
            	if(jedis != null)
    				jedis.close();
    			logger.error("redis get error"+e);
            } finally{
            	if(jedis != null)
    				jedis.close();
            }
            
        
    }
    
    /**
	 * 获取byte[]类型Key
	 * @param key
	 * @return
	 */
	public static byte[] getBytesKey(Object object){
		if(object instanceof String){
    		return StringUtils.getBytes((String)object);
    	}else{
    		return StringUtils.serialize(object);
    	}
	}
	
	/**
	 * byte[]型转换Object
	 * @param key
	 * @return
	 */
	public static Object toObject(byte[] bytes){
		return StringUtils.unserialize(bytes);
	}
	
	/**
	 * Object转换byte[]类型
	 * @param key
	 * @return
	 */
	public static byte[] toBytes(Object object){
    	return StringUtils.serialize(object);
	}
	
	/**
	 * 获取byte[]类型Key
	 * @param key
	 * @return
	 */
	public static Object getObjectKey(byte[] key){
		try{
			return StringUtils.toString(key);
		}catch(UnsupportedOperationException uoe){
			try{
				return RedisCache.toObject(key);
			}catch(UnsupportedOperationException uoe2){
				uoe2.printStackTrace();
			}
		}
		return null;
	}
}
