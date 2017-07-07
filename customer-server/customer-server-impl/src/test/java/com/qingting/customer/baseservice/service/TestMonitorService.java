package com.qingting.customer.baseservice.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qingting.customer.baseserver.MonitorService;
import com.qingting.customer.common.pojo.hbasedo.Monitor;
import com.qingting.customer.common.pojo.util.DateUtil;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath*:applicationContext.xml")
public class TestMonitorService {
	private static final Logger logger = LoggerFactory.getLogger(TestMonitorService.class);
	@Resource
	MonitorService monitorService;
	@Test
	public void testListMonitor(){
		//List<Monitor> listMonitor = monitorService.listMonitorByStartAndEndOfCalendar(1,DateUtil.getDate(2017,4,7,0,0,0,0), DateUtil.getDate(2017,4,27,9,42,56,0));

		/*logger.debug("测试打印startRowKey:");
		for (byte b : startRowKey.toBytes()) {
			System.out.print(b + " ");
		}
		logger.debug("\n测试打印endRowKey");
		for (byte b : endRowKey.toBytes()) {
			System.out.print(b + " ");
		}*/
		/*logger.debug("\n测试打印result:");
		for (Monitor m : listMonitor) {
			System.out.println(m + " ");
		}*/
		
		//monitorService.listMonitor(startRowKey, endRowKey);
	}
	
	@Test
	public void testInsertMonitor1() {
		Monitor monitor = new Monitor();
		/*monitor.setD((float) 1.0);
		monitor.setFlow((float) 1.1);
		monitor.setHumidity((float) 1.2);
		monitor.setLeak(true);
		monitor.setPurTds((float) 1.3);
		monitor.setRawTds((float) 1.4);
		monitor.setTemp((float) 1.5);
		monitor.setW((float) 1.6);*/
		
		monitorService.insertMonitor(monitor);

		/*Calendar startCal = DateUtil.setDate(2017, 4, 7, 9, 42, 55, 790);
		System.out.println(convertTime(startCal));
		MonitorRowKey monitorRowKey = new MonitorRowKey(1, startCal);
		monitorDAO.insertMonitor(monitor, monitorRowKey);*/
	}
	
	/*public static String datechange(Date date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String demo = sdf.format(date);
		return demo;
	}

	public static String convertTime(Calendar c) {
		String demo = datechange(c.getTime(), "yyyy-MM-dd HH:mm:ss.SSS");
		return demo;
	}

	@Test
	public void testInsertMonitor1() {
		Monitor monitor = new Monitor();
		monitor.setdValue((float) 1.0);
		monitor.setFlow((float) 1.1);
		monitor.setHumidity((float) 1.2);
		monitor.setLeak(true);
		monitor.setPurifyTdsValue((float) 1.3);
		monitor.setRawTdsValue((float) 1.4);
		monitor.setTempValue((float) 1.5);
		monitor.setwValue((float) 1.6);

		Calendar startCal = DateUtil.setDate(2017, 4, 7, 9, 42, 55, 790);
		System.out.println(convertTime(startCal));
		MonitorRowKey monitorRowKey = new MonitorRowKey(1, startCal);
		monitorDAO.insertMonitor(monitor, monitorRowKey);
	}

	@Test
	public void testInsertMonitor2() {
		Monitor monitor = new Monitor();
		monitor.setdValue((float) 1.0);
		monitor.setFlow((float) 1.1);
		monitor.setHumidity((float) 1.2);
		monitor.setLeak(true);
		monitor.setPurifyTdsValue((float) 1.3);
		monitor.setRawTdsValue((float) 1.4);
		monitor.setTempValue((float) 1.5);
		monitor.setwValue((float) 1.6);

		Calendar startCal = DateUtil.setDate(2017, 4, 7, 9, 42, 55, 791);
		System.out.println(convertTime(startCal));
		MonitorRowKey monitorRowKey = new MonitorRowKey(1, startCal);
		monitorDAO.insertMonitor(monitor, monitorRowKey);
	}

	@Test
	public void testDeleteMonitorByRowKey() {
		Calendar startCal = DateUtil.setDate(2017, 4, 7, 9, 42, 55, 790);
		MonitorRowKey monitorRowKey = new MonitorRowKey(1, startCal);
		monitorDAO.deleteMonitorByRowKey(monitorRowKey);
	}

	@Test
	public void testUpdateMonitorByRowKey() {
		Monitor monitor = new Monitor();
		monitor.setdValue((float) 1.0);
		monitor.setFlow((float) 1.1);
		monitor.setHumidity((float) 1.2);
		monitor.setLeak(true);
		monitor.setPurifyTdsValue((float) 1.3);
		monitor.setRawTdsValue((float) 1.4);
		monitor.setTempValue((float) 1.5);

		monitor.setwValue((float) 2.6);

		Calendar startCal = DateUtil.setDate(2017, 4, 7, 9, 42, 55, 790);
		System.out.println(convertTime(startCal));
		MonitorRowKey monitorRowKey = new MonitorRowKey(1, startCal);
		monitorDAO.updateMonitorByRowKey(monitor, monitorRowKey);
	}

	@Test
	public void testGetMonitorByRowKey() {
		Calendar startCal = DateUtil.setDate(2017, 4, 7, 9, 42, 55, 790);
		MonitorRowKey monitorRowKey = new MonitorRowKey(1, startCal);
		Monitor monitor = monitorDAO.getMonitorByRowKey(monitorRowKey);
		System.out.println(monitor);
	}

	@Test
	public void testListMonitor() {

		Calendar startCal = DateUtil.setDate(2017, 4, 7, 9, 42, 55, 0);
		MonitorRowKey startRowKey = new MonitorRowKey(1, startCal);
		Calendar endCal = DateUtil.setDate(2017, 4, 7, 9, 42, 56, 0);
		MonitorRowKey endRowKey = new MonitorRowKey(1, endCal);
		List<Monitor> listMonitor = monitorDAO.listMonitor(startRowKey,
				endRowKey);

		logger.debug("startRowKey:");
		for (byte b : startRowKey.toBytes()) {
			System.out.print(b + " ");
		}
		logger.debug("\nendRowKey");
		for (byte b : endRowKey.toBytes()) {
			System.out.print(b + " ");
		}
		logger.debug("\nresult:");
		for (Monitor m : listMonitor) {
			System.out.println(m + " ");
		}

	}*/
}
