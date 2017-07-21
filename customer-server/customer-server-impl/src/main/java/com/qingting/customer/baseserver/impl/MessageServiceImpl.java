package com.qingting.customer.baseserver.impl;

import java.util.List;

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
	public void deleteMessage(Integer userId, String sortCode, Long millis) {
		messageDAO.deleteMessage(userId, sortCode, millis);
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
	public Pagination<Message> listMessage(Integer userId, String sortCode, Integer pageNo, Integer pageSize) {
		return messageDAO.listMessage(userId, sortCode, pageNo, pageSize);
	}

	
}
