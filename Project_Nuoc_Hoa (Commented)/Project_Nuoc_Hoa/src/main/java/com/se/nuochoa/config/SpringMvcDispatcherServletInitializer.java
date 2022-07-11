package com.se.nuochoa.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { AppConfig.class }; // Cấu hình Servlet theo class AppConfig
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };   // Cấu hình Servlet Mapping dưới dạng "/"
	}
}
