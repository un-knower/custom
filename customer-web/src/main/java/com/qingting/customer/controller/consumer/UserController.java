package com.qingting.customer.controller.consumer;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qingting.customer.baseserver.UserService;
import com.qingting.customer.common.pojo.dto.MyDTO;
import com.qingting.customer.common.pojo.hbasedo.User;
import com.smart.mvc.model.ResultCode;
import com.smart.mvc.model.WebResult;
import com.smart.sso.client.SessionUser;
import com.smart.sso.client.SessionUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "用户相关")
@Controller
@RequestMapping("/consumer/user")
public class UserController {
	@Resource
	UserService userService;
	@ApiOperation("页面跳转-我的页面")
	@RequestMapping(method = RequestMethod.GET)
	public String execute(){
		return "/consumer/user";
	}
	/*@ApiOperation("获取当前登陆用户的信息")
	@RequestMapping(value="/get",method = RequestMethod.POST)
	public WebResult<User> getUser(HttpServletRequest request){
		SessionUser sessionUser = SessionUtils.getSessionUser(request);
		String account = sessionUser.getAccount();
		System.out.println("account:"+account);
		User user = userService.getUserByAccount(account);
		WebResult<User> result=new WebResult<User>(ResultCode.SUCCESS);
		result.setData(user);
		return result;
	}*/
	@ApiOperation("获取当前登陆用户的信息")
	@RequestMapping(value="/get",method = RequestMethod.GET)
	public @ResponseBody WebResult<MyDTO> getUserMsg(HttpServletRequest request){
		/*SessionUser sessionUser = SessionUtils.getSessionUser(request);
		String account = sessionUser.getAccount();
		System.out.println("account:"+account);
		User user = userService.getUserByAccount(account);
		WebResult<User> result=new WebResult<User>(ResultCode.SUCCESS);
		result.setData(user);*/
		WebResult<MyDTO> result=new WebResult<MyDTO>(ResultCode.SUCCESS);
		MyDTO myDTO=new MyDTO();
		myDTO.setAttentEquip(2);
		myDTO.setMineEquip(2);
		myDTO.setName("最可爱的人");
		myDTO.setPath("/resource/images/customer/head/zlf.png");
		result.setData(myDTO);
		result.setMessage("获取成功");
		return result;
	}
}
