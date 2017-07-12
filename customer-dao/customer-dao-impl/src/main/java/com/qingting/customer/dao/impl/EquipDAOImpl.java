package com.qingting.customer.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.alipay.simplehbase.client.rowkey.BytesRowKey;
import com.alipay.simplehbase.client.rowkey.StringRowKey;
import com.alipay.simplehbase.enums.SerialType;
import com.alipay.simplehbase.sequence.RedisSerialNum;
import com.qingting.customer.common.pojo.hbasedo.Equip;
import com.qingting.customer.common.pojo.util.DateUtil;
import com.qingting.customer.common.pojo.util.RowKeyUtil;
import com.qingting.customer.dao.EquipDAO;
import com.qingting.customer.dao.util.SHCUtil;
import com.qingting.customer.hbase.doandkey.SimpleHbaseDOWithKeyResult;
import com.qingting.customer.hbase.rowkey.RowKey;

@Repository("equipDAO")
public class EquipDAOImpl implements EquipDAO {
	@Resource(name="redisTemplate")
	public RedisTemplate<String, Integer> redisTemplate;
	@Override
	public void insertEquip(Equip equip) {
		int num=RedisSerialNum.getSerialNum(redisTemplate, SerialType.SERIALNUM.getValue());
		RowKey rowKey = new BytesRowKey(RowKeyUtil.getBytes(equip.getProjectId(), DateUtil.getMillisOfStart(),num));
		SHCUtil.getSHC("equip").insertObject(rowKey, equip);
	}

	@Override
	public void deleteEquipByRowKey(String rowKey) {
		SHCUtil.getSHC("equip").delete(new StringRowKey(rowKey));
	}

	@Override
	public void updateEquipByRowKey(Equip equip) {
		SHCUtil.getSHC("equip").updateObjectWithVersion(new StringRowKey(equip.getRowKey()), equip, equip.getVersion());
	}

	@Override
	public List<Equip> listEquipByProjectId(Integer projectId) {
		RowKey startRowKey=new BytesRowKey(RowKeyUtil.getBytes(projectId, DateUtil.getStartOfMillis()));
		RowKey endRowKey=new BytesRowKey(RowKeyUtil.getBytes(projectId, DateUtil.getMillisOfStart()));
		List<SimpleHbaseDOWithKeyResult<Equip>> listDOWithKey = SHCUtil.getSHC("equip").findObjectAndKeyList(startRowKey,endRowKey, Equip.class);
		List<Equip> list=new ArrayList<Equip>();
		for (SimpleHbaseDOWithKeyResult<Equip> result : listDOWithKey) {
			Equip equip = result.getT();
			equip.setContentOfRowKey(result.getRowKey().toBytes());
			list.add(equip);
		}
		return list;
	}
}
