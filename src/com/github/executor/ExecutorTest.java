package com.github.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecutorTest {

	private static Integer pages=1;//
	private static boolean exeFlag=true;
	
	public static void main(String[] args) {
		ExecutorService executorService=Executors.newFixedThreadPool(10);//
		
		while(exeFlag){
			if(pages<=100){
				executorService.execute(new Runnable(){

					@Override
					public void run() {
						System.out.println("pages..."+pages+"...page");
						pages++;
					}
					
				});
			}else{
				if(((ThreadPoolExecutor)executorService).getActiveCount()==0){
					executorService.shutdown();//
					exeFlag=false;
					System.out.println("finish...");
				}
			}
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
