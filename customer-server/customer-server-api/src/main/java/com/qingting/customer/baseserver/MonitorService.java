package com.qingting.customer.baseserver;

import java.util.Calendar;
import java.util.List;

import com.qingting.customer.common.pojo.hbasedo.Monitor;



public interface MonitorService {
	/**
	 * 
	 * @Title: insertMonitor
	 * @Description: 插入一条监测值
	 * @param monitor
	 * @return void
	 * @throws
	 */
	void insertMonitor(Monitor monitor);

	/**
	 * 
	 * @Title: deleteMonitorByRowKey
	 * @Description: 删除一条监测值通过rowKey
	 * @param rowKey 
	 * @return void
	 * @throws
	 */
	void deleteMonitorByRowKey(String rowKey);

	/**
	 * 
	 * @Title: updateMonitorByRowKey
	 * @Description: 修改一条监测值通过RowKey
	 * @param monitor 
	 * @return void
	 * @throws
	 */
	void updateMonitorByRowKey(Monitor monitor);

	/**
	 * 
	 * @Title: getMonitorByRowKey
	 * @Description: 查询一条监测值通过rowKey
	 * @param rowKey
	 * @return 
	 * @return Monitor
	 * @throws
	 */
	Monitor getMonitorByRowKey(String rowKey);

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
