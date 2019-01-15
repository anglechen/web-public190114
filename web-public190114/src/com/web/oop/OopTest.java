package com.web.oop;

public class OopTest {

	public static void main(String[] args) {
		Teacher t1 = new Teacher();
		Teacher t2 = new Teacher("张三");
//		System.out.println("t1的名称：" +t1.getName());
//		System.out.println("t2的名称："+ t2.getName());
		
		
		
		Teacher1 t11 = new Teacher1();
		t11.test();
		
		Taxi txi = new Taxi();
		txi.setNums(1);
		txi.setCoclr("红色");
		
		System.out.println("============");
		
		AbstractTestChidren ab1 = new AbstractTestChidren();
		ab1.test();
		ab1.call();
		
		
		Print black = new ColorPrintMachine();
//		Print colorMachine = new ColorPrintMachine();
//		testPrint(black);
	}
	
	
	public static void testPrint(Print print) {
		print.printPaper();
	}
	
	
	
	
	

}
