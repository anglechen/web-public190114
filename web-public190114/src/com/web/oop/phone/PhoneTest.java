package com.web.oop.phone;

import com.sun.java.swing.plaf.motif.resources.motif;

/**
 * 手机测试类
 * @author Administrator
 *
 */
public class PhoneTest {

	public static void main(String[] args) {
		
//		testPhone(new Iphone(),new Unicom());
		testPhone(new Nokia(),new Telecom());
	}
	
	public static void testPhone(Phone phone,CardService cardService) {
//		Iphone iphone = new Iphone();//买了一个iphone手机
//		Nokia nokia = new Nokia();
//	Phone phone = new Moto();
	
//	Mobie mobieCard = new Mobie();//买了mobie一个卡
//		Unicom unicom = new Unicom();
//	CardService cardService = new Telecom();
	
//	nokia.setCardService(unicom);
//	iphone.setCardService(mobieCard);
	phone.setCardService(cardService);
	
//	iphone.start();
//	iphone.timer();
	phone.start();
	phone.timer();
//	CardService card = iphone.getCardService();
	CardService card = phone.getCardService();
	card.sendPhone();
	card.sendMesage();
	phone.close();
	
	}
	
	
	
	
	
	
	
	

}
