package com.qingting.customer.dao;

import java.util.List;

import com.qingting.customer.model.Combo;

public interface ComboDAO {
	/**
	 * 
	 * @Title: insertCombo
	 * @Description: 插入一个套餐
	 * @param combo 
	 * @return void
	 * @throws
	 */
	void insertCombo(Combo combo);
	/**
	 * 
	 * @Title: deleteComboByRowKey
	 * @Description: 删除一个套餐通过rowKey
	 * @param rowKey 
	 * @return void
	 * @throws
	 */
	void deleteComboByRowKey(String rowKey);
	/**
	 * 
	 * @Title: updateComboByRowKey
	 * @Description: 修改一个套餐通过rowKey
	 * @param combo 
	 * @return void
	 * @throws
	 */
	void updateComboByRowKey(Combo combo);
	/**
	 * 
	 * @Title: getComboByRowKey
	 * @Description: 获取一个套餐通过RowKey
	 * @param rowKey
	 * @return 
	 * @return Combo
	 * @throws
	 */
	Combo getComboByRowKey(String rowKey);
	/**
	 * 
	 * @Title: listCombo
	 * @Description: 获得所有套餐
	 * @return 
	 * @return List<Combo>
	 * @throws
	 */
	List<Combo> listCombo();
}
