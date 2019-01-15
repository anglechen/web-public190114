package com.web.oop.phone;

public class Unicom implements CardService{

	@Override
	public void sendPhone() {
		System.out.println("正在使用中国联通打电话");
		
	}

	@Override
	public void sendMesage() {
		System.out.println("正在使用中国联通发短信");
		
	}

}
