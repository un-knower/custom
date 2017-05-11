package com.qingting.customer.controller.admin;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
@Api(tags = "项目相关")
@Controller
@RequestMapping("/project")
public class ProjectController {
	@Resource
	ProjectService projectService;
	@Resource
	UserService userService;
	
	@ApiOperation("查询用户所有项目")
	@RequestMapping("/list")
	public @ResponseBody List<Project> listProject(HttpServletRequest request){
		SessionUser sessionUser = SessionUtils.getSessionUser(request);
		String account = sessionUser.getAccount();
		User user = userService.getUserByAccount(account);
		System.out.println("~~~~~~~~~~~进入listProject~~~~~~~~~~~~");
		List<Project> list = projectService.listProjectByUserId(user.getId());
		System.out.println("结果："+list);
		return list;
	}
	@ApiOperation("添加项目")
	@RequestMapping("/insert")
	public @ResponseBody Result insertProject(
			Project project
			){
		
		return null;
	}
}
