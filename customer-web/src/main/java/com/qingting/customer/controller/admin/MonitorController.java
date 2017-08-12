package com.qingting.customer.controller.admin;


import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qingting.customer.baseserver.MonitorService;
import com.qingting.customer.common.pojo.hbasedo.Monitor;
import com.qingting.customer.common.pojo.model.Pagination;
import com.qingting.customer.controller.common.ClientConfigInit;
import com.smart.mvc.model.ResultCode;
import com.smart.mvc.model.WebResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "监测相关")
@Controller("adminMonitorController")
@RequestMapping("/admin/monitor")
public class MonitorController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ClientConfigInit.class);
	
	@Resource
	MonitorService monitorService;
	@ApiOperation("页面跳转-监测页面")
	@RequestMapping(value="/monitor",method = RequestMethod.GET)
	public String execute(){
		return "/admin/monitor/monitor";
	}
	
	@ApiOperation("查询所有监测值")
	@RequestMapping(value="/list",method = RequestMethod.POST)
	public @ResponseBody WebResult<Pagination<Monitor>> listMonitor(
			@ApiParam(value = "page", required = true) @RequestBody Pagination<Monitor> page
			){
		//别忘记验证传参和用户身份是否匹配
		Pagination<Monitor> newPage = monitorService.listMonitor(page);
		WebResult<Pagination<Monitor>> result=new WebResult<Pagination<Monitor>>(ResultCode.SUCCESS);
		result.setData(newPage);
		return result;
	}
}
