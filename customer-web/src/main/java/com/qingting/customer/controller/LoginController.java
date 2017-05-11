package com.qingting.customer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/login")
public class LoginController {
	@ApiOperation("客户端登陆页")
	@RequestMapping(method = RequestMethod.GET)
	public String execute(){
		System.out.println(this.getClass()+"客户端自定义登陆页面！login.jsp");
		return "/login";
	}
}
