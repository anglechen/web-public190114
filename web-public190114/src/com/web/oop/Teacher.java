package com.web.oop;


public class Teacher {
	
	public Teacher() {
		System.out.println("正在使用默认teacher的构造函数");
	}
	
	public Teacher(String name) {
		this.name = name;
	}
	
	private String name ;
	
	private Integer age;
	
	private String sex;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	
	public void test() {
		System.out.println("正在使用teacher对象打印数据");
	}
	
	
	
	
}
