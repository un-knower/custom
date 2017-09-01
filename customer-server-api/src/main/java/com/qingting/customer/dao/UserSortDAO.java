package com.qingting.customer.dao;

import com.qingting.customer.model.hbasedo.UserSort;
import com.qingting.customer.model.page.Pagination;

public interface UserSortDAO {
	/**
	 * 
	 * @Title: insertUserSort
	 * @Description: 插入用户分类
	 * @param userSort 
	 * @return void
	 * @throws
	 */
	void insertUserSort(UserSort userSort);
	/**
	 * 
	 * @Title: deleteUserSortByRowKey
	 * @Description: 删除用户分类
	 * @param rowKey 
	 * @return void
	 * @throws
	 */
	void deleteUserSortByRowKey(String rowKey);
	/**
	 * 
	 * @Title: updateUserSortByRowKey
	 * @Description: 修改用户分类
	 * @param userSort 
	 * @return void
	 * @throws
	 */
	void updateUserSortByRowKey(UserSort userSort);
	/**
	 * 
	 * @Title: getUserSortByRowKey
	 * @Description: 查询用户分类
	 * @param rowKey
	 * @return 
	 * @return UserSort
	 * @throws
	 */
	UserSort getUserSortByRowKey(String rowKey);
	/**
	 * 
	 * @Title: listUserSort
	 * @Description: 查询所有用户分类
	 * @param pageNo
	 * @param pageSize
	 * @return 
	 * @return Pagination<UserSort>
	 * @throws
	 */
	Pagination<UserSort> listUserSort(Integer pageNo,Integer pageSize);
}
