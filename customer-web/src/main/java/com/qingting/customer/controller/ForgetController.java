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
import com.smart.sso.client.RegisterUtils;
import com.smart.sso.client.SessionUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags="忘记密码")
@Controller
@RequestMapping("/forget")
public class ForgetController {
	@ApiOperation("修改密码")
	@RequestMapping(value="/update",method = RequestMethod.POST)
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
			result=RegisterUtils.findByAccount(mobile);
			if(result.getCode()==ResultCode.SUCCESS){
				result = RegisterUtils.updatePassword(mobile, password);
				result.setMessage("修改成功");
				return result;
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
