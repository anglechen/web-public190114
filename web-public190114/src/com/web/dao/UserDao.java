package com.web.dao;

import java.util.List;

import com.web.model.User;

public interface UserDao {
	/**
	 * 新增操作
	 * @param user
	 */
	public void add(User user);
	/**
	 * 修改操作
	 * @param user
	 */
	public void mod(User user);
	/**
	 * 删除操作
	 * @param id
	 */
	public void del(int id);
	/**
	 * 查询操作
	 * @param user
	 */
	public List<User> query(User user);
}
