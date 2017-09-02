package com.qingting.customer.dao;

import java.util.List;

import com.qingting.customer.model.EquipParam;

public interface EquipParamDAO {
	/**
	 * 
	 * @Title: insertEquipParam
	 * @Description: 插入一条设备参数
	 * @param equipParam
	 * @return void
	 * @throws
	 */
	void insertEquipParam(EquipParam equipParam);
	/**
	 * 
	 * @Title: deleteEquipParamByRowKey
	 * @Description: 删除一条设备参数通过rowKey
	 * @param rowKey 
	 * @return void
	 * @throws
	 */
	void deleteEquipParamByRowKey(String rowKey);
	/**
	 * 
	 * @Title: updateEquipParamByRowKey
	 * @Description: 更新一条设备参数通过RowKey
	 * @param equipParam 
	 * @return void
	 * @throws
	 */
	void updateEquipParamByRowKey(EquipParam equipParam);
	/**
	 * 
	 * @Title: getEquipParamByEquipId
	 * @Description: 查询设备激活的参数通过equipId(如存在多个激活的公式，抛出逻辑异常)
	 * @param equipId
	 * @return EquipParam
	 * @throws
	 */
	EquipParam getEquipParamOfEnableByEquipId(Integer equipId);
	/**
	 * 
	 * @Title: listEquipParamByEquipId
	 * @Description: 获得所有设备参数(激活和未激活)
	 * @param equipId
	 * @return List<EquipParam>
	 * @throws
	 */
	List<EquipParam> listEquipParamByEquipId(Integer equipId);
}
