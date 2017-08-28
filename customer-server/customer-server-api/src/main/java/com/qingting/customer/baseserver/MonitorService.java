package com.qingting.customer.baseserver;

import java.util.Calendar;
import java.util.List;

import com.qingting.customer.common.pojo.dto.EmpMonitorDTO;
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
	 * @Title: isExist
	 * @Description: 判断数据库是否存在一个监测值
	 * @param equipCode
	 * @param collectTime
	 * @return 
	 * @return boolean
	 * @throws
	 */
	boolean isExist(String equipCode,Calendar collectTime);
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
	 * @Title: listMonitorByEndTime
	 * @Description: 前端用-查询监测值
	 * @param equipCode
	 * @param type
	 * @param pageSize
	 * @param endTime
	 * @return 
	 * @return List<Monitor>
	 * @throws
	 */
	List<Monitor> listMonitorByEndTime(String equipCode, String type, int pageSize,
			Calendar endTime);
	/**
	 * 
	 * @Title: listMonitor
	 * @Description: 查监测值
	 * @param page
	 * @return 
	 * @return Pagination<Monitor>
	 * @throws
	 */
	Pagination<Monitor> listMonitor(Pagination<Monitor> page);
	/**
	 * 
	 * @Title: listTopMonitorOfNew
	 * @Description: 查用户置顶设备的最新监测值
	 * @param userId
	 * @return 
	 * @return Monitor
	 * @throws
	 */
	Monitor listTopMonitorOfNew(Integer userId);
	/**
	 * 
	 * @Title: getMonitorOfNewByEquipCode
	 * @Description: 获得一个设别的最新一条监测值
	 * @param equipCode
	 * @return 
	 * @return Monitor
	 * @throws
	 */
	Monitor getMonitorOfNewByEquipCode(String equipCode);
	/**
	 * 
	 * @Title: getMonitorOfNewOfEmp
	 * @Description: 工程测试用户测试查询
	 * @param equipCode
	 * @return 
	 * @return EmpMonitorDTO
	 * @throws
	 */
	EmpMonitorDTO getMonitorOfNewOfEmp(String equipCode);
}
