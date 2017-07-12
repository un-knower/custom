package com.qingting.customer.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.alipay.simplehbase.client.rowkey.BytesRowKey;
import com.alipay.simplehbase.client.rowkey.StringRowKey;
import com.qingting.customer.common.pojo.hbasedo.MessageSort;
import com.qingting.customer.common.pojo.util.DateUtil;
import com.qingting.customer.common.pojo.util.RowKeyUtil;
import com.qingting.customer.dao.MessageSortDAO;
import com.qingting.customer.dao.util.SHCUtil;
import com.qingting.customer.hbase.doandkey.SimpleHbaseDOWithKeyResult;
import com.qingting.customer.hbase.rowkey.RowKey;
@Repository("messageSortDAO")
public class MessageSortDAOImpl implements MessageSortDAO {

	@Override
	public void insertMessageSort(MessageSort messageSort) {
		RowKey rowKey = new BytesRowKey(RowKeyUtil.getBytes(DateUtil.getMillisOfStart()));
		SHCUtil.getSHC("messageSort").insertObject(rowKey, messageSort);
	}

	@Override
	public void deleteMessageSort(String rowKey) {
		SHCUtil.getSHC("messageSort").delete(new StringRowKey(rowKey));
	}

	@Override
	public void updateMessageSortByRowKey(MessageSort messageSort) {
		SHCUtil.getSHC("messageSort").updateObjectWithVersion(new StringRowKey(messageSort.getRowKey()), messageSort, messageSort.getVersion());
	}

	@Override
	public MessageSort getMessageSort(String rowKey) {
		SimpleHbaseDOWithKeyResult<MessageSort> result = SHCUtil.getSHC("messageSort").findObjectAndKey(new StringRowKey(rowKey), MessageSort.class);
		MessageSort messageSort=result.getT();
		messageSort.setContentOfRowKey(result.getRowKey().toBytes());
		return messageSort;
	}

	@Override
	public List<MessageSort> listMessageSort() {
		RowKey startRowKey=new BytesRowKey(RowKeyUtil.getBytes(DateUtil.getStartOfMillis()));
		RowKey endRowKey=new BytesRowKey(RowKeyUtil.getBytes(DateUtil.getMillisOfStart()));
		List<SimpleHbaseDOWithKeyResult<MessageSort>> listDOWithKey = SHCUtil.getSHC("messageSort").findObjectAndKeyList(startRowKey,endRowKey, MessageSort.class);
		List<MessageSort> list=new ArrayList<MessageSort>();
		for (SimpleHbaseDOWithKeyResult<MessageSort> result : listDOWithKey) {
			MessageSort messageSort = result.getT();
			messageSort.setContentOfRowKey(result.getRowKey().toBytes());
			list.add(messageSort);
		}
		return list;
	}

}
