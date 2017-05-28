package com.qingting.customer.controller.admin;

import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qingting.customer.baseserver.MonitorService;
import com.qingting.customer.common.pojo.hbasedo.Monitor;
import com.smart.mvc.model.Result;
import com.smart.mvc.validator.Validator;
import com.smart.mvc.validator.annotation.ValidateParam;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "监测相关")
@Controller
@RequestMapping("/monitor")
public class MonitorController {
	@Resource
	MonitorService monitorService;
	@ApiOperation("监测页面")
	@RequestMapping(method = RequestMethod.GET)
	public String execute(){
		return "/monitor";
	}
	@ApiOperation("插入监测值")
	@RequestMapping(value="/insert",method = RequestMethod.POST)
	public @ResponseBody Result insertMonitor(
			@ApiParam @RequestBody Monitor monitor
			){
		
		return null;
	}
	@ApiOperation("根据行健查询某个监测值")
	@RequestMapping(value="/get",method = RequestMethod.POST)
	public @ResponseBody Result getMonitor(
			@ApiParam(value = "行健", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK })String rowKey
			){
		//别忘记验证传参和用户身份是否匹配
		System.out.println("rowKey:"+rowKey);
		//Calendar startCal = DateUtil.getDate(2017, 4, 7, 9, 42, 55, 790);
		Monitor monitor= monitorService.getMonitorByRowKey(rowKey);
		System.out.println("monitor:"+monitor);
		Result result = Result.createSuccessResult();
		result.setData(monitor);
		return result;
	}
	@ApiOperation("查询某个时间段的监测值")
	@RequestMapping(value="/list",method = RequestMethod.POST)
	public @ResponseBody Result listMonitor(
			@ApiParam(value = "设备ID", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK })Integer equipId,
			@ApiParam(value = "查询的起始时间", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK })GregorianCalendar startCalendar,
			@ApiParam(value = "查询的结束时间", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK })GregorianCalendar endCalendar
			){
		//别忘记验证传参和用户身份是否匹配
		//Calendar startCal = DateUtil.getDate(2017, 4, 7, 9, 42, 55, 790);
		System.out.println("输入参数"+equipId+" "+startCalendar+" "+endCalendar);
		List<Monitor> list = monitorService.listMonitorByStartAndEndOfCalendar(equipId, startCalendar, endCalendar);
		Result result = Result.createSuccessResult();
		result.setData(list);
		return result;
	}
}
