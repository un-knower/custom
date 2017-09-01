package com.qingting.customer.dao;

import java.util.List;

import com.qingting.customer.model.hbasedo.WarnSort;

public interface WarnSortDAO {
	/**
	 * 
	 * @Title: insertWarnSort
	 * @Description: 插入预警分类信息
	 * @param warnSort 
	 * @return void
	 * @throws
	 */
	void insertWarnSort(WarnSort warnSort);
	/**
	 * 
	 * @Title: deleteWarnSortByRowKey
	 * @Description: 删除预警分类信息通过rowKey
	 * @param rowKey 
	 * @return void
	 * @throws
	 */
	void deleteWarnSortByRowKey(String rowKey);
	/**
	 * 
	 * @Title: updateWarnSortByRowKey
	 * @Description: 修改预警分类信息通过rowKey
	 * @param warnSort
	 * @return void
	 * @throws
	 */
	void updateWarnSortByRowKey(WarnSort warnSort);
	/**
	 * 
	 * @Title: getWarnSortByRowKey
	 * @Description: 获得预警分类信息通过rowKey
	 * @param rowKey
	 * @return 
	 * @return WarnSort
	 * @throws
	 */
	WarnSort getWarnSortByRowKey(String rowKey);
	/**
	 * 
	 * @Title: listWarnSort
	 * @Description: 获得所有预警分类信息
	 * @return 
	 * @return List<WarnSort>
	 * @throws
	 */
	List<WarnSort> listWarnSort();
}
