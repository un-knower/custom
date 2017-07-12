package com.qingting.customer.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.smart.sso.client.SessionPermission;
import com.smart.sso.client.SessionUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "引导页")
@Controller
@RequestMapping("/lead")
public class LeadController {
	@ApiOperation("页面跳转-引导页")
	@RequestMapping(method = RequestMethod.GET,produces="text/html")
	public String execute(HttpServletRequest request, Model model) {
		System.out.println("进入引导页~~");
		SessionPermission sessionPermission = SessionUtils.getSessionPermission(request);
		// 设置当前登录用户没有的权限
		model.addAttribute("sessionUserNoPermissions", sessionPermission == null ? null : sessionPermission.getNoPermissions());
		// 默认首页
		// model.addAttribute("defaultPage", null);
		return "/lead";
	}
}
