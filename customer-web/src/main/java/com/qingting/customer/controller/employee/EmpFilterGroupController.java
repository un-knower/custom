package com.qingting.customer.controller.employee;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qingting.customer.common.pojo.dto.FilterGroupDTO;
import com.qingting.customer.common.pojo.hbasedo.FilterGroup;
import com.qingting.customer.common.pojo.hbasedo.User;
import com.qingting.customer.server.FilterGroupService;
import com.smart.mvc.model.ResultCode;
import com.smart.mvc.model.WebResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "滤芯组合相关")
@Controller
@RequestMapping("/employee/filterGroup")
public class EmpFilterGroupController {
	@Resource
	FilterGroupService filterGroupService;
	
	@ApiOperation("查询所有滤芯组合")
	@RequestMapping(value="/list",method = RequestMethod.GET)
	public @ResponseBody WebResult<List<FilterGroupDTO>> list(
			){
		WebResult<List<FilterGroupDTO>> result=new WebResult<List<FilterGroupDTO>>(ResultCode.SUCCESS);
		result.setData(filterGroupService.listDTO());
		result.setMessage("查询成功");
		return result;
	}
}
