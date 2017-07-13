package com.qingting.customer.baseserver;

import java.util.List;

import com.qingting.customer.common.pojo.hbasedo.Equip;
import com.qingting.customer.common.pojo.model.Pagination;

public interface EquipService {
	/**
	 * 
	 * @Title: insertEquip
	 * @Description: 插入一条设备数据
	 * @param equip
	 * @return void
	 * @throws
	 */
	void insertEquip(Equip equip);
	/**
	 * 
	 * @Title: deleteEquipByRowKey
	 * @Description: 删除一条设备数据通过rowKey
	 * @param rowKey 
	 * @return void
	 * @throws
	 */
	void deleteEquipByRowKey(String rowKey);
	/**
	 * 
	 * @Title: updateEquipByRowKey
	 * @Description: 更新一条设备数据通过RowKey
	 * @param equip 
	 * @return void
	 * @throws
	 */
	void updateEquipByRowKey(Equip equip);
	/**
	 * 
	 * @Title: listEquipByEquipCodeAndUserId
	 * @Description: 查询设备
	 * @param equipCode
	 * @param userId
	 * @return 
	 * @return Pagination<Equip>
	 * @throws
	 */
	Pagination<Equip> listEquipByEquipCodeAndUserId(String equipCode,Integer userId,Integer pageNo,Integer pageSize);
}
