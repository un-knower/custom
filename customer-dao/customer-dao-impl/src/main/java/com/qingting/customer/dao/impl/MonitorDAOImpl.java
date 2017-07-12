package com.qingting.customer.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Repository;

import com.alipay.simplehbase.client.SimpleHbaseClient;
import com.alipay.simplehbase.client.rowkey.RowKeyUtil;
import com.alipay.simplehbase.util.BytesUtil;
import com.qingting.customer.common.pojo.common.StringUtils;
import com.qingting.customer.common.pojo.hbasedo.Monitor;
import com.qingting.customer.common.pojo.model.Pagination;
import com.qingting.customer.dao.MonitorDAO;
import com.qingting.customer.dao.util.SHCUtil;
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
		byte[] bytes=new byte[1];
		Random random = new Random();
		random.nextBytes(bytes);
		return RowKeyUtil.getRowKey(equipCode,bytes,millis);
	}
	private static List<Monitor> setContentOfRowKey(List<SimpleHbaseDOWithKeyResult<Monitor>> listHbase){
		List<Monitor> list=new ArrayList<Monitor>();
		//for (SimpleHbaseDOWithKeyResult<Monitor> result : listHbase) {
		for(int i=listHbase.size()-1;i>-1;i--){
			SimpleHbaseDOWithKeyResult<Monitor> result=listHbase.get(i);
			Monitor monitor = result.getT();
			byte[] rowkey=result.getRowKey().toBytes();
			
			monitor.setEquipCode(new String(rowkey,0,rowkey.length-8-1));//最前边是设备编号
			Calendar time=Calendar.getInstance();
			time.setTimeInMillis(BytesUtil.bytesToLong(rowkey, rowkey.length-8, 8));
			monitor.setCollectTime(time);//后8字节字节是时间
			list.add(monitor);
		}
		return list;
	}
	
	@Override
	public void insertMonitor(Monitor monitor) {
		tClient.putObject(createRowKey(monitor.getEquipCode(),monitor.getCollectTime().getTimeInMillis()), monitor);
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
		
		//tClient.setSimpleHbaseRuntimeSetting(new SimpleHbaseRuntimeSetting());
		return setContentOfRowKey(
				tClient.findObjectAndKeyList(RowKeyUtil.getRowKey(equipCode,new byte[]{0},startTime.getTimeInMillis()),RowKeyUtil.getRowKey(equipCode,new byte[]{(byte)0xFF},endTime.getTimeInMillis()), Monitor.class)
				);
	}
	@Override
	public List<Monitor> listMonitorOfNew(String equipCode,Long wide) {
		long now=Calendar.getInstance().getTimeInMillis();
		return setContentOfRowKey(
				tClient.findObjectAndKeyList(RowKeyUtil.getRowKey(equipCode,new byte[]{0},now-wide),RowKeyUtil.getRowKey(equipCode,new byte[]{(byte)0xFF},now), Monitor.class)
				);
	}
	<T> Pagination<T> getPage(Integer pageNo,Integer pageSize,List<T> list){
		Pagination<T> page=new Pagination<T>();
		int size=list.size();
		List<T> resultlist=new ArrayList<T>();
		for(int i=0;i<size;i++){
			if( i>((pageNo-1)*pageSize-1)&& i<(pageNo*pageSize) ){
				resultlist.add(list.get(i));
			}
		}
		page.setList(resultlist);
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		page.setRowCount(size);
		return page;
	}
	@Override
	public Pagination<Monitor> listMonitor(String equipCode,Integer pageNo,Integer pageSize) {
		System.out.println("equipCode:"+equipCode);
		if(StringUtils.isBlank(equipCode)){
			System.out.println("设备编号空...");
			return getPage(pageNo,pageSize,setContentOfRowKey(
				tClient.findObjectAndKeyList(RowKeyUtil.getStringbytesLongMinRowKey(32,1),RowKeyUtil.getStringbytesLongMaxRowKey(32,1), Monitor.class)
				));
		}else{
			return getPage(pageNo,pageSize,setContentOfRowKey(
					tClient.findObjectAndKeyList(RowKeyUtil.getStringbytesLongMinRowKey(equipCode,1),RowKeyUtil.getStringbytesLongMaxRowKey(equipCode,1), Monitor.class)
					));
		}
	}
	

}
