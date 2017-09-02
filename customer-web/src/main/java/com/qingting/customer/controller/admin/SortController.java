package com.qingting.customer.controller.admin;

import java.util.Calendar;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smart.mvc.model.Pagination;
import com.qingting.customer.model.EquipSort;
import com.qingting.customer.model.MessageSort;
import com.qingting.customer.model.UserSort;
import com.qingting.customer.server.EquipSortService;
import com.qingting.customer.server.MessageSortService;
import com.qingting.customer.server.UserSortService;
import com.smart.mvc.model.ResultCode;
import com.smart.mvc.model.WebResult;
import com.smart.mvc.validator.Validator;
import com.smart.mvc.validator.annotation.ValidateParam;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "分类相关")
@Controller("adminSortController")
@RequestMapping("/admin/sort")
public class SortController {
	@Resource
	UserSortService userSortService;
	@Resource
	EquipSortService equipSortService;
	@Resource
	MessageSortService messageSortService;
	@ApiOperation("用户分类-页面跳转")
	@RequestMapping(value="/userSort",method = RequestMethod.GET)
	public String userSort(){
		return "/admin/sort/userSort";
	}
	@ApiOperation("设备分类-页面跳转")
	@RequestMapping(value="/equipSort",method = RequestMethod.GET)
	public String equipSort(){
		return "/admin/sort/equipSort";
	}
	@ApiOperation("消息分类-页面跳转")
	@RequestMapping(value="/messageSort",method = RequestMethod.GET)
	public String messageSort(){
		return "/admin/sort/messageSort";
	}
	@ApiOperation("获取用户分类信息")
	@RequestMapping(value="/listUserSort",method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public @ResponseBody WebResult<Pagination<UserSort>> listUserSort(
			@ApiParam(value = "开始页码", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK }) Integer pageNo,
			@ApiParam(value = "显示条数", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK }) Integer pageSize
			){
		WebResult<Pagination<UserSort>> result=new WebResult<Pagination<UserSort>>(ResultCode.SUCCESS);
		result.setData(userSortService.listUserSort(pageNo, pageSize));
		return result;
	}
	@ApiOperation("保存用户分类信息")
	@RequestMapping(value="/saveUserSort",method = RequestMethod.POST,produces = "application/json; charset=utf-8")
	public @ResponseBody WebResult<Object> saveUserSort(
			@ApiParam @RequestBody UserSort userSort
			){
		System.out.println(userSort);
		userSort.setCreateTime(Calendar.getInstance());
		userSortService.insertUserSort(userSort);
		WebResult<Object> result=new WebResult<Object>(ResultCode.SUCCESS);
		result.setData("成功");
		return result;
	}
	@ApiOperation("获取设备分类信息")
	@RequestMapping(value="/listEquipSort",method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public @ResponseBody WebResult<Pagination<EquipSort>> listEquipSort(
			@ApiParam(value = "开始页码", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK }) Integer pageNo,
			@ApiParam(value = "显示条数", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK }) Integer pageSize
			){
		WebResult<Pagination<EquipSort>> result=new WebResult<Pagination<EquipSort>>(ResultCode.SUCCESS);
		result.setData(equipSortService.listEquipSort(pageNo, pageSize));
		return result;
	}
	@ApiOperation("保存用户分类信息")
	@RequestMapping(value="/saveEquipSort",method = RequestMethod.POST,produces = "application/json; charset=utf-8")
	public @ResponseBody WebResult<Object> saveEquipSort(
			@ApiParam @RequestBody EquipSort equipSort
			){
		System.out.println(equipSort);
		equipSort.setCreateTime(Calendar.getInstance());
		equipSortService.insertEquipSort(equipSort);
		WebResult<Object> result=new WebResult<Object>(ResultCode.SUCCESS);
		result.setData("成功");
		return result;
	}
	@ApiOperation("获取信息分类信息")
	@RequestMapping(value="/listMessageSort",method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public @ResponseBody WebResult<Pagination<MessageSort>> listMessageSort(
			@ApiParam(value = "开始页码", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK }) Integer pageNo,
			@ApiParam(value = "显示条数", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK }) Integer pageSize
			){
		WebResult<Pagination<MessageSort>> result=new WebResult<Pagination<MessageSort>>(ResultCode.SUCCESS);
		result.setData(messageSortService.listMessageSort(pageNo, pageSize));
		return result;
	}
	@ApiOperation("保存用户分类信息")
	@RequestMapping(value="/saveMessageSort",method = RequestMethod.POST,produces = "application/json; charset=utf-8")
	public @ResponseBody WebResult<Object> saveMessageSort(
			@ApiParam @RequestBody MessageSort messageSort
			){
		System.out.println(messageSort);
		messageSort.setCreateTime(Calendar.getInstance());
		messageSortService.insertMessageSort(messageSort);
		WebResult<Object> result=new WebResult<Object>(ResultCode.SUCCESS);
		result.setData("成功");
		return result;
	}
}
