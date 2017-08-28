package com.qingting.customer.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.qingting.customer.baseserver.MessageService;
import com.qingting.customer.baseserver.UserService;
import com.qingting.customer.common.pojo.hbasedo.User;
import com.smart.mvc.model.ResultCode;
import com.smart.mvc.model.WebResult;
import com.smart.mvc.validator.Validator;
import com.smart.mvc.validator.annotation.ValidateParam;
import com.smart.sso.client.Config;
import com.smart.sso.client.AuthRpcUtils;
import com.smart.sso.client.SessionUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags="注册")
@Controller
@RequestMapping("/register")
public class RegisterController {
	@Resource
	UserService userService;
	@Resource
	MessageService messageService;
	
	@ApiOperation("页面跳转-注册页面")
	@RequestMapping(method = RequestMethod.GET,produces="text/html")
	public String execute(){
		return "/register";
	}
	@ApiOperation("注册用户")
	@RequestMapping(value="/submit",method = RequestMethod.POST,produces = "application/json; charset=utf-8")
	//@ApiImplicitParam(paramType="query", name = "account", value = "手机号", required = true, dataType = "String")
	//@ApiImplicitParam(paramType="query", name = "password", value = "密码", required = true, dataType = "String")
	//@ApiImplicitParam(paramType="query", name = "validateCode", value = "验证码", required = true, dataType = "String")
	public @ResponseBody WebResult<Object> submit(
			HttpServletRequest request,
			@ApiParam(value = "手机号", required = true) @RequestParam @ValidateParam({ Validator.MOBILE }) String mobile,
			@ApiParam(value = "密码", required = true) @RequestParam @ValidateParam({ Validator.PASSWORD }) String password,
			@ApiParam(value = "验证码", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK }) String validateCode
			){
		System.out.println("account:"+mobile);
		System.out.println("password:"+password);
		System.out.println("validateCode:"+validateCode);
		String saveValidateCode = SessionUtils.getSessionValidateCode(request);
		System.out.println("validateCode:"+validateCode);
		System.out.println("saveValidateCode:"+saveValidateCode);
		WebResult<Object> result=null;
		if(validateCode.equals(saveValidateCode)){
			result=AuthRpcUtils.findByAccount(mobile);
			if(result.getCode()==ResultCode.FAILURE){//单点服务端用户不存在
				if(userService.getUserByMobile(mobile)==null){//本地用户不存在
					System.out.println("准备开始存用户...");
					result = AuthRpcUtils.register(Config.getSsoAppCode(),mobile, password);//单点服务端注册用户
					System.out.println("单点注册结果result："+result);
					
					User user=new User();
					user.setMobile(mobile);
					user.setPortraitUrl("/resource/images/customer/portrait/portrait.png");
					user.setName("最可爱的人");
					userService.insertUser(user);//本地注册用户
					
					result.setMessage("注册成功");
					return result;
				}
			}
			result.setMessage("用户已存在"); 
			return result;
			
		}else{
			result=new WebResult<Object>(ResultCode.FAILURE);
			result.setMessage("验证码有误");
			return result;
		}
		
	}
	@ApiOperation("验证账号是否存在")
	@RequestMapping(value="/validateAccount",method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	@ApiImplicitParam(paramType="query", name = "mobile", value = "手机号", required = true, dataType = "String")
	public @ResponseBody WebResult<Object> validateAccount(
			@ValidateParam({ Validator.NOT_BLANK }) String mobile
			){
		System.out.println("account:"+mobile);
		WebResult<Object> result=AuthRpcUtils.findByAccount(mobile);
		System.out.println("result:"+result);
		User user=userService.getUserByMobile(mobile);
		System.out.println("user:"+user);
		if(user!=null ||result.getCode()==ResultCode.SUCCESS){
			result.setMessage("用户已存在");
			return result;
		}else{
			result.setMessage("用户不存在");
			return result;
		}
	}
	
}
