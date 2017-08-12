package com.qingting.customer.controller.admin;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qingting.customer.baseserver.EquipService;
import com.qingting.customer.common.pojo.dto.EquipDTO;
import com.qingting.customer.common.pojo.hbasedo.Equip;
import com.qingting.customer.common.pojo.hbasedo.Message;
import com.qingting.customer.common.pojo.model.Pagination;
import com.smart.mvc.model.ResultCode;
import com.smart.mvc.model.WebResult;
import com.smart.mvc.validator.Validator;
import com.smart.mvc.validator.annotation.ValidateParam;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
@Api(tags = "设备相关")
@Controller
@RequestMapping("/admin/equip")
public class EquipController {
	@Resource
	EquipService equipService;
	
	@ApiOperation("页面跳转-设备管理页")
	@RequestMapping(value="/equip",method = RequestMethod.GET,produces="text/html")
	public String execute() {
		return "/admin/equip/equip";
	}
	
	@ApiOperation("后台插入设备")
	@RequestMapping(value="/insert",method = RequestMethod.POST)
	public @ResponseBody WebResult<Object> insertEquip(
			@ApiParam @RequestBody Equip equip){
		System.out.println(equip);
		equipService.insertEquip(equip);
		return new WebResult<Object>(ResultCode.SUCCESS);
	}
	@ApiOperation("后台删除设备")
	@RequestMapping(value="/delete",method = RequestMethod.POST)
	public @ResponseBody WebResult<Object> deleteEquipByRowKey(
			@ApiParam(value = "设备编号", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK })String equipCode
			){
		System.out.println("设备编号:"+equipCode);
		equipService.deleteEquipByEquipCode(equipCode);
		return new WebResult<Object>(ResultCode.SUCCESS);
	}
	@ApiOperation("后台更新设备")
	@RequestMapping(value="/update",method = RequestMethod.POST)
	public @ResponseBody WebResult<Object> updateEquipByRowKey(
			@ApiParam @RequestBody Equip equip
			){
		equipService.updateEquipByEquipCode(equip);
		return new WebResult<Object>(ResultCode.SUCCESS);
	}
	//已测试OK
	@ApiOperation("查询所有设备")
	@RequestMapping(value="/list",method = RequestMethod.POST,produces = "application/json; charset=utf-8")
	public @ResponseBody WebResult<Pagination<Equip>> listEquip(
			@ApiParam(value = "page", required = true) @RequestBody Pagination<Equip> page
			){
		WebResult<Pagination<Equip>> result=new WebResult<Pagination<Equip>>(ResultCode.SUCCESS);
		result.setData(equipService.listEquipByEquipCodeAndUserId(page));
		return result;
	}
	/*//已测试OK
	@ApiOperation("工程安装-给用户绑定设备")
	@RequestMapping(value="/bindEquip",method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public @ResponseBody WebResult<Object> bindEquip(
			@ApiParam(value = "用户ID", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK })Integer userId,
			@ApiParam(value = "设备编号", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK })String equipCode){
		String msg = equipService.updateUserOfNewEquip(userId, equipCode);
		if(msg==null){//绑定成功
			WebResult<Object> result=new WebResult<Object>(ResultCode.SUCCESS);
			result.setMessage("绑定成功");
			return result;
		}else{
			WebResult<Object> result=new WebResult<Object>(ResultCode.FAILURE);
			result.setMessage(msg);
			return result;
		}
			
	}*/
	@ApiOperation("后台用-更新设备的绑定用户")
	@RequestMapping(value="/updateBindEquip",method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public @ResponseBody WebResult<Object> updateBindEquip(
			@ApiParam(value = "用户ID", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK })Integer userId,
			@ApiParam(value = "滤芯组合ID", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK })Integer filterGroupId,
			@ApiParam(value = "水源（自来水公司）ID", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK })Integer waterAreaId,
			@ApiParam(value = "设备编号", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK })String equipCode){
		equipService.updateUserAndRelevanceOfEquip(userId, filterGroupId, waterAreaId, equipCode); 
		
		WebResult<Object> result=new WebResult<Object>(ResultCode.SUCCESS);
		result.setMessage("绑定成功");
		return result;
	}
	@ApiOperation("工程安装-给用户绑定设备")
	@RequestMapping(value="/bindEquip",method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public @ResponseBody WebResult<Object> bindEquip(
			@ApiParam(value = "用户ID", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK })Integer userId,
			@ApiParam(value = "滤芯组合ID", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK })Integer filterGroupId,
			@ApiParam(value = "水源（自来水公司）ID", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK })Integer waterAreaId,
			@ApiParam(value = "设备编号", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK })String equipCode){
		String msg = equipService.updateUserAndRelevanceOfNewEquip(userId, filterGroupId, waterAreaId, equipCode); 
		if(msg==null){//绑定成功
			WebResult<Object> result=new WebResult<Object>(ResultCode.SUCCESS);
			result.setMessage("绑定成功");
			return result;
		}else{
			WebResult<Object> result=new WebResult<Object>(ResultCode.FAILURE);
			result.setMessage(msg);
			return result;
		}
	}
}
