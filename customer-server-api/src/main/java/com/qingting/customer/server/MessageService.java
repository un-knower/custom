package com.qingting.customer.server;

import java.util.List;
import java.util.Map;

import com.qingting.customer.model.Message;
import com.smart.mvc.model.Pagination;

public interface MessageService {
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
	 * @Description: 删除消息
	 * @param messages 
	 * @return void
	 * @throws
	 */
	void deleteMessage(List<Message> messages);
	
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
	 * @param type
	 * @param millis
	 * @return 
	 * @return Message
	 * @throws
	 */
	Message getMessage(Integer userId, byte type, Long millis);
	/**
	 * 
	 * @Title: listMessage
	 * @Description: 查消息
	 * @param page
	 * @return 
	 * @return Pagination<Message>
	 * @throws
	 */
	Pagination<Message> listMessage(Pagination<Message> page);
	/**
	 * 
	 * @Title: listMessageByEndRowKey
	 * @Description: 查消息
	 * @param endId
	 * @param userId
	 * @param byte
	 * @param pageSize
	 * @return 
	 * @return List<Message>
	 * @throws
	 */
	List<Message> listMessageByEndId(Long endId,Integer userId,Byte type,Integer pageSize);
	/**
	 * 
	 * @Title: setRead
	 * @Description: 已读标记
	 * @param userId
	 * @param type
	 * @param id 
	 * @return void
	 * @throws
	 */
	void setRead(Integer userId,Byte type, Long id);
}
