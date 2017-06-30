package com.qingting.customer.controller.admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qingting.customer.baseserver.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "用户相关")
@Controller("adminUserController")
@RequestMapping("/admin/user")
public class UserController {
	@Resource
	UserService userService;
	@ApiOperation("用户管理-消费者用户")
	@RequestMapping(value="/consumer",method = RequestMethod.GET)
	public String consumer(){
		return "/admin/user/consumer";
	}
	@ApiOperation("用户管理-企业员工")
	@RequestMapping(value="/employee",method = RequestMethod.GET)
	public String employee(){
		return "/admin/user/employee";
	}
}
