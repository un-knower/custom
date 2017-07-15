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
	 * @Title: deleteMessageByRowKey
	 * @Description: 删除一条信息
	 * @param rowKey 
	 * @return void
	 * @throws
	 */
	void deleteMessageByRowKey(String rowKey);
	/**
	 * 
	 * @Title: updateMessageByRowKey
	 * @Description: 更新一条信息
	 * @param message 
	 * @return void
	 * @throws
	 */
	void updateMessageByRowKey(Message message);
	/**
	 * 
	 * @Title: getMessageByRowKey
	 * @Description: 获得一条信息
	 * @param rowKey
	 * @return 
	 * @return Message
	 * @throws
	 */
	Message getMessageByRowKey(String rowKey);
	/**
	 * 
	 * @Title: listMessage
	 * @Description: 查消息
	 * @param sortCode
	 * @param mobile
	 * @param pageNo
	 * @param pageSize
	 * @return 
	 * @return Pagination<Message>
	 * @throws
	 */
	Pagination<Message> listMessage(String sortCode,String mobile,Integer pageNo,Integer pageSize);
	
}
