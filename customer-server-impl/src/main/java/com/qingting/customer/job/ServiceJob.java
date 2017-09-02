package com.qingting.customer.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceJob {
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	public void execute(){
		System.out.println("判断定时服务是否到时..");
	}
}
