package com.qingting.customer.controller.common;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.support.XmlWebApplicationContext;

import com.qingting.customer.common.pojo.hbasedo.User;
import com.qingting.customer.server.UserService;
import com.smart.mvc.exception.ServiceException;
import com.smart.mvc.model.ResultCode;
import com.smart.sso.client.ClientFilter;
import com.smart.sso.client.SessionUser;
import com.smart.sso.client.SessionUtils;

public class UserMsgFilter extends ClientFilter {
	// 客户端提供的RPC服务，由Spring容器注入
	//protected static UserService userService=SpringUtils.getBean("userService");
	protected static UserService userService;//=
			
			//(UserService)new ClassPathXmlApplicationContext("applicationContext*.xml").getBean("userService")
			//;//=SpringUtils.getBean(UserService.class);
	static{
		/*@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");  
		 BeanFactory factory=(BeanFactory) ctx;
		 userService=(UserService)factory.getBean("userService");*/
	}
	@Override
	public void init(javax.servlet.FilterConfig filterConfig) throws ServletException {
		 /*ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext*.xml");  
		 BeanFactory factory=(BeanFactory) ctx;
		 userService=(UserService)factory.getBean("userService");
		 //userService=(UserService) ctx.getBean("userService");*/
		ServletContext sc = filterConfig.getServletContext(); 
        XmlWebApplicationContext cxt = (XmlWebApplicationContext)WebApplicationContextUtils.getWebApplicationContext(sc);
        
        if(cxt != null && cxt.getBean("userService") != null && userService == null)
            userService = (UserService) cxt.getBean("userService");   
        else
        	System.out.println("注入失败.");
	}
	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException, ServiceException {
		System.out.println("进入用户信息过滤器.");
		SessionUserMsg sessionUserMsg = SessionUserMsgUtils.getSessionUserMsg(request);
		if(sessionUserMsg!=null){
			chain.doFilter(request, response);
		}else{
			SessionUser sessionUser = SessionUtils.getSessionUser(request);
			System.out.println("sessionUser:"+sessionUser);
			if(sessionUser!=null){
				System.out.println("userService1:"+userService);
				//User user=new User();
				User user=userService.getUserByMobile(sessionUser.getAccount());
				//user.setMobile(sessionUser.getAccount());
				//user.setName("zlf");
				//user.setPortraitUrl("/resource/images/customer/portrait/zlf.png");;
				System.out.println("user:"+user);
				if(user!=null){
					sessionUserMsg=new SessionUserMsg();
					sessionUserMsg.setMobile(user.getMobile());
					sessionUserMsg.setProfile(user);
					SessionUserMsgUtils.setSessionUserMsg(request,sessionUserMsg);
					chain.doFilter(request, response);
				}else{
					throw new ServiceException(ResultCode.CUSTOM_USER_NOEXIST, "单点系统用户存在，但客户端用户信息不存在");
				}
			}else{
				throw new ServiceException(ResultCode.CUSTOM_LOGIN_ERROR, "客户端登陆错误");
			}
		}
	}
}
