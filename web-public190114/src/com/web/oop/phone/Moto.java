package com.web.oop.phone;

/**
 *  moto手机类
 * @author Administrator
 *
 */
public class Moto extends Phone implements Blooth{

	/**
	 * 闹钟的实现
	 */
	@Override
	public void timer() {
		System.out.println("这里是moto的闹钟设计功能");
	}

	@Override
	public void startBlooth() {
		System.out.println("正在使用moto的蓝牙功能");
	}

}
