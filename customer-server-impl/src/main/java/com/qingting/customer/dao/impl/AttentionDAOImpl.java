package com.qingting.customer.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.alipay.simplehbase.client.SimpleHbaseClient;
import com.alipay.simplehbase.client.rowkey.BytesRowKey;
import com.alipay.simplehbase.client.rowkey.RowKeyUtil;
import com.alipay.simplehbase.client.rowkey.StringRowKey;
import com.alipay.simplehbase.util.HbaseOriginService;
import com.qingting.customer.model.hbasedo.Attention;
import com.qingting.customer.model.util.DateUtil;
import com.qingting.customer.model.util.RandomUtil;
import com.qingting.customer.dao.AttentionDAO;
import com.qingting.customer.dao.util.SHCUtil;
import com.qingting.customer.hbase.doandkey.SimpleHbaseDOWithKeyResult;
import com.qingting.customer.hbase.rowkey.RowKey;

@Repository("attentionDAO")
public class AttentionDAOImpl implements AttentionDAO{
	@Resource(name="redisTemplate")
	public RedisTemplate<String, Integer> redisTemplate;
	
	private static SimpleHbaseClient tClient=SHCUtil.getSHC("attention");
	/*private static HbaseOriginService index=new HbaseOriginService("attentionIndex",
			new String[]{"aif"},
			new byte[][]{
	});*/
	
	private static RowKey createRowKey(String equipCode){
		//return RowKeyUtil.getRowKey(RandomUtil.getRandomCode(RANDOM_LENGTH),equipCode);
		return null;
	}
	@Override
	public void insertAttention(Attention attention) {
		RowKey rowKey = RowKeyUtil.getRowKey(attention.getUserId(), DateUtil.getMillisOfStart());
		
		SHCUtil.getSHC("attention").insertObject(rowKey, attention);
	}

	@Override
	public void deleteAttentionByRowKey(String rowKey) {
		SHCUtil.getSHC("attention").delete(new StringRowKey(rowKey));
	}

	@Override
	public void updateAttentionByRowKey(Attention attention) {
		//SHCUtil.getSHC("attention").updateObjectWithVersion(new StringRowKey(attention.getRowKey()), attention, attention.getVersion());
	}

	@Override
	public List<Attention> listAttentionByUserId(Integer userId) {
		RowKey startRowKey=RowKeyUtil.getRowKey(userId, DateUtil.getStartOfMillis());
		RowKey endRowKey=RowKeyUtil.getRowKey(userId, DateUtil.getMillisOfStart());
		List<SimpleHbaseDOWithKeyResult<Attention>> listDOWithKey = SHCUtil.getSHC("attention").findObjectAndKeyList(startRowKey,endRowKey, Attention.class);
		List<Attention> list=new ArrayList<Attention>();
		for (SimpleHbaseDOWithKeyResult<Attention> result : listDOWithKey) {
			Attention attention = result.getT();
			//attention.setContentOfRowKey(result.getRowKey().toBytes());
			list.add(attention);
		}
		return list;
	}
}
