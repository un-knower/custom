package com.qingting.customer.dao.external.util;

import java.util.HashMap;
import java.util.Map;

public class HttpClientTest {
	public static void main(String[] args){
		Map<String,String> map=new HashMap<String,String>();
		map.put("action", "send");
		map.put("userid", "1135");
		map.put("account", "qtkj");
		map.put("password", "a123456");
		map.put("mobile", "17701879780");
		map.put("content", "感谢你注册清渟科技在线监测系统，你的注册验证码是1234，为了保证你的账号信息安全，请不要将验证码告诉其他人！");
		String str = HttpClientUtils.doPost("http://101.200.230.239:6888/sms.aspx",map);
		System.out.println("发送结果："+str);
	}
}
