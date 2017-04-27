package com.qingting.customer.dao.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.alipay.simplehbase.util.SHCUtil;
import com.qingting.customer.common.pojo.hbasedo.Monitor;
import com.qingting.customer.common.pojo.rowkey.MonitorRowKey;
import com.qingting.customer.dao.MonitorDAO;

@Repository(value="monitorDAO")
public class MonitorDAOImpl implements MonitorDAO {

	@Override
	public void insertMonitorByEquipId(Monitor monitor, Integer equipId) {
		SHCUtil.getSHC("monitor").putObject(new MonitorRowKey(equipId), monitor);
	}

	@Override
	public void deleteMonitorByEquipIdAndCalendar(Integer equipId,Calendar calendar) {
		SHCUtil.getSHC("monitor").delete(new MonitorRowKey(equipId,calendar));
	}

	@Override
	public void updateMonitorByEquipIdAndCalendar(Monitor monitor, Integer equipId,Calendar calendar) {
		SHCUtil.getSHC("monitor").updateObjectWithVersion(new MonitorRowKey(equipId,calendar), monitor,monitor.getVersion());
	}

	@Override
	public Monitor getMonitorByEquipIdAndCalendar(Integer equipId,Calendar calendar) {
		return SHCUtil.getSHC("monitor").findObject(new MonitorRowKey(equipId,calendar), Monitor.class);
	}

	@Override
	public List<Monitor> listMonitorByStartAndEndOfCalendar(Integer equipId,Calendar startCalendar,Calendar endCalendar) {
		System.out.println("startTime:"+startCalendar+","+"endTime:"+endCalendar);
		return SHCUtil.getSHC("monitor").findObjectList(new MonitorRowKey(equipId,startCalendar), new MonitorRowKey(equipId,endCalendar),Monitor.class);
	}

}
