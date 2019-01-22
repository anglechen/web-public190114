package com.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*使用注解的形式配置servlet，跟web.xml中配置是一致*/
@WebServlet("/testHttp")
public class TestHttpServlet extends HttpServlet {
	
	

	@Override
	public void init() throws ServletException {
		System.out.println("==========start===========");
		System.out.println("正在初始化testhttpservlet");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter print = resp.getWriter();
		print.write("this is a get");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter print = resp.getWriter();
		print.write("this is a post");
	}

	
}
