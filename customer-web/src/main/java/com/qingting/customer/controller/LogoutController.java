package com.qingting.customer.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.smart.mvc.validator.Validator;
import com.smart.mvc.validator.annotation.ValidateParam;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "单点登出")
@Controller
@RequestMapping("/logout")
public class LogoutController {
	@ApiOperation("登出")
	@RequestMapping(method = RequestMethod.GET,produces="text/html")
	public String logout(HttpServletRequest request,
			@ApiParam(value = "你是客户端还是后台？例:只有传参(admin)返回后台登陆页，不传参或其他参数返回客户端登陆页", required = false) @RequestParam(value="type", required=false) String type
			) {
		return "/login/consumer";
	}
}
