package com.qingting.customer.dao;

import java.util.List;

import com.qingting.customer.common.pojo.hbasedo.MessageSort;

public interface MessageSortDAO {
	/**
	 * 
	 * @Title: insertMessageSort
	 * @Description: 插入一条信息分类
	 * @param messageSort 
	 * @return void
	 * @throws
	 */
	void insertMessageSort(MessageSort messageSort);
	/**
	 * 
	 * @Title: deleteMessageSort
	 * @Description: 删除一条信息分类
	 * @param rowKey 
	 * @return void
	 * @throws
	 */
	void deleteMessageSort(String rowKey);
	/**
	 * 
	 * @Title: updateMessageSortByRowKey
	 * @Description: 修改信息分类
	 * @param rowKey 
	 * @return void
	 * @throws
	 */
	void updateMessageSortByRowKey(MessageSort messageSort);
	/**
	 * 
	 * @Title: getMessageSort
	 * @Description: 获得一个信息分类
	 * @param rowKey
	 * @return 
	 * @return MessageSort
	 * @throws
	 */
	MessageSort getMessageSort(String rowKey);
	/**
	 * 
	 * @Title: listMessageSort
	 * @Description: 获得全部信息分类
	 * @return 
	 * @return List<MessageSort>
	 * @throws
	 */
	List<MessageSort> listMessageSort();
}
