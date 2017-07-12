package com.qingting.customer.baseserver;

import java.util.List;

import com.qingting.customer.common.pojo.hbasedo.User;
import com.qingting.customer.common.pojo.model.Pagination;

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
	 * @Description: 删除一个用户通过rowkey
	 * @param rowkey 
	 * @return void
	 * @throws
	 */
	void deleteUserByRowKey(String rowkey);
	/**
	 * 
	 * @Title: updateUserByRowKey
	 * @Description: 修改一个用户通过rowkey
	 * @param user 
	 * @return void
	 * @throws
	 */
	void updateUserByRowKey(User user);
	
	
	/**
	 * 
	 * @Title: getUserByMobileAndId
	 * @Description: 查询用户
	 * @param id
	 * @param mobile
	 * @return 
	 * @return User
	 * @throws
	 */
	User getUserByMobileAndId(Integer id,String mobile);
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
}
