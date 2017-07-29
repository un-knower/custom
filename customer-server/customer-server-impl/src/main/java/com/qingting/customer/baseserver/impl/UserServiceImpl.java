package com.qingting.customer.baseserver.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qingting.customer.baseserver.UserService;
import com.qingting.customer.common.pojo.hbasedo.User;
import com.qingting.customer.common.pojo.model.Pagination;
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
	public void deleteUserByRowKey(List<String> rowkey) {
		userDAO.deleteUserByRowKey(rowkey);
	}

	@Override
	public void updateUserByRowKey(User user) {
		userDAO.updateUserByRowKey(user);
	}

	@Override
	public User getUserByMobileAndId(Integer id, String mobile) {
		return userDAO.getUserByMobileAndId(id, mobile);
	}

	@Override
	public Pagination<User> listUser(Integer pageNo, Integer pageSize) {
		return userDAO.listUser(pageNo, pageSize);
	}
	
}
