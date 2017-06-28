package com.qingting.customer.controller.common;

import java.io.Serializable;

public class SessionUserMsg implements Serializable{

	private static final long serialVersionUID = -8981851134172105467L;
	
	// 登录成功用户名
	private String mobile;
	// 登录对象
	private Object profile;
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Object getProfile() {
		return profile;
	}
	public void setProfile(Object profile) {
		this.profile = profile;
	}
	@Override
	public String toString() {
		return "SessionUserMsg [mobile=" + mobile + ", profile=" + profile + "]";
	}
	
	
}
