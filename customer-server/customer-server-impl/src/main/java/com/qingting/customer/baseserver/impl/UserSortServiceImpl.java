package com.qingting.customer.baseserver.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qingting.customer.baseserver.UserSortService;
import com.qingting.customer.common.pojo.hbasedo.UserSort;
import com.qingting.customer.dao.UserSortDAO;
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
	public List<UserSort> listUserSort() {
		return userSortDAO.listUserSort();
	}

}
