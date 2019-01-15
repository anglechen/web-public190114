package com.web.oop.phone;

public class Mobie implements CardService {

	@Override
	public void sendPhone() {
		System.out.println("正在使用中国移动打电话");
		
	}

	@Override
	public void sendMesage() {
		System.out.println("正在使用中国移动发短信");
		
	}

}
