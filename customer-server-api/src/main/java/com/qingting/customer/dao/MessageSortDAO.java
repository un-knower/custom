package com.qingting.customer.dao;


import com.qingting.customer.model.hbasedo.MessageSort;
import com.qingting.customer.model.page.Pagination;

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
	 * @Description: 查信息分类
	 * @param pageNo
	 * @param pageSize
	 * @return 
	 * @return Pagination<MessageSort>
	 * @throws
	 */
	Pagination<MessageSort> listMessageSort(Integer pageNo,Integer pageSize);
}
