package com.web.dao.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import com.web.model.User;

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
		fail("Not yet implemented");
	}

	@Test
	public void testDel() {
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		userDaoImpl.del(6);
		userDaoImpl.del(7);
	}

	@Test
	public void testQuery() {
		fail("Not yet implemented");
	}

}
