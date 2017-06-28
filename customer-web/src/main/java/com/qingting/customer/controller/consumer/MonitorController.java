package com.qingting.customer.controller.consumer;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qingting.customer.baseserver.MonitorService;
import com.qingting.customer.common.pojo.dto.MonitorDTO;
import com.qingting.customer.common.pojo.hbasedo.Monitor;
import com.smart.mvc.model.ResultCode;
import com.smart.mvc.model.WebResult;
import com.smart.mvc.validator.Validator;
import com.smart.mvc.validator.annotation.ValidateParam;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "监测相关")
@Controller("consumerMonitorController")
@RequestMapping("/consumer/monitor")
public class MonitorController {
	@Resource
	MonitorService monitorService;
	@ApiOperation("页面跳转-监测页面")
	@RequestMapping(method = RequestMethod.GET)
	public String execute(){
		return "/consumer/monitor";
	}
	@ApiOperation("根据行健查询某个监测值")
	@RequestMapping(value="/get",method = RequestMethod.POST)
	public @ResponseBody WebResult<Monitor> getMonitor(
			@ApiParam(value = "行健", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK })String rowKey
			){
		//别忘记验证传参和用户身份是否匹配
		System.out.println("rowKey:"+rowKey);
		//Calendar startCal = DateUtil.getDate(2017, 4, 7, 9, 42, 55, 790);
		Monitor monitor= monitorService.getMonitorByRowKey(rowKey);
		System.out.println("monitor:"+monitor);
		WebResult<Monitor> result=new WebResult<Monitor>(ResultCode.SUCCESS);
		result.setData(monitor);
		return result;
	}
	/*@ApiOperation("查询某个时间段的监测值")
	@RequestMapping(value="/list",method = RequestMethod.POST)
	public @ResponseBody WebResult<List<Monitor>> listMonitor(
			@ApiParam(value = "设备ID", required = false) @RequestParam Integer equipId,
			@ApiParam(value = "查询的起始时间", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK })GregorianCalendar startCalendar,
			@ApiParam(value = "查询的结束时间", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK })GregorianCalendar endCalendar
			){
		//别忘记验证传参和用户身份是否匹配
		//Calendar startCal = DateUtil.getDate(2017, 4, 7, 9, 42, 55, 790);
		System.out.println("输入参数"+equipId+" "+startCalendar+" "+endCalendar);
		List<Monitor> list = monitorService.listMonitorByStartAndEndOfCalendar(equipId, startCalendar, endCalendar);
		WebResult<List<Monitor>> result=new WebResult<List<Monitor>>(ResultCode.SUCCESS);
		result.setData(list);
		return result;
	}
	
	@ApiOperation("查询最新时间段的监测值")
	@RequestMapping(value="/listNew",method = RequestMethod.POST)
	public @ResponseBody WebResult<List<Monitor>> listNewMonitor(
			@ApiParam(value = "设备ID", required = false) @RequestParam Integer equipId
			){
		//别忘记验证传参和用户身份是否匹配
		//Calendar startCal = DateUtil.getDate(2017, 4, 7, 9, 42, 55, 790);
		System.out.println("输入参数"+equipId);
		List<Monitor> list = monitorService.listMonitorofNew(equipId);
		WebResult<List<Monitor>> result=new WebResult<List<Monitor>>(ResultCode.SUCCESS);
		result.setData(list);
		return result;
	}*/
	@ApiOperation("查询某个时间段的监测值")
	@RequestMapping(value="/list",method = RequestMethod.POST)
	public @ResponseBody WebResult<MonitorDTO> listMonitor(
			@ApiParam(value = "设备ID", required = false) @RequestParam(value="equipId", required=false) Integer equipId,
			@ApiParam(value = "查询的结束时间", required = true,example="2017-01-01 12:00:00") @RequestParam @ValidateParam({ Validator.NOT_BLANK })GregorianCalendar endCalendar
			){
		//别忘记验证传参和用户身份是否匹配
		//Calendar startCal = DateUtil.getDate(2017, 4, 7, 9, 42, 55, 790);
		System.out.println("输入参数:"+equipId+" "+endCalendar);
		MonitorDTO monitorDTO=new MonitorDTO();
		monitorDTO.setUserName("武双");
		List<Float> purDatas=new ArrayList<Float>();
		purDatas.add(9.7f);
		purDatas.add(5.8f);
		purDatas.add(17.3f);
		purDatas.add(5.8f);
		monitorDTO.setPurDatas(purDatas);
		
		List<Float> rawDatas=new ArrayList<Float>();
		rawDatas.add(17.3f);
		rawDatas.add(38.2f);
		rawDatas.add(12.3f);
		rawDatas.add(23.2f);
		monitorDTO.setRawDatas(rawDatas);
		List<Calendar> secondDates =new ArrayList<Calendar>();
		Calendar cal1 = Calendar.getInstance();
		secondDates.add(cal1);
		
		Calendar cal2=Calendar.getInstance();
		cal2.setTimeInMillis(cal1.getTimeInMillis()-5000);
		secondDates.add(cal2);
		
		Calendar cal3=Calendar.getInstance();
		cal3.setTimeInMillis(cal2.getTimeInMillis()-5000);
		secondDates.add(cal3);
		
		Calendar cal4=Calendar.getInstance();
		cal4.setTimeInMillis(cal3.getTimeInMillis()-5000);
		secondDates.add(cal4);
		
		monitorDTO.setSecondDates(secondDates);
		WebResult<MonitorDTO> result=new WebResult<MonitorDTO>(ResultCode.SUCCESS);
		result.setData(monitorDTO);
		return result;
	}
	
	@ApiOperation("查询最新时间段的监测值")
	@RequestMapping(value="/listNew",method = RequestMethod.POST)
	public @ResponseBody WebResult<MonitorDTO> listNewMonitor(
			@ApiParam(value = "设备ID", required = false) @RequestParam Integer equipId
			){
		System.out.println("输入参数:"+equipId);
		MonitorDTO monitorDTO=new MonitorDTO();
		monitorDTO.setUserName("武双");
		List<Float> purDatas=new ArrayList<Float>();
		purDatas.add(9.7f);
		purDatas.add(5.8f);
		purDatas.add(17.3f);
		purDatas.add(5.8f);
		monitorDTO.setPurDatas(purDatas);
		
		List<Float> rawDatas=new ArrayList<Float>();
		rawDatas.add(17.3f);
		rawDatas.add(38.2f);
		rawDatas.add(12.3f);
		rawDatas.add(23.2f);
		monitorDTO.setRawDatas(rawDatas);
		List<Calendar> secondDates =new ArrayList<Calendar>();
		Calendar cal1 = Calendar.getInstance();
		secondDates.add(cal1);
		
		Calendar cal2=Calendar.getInstance();
		cal2.setTimeInMillis(cal1.getTimeInMillis()-5000);
		secondDates.add(cal2);
		
		Calendar cal3=Calendar.getInstance();
		cal3.setTimeInMillis(cal2.getTimeInMillis()-5000);
		secondDates.add(cal3);
		
		Calendar cal4=Calendar.getInstance();
		cal4.setTimeInMillis(cal3.getTimeInMillis()-5000);
		secondDates.add(cal4);
		
		monitorDTO.setSecondDates(secondDates);
		WebResult<MonitorDTO> result=new WebResult<MonitorDTO>(ResultCode.SUCCESS);
		result.setData(monitorDTO);
		return result;
	}
}
