package com.qingting.customer.controller.consumer;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
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
@Controller("consumerEquipController")
@RequestMapping("/consumer/equip")
public class EquipController {
	@Resource
	EquipService equipService;
	
	@ApiOperation("用户查询所有设备")
	@RequestMapping(value="/list",method = RequestMethod.GET)
	public @ResponseBody WebResult<List<Equip>> listEquip(
			@ApiParam(value = "项目ID", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK })int projectId){
		List<Equip> list = equipService.listEquipByProjectId(projectId);
		WebResult<List<Equip>> result=new WebResult<List<Equip>>(ResultCode.SUCCESS);
		result.setData(list);
		return result;
	}
}
