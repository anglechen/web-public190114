package com.web.oop.string;

public class StringTest {

	public static void main(String[] args) {
//		String  Stringbuffer   Stringbuilder
//		String name = "张三";
//		name = "abc";
//		System.out.println(name);
		long stringStart = System.currentTimeMillis();
		String a = "abc";
		for(int i = 0 ; i< 100; i++) {
			a+="abc";
		}
		long stringEnd = System.currentTimeMillis();
		System.out.println("string 拼接花费的时间：" + (stringEnd - stringStart));
		
		
		
		long stringBufferStart = System.currentTimeMillis();
		StringBuffer b = new StringBuffer("abc");
		for(int i = 0 ; i< 100; i++) {
			b.append("abc");
		}
		long stringBufferEnd = System.currentTimeMillis();
		System.out.println("stringBuffer 拼接花费的时间：" + (stringBufferEnd - stringBufferStart));
		
		
		
		
		
		
		
		
		
		
	}

}
