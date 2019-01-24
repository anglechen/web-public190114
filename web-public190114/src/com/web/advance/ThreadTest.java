package com.web.advance;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadTest {
	public static void main(String[] args) {
		Thread t1 = new ThreadClass();
		Thread t2 = new Thread(new RunnableClass());
//		t1.start();
//		t2.start();
//		ExecutorService service = Executors.newFixedThreadPool(2);
		ScheduledExecutorService service = Executors.newScheduledThreadPool(2);
//		for(int i = 0; i< 10; i++) {
//			service.execute(new RunnableClass());
			service.scheduleAtFixedRate(t2, 0, 1, TimeUnit.SECONDS);
//		}
		
		
		while(Thread.activeCount() > 1) {
//			System.out.println(Thread.activeCount());
			Thread.yield();
		}
		System.out.println(Business.num);
	}
}

class ThreadClass extends Thread{
	@Override
	public void run() {
		Business.mainWork();
	}
}

class RunnableClass implements Runnable{

	@Override
	public void run() {
		Business.mainWork();
	}
	
}

class Business{
	public static int num = 0;
	
	public  static void mainWork() {
		for(int i = 0; i< 10; i++) {
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (Business.class) {
				num ++;
			}
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
	}
	
	public void subWork() {
		for(int i = 0; i< 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
	}
}