package com.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.web.service.UserService;
import com.web.service.impl.UserServiceImpl;

@WebServlet("/user/del")
public class UserDelServlet extends HttpServlet{
	private UserService userService = new UserServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("utf-8");
//		resp.setCharacterEncoding("utf-8");
		String id = req.getParameter("id");
		JSONObject json = new JSONObject();
		if(id !=null && !"".equals(id)) {
			userService.del(Integer.parseInt(id));
			json.put("result", "success");
		}else {
			json.put("result", "error");
		}
//		resp.setContentType("application/json,charset=utf-8");
		PrintWriter print = resp.getWriter();
		print.write(json.toJSONString());
		
		
	}
	
	
	
	
}
