package com.qingting.customer.controller.admin;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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
import com.qingting.customer.controller.common.RequestEntitys;
import com.qingting.customer.hbase.rowkey.RowKeyParam;
import com.smart.mvc.controller.BaseController;
import com.smart.mvc.model.ResultCode;
import com.smart.mvc.model.WebResult;
import com.smart.mvc.validator.Validator;
import com.smart.mvc.validator.annotation.ValidateParam;

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
			@ApiParam(value = "用户Id", required = false) @RequestParam(value="userId", required=false) Integer userId,
			@ApiParam(value = "消息分类编号", required = false) @RequestParam(value="sortCode", required=false) String sortCode,
			@ApiParam(value = "page", required = true) @RequestBody Pagination<Message> page
			){
		System.out.println("userId:"+userId+".sortCode:"+sortCode+".page:"+page);
		WebResult<Pagination<Message>> result=new WebResult<Pagination<Message>>(ResultCode.SUCCESS);
		result.setData(messageService.listMessage(userId, sortCode, page));
		return result;
	}
}
