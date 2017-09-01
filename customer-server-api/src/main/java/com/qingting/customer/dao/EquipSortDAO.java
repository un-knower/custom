package com.qingting.customer.dao;

import java.util.List;

import com.qingting.customer.model.hbasedo.EquipSort;
import com.qingting.customer.model.page.Pagination;

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
	 * @Title: getEquipSortById
	 * @Description: 获取设备分类
	 * @param id
	 * @return 
	 * @return EquipSort
	 * @throws
	 */
	EquipSort getEquipSortById(Integer id);
	/**
	 * 
	 * @Title: listEquipSort
	 * @Description: 获得所有设备分类信息
	 * @param pageNo
	 * @param pageSize
	 * @return 
	 * @return Pagination<EquipSort>
	 * @throws
	 */
	Pagination<EquipSort> listEquipSort(Integer pageNo,Integer pageSize);
	/**
	 * 
	 * @Title: listEquipSort
	 * @Description: 查询所有设备
	 * @return 
	 * @return List<EquipSort>
	 * @throws
	 */
	List<EquipSort> listEquipSort();
}
