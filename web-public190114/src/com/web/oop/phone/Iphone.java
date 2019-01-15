package com.web.oop.phone;

public class Iphone extends Phone implements Blooth , Wifi{
	
	@Override
	public void startWifi() {
		System.out.println("正在使用iphone的wifi功能");
		
	}

	@Override
	public void startBlooth() {
		System.out.println("正在使用iphone的蓝牙功能");
		
	}

	@Override
	public void timer() {
		System.out.println("这里是iphone的闹钟功能");
		
	}

}
