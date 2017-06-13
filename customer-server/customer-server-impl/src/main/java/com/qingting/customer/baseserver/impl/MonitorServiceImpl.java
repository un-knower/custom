package com.qingting.customer.baseserver.impl;

import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qingting.customer.baseserver.MonitorService;
import com.qingting.customer.common.pojo.hbasedo.Monitor;
import com.qingting.customer.dao.MonitorDAO;

@Service(value="monitorService")
public class MonitorServiceImpl implements MonitorService{
	
	@Resource
	MonitorDAO monitorDAO;

	@Override
	public void insertMonitor(Monitor monitor) {
		monitorDAO.insertMonitor(monitor);
	}

	@Override
	public void deleteMonitorByRowKey(String rowKey) {
		monitorDAO.deleteMonitorByRowKey(rowKey);
	}

	@Override
	public void updateMonitorByRowKey(Monitor monitor) {
		monitorDAO.updateMonitorByRowKey(monitor);
	}

	@Override
	public Monitor getMonitorByRowKey(String rowKey) {
		return monitorDAO.getMonitorByRowKey(rowKey);
	}

	@Override
	public List<Monitor> listMonitorByStartAndEndOfCalendar(Integer equipId, Calendar startCalendar,
			Calendar endCalendar) {
		return monitorDAO.listMonitorByStartAndEndOfCalendar(equipId, startCalendar, endCalendar);
	}

	@Override
	public List<Monitor> listMonitorofNew(Integer equipId) {
		return monitorDAO.listMonitorofNew(equipId);
	}
}
