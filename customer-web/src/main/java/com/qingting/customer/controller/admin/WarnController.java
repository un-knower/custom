package com.qingting.customer.controller.admin;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qingting.customer.baseserver.WarnService;
import com.qingting.customer.common.pojo.hbasedo.Warn;
import com.smart.mvc.model.Result;
import com.smart.mvc.validator.Validator;
import com.smart.mvc.validator.annotation.ValidateParam;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "预警相关")
@Controller
@RequestMapping("/warn")
public class WarnController {
	@Resource
	WarnService warnService;
	
	@ApiOperation("查询设备的预警")
	@RequestMapping(value="/list",method = RequestMethod.GET)
	public @ResponseBody Result listWarn(
			@ApiParam(value = "设备ID", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK })String equipId
			){
		List<Warn> list = warnService.listWarn(equipId);
		Result result=Result.createSuccessResult();
		result.setData(list);
		return result;
	}
}
