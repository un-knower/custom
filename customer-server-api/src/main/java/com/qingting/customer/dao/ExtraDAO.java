package com.qingting.customer.dao;

import java.util.List;

import com.qingting.customer.model.hbasedo.Extra;

public interface ExtraDAO{
	/**
	 * 
	 * @Title: insertExtra
	 * @Description: 插入一条保障和特权信息
	 * @param extra 
	 * @return void
	 * @throws
	 */
	void insertExtra(Extra extra);
	/**
	 * 
	 * @Title: deleteExtraByRowKey
	 * @Description: 删除一条保障和特权信息
	 * @param rowKey 
	 * @return void
	 * @throws
	 */
	void deleteExtraByRowKey(String rowKey);
	/**
	 * 
	 * @Title: updateExtraByRowKey
	 * @Description: 修改一条保障和特权信息
	 * @param extra 
	 * @return void
	 * @throws
	 */
	void updateExtraByRowKey(Extra extra);
	/**
	 * 
	 * @Title: getExtraByRowKey
	 * @Description: 获得一条保障和特权信息通过rowKey
	 * @param rowKey
	 * @return 
	 * @return Extra
	 * @throws
	 */
	Extra getExtraByRowKey(String rowKey);
	/**
	 * 
	 * @Title: listExtra
	 * @Description: 获得所有保障和特权信息
	 * @return 
	 * @return List<Extra>
	 * @throws
	 */
	List<Extra> listExtra();
}