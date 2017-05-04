package com.qingting.customer.dao;

import java.util.List;

import com.qingting.customer.common.pojo.hbasedo.EquipSort;

public interface EquipSortDAO {
	/**
	 * 
	 * @Title: insertEquipSort
	 * @Description: 插入设备分类
	 * @param equipSort 
	 * @return void
	 * @throws
	 */
	void insertEquipSort(EquipSort equipSort);
	/**
	 * 
	 * @Title: deleteEquipSortByRowKey
	 * @Description: 删除设备分类信息通过rowKey
	 * @param rowKey 
	 * @return void
	 * @throws
	 */
	void deleteEquipSortByRowKey(String rowKey);
	/**
	 * 
	 * @Title: updateEquipSortByRowKey
	 * @Description: 修改设备分类信息
	 * @param equipSort 
	 * @return void
	 * @throws
	 */
	void updateEquipSortByRowKey(EquipSort equipSort);
	/**
	 * 
	 * @Title: getEquipSortByRowKey
	 * @Description: 获得设备分类信息
	 * @param rowKey
	 * @return 
	 * @return EquipSort
	 * @throws
	 */
	EquipSort getEquipSortByRowKey(String rowKey);
	/**
	 * 
	 * @Title: listEquipSort
	 * @Description: 获得所有设备分类信息
	 * @return 
	 * @return List<EquipSort>
	 * @throws
	 */
	List<EquipSort> listEquipSort();
}
