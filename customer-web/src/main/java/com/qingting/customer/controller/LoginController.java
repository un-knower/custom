package com.qingting.customer.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	@ApiOperation("页面跳转-客户端登陆页,例外:此处跳转顶层目录login.jsp页")
	@RequestMapping(value="/consumer",method = RequestMethod.GET)
	public String consumerRedirect(){
		System.out.println(this.getClass()+"客户端自定义登陆页面！login.jsp");
		return "/login";
	}
	@ApiOperation("页面跳转-后台登陆页,例外:此处跳转顶层目录admin.jsp页")
	@RequestMapping(value="/admin",method = RequestMethod.GET)
	public String adminRedirect(){
		System.out.println(this.getClass()+"客户端自定义登陆页面！login.jsp");
		return "/admin";
	}
	@ApiOperation("登陆提交")
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public String login(HttpServletRequest request,
			@ApiParam(value = "手机号", required = true) @RequestParam @ValidateParam({ Validator.MOBILE })String mobile,
			@ApiParam(value = "密码", required = true) @RequestParam @ValidateParam({ Validator.PASSWORD })String password
			){
		String contextpath = request.getScheme() +"://" + request.getServerName()  + ":" +request.getServerPort() +request.getContextPath();
		String ssoLoginUrl = new StringBuilder().append(Config.getSsoServerUrl()).append("/login/submit?").append("account="+mobile).append("&password="+password).
				append("&backUrl=").append(contextpath+"/lead").append("&appCode=").append(Config.getSsoAppCode()).toString();
		System.out.println(this.getClass()+"ssoLoginUrl:");
		return "redirect:" + ssoLoginUrl;
		/*String ssoLoginUrl = new StringBuilder().append(Config.getSsoServerUrl()).append("/login/submit").toString();
		model.addAttribute("account", mobile);   
	    model.addAttribute("password", password); 
	    model.addAttribute("backUrl", request.getServletPath()+"/lead");
	    model.addAttribute("appCode", Config.getSsoAppCode());
	    return "redirect:" + ssoLoginUrl; */
	}
	/**
	 * 
	 * @Title: login
	 * @Description: TODO(登陆)
	 * @param map
	 * @return RedirectView
	 * @throws
	 */
	/*@ApiOperation("登陆")
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public RedirectView login(
			@ApiParam(value = "手机号", required = true) @RequestParam @ValidateParam({ Validator.MOBILE })String mobile,
			@ApiParam(value = "密码", required = true) @RequestParam @ValidateParam({ Validator.PASSWORD })String password
			) {   
		String ssoLoginUrl = new StringBuilder().append(Config.getSsoServerUrl()).append("/login/submit").toString();
        return new RedirectView(ssoLoginUrl,true,false,false);//最后的参数为false代表以post方式提交请求   
    }*/
}
