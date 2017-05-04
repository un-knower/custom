package com.qingting.customer.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.alipay.simplehbase.client.rowkey.BytesRowKey;
import com.alipay.simplehbase.client.rowkey.StringRowKey;
import com.alipay.simplehbase.util.SHCUtil;
import com.qingting.customer.common.pojo.hbasedo.Attention;
import com.qingting.customer.common.pojo.util.DateUtil;
import com.qingting.customer.common.pojo.util.RowKeyUtil;
import com.qingting.customer.dao.AttentionDAO;
import com.qingting.customer.hbase.doandkey.SimpleHbaseDOWithKeyResult;
import com.qingting.customer.hbase.rowkey.RowKey;

@Repository("attentionDAO")
public class AttentionDAOImpl implements AttentionDAO{
	
	@Override
	public void insertAttention(Attention attention) {
		RowKey rowKey = new BytesRowKey(RowKeyUtil.getBytes(attention.getUserId(), DateUtil.getMillisOfStart()));
		SHCUtil.getSHC("attention").insertObject(rowKey, attention);
	}

	@Override
	public void deleteAttentionByRowKey(String rowKey) {
		SHCUtil.getSHC("attention").delete(new StringRowKey(rowKey));
	}

	@Override
	public void updateAttentionByRowKey(Attention attention) {
		SHCUtil.getSHC("attention").updateObjectWithVersion(new StringRowKey(attention.getRowKey()), attention, attention.getVersion());
	}

	@Override
	public List<Attention> listAttentionByUserId(Integer userId) {
		RowKey startRowKey=new BytesRowKey(RowKeyUtil.getBytes(userId, DateUtil.getStartOfMillis()));
		RowKey endRowKey=new BytesRowKey(RowKeyUtil.getBytes(userId, DateUtil.getMillisOfStart()));
		List<SimpleHbaseDOWithKeyResult<Attention>> listDOWithKey = SHCUtil.getSHC("attention").findObjectAndKeyList(startRowKey,endRowKey, Attention.class);
		List<Attention> list=new ArrayList<Attention>();
		for (SimpleHbaseDOWithKeyResult<Attention> result : listDOWithKey) {
			Attention attention = result.getT();
			attention.setContentOfRowKey(result.getRowKey().toBytes());
			list.add(attention);
		}
		return list;
	}
}
