package com.qingting.customer.controller.admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qingting.customer.model.hbasedo.Filter;
import com.qingting.customer.model.hbasedo.FilterGroup;
import com.qingting.customer.model.page.Pagination;
import com.qingting.customer.server.FilterGroupService;
import com.qingting.customer.server.FilterService;
import com.smart.mvc.model.ResultCode;
import com.smart.mvc.model.WebResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "滤芯相关")
@Controller
@RequestMapping("/admin/filter")
public class FilterController {
	@Resource
	FilterService filterService;
	@Resource
	FilterGroupService filterGroupService;
	@ApiOperation("页面跳转-滤芯管理页")
	@RequestMapping(value="/filter",method = RequestMethod.GET,produces="text/html")
	public String filter() {
		return "/admin/filter/filter";
	}
	@ApiOperation("后台插入滤芯")
	@RequestMapping(value="/insertFilter",method = RequestMethod.POST)
	public @ResponseBody WebResult<Object> insertFilter(
			@ApiParam @RequestBody Filter filter){
		System.out.println(filter);
		filterService.insert(filter);
		return new WebResult<Object>(ResultCode.SUCCESS);
	}
	@ApiOperation("查询一个滤芯")
	@RequestMapping(value="/getFilter",method = RequestMethod.POST,produces = "application/json; charset=utf-8")
	public @ResponseBody WebResult<Filter> getFilter(
			@ApiParam(value = "id", required = true) @RequestBody Integer id
			){
		WebResult<Filter> result=new WebResult<Filter>(ResultCode.SUCCESS);
		result.setData(filterService.getById(id));
		return result;
	}
	@ApiOperation("查询所有滤芯")
	@RequestMapping(value="/listFilter",method = RequestMethod.POST,produces = "application/json; charset=utf-8")
	public @ResponseBody WebResult<Pagination<Filter>> listFilter(
			@ApiParam(value = "page", required = true) @RequestBody Pagination<Filter> page
			){
		WebResult<Pagination<Filter>> result=new WebResult<Pagination<Filter>>(ResultCode.SUCCESS);
		result.setData(filterService.list(page));
		return result;
	}
	
	@ApiOperation("页面跳转-滤芯组合页")
	@RequestMapping(value="/filterGroup",method = RequestMethod.GET,produces="text/html")
	public String filterGroup() {
		return "/admin/filter/filterGroup";
	}
	@ApiOperation("后台插入滤芯组合")
	@RequestMapping(value="/insertFilterGroup",method = RequestMethod.POST)
	public @ResponseBody WebResult<Object> insertFilterGroup(
			@ApiParam @RequestBody FilterGroup filterGroup){
		System.out.println(filterGroup);
		filterGroupService.insert(filterGroup);
		return new WebResult<Object>(ResultCode.SUCCESS);
	}
	@ApiOperation("查询所有滤芯组合")
	@RequestMapping(value="/listFilterGroup",method = RequestMethod.POST,produces = "application/json; charset=utf-8")
	public @ResponseBody WebResult<Pagination<FilterGroup>> listFilterGroup(
			@ApiParam(value = "page", required = true) @RequestBody Pagination<FilterGroup> page
			){
		WebResult<Pagination<FilterGroup>> result=new WebResult<Pagination<FilterGroup>>(ResultCode.SUCCESS);
		result.setData(filterGroupService.list(page));
		return result;
	}
}
