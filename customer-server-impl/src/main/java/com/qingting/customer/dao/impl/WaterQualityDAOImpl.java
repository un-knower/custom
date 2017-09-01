package com.qingting.customer.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.alipay.simplehbase.client.QueryExtInfo;
import com.alipay.simplehbase.client.SimpleHbaseClient;
import com.alipay.simplehbase.client.rowkey.RowKeyUtil;
import com.alipay.simplehbase.sequence.RedisSerialNum;
import com.alipay.simplehbase.util.FilterUtils;
import com.qingting.customer.model.hbasedo.WaterQuality;
import com.qingting.customer.model.page.Pagination;
import com.qingting.customer.dao.WaterQualityDAO;
import com.qingting.customer.dao.util.SHCUtil;
import com.qingting.customer.hbase.doandkey.SimpleHbaseDOWithKeyResult;
import com.qingting.customer.hbase.rowkey.RowKey;
@Repository("waterQualityDAO")
public class WaterQualityDAOImpl implements WaterQualityDAO {
	@Resource(name="redisTemplate")
	public RedisTemplate<String, Integer> redisTemplate;
	
	private final static String SEQUENCE="waterQuality_id_seq";
	
	private static SimpleHbaseClient tClient=SHCUtil.getSHC("waterQuality");
	
	@Override
	public void insert(WaterQuality waterQuality) {
		int num=RedisSerialNum.getSerialNum(redisTemplate, SEQUENCE);
		waterQuality.setId(num);
		waterQuality.setCreateTime(Calendar.getInstance());
		tClient.putObject(RowKeyUtil.getRowKey(waterQuality.getWaterAreaId(),num), waterQuality);
	}

	@Override
	public void deleteById(Integer id) {
		tClient.delete(getRowKeyById(id));
	}

	@Override
	public void updateById(WaterQuality waterQuality) {
		tClient.putObject(getRowKeyById(waterQuality.getId()), waterQuality);
	}
	
	private RowKey getRowKeyById(Integer id) {
		QueryExtInfo queryExtInfo = new QueryExtInfo();
		queryExtInfo.setLimit(0, 1);
		List<SimpleHbaseDOWithKeyResult<WaterQuality>> list = tClient.findObjectAndKeyList(RowKeyUtil.getRowKey(0,id), RowKeyUtil.getRowKey(Integer.MAX_VALUE,id), WaterQuality.class, FilterUtils.getSuffixFilter(id), queryExtInfo);
		if(list!=null && list.size()==1){
			return list.get(0).getRowKey();
		}else{
			return null;
		}
	}
	
	@Override
	public WaterQuality getById(Integer id) {
		QueryExtInfo queryExtInfo = new QueryExtInfo();
		queryExtInfo.setLimit(0, 1);
		List<SimpleHbaseDOWithKeyResult<WaterQuality>> list = tClient.findObjectAndKeyList(RowKeyUtil.getRowKey(0,id), RowKeyUtil.getRowKey(Integer.MAX_VALUE,id), WaterQuality.class, FilterUtils.getSuffixFilter(id), queryExtInfo);
		if(list!=null && list.size()==1){
			return list.get(0).getT();
		}else{
			return null;
		}
	}

	@Override
	public WaterQuality getNewByWaterAreaId(Integer waterAreaId) {
		QueryExtInfo queryExtInfo = new QueryExtInfo();
		queryExtInfo.setLimit(0, 1);
		List<SimpleHbaseDOWithKeyResult<WaterQuality>> list = tClient.findObjectAndKeyList(RowKeyUtil.getRowKey(waterAreaId,0), RowKeyUtil.getRowKey(waterAreaId,Integer.MAX_VALUE), WaterQuality.class, FilterUtils.getPrefixFilter(waterAreaId), queryExtInfo);
		if(list!=null && list.size()==1){
			return list.get(0).getT();
		}else{
			return null;
		}
	}
	@Override
	public Pagination<WaterQuality> list(Pagination<WaterQuality> page) {
		QueryExtInfo queryExtInfo = new QueryExtInfo();
		queryExtInfo.setLimit((page.getPageNo()-1)*page.getPageSize(), page.getPageSize());
		
		page.setList(
				tClient.findObjectList(RowKeyUtil.getRowKey(0,0),RowKeyUtil.getRowKey(Integer.MAX_VALUE,Integer.MAX_VALUE) , WaterQuality.class, queryExtInfo)
				);
				
		page.setRowCount(
				tClient.count(RowKeyUtil.getRowKey(0,0),RowKeyUtil.getRowKey(Integer.MAX_VALUE,Integer.MAX_VALUE), null)
				);
		
		return page;
	}

}
