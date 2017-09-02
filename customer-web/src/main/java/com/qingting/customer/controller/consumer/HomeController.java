package com.qingting.customer.controller.consumer;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qingting.customer.model.Monitor;
import com.qingting.customer.model.User;
import com.qingting.customer.model.dto.HomeMonitorDTO;
import com.qingting.customer.controller.common.SessionUserMsg;
import com.qingting.customer.controller.common.SessionUserMsgUtils;
import com.qingting.customer.enums.MsgType;
import com.qingting.customer.server.EquipService;
import com.qingting.customer.server.MonitorService;
import com.smart.mvc.model.ResultCode;
import com.smart.mvc.model.WebResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "首页相关")
@Controller("homeController")
@RequestMapping("/consumer/home")
public class HomeController {
	@Resource
	MonitorService monitorService;
	@Resource
	EquipService equipService;
	
	@ApiOperation("页面跳转-用户主页")
	@RequestMapping(method = RequestMethod.GET,produces="text/html")
	public String execute(){
		return "/consumer/home";
	}
	@ApiOperation("查询置顶设备监测数据")
	@RequestMapping(value="/listStickMonitor",method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public @ResponseBody WebResult<HomeMonitorDTO> listStickMonitor(
			HttpServletRequest request
			){
		//SessionUser sessionUser = SessionUtils.getSessionUser(request);
		//String account = sessionUser.getAccount();
		//这里查询用户的置顶设备监测数据
		
		SessionUserMsg sessionUserMsg = SessionUserMsgUtils.getSessionUserMsg(request);
		User user = (User)sessionUserMsg.getProfile();
		
		Monitor monitor = monitorService.listTopMonitorOfNew(user.getId());
		
		WebResult<HomeMonitorDTO> result=null;
		if(monitor!=null){
			HomeMonitorDTO homeMonitor=new HomeMonitorDTO();
			
			homeMonitor.setAttentEquip(equipService.countAttent(user.getId()));
			homeMonitor.setFlow(monitor.getFlow());
			homeMonitor.setLeak(monitor.getLeak());
			homeMonitor.setMineEquip(equipService.countEquip(user.getId()));
			homeMonitor.setPurTds(monitor.getPurTds());
			homeMonitor.setRawTds(monitor.getRawTds());
			homeMonitor.setServiceCount(2);
			
			result=new WebResult<HomeMonitorDTO>(ResultCode.SUCCESS);
			result.setData(homeMonitor);
			result.setMessage("查询成功");
		}else{
			result=new WebResult<HomeMonitorDTO>(ResultCode.FAILURE);
			result.setMessage("无置顶设备");
		}
		return result;
		
		/*SessionUserMsg sessionUserMsg = SessionUserMsgUtils.getSessionUserMsg(request);
		User user = (User)sessionUserMsg.getProfile();
		Monitor monitor = monitorService.listTopMonitorOfNew(user.getId());
		WebResult<Monitor> result=new WebResult<Monitor>(ResultCode.SUCCESS);
		result.setData(monitor);
		result.setMessage("查询成功");
		return result;*/
	}
}
