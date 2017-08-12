package com.qingting.customer.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smart.mvc.model.ResultCode;
import com.smart.mvc.model.WebResult;
import com.smart.mvc.validator.Validator;
import com.smart.mvc.validator.annotation.ValidateParam;
import com.smart.sso.client.Config;
import com.smart.sso.client.AuthRpcUtils;
import com.smart.sso.client.SessionUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags="忘记密码")
@Controller
@RequestMapping("/forget")
public class ForgetController {
	@ApiOperation("页面跳转-忘记密码页面")
	@RequestMapping(method = RequestMethod.GET,produces="text/html")
	public String execute(){
		return "/forget";
	}
	@ApiOperation("修改密码")
	@RequestMapping(value="/update",method = RequestMethod.POST,produces = "application/json; charset=utf-8")
	public @ResponseBody WebResult<Object> updatePassword(
			HttpServletRequest request,
			HttpServletResponse response,
			@ApiParam(value = "手机号", required = true) @RequestParam @ValidateParam({ Validator.MOBILE }) String mobile,
			@ApiParam(value = "密码", required = true) @RequestParam @ValidateParam({ Validator.PASSWORD }) String password,
			@ApiParam(value = "验证码", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK }) String validateCode
			){
		System.out.println("account:"+mobile);
		System.out.println("password:"+password);
		System.out.println("validateCode:"+validateCode);
		String saveValidateCode = SessionUtils.getSessionValidateCode(request);
		System.out.println("saveValidateCode:"+saveValidateCode);
		WebResult<Object> result=null;
		if(saveValidateCode.equals(validateCode)){
			result=AuthRpcUtils.findByAccount(mobile);
			if(result.getCode()==ResultCode.SUCCESS){
				result = AuthRpcUtils.updatePassword(mobile, password);
				WebResult<Object> loginResult = AuthRpcUtils.login(Config.getSsoAppCode(), mobile, password, request, response);
				if(result.getCode()==ResultCode.SUCCESS&&loginResult.getCode()==ResultCode.SUCCESS){
					result.setMessage("修改成功");
					return result;
				}else{
					result.setCode(ResultCode.FAILURE);
					if(result.getCode()!=ResultCode.SUCCESS){ //密码更新失败
						result.setMessage("密码更新失败，可能SSO服务器未启动");
					}else{//登陆失败
						result.setMessage("登陆失败，可能SSO服务器未启动");
					}
				}
			}else{
				result.setMessage("用户不存在");
			}
			return result;
		}else{
			result=new WebResult<Object>();
			result.setMessage("验证码错误");
			return result;
		}
	}
}
