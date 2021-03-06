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
		//设置请求，以及相应的编码为utf-8
//		req.setCharacterEncoding("utf-8");
//		resp.setCharacterEncoding("utf-8");
		userService.add(JsonUtil.mapToJavaObject(req.getParameterMap(), User.class));
		//解决返回中文乱码问题
		PrintWriter writer = resp.getWriter();
		JSONObject json = new JSONObject();
		json.put("result", "success");
//		resp.setContentType("application/json,charset=utf-8");
		writer.write(json.toJSONString());
	}
	
	
	
	
	
}
