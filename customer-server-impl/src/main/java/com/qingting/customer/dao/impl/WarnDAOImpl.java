package com.qingting.customer.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.alipay.simplehbase.client.rowkey.BytesRowKey;
import com.alipay.simplehbase.client.rowkey.StringRowKey;
import com.alipay.simplehbase.enums.SerialType;
import com.alipay.simplehbase.sequence.RedisSerialNum;
import com.qingting.customer.model.hbasedo.Warn;
import com.qingting.customer.model.util.DateUtil;
import com.qingting.customer.model.util.RowKeyUtil;
import com.qingting.customer.dao.WarnDAO;
import com.qingting.customer.dao.util.SHCUtil;
import com.qingting.customer.hbase.doandkey.SimpleHbaseDOWithKeyResult;
import com.qingting.customer.hbase.rowkey.RowKey;
@Repository("warnDAO")
public class WarnDAOImpl implements WarnDAO {
	@Autowired
	public RedisTemplate<String, Integer> redisTemplate;
	@Override
	public void insertWarn(Warn warn) {
		int num=RedisSerialNum.getSerialNum(redisTemplate, SerialType.SERIALNUM.getValue());
		RowKey rowKey = new BytesRowKey(RowKeyUtil.getBytes(warn.getEquipId(), DateUtil.getMillisOfStart(),num));
		SHCUtil.getSHC("warn").insertObject(rowKey, warn);
	}

	@Override
	public void deleteWarnByRowKey(String rowKey) {
		SHCUtil.getSHC("warn").delete(new StringRowKey(rowKey));
	}

	@Override
	public void updateWarnByRowKey(Warn warn) {
		SHCUtil.getSHC("warn").updateObjectWithVersion(new StringRowKey(warn.getRowKey()), warn, warn.getVersion());

	}

	@Override
	public Warn getWarnById(String rowKey) {
		SimpleHbaseDOWithKeyResult<Warn> result = SHCUtil.getSHC("warn").findObjectAndKey(new StringRowKey(rowKey), Warn.class);
		Warn warn=result.getT();
		warn.setContentOfRowKey(result.getRowKey().toBytes());
		return warn;
	}

	@Override
	public List<Warn> listWarn(String equipId) {
		RowKey startRowKey=new BytesRowKey(RowKeyUtil.getBytes(DateUtil.getStartOfMillis()));
		RowKey endRowKey=new BytesRowKey(RowKeyUtil.getBytes(DateUtil.getMillisOfStart()));
		List<SimpleHbaseDOWithKeyResult<Warn>> listDOWithKey = SHCUtil.getSHC("warn").findObjectAndKeyList(startRowKey,endRowKey, Warn.class);
		List<Warn> list=new ArrayList<Warn>();
		for (SimpleHbaseDOWithKeyResult<Warn> result : listDOWithKey) {
			Warn warn = result.getT();
			warn.setContentOfRowKey(result.getRowKey().toBytes());
			list.add(warn);
		}
		return list;
	}
}
