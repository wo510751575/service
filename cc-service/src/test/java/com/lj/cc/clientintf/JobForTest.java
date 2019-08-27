package com.lj.cc.clientintf;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市杨恩科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.cc.clientintf.IJob;
import com.lj.cc.clientintf.JobService;

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
public class JobForTest implements IJob {

	/* (non-Javadoc)
	 * @see com.lj.cc.clientintf.IJob#runJob()
	 */
	@Override
	public void runJob() {
		
		printEvery2s();
	}
	
	/**
	 * Prints the every2s.
	 */
	public static void printEvery2s(){
		int i = 0;
        while(i<10){
        	System.out.println(Thread.currentThread().getName()+" now times:"+i);
        	try {
				Thread.sleep(2000);
				i++;
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}//sleep 2秒
        }
	}
	
	/**
	 * The main method.
	 *
	 * @param args the args
	 * @throws InterruptedException the interrupted exception
	 */
	public static void main(String []args) throws InterruptedException{
		
		
		System.out.println(Thread.currentThread().getName()+" begin "+System.currentTimeMillis());
		JobService jobservice = new JobService();
		jobservice.setJob(new JobForTest());
		jobservice.runJob();
		//Thread.sleep(10000);//本线程等待，以便查看job线程情况
		printEvery2s();
        
		System.out.println(Thread.currentThread().getName()+" end "+System.currentTimeMillis());
	}

}
