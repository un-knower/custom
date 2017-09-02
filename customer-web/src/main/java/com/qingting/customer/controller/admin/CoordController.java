package com.qingting.customer.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qingting.customer.model.Project;
import com.smart.mvc.model.WebResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "经纬度获取")
@Controller
@RequestMapping("/admin/coord")
public class CoordController {
	@ApiOperation("获取多个经纬度")
	@RequestMapping(value="/list",method = RequestMethod.GET)
	public @ResponseBody WebResult<List<Project>> listCoord(HttpServletRequest request){
		return null;
	}
}
