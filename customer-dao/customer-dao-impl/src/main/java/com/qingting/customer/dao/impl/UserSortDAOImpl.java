package com.qingting.customer.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.alipay.simplehbase.client.rowkey.BytesRowKey;
import com.alipay.simplehbase.client.rowkey.StringRowKey;
import com.qingting.customer.common.pojo.hbasedo.UserSort;
import com.qingting.customer.common.pojo.util.DateUtil;
import com.qingting.customer.common.pojo.util.RowKeyUtil;
import com.qingting.customer.dao.UserSortDAO;
import com.qingting.customer.dao.util.SHCUtil;
import com.qingting.customer.hbase.doandkey.SimpleHbaseDOWithKeyResult;
import com.qingting.customer.hbase.rowkey.RowKey;
@Repository("userSortDAO")
public class UserSortDAOImpl implements UserSortDAO {
	
	@Override
	public void insertUserSort(UserSort userSort) {
		RowKey rowKey = new BytesRowKey(RowKeyUtil.getBytes(DateUtil.getMillisOfStart()));
		SHCUtil.getSHC("userSort").insertObject(rowKey, userSort);
	}

	@Override
	public void deleteUserSortByRowKey(String rowKey) {
		SHCUtil.getSHC("userSort").delete(new StringRowKey(rowKey));
	}

	@Override
	public void updateUserSortByRowKey(UserSort userSort) {
		SHCUtil.getSHC("userSort").updateObjectWithVersion(new StringRowKey(userSort.getRowKey()), userSort, userSort.getVersion());
	}

	@Override
	public UserSort getUserSortByRowKey(String rowKey) {
		SimpleHbaseDOWithKeyResult<UserSort> result = SHCUtil.getSHC("userSort").findObjectAndKey(new StringRowKey(rowKey), UserSort.class);
		UserSort userSort=result.getT();
		userSort.setContentOfRowKey(result.getRowKey().toBytes());
		return userSort;
	}

	@Override
	public List<UserSort> listUserSort() {
		RowKey startRowKey=new BytesRowKey(RowKeyUtil.getBytes(DateUtil.getStartOfMillis()));
		RowKey endRowKey=new BytesRowKey(RowKeyUtil.getBytes(DateUtil.getMillisOfStart()));
		List<SimpleHbaseDOWithKeyResult<UserSort>> listDOWithKey = SHCUtil.getSHC("userSort").findObjectAndKeyList(startRowKey,endRowKey, UserSort.class);
		List<UserSort> list=new ArrayList<UserSort>();
		for (SimpleHbaseDOWithKeyResult<UserSort> result : listDOWithKey) {
			UserSort userSort = result.getT();
			userSort.setContentOfRowKey(result.getRowKey().toBytes());
			list.add(userSort);
		}
		return list;
	}

}
