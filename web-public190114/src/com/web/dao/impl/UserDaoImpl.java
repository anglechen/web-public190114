package com.web.dao.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import com.web.dao.UserDao;
import com.web.model.User;
import com.web.util.JdbcUtil;

public class UserDaoImpl implements UserDao {


	
	@Override
	public void add(User user) {
		Date date = user.getBirthday();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		String sql = "insert into user(account,password,name,age,status,birthday)"
				+ " values('"+ user.getAccount() +"',"
				+ "'"+ user.getPassword()+"', '"+ user.getName()+"',"
						+ ""+ user.getAge()+","+ user.getStatus()+",'"+ sf.format(date) +"')";
		JdbcUtil.execute(sql);
	}

	@Override
	public void mod(User user) {
		String sql = "update user set account ='"+ user.getAccount()+"' "
				+ ", password = '"+ user.getPassword()+"'"
						+ ",name = '"+user.getName()+ "' "
								+ "where id = " + user.getId();
		JdbcUtil.execute(sql);

	}

	@Override
	public void del(int id) {
		String sql = "delete from user where id = " + id;
		JdbcUtil.execute(sql );
	}

	@Override
	public List<User> query(User user) {
		String sql = "select * from user where id !='' ";
		if(user.getAccount() !=null && user.getAccount() !="") {
			sql += " and account like '" + user.getAccount() + "'";
		}
		if(user.getPassword()!=null && user.getPassword() !="") {
			sql += " and password = '" +user.getPassword() + "'";
		}
		if(user.getName() !=null && user.getName() !="") {
			sql += " and name = '" + user.getName() + "'";
		}
		if(user.getAge() !=null) {
			sql += " and age = " + user.getAge();
		}
		return JdbcUtil.executeQueryF(sql, User.class);
	}

	
	
	
	
	
	
}