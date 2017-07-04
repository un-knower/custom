package com.qingting.customer.controller.admin;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qingting.customer.baseserver.UserService;
import com.qingting.customer.common.pojo.hbasedo.User;
import com.smart.mvc.model.ResultCode;
import com.smart.mvc.model.WebResult;
import com.smart.mvc.validator.Validator;
import com.smart.mvc.validator.annotation.ValidateParam;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "用户相关")
@Controller("adminUserController")
@RequestMapping("/admin/user")
public class UserController {
	@Resource
	UserService userService;
	
	@ApiOperation("用户管理-消费者用户")
	@RequestMapping(value="/consumer",method = RequestMethod.GET)
	public String consumer(){
		return "/admin/user/consumer";
	}
	@ApiOperation("用户管理-企业员工")
	@RequestMapping(value="/employee",method = RequestMethod.GET)
	public String employee(){
		return "/admin/user/employee";
	}
	@ApiOperation("后台添加和修改用户")
	@RequestMapping(value="/save",method = RequestMethod.POST)
	/*@ApiImplicitParams({
	    @ApiImplicitParam(name = "id", value = "主键ID", required = false, paramType = "path"),
	    @ApiImplicitParam(name = "projectName", value = "项目名称", required = true, paramType = "query"),
	    @ApiImplicitParam(name = "userId", value = "用户ID", required = true, paramType = "query")
	    })*/
	public @ResponseBody WebResult<Object> save(
			HttpServletRequest request,
			@ApiParam @RequestBody User user
			){
		System.out.println("user:"+user);
		
		userService.insertUser(user);
		
		return new WebResult<Object>(ResultCode.SUCCESS);
	}
	@ApiOperation("后台查询所有用户")
	@RequestMapping(value="/list",method = RequestMethod.GET)
	/*@ApiImplicitParams({
	    @ApiImplicitParam(name = "id", value = "主键ID", required = false, paramType = "path"),
	    @ApiImplicitParam(name = "projectName", value = "项目名称", required = true, paramType = "query"),
	    @ApiImplicitParam(name = "userId", value = "用户ID", required = true, paramType = "query")
	    })*/
	public @ResponseBody WebResult<List<User>> list(
			HttpServletRequest request,
			@ApiParam(value = "开始页码", required = true) @ValidateParam({ Validator.NOT_BLANK }) Integer pageNo,
			@ApiParam(value = "显示条数", required = true) @ValidateParam({ Validator.NOT_BLANK }) Integer pageSize
			){
		List<User> data=userService.listUser();
		WebResult<List<User>> result=new WebResult<List<User>>(ResultCode.SUCCESS);
		result.setData(data);
		return result;
	}
}
