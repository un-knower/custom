package com.qingting.customer.baseserver;

import java.util.Calendar;
import java.util.List;

import com.qingting.customer.common.pojo.hbasedo.Monitor;
import com.qingting.customer.common.pojo.model.Pagination;



public interface MonitorService {
	/**
	 * 
	 * @Title: insertMonitor
	 * @Description: 插入一条数据
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
	 * @Title: listMonitorByStartTimeAndEndTime
	 * @Description: 查询一段时间的监测数据
	 * @param equipCode
	 * @param startTime
	 * @param endTime
	 * @return 
	 * @return List<Monitor>
	 * @throws
	 */
	List<Monitor> listMonitorByStartTimeAndEndTime(String equipCode, Calendar startTime,
			Calendar endTime);
	/**
	 * 
	 * @Title: listMonitorOfNew
	 * @Description: 查询设备最新一段时间的监测数据
	 * @param equipCode
	 * @param wide
	 * @return 
	 * @return List<Monitor>
	 * @throws
	 */
	List<Monitor> listMonitorOfNew(String equipCode,Long wide);
	/**
	 * 
	 * @Title: listMonitor
	 * @Description: 查询所有监测值
	 * @param equipCode
	 * @param pageNo
	 * @param pageSize
	 * @return 
	 * @return Pagination<Monitor>
	 * @throws
	 */
	Pagination<Monitor> listMonitor(String equipCode,Integer pageNo,Integer pageSize);
}
