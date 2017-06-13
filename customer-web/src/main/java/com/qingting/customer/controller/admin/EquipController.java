package com.qingting.customer.controller.admin;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qingting.customer.baseserver.EquipService;
import com.qingting.customer.common.pojo.hbasedo.Equip;
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
	
	@ApiOperation("后台插入设备")
	@RequestMapping(value="/insert",method = RequestMethod.POST)
	public @ResponseBody WebResult<Object> insertEquip(
			@ApiParam @RequestBody Equip equip){
		equipService.insertEquip(equip);
		return new WebResult<Object>(ResultCode.SUCCESS);
	}
	@ApiOperation("后台删除设备")
	@RequestMapping(value="/delete",method = RequestMethod.POST)
	public @ResponseBody WebResult<Object> deleteEquipByRowKey(
			@ApiParam(value = "设备行健", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK })String rowKey
			){
		equipService.deleteEquipByRowKey(rowKey);
		return new WebResult<Object>(ResultCode.SUCCESS);
	}
	@ApiOperation("后台更新设备")
	@RequestMapping(value="/update",method = RequestMethod.POST)
	public @ResponseBody WebResult<Object> updateEquipByRowKey(
			@ApiParam @RequestBody Equip equip
			){
		equipService.updateEquipByRowKey(equip);
		return new WebResult<Object>(ResultCode.SUCCESS);
	}
}
