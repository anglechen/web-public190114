package com.web.dao.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.web.model.User;
import com.web.util.JdbcUtil;

public class UserDaoImplTest {

	@Test
	public void testAdd() {
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		User user = new User();
		user.setAccount("test4");
		user.setPassword("99999999");
		user.setName("王五");
		userDaoImpl.add(user);
	}

	@Test
	public void testMod() {
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		User user = new User();
		user.setAccount("admin2");
		user.setPassword("66666666");
		user.setName("测试管理员");
		user.setId(6);
		userDaoImpl.mod(user);
	}

	@Test
	public void testDel() {
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		userDaoImpl.del(6);
		userDaoImpl.del(7);
	}

	@Test
	public void testQuery() {
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		User user = new User();
		user.setAccount("admin%' or '1'='1");
//		user.setPassword("123456");
		List<User> results = userDaoImpl.query(user);
		System.out.println("记录的总数" + results.size());
		System.out.println(results);
	}
	
	@Test
	public void test2() {
		List list = new ArrayList<>();
		list.add(111);
		list.add("232");
		list.add(new User());
	}
	
	
	
	
	@Test
	public void testInsert2() {
		String sql = "insert into user(account) values('事务3')";
		JdbcUtil.executeWorks(sql);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	@Test
	public void testQuery2() {
		String sql = "select * from user where id !='' ";
		List<User> lists = JdbcUtil.executeQuery(sql, User.class);
		System.out.println(lists);
	}

}
