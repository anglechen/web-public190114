package com.web.oop.phone;

public abstract class Phone {
	
	/**
	 * 手机卡
	 */
	private CardService cardService;
	
	
	
	public CardService getCardService() {
		return cardService;
	}

	public void setCardService(CardService cardService) {
		this.cardService = cardService;
	}

	/**
	 * 手机的开机方法
	 */
	public void start() {
		System.out.println("长按开机中.....;已开机");
	}
	
	/**
	 * 手机的关机方法
	 */
	public void close() {
		System.out.println("长按关机中.....;已关机");
	}
	
	public abstract void timer();
}
