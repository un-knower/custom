package com.qingting.customer.controller;

import java.util.Calendar;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.qingting.customer.baseserver.MessageService;
import com.qingting.customer.baseserver.UserService;
import com.qingting.customer.baseserver.external.TxMessageService;
import com.qingting.customer.common.pojo.hbasedo.Message;
import com.qingting.customer.common.pojo.hbasedo.User;
import com.smart.mvc.model.Result;
import com.smart.mvc.model.ResultCode;
import com.smart.mvc.util.StringUtils;
import com.smart.mvc.validator.Validator;
import com.smart.mvc.validator.annotation.ValidateParam;
import com.smart.sso.client.MnsUtils;
import com.smart.sso.client.RegisterUtils;
import com.smart.sso.client.SessionUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags="注册")
@Controller
@RequestMapping("/reg")
public class RegisterController {
	@Resource
	UserService userService;
	@Resource
	MessageService messageService;
	@Resource
	TxMessageService txMessageService;
	@ApiOperation("跳转注册页面")
	@RequestMapping(method = RequestMethod.GET)
	public String execute(){
		return "/register";
	}
	@ApiOperation("注册用户")
	@RequestMapping(value="/reg",method = RequestMethod.POST)
	//@ApiImplicitParam(paramType="query", name = "account", value = "手机号", required = true, dataType = "String")
	//@ApiImplicitParam(paramType="query", name = "password", value = "密码", required = true, dataType = "String")
	//@ApiImplicitParam(paramType="query", name = "validateCode", value = "验证码", required = true, dataType = "String")
	public @ResponseBody Result register(
			HttpServletRequest request,
			@ApiParam(value = "手机号", required = true) @RequestParam @ValidateParam({ Validator.MOBILE }) String account,
			@ApiParam(value = "密码", required = true) @RequestParam @ValidateParam({ Validator.PASSWORD }) String password,
			@ApiParam(value = "验证码", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK }) String validateCode
			){
		System.out.println("account:"+account);
		System.out.println("password:"+password);
		System.out.println("validateCode:"+validateCode);
		String saveValidateCode = SessionUtils.getSessionValidateCode(request);
		System.out.println("validateCode:"+validateCode);
		System.out.println("saveValidateCode:"+saveValidateCode);
		if(validateCode.equals(saveValidateCode)){
			User user=new User();
			user.setAccount(account);
			user.setPassword(password);
			Result result=RegisterUtils.findByAccount(account);
			if(userService.getUserByAccount(account)==null){//本地用户不存在
				if(result.getCode()==ResultCode.SUCCESS){//单点服务端用户不存在
					System.out.println("准备开始存用户...");
					result = RegisterUtils.register(account, password);//单点服务端注册用户
					System.out.println("单点注册结果result："+result);
					userService.insertUser(user);//本地注册用户
					Result reResult = Result.createSuccessResult();
					return reResult;
				}
			}
		}
		Result reResult = Result.createFailureResult();
		return reResult;
	}
	@ApiOperation("验证账号是否存在")
	@RequestMapping(value="/validateAccount",method = RequestMethod.POST)
	@ApiImplicitParam(paramType="query", name = "account", value = "手机号", required = true, dataType = "String")
	public @ResponseBody Result validateAccount(
			@ValidateParam({ Validator.NOT_BLANK }) String account
			){
		System.out.println("account:"+account);
		Result result=RegisterUtils.findByAccount(account);
		System.out.println("result:"+result);
		User user=userService.getUserByAccount(account);
		System.out.println("user:"+user);
		if(user!=null)
			return result.setCode(ResultCode.ISEXIST_ERROR);
		if(result.getCode()!=ResultCode.SUCCESS)
			return result.setCode(ResultCode.ISEXIST_ERROR);
		return result;
	}
	@ApiOperation("修改密码")
	@RequestMapping(value="/updatePassword",method = RequestMethod.POST)
	public @ResponseBody Result updatePassword(
			HttpServletRequest request,
			@ApiParam(value = "手机号", required = true) @RequestParam @ValidateParam({ Validator.MOBILE }) String account,
			@ApiParam(value = "密码", required = true) @RequestParam @ValidateParam({ Validator.PASSWORD }) String password,
			@ApiParam(value = "验证码", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK }) String validateCode
			){
		System.out.println("account:"+account);
		System.out.println("password:"+password);
		System.out.println("validateCode:"+validateCode);
		String saveValidateCode = SessionUtils.getSessionValidateCode(request);
		System.out.println("saveValidateCode:"+saveValidateCode);
		Result result=null;
		if(saveValidateCode.equals(validateCode)){
			result = RegisterUtils.updatePassword(account, password);
		}
		if(result!=null)
			System.out.println("result.getCode()"+result.getCode());
		else
			System.out.println("result is null.");
		//此处还需考虑修改失败
		return result;
	}
	@ApiOperation("获取验证码")
	@RequestMapping(value="/getValidateCode",method = RequestMethod.GET)
	@ApiImplicitParam(paramType="query", name = "account", value = "手机号", required = true, dataType = "String")
	public @ResponseBody Result getValidateCode(
			HttpServletRequest request,
			@ValidateParam({ Validator.MOBILE }) String account
			){
		String ip = getIpAddr(request);
		System.out.println("请求ip地址:"+ip);
		Result result = txMessageService.getValidateCode(account,ip);
		System.out.println("result:"+result);
		System.out.println("result.getCode():"+result.getCode());
		if(result.getCode()==200){ //发送验证码成功
			SessionUtils.setSessionValidateCode(request, (String)result.getData());
			return Result.createSuccessResult();
		}else//发送验证码失败
			return Result.createFailureResult();
	}
	
	/**
	 * 
	 * @Title: getIpAddr
	 * @Description: 获取IP地址
	 * @param request
	 * @return 
	 * @return String
	 * @throws
	 */
	protected String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("X-Real-IP");
		if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
			return toIpv4(ip);
		}
		ip = request.getHeader("X-Forwarded-For");
		if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
			// 多次反向代理后会有多个IP值，第一个为真实IP。
			int index = ip.indexOf(',');
			if (index != -1) {
				return toIpv4(ip.substring(0, index));
			}
			else {
				return toIpv4(ip);
			}
		}
		else {
			return toIpv4(request.getRemoteAddr());
		}
	}
	/**
	 * 
	 * @Title: toIpv4
	 * @Description: 本地访问时，ipv6转ipv4
	 * @param ip
	 * @return 
	 * @return String
	 * @throws
	 */
	protected String toIpv4(String ip){
		return ip.equals("0:0:0:0:0:0:0:1")?"127.0.0.1":ip;
	}
	/**
	 * 
	 * @Title: getRandomCode
	 * @Description: 获得4为随机数字
	 * @return 
	 * @return String
	 * @throws
	 */
	protected String getRandomCode(){
		//字符串转char数组
		char[] str="0123456789".toCharArray();
	
		StringBuilder sb=new StringBuilder();
		Random random=new Random();
		for(int i=0;i<4;i++){
			//随机生成0到str长度之间的数字做为下标
			int randomIndex=random.nextInt(str.length);
			//追加到sb对象
			sb.append(str[randomIndex]);
		}
		return sb.toString();
	}
}
