package com.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.web.model.User;
import com.web.service.UserService;
import com.web.service.impl.UserServiceImpl;
import com.web.util.JsonUtil;

@WebServlet("/user/list")
public class UserListServlet extends HttpServlet {

	private UserService userService = new UserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("utf-8");
//		resp.setCharacterEncoding("utf-8");
		Map<String, String[]> parameters = req.getParameterMap();
		User user = JsonUtil.mapToJavaObject(parameters, User.class);
		List<User> results = userService.query(user);
		/*req.setAttribute("results", results);
		req.getRequestDispatcher("userList.jsp").forward(req, resp);*/
		JSONObject json = new JSONObject();
		json.put("result", results);
//		resp.setContentType("application/json,charset=utf-8");
		PrintWriter print = resp.getWriter();
		print.write(json.toJSONString());
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
