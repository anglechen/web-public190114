package com.web.thread;
/**
 * 通过继承Thread的方式实现多线程
 * @author Administrator
 *
 */
public class ThreadClass extends Thread {
	
	@Override
	public void run() {
		Business.bus();
		/*for(int i = 0 ; i< 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() +":" + i);
		}*/
	}
}
