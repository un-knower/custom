package com.qingting.customer.dao.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.hbase.util.MD5Hash;
import org.springframework.stereotype.Repository;

import com.alipay.simplehbase.client.QueryExtInfo;
import com.alipay.simplehbase.client.SimpleHbaseClient;
import com.alipay.simplehbase.client.rowkey.RowKeyUtil;
import com.alipay.simplehbase.util.BytesUtil;
import com.alipay.simplehbase.util.FilterUtils;
import com.alipay.simplehbase.util.HbaseOriginService;
import com.qingting.customer.model.common.StringUtils;
import com.qingting.customer.model.hbasedo.EquipSort;
import com.qingting.customer.model.hbasedo.Message;
import com.qingting.customer.model.hbasedo.Monitor;
import com.qingting.customer.model.page.Pagination;
import com.qingting.customer.model.util.DateUtil;
import com.qingting.customer.model.util.RandomUtil;
import com.qingting.customer.dao.MonitorDAO;
import com.qingting.customer.dao.util.SHCUtil;
import com.qingting.customer.hbase.doandkey.SimpleHbaseDOWithKeyResult;
import com.qingting.customer.hbase.rowkey.RowKey;

@Repository("monitorDAO")
public class MonitorDAOImpl implements MonitorDAO {
	
	/*@Autowired
	public RedisTemplate<String, Integer> redisTemplate;*/
	
	private static SimpleHbaseClient tClient=SHCUtil.getSHC("monitor");

	private static HbaseOriginService index=new HbaseOriginService("monitorIndex",
			new String[]{"mif"},
			new byte[][]{
			
		
	});
	private static HbaseOriginService indexDay=new HbaseOriginService("monitorIndexDay",
			new String[]{"mif"},
			new byte[][]{
			
		
	});
	
	private final static int RANDOM_LENGTH=2;
	/**
	 * RowKey=(散列字段+设备编号+时间戳)
	 */
	private static RowKey createRowKey(String equipCode,Long millis){	
		return RowKeyUtil.getRowKey(RandomUtil.getRandomCode(RANDOM_LENGTH),equipCode,millis);
	}
	private static RowKey createIndexRowKey(String equipCode,Long millis){//按毫秒索引
		return RowKeyUtil.getRowKey(equipCode,millis);
	}
	private static RowKey createIndexDayRowKey(String equipCode,Long day){//按天索引
		return RowKeyUtil.getRowKey(equipCode,(int)(day/43200000));//天算法/1000/60/60/12
	}
	
	private static List<Monitor> setContentOfRowKey(List<SimpleHbaseDOWithKeyResult<Monitor>> listHbase){
		List<Monitor> list=new ArrayList<Monitor>();
		for(int i=0;i<listHbase.size();i++){
			SimpleHbaseDOWithKeyResult<Monitor> result=listHbase.get(i);
			Monitor monitor = result.getT();
			byte[] rowkey=result.getRowKey().toBytes();
			
			/*Calendar time=Calendar.getInstance();
			time.setTimeInMillis(BytesUtil.bytesReverseToLong(rowkey,0, 8)*1000);
			monitor.setCreateTime(time);//前8字节字节是时间
			
			monitor.setEquipCode(new String(rowkey,8,rowkey.length-8));//最后边是设备编号
*/			
			list.add(monitor);
		}
		/*Collections.sort(list,new Comparator<Monitor>() {
			@Override
			public int compare(Monitor o1, Monitor o2) {
				int i = (int)(o1.getCreateTime().getTimeInMillis() - o2.getCreateTime().getTimeInMillis());  
                if(i == 0){  
                    return (int)(o1.getCreateTime().getTimeInMillis() - o2.getCreateTime().getTimeInMillis());  
                }  
                return i; 
			}
		});*/
		return list;
	}
	
	
	@Override
	public void insertMonitor(Monitor monitor) {
		System.out.println("输入的monitor:"+monitor);
		//按时间索引
		RowKey indexRowKey=createIndexRowKey(monitor.getEquipCode(),monitor.getCollectTime().getTimeInMillis());
		//按天索引
		RowKey indexDayRowKey=createIndexDayRowKey(monitor.getEquipCode(),
				monitor.getCollectTime().getTimeInMillis());//天算法/1000/60/60/12
		//实际数据行键
		RowKey value=createRowKey(monitor.getEquipCode(),Calendar.getInstance().getTimeInMillis());
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(monitor.getCollectTime().getTimeInMillis());
		System.out.println("collectTime:"+dateString);
		System.out.println("indexRowKey:");
		for (byte b : indexRowKey.toBytes()) {
			System.out.print((int)(b&0xFF)+" ");
		}
		System.out.println();
		System.out.println("indexRowKey:"+new String(indexRowKey.toBytes()));
		
		/*if(index.indexGet(indexRowKey, null, null, "value")==null){*/
			index.put(indexRowKey, "mif", "value", value.toBytes());
			indexDay.put(indexDayRowKey, "mif", "value", value.toBytes());
			tClient.putObject(value, monitor);
			System.out.println("监测值插入成功:"+monitor);
		/*}else{
			System.out.println("===================数据库已存在该值====================");
		}*/
	}
	@Override
	public boolean isExist(String equipCode,Calendar collectTime){
		RowKey indexRowKey=createIndexRowKey(equipCode,collectTime.getTimeInMillis());
		if(index.indexGet(indexRowKey, null, null, "value")==null){
			return false;
		}else{
			return true;
		}
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
		return null;
	}
	@Override
	public Monitor getMonitorOfNewByEquipCode(String equipCode){
		QueryExtInfo queryExtInfo = new QueryExtInfo();
		queryExtInfo.setLimit(0, 1);
		queryExtInfo.setReversed(true);//倒叙查询
		List<RowKey> listRowKey=null;
		List<Monitor> list=null;
		listRowKey=index.indexScan(RowKeyUtil.getIntMinRowKey(), createIndexRowKey(equipCode,Calendar.getInstance().getTimeInMillis()), FilterUtils.getPrefixFilter(equipCode), queryExtInfo, "value");
		if(listRowKey!=null && listRowKey.size()>0){
			list=setContentOfRowKey(
					tClient.findObjectAndKeyBatch(listRowKey,Monitor.class)
					);
			return list.get(0);
		}else{
			return null;
		}
	}
	/*@Override
	public Monitor getMonitorOfNew(){
		return null;
	}*/
	@Override
	public List<Monitor> listMonitorByEndTime(String equipCode, String type, int pageSize,
			Calendar endTime) {
		QueryExtInfo queryExtInfo = new QueryExtInfo();
		queryExtInfo.setLimit(0, pageSize);
		queryExtInfo.setReversed(true);//倒叙查询
		List<RowKey> listRowKey=null;
		List<Monitor> list=null;
		if(type!=null && type.equals("day")){//按天查询
			if(endTime==null){//查最新的数据
				listRowKey=indexDay.indexScan(RowKeyUtil.getIntMinRowKey(), createIndexDayRowKey(equipCode,Calendar.getInstance().getTimeInMillis()), FilterUtils.getPrefixFilter(equipCode), queryExtInfo, "value");
				list=setContentOfRowKey(
						tClient.findObjectAndKeyBatch(listRowKey,Monitor.class)
						);
			}else{//查历史数据
				listRowKey=indexDay.indexScan(RowKeyUtil.getIntMinRowKey(), createIndexDayRowKey(equipCode,endTime.getTimeInMillis()), FilterUtils.getPrefixFilter(equipCode), queryExtInfo, "value");
				list=setContentOfRowKey(
						tClient.findObjectAndKeyBatch(listRowKey,Monitor.class)
						);
			}
		}else{//按秒查询
			if(endTime==null){//查最新的数据
				listRowKey=index.indexScan(RowKeyUtil.getIntMinRowKey(), createIndexRowKey(equipCode,Calendar.getInstance().getTimeInMillis()), FilterUtils.getPrefixFilter(equipCode), queryExtInfo, "value");
				list=setContentOfRowKey(
						tClient.findObjectAndKeyBatch(listRowKey,Monitor.class)
						);
			}else{//查历史数据
				listRowKey=index.indexScan(RowKeyUtil.getIntMinRowKey(), createIndexRowKey(equipCode,endTime.getTimeInMillis()), FilterUtils.getPrefixFilter(equipCode), queryExtInfo, "value");
				list=setContentOfRowKey(
						tClient.findObjectAndKeyBatch(listRowKey,Monitor.class)
						);
			}
		}
		return list;
		/*return setContentOfRowKey(
				//tClient.findObjectAndKeyList(RowKeyUtil.getRowKey(equipCode,new byte[]{0},startTime.getTimeInMillis()),RowKeyUtil.getRowKey(equipCode,new byte[]{(byte)0xFF},endTime.getTimeInMillis()), Monitor.class)
				tClient.findObjectAndKeyBatch(getListSecondRowKey(equipCode, startTime.getTimeInMillis(), endTime.getTimeInMillis()), Monitor.class)
				);*/
	}
	
	@Override
	public Pagination<Monitor> listMonitor(Pagination<Monitor> page) {
		QueryExtInfo queryExtInfo = new QueryExtInfo();
		
		List<Monitor> list=null;
		List<RowKey> listRowKey=null;
		Map<String, Object> map=null;
		
		
		String equipCode=null;
		
		Integer lastPageNo=null;
		Integer realityCount=null;
		if(page.getMap()!=null){
			map=page.getMap();
			if(map.get("equipCode")!=null)
				equipCode=(String)map.get("equipCode");
			if(map.get("lastPageNo")!=null)
				lastPageNo=(Integer)map.get("lastPageNo");
			if(map.get("realityCount")!=null)
				realityCount=(Integer)map.get("realityCount");
		}else{
			map=new HashMap<String,Object>();
		}
		
		RowKey startRowKey=null;
		RowKey endRowKey=null;
		
		
		Integer pageNo=page.getPageNo();
		Integer pageSize=page.getPageSize();
		
		System.out.println("equipCode:"+equipCode);
		if(StringUtils.isBlank(equipCode)){
			System.out.println("设备编号空...");
			
			long count = index.count(RowKeyUtil.getMinRowKey(1), RowKeyUtil.getMaxRowKey(20), null);
			page.setRowCount(count);
			
			if(count>0){
				if( ((pageNo-1)*pageSize)<(count/2) ){ //查一半以后的数据
					queryExtInfo.setLimit((pageNo-1)*pageSize, pageSize);
					queryExtInfo.setReversed(true);
					listRowKey=index.indexScan(RowKeyUtil.getMinRowKey(1), RowKeyUtil.getMaxRowKey(20), null, queryExtInfo, "value");
				}else{//查一半以前的数据
					queryExtInfo.setLimit(page.getPageCount()==pageNo ? 0 : count-pageNo*pageSize, page.getPageCount()==pageNo ? count-(page.getPageCount()-1)*pageSize : pageSize);
					queryExtInfo.setReversed(false);
					listRowKey=index.indexScan(RowKeyUtil.getMinRowKey(1), RowKeyUtil.getMaxRowKey(20), null, queryExtInfo, "value");
					Collections.reverse(listRowKey);
				}
				
				list=setContentOfRowKey(
						tClient.findObjectAndKeyBatch(listRowKey,Monitor.class)
						);
			}
			
			
		}else{//非空
			long count = index.count(
					createIndexRowKey(equipCode,0l), createIndexRowKey(equipCode,Calendar.getInstance().getTimeInMillis()), FilterUtils.getPrefixFilter(equipCode)
					);
			page.setRowCount(count);
			
			if(count>0){
				if( ((pageNo-1)*pageSize)<(count/2) ){ //前一半页面
					//查一半以后的数据
					queryExtInfo.setLimit((pageNo-1)*pageSize, pageSize);
					queryExtInfo.setReversed(true);
					listRowKey=index.indexScan(createIndexRowKey(equipCode,0l), createIndexRowKey(equipCode,Calendar.getInstance().getTimeInMillis()), FilterUtils.getPrefixFilter(equipCode), queryExtInfo, "value");
				}else{//后一半页面
					//查一半以前的数据
					queryExtInfo.setLimit(page.getPageCount()==pageNo ? 0 :count-pageNo*pageSize, page.getPageCount()==pageNo ? count-(page.getPageCount()-1)*pageSize : pageSize);
					queryExtInfo.setReversed(false);
					listRowKey=index.indexScan(createIndexRowKey(equipCode,0l), createIndexRowKey(equipCode,Calendar.getInstance().getTimeInMillis()), FilterUtils.getPrefixFilter(equipCode), queryExtInfo, "value");
					Collections.reverse(listRowKey);
				}
				
				list=setContentOfRowKey(
						tClient.findObjectAndKeyBatch(listRowKey,Monitor.class)
						);
			}
			/*listRowKey=index.indexScan(RowKeyUtil.getMinRowKey(1), createIndexRowKey(equipCode,Calendar.getInstance().getTimeInMillis()), FilterUtils.getPrefixFilter(equipCode), queryExtInfo, "value");
			list=setContentOfRowKey(
					tClient.findObjectAndKeyBatch(listRowKey,Monitor.class)
					);
			page.setRowCount(index.count(RowKeyUtil.getMinRowKey(1), createIndexRowKey(equipCode,Calendar.getInstance().getTimeInMillis()), FilterUtils.getPrefixFilter(equipCode)));*/
		}
		page.setList(list);
		return page;
	}
	/*private static final long cacheSize=60000;//60秒
	public List<SimpleHbaseDOWithKeyResult<Monitor>>  getEnoughMonitor(String equipCode,Integer pageNo,Integer pageSize){
		List<SimpleHbaseDOWithKeyResult<Monitor>> list=new ArrayList<SimpleHbaseDOWithKeyResult<Monitor>>();
		long now=Calendar.getInstance().getTimeInMillis();
		long count=0;
		long startIndex=(pageNo-1)*pageSize;//包含开始索引
		if(!StringUtils.isBlank(equipCode)){
			int num=0;
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
			}
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
	}*/

}
