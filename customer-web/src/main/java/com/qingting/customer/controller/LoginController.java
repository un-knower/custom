package com.qingting.customer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.qingting.customer.server.UserService;
import com.smart.mvc.util.StringUtils;
import com.smart.mvc.validator.Validator;
import com.smart.mvc.validator.annotation.ValidateParam;
import com.smart.sso.client.Config;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "登陆页")
@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	UserService userService;
	
	@ApiOperation("页面跳转-用户登陆页")
	@RequestMapping(value="/consumer",method = RequestMethod.GET,produces="text/html")
	public void consumer(HttpServletRequest request,HttpServletResponse response,
			@ApiParam(value = "错误信息", required = false) @RequestParam(name="errorMessage",required=false) String errorMessage,
			@ApiParam(value = "回调地址", required = false) @RequestParam(name="backUrl",required=false) String backUrl
			){
		System.out.println(this.getClass()+"客户端自定义登陆页面！login.jsp");
		request.setAttribute("errorMessage",errorMessage);
		if(StringUtils.isBlank(backUrl)){
			String contextpath = request.getScheme() +"://" + request.getServerName()  + ":" +request.getServerPort() +request.getContextPath();
		 	request.setAttribute("backUrl",contextpath+"/consumer/home.jsp");
		}else{
			request.setAttribute("backUrl",backUrl);
		}
		try {
			request.getRequestDispatcher("/login/consumer.jsp").forward(request,response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@ApiOperation("页面跳转-后台登陆页")
	@RequestMapping(value="/admin",method = RequestMethod.GET,produces="text/html")
	public void admin(HttpServletRequest request,HttpServletResponse response,
			@ApiParam(value = "错误信息", required = false) @RequestParam(name="errorMessage",required=false) String errorMessage,
			@ApiParam(value = "回调地址", required = false) @RequestParam(name="backUrl",required=false) String backUrl
			){
		System.out.println(this.getClass()+"客户端自定义登陆页面！login.jsp");
		System.out.println("userService"+userService);
		
		request.setAttribute("errorMessage",errorMessage);
		if(StringUtils.isBlank(backUrl)){
			String contextpath = request.getScheme() +"://" + request.getServerName()  + ":" +request.getServerPort() +request.getContextPath();
			request.setAttribute("backUrl",contextpath+"/admin/admin");
		}else{
			request.setAttribute("backUrl",backUrl);
		}
		try {
			request.getRequestDispatcher("/login/admin.jsp").forward(request,response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@ApiOperation("页面跳转-工程登陆页")
	@RequestMapping(value="/employee",method = RequestMethod.GET,produces="text/html")
	public void employee(HttpServletRequest request,HttpServletResponse response,
			@ApiParam(value = "错误信息", required = false) @RequestParam(name="errorMessage",required=false) String errorMessage,
			@ApiParam(value = "回调地址", required = false) @RequestParam(name="backUrl",required=false) String backUrl
			){
		System.out.println(this.getClass()+"客户端自定义登陆页面！login.jsp");
		System.out.println("userService"+userService);
		
		request.setAttribute("errorMessage",errorMessage);
		if(StringUtils.isBlank(backUrl)){
			String contextpath = request.getScheme() +"://" + request.getServerName()  + ":" +request.getServerPort() +request.getContextPath();
			request.setAttribute("backUrl",contextpath+"/employee/bind.jsp");
		}else{
			request.setAttribute("backUrl",backUrl);
		}
		try {
			request.getRequestDispatcher("/login/employee.jsp").forward(request,response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@ApiOperation(value="用户登陆提交")
	@RequestMapping(value="/consumer/submit",method = RequestMethod.POST,produces="text/html")
	public String consumerSubmit(HttpServletRequest request,
			@ApiParam(value = "手机号", required = true) @RequestParam @ValidateParam({ Validator.MOBILE })String mobile,
			@ApiParam(value = "密码", required = true) @RequestParam @ValidateParam({ Validator.PASSWORD })String password,
			@ApiParam(value = "回调地址", required = false) @RequestParam(name="backUrl",required=false) String backUrl
			){
		if(StringUtils.isBlank(backUrl)){
			String contextpath = request.getScheme() +"://" + request.getServerName()  + ":" +request.getServerPort() +request.getContextPath();
			backUrl=contextpath+"/consumer/lead.jsp";
		}
		
		String contextpath = request.getScheme() +"://" + request.getServerName()  + ":" +request.getServerPort() +request.getContextPath();
		String ssoLoginUrl = new StringBuilder().append(Config.getSsoServerUrl()).append("/login/clientSubmit?").
				append("account="+mobile).append("&password="+password).
				append("&backUrl=").append(backUrl).
				append("&loginUrl="+contextpath+"/login/consumer").
				append("&appCode=").append(Config.getSsoAppCode()).toString();
		
		System.out.println("ssoLoginUrl:"+ssoLoginUrl);
		return "redirect:" + ssoLoginUrl;
		
		/*String ssoLoginUrl = new StringBuilder().append(Config.getSsoServerUrl()).append("/login/submit").toString();
		model.addAttribute("account", mobile);   
	    model.addAttribute("password", password); 
	    model.addAttribute("backUrl", request.getServletPath()+"/lead");
	    model.addAttribute("appCode", Config.getSsoAppCode());
	    return "redirect:" + ssoLoginUrl; */
	}
	@ApiOperation(value="后台登陆提交")
	@RequestMapping(value="/admin/submit",method = RequestMethod.POST,produces="text/html")
	public String adminSubmit(HttpServletRequest request,
			@ApiParam(value = "手机号", required = true) @RequestParam @ValidateParam({ Validator.MOBILE })String mobile,
			@ApiParam(value = "密码", required = true) @RequestParam @ValidateParam({ Validator.PASSWORD })String password,
			@ApiParam(value = "回调地址", required = false) @RequestParam(name="backUrl",required=false) String backUrl
			){
		if(StringUtils.isBlank(backUrl)){
			String contextpath = request.getScheme() +"://" + request.getServerName()  + ":" +request.getServerPort() +request.getContextPath();
			backUrl=contextpath+"/admin/admin";
		}
		String contextpath = request.getScheme() +"://" + request.getServerName()  + ":" +request.getServerPort() +request.getContextPath();
		String ssoLoginUrl = new StringBuilder().append(Config.getSsoServerUrl()).append("/login/clientSubmit?").
				append("account="+mobile).append("&password="+password).
				append("&backUrl=").append(backUrl).
				append("&loginUrl="+contextpath+"/login/admin").
				append("&appCode=").append(Config.getSsoAppCode()).toString();
		
		System.out.println("ssoLoginUrl:"+ssoLoginUrl);
		return "redirect:" + ssoLoginUrl;
		
	}
	@ApiOperation(value="工程登陆提交")
	@RequestMapping(value="/employee/submit",method = RequestMethod.POST,produces="text/html")
	public String employeeSubmit(HttpServletRequest request,
			@ApiParam(value = "手机号", required = true) @RequestParam @ValidateParam({ Validator.MOBILE })String mobile,
			@ApiParam(value = "密码", required = true) @RequestParam @ValidateParam({ Validator.PASSWORD })String password,
			@ApiParam(value = "回调地址", required = false) @RequestParam(name="backUrl",required=false) String backUrl
			){
		if(StringUtils.isBlank(backUrl)){
			String contextpath = request.getScheme() +"://" + request.getServerName()  + ":" +request.getServerPort() +request.getContextPath();
			backUrl=contextpath+"/employee/bind.jsp";
		}
		String contextpath = request.getScheme() +"://" + request.getServerName()  + ":" +request.getServerPort() +request.getContextPath();
		String ssoLoginUrl = new StringBuilder().append(Config.getSsoServerUrl()).append("/login/clientSubmit?").
				append("account="+mobile).append("&password="+password).
				append("&backUrl=").append(backUrl).
				append("&loginUrl="+contextpath+"/login/employee").
				append("&appCode=").append(Config.getSsoAppCode()).toString();
		
		System.out.println("ssoLoginUrl:"+ssoLoginUrl);
		return "redirect:" + ssoLoginUrl;
	}
	
	
	
}
