package com.qingting.customer.controller.admin;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qingting.customer.baseserver.EquipService;
import com.qingting.customer.common.pojo.hbasedo.Equip;
import com.smart.mvc.model.Result;
import com.smart.mvc.validator.Validator;
import com.smart.mvc.validator.annotation.ValidateParam;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
@Api(tags = "设备相关")
@Controller
@RequestMapping("/equip")
public class EquipController {
	@Resource
	EquipService equipService;
	
	@ApiOperation("查询我的设备")
	@RequestMapping(value="/list",method = RequestMethod.GET)
	public @ResponseBody List<Equip> listEquip(
			@ApiParam(value = "项目ID", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK })int projectId){
		return equipService.listEquipByProjectId(projectId);
	}
	@ApiOperation("插入我的设备")
	@RequestMapping(value="/insert",method = RequestMethod.POST)
	public @ResponseBody Result insertEquip(
			@ApiParam @RequestBody Equip equip){
		equipService.insertEquip(equip);
		return Result.createSuccessResult();
	}
}
