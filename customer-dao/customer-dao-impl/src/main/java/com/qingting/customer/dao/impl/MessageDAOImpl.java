package com.qingting.customer.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.alipay.simplehbase.client.SimpleHbaseClient;
import com.alipay.simplehbase.client.rowkey.RowKeyUtil;
import com.alipay.simplehbase.client.rowkey.StringRowKey;
import com.qingting.customer.common.pojo.hbasedo.Message;
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
	private final static String SEQUENCE="message_id_seq";
	private final static byte dataVersion=0;
	
	private final static int RANDOM_LENGTH=2;
	private final static int SORT_CODE_LENGTH=2;
	private final static int MOBILE_LENGTH=11;
	
	private static RowKey createRowKey(String sortCode,String mobile){
		return RowKeyUtil.getRowKey(RandomUtil.getRandomCode(RANDOM_LENGTH),sortCode,mobile);
	}
	
	private static List<Message> setContentOfRowKey(List<SimpleHbaseDOWithKeyResult<Message>> listHbase){
		List<Message> list=new ArrayList<Message>();
		for (SimpleHbaseDOWithKeyResult<Message> result : listHbase) {
			list.add(getMessageFromResult(result));
		}
		return list;
	}
	private static Message getMessageFromResult(SimpleHbaseDOWithKeyResult<Message> result){
		Message message = result.getT();
		byte[] rowkey=result.getRowKey().toBytes();
		
		message.setRowKey(result.getRowKey().toString());
		
		byte[] sortCode=new byte[SORT_CODE_LENGTH];
		System.arraycopy(rowkey, RANDOM_LENGTH, sortCode, 0, SORT_CODE_LENGTH);//中间分类编号
		message.setSortCode(new String(sortCode));
		
		byte[] userMobile=new byte[MOBILE_LENGTH];
		System.arraycopy(rowkey, RANDOM_LENGTH+SORT_CODE_LENGTH, userMobile, 0, MOBILE_LENGTH);//后4个字节用户id
		message.setUserMobile(new String(userMobile));
		return message;
	}
	@Override
	public void insertMessage(Message message) {
		System.out.println("插入信息："+message);
		tClient.putObject(createRowKey(message.getSortCode(),message.getUserMobile()), message);
	}

	@Override
	public void deleteMessageByRowKey(String rowKey) {
		tClient.delete(new StringRowKey(rowKey));
		
	}

	@Override
	public void updateMessageByRowKey(Message message) {
		tClient.updateObject(new StringRowKey(message.getRowKey()), message,dataVersion);
	}

	@Override
	public Message getMessageByRowKey(String rowKey) {
		return getMessageFromResult(
				tClient.findObjectAndKey(new StringRowKey(rowKey), Message.class)
				);
	}

	@Override
	public Pagination<Message> listMessage(String sortCode,String mobile,Integer pageNo,Integer pageSize) {
		return null;
	}


}
