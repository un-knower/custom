package com.qingting.customer.server.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.smart.mvc.model.Pagination;
import com.qingting.customer.dao.MessageSortDAO;
import com.qingting.customer.model.MessageSort;
import com.qingting.customer.server.MessageSortService;
@Service("messageSortService")
public class MessageSortServiceImpl implements MessageSortService {
	@Resource
	MessageSortDAO messageSortDAO;

	@Override
	public void insertMessageSort(MessageSort messageSort) {
		messageSortDAO.insertMessageSort(messageSort);
	}

	@Override
	public void deleteMessageSort(String rowKey) {
		messageSortDAO.deleteMessageSort(rowKey);
	}

	@Override
	public void updateMessageSortByRowKey(MessageSort messageSort) {
		messageSortDAO.updateMessageSortByRowKey(messageSort);
	}

	@Override
	public MessageSort getMessageSort(String rowKey) {
		return messageSortDAO.getMessageSort(rowKey);
	}

	@Override
	public Pagination<MessageSort> listMessageSort(Integer pageNo, Integer pageSize) {
		return messageSortDAO.listMessageSort(pageNo, pageSize);
	}
	
}
