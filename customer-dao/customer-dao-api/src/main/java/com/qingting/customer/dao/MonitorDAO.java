/**   
 * @Title：MonitorDAO.java  
 * @包：   com.qingting.dao  
 * @描述:  TODO  
 * @作者： 周凌峰  
 * @日期： 2017年3月16日 下午6:06:51  
 * @version：   
 */

package com.qingting.customer.dao;

import java.util.Calendar;
import java.util.List;

import com.qingting.customer.common.pojo.hbasedo.Monitor;
import com.qingting.customer.common.pojo.model.Pagination;

/**
 * 
 * @ClassName: MonitorDAO
 * @Description: 监测值数据库访问接口CURD
 * @author zlf
 * @date 2017年4月24日 下午5:51:03
 *
 */
public interface MonitorDAO {
	
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
