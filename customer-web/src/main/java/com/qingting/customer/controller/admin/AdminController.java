package com.qingting.customer.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smart.mvc.model.ResultCode;
import com.smart.mvc.model.WebResult;
import com.smart.sso.client.ApplicationPermissionUtils;
import com.smart.sso.client.SessionPermission;
import com.smart.sso.client.SessionUtils;
import com.smart.sso.rpc.RpcPermission;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author zlf
 */
@Api(tags = "后台首页管理")
@Controller
@RequestMapping("/admin/admin")
public class AdminController {

	@ApiOperation("页面跳转-后台初始页")
	@RequestMapping(method = RequestMethod.GET)
	public String execute(HttpServletRequest request, Model model) {
		System.out.println("进入首页~~");
		SessionPermission sessionPermission = SessionUtils.getSessionPermission(request);
		// 设置当前登录用户没有的权限
		model.addAttribute("sessionUserNoPermissions", sessionPermission == null ? null : sessionPermission.getNoPermissions());
		// 默认首页
		// model.addAttribute("defaultPage", null);
		return "/admin/admin";
	}

	@ApiOperation("后台菜单")
	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public @ResponseBody WebResult<List<RpcPermission>> menu(HttpServletRequest request) {
		SessionPermission sessionPermission = SessionUtils.getSessionPermission(request);
		// 如果配置的权限拦截器，则获取登录用户权限下的菜单，没有权限拦截限制的情况下，获取当前系统菜单呈现
		//return Result.createSuccessResult().setData(
		//		sessionPermission == null ? ApplicationPermissionUtils.getApplicationMenuList() : sessionPermission.getMenuList());
		WebResult<List<RpcPermission>> result=new WebResult<List<RpcPermission>>(ResultCode.SUCCESS);
		result.setData(
				sessionPermission == null ? ApplicationPermissionUtils.getApplicationMenuList() : sessionPermission.getMenuList()
				);
		for (RpcPermission  rp: result.getData()) {
			System.out.println("RpcPermission:"+rp);
		}
		System.out.println("sessionPermission:"+sessionPermission.getMenuList());
		System.out.println("ApplicationMenuList:"+ApplicationPermissionUtils.getApplicationMenuList());
		return result;
	}
}