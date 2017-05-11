package com.qingting.customer.baseserver.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qingting.customer.baseserver.MessageSortService;
import com.qingting.customer.common.pojo.hbasedo.MessageSort;
import com.qingting.customer.dao.MessageSortDAO;
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
	public List<MessageSort> listMessageSort() {
		return messageSortDAO.listMessageSort();
	}

}
