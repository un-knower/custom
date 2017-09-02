package com.qingting.customer.controller.admin;


import java.util.Calendar;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smart.mvc.model.Pagination;
import com.qingting.customer.controller.common.RequestEntitys;
import com.qingting.customer.model.Message;
import com.qingting.customer.server.MessageService;
import com.smart.mvc.controller.BaseController;
import com.smart.mvc.model.ResultCode;
import com.smart.mvc.model.WebResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "消息相关")
@Controller("adminMessageController")
@RequestMapping("/admin/message")
public class MessageController extends BaseController{
	@Resource
	MessageService messageService;
	
	@ApiOperation("页面跳转-消息管理页")
	@RequestMapping(value="/message",method = RequestMethod.GET,produces="text/html")
	public String execute() {
		return "/admin/message/message";
	}
	@ApiOperation(value="标记已读消息")
	@RequestMapping(value="/update",method = RequestMethod.POST,produces = "application/json; charset=utf-8")
	public @ResponseBody WebResult<String> update(
			@ApiParam @RequestBody Message message
			){
		messageService.updateMessage(message);
		WebResult<String> result=new WebResult<String>(ResultCode.SUCCESS);
		result.setMessage("设置成功");
		return result;
	}
	@ApiOperation("后台消息")
	@RequestMapping(value="/delete",method = RequestMethod.POST)
	public @ResponseBody WebResult<Object> delete(
			@ApiParam(value = "entitys", required = true) @RequestBody RequestEntitys<Message> entitys//List<RowKeyParam> rowkeys
			){
		System.out.println("删除的用户rowkey:"+entitys);
		//System.out.println(list);
		/*List<String> list=new ArrayList<String>();
		for (String string : rowkeys) {
			list.add(string);
		}*/
		messageService.deleteMessage(entitys.getEntitys());
		//userService.deleteUserByRowKey(getAjaxIdsString(rowkeys));
		WebResult<Object> result=new WebResult<Object>(ResultCode.SUCCESS);
		result.setMessage("删除成功");
		return result;
	}
	@ApiOperation("插入消息")
	@RequestMapping(value="/insert",method = RequestMethod.POST,produces = "application/json; charset=utf-8")
	public @ResponseBody WebResult<Object> insert(
			@ApiParam @RequestBody Message message
			){
		message.setCreateTime(Calendar.getInstance());
		WebResult<Object> result=new WebResult<Object>(ResultCode.SUCCESS);
		for (int i = 0; i < 45; i++) {
			message.setCreateTime(Calendar.getInstance());
			messageService.insertMessage(message);
		}
		result.setData("成功");
		return result;
	}
	@ApiOperation("查询消息")
	@RequestMapping(value="/list",method = RequestMethod.POST,produces = "application/json; charset=utf-8")
	public @ResponseBody WebResult<Pagination<Message>> list(
			@ApiParam(value = "page", required = true) @RequestBody Pagination<Message> page
			){
		System.out.println("page:"+page);
		WebResult<Pagination<Message>> result=new WebResult<Pagination<Message>>(ResultCode.SUCCESS);
		result.setData(messageService.listMessage(page));
		return result;
	}
}
