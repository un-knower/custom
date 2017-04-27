package com.qingting.customer.dao;

import java.util.Calendar;
import java.util.List;

import com.qingting.customer.common.pojo.hbasedo.Equip;
import com.qingting.customer.hbase.doandkey.SimpleHbaseDOWithKeyResult;

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
