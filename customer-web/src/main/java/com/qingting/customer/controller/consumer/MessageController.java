package com.qingting.customer.controller.consumer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qingting.customer.common.pojo.dto.MessageDTO;
import com.qingting.customer.common.pojo.util.DateUtil;
import com.smart.mvc.model.ResultCode;
import com.smart.mvc.model.WebResult;
import com.smart.mvc.validator.Validator;
import com.smart.mvc.validator.annotation.ValidateParam;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "消息相关")
@Controller("consumerMessageController")
@RequestMapping("/consumer/message")
public class MessageController {
	static boolean m1Flag=true;
	static boolean m2Flag=false;
	static boolean m3Flag=true;
	static boolean m4Flag=false;
	@ApiOperation(value="标记已读消息")
	@RequestMapping(value="/setRead",method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public @ResponseBody WebResult<String> setRead(
			@ApiParam(value = "消息ID", required = true)Integer id
			){
		if(id==1)
			m1Flag=true;
		if(id==2)
			m2Flag=true;
		if(id==3)
			m3Flag=true;
		if(id==4)
			m4Flag=true;
		WebResult<String> result=new WebResult<String>(ResultCode.SUCCESS);
		result.setMessage("设置成功");
		return result;
	}
	
	@ApiOperation("查询所有消息")
	@RequestMapping(value="/list",method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public @ResponseBody WebResult<List<MessageDTO>> list(){
		WebResult<List<MessageDTO>> result=new WebResult<List<MessageDTO>>(ResultCode.SUCCESS);
		List<MessageDTO> list=new ArrayList<MessageDTO>();
		MessageDTO m1=new MessageDTO();
		m1.setId(1);
		m1.setCreateTime(DateUtil.getDate(2017, 6, 27, 3, 10, 0));
		m1.setPath("/resource/images/customer/message/fwtx.jpg");
		m1.setSortCode("1");
		m1.setSortName("服务提醒");
		m1.setUserId(12); 
		m1.setReadFlag(m1Flag);
		m1.setContent("服务人员即将联系您，为您服务——清渟科技茶水间设备");
		list.add(m1);
		MessageDTO m2=new MessageDTO();
		m2.setId(2);
		m2.setCreateTime(DateUtil.getDate(2017, 6, 27, 3, 10, 0));
		m2.setPath("/resource/images/customer/message/fwpj.jpg");
		m2.setSortCode("2");
		m2.setSortName("服务评价");
		m2.setUserId(13); 
		m2.setReadFlag(m2Flag);
		m2.setContent("你有一条服务待评价");
		list.add(m2);
		MessageDTO m3=new MessageDTO();
		m3.setId(3);
		m3.setCreateTime(DateUtil.getDate(2017, 6, 27, 3, 10, 0));
		m3.setPath("/resource/images/customer/message/yjxx.jpg");
		m3.setSortCode("3");
		m3.setSortName("预警消息");
		m3.setUserId(14);
		m3.setReadFlag(m3Flag);
		m3.setDetailId(2);
		m3.setContent("设备预警，待处理...");
		list.add(m3);
		MessageDTO m4=new MessageDTO();
		m4.setId(4);
		m4.setCreateTime(DateUtil.getDate(2017, 6, 27, 3, 10, 0));
		m4.setPath("/resource/images/customer/message/sqgz.jpg");
		m4.setSortCode("4");
		m4.setSortName("申请关注");
		m4.setUserId(15); 
		m4.setReadFlag(m4Flag);
		m4.setContent("申请关注你的设备——最难忘的人");
		list.add(m4);
		result.setData(list);
		return result;
	}
	
}
