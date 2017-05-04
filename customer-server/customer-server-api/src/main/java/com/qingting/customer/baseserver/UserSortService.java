package com.qingting.customer.baseserver;

import java.util.List;

import com.qingting.customer.common.pojo.hbasedo.UserSort;

public interface UserSortService {
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
	 * @Description: 删除用户分类通过rowKey
	 * @param rowKey 
	 * @return void
	 * @throws
	 */
	void deleteUserSortByRowKey(String rowKey);
	/**
	 * 
	 * @Title: updateUserSortByRowKey
	 * @Description: 修改用户分类通过rowKey
	 * @param userSort 
	 * @return void
	 * @throws
	 */
	void updateUserSortByRowKey(UserSort userSort);
	/**
	 * 
	 * @Title: getUserSortByRowKey
	 * @Description: 查询用户分类通过rowKey
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
	 * @return 
	 * @return List<UserSort>
	 * @throws
	 */
	List<UserSort> listUserSort();
}
