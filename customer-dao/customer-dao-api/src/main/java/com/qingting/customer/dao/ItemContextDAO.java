package com.qingting.customer.dao;

import java.util.List;

import com.qingting.customer.common.pojo.hbasedo.ItemContext;

public interface ItemContextDAO{
	/**
	 * 
	 * @Title: insertItemContext
	 * @Description: 插入一条项内容
	 * @param itemContext 
	 * @return void
	 * @throws
	 */
	void insertItemContext(ItemContext itemContext);
	/**
	 * 
	 * @Title: deleteItemContextByRowKey
	 * @Description: 删除一条项内容通过rowKey
	 * @param rowKey 
	 * @return void
	 * @throws
	 */
	void deleteItemContextByRowKey(String rowKey);
	/**
	 * 
	 * @Title: updateItemContextByRowKey
	 * @Description: 修改一条项内容通过rowKey
	 * @param itemContext 
	 * @return void
	 * @throws
	 */
	void updateItemContextByRowKey(ItemContext itemContext);
	/**
	 * 
	 * @Title: getItemContextByRowKey
	 * @Description: 获得一条项内容通过rowKey
	 * @param rowKey
	 * @return 
	 * @return ItemContext
	 * @throws
	 */
	ItemContext getItemContextByRowKey(String rowKey);
	/**
	 * 
	 * @Title: listItemContext
	 * @Description: 获得所有项内容
	 * @return 
	 * @return List<ItemContext>
	 * @throws
	 */
	List<ItemContext> listItemContext();
}