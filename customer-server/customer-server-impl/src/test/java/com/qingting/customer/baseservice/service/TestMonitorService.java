package com.qingting.customer.baseservice.service;

import java.util.UUID;


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qingting.customer.common.pojo.hbasedo.Monitor;


//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations="classpath*:applicationContext.xml")
public class TestMonitorService {
	private static final Logger logger = LoggerFactory.getLogger(TestMonitorService.class);
	//@Resource
	//MonitorService monitorService;
	 public static byte[] plusOne(byte[] bytes){
    	int temp=0;
    	for(int i=bytes.length-1;i>-1;i--){
    		temp=(int)(bytes[i]&0xFF)+1;
    		if(temp<256){
    			bytes[i]=(byte)temp;
    			break;
    		}else{
    			bytes[i]=0;
    		}
    	}
    	return bytes;
    }
	@Test
	public void testListMonitor(){
		byte[] bytes=new byte[]{0x01,(byte)0xFF,(byte)0xFF};
		byte[] plusOne = plusOne(bytes);
		System.out.println("加1结果:");
		for (byte b : plusOne) {
			System.out.print((b&0xFF)+" ");
		}
	}
	@Test
	public void testCoprocess(){
		
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
		
		//monitorService.insertMonitor(monitor);

		/*Calendar startCal = DateUtil.setDate(2017, 4, 7, 9, 42, 55, 790);
		System.out.println(convertTime(startCal));
		MonitorRowKey monitorRowKey = new MonitorRowKey(1, startCal);
		monitorDAO.insertMonitor(monitor, monitorRowKey);*/
	}
	public String getOrderIdByUUId() {
        int machineId = 1;//最大支持1-9个集群机器部署
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if(hashCodeV < 0) {//有可能是负数
            hashCodeV = - hashCodeV;
        }
        // 0 代表前面补充0     
        // 4 代表长度为4     
        // d 代表参数为正数型
        //return machineId + String.format("%015d", hashCodeV);
        return String.format("%015d", hashCodeV);
    }
	@Test
    public void uuid() {
        //System.out.println(getOrderIdByUUId());
		System.out.println(UUID.randomUUID());
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
