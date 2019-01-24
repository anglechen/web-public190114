package com.web.thread;

import org.junit.Test;

/**
 * 测试多线程
 * @author Administrator
 *
 */
public class ThreadTest {
	
	public static void main(String[] args) {
		Thread t1 = new ThreadClass();
		Runnable r1 = new RunnableClass();
		Thread t2 = new Thread(r1);
//		t1.run();
		t1.start();
		t2.start();
		System.out.println("main线程结束");
	}
	
	
	
	
	
	
	
	@Test
	public void testThread() {
		Thread t1 = new ThreadClass();
//		t1.run();
		t1.start();
		System.out.println("main线程结束");
	}
}
