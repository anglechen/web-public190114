package com.web.oop.phone;

public class Nokia extends Phone implements Wifi {

	@Override
	public void startWifi() {
		System.out.println("正在使用nokia的wifi功能");
		
	}

	@Override
	public void timer() {
		System.out.println("这里是nokia的闹钟功能");
		
	}

}
