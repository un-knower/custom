package com.qingting.customer.controller.consumer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qingting.customer.common.pojo.dto.MessageDTO;
import com.qingting.customer.common.pojo.util.DateUtil;
import com.smart.mvc.model.ResultCode;
import com.smart.mvc.model.WebResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "消息相关")
@Controller("consumerMessageController")
@RequestMapping("/consumer/message")
public class MessageController {
	@ApiOperation("查询所有消息")
	@RequestMapping(value="/list",method = RequestMethod.GET)
	public @ResponseBody WebResult<List<MessageDTO>> list(){
		WebResult<List<MessageDTO>> result=new WebResult<List<MessageDTO>>(ResultCode.SUCCESS);
		List<MessageDTO> list=new ArrayList<MessageDTO>();
		MessageDTO m1=new MessageDTO();
		m1.setCreateTime(DateUtil.getDate(2017, 6, 27, 3, 10, 0));
		m1.setPath("/resource/images/customer/message/fwtx.jpg");
		m1.setSortCode("1");
		m1.setSortName("服务提醒");
		m1.setUserId(12); 
		list.add(m1);
		MessageDTO m2=new MessageDTO();
		m2.setCreateTime(DateUtil.getDate(2017, 6, 27, 3, 10, 0));
		m2.setPath("/resource/images/customer/message/fwpj.jpg");
		m2.setSortCode("2");
		m2.setSortName("服务评价");
		m2.setUserId(13); 
		list.add(m2);
		MessageDTO m3=new MessageDTO();
		m3.setCreateTime(DateUtil.getDate(2017, 6, 27, 3, 10, 0));
		m3.setPath("/resource/images/customer/message/yjxx.jpg");
		m3.setSortCode("3");
		m3.setSortName("预警消息");
		m3.setUserId(14); 
		list.add(m3);
		MessageDTO m4=new MessageDTO();
		m4.setCreateTime(DateUtil.getDate(2017, 6, 27, 3, 10, 0));
		m4.setPath("/resource/images/customer/message/sqgz.jpg");
		m4.setSortCode("4");
		m4.setSortName("申请关注");
		m4.setUserId(15); 
		list.add(m4);
		result.setData(list);
		return result;
	}
}
