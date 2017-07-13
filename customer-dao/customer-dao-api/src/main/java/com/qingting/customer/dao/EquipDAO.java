package com.qingting.customer.dao;


import com.qingting.customer.common.pojo.hbasedo.Equip;
import com.qingting.customer.common.pojo.model.Pagination;

/**
 * 
 * @ClassName: EquipDAO
 * @Description: 设备数据库访问CURD
 * @author zlf
 * @date 2017年4月25日 上午12:21:02
 *
 */
public interface EquipDAO {
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
