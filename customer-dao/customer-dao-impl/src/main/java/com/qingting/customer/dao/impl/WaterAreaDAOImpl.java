package com.qingting.customer.dao.impl;


import java.util.Calendar;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.alipay.simplehbase.client.QueryExtInfo;
import com.alipay.simplehbase.client.SimpleHbaseClient;
import com.alipay.simplehbase.client.rowkey.RowKeyUtil;
import com.alipay.simplehbase.sequence.RedisSerialNum;
import com.qingting.customer.common.pojo.hbasedo.WaterArea;
import com.qingting.customer.common.pojo.model.Pagination;
import com.qingting.customer.dao.WaterAreaDAO;
import com.qingting.customer.dao.util.SHCUtil;
@Repository("waterAreaDAO")
public class WaterAreaDAOImpl implements WaterAreaDAO {
	@Resource(name="redisTemplate")
	public RedisTemplate<String, Integer> redisTemplate;
	
	private final static String SEQUENCE="waterArea_id_seq";
	
	private static SimpleHbaseClient tClient=SHCUtil.getSHC("waterArea");
	
	@Override
	public void insert(WaterArea waterArea) {
		int num=RedisSerialNum.getSerialNum(redisTemplate, SEQUENCE);
		waterArea.setId(num);
		waterArea.setCreateTime(Calendar.getInstance());
		tClient.putObject(RowKeyUtil.getRowKey(num), waterArea);
	}

	@Override
	public void deleteById(Integer id) {
		tClient.delete(RowKeyUtil.getRowKey(id));
	}

	@Override
	public void updateById(WaterArea waterArea) {
		tClient.putObject(RowKeyUtil.getRowKey(waterArea.getId()), waterArea);
	}

	@Override
	public WaterArea getById(Integer id) {
		return tClient.findObject(RowKeyUtil.getRowKey(id), WaterArea.class);
	}

	@Override
	public Pagination<WaterArea> list(Pagination<WaterArea> page) {
		QueryExtInfo queryExtInfo = new QueryExtInfo();
		queryExtInfo.setLimit((page.getPageNo()-1)*page.getPageSize(), page.getPageSize());
		
		page.setList(
				tClient.findObjectList(RowKeyUtil.getRowKey(0),RowKeyUtil.getRowKey(Integer.MAX_VALUE) , WaterArea.class, queryExtInfo)
				);
				
		page.setRowCount(
				tClient.count(RowKeyUtil.getRowKey(0),RowKeyUtil.getRowKey(Integer.MAX_VALUE), null)
				);
		
		return page;
	}
}
