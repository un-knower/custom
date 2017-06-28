package com.qingting.customer.baseserver;

import java.util.List;

import com.qingting.customer.common.pojo.hbasedo.User;

public interface UserService {
	/**
	 * 
	 * @Title: insertUser
	 * @Description: 插入一个用户
	 * @param user 
	 * @return void
	 * @throws
	 */
	void insertUser(User user);
	/**
	 * 
	 * @Title: deleteUserByRowKey
	 * @Description: 删除一个用户通过rowKey
	 * @param rowKey 
	 * @return void
	 * @throws
	 */
	void deleteUserByRowKey(String rowKey);
	/**
	 * 
	 * @Title: updateUserByRowKey
	 * @Description: 修改一个用户通过rowKey
	 * @param user 
	 * @return void
	 * @throws
	 */
	void updateUserByRowKey(User user);
	/**
	 * 
	 * @Title: getUserByRowKey
	 * @Description: 查询一个用户通过rowKey
	 * @param rowKey
	 * @return 
	 * @return User
	 * @throws
	 */
	User getUserByRowKey(String rowKey);
	/**
	 * 
	 * @Title: getUserByMobile
	 * @Description: 查询一个用户通过mobile
	 * @param mobile
	 * @return 
	 * @return User
	 * @throws
	 */
	User getUserByMobile(String mobile);
	/**
	 * 
	 * @Title: listUser
	 * @Description: 查询所有用户
	 * @return 
	 * @return List<User>
	 * @throws
	 */
	List<User> listUser();
}
