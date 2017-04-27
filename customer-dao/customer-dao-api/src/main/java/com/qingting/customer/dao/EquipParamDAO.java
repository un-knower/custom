package com.qingting.customer.dao;

import java.util.Calendar;
import java.util.List;

import com.qingting.customer.common.pojo.hbasedo.EquipParam;
import com.qingting.customer.hbase.doandkey.SimpleHbaseDOWithKeyResult;

public interface EquipParamDAO {
	/**
	 * 
	 * @Title: insertEquipParamByEquipIdAndEnable
	 * @Description: 插入一条设备参数通过EquipIdAndEnable
	 * @param equipParam
	 * @param equipId
	 * @param enable
	 * @return void
	 * @throws
	 */
	void insertEquipParamByEquipIdAndEnable(EquipParam equipParam,Integer equipId,Boolean enable);
	/**
	 * 
	 * @Title: deleteEquipParamByEquipIdAndEnableAndCalendar
	 * @Description: 删除一条设备参数通过EquipIdAndEnableAndCalendar
	 * @param equipId
	 * @param enable
	 * @param calendar 
	 * @return void
	 * @throws
	 */
	void deleteEquipParamByEquipIdAndEnableAndCalendar(Integer equipId,Boolean enable,Calendar calendar);
	/**
	 * 
	 * @Title: updateEquipParamByEquipIdAndEnableAndCalendar
	 * @Description: 更新一条设备参数通过EquipIdAndEnableAndCalendar
	 * @param equipParam
	 * @param equipId
	 * @param enable
	 * @param calendar 
	 * @return void
	 * @throws
	 */
	void updateEquipParamByEquipIdAndEnableAndCalendar(EquipParam equipParam,Integer equipId,Boolean enable,Calendar calendar);
	/**
	 * 
	 * @Title: getEquipParamByEquipIdOfEnable
	 * @Description: 查询一条设备激活参数通过equipId
	 * @param equipId
	 * @return 
	 * @return EquipParam
	 * @throws
	 */
	EquipParam getEquipParamByEquipIdOfEnable(Integer equipId);
	/**
	 * 
	 * @Title: listEquipParamAndKeyByEquipIdOfEnable
	 * @Description: 获得所有设备参数
	 * @param equipId
	 * @return 
	 * @return List<SimpleHbaseDOWithKeyResult<EquipParam>>
	 * @throws
	 */
	List<SimpleHbaseDOWithKeyResult<EquipParam>> listEquipParamAndKeyByEquipId(Integer equipId);
}
