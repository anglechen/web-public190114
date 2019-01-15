package com.web.oop.string;

import com.web.oop.Teacher;

public class EqualsTest {
	
	public static void main(String[] args) {
		String a = "abc";
		String b = "abc";
		String c = new String("abc");
		System.out.println("a==b:" + (a==b));
		System.out.println("a equals b:" + (a.equals(b)));
		System.out.println("a==c:" + (a==c));
		System.out.println("a equals c:" + (a.equals(c)));
		
		System.out.println("=====分割线===========");
		
		//使用Teacher 类== 跟equal  比较 
		Teacher t1 = new Teacher();
		t1.setName("张三");
		Teacher t2 = new Teacher();
		t2.setName("张三");
		System.out.println("t1==t2:" +( t1 == t2));
		System.out.println("t1 equals t2:" +( t1.equals(t2)));
		
		
		
		
		
		
		
		
		
	}

}
