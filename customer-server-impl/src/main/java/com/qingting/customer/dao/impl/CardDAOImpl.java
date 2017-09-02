package com.qingting.customer.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.alipay.simplehbase.client.QueryExtInfo;
import com.alipay.simplehbase.client.SimpleHbaseClient;
import com.alipay.simplehbase.client.rowkey.RowKeyUtil;
import com.alipay.simplehbase.sequence.RedisSerialNum;
import com.alipay.simplehbase.util.FilterUtils;
import com.smart.mvc.model.Pagination;
import com.qingting.customer.dao.CardDAO;
import com.qingting.customer.dao.util.SHCUtil;
import com.qingting.customer.hbase.doandkey.SimpleHbaseDOWithKeyResult;
import com.qingting.customer.hbase.rowkey.RowKey;
import com.qingting.customer.model.Card;
import com.qingting.customer.model.Monitor;
@Repository("cardDAO")
public class CardDAOImpl implements CardDAO {
	@Resource(name="redisTemplate")
	public RedisTemplate<String, Integer> redisTemplate;
	
	private static SimpleHbaseClient tClient=SHCUtil.getSHC("card");
	private final static String SEQUENCE="card_id_seq";
	@Override
	public void insert(Card card) {
		int num=RedisSerialNum.getSerialNum(redisTemplate, SEQUENCE);
		card.setId(num);
		card.setCreateTime(Calendar.getInstance());
		tClient.putObject(RowKeyUtil.getRowKey(num), card);
	}

	@Override
	public Pagination<Card> list(Pagination<Card> page) {
		QueryExtInfo queryExtInfo = new QueryExtInfo();
		
		queryExtInfo.setLimit((page.getPageNo()-1)*page.getPageSize(), page.getPageSize());
		
		page.setList(tClient.findObjectList(RowKeyUtil.getRowKey(0), RowKeyUtil.getRowKey(Integer.MAX_VALUE), Card.class, queryExtInfo));
		page.setRowCount(tClient.count(RowKeyUtil.getRowKey(0), RowKeyUtil.getRowKey(Integer.MAX_VALUE), null));
		return page;
	}

	@Override
	public List<Card> search(String number) {
		List<Card> result=null;
		List<SimpleHbaseDOWithKeyResult<Card>> list = tClient.findObjectAndKeyList(RowKeyUtil.getRowKey(0), RowKeyUtil.getRowKey(Integer.MAX_VALUE), Card.class, FilterUtils.getNotContainFilter(number), null);
		if(list!=null && list.size()>0){
			result=new ArrayList<Card>();
			for (SimpleHbaseDOWithKeyResult<Card> shdr : list) {
				result.add(shdr.getT());
			}
		}
		return result;
	}

}
