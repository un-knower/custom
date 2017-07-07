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
	public List<Monitor> listMonitorByStartTimeAndEndTime(String equipCode, Calendar startTime, Calendar endTime) {
		return monitorDAO.listMonitorByStartTimeAndEndTime(equipCode, startTime, endTime);
	}

	@Override
	public List<Monitor> listMonitorOfNew(String equipCode, Long wide) {
		return monitorDAO.listMonitorOfNew(equipCode, wide);
	}

	@Override
	public List<Monitor> listMonitor() {
		// TODO Auto-generated method stub
		return null;
	}
}
