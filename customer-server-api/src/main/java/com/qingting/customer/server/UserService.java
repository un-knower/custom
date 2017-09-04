package com.qingting.customer.server;

import java.util.List;

import com.qingting.customer.model.User;
import com.smart.mvc.model.Pagination;

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
	 * @Description: 删除用户
	 * @param rowkey 
	 * @return void
	 * @throws
	 */
	void deleteUserByRowKey(List<String> rowkey);
	/**
	 * 
	 * @Title: updateUserByRowKey
	 * @Description: 修改一个用户通过rowkey
	 * @param user 
	 * @return void
	 * @throws
	 */
	//void updateUserByRowKey(User user);
	/**
	 * 
	 * @Title: getUserByMobile
	 * @Description: 查询用户
	 * @param mobile
	 * @return 
	 * @return User
	 * @throws
	 */
	User getUserByMobile(String mobile);
	/**
	 * 
	 * @Title: listUser
	 * @Description: 查询用户
	 * @param pageNo
	 * @param pageSize
	 * @return 
	 * @return Pagination<User>
	 * @throws
	 */
	Pagination<User> listUser(Integer pageNo,Integer pageSize);
	/**
	 * 
	 * @Title: searchUserByMobile
	 * @Description: 搜索用户
	 * @param mobile
	 * @return 
	 * @return List<User>
	 * @throws
	 */
	List<User> searchUserByMobile(String mobile);
}
