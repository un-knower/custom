package com.qingting.customer.controller.admin;

import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qingting.customer.baseserver.MonitorService;
import com.qingting.customer.common.pojo.hbasedo.Monitor;
import com.qingting.customer.common.pojo.model.Pagination;
import com.qingting.customer.controller.common.ClientConfig;
import com.qingting.customer.controller.common.ClientConfigInit;
import com.smart.mvc.model.ResultCode;
import com.smart.mvc.model.WebResult;
import com.smart.mvc.validator.Validator;
import com.smart.mvc.validator.annotation.ValidateParam;

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
	
	@ApiOperation("查询某个时间段的监测值")
	@RequestMapping(value="/listMonitorByTime",method = RequestMethod.POST)
	public @ResponseBody WebResult<List<Monitor>> listMonitorByTime(
			@ApiParam(value = "设备编号", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK })String equipCode,
			@ApiParam(value = "查询的起始时间", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK })GregorianCalendar startTime,
			@ApiParam(value = "查询的结束时间", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK })GregorianCalendar endTime
			){
		//别忘记验证传参和用户身份是否匹配
		LOGGER.info("listMonitor equipCode {}.from {} to {}.",equipCode,startTime,endTime);
		List<Monitor> list = monitorService.listMonitorByStartTimeAndEndTime(equipCode, startTime, endTime);//(equipId, startCalendar, endCalendar);
		WebResult<List<Monitor>> result=new WebResult<List<Monitor>>(ResultCode.SUCCESS);
		result.setData(list);
		return result;
	}
	
	@ApiOperation("查询最新时间段的监测值")
	@RequestMapping(value="/listNew",method = RequestMethod.POST)
	public @ResponseBody WebResult<List<Monitor>> listNewMonitor(
			@ApiParam(value = "设备编号", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK })String equipCode
			){
		//别忘记验证传参和用户身份是否匹配
		LOGGER.info("listNewMonitor equipCode {}",equipCode);
		List<Monitor> list = monitorService.listMonitorOfNew(equipCode,Long.parseLong(ClientConfig.getSearchTimeWide()));
		WebResult<List<Monitor>> result=new WebResult<List<Monitor>>(ResultCode.SUCCESS);
		result.setData(list);
		return result;
	}
	@ApiOperation("查询所有监测值")
	@RequestMapping(value="/list",method = RequestMethod.GET)
	public @ResponseBody WebResult<Pagination<Monitor>> listMonitor(
			@ApiParam(value = "设备编号", required = false) @RequestParam(value="equipCode", required=false) String equipCode,
			@ApiParam(value = "开始页码", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK }) Integer pageNo,
			@ApiParam(value = "显示条数", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK }) Integer pageSize
			){
		//别忘记验证传参和用户身份是否匹配
		Pagination<Monitor> page = monitorService.listMonitor(equipCode,pageNo,pageSize);
		WebResult<Pagination<Monitor>> result=new WebResult<Pagination<Monitor>>(ResultCode.SUCCESS);
		result.setData(page);
		return result;
	}
}
