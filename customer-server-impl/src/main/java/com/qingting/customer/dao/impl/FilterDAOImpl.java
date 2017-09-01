package com.qingting.customer.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.alipay.simplehbase.client.QueryExtInfo;
import com.alipay.simplehbase.client.SimpleHbaseClient;
import com.alipay.simplehbase.client.rowkey.RowKeyUtil;
import com.alipay.simplehbase.sequence.RedisSerialNum;
import com.qingting.customer.model.hbasedo.Filter;
import com.qingting.customer.model.page.Pagination;
import com.qingting.customer.dao.FilterDAO;
import com.qingting.customer.dao.util.SHCUtil;
import com.qingting.customer.hbase.rowkey.RowKey;
@Repository("filterDAO")
public class FilterDAOImpl implements FilterDAO {
	@Resource(name="redisTemplate")
	public RedisTemplate<String, Integer> redisTemplate;
	
	private final static String SEQUENCE="filter_id_seq";
	
	private static SimpleHbaseClient tClient=SHCUtil.getSHC("filter");
	@Override
	public void insert(Filter filter) {
		int num=RedisSerialNum.getSerialNum(redisTemplate, SEQUENCE);
		filter.setId(num);
		filter.setCreateTime(Calendar.getInstance());
		tClient.putObject(RowKeyUtil.getRowKey(num), filter);
	}

	@Override
	public void deleteById(Integer id) {
		tClient.delete(RowKeyUtil.getRowKey(id));
	}

	@Override
	public void updateById(Filter filter) {
		tClient.putObject(RowKeyUtil.getRowKey(filter.getId()), filter);
	}

	@Override
	public Filter getById(Integer id) {
		return tClient.findObject(RowKeyUtil.getRowKey(id), Filter.class);
	}

	@Override
	public Pagination<Filter> list(Pagination<Filter> page) {
		QueryExtInfo queryExtInfo = new QueryExtInfo();
		queryExtInfo.setLimit((page.getPageNo()-1)*page.getPageSize(), page.getPageSize());
		
		page.setList(
				tClient.findObjectList(RowKeyUtil.getRowKey(0),RowKeyUtil.getRowKey(Integer.MAX_VALUE) , Filter.class, queryExtInfo)
				);
				
		page.setRowCount(
				tClient.count(RowKeyUtil.getRowKey(0),RowKeyUtil.getRowKey(Integer.MAX_VALUE), null)
				);
		
		return page;
	}
	@Override
	public Map<Integer,Filter> listByIds(List<Integer> listIds){
		List<RowKey> rowKeyList=new ArrayList<RowKey>();
		for (Integer integer : listIds) {
			rowKeyList.add(RowKeyUtil.getRowKey(integer));
		}
		List<Filter> list =  tClient.findObjectBatch(rowKeyList, Filter.class);
		Map<Integer,Filter> map=new HashMap<Integer,Filter>();
		for (Filter filter : list) {
			map.put(filter.getId(), filter);
		}
		return map;
	}
	@Override
	public Map<Integer,Filter> listByIds(Set<Integer> setIds){
		List<RowKey> rowKeyList=new ArrayList<RowKey>();
		for (Integer integer : setIds) {
			rowKeyList.add(RowKeyUtil.getRowKey(integer));
		}
		List<Filter> list =  tClient.findObjectBatch(rowKeyList, Filter.class);
		Map<Integer,Filter> map=new HashMap<Integer,Filter>();
		for (Filter filter : list) {
			map.put(filter.getId(), filter);
		}
		return map;
	}
}
