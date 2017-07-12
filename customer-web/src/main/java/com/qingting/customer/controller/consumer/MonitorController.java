package com.qingting.customer.controller.consumer;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

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
	@RequestMapping(method = RequestMethod.GET,consumes="text/html")
	public String execute(){
		return "/consumer/monitor";
	}
	
	@ApiOperation("查询某个时间段的监测值")
	@RequestMapping(value="/list",method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public @ResponseBody WebResult<MonitorDTO> listMonitor(
			@ApiParam(value = "设备编号", required = false) @RequestParam(value="equipCode", required=false) String equipCode,
			@ApiParam(value = "查询的结束时间", required = true,example="2017-01-01 12:00:00") @RequestParam @ValidateParam({ Validator.NOT_BLANK })GregorianCalendar endCalendar
			){
		//别忘记验证传参和用户身份是否匹配
		//Calendar startCal = DateUtil.getDate(2017, 4, 7, 9, 42, 55, 790);
		System.out.println("输入参数:"+equipCode+" "+endCalendar);
		
		WebResult<MonitorDTO> result=new WebResult<MonitorDTO>(ResultCode.SUCCESS);
		result.setData(getMonitorDTO(endCalendar));
		return result;
	}
	
	@ApiOperation("查询最新时间段的监测值")
	@RequestMapping(value="/listNew",method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public @ResponseBody WebResult<MonitorDTO> listNewMonitor(
			@ApiParam(value = "设备编号", required = false) @RequestParam(value="equipCode", required=false) String equipCode
			){
		System.out.println("输入参数:"+equipCode);
		
		
		WebResult<MonitorDTO> result=new WebResult<MonitorDTO>(ResultCode.SUCCESS);
		result.setData(getMonitorDTO(Calendar.getInstance()));
		return result;
	}
	public MonitorDTO getMonitorDTO(Calendar cal){
		MonitorDTO monitorDTO=new MonitorDTO();
		monitorDTO.setUserName("武双");
		
		List<Float> purDatas=new ArrayList<Float>();
		int random=new Random().nextInt(15);
		for(int i=0;i<random;i++){
			purDatas.add(new Random().nextFloat()*20);
		}
		monitorDTO.setPurDatas(purDatas);
		
		List<Float> rawDatas=new ArrayList<Float>();
		for(int i=0;i<random;i++){
			rawDatas.add(new Random().nextFloat()*200);
		}
		monitorDTO.setRawDatas(rawDatas);
		
		List<Calendar> secondDates =new ArrayList<Calendar>();
		Calendar cal1 = cal;
		secondDates.add(cal1);
		Calendar temp=cal1;
		for(int i=0;i<random-1;i++){
			Calendar cal2=Calendar.getInstance();
			cal2.setTimeInMillis(temp.getTimeInMillis()-30000/random);
			secondDates.add(cal2);
			temp=cal2;
		}
		
		monitorDTO.setSecondDates(secondDates);
		return monitorDTO;
	}
}
