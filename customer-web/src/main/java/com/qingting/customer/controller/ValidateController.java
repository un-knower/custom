package com.qingting.customer.controller;

import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qingting.customer.baseserver.external.TxMessageService;
import com.smart.mvc.model.Result;
import com.smart.mvc.model.ResultCode;
import com.smart.mvc.model.WebResult;
import com.smart.mvc.util.StringUtils;
import com.smart.mvc.validator.Validator;
import com.smart.mvc.validator.annotation.ValidateParam;
import com.smart.sso.client.SessionUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Api(tags="验证码")
@Controller
@RequestMapping("/validate")
public class ValidateController {
	
	@Resource
	TxMessageService txMessageService;
	
	@ApiOperation("获取验证码")
	@RequestMapping(value="/getValidateCode",method = RequestMethod.GET)
	@ApiImplicitParam(paramType="query", name = "mobile", value = "手机号", required = true, dataType = "String")
	public @ResponseBody WebResult<Object> getValidateCode(
			HttpServletRequest request,
			@ValidateParam({ Validator.MOBILE }) String mobile
			){
		String ip = getIpAddr(request);
		System.out.println("请求ip地址:"+ip);
		Result result = txMessageService.getValidateCode(mobile,ip);
		System.out.println("result:"+result);
		System.out.println("result.getCode():"+result.getCode());
		if(result.getCode()==200){ //发送验证码成功
			SessionUtils.setSessionValidateCode(request, (String)result.getData());
			return new WebResult<Object>(ResultCode.SUCCESS);
		}else//发送验证码失败
			return new WebResult<Object>(ResultCode.FAILURE);
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
