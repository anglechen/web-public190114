package com.web.service.impl;

import java.util.List;

import com.web.dao.UserDao;
import com.web.dao.impl.UserDaoImpl;
import com.web.model.User;
import com.web.service.UserService;
/**
 * 用户的业务逻辑信息
 * @author Administrator
 *
 */
public class UserServiceImpl implements UserService {

	private UserDao userDao = new UserDaoImpl();
	
	@Override
	public void add(User user) {
		//处理业务
		userDao.add(user);
	}

	@Override
	public void mod(User user) {
		//处理业务
		userDao.mod(user);

	}

	@Override
	public void del(int id) {
		userDao.del(id);

	}

	@Override
	public List<User> query(User user) {
		return userDao.query(user);
	}

}
