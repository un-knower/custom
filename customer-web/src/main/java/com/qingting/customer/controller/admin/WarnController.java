package com.qingting.customer.controller.admin;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qingting.customer.model.hbasedo.Warn;
import com.qingting.customer.server.WarnService;
import com.smart.mvc.model.ResultCode;
import com.smart.mvc.model.WebResult;
import com.smart.mvc.validator.Validator;
import com.smart.mvc.validator.annotation.ValidateParam;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "预警相关")
@Controller
@RequestMapping("/admin/warn")
public class WarnController {
	@Resource
	WarnService warnService;
	
	@ApiOperation("查询设备的预警")
	@RequestMapping(value="/list",method = RequestMethod.GET)
	public @ResponseBody WebResult<List<Warn>> listWarn(
			@ApiParam(value = "设备ID", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK })String equipId
			){
		List<Warn> list = warnService.listWarn(equipId);
		WebResult<List<Warn>> result=new WebResult<List<Warn>>(ResultCode.SUCCESS);
		result.setData(list);
		return result;
	}
}
