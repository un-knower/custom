package com.qingting.customer.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.alipay.simplehbase.client.rowkey.BytesRowKey;
import com.alipay.simplehbase.client.rowkey.StringRowKey;
import com.alipay.simplehbase.sequence.RedisSerialNum;
import com.qingting.customer.common.pojo.hbasedo.Config;
import com.qingting.customer.common.pojo.util.RowKeyUtil;
import com.qingting.customer.dao.ConfigDAO;
import com.qingting.customer.dao.util.SHCUtil;
import com.qingting.customer.hbase.doandkey.SimpleHbaseDOWithKeyResult;
import com.qingting.customer.hbase.rowkey.RowKey;
@Repository("configDAO")
public class ConfigDAOImpl implements ConfigDAO {
	@Autowired
	public RedisTemplate<String, Integer> redisTemplate;
	@Override
	public void insertConfig(Config config) {
		int num=RedisSerialNum.getSerialNum(redisTemplate, "config_id_seq");
		RowKey rowKey = new BytesRowKey(RowKeyUtil.getBytes(num));
		SHCUtil.getSHC("config").insertObject(rowKey, config);
	}

	@Override
	public void deleteConfigByRowKey(String rowKey) {
		SHCUtil.getSHC("config").delete(new StringRowKey(rowKey));
	}

	@Override
	public void updateConfigByRowKey(Config config) {
		SHCUtil.getSHC("config").updateObjectWithVersion(new StringRowKey(config.getRowKey()), config, config.getVersion());
	}

	@Override
	public Config getConfigByRowKey(String rowKey) {
		SimpleHbaseDOWithKeyResult<Config> result = SHCUtil.getSHC("config").findObjectAndKey(new StringRowKey(rowKey), Config.class);
		Config config=result.getT();
		config.setContentOfRowKey(result.getRowKey().toBytes());
		return config;
	}

	@Override
	public List<Config> listConfig() {
		RowKey startRowKey=new BytesRowKey(RowKeyUtil.getBytes(0));
		RowKey endRowKey=new BytesRowKey(RowKeyUtil.getBytes(Integer.MAX_VALUE));
		List<SimpleHbaseDOWithKeyResult<Config>> listDOWithKey = SHCUtil.getSHC("config").findObjectAndKeyList(startRowKey,endRowKey, Config.class);
		List<Config> list=new ArrayList<Config>();
		for (SimpleHbaseDOWithKeyResult<Config> result : listDOWithKey) {
			Config config = result.getT();
			config.setContentOfRowKey(result.getRowKey().toBytes());
			list.add(config);
		}
		return list;
	}

}
