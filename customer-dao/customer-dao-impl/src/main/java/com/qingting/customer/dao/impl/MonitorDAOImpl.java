package com.qingting.customer.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.alipay.simplehbase.client.SimpleHbaseClient;
import com.alipay.simplehbase.client.rowkey.RowKeyUtil;
import com.alipay.simplehbase.util.BytesUtil;
import com.alipay.simplehbase.util.SHCUtil;
import com.qingting.customer.common.pojo.hbasedo.Monitor;
import com.qingting.customer.dao.MonitorDAO;
import com.qingting.customer.hbase.doandkey.SimpleHbaseDOWithKeyResult;
import com.qingting.customer.hbase.rowkey.RowKey;

@Repository("monitorDAO")
public class MonitorDAOImpl implements MonitorDAO {
	
	/*@Autowired
	public RedisTemplate<String, Integer> redisTemplate;*/
	
	private static SimpleHbaseClient tClient=SHCUtil.getSHC("monitor");
	private final static String SEQUENCE="monitor_id_seq";
	private final static byte dataVersion=0;
	/**
	 * RowKey=(设备编号32字节+时间戳)
	 */
	private static RowKey createRowKey(String equipCode,Long millis){
		
		return RowKeyUtil.getRowKey(equipCode,millis);
	}
	private static List<Monitor> setContentOfRowKey(List<SimpleHbaseDOWithKeyResult<Monitor>> listHbase){
		List<Monitor> list=new ArrayList<Monitor>();
		for (SimpleHbaseDOWithKeyResult<Monitor> result : listHbase) {
			Monitor monitor = result.getT();
			byte[] rowkey=result.getRowKey().toBytes();
			
			monitor.setEquipCode(new String(rowkey,0,rowkey.length-8));//最前边是设备编号
			Calendar time=Calendar.getInstance();
			time.setTimeInMillis(BytesUtil.bytesToLong(rowkey, rowkey.length-8, 8));
			monitor.setCreateTime(time);//后8字节字节是时间
			list.add(monitor);
		}
		return list;
	}
	
	@Override
	public void insertMonitor(Monitor monitor) {
		tClient.putObject(createRowKey(monitor.getEquipCode(),monitor.getCreateTime().getTimeInMillis()), monitor);
	}

	
	@Override
	public void deleteMonitorByRowKey(String rowKey) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateMonitorByRowKey(Monitor monitor) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Monitor getMonitorByRowKey(String rowKey) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Monitor> listMonitorByStartTimeAndEndTime(String equipCode, Calendar startTime,
			Calendar endTime) {
		return setContentOfRowKey(
				tClient.findObjectAndKeyList(RowKeyUtil.getRowKey(equipCode,startTime.getTimeInMillis()),RowKeyUtil.getRowKey(equipCode,endTime.getTimeInMillis()), Monitor.class)
				);
	}
	@Override
	public List<Monitor> listMonitorOfNew(String equipCode,Long wide) {
		long now=Calendar.getInstance().getTimeInMillis();
		return setContentOfRowKey(
				tClient.findObjectAndKeyList(RowKeyUtil.getRowKey(equipCode,now-wide),RowKeyUtil.getRowKey(equipCode,now), Monitor.class)
				);
	}
	@Override
	public List<Monitor> listMonitor() {
		return setContentOfRowKey(
				tClient.findObjectAndKeyList(RowKeyUtil.getStringLongMinRowKey(32),RowKeyUtil.getStringLongMaxRowKey(32), Monitor.class)
				);
	}

}
