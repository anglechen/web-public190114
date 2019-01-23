package com.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.model.User;
import com.web.service.UserService;
import com.web.service.impl.UserServiceImpl;
import com.web.util.JsonUtil;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	private UserService userService = new UserServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		List list = userService.query(JsonUtil.mapToJavaObject(req.getParameterMap(), User.class));
		PrintWriter print = resp.getWriter();
		if(list.size() > 0) {
			HttpSession session = req.getSession();
			System.out.println("session的id" + session.getId());
			session.setAttribute("name", req.getParameter("account"));
			print.write("success");
		}else {
			print.write("fail");
		}
		
	}
	
	
	
	
	
}
