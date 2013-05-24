package com.marthym.oikonomos.server.utils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class WebAppPropertiesListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		String rootPath = sce.getServletContext().getRealPath("/");
		System.setProperty("webApplicationRoot", rootPath);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {}
}
