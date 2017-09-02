package com.qingting.customer.controller.employee;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qingting.customer.model.Monitor;
import com.qingting.customer.model.WaterArea;
import com.qingting.customer.model.dto.EmpMonitorDTO;
import com.qingting.customer.server.MonitorService;
import com.smart.mvc.model.ResultCode;
import com.smart.mvc.model.WebResult;
import com.smart.mvc.validator.Validator;
import com.smart.mvc.validator.annotation.ValidateParam;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "工程测试相关")
@Controller
@RequestMapping("/employee/monitor")
public class EmpMonitorController {
	@Resource
	MonitorService monitorService;
	
	@ApiOperation("查设备最新的监测值值")
	@RequestMapping(value="/getMonitorOfNew",method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public @ResponseBody WebResult<EmpMonitorDTO> getMonitorOfNew(
			@ApiParam(value = "设备编号", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK }) String equipCode
			){
		WebResult<EmpMonitorDTO> result=new WebResult<EmpMonitorDTO>(ResultCode.SUCCESS);
		
		EmpMonitorDTO empMonitorDTO = monitorService.getMonitorOfNewOfEmp(equipCode);
		
		result.setData(empMonitorDTO);
		return result;
	}
}
