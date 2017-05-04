package com.qingting.customer.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@RequestMapping("/sequnence")
public class SequenceController {
	@Autowired
	public RedisTemplate<String, Integer> redisTemplate;
	@RequestMapping("/get") 
	public @ResponseBody int getSequence(){
		//int num=RedisSerialNum.getSerialNum(redisTemplate, SerialType.SERIALNUM.getValue());
	    //System.out.println("获取的序列-num:" + num);
		//return num;
		return 0;
	}
}
