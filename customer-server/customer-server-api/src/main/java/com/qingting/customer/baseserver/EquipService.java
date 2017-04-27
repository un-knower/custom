package com.qingting.customer.baseserver;

import java.util.Calendar;
import java.util.List;

import com.qingting.customer.common.pojo.hbasedo.Equip;
import com.qingting.customer.hbase.doandkey.SimpleHbaseDOWithKeyResult;

public interface EquipService {
	/**
	 * 
	 * @Title: insertEquipByProjectId
	 * @Description: 插入一条设备数据通过projectId
	 * @param equip
	 * @param projectId 
	 * @return void
	 * @throws
	 */
	void insertEquipByProjectId(Equip equip,Integer projectId);
	/**
	 * 
	 * @Title: deleteEquipByProjectIdAndCalendar
	 * @Description: 删除一条设备数据通过ProjectIdAndCalendar
	 * @param projectId
	 * @param calendar 
	 * @return void
	 * @throws
	 */
	void deleteEquipByProjectIdAndCalendar(Integer projectId,Calendar calendar);
	/**
	 * 
	 * @Title: updateEquipByProjectIdAndCalendar
	 * @Description: 更新一条设备数据通过ProjectIdAndCalendar
	 * @param equip
	 * @param projectId
	 * @param calendar 
	 * @return void
	 * @throws
	 */
	void updateEquipByProjectIdAndCalendar(Equip equip,Integer projectId,Calendar calendar);
	/**
	 * 
	 * @Title: listEquipByProjectId
	 * @Description: 查询所有设备数据通过ProjectId
	 * @param projectId
	 * @return 
	 * @return List<SimpleHbaseDOWithKeyResult<Equip>>
	 * @throws
	 */
	List<SimpleHbaseDOWithKeyResult<Equip>> listEquipByProjectId(Integer projectId);
}
