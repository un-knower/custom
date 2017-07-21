package com.qingting.customer.dao;

import com.qingting.customer.common.pojo.hbasedo.Message;
import com.qingting.customer.common.pojo.model.Pagination;

public interface MessageDAO {
	/**
	 * 
	 * @Title: insertMessage
	 * @Description: 插入一条信息
	 * @param message 
	 * @return void
	 * @throws
	 */
	void insertMessage(Message message);
	/**
	 * 
	 * @Title: deleteMessage
	 * @Description: 删除一条信息
	 * @param userId
	 * @param sortCode
	 * @param millis 
	 * @return void
	 * @throws
	 */
	void deleteMessage(Integer userId,String sortCode,Long millis);
	/**
	 * 
	 * @Title: updateMessage
	 * @Description: 更新一条信息
	 * @param message 
	 * @return void
	 * @throws
	 */
	void updateMessage(Message message);
	/**
	 * 
	 * @Title: getMessage
	 * @Description: 获得一条信息
	 * @param userId
	 * @param sortCode
	 * @param millis
	 * @return 
	 * @return Message
	 * @throws
	 */
	Message getMessage(Integer userId,String sortCode,Long millis);
	/**
	 * 
	 * @Title: listMessage
	 * @Description: 查消息
	 * @param userId
	 * @param sortCode
	 * @param pageNo
	 * @param pageSize
	 * @return 
	 * @return Pagination<Message>
	 * @throws
	 */
	Pagination<Message> listMessage(Integer userId,String sortCode,Integer pageNo,Integer pageSize);
	
}
