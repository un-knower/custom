package com.qingting.customer.dao.impl;

import java.util.Calendar;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.alipay.simplehbase.client.QueryExtInfo;
import com.alipay.simplehbase.client.SimpleHbaseClient;
import com.alipay.simplehbase.client.rowkey.RowKeyUtil;
import com.alipay.simplehbase.sequence.RedisSerialNum;
import com.qingting.customer.model.hbasedo.MicroFormula;
import com.qingting.customer.model.page.Pagination;
import com.qingting.customer.dao.MicroFormulaDAO;
import com.qingting.customer.dao.util.SHCUtil;
@Repository("microFormulaDAO")
public class MicroFormulaDAOImpl implements MicroFormulaDAO {
	@Resource(name="redisTemplate")
	public RedisTemplate<String, Integer> redisTemplate;
	
	private final static String SEQUENCE="microFormula_id_seq";
	
	private static SimpleHbaseClient tClient=SHCUtil.getSHC("microFormula");
	
	@Override
	public void insert(MicroFormula microFormula) {
		int num=RedisSerialNum.getSerialNum(redisTemplate, SEQUENCE);
		microFormula.setId(num);
		microFormula.setCreateTime(Calendar.getInstance());
		System.out.println("microFormula:"+microFormula);
		tClient.putObject(RowKeyUtil.getRowKey(num), microFormula);
	}

	@Override
	public void deleteById(Integer id) {
		tClient.delete(RowKeyUtil.getRowKey(id));
	}

	@Override
	public void updateById(MicroFormula microFormula) {
		tClient.putObject(RowKeyUtil.getRowKey(microFormula.getId()), microFormula);
	}

	@Override
	public MicroFormula getById(Integer id) {
		return tClient.findObject(RowKeyUtil.getRowKey(id), MicroFormula.class);
	}

	@Override
	public Pagination<MicroFormula> list(Pagination<MicroFormula> page) {
		QueryExtInfo queryExtInfo = new QueryExtInfo();
		queryExtInfo.setLimit((page.getPageNo()-1)*page.getPageSize(), page.getPageSize());
		
		page.setList(
				tClient.findObjectList(RowKeyUtil.getRowKey(0),RowKeyUtil.getRowKey(Integer.MAX_VALUE) , MicroFormula.class, queryExtInfo)
				);
				
		page.setRowCount(
				tClient.count(RowKeyUtil.getRowKey(0),RowKeyUtil.getRowKey(Integer.MAX_VALUE), null)
				);
		
		return page;
	}

}
