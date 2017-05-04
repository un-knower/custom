package com.qingting.customer.baseserver;

import java.util.List;

import com.qingting.customer.common.pojo.hbasedo.Equip;

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
	 * @Title: listEquipByProjectId
	 * @Description: 查询项目的所有设备数据
	 * @param projectId
	 * @return List<Equip>
	 * @throws
	 */
	List<Equip> listEquipByProjectId(Integer projectId);
}
