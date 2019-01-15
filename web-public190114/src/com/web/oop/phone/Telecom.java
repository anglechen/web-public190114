package com.web.oop.phone;

public class Telecom implements CardService {

	@Override
	public void sendPhone() {
		System.out.println("正在使用中国电信打电话");
		
	}

	@Override
	public void sendMesage() {
		System.out.println("正在使用中国电信发短信");
		
	}

}
