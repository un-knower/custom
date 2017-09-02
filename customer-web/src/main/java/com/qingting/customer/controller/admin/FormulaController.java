package com.qingting.customer.controller.admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smart.mvc.model.Pagination;
import com.qingting.customer.model.Formula;
import com.qingting.customer.model.MicroFormula;
import com.qingting.customer.server.FormulaService;
import com.qingting.customer.server.MicroFormulaService;
import com.smart.mvc.model.ResultCode;
import com.smart.mvc.model.WebResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "算法相关")
@Controller
@RequestMapping("/admin/formula")
public class FormulaController {
	@Resource
	FormulaService formulaService;
	@Resource
	MicroFormulaService microFormulaService;
	@ApiOperation("页面跳转-滤芯公式页")
	@RequestMapping(value="/formula",method = RequestMethod.GET,produces="text/html")
	public String formula() {
		return "/admin/formula/formula";
	}
	@ApiOperation("后台插入滤芯公式")
	@RequestMapping(value="/insertFormula",method = RequestMethod.POST)
	public @ResponseBody WebResult<Object> insertFormula(
			@ApiParam @RequestBody Formula formula){
		System.out.println(formula);
		formulaService.insert(formula);
		return new WebResult<Object>(ResultCode.SUCCESS);
	}
	@ApiOperation("查询所有滤芯公式")
	@RequestMapping(value="/listFormula",method = RequestMethod.POST,produces = "application/json; charset=utf-8")
	public @ResponseBody WebResult<Pagination<Formula>> listFormula(
			@ApiParam(value = "page", required = true) @RequestBody Pagination<Formula> page
			){
		WebResult<Pagination<Formula>> result=new WebResult<Pagination<Formula>>(ResultCode.SUCCESS);
		result.setData(formulaService.list(page));
		return result;
	}
	
	
	@ApiOperation("页面跳转-微生物公式页")
	@RequestMapping(value="/microFormula",method = RequestMethod.GET,produces="text/html")
	public String microFormula() {
		return "/admin/formula/microFormula";
	}
	@ApiOperation("后台插入微生物公式")
	@RequestMapping(value="/insertMicroFormula",method = RequestMethod.POST)
	public @ResponseBody WebResult<Object> insertMicroFormula(
			@ApiParam @RequestBody MicroFormula microFormula){
		System.out.println(microFormula);
		microFormulaService.insert(microFormula);
		return new WebResult<Object>(ResultCode.SUCCESS);
	}
	@ApiOperation("查询所有滤芯公式")
	@RequestMapping(value="/listMicroFormula",method = RequestMethod.POST,produces = "application/json; charset=utf-8")
	public @ResponseBody WebResult<Pagination<MicroFormula>> listMicroFormula(
			@ApiParam(value = "page", required = true) @RequestBody Pagination<MicroFormula> page
			){
		WebResult<Pagination<MicroFormula>> result=new WebResult<Pagination<MicroFormula>>(ResultCode.SUCCESS);
		result.setData(microFormulaService.list(page));
		return result;
	}
}
