package com.qingting.customer.controller.admin;

import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qingting.customer.baseserver.UserService;
import com.qingting.customer.common.pojo.dto.MyDTO;
import com.qingting.customer.common.pojo.hbasedo.User;
import com.qingting.customer.common.pojo.model.Pagination;
import com.smart.mvc.controller.BaseController;
import com.smart.mvc.model.ResultCode;
import com.smart.mvc.model.WebResult;
import com.smart.mvc.validator.Validator;
import com.smart.mvc.validator.annotation.ValidateParam;
import com.smart.sso.client.Config;
import com.smart.sso.client.AuthRpcUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "用户相关")
@Controller("adminUserController")
@RequestMapping("/admin/user")
public class UserController extends BaseController {
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
		user.setCreateTime(Calendar.getInstance());
		System.out.println("user:"+user);
		
		WebResult<Object> result=null;
		result=AuthRpcUtils.findByAccount(user.getMobile());
		if(result.getCode()==ResultCode.FAILURE){//单点服务端用户不存在
			if(userService.getUserByMobileAndId(null, user.getMobile())==null){//本地用户不存在
				System.out.println("准备开始存用户...");
				result = AuthRpcUtils.register(Config.getSsoAppCode(),user.getMobile(), user.getPassword());//单点服务端注册用户
				System.out.println("单点注册结果result："+result);
				
				//User temp=new User();
				//temp.setMobile(mobile);
				//user.setPassword(password);
				userService.insertUser(user);//本地注册用户
				
				result.setMessage("注册成功");
				return result;
			}
		}
		result.setMessage("用户已存在"); 
		return result;
		
		
		
		//userService.insertUser(user);
		
		//return new WebResult<Object>(ResultCode.SUCCESS);
	}
	@ApiOperation("后台删除用户")
	@RequestMapping(value="/delete",method = RequestMethod.POST)
	public @ResponseBody WebResult<Object> delete(
			@ApiParam(value = "rowkeys", required = true) @ValidateParam({ Validator.NOT_BLANK })String rowkeys,
			@ApiParam(value = "ids", required = true) @ValidateParam({ Validator.NOT_BLANK })String ids
			){
		System.out.println("删除的用户rowkey:"+rowkeys);
		AuthRpcUtils.deleteById(getAjaxIds(ids));
		userService.deleteUserByRowKey(getAjaxIdsString(rowkeys));
		WebResult<Object> result=new WebResult<Object>(ResultCode.SUCCESS);
		result.setMessage("删除成功");
		return result;
	}
	@ApiOperation("后台查询所有用户")
	@RequestMapping(value="/list",method = RequestMethod.GET)
	/*@ApiImplicitParams({
	    @ApiImplicitParam(name = "id", value = "主键ID", required = false, paramType = "path"),
	    @ApiImplicitParam(name = "projectName", value = "项目名称", required = true, paramType = "query"),
	    @ApiImplicitParam(name = "userId", value = "用户ID", required = true, paramType = "query")
	    })*/
	public @ResponseBody WebResult<Pagination<User>> list(
			HttpServletRequest request,
			@ApiParam(value = "开始页码", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK }) Integer pageNo,
			@ApiParam(value = "显示条数", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK }) Integer pageSize
			){
		Pagination<User> data = userService.listUser(pageNo,pageSize);
		WebResult<Pagination<User>> result=new WebResult<Pagination<User>>(ResultCode.SUCCESS);
		result.setData(data);
		return result;
	}
	@ApiOperation("获取当前登陆用户的信息")
	@RequestMapping(value="/get",method = RequestMethod.GET)
	public @ResponseBody WebResult<User> getUserMsg(HttpServletRequest request,
			@ApiParam(value = "用户ID", required = false) @RequestParam Integer id,
			@ApiParam(value = "用户电话", required = false) @RequestParam String mobile
			){
		/*SessionUser sessionUser = SessionUtils.getSessionUser(request);
		String account = sessionUser.getAccount();
		System.out.println("account:"+account);
		User user = userService.getUserByAccount(account);
		WebResult<User> result=new WebResult<User>(ResultCode.SUCCESS);
		result.setData(user);*/
		/*WebResult<MyDTO> result=new WebResult<MyDTO>(ResultCode.SUCCESS);
		MyDTO myDTO=new MyDTO();
		myDTO.setPhone("17701879780");
		myDTO.setAttentEquip(2);
		myDTO.setMineEquip(2);
		myDTO.setName("最可爱的人");
		myDTO.setPath("/resource/images/customer/head/zlf.png");
		result.setData(myDTO);
		result.setMessage("获取成功");*/
		WebResult<User> result=new WebResult<User>(ResultCode.SUCCESS);
		User user = userService.getUserByMobileAndId(id, mobile);
		
		/*WebResult<MyDTO> result=new WebResult<MyDTO>(ResultCode.SUCCESS);
		MyDTO myDTO=new MyDTO();
		SessionUserMsg sessionUserMsg = SessionUserMsgUtils.getSessionUserMsg(request);
		User user=(User)sessionUserMsg.getProfile();
		myDTO.setPhone(sessionUserMsg.getMobile());
		myDTO.setName(user.getName());*/
		result.setData(user);
		return result;
	}
}
