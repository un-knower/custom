package com.qingting.customer.baseserver.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qingting.customer.baseserver.UserService;
import com.qingting.customer.common.pojo.hbasedo.User;
import com.qingting.customer.dao.UserDAO;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource
	UserDAO userDAO;
	@Override
	public void insertUser(User user) {
		userDAO.insertUser(user);
	}

	@Override
	public void deleteUserByRowKey(String rowKey) {
		userDAO.deleteUserByRowKey(rowKey);
	}

	@Override
	public void updateUserByRowKey(User user) {
		userDAO.updateUserByRowKey(user);
	}

	@Override
	public User getUserByRowKey(String rowKey) {
		return userDAO.getUserByRowKey(rowKey);
	}

	@Override
	public List<User> listUser() {
		return userDAO.listUser();
	}

}
