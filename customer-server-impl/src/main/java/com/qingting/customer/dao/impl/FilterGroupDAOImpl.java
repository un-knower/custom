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
import com.qingting.customer.model.hbasedo.FilterGroup;
import com.qingting.customer.model.page.Pagination;
import com.qingting.customer.dao.FilterGroupDAO;
import com.qingting.customer.dao.util.SHCUtil;
@Repository("filterGroupDAO")
public class FilterGroupDAOImpl implements FilterGroupDAO {
	@Resource(name="redisTemplate")
	public RedisTemplate<String, Integer> redisTemplate;
	
	private final static String SEQUENCE="filterGroup_id_seq";
	
	private static SimpleHbaseClient tClient=SHCUtil.getSHC("filterGroup");
	@Override
	public void insert(FilterGroup filterGroup) {
		int num=RedisSerialNum.getSerialNum(redisTemplate, SEQUENCE);
		filterGroup.setId(num);
		filterGroup.setCreateTime(Calendar.getInstance());
		tClient.putObject(RowKeyUtil.getRowKey(num), filterGroup);
	}

	@Override
	public void deleteById(Integer id) {
		tClient.delete(RowKeyUtil.getRowKey(id));
	}

	@Override
	public void updateById(FilterGroup filterGroup) {
		tClient.putObject(RowKeyUtil.getRowKey(filterGroup.getId()), filterGroup);
	}

	@Override
	public FilterGroup getById(Integer id) {
		return tClient.findObject(RowKeyUtil.getRowKey(id), FilterGroup.class);
	}

	@Override
	public Pagination<FilterGroup> list(Pagination<FilterGroup> page) {
		QueryExtInfo queryExtInfo = new QueryExtInfo();
		queryExtInfo.setLimit((page.getPageNo()-1)*page.getPageSize(), page.getPageSize());
		
		page.setList(
				tClient.findObjectList(RowKeyUtil.getRowKey(0),RowKeyUtil.getRowKey(Integer.MAX_VALUE) , FilterGroup.class, queryExtInfo)
				);
				
		page.setRowCount(
				tClient.count(RowKeyUtil.getRowKey(0),RowKeyUtil.getRowKey(Integer.MAX_VALUE), null)
				);
		
		return page;
	}

	@Override
	public List<FilterGroup> list() {
		return tClient.findObjectList(RowKeyUtil.getRowKey(0),RowKeyUtil.getRowKey(Integer.MAX_VALUE) , FilterGroup.class);
	}

}
