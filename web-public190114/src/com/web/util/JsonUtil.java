package com.web.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.web.model.User;

public class JsonUtil {
	/**
	 * 用来把map转换为bean
	 * @param parameters
	 * @param clazz
	 * @return
	 */
	public static <T>  T mapToJavaObject(Map<String,String[]> parameters , Class<T> clazz) {
		Map<String, String> parameterMap = new HashMap<>();
		//遍历参数的map对象
		Set<Entry<String, String[]>> entrys = parameters.entrySet();
		for(Entry<String, String[]> entry : entrys ) {
			String key = entry.getKey();
			String value = entry.getValue()[0];
			parameterMap.put(key, value);
		}
		T temp = JSONObject.toJavaObject((JSON)JSON.toJSON(parameterMap), clazz);
		return temp;
	}
	
	
	public static <T>  T mapToBean(Map<String,String[]> parameters , Class<T> clazz) {
		T obj = null;	
		//实例化对象
		try {
			obj = clazz.newInstance();
		}  catch (Exception e1) {
			e1.printStackTrace();
		}
		//遍历参数map对象
		Set<Entry<String, String[]>>  entrys = parameters.entrySet();
		for(Entry<String, String[]> entry : entrys) {
			String key = entry.getKey();//前端参数属性的名称
			String[] values = entry.getValue();
			if(values == null || values.length == 0) {
				System.out.println("map中键的名称为：" +key + "；值为空");
				continue;
			}
			//写死直接取第一个值
			String value = values[0];//属性的值
			//key 为id； 拼接后： setId
			String methodName = "set" + key.substring(0, 1).toUpperCase() +key.substring(1);
			try {
//				根据参数名称获取属性对象
				Field field = clazz.getDeclaredField(key);
//				根据方法名称获取方法
				Method method = clazz.getMethod(methodName, field.getType());
				//执行方法
				method.invoke(obj, parseType(field,value));
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
		}
		return obj;
	}
	
	/**
	 * 根据属性转换为对应的属性类型
	 * @param field
	 * @param value
	 * @return
	 * @throws ParseException
	 */
	private static Object parseType(Field field,String value) throws ParseException {
//		Class typeClass = field.getType();
		Object obj = null;
		String typeName = field.getType().getName();
		if(Date.class.getName().equals(typeName)) {
			//字符串转换为日期
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			obj = sf.parse(value);
		}else if(Integer.class.getName().equals(typeName)) {
			//字符串转换为数字
			obj = Integer.parseInt(value);
		}else {
			obj = value;
		}
		return obj;
	}
	
	
	
	
	public static void main(String[] args) throws ClassNotFoundException {
//		Map<String, String[]> map = new HashMap<>();
//		String[] id = {"12"},account = {"张三"},password= {"123456"},birthday= {"2017-03-03"};
//		map.put("id", id);
//		map.put("account", account);
//		map.put("password", password);
//		map.put("birthday", birthday);
//		User user = JsonUtil.mapToBean(map, User.class);
//		System.out.println(user);
//		类加载器
//		System.out.println(JsonUtil.class.getClassLoader());
//		System.out.println(JsonUtil.class.getClassLoader().getParent());
//		System.out.println(JsonUtil.class.getClassLoader().getParent().getParent());
		
		Class userClass = Class.forName("com.web.model.User");
		ClassLoader loader = JsonUtil.class.getClassLoader();
		Class.forName("com.web.model.User", true, loader);
		System.out.println(userClass.getClassLoader());
	
	}
	
	
	
	
	
	
	
	
	
	
}
