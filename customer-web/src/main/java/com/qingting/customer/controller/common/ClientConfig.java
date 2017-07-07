package com.qingting.customer.controller.common;

import com.smart.mvc.config.ConfigUtils;
import com.smart.sso.client.Config;

public class ClientConfig extends Config {
	
	// 最新监测数据查询的时间宽度
	protected static String searchTimeWide = ConfigUtils.getProperty("customer.new-monitor.time");

	public static String getSearchTimeWide() {
		return searchTimeWide;
	}

	public static void setSearchTimeWide(String searchTimeWide) {
		ClientConfig.searchTimeWide = searchTimeWide;
	}
	
	
}
