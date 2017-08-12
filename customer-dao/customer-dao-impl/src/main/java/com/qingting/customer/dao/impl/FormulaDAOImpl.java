package com.qingting.customer.dao.impl;


import java.util.Calendar;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.alipay.simplehbase.client.QueryExtInfo;
import com.alipay.simplehbase.client.SimpleHbaseClient;
import com.alipay.simplehbase.client.rowkey.RowKeyUtil;
import com.alipay.simplehbase.sequence.RedisSerialNum;
import com.alipay.simplehbase.util.HbaseOriginService;
import com.qingting.customer.common.pojo.hbasedo.Formula;
import com.qingting.customer.common.pojo.model.Pagination;
import com.qingting.customer.dao.FormulaDAO;
import com.qingting.customer.dao.util.SHCUtil;
import com.qingting.customer.hbase.rowkey.RowKey;
@Repository("formulaDAO")
public class FormulaDAOImpl implements FormulaDAO {
	@Resource(name="redisTemplate")
	public RedisTemplate<String, Integer> redisTemplate;
	
	private final static String SEQUENCE="formula_id_seq";
	
	private static SimpleHbaseClient tClient=SHCUtil.getSHC("formula");
	
	private static HbaseOriginService filterOrderIndex=new HbaseOriginService("filterOrderIndex",
			new String[]{"foif"},
			new byte[][]{
	});
	
	@Override
	public void insert(Formula formula) {
		int num=RedisSerialNum.getSerialNum(redisTemplate, SEQUENCE);
		formula.setId(num);
		RowKey rowKey=RowKeyUtil.getRowKey(num);
		filterOrderIndex.put(RowKeyUtil.getRowKey(formula.getFilterId(),formula.getOrder()), "foif", "value", rowKey.toBytes());
		formula.setCreateTime(Calendar.getInstance());
		tClient.putObject(rowKey, formula); 
	}

	@Override
	public void deleteById(Integer id) {
		Formula formula = getById(id);
		filterOrderIndex.delete(RowKeyUtil.getRowKey(formula.getFilterId(),formula.getOrder()));
		tClient.delete(RowKeyUtil.getRowKey(id));
	}

	@Override
	public void updateById(Formula formula) {
		Formula hisFormula = getById(formula.getId());
		if(hisFormula.getFilterId().equals(formula.getFilterId()) &&
			hisFormula.getOrder().equals(formula.getOrder())
				){//这里需要修改索引
			filterOrderIndex.delete(RowKeyUtil.getRowKey(hisFormula.getFilterId(),hisFormula.getOrder()));
			filterOrderIndex.put(RowKeyUtil.getRowKey(formula.getFilterId(),formula.getOrder()), "foif", "value", RowKeyUtil.getRowKey(formula.getId()).toBytes());
		}
		tClient.putObject(RowKeyUtil.getRowKey(formula.getId()), formula);
	}

	@Override
	public Formula getById(Integer id) {
		return tClient.findObject(RowKeyUtil.getRowKey(id), Formula.class);
	}
	@Override
	public Formula getByFilterIdAndOrder(Integer filterId,Byte order){
		RowKey rowKey = filterOrderIndex.indexGet(RowKeyUtil.getRowKey(filterId,order), null, null, "value");
		return tClient.findObject(rowKey, Formula.class);
	}
	@Override
	public Pagination<Formula> list(Pagination<Formula> page) {
		QueryExtInfo queryExtInfo = new QueryExtInfo();
		queryExtInfo.setLimit((page.getPageNo()-1)*page.getPageSize(), page.getPageSize());
		
		page.setList(
				tClient.findObjectList(RowKeyUtil.getRowKey(0),RowKeyUtil.getRowKey(Integer.MAX_VALUE) , Formula.class, queryExtInfo)
				);
				
		page.setRowCount(
				tClient.count(RowKeyUtil.getRowKey(0),RowKeyUtil.getRowKey(Integer.MAX_VALUE), null)
				);
		
		return page;
	}

	
}
