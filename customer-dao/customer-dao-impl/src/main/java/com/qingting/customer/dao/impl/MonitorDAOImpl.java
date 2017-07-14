package com.qingting.customer.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.hbase.util.MD5Hash;
import org.springframework.stereotype.Repository;

import com.alipay.simplehbase.client.QueryExtInfo;
import com.alipay.simplehbase.client.SimpleHbaseClient;
import com.alipay.simplehbase.client.rowkey.RowKeyUtil;
import com.alipay.simplehbase.util.BytesUtil;
import com.alipay.simplehbase.util.FilterUtils;
import com.qingting.customer.common.pojo.common.StringUtils;
import com.qingting.customer.common.pojo.hbasedo.EquipSort;
import com.qingting.customer.common.pojo.hbasedo.Monitor;
import com.qingting.customer.common.pojo.model.Pagination;
import com.qingting.customer.common.pojo.util.DateUtil;
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
	private static RowKey createRowKey(Long millis,String equipCode){	
		return RowKeyUtil.getRowKey(BytesUtil.longReverseToBytes(millis/1000),
				equipCode);
	}
	
	private static List<Monitor> setContentOfRowKey(List<SimpleHbaseDOWithKeyResult<Monitor>> listHbase){
		List<Monitor> list=new ArrayList<Monitor>();
		for(int i=0;i<listHbase.size();i++){
			SimpleHbaseDOWithKeyResult<Monitor> result=listHbase.get(i);
			Monitor monitor = result.getT();
			byte[] rowkey=result.getRowKey().toBytes();
			
			Calendar time=Calendar.getInstance();
			time.setTimeInMillis(BytesUtil.bytesReverseToLong(rowkey,0, 8)*1000);
			monitor.setCreateTime(time);//前8字节字节是时间
			
			monitor.setEquipCode(new String(rowkey,8,rowkey.length-8));//最后边是设备编号
			
			list.add(monitor);
		}
		Collections.sort(list,new Comparator<Monitor>() {
			@Override
			public int compare(Monitor o1, Monitor o2) {
				int i = (int)(o1.getCreateTime().getTimeInMillis() - o2.getCreateTime().getTimeInMillis());  
                if(i == 0){  
                    return (int)(o1.getCreateTime().getTimeInMillis() - o2.getCreateTime().getTimeInMillis());  
                }  
                return i; 
			}
		});
		return list;
	}
	public List<RowKey> getListSecondRowKey(String equipCode,Long startTime,Long endTime){
		List<RowKey> list=new ArrayList<RowKey>();
		long wide=(endTime-startTime)/1000;//秒数
		for(long i=0;i<wide;i++){//循环相隔秒数
			list.add(createRowKey(startTime+i*1000,equipCode));
		}
		return list;
	}
	
	@Override
	public void insertMonitor(Monitor monitor) {
		tClient.putObject(createRowKey(monitor.getCreateTime().getTimeInMillis(),monitor.getEquipCode()), monitor);
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
				//tClient.findObjectAndKeyList(RowKeyUtil.getRowKey(equipCode,new byte[]{0},startTime.getTimeInMillis()),RowKeyUtil.getRowKey(equipCode,new byte[]{(byte)0xFF},endTime.getTimeInMillis()), Monitor.class)
				tClient.findObjectAndKeyBatch(getListSecondRowKey(equipCode, startTime.getTimeInMillis(), endTime.getTimeInMillis()), Monitor.class)
				);
	}
	@Override
	public List<Monitor> listMonitorOfNew(String equipCode,Long wide) {
		long now=Calendar.getInstance().getTimeInMillis();
		return setContentOfRowKey(
				//tClient.findObjectAndKeyList(RowKeyUtil.getRowKey(equipCode,new byte[]{0},now-wide),RowKeyUtil.getRowKey(equipCode,new byte[]{(byte)0xFF},now), Monitor.class)
				tClient.findObjectAndKeyBatch(getListSecondRowKey(equipCode, now-wide, now), Monitor.class)
				);
	}
	@Override
	public Pagination<Monitor> listMonitor(String equipCode,Integer pageNo,Integer pageSize) {
		QueryExtInfo queryExtInfo = new QueryExtInfo();
		queryExtInfo.setLimit((pageNo-1)*pageSize, pageSize);
		List<Monitor> list=null;
		Pagination<Monitor> page=new Pagination<Monitor>();
		
		System.out.println("equipCode:"+equipCode);
		if(StringUtils.isBlank(equipCode)){
			System.out.println("设备编号空...");
			
			list = setContentOfRowKey(
					tClient.findObjectAndKeyList(RowKeyUtil.getLongStringMinRowKey(12),RowKeyUtil.getLongStringMaxRowKey(12), Monitor.class,null,queryExtInfo)
					//tClient.findObjectAndKeyBatch(getListSecondRowKey(equipCode, now, now), Monitor.class)
					);
					/*setContentOfRowKey(
				tClient.findObjectAndKeyList(RowKeyUtil.getStringbytesLongMinRowKey(32,1),RowKeyUtil.getStringbytesLongMaxRowKey(32,1), Monitor.class)
				);*/
			page.setRowCount(tClient.count(RowKeyUtil.getLongStringMinRowKey(12),RowKeyUtil.getLongStringMaxRowKey(12), null));
		}else{//非空
			/*list = setContentOfRowKey(
					tClient.findObjectAndKeyList(RowKeyUtil.getStringbytesLongMinRowKey(equipCode,1),RowKeyUtil.getStringbytesLongMaxRowKey(equipCode,1), Monitor.class)
					);*/
			list = setContentOfRowKey(
					//tClient.findObjectAndKeyList(RowKeyUtil.getRowKey(equipCode,new byte[]{0},now-wide),RowKeyUtil.getRowKey(equipCode,new byte[]{(byte)0xFF},now), Monitor.class)
					//tClient.findObjectAndKeyBatch(getListSecondRowKey(equipCode, now, now), Monitor.class)
					
					tClient.findObjectAndKeyList(createRowKey(Long.MIN_VALUE,equipCode),createRowKey(Long.MAX_VALUE,equipCode), Monitor.class,FilterUtils.getSuffixFilter(equipCode),queryExtInfo)
					//getEnoughMonitor(equipCode,pageNo,pageSize)
					);
			page.setRowCount(tClient.count(createRowKey(Long.MIN_VALUE,equipCode),createRowKey(Long.MAX_VALUE,equipCode), FilterUtils.getSuffixFilter(equipCode)));
		}
		page.setList(list);
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		return page;
	}
	private static final long cacheSize=60000;//60秒
	public List<SimpleHbaseDOWithKeyResult<Monitor>>  getEnoughMonitor(String equipCode,Integer pageNo,Integer pageSize){
		List<SimpleHbaseDOWithKeyResult<Monitor>> list=new ArrayList<SimpleHbaseDOWithKeyResult<Monitor>>();
		long now=Calendar.getInstance().getTimeInMillis();
		long count=0;
		long startIndex=(pageNo-1)*pageSize;//包含开始索引
		if(!StringUtils.isBlank(equipCode)){
			/*int num=0;
			while(num<10){//条件有待商榷
				List<SimpleHbaseDOWithKeyResult<Monitor>> temp=tClient.findObjectAndKeyBatch(getListSecondRowKey(equipCode, now-cacheSize, now), Monitor.class);
				long location=count;
				if(temp!=null){
					count+=temp.size();
					if(count>startIndex){
						for(long i=0;i<count-startIndex;i++){
							list.add(temp.get((int)(startIndex-location)));
							if(list.size()==pageSize){
								num=10;
								break;
							}
							num++;
						}
					}
				}else{
					num++;
				}
			}*/
			for(long i=now;i>DateUtil.getStart().getTimeInMillis();i-=1000){
				SimpleHbaseDOWithKeyResult<Monitor> temp=tClient.findObjectAndKey(createRowKey(i,equipCode), Monitor.class);
				if(temp!=null){
					count++;
					if(count>=startIndex){
						list.add(temp);
						if(list.size()==pageSize)
							break;
					}
				}
				if(Calendar.getInstance().getTimeInMillis()-now>120000)//超过120s
					break;
			}
		}
		return list;
	}

}
