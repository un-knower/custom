package com.qingting.operation.server.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.qingting.customer.dao.UserDAO;
import com.qingting.operation.model.User;
import com.qingting.operation.server.UserService;

public class UserServiceImpl implements UserService {
	@Resource
	UserDAO userDAO;
	@Override
	public List<User> searchUser(String mobile) {
		List<com.qingting.customer.model.hbasedo.User> list = userDAO.searchUserByMobile(mobile);
		List<User> result=new ArrayList<User>();
		for (com.qingting.customer.model.hbasedo.User user : list) {
			User u=new User();
			u.setId(user.getId());
			u.setMobile(user.getMobile());
			u.setName(user.getName());
			result.add(u);
		}
		return result;
	}

}
