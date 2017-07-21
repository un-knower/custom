package com.qingting.customer.controller.admin;


import java.util.Calendar;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qingting.customer.baseserver.MessageService;
import com.qingting.customer.common.pojo.hbasedo.Message;
import com.qingting.customer.common.pojo.model.Pagination;
import com.smart.mvc.model.ResultCode;
import com.smart.mvc.model.WebResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "消息相关")
@Controller("adminMessageController")
@RequestMapping("/admin/message")
public class MessageController {
	@Resource
	MessageService messageService;
	
	@ApiOperation("页面跳转-消息管理页")
	@RequestMapping(value="/message",method = RequestMethod.GET,produces="text/html")
	public String execute() {
		return "/admin/message/message";
	}
	@ApiOperation(value="标记已读消息")
	@RequestMapping(value="/setRead",method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public @ResponseBody WebResult<String> setRead(
			@ApiParam(value = "消息ID", required = true)Integer id
			){
		WebResult<String> result=new WebResult<String>(ResultCode.SUCCESS);
		result.setMessage("设置成功");
		return result;
	}
	@ApiOperation("插入消息")
	@RequestMapping(value="/insert",method = RequestMethod.POST,produces = "application/json; charset=utf-8")
	public @ResponseBody WebResult<Object> insert(
			@ApiParam @RequestBody Message message
			){
		message.setCreateTime(Calendar.getInstance());
		WebResult<Object> result=new WebResult<Object>(ResultCode.SUCCESS);
		messageService.insertMessage(message);
		result.setData("成功");
		return result;
	}
	@ApiOperation("查询消息")
	@RequestMapping(value="/list",method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public @ResponseBody WebResult<Pagination<Message>> list(
			@ApiParam(value = "用户Id", required = false) @RequestParam(value="userId", required=false) Integer userId,
			@ApiParam(value = "消息分类编号", required = false) @RequestParam(value="sortCode", required=false) String sortCode,
			@ApiParam(value = "开始页码", required = true) @RequestParam Integer pageNo,
			@ApiParam(value = "显示条数", required = true) @RequestParam Integer pageSize
			){
		WebResult<Pagination<Message>> result=new WebResult<Pagination<Message>>(ResultCode.SUCCESS);
		result.setData(messageService.listMessage(userId, sortCode, pageNo, pageSize));
		return result;
	}
}
