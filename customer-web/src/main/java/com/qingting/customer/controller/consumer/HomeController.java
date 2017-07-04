package com.qingting.customer.controller.consumer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qingting.customer.common.pojo.common.MsgType;
import com.qingting.customer.common.pojo.dto.HomeMonitorDTO;
import com.smart.mvc.model.ResultCode;
import com.smart.mvc.model.WebResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "首页相关")
@Controller("homeController")
@RequestMapping("/consumer/home")
public class HomeController {
	@ApiOperation("页面跳转-用户主页")
	@RequestMapping(method = RequestMethod.GET)
	public String execute(){
		return "/consumer/home";
	}
	@ApiOperation("查询置顶设备监测数据")
	@RequestMapping(value="/listStickMonitor",method = RequestMethod.GET)
	public @ResponseBody WebResult<HomeMonitorDTO> listStickMonitor(
			HttpServletRequest request
			){
		//SessionUser sessionUser = SessionUtils.getSessionUser(request);
		//String account = sessionUser.getAccount();
		//这里查询用户的置顶设备监测数据
		
		HomeMonitorDTO homeMonitor=new HomeMonitorDTO();
		homeMonitor.setMoitorCount(1000);
		homeMonitor.setServiceCount(2);
		homeMonitor.setFlow(1237.0000f);
		homeMonitor.setHumidity(25f);
		homeMonitor.setLeak(false);
		homeMonitor.setPurTds(20.00f);
		homeMonitor.setRawTds(100.00f);
		homeMonitor.setTemp(24.0f);
		homeMonitor.setMsgType(MsgType.WARN.ordinal());
		WebResult<HomeMonitorDTO> result=new WebResult<HomeMonitorDTO>(ResultCode.SUCCESS);
		result.setData(homeMonitor);
		return result;
	}
}
