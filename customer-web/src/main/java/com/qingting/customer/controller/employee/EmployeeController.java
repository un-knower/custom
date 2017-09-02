package com.qingting.customer.controller.employee;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qingting.customer.model.User;
import com.qingting.customer.model.dto.UserDTO;
import com.qingting.customer.server.UserService;
import com.smart.mvc.model.ResultCode;
import com.smart.mvc.model.WebResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "企业员工相关")
@Controller
@RequestMapping("/employee/employee")
public class EmployeeController {
	@Resource
	UserService userService;
	
	@ApiOperation("搜索用户的信息")
	@RequestMapping(value="/searchUser",method = RequestMethod.GET)
	public @ResponseBody WebResult<List<UserDTO>> searchUser(
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
		WebResult<List<UserDTO>> result=new WebResult<List<UserDTO>>(ResultCode.SUCCESS);
		List<User> list = userService.searchUserByMobile(mobile);
		List<UserDTO> listDTO=new ArrayList<UserDTO>();
		for (User user : list) {
			UserDTO userDTO=new UserDTO();
			userDTO.setId(user.getId());
			userDTO.setMobile(user.getMobile());
			userDTO.setName(user.getName());
			listDTO.add(userDTO);
		}
		/*WebResult<MyDTO> result=new WebResult<MyDTO>(ResultCode.SUCCESS);
		MyDTO myDTO=new MyDTO();
		SessionUserMsg sessionUserMsg = SessionUserMsgUtils.getSessionUserMsg(request);
		User user=(User)sessionUserMsg.getProfile();
		myDTO.setPhone(sessionUserMsg.getMobile());
		myDTO.setName(user.getName());*/
		result.setData(listDTO);
		return result;
	}
}
