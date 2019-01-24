package com.web.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.web.model.User;

public class ReflectTest {
	public static void main(String[] args) throws Exception {
		Class userClass = User.class;
//		Class userClass = new User().getClass();
//		Class userClass = Class.forName("com.web.model.User");
		//构建对象
		User user = (User) userClass.newInstance();
		User user2 = new User();
//		userClass.getConstructors();
		//执行方法
		Method setAccount = userClass.getDeclaredMethod("setAccount", String.class);
		setAccount.invoke(user, "张三");
		
		user2.setAccount("张三");
		System.out.println("通过反射实现：" + user);
		System.out.println("通过对象直接调用set方法实现：" + user2);
		
		
		
		
		//获取属性
		Field[] fields = userClass.getFields();
		Field[] fields2 = userClass.getDeclaredFields();
		for(Field f : fields) {
			System.out.println("getFields()" + f.getName());
		}
		System.out.println("===========");
		for(Field f : fields2) {
			System.out.println("getDeclaredFields()" + f.getName());
		}
		
		//获取方法
		System.out.println("===========methods ============");
		
		Method[] methods = userClass.getDeclaredMethods();
		Method[] methods2 = userClass.getMethods();
		for(Method f : methods) {
			System.out.println("getDeclaredMethods()" + f.getName());
		}
		System.out.println("===========");
		for(Method f : methods2) {
			System.out.println("getMethods()" + f.getName());
		}
		
		
		
		
	}
}
