package com.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ServiceListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("正在初始化servletcontext");
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("正在销毁servletcontext");
		
	}

}
