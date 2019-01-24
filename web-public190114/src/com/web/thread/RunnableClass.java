package com.web.thread;
/***
 * 通过实现runnable接口实现多线程
 * @author Administrator
 *
 */
public class RunnableClass implements Runnable {

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
