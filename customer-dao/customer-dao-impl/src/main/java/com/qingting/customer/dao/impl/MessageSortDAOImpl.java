package com.qingting.customer.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.alipay.simplehbase.client.QueryExtInfo;
import com.alipay.simplehbase.client.SimpleHbaseClient;
import com.alipay.simplehbase.client.rowkey.RowKeyUtil;
import com.alipay.simplehbase.client.rowkey.StringRowKey;
import com.alipay.simplehbase.sequence.RedisSerialNum;
import com.qingting.customer.common.pojo.hbasedo.EquipSort;
import com.qingting.customer.common.pojo.hbasedo.MessageSort;
import com.qingting.customer.common.pojo.model.Pagination;
import com.qingting.customer.dao.MessageSortDAO;
import com.qingting.customer.dao.util.SHCUtil;
import com.qingting.customer.hbase.doandkey.SimpleHbaseDOWithKeyResult;
@Repository("messageSortDAO")
public class MessageSortDAOImpl implements MessageSortDAO {
	@Autowired
	public RedisTemplate<String, Integer> redisTemplate;
	
	private static SimpleHbaseClient tClient=SHCUtil.getSHC("messageSort");
	private final static String SEQUENCE="messageSort_id_seq";
	private final static byte dataVersion=0;
	
	private static List<MessageSort> setContentOfRowKey(List<SimpleHbaseDOWithKeyResult<MessageSort>> listHbase){
		List<MessageSort> list=new ArrayList<MessageSort>();
		for (SimpleHbaseDOWithKeyResult<MessageSort> result : listHbase) {
			list.add(getMessageSortFromResult(result));
		}
		return list;
	}
	private static MessageSort getMessageSortFromResult(SimpleHbaseDOWithKeyResult<MessageSort> result){
		MessageSort messageSort = result.getT();
		byte[] rowkey=result.getRowKey().toBytes();
		messageSort.setId(Bytes.toInt(rowkey));
		return messageSort;
	}
	@Override
	public void insertMessageSort(MessageSort messageSort) {
		int num=RedisSerialNum.getSerialNum(redisTemplate, SEQUENCE);
		messageSort.setId(num);
		tClient.putObject(RowKeyUtil.getRowKey(num), messageSort);
	}

	@Override
	public void deleteMessageSort(String rowKey) {
		tClient.delete(RowKeyUtil.getRowKey(rowKey));
	}

	@Override
	public void updateMessageSortByRowKey(MessageSort messageSort) {
		tClient.updateObjectWithVersion(RowKeyUtil.getRowKey(messageSort.getRowKey()), messageSort, dataVersion);
	}

	@Override
	public MessageSort getMessageSort(String rowKey) {
		return getMessageSortFromResult(
				tClient.findObjectAndKey(new StringRowKey(rowKey), MessageSort.class)
				);
	}

	@Override
	public Pagination<MessageSort> listMessageSort(Integer pageNo,Integer pageSize) {
		QueryExtInfo queryExtInfo = new QueryExtInfo();
		queryExtInfo.setLimit((pageNo-1)*pageSize, pageSize);
		List<MessageSort> list=null;
		Pagination<MessageSort> page=new Pagination<MessageSort>();
		
		list=setContentOfRowKey(
				tClient.findObjectAndKeyList(RowKeyUtil.getIntMinRowKey(),RowKeyUtil.getIntMaxRowKey(), MessageSort.class,null,queryExtInfo)
				);
		page.setRowCount(tClient.count(RowKeyUtil.getIntMinRowKey(), RowKeyUtil.getIntMaxRowKey(), null));
		
		page.setList(list);
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		return page;
	}

}
