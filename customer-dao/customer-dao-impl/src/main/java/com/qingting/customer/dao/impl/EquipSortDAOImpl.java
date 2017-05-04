package com.qingting.customer.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.alipay.simplehbase.client.rowkey.BytesRowKey;
import com.alipay.simplehbase.client.rowkey.StringRowKey;
import com.alipay.simplehbase.util.SHCUtil;
import com.qingting.customer.common.pojo.hbasedo.EquipSort;
import com.qingting.customer.common.pojo.util.DateUtil;
import com.qingting.customer.common.pojo.util.RowKeyUtil;
import com.qingting.customer.dao.EquipSortDAO;
import com.qingting.customer.hbase.doandkey.SimpleHbaseDOWithKeyResult;
import com.qingting.customer.hbase.rowkey.RowKey;
@Repository("equipSortDAO")
public class EquipSortDAOImpl implements EquipSortDAO {

	@Override
	public void insertEquipSort(EquipSort equipSort) {
		RowKey rowKey = new BytesRowKey(RowKeyUtil.getBytes(DateUtil.getMillisOfStart()));
		SHCUtil.getSHC("equipSort").insertObject(rowKey, equipSort);
	}

	@Override
	public void deleteEquipSortByRowKey(String rowKey) {
		SHCUtil.getSHC("equipSort").delete(new StringRowKey(rowKey));
	}

	@Override
	public void updateEquipSortByRowKey(EquipSort equipSort) {
		SHCUtil.getSHC("equipSort").updateObjectWithVersion(new StringRowKey(equipSort.getRowKey()), equipSort, equipSort.getVersion());
	}

	@Override
	public EquipSort getEquipSortByRowKey(String rowKey) {
		SimpleHbaseDOWithKeyResult<EquipSort> result = SHCUtil.getSHC("equipSort").findObjectAndKey(new StringRowKey(rowKey), EquipSort.class);
		EquipSort equipSort=result.getT();
		equipSort.setContentOfRowKey(result.getRowKey().toBytes());
		return equipSort;
	}

	@Override
	public List<EquipSort> listEquipSort() {
		RowKey startRowKey=new BytesRowKey(RowKeyUtil.getBytes(DateUtil.getStartOfMillis()));
		RowKey endRowKey=new BytesRowKey(RowKeyUtil.getBytes(DateUtil.getMillisOfStart()));
		List<SimpleHbaseDOWithKeyResult<EquipSort>> listDOWithKey = SHCUtil.getSHC("equipSort").findObjectAndKeyList(startRowKey,endRowKey, EquipSort.class);
		List<EquipSort> list=new ArrayList<EquipSort>();
		for (SimpleHbaseDOWithKeyResult<EquipSort> result : listDOWithKey) {
			EquipSort equipSort = result.getT();
			equipSort.setContentOfRowKey(result.getRowKey().toBytes());
			list.add(equipSort);
		}
		return list;
	}

}
