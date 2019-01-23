package com.web.util;

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
}
