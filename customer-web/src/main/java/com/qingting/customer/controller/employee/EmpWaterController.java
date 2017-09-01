package com.qingting.customer.controller.employee;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qingting.customer.model.hbasedo.Formula;
import com.qingting.customer.model.hbasedo.WaterArea;
import com.qingting.customer.model.hbasedo.WaterQuality;
import com.qingting.customer.model.page.Pagination;
import com.qingting.customer.server.FormulaService;
import com.qingting.customer.server.MicroFormulaService;
import com.qingting.customer.server.WaterAreaService;
import com.qingting.customer.server.WaterQualityService;
import com.smart.mvc.model.ResultCode;
import com.smart.mvc.model.WebResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "水源相关")
@Controller
@RequestMapping("/employee/water")
public class EmpWaterController {
	@Resource
	WaterAreaService waterAreaService;
	
	
	@ApiOperation("查询所有水源")
	@RequestMapping(value="/listWaterArea",method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public @ResponseBody WebResult<List<WaterArea>> listWaterArea(){
		WebResult<List<WaterArea>> result=new WebResult<List<WaterArea>>(ResultCode.SUCCESS);
		result.setData(waterAreaService.listAll());
		return result;
	}
	
}
