package com.qingting.customer.server.impl;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.smart.mvc.model.Pagination;
import com.qingting.customer.dao.UserDAO;
import com.qingting.customer.model.User;
import com.qingting.customer.server.UserService;

@Service("userService")
public class UserServiceImpl implements UserService,com.qingting.operation.server.UserService {
	@Resource
	UserDAO userDAO;

	@Override
	public void insertUser(User user) {
		userDAO.insertUser(user);
	}

	@Override
	public void deleteUserByRowKey(List<String> rowkey) {
		userDAO.deleteUserByRowKey(rowkey);
	}

	@Override
	public void updateUserByRowKey(User user) {
		userDAO.updateUserByRowKey(user);
	}

	@Override
	public Pagination<User> listUser(Integer pageNo, Integer pageSize) {
		return userDAO.listUser(pageNo, pageSize);
	}

	@Override
	public List<User> searchUserByMobile(String mobile) {
		return userDAO.searchUserByMobile(mobile);
	}

	@Override
	public User getUserByMobile(String mobile) {
		return userDAO.getUserByMobile(mobile);
	}

	@Override
	public List<com.qingting.operation.model.User> searchUser(String mobile) {
		List<User> list = userDAO.searchUserByMobile(mobile);
		List<com.qingting.operation.model.User> result = new ArrayList<com.qingting.operation.model.User>();
		for (User user : list) {
			com.qingting.operation.model.User u = new com.qingting.operation.model.User();
			u.setId(user.getId());
			u.setMobile(user.getMobile());
			u.setName(user.getName());
		}
		return result;
	}
	
}
