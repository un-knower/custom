package com.qingting.customer.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.alipay.simplehbase.client.rowkey.BytesRowKey;
import com.alipay.simplehbase.client.rowkey.StringRowKey;
import com.qingting.customer.common.pojo.hbasedo.Formula;
import com.qingting.customer.common.pojo.util.DateUtil;
import com.qingting.customer.common.pojo.util.RowKeyUtil;
import com.qingting.customer.dao.FormulaDAO;
import com.qingting.customer.dao.util.SHCUtil;
import com.qingting.customer.hbase.doandkey.SimpleHbaseDOWithKeyResult;
import com.qingting.customer.hbase.rowkey.RowKey;
@Repository("formulaDAO")
public class FormulaDAOImpl implements FormulaDAO {

	@Override
	public void insertFormula(Formula formula) {
		RowKey rowKey = new BytesRowKey(RowKeyUtil.getBytes(DateUtil.getMillisOfStart()));
		SHCUtil.getSHC("formula").insertObject(rowKey, formula);
	}

	@Override
	public void deleteFormulaByRowKey(String rowKey) {
		SHCUtil.getSHC("formula").delete(new StringRowKey(rowKey));
	}

	@Override
	public void updateFormulaByRowKey(Formula formula) {
		SHCUtil.getSHC("formula").updateObjectWithVersion(new StringRowKey(formula.getRowKey()), formula, formula.getVersion());
	}

	@Override
	public Formula getFormulaByRowKey(String rowKey) {
		SimpleHbaseDOWithKeyResult<Formula> result = SHCUtil.getSHC("formula").findObjectAndKey(new StringRowKey(rowKey), Formula.class);
		Formula formula=result.getT();
		formula.setContentOfRowKey(result.getRowKey().toBytes());
		return formula;
	}

	@Override
	public List<Formula> listFormula() {
		RowKey startRowKey=new BytesRowKey(RowKeyUtil.getBytes(DateUtil.getStartOfMillis()));
		RowKey endRowKey=new BytesRowKey(RowKeyUtil.getBytes(DateUtil.getMillisOfStart()));
		List<SimpleHbaseDOWithKeyResult<Formula>> listDOWithKey = SHCUtil.getSHC("formula").findObjectAndKeyList(startRowKey,endRowKey, Formula.class);
		List<Formula> list=new ArrayList<Formula>();
		for (SimpleHbaseDOWithKeyResult<Formula> result : listDOWithKey) {
			Formula formula = result.getT();
			formula.setContentOfRowKey(result.getRowKey().toBytes());
			list.add(formula);
		}
		return list;
	}

}
