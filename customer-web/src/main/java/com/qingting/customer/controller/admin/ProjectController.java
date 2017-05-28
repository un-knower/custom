package com.qingting.customer.controller.admin;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qingting.customer.baseserver.ProjectService;
import com.qingting.customer.baseserver.UserService;
import com.qingting.customer.common.pojo.hbasedo.Project;
import com.qingting.customer.common.pojo.hbasedo.User;
import com.smart.mvc.model.Result;
import com.smart.sso.client.SessionUser;
import com.smart.sso.client.SessionUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "项目相关")
@Controller
@RequestMapping("/project")
public class ProjectController {
	@Resource
	ProjectService projectService;
	@Resource
	UserService userService;
	
	@ApiOperation("查询用户所有项目")
	@RequestMapping(value="/list",method = RequestMethod.GET)
	public @ResponseBody List<Project> listProject(HttpServletRequest request){
		System.out.println("~~~~~~~~~~~进入listProject~~~~~~~~~~~~");
		
		SessionUser sessionUser = SessionUtils.getSessionUser(request);
		String account = sessionUser.getAccount();
		System.out.println("account:"+account);
		User user = userService.getUserByAccount(account);
		
		List<Project> list = projectService.listProjectByUserId(user.getId());
		System.out.println("结果："+list);
		return list;
	}
	@ApiOperation("添加项目")
	@RequestMapping(value="/insert",method = RequestMethod.POST)
	/*@ApiImplicitParams({
	    @ApiImplicitParam(name = "id", value = "主键ID", required = false, paramType = "path"),
	    @ApiImplicitParam(name = "projectName", value = "项目名称", required = true, paramType = "query"),
	    @ApiImplicitParam(name = "userId", value = "用户ID", required = true, paramType = "query")
	    })*/
	public @ResponseBody Result insertProject(
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
		return Result.createSuccessResult();
	}
}
