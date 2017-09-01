package com.qingting.customer.controller.admin;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qingting.customer.model.hbasedo.Project;
import com.qingting.customer.server.ProjectService;
import com.qingting.customer.server.UserService;
import com.smart.mvc.model.ResultCode;
import com.smart.mvc.model.WebResult;
import com.smart.mvc.validator.Validator;
import com.smart.mvc.validator.annotation.ValidateParam;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "项目相关")
@Controller
@RequestMapping("/admin/project")
public class ProjectController {
	@Resource
	ProjectService projectService;
	@Resource
	UserService userService;
	@ApiOperation("后台添加项目")
	@RequestMapping(value="/insert",method = RequestMethod.POST)
	/*@ApiImplicitParams({
	    @ApiImplicitParam(name = "id", value = "主键ID", required = false, paramType = "path"),
	    @ApiImplicitParam(name = "projectName", value = "项目名称", required = true, paramType = "query"),
	    @ApiImplicitParam(name = "userId", value = "用户ID", required = true, paramType = "query")
	    })*/
	public @ResponseBody WebResult<Object> insertProject(
			HttpServletRequest request,
			@ApiParam @RequestBody Project project
			){
		System.out.println("insertProject——project:"+project);
		
		//SessionUser sessionUser = SessionUtils.getSessionUser(request);
		//String account = sessionUser.getAccount();
		//User user = userService.getUserByAccount(account);
		//project.setUserId(user.getId());
		projectService.insertProject(project);
		//System.out.println("user:"+user);
		System.out.println("project:"+project);
		
		return new WebResult<Object>(ResultCode.SUCCESS);
	}
	@ApiOperation("后台删除项目")
	@RequestMapping(value="/delete",method = RequestMethod.POST)
	public @ResponseBody WebResult<Object> deleteProjectByRowKey(
			@ApiParam(value = "项目行健", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK })String rowKey
			){
		projectService.deleteProjectByRowKey(rowKey);
		return new WebResult<Object>(ResultCode.SUCCESS);
	}
	@ApiOperation("后台更新项目")
	@RequestMapping(value="/update",method = RequestMethod.POST)
	public @ResponseBody WebResult<Object> updateProjectByRowKey(
			@ApiParam @RequestBody Project project
			){
		projectService.updateProjectByRowKey(project);
		return new WebResult<Object>(ResultCode.SUCCESS);
	}
	@ApiOperation("后台查询某个项目")
	@RequestMapping(value="/getNeed",method = RequestMethod.GET)
	public @ResponseBody WebResult<Project> getProjectOfAny(
			@ApiParam(value = "项目行健", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK })String rowKey){
		System.out.println("~~~~~~~~~~~进入getProject~~~~~~~~~~~~");
		Project project = projectService.getProjectByRowkey(rowKey);
		System.out.println("结果："+project);
		WebResult<Project> webResult=new WebResult<Project>(ResultCode.SUCCESS);
		webResult.setData(project);
		return webResult;
	}
	
}
