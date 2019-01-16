package com.web.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.web.dao.UserDao;
import com.web.model.User;
import com.web.util.JdbcUtil;

public class UserDaoImpl implements UserDao {


	
	@Override
	public void add(User user) {
		String sql = "insert into user(account,password,name)"
				+ " values('"+ user.getAccount() +"',"
						+ "'"+ user.getPassword()+"',"
								+ "'"+ user.getName()+"')";
		JdbcUtil.execute(sql);
	}

	@Override
	public void mod(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void del(int id) {
		String sql = "delete from user where id = " + id;
		JdbcUtil.execute(sql );
	}

	@Override
	public void query(User user) {
		// TODO Auto-generated method stub

	}

}
