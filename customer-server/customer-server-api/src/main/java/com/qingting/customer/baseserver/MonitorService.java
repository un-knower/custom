package com.qingting.customer.baseserver;

import java.util.Calendar;
import java.util.List;

import com.qingting.customer.common.pojo.hbasedo.Monitor;



public interface MonitorService {
	/**
	 * 
	 * @Title: insertMonitorByEquipId
	 * @Description: 插入一条监测值
	 * @param monitor
	 * @param equipId 
	 * @return void
	 * @throws
	 */
	void insertMonitorByEquipId(Monitor monitor, Integer equipId);
	/**
	 * 
	 * @Title: getMonitorByEquipIdAndCalendar
	 * @Description: 查询一条监测值通过equipId和calendar
	 * @param equipId
	 * @param calendar
	 * @return 
	 * @return Monitor
	 * @throws
	 */
	Monitor getMonitorByEquipIdAndCalendar(Integer equipId,Calendar calendar);
	/**
	 * 
	 * @Title: listMonitorByStartAndEndOfCalendar
	 * @Description: 查询一段时间的监测数据
	 * @param equipId
	 * @param startCalendar
	 * @param endCalendar
	 * @return 
	 * @return List<Monitor>
	 * @throws
	 */
	List<Monitor> listMonitorByStartAndEndOfCalendar(Integer equipId,Calendar startCalendar,Calendar endCalendar);
}
