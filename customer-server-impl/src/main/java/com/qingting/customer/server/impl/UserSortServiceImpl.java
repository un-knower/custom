package com.qingting.customer.server.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qingting.customer.model.hbasedo.UserSort;
import com.qingting.customer.model.page.Pagination;
import com.qingting.customer.dao.UserSortDAO;
import com.qingting.customer.server.UserSortService;
@Service("userSortService")
public class UserSortServiceImpl implements UserSortService {
	@Resource
	UserSortDAO userSortDAO;

	@Override
	public void insertUserSort(UserSort userSort) {
		userSortDAO.insertUserSort(userSort);
	}

	@Override
	public void deleteUserSortByRowKey(String rowKey) {
		userSortDAO.deleteUserSortByRowKey(rowKey);
	}

	@Override
	public void updateUserSortByRowKey(UserSort userSort) {
		userSortDAO.updateUserSortByRowKey(userSort);
	}

	@Override
	public UserSort getUserSortByRowKey(String rowKey) {
		return userSortDAO.getUserSortByRowKey(rowKey);
	}

	@Override
	public Pagination<UserSort> listUserSort(Integer pageNo, Integer pageSize) {
		return userSortDAO.listUserSort(pageNo, pageSize);
	}

	

	
}
