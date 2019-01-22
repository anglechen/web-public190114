package com.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.web.model.User;
import com.web.service.UserService;
import com.web.service.impl.UserServiceImpl;
import com.web.util.JsonUtil;

@WebServlet("/user/add")
public class UserAddServlet extends HttpServlet {

	private UserService userService = new UserServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		/*User user = new User();
		 String account = req.getParameter("account");
		String password = req.getParameter("password");
		String name = req.getParameter("name");*/
		
		/*user.setAccount(account);
		user.setPassword(password);
		user.setName(name);*/
		userService.add(JsonUtil.mapToJavaObject(req.getParameterMap(), User.class));
		//解决返回中午乱码问题
		resp.setCharacterEncoding("utf-8");
		PrintWriter writer = resp.getWriter();
		writer.write("新增成功");
		writer.close();
	}
	
	
	
	
	
}
