package com.web.thread;

public class Business {
	
	public static int count = 0;
	
//	public static Object obj = new Object();
	//synchronized 修饰方法
	public  static void bus() {
		for(int i = 0 ; i< 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (Business.class) {
				count++;
//				count = count + 1;
				System.out.println(Thread.currentThread().getName() +":" + count);
			}
			
		}
	}
}
