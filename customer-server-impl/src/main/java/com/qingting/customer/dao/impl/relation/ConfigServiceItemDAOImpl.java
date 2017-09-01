package com.qingting.customer.dao.impl.relation;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.alipay.simplehbase.client.rowkey.BytesRowKey;
import com.alipay.simplehbase.client.rowkey.StringRowKey;
import com.alipay.simplehbase.sequence.RedisSerialNum;
import com.qingting.customer.model.hbasedo.relation.ConfigServiceItem;
import com.qingting.customer.model.util.RowKeyUtil;
import com.qingting.customer.dao.relation.ConfigServiceItemDAO;
import com.qingting.customer.dao.util.SHCUtil;
import com.qingting.customer.hbase.doandkey.SimpleHbaseDOWithKeyResult;
import com.qingting.customer.hbase.rowkey.RowKey;

@Repository("configServiceItemDAO")
public class ConfigServiceItemDAOImpl implements ConfigServiceItemDAO {
	
	@Autowired
	public RedisTemplate<String, Integer> redisTemplate;
	
	@Override
	public ConfigServiceItem get(String rk) {
		SimpleHbaseDOWithKeyResult<ConfigServiceItem> result = SHCUtil.getSHC("configServiceItem").findObjectAndKey(new StringRowKey(rk), ConfigServiceItem.class);
		ConfigServiceItem configServiceItem=result.getT();
		configServiceItem.setContentOfRowKey(result.getRowKey().toBytes());
		return configServiceItem;
	}

	@Override
	public void insert(ConfigServiceItem t) {
		int num=RedisSerialNum.getSerialNum(redisTemplate, "configServiceItem_id_seq");
		RowKey rowKey = new BytesRowKey(RowKeyUtil.getBytes(num));
		SHCUtil.getSHC("configServiceItem").insertObject(rowKey, t);
	}

	@Override
	public void update(ConfigServiceItem t) {
		SHCUtil.getSHC("configServiceItem").updateObjectWithVersion(new StringRowKey(t.getRowKey()), t, t.getVersion());
	}

	@Override
	public void deleteById(Collection<String> rkList) {
		for (String string : rkList) {
			SHCUtil.getSHC("configServiceItem").delete(new StringRowKey(string));
		}
	}

}
