package com.qingting.customer.controller.consumer;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qingting.customer.baseserver.ProjectService;
import com.qingting.customer.baseserver.UserService;
import com.qingting.customer.common.pojo.hbasedo.Project;
import com.qingting.customer.common.pojo.hbasedo.User;
import com.smart.mvc.model.ResultCode;
import com.smart.mvc.model.WebResult;
import com.smart.mvc.validator.Validator;
import com.smart.mvc.validator.annotation.ValidateParam;
import com.smart.sso.client.SessionUser;
import com.smart.sso.client.SessionUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "项目相关")
@Controller("consumerProjectController")
@RequestMapping("/consumer/project")
public class ProjectController {
	@Resource
	ProjectService projectService;
	@Resource
	UserService userService;
	
	@ApiOperation("获取当前登陆用户的所有项目")
	@RequestMapping(value="/list",method = RequestMethod.GET)
	public @ResponseBody WebResult<List<Project>> listProjectOfUser(HttpServletRequest request){
		System.out.println("~~~~~~~~~~~进入listProject~~~~~~~~~~~~");
		
		SessionUser sessionUser = SessionUtils.getSessionUser(request);
		String account = sessionUser.getAccount();
		System.out.println("account:"+account);
		User user = userService.getUserByAccount(account);
		
		List<Project> list = projectService.listProjectByUserId(user.getId());
		System.out.println("结果："+list);
		WebResult<List<Project>> webResult=new WebResult<List<Project>>(ResultCode.SUCCESS);
		webResult.setData(list);
		return webResult;
	}
	@ApiOperation("获取当前登陆用户的某个项目")
	@RequestMapping(value="/get",method = RequestMethod.GET)
	public @ResponseBody WebResult<Project> getProjectOfUser(HttpServletRequest request,
			@ApiParam(value = "项目行健", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK })String rowKey){
		System.out.println("~~~~~~~~~~~进入getProject~~~~~~~~~~~~");
		
		SessionUser sessionUser = SessionUtils.getSessionUser(request);
		String account = sessionUser.getAccount();
		System.out.println("account:"+account);
		User user = userService.getUserByAccount(account);
		
		Project project = projectService.getProjectByRowkey(rowKey);
		System.out.println("结果："+project);
		if(project.getUserId().equals(user.getId())){
			WebResult<Project> webResult=new WebResult<Project>(ResultCode.SUCCESS);
			webResult.setData(project);
			return webResult;
		}else{
			WebResult<Project> webResult=new WebResult<Project>(ResultCode.FAILURE);
			webResult.setData(project);
			return webResult;
		}
	}
}
