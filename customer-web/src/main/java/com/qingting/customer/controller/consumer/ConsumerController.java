package com.qingting.customer.controller.consumer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(tags = "客户端首页")
@Controller
@RequestMapping("/consumer/home")
public class ConsumerController {
	@ApiOperation("页面跳转-用户主页")
	@RequestMapping(method = RequestMethod.GET)
	public String execute(){
		return "/consumer/home";
	}
}
