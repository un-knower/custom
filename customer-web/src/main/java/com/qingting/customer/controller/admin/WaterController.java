package com.qingting.customer.controller.admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smart.mvc.model.Pagination;
import com.qingting.customer.model.Formula;
import com.qingting.customer.model.WaterArea;
import com.qingting.customer.model.WaterQuality;
import com.qingting.customer.server.FormulaService;
import com.qingting.customer.server.MicroFormulaService;
import com.qingting.customer.server.WaterAreaService;
import com.qingting.customer.server.WaterQualityService;
import com.smart.mvc.model.ResultCode;
import com.smart.mvc.model.WebResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "算法相关")
@Controller
@RequestMapping("/admin/water")
public class WaterController {
	@Resource
	WaterAreaService waterAreaService;
	@Resource
	WaterQualityService waterQualityService;
	@ApiOperation("页面跳转-水源管理页")
	@RequestMapping(value="/waterArea",method = RequestMethod.GET,produces="text/html")
	public String waterArea() {
		return "/admin/water/waterArea";
	}
	@ApiOperation("后台插入水源")
	@RequestMapping(value="/insertWaterArea",method = RequestMethod.POST)
	public @ResponseBody WebResult<Object> insertWaterArea(
			@ApiParam @RequestBody WaterArea waterArea){
		System.out.println(waterArea);
		waterAreaService.insert(waterArea);
		return new WebResult<Object>(ResultCode.SUCCESS);
	}
	@ApiOperation("查询所有水源")
	@RequestMapping(value="/listWaterArea",method = RequestMethod.POST,produces = "application/json; charset=utf-8")
	public @ResponseBody WebResult<Pagination<WaterArea>> listWaterArea(
			@ApiParam(value = "page", required = true) @RequestBody Pagination<WaterArea> page
			){
		WebResult<Pagination<WaterArea>> result=new WebResult<Pagination<WaterArea>>(ResultCode.SUCCESS);
		result.setData(waterAreaService.list(page));
		return result;
	}
	
	
	@ApiOperation("页面跳转-水质管理页")
	@RequestMapping(value="/waterQuality",method = RequestMethod.GET,produces="text/html")
	public String waterQuality() {
		return "/admin/water/waterQuality";
	}
	@ApiOperation("后台插入水质")
	@RequestMapping(value="/insertWaterQuality",method = RequestMethod.POST)
	public @ResponseBody WebResult<Object> insertWaterQuality(
			@ApiParam @RequestBody WaterQuality waterQuality){
		System.out.println(waterQuality);
		waterQualityService.insert(waterQuality);
		return new WebResult<Object>(ResultCode.SUCCESS);
	}
	@ApiOperation("查询所有水质")
	@RequestMapping(value="/listWaterQuality",method = RequestMethod.POST,produces = "application/json; charset=utf-8")
	public @ResponseBody WebResult<Pagination<WaterQuality>> listWaterQuality(
			@ApiParam(value = "page", required = true) @RequestBody Pagination<WaterQuality> page
			){
		WebResult<Pagination<WaterQuality>> result=new WebResult<Pagination<WaterQuality>>(ResultCode.SUCCESS);
		result.setData(waterQualityService.list(page));
		return result;
	}
}
