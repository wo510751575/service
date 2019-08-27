package com.lj.distributelock;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市杨恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.ArrayList;
import java.util.List;

import com.lj.distributecache.RedisCache;
import com.lj.distributelock.RedisLock;

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
public class RedisLockTest implements Runnable{
	 
	/**
	 * The main method.
	 *
	 * @param args the args
	 */
	public static void main(String []args){
		//启动线程,
		long beginTimes = System.currentTimeMillis();
		RedisLockTest rlt = new RedisLockTest();
		List<Thread> threadList = new ArrayList<Thread>();
		for(int i=0;i<100;i++){
			Thread t = new Thread(rlt);
			t.start();
			threadList.add(t);
		}
		boolean canRun = true;
		while(canRun){
			int aliveThreads = 0;
			for(Thread t : threadList){
				if( t.isAlive() ){
					aliveThreads++;
				} 
			}//end for
			if(aliveThreads>0){
				canRun = true;
				try {
					System.out.println("####################");
					System.out.println("还有未执行完的线程数"+aliveThreads);
					System.out.println("####################");
					Thread.sleep(5000);
					
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}else{
				canRun = false;
			}
		}
		System.out.println("####################");
		System.out.println("执行花费："+(System.currentTimeMillis()-beginTimes));
		System.out.println("####################");	
					 
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		RedisCache rc = new RedisCache();
		rc.setRedisServer("localhost");
		rc.setRedisPort(6379);
		rc.setTimeout(2000);
		
		RedisLock rl = new RedisLock();
		rl.setRedisCache(rc);
		long beginTimes = System.currentTimeMillis();
		int getlocks = 0;
		
		for(int i=0;i<10000;i++){
			try {
				String lockName = "miaosha"; 
				 String lockValue = rl.getLockUntilTimeout(lockName, 1000 ) ;
				 getlocks++;
				 rl.releaseLock(lockName, lockValue);//释放所
			} catch (Exception e) { 
				//没拿到锁
			}
		}
		System.out.println("%%%%%%%%%%%%执行花费："+(System.currentTimeMillis()-beginTimes)+"%共拿到锁："+getlocks);
		
	}
}
