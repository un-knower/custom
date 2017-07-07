package com.qingting.customer.controller.common;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.smart.mvc.config.ConfigUtils;
import com.smart.mvc.servlet.ConfigInitServlet;

public class ClientConfigInit extends ConfigInitServlet {
	
	private static final long serialVersionUID = 337209182036742487L;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ClientConfigInit.class);
	
	public ClientConfigInit() {
		super();
	}

	@Override
	public void init() throws ServletException{
		ServletContext servletContext = getServletContext();
		try {
			servletContext.setAttribute("_searchTimeWide", ConfigUtils.getProperty("customer.new-monitor.time"));
		}
		catch (Exception e) {
			LOGGER.error("系统初始化参数配置有误", e);
		}
	}
}
