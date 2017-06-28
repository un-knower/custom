package com.qingting.customer.controller.common;

import javax.servlet.http.HttpServletRequest;


/**
 * 当前已登录用户Session
 * 
 * @author Joe
 */
public class SessionUserMsgUtils {
	
	/**
	 * 客户端用户信息
	 */
	public static final String SESSION_USERMSG = "_sessionUserMsg";
	
	public static SessionUserMsg getSessionUserMsg(HttpServletRequest request) {
		return (SessionUserMsg) request.getSession().getAttribute(SESSION_USERMSG);
	}

	public static void setSessionUserMsg(HttpServletRequest request, SessionUserMsg sessionUserMsg) {
		request.getSession().setAttribute(SESSION_USERMSG, sessionUserMsg);
	}
}