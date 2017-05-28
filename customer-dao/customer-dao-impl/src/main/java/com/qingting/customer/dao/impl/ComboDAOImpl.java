package com.qingting.customer.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.alipay.simplehbase.client.rowkey.BytesRowKey;
import com.alipay.simplehbase.client.rowkey.StringRowKey;
import com.alipay.simplehbase.sequence.RedisSerialNum;
import com.alipay.simplehbase.util.SHCUtil;
import com.qingting.customer.common.pojo.hbasedo.Combo;
import com.qingting.customer.common.pojo.util.RowKeyUtil;
import com.qingting.customer.dao.ComboDAO;
import com.qingting.customer.hbase.doandkey.SimpleHbaseDOWithKeyResult;
import com.qingting.customer.hbase.rowkey.RowKey;

@Repository("comboDAO")
public class ComboDAOImpl implements ComboDAO {
	@Autowired
	public RedisTemplate<String, Integer> redisTemplate;
	@Override
	public void insertCombo(Combo combo) {
		int num=RedisSerialNum.getSerialNum(redisTemplate, "combo_id_seq");
		RowKey rowKey = new BytesRowKey(RowKeyUtil.getBytes(num));
		SHCUtil.getSHC("combo").insertObject(rowKey, combo);
	}

	@Override
	public void deleteComboByRowKey(String rowKey) {
		SHCUtil.getSHC("combo").delete(new StringRowKey(rowKey));
	}

	@Override
	public void updateComboByRowKey(Combo combo) {
		SHCUtil.getSHC("combo").updateObjectWithVersion(new StringRowKey(combo.getRowKey()), combo, combo.getVersion());
	}

	@Override
	public Combo getComboByRowKey(String rowKey) {
		SimpleHbaseDOWithKeyResult<Combo> result = SHCUtil.getSHC("combo").findObjectAndKey(new StringRowKey(rowKey), Combo.class);
		Combo combo=result.getT();
		combo.setContentOfRowKey(result.getRowKey().toBytes());
		return combo;
	}

	@Override
	public List<Combo> listCombo() {
		RowKey startRowKey=new BytesRowKey(RowKeyUtil.getBytes(0));
		RowKey endRowKey=new BytesRowKey(RowKeyUtil.getBytes(Integer.MAX_VALUE));
		List<SimpleHbaseDOWithKeyResult<Combo>> listDOWithKey = SHCUtil.getSHC("combo").findObjectAndKeyList(startRowKey,endRowKey, Combo.class);
		List<Combo> list=new ArrayList<Combo>();
		for (SimpleHbaseDOWithKeyResult<Combo> result : listDOWithKey) {
			Combo combo = result.getT();
			combo.setContentOfRowKey(result.getRowKey().toBytes());
			list.add(combo);
		}
		return list;
	}

}
