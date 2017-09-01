package com.qingting.customer.server.external.impl;

import java.util.Calendar;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qingting.customer.common.pojo.hbasedo.Message;
import com.qingting.customer.dao.external.TxMessageDAO;
import com.qingting.customer.server.MessageService;
import com.qingting.customer.server.external.TxMessageService;
import com.smart.mvc.model.Result;
//import com.smart.sso.client.MnsUtils;
//import com.smart.sso.client.SessionUtils;
import org.json.JSONObject;

@Service("txMessageService")
public class TxMessageServiceImpl implements TxMessageService {
	@Resource
	MessageService messageService;
	@Resource
	TxMessageDAO txMessageDAO;
	@Override
	public Result getValidateCode(String account, String ip) {
		
		/*System.out.println("获得"+account+"验证码...");
		Integer txCountForPhone = messageService.countMessageOfTodayByPhone(account);
		System.out.println("今天给手机号"+account+"发送条数:"+txCountForPhone);
		String ip = getIpAddr(request);
		System.out.println("请求ip地址:"+ip);
		Integer txCountForIp =messageService.countMessageOfTodayByIp(ip);
		System.out.println("今天IP:"+ip+",发送条数:"+txCountForIp);
		Message message=new Message();//插入请求客户端信息
		message.setIpAddr(ip);
		message.setPhone(account);
		message.setMessageSortId(1);
		message.setCalendar(Calendar.getInstance());
		messageService.insertMessage(message);
		System.out.println("插入信息结束...");
		String validateCode=getRandomCode();
		System.out.println("验证码validateCode："+validateCode);
		SessionUtils.setSessionValidateCode(request, validateCode);
		String ret = MnsUtils.txValidateCode(account, validateCode);
		System.out.println("ret:"+ret);*/
		
		/*System.out.println("获得"+account+"验证码...");
		Integer txCountForPhone = messageService.countMessageOfTodayByPhone(account);
		System.out.println("今天给手机号"+account+"发送条数:"+txCountForPhone);
		//String ip = getIpAddr(request);
		System.out.println("请求ip地址:"+ip);
		Integer txCountForIp =messageService.countMessageOfTodayByIp(ip);
		System.out.println("今天IP:"+ip+",发送条数:"+txCountForIp);
		Message message=new Message();//插入请求客户端信息
		message.setIpAddr(ip);
		message.setPhone(account);
		message.setMessageSortId(1);
		message.setCalendar(Calendar.getInstance());
		messageService.insertMessage(message);
		System.out.println("插入信息结束...");
		//String validateCode=getRandomCode();
		//System.out.println("验证码validateCode："+validateCode);
		//SessionUtils.setSessionValidateCode(request, validateCode);
		//String ret = MnsUtils.txValidateCode(account, validateCode);
		//System.out.println("ret:"+ret);*/
		
		JSONObject jsonObject = new JSONObject(txMessageDAO.txValidateCode(account));
		int code =jsonObject.getInt("code");
		String msg=jsonObject.getString("msg");
		String obj=jsonObject.getString("obj");
		return  Result.createResult(code, msg, obj);
	}

}
