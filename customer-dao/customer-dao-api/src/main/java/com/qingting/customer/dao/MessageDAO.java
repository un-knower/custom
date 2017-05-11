package com.qingting.customer.dao;

import java.util.List;

import com.qingting.customer.common.pojo.hbasedo.Message;

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
	 * @Description: 获得发送给某个号码的多条信息
	 * @param phone
	 * @return 
	 * @return List<Message>
	 * @throws
	 */
	List<Message> listMessage(String phone);
	/**
	 * 
	 * @Title: countMessageOfTodayByPhone
	 * @Description: 计数今天(凌晨00:00:00到现在)发送给某个号码的信息条数
	 * @param phone
	 * @return 
	 * @return Integer
	 * @throws
	 */
	Integer countMessageOfTodayByPhone(String phone);
	/**
	 * 
	 * @Title: countMessageOfTodayByIp
	 * @Description: 计数今天(凌晨00:00:00到现在)某个IP请求发送的信息条数
	 * @param ip
	 * @return 
	 * @return Integer
	 * @throws
	 */
	Integer countMessageOfTodayByIp(String ip);
}
