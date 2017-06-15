package com.qingting.customer.dao.impl.relation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.alipay.simplehbase.client.rowkey.BytesRowKey;
import com.alipay.simplehbase.client.rowkey.StringRowKey;
import com.alipay.simplehbase.sequence.RedisSerialNum;
import com.alipay.simplehbase.util.SHCUtil;
import com.qingting.customer.common.pojo.hbasedo.ItemContext;
import com.qingting.customer.common.pojo.hbasedo.relation.ComboConfig;
import com.qingting.customer.common.pojo.util.RowKeyUtil;
import com.qingting.customer.dao.relation.ComboConfigDAO;
import com.qingting.customer.hbase.doandkey.SimpleHbaseDOWithKeyResult;
import com.qingting.customer.hbase.rowkey.RowKey;
@Repository("comboConfigDAO")
public class ComboConfigDAOImpl implements ComboConfigDAO {
	@Autowired
	public RedisTemplate<String, Integer> redisTemplate;
	@Override
	public void insertComboConfig(ComboConfig comboConfig) {
		int num=RedisSerialNum.getSerialNum(redisTemplate, "comboConfig_id_seq");
		RowKey rowKey = new BytesRowKey(RowKeyUtil.getBytes(num));
		SHCUtil.getSHC("comboConfig").insertObject(rowKey, comboConfig);
	}

	@Override
	public void deleteComboConfigByRowKey(String rowKey) {
		SHCUtil.getSHC("comboConfig").delete(new StringRowKey(rowKey));
	}

	@Override
	public void updateComboConfigByRowKey(ComboConfig comboConfig) {
		SHCUtil.getSHC("comboConfig").updateObjectWithVersion(new StringRowKey(comboConfig.getRowKey()), comboConfig, comboConfig.getVersion());
	}

	@Override
	public ComboConfig getComboConfigByRowKey(String rowKey) {
		SimpleHbaseDOWithKeyResult<ComboConfig> result = SHCUtil.getSHC("comboConfig").findObjectAndKey(new StringRowKey(rowKey), ComboConfig.class);
		ComboConfig comboConfig=result.getT();
		comboConfig.setContentOfRowKey(result.getRowKey().toBytes());
		return comboConfig;
	}

	@Override
	public List<ComboConfig> listComboConfig() {
		RowKey startRowKey=new BytesRowKey(RowKeyUtil.getBytes(0));
		RowKey endRowKey=new BytesRowKey(RowKeyUtil.getBytes(Integer.MAX_VALUE));
		List<SimpleHbaseDOWithKeyResult<ComboConfig>> listDOWithKey = SHCUtil.getSHC("comboConfig").findObjectAndKeyList(startRowKey,endRowKey, ComboConfig.class);
		List<ComboConfig> list=new ArrayList<ComboConfig>();
		for (SimpleHbaseDOWithKeyResult<ComboConfig> result : listDOWithKey) {
			ComboConfig comboConfig = result.getT();
			comboConfig.setContentOfRowKey(result.getRowKey().toBytes());
			list.add(comboConfig);
		}
		return list;
	}

}
