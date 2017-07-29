package com.qingting.customer.controller.consumer;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qingting.customer.baseserver.MessageService;
import com.qingting.customer.common.pojo.dto.MessageDTO;
import com.qingting.customer.common.pojo.hbasedo.Message;
import com.smart.mvc.model.ResultCode;
import com.smart.mvc.model.WebResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "消息相关")
@Controller("consumerMessageController")
@RequestMapping("/consumer/message")
public class MessageController {
	
	@Resource
	MessageService messageService;
	@ApiOperation(value="标记已读消息")
	@RequestMapping(value="/setRead",method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public @ResponseBody WebResult<String> setRead(
			@ApiParam(value = "消息ID", required = true) @RequestParam Long id,
			@ApiParam(value = "分类编号", required = true) @RequestParam String sortCode
			){
		System.out.println("id="+id+".sortCode="+sortCode+".");
		messageService.setRead(99, sortCode, id);
		WebResult<String> result=new WebResult<String>(ResultCode.SUCCESS);
		result.setMessage("设置成功");
		return result;
	}
	@ApiOperation(value="查询所有消息")
	@RequestMapping(value="/list",method = RequestMethod.POST)
	public @ResponseBody WebResult<List<MessageDTO>> list(
			@ApiParam(value = "消息ID", required = false) @RequestParam(value="endId", required=false) Long endId,
			@ApiParam(value = "分类编号", required = true) @RequestParam String sortCode
			){
		WebResult<List<MessageDTO>> result=new WebResult<List<MessageDTO>>(ResultCode.SUCCESS);
		List<MessageDTO> list=new ArrayList<MessageDTO>();
		
		List<Message> listMessage=null;
		if(endId!=null)
			listMessage = messageService.listMessageByEndId(endId, 99, sortCode, 20);
		else
			listMessage = messageService.listMessageByEndId(null, 99, sortCode, 20);
		
		
		for (Message message : listMessage) {
			MessageDTO messageDTO=new MessageDTO();
			messageDTO.setContent(message.getContent());
			messageDTO.setCreateTime(message.getCreateTime());
			messageDTO.setDetailId(2);
			messageDTO.setRowKey(message.getRowKey());
			messageDTO.setId(message.getId());
			messageDTO.setPath(message.getImageUrl());
			messageDTO.setReadFlag(message.getReadFlag());
			messageDTO.setSortCode(message.getSortCode());
			messageDTO.setTitle(message.getTitle());
			messageDTO.setStatus(message.getStatus());
			list.add(messageDTO);
		}
		
		
		result.setMessage("查询成功");
		result.setData(list);
		return result;
	}
	
}
