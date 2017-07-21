package com.qingting.customer.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.alipay.simplehbase.client.QueryExtInfo;
import com.alipay.simplehbase.client.SimpleHbaseClient;
import com.alipay.simplehbase.client.rowkey.RowKeyUtil;
import com.alipay.simplehbase.client.rowkey.StringRowKey;
import com.alipay.simplehbase.util.FilterUtils;
import com.qingting.customer.common.pojo.common.StringUtils;
import com.qingting.customer.common.pojo.hbasedo.Equip;
import com.qingting.customer.common.pojo.hbasedo.Message;
import com.qingting.customer.common.pojo.index.MessageIndex;
import com.qingting.customer.common.pojo.model.Pagination;
import com.qingting.customer.dao.MessageDAO;
import com.qingting.customer.dao.util.RandomUtil;
import com.qingting.customer.dao.util.SHCUtil;
import com.qingting.customer.hbase.doandkey.SimpleHbaseDOWithKeyResult;
import com.qingting.customer.hbase.rowkey.RowKey;
@Repository("messageDAO")
public class MessageDAOImpl implements MessageDAO{
	
	@Resource(name="redisTemplate")
	public RedisTemplate<String, Integer> redisTemplate;
	
	private static SimpleHbaseClient tClient=SHCUtil.getSHC("message");
	private static SimpleHbaseClient indexClient=SHCUtil.getSHC("messageIndex");
	private final static String SEQUENCE="message_id_seq";
	
	private final static byte dataVersion=0;
	
	private final static int RANDOM_LENGTH=2;
	private final static int MILLIS_LENGTH=8;
	private final static int SORTCODE_LENGTH=4;
	
	private static RowKey createRowKey(Long millis){
		return RowKeyUtil.getRowKey(RandomUtil.getRandomCode(RANDOM_LENGTH),millis);
	}
	private static RowKey createIndexRowKey(Integer userId,String sortCode,Long millis){
		return RowKeyUtil.getRowKey(userId,sortCode,millis);
	}
	private static List<Message> setContentOfRowKey(List<SimpleHbaseDOWithKeyResult<Message>> listHbase){
		List<Message> list=new ArrayList<Message>();
		for (SimpleHbaseDOWithKeyResult<Message> result : listHbase) {
			list.add(getMessageFromResult(result));
		}
		return list;
	}
	private static List<RowKey> setIndexOfRowKey(List<SimpleHbaseDOWithKeyResult<MessageIndex>> listHbase){
		List<RowKey> list=new ArrayList<RowKey>();
		for (SimpleHbaseDOWithKeyResult<MessageIndex> result : listHbase) {
			list.add(getMessageIndexFromResult(result));
		}
		return list;
	}
	private static RowKey getMessageIndexFromResult(SimpleHbaseDOWithKeyResult<MessageIndex> result){
		MessageIndex messageIndex = result.getT();
		return new StringRowKey(messageIndex.getValue());
	}
	private static Message getMessageFromResult(SimpleHbaseDOWithKeyResult<Message> result){
		Message message = result.getT();
		byte[] rowkey=result.getRowKey().toBytes();
		
		message.setRowKey(result.getRowKey().toString());
		
		byte[] createTime=new byte[MILLIS_LENGTH];
		System.arraycopy(rowkey, RANDOM_LENGTH, createTime, 0, MILLIS_LENGTH);//后4个字节用户id
		Calendar cal=Calendar.getInstance();
		cal.setTimeInMillis(Bytes.toLong(createTime));
		message.setCreateTime(cal);
		
		return message;
	}
	@Override
	public void insertMessage(Message message) {
		System.out.println("插入信息："+message);
		MessageIndex messageIndex=new MessageIndex();
		RowKey rowKey=createIndexRowKey(message.getUserId(),message.getSortCode(),message.getCreateTime().getTimeInMillis());
		RowKey value=createRowKey(message.getCreateTime().getTimeInMillis());
		messageIndex.setValue(new String(value.toBytes()));
		indexClient.putObject(rowKey, messageIndex);//索引表
		tClient.putObject(value, message);
	}

	@Override
	public void deleteMessage(Integer userId,String sortCode,Long millis) {
		tClient.delete(getMessageRowKeyDeleteIndex(userId,sortCode,millis));
	}

	@Override
	public void updateMessage(Message message) {
		tClient.updateObject(getMessageRowKey(message.getUserId(),message.getSortCode(),message.getCreateTime().getTimeInMillis()), message,dataVersion);
	}
	
	public RowKey getMessageRowKey(Integer userId,String sortCode,Long millis){
		SimpleHbaseDOWithKeyResult<MessageIndex> result = indexClient.findObjectAndKey(createIndexRowKey(userId, sortCode, millis), MessageIndex.class);
		MessageIndex obj=result.getT();
		return new StringRowKey(obj.getValue());
	}
	public RowKey getMessageRowKeyDeleteIndex(Integer userId,String sortCode,Long millis){
		RowKey rowKey=createIndexRowKey(userId, sortCode, millis);
		SimpleHbaseDOWithKeyResult<MessageIndex> result = indexClient.findObjectAndKey(rowKey, MessageIndex.class);
		MessageIndex obj=result.getT();
		indexClient.delete(rowKey);
		return new StringRowKey(obj.getValue());
	}
	@Override
	public Message getMessage(Integer userId,String sortCode,Long millis) {
		return getMessageFromResult(
				tClient.findObjectAndKey(getMessageRowKey(userId,sortCode,millis), Message.class)
				);
	}
	
	@Override
	public Pagination<Message> listMessage(Integer userId,String sortCode,Integer pageNo,Integer pageSize) {
		QueryExtInfo queryExtInfo = new QueryExtInfo();
		queryExtInfo.setLimit((pageNo-1)*pageSize, pageSize);
		List<RowKey> listRowKey=null;
		List<Message> list=null;
		Pagination<Message> page=new Pagination<Message>();
		
		if(StringUtils.isZeroOrNull(userId) && StringUtils.isBlank(sortCode) ){//全空
			list=setContentOfRowKey(
					tClient.findObjectAndKeyList(RowKeyUtil.getIntStringLongMinRowKey(SORTCODE_LENGTH),RowKeyUtil.getIntStringLongMaxRowKey(SORTCODE_LENGTH),Message.class,queryExtInfo)
					);
			page.setRowCount(tClient.count(RowKeyUtil.getIntStringLongMinRowKey(SORTCODE_LENGTH),RowKeyUtil.getIntStringLongMaxRowKey(SORTCODE_LENGTH), null));
		}else if(!StringUtils.isZeroOrNull(userId) && StringUtils.isBlank(sortCode) ){
			listRowKey = setIndexOfRowKey(
					indexClient.findObjectAndKeyList(RowKeyUtil.getIntStringLongMinRowKey(userId,SORTCODE_LENGTH),RowKeyUtil.getIntStringLongMaxRowKey(userId,SORTCODE_LENGTH),MessageIndex.class,FilterUtils.getPrefixFilter(userId),queryExtInfo)
					);
			list=setContentOfRowKey(
					tClient.findObjectAndKeyBatch(listRowKey,Message.class)
					);
			page.setRowCount(tClient.count(RowKeyUtil.getIntStringLongMinRowKey(userId,SORTCODE_LENGTH),RowKeyUtil.getIntStringLongMaxRowKey(userId,SORTCODE_LENGTH), FilterUtils.getPrefixFilter(userId)));
		}else if(!StringUtils.isZeroOrNull(userId) && !StringUtils.isBlank(sortCode) ){
			listRowKey = setIndexOfRowKey(
					indexClient.findObjectAndKeyList(RowKeyUtil.getIntStringLongMinRowKey(userId,sortCode),RowKeyUtil.getIntStringLongMaxRowKey(userId,sortCode),MessageIndex.class,FilterUtils.getPrefixFilter(userId),queryExtInfo)
					);
			list=setContentOfRowKey(
					tClient.findObjectAndKeyBatch(listRowKey,Message.class)
					);
			page.setRowCount(tClient.count(RowKeyUtil.getIntStringLongMinRowKey(userId,sortCode),RowKeyUtil.getIntStringLongMaxRowKey(userId,sortCode), FilterUtils.getPrefixFilter(userId)));
		}
		
		page.setList(list);
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		return page;
	}


}
