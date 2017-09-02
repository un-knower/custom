package com.qingting.customer.controller.consumer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qingting.customer.model.Monitor;
import com.qingting.customer.model.User;
import com.qingting.customer.model.dto.MonitorDTO;
import com.qingting.customer.controller.common.SessionUserMsg;
import com.qingting.customer.controller.common.SessionUserMsgUtils;
import com.qingting.customer.server.MonitorService;
import com.smart.mvc.config.ConfigUtils;
import com.smart.mvc.model.ResultCode;
import com.smart.mvc.model.WebResult;
import com.smart.mvc.util.StringUtils;
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
	@ApiOperation("查询用户置顶设备的最新监测数据")
	@RequestMapping(value="/listTopMonitorOfNew",method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public @ResponseBody WebResult<Monitor> listTopMonitorOfNew(
			HttpServletRequest request
			){
		SessionUserMsg sessionUserMsg = SessionUserMsgUtils.getSessionUserMsg(request);
		User user = (User)sessionUserMsg.getProfile();
		Monitor monitor = monitorService.listTopMonitorOfNew(user.getId());
		WebResult<Monitor> result=new WebResult<Monitor>(ResultCode.SUCCESS);
		result.setData(monitor);
		result.setMessage("查询成功");
		return result;
	}
	@ApiOperation("查询某个时间段的监测值")
	@RequestMapping(value="/list",method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public @ResponseBody WebResult<MonitorDTO> listMonitor(
			@ApiParam(value = "设备编号", required = false) @RequestParam(value="equipCode", required=false) String equipCode,
			@ApiParam(value = "查询的结束时间", required = false,example="2017-01-01 12:00:00") @RequestParam(value="endTime", required=false)String endTime,
			@ApiParam(value = "查询类型(按天查询时必须)", required = false,example="day代表按天查询") @RequestParam(value="type", required=false)String type
			
			){
		//别忘记验证传参和用户身份是否匹配
		System.out.println("输入参数:equipCode="+equipCode+".endTime="+endTime+".type="+type);
		Date d=null;
		Calendar cal=null;
		if(!StringUtils.isBlank(endTime)){
			try {
				d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(endTime);
				cal = Calendar.getInstance();
				cal.setTime(d);
			} catch (ParseException e) {
				e.printStackTrace();
				WebResult<MonitorDTO> failure=new WebResult<MonitorDTO>(ResultCode.FAILURE);
				failure.setMessage("日期格式异常");
				return failure;
			}
		}
		MonitorDTO md=convertToMonitorDTO(monitorService.listMonitorByEndTime("211701000001", type, 20, cal));
		WebResult<MonitorDTO> result=new WebResult<MonitorDTO>(ResultCode.SUCCESS);
		result.setData(md);
		return result;
	}
	private MonitorDTO convertToMonitorDTO(List<Monitor> list){
		MonitorDTO md=new MonitorDTO();
		md.setUserName("最可爱的人");
		List<Float> purDatas=new ArrayList<Float>();
		List<Float> rawDatas=new ArrayList<Float>();
		List<Calendar> secondDates=new ArrayList<Calendar>();
		for (Monitor monitor : list) {
			purDatas.add(monitor.getPurTds());
			rawDatas.add(monitor.getRawTds());
			secondDates.add(monitor.getCollectTime());
		}
		md.setPurDatas(purDatas);
		md.setRawDatas(rawDatas);
		md.setSecondDates(secondDates);
		
		return md;
	}
	/*@ApiOperation("查询某个时间段的监测值")
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
		//List<Monitor> list = monitorService.listMonitorOfNew(equipCode, Long.valueOf(ConfigUtils.getProperty("customer.new-monitor.time")));
		
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
	}*/
}
