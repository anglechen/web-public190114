package com.web.oop;

public abstract  class AbstractTest {
	
	private String name;
	
	public void test() {
		System.out.println("正在使用默认的test方法");
	}
	
	public abstract void call();
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
}
