package com.qingting.customer.dao.impl;

import java.util.Calendar;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.alipay.simplehbase.client.QueryExtInfo;
import com.alipay.simplehbase.client.SimpleHbaseClient;
import com.alipay.simplehbase.client.rowkey.RowKeyUtil;
import com.alipay.simplehbase.sequence.RedisSerialNum;
import com.qingting.customer.common.pojo.hbasedo.Filter;
import com.qingting.customer.common.pojo.model.Pagination;
import com.qingting.customer.dao.FilterDAO;
import com.qingting.customer.dao.util.SHCUtil;
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

}
