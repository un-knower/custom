package com.qingting.customer.baseserver.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qingting.customer.baseserver.MessageService;
import com.qingting.customer.common.pojo.hbasedo.Message;
import com.qingting.customer.common.pojo.model.Pagination;
import com.qingting.customer.dao.MessageDAO;

@Service("messageService")
public class MessageServiceImpl implements MessageService {
	@Resource
	MessageDAO messageDAO;

	@Override
	public void insertMessage(Message message) {
		messageDAO.insertMessage(message);
	}
	
	@Override
	public void updateMessage(Message message) {
		messageDAO.updateMessage(message);
	}

	@Override
	public Message getMessage(Integer userId, String sortCode, Long millis) {
		return messageDAO.getMessage(userId, sortCode, millis);
	}
	
	@Override
	public void deleteMessage(List<Message> messages) {
		System.out.println("service删除消息deleteMessage(List<String> rowkeys).");
		messageDAO.deleteMessage(messages);
	}

	@Override
	public void setRead(Integer userId, String sortCode, Long id) {
		messageDAO.setRead(userId, sortCode, id);
	}

	@Override
	public List<Message> listMessageByEndId(Long endId, Integer userId, String sortCode, Integer pageSize) {
		return messageDAO.listMessageByEndId(endId, userId, sortCode, pageSize);
	}

	@Override
	public Pagination<Message> listMessage(Pagination<Message> page) {
		return messageDAO.listMessage(page);
	}
	
	
}
