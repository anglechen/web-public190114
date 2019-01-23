package com.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/user/*")
public class CharFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("正在初始化过滤器");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		//统一处理了编码，以及返回类型设置为json
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("applicaton/json,charset=utf-8");
		
		//验证是否登录
		HttpSession session = req.getSession();
		Object name  = session.getAttribute("name");
		if(name == null) {
			//如果没有登录就直接跳转到登录页面
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
			return;
		}
		
		chain.doFilter(request, response);
		
	}

	@Override
	public void destroy() {
		System.out.println("正在销毁过滤器");
		
	}

}
