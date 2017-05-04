package com.qingting.customer.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qingting.customer.baseserver.UserService;
import com.qingting.customer.common.pojo.hbasedo.User;
import com.smart.mvc.validator.Validator;
import com.smart.mvc.validator.annotation.ValidateParam;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags="注册")
@Controller
@RequestMapping("/reg")
public class RegisterController {
	@Resource
	UserService userService;
	@ApiOperation("初始页")
	@RequestMapping(method = RequestMethod.GET)
	public String execute(){
		return "/register";
	}
	@ApiOperation("注册用户")
	@RequestMapping(value="/reg",method = RequestMethod.POST)
	public String register(
			@ApiParam(value = "手机号", required = true) @ValidateParam({ Validator.MOBILE }) String phone,
			@ApiParam(value = "密码", required = true) @ValidateParam({ Validator.PASSWORD }) String password,
			@ApiParam(value = "验证码", required = true) @ValidateParam({ Validator.NOT_BLANK }) String code
			){
		User user=new User();
		user.setAccount(phone);
		userService.insertUser(user);
		return "/home";
	}
}
