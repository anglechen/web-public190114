package com.web.oop.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.web.oop.Teacher;

public class CollectionTest {

	public static void main(String[] args) {
//		testList();
//		testSet();
		testSetTeacher();
//		testMap();
	}
	
	public static void testMap() {
		Map<Object, Object> map = new HashMap<>();
		map.put("name", "张三");
		map.put("sex", "男");
		map.put("age", 23);
		map.put("name", "李四");
		System.out.println(map);
		System.out.println(map.get("name"));
	}
	
	public static void testSetTeacher() {
		Teacher t1 = new Teacher();
		Teacher t2 = new Teacher();
		Teacher t3 = new Teacher();
		t1.setName("张三");
		t2.setName("李四");
		t3.setName("李四");
//		System.out.println("t2 equlas t3: " +(t2.equals(t3)));
		Set<Object> set = new HashSet<>();
//		System.out.println("t1:" + t1.hashCode());
//		System.out.println("t2:" +t2.hashCode());
//		System.out.println("t3:" +t3.hashCode());
		set.add(t1);
		set.add(t2);
		set.add(t3);
		System.out.println(set);
	}
	
	public static void testSet() {
		Set<Object> set = new HashSet<>();
		set.add(123);
		set.add(456);
		set.add(999);
		set.add(123);
		System.out.println(set);
		Iterator<Object> iterator = set.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	
	}
	
	public static void testList() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(123);
		list.add(456);
		list.add(789);
		list.add(123);
		System.out.println(list);
		System.out.println("list的长度"+list.size());
		System.out.println(list.get(list.size() - 1));
	}

}
