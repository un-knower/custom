package com.qingting.customer.dao.impl.relation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.alipay.simplehbase.client.rowkey.BytesRowKey;
import com.alipay.simplehbase.client.rowkey.StringRowKey;
import com.alipay.simplehbase.sequence.RedisSerialNum;
import com.qingting.customer.model.hbasedo.relation.ComboExtra;
import com.qingting.customer.model.util.RowKeyUtil;
import com.qingting.customer.dao.relation.ComboExtraDAO;
import com.qingting.customer.dao.util.SHCUtil;
import com.qingting.customer.hbase.doandkey.SimpleHbaseDOWithKeyResult;
import com.qingting.customer.hbase.rowkey.RowKey;
@Repository("comboExtraDAO")
public class ComboExtraImpl implements ComboExtraDAO {
	@Autowired
	public RedisTemplate<String, Integer> redisTemplate;
	
	@Override
	public void insertComboExtra(ComboExtra comboExtra) {
		int num=RedisSerialNum.getSerialNum(redisTemplate, "comboExtra_id_seq");
		RowKey rowKey = new BytesRowKey(RowKeyUtil.getBytes(num));
		SHCUtil.getSHC("comboExtra").insertObject(rowKey, comboExtra);
	}

	@Override
	public void deleteComboExtraByRowKey(String rowKey) {
		SHCUtil.getSHC("comboExtra").delete(new StringRowKey(rowKey));
	}

	@Override
	public void updateComboExtraByRowKey(ComboExtra comboExtra) {
		SHCUtil.getSHC("comboExtra").updateObjectWithVersion(new StringRowKey(comboExtra.getRowKey()), comboExtra, comboExtra.getVersion());
	}

	@Override
	public ComboExtra getComboExtraByRowKey(String rowKey) {
		SimpleHbaseDOWithKeyResult<ComboExtra> result = SHCUtil.getSHC("comboExtra").findObjectAndKey(new StringRowKey(rowKey), ComboExtra.class);
		ComboExtra comboExtra=result.getT();
		comboExtra.setContentOfRowKey(result.getRowKey().toBytes());
		return comboExtra;
	}

	@Override
	public List<ComboExtra> listComboExtra() {
		RowKey startRowKey=new BytesRowKey(RowKeyUtil.getBytes(0));
		RowKey endRowKey=new BytesRowKey(RowKeyUtil.getBytes(Integer.MAX_VALUE));
		List<SimpleHbaseDOWithKeyResult<ComboExtra>> listDOWithKey = SHCUtil.getSHC("comboExtra").findObjectAndKeyList(startRowKey,endRowKey, ComboExtra.class);
		List<ComboExtra> list=new ArrayList<ComboExtra>();
		for (SimpleHbaseDOWithKeyResult<ComboExtra> result : listDOWithKey) {
			ComboExtra comboExtra = result.getT();
			comboExtra.setContentOfRowKey(result.getRowKey().toBytes());
			list.add(comboExtra);
		}
		return list;
	}

}
