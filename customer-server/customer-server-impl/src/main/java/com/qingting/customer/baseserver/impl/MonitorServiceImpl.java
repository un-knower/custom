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
	public void insertMonitorByEquipId(Monitor monitor, Integer equipId) {
		monitorDAO.insertMonitorByEquipId(monitor, equipId);	
	}

	@Override
	public Monitor getMonitorByEquipIdAndCalendar(Integer equipId,Calendar calendar) {
		System.out.println("~~~~~~~~进入服务customer-server-impl的getMonitorByRowKey方法~~~~~~~");
		Monitor monitor = monitorDAO.getMonitorByEquipIdAndCalendar(equipId,calendar);
		System.out.println("查询的结果monitor:"+monitor);
		return monitor;
	}

	@Override
	public List<Monitor> listMonitorByStartAndEndOfCalendar(Integer equipId,Calendar startCalendar,Calendar endCalendar) {
		System.out.println("startCalendar:"+startCalendar+","+"endCalendar:"+endCalendar);
		System.out.println("monitorDAO注入："+monitorDAO);
		return monitorDAO.listMonitorByStartAndEndOfCalendar(equipId, startCalendar, endCalendar);
	}
}
