package com.qingting.customer.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.alipay.simplehbase.client.rowkey.BytesRowKey;
import com.alipay.simplehbase.client.rowkey.RowKeyUtil;
import com.alipay.simplehbase.client.rowkey.StringRowKey;
import com.smart.mvc.util.DateUtil;
import com.qingting.customer.dao.WarnSortDAO;
import com.qingting.customer.dao.util.SHCUtil;
import com.qingting.customer.hbase.doandkey.SimpleHbaseDOWithKeyResult;
import com.qingting.customer.hbase.rowkey.RowKey;
import com.qingting.customer.model.WarnSort;
@Repository("warnSortDAO")
public class WarnSortDAOImpl implements WarnSortDAO {

	@Override
	public void insertWarnSort(WarnSort warnSort) {
		RowKey rowKey = RowKeyUtil.getRowKey(DateUtil.getMillisOfStart());
		SHCUtil.getSHC("warnSort").insertObject(rowKey, warnSort);
	}

	@Override
	public void deleteWarnSortByRowKey(String rowKey) {
		SHCUtil.getSHC("warnSort").delete(new StringRowKey(rowKey));
	}

	@Override
	public void updateWarnSortByRowKey(WarnSort warnSort) {
		SHCUtil.getSHC("warnSort").updateObjectWithVersion(new StringRowKey(warnSort.getRowKey()), warnSort, warnSort.getVersion());
	}

	@Override
	public WarnSort getWarnSortByRowKey(String rowKey) {
		SimpleHbaseDOWithKeyResult<WarnSort> result = SHCUtil.getSHC("warnSort").findObjectAndKey(new StringRowKey(rowKey), WarnSort.class);
		WarnSort warnSort=result.getT();
		warnSort.setContentOfRowKey(result.getRowKey().toBytes());
		return warnSort;
	}

	@Override
	public List<WarnSort> listWarnSort() {
		RowKey startRowKey=RowKeyUtil.getRowKey(DateUtil.getStartOfMillis());
		RowKey endRowKey=RowKeyUtil.getRowKey(DateUtil.getMillisOfStart());
		List<SimpleHbaseDOWithKeyResult<WarnSort>> listDOWithKey = SHCUtil.getSHC("warnSort").findObjectAndKeyList(startRowKey,endRowKey, WarnSort.class);
		List<WarnSort> list=new ArrayList<WarnSort>();
		for (SimpleHbaseDOWithKeyResult<WarnSort> result : listDOWithKey) {
			WarnSort warnSort = result.getT();
			warnSort.setContentOfRowKey(result.getRowKey().toBytes());
			list.add(warnSort);
		}
		return list;
	}

}
