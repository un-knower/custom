package com.qingting.customer.dao.impl.relation;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.alipay.simplehbase.client.rowkey.BytesRowKey;
import com.alipay.simplehbase.client.rowkey.StringRowKey;
import com.alipay.simplehbase.sequence.RedisSerialNum;
import com.qingting.customer.model.hbasedo.relation.EmployeeEquip;
import com.qingting.customer.model.util.RowKeyUtil;
import com.qingting.customer.dao.relation.EmployeeEquipDAO;
import com.qingting.customer.dao.util.SHCUtil;
import com.qingting.customer.hbase.doandkey.SimpleHbaseDOWithKeyResult;
import com.qingting.customer.hbase.rowkey.RowKey;
@Repository("employeeEquipDAO")
public class EmployeeEquipImpl implements EmployeeEquipDAO {

	@Autowired
	public RedisTemplate<String, Integer> redisTemplate;
	
	@Override
	public EmployeeEquip get(String rk) {
		SimpleHbaseDOWithKeyResult<EmployeeEquip> result = SHCUtil.getSHC("employeeEquip").findObjectAndKey(new StringRowKey(rk), EmployeeEquip.class);
		EmployeeEquip employeeEquip=result.getT();
		employeeEquip.setContentOfRowKey(result.getRowKey().toBytes());
		return employeeEquip;
	}

	@Override
	public void insert(EmployeeEquip t) {
		int num=RedisSerialNum.getSerialNum(redisTemplate, "employeeEquip_id_seq");
		RowKey rowKey = new BytesRowKey(RowKeyUtil.getBytes(num));
		SHCUtil.getSHC("employeeEquip").insertObject(rowKey, t);
	}

	@Override
	public void update(EmployeeEquip t) {
		SHCUtil.getSHC("employeeEquip").updateObjectWithVersion(new StringRowKey(t.getRowKey()), t, t.getVersion());
	}

	@Override
	public void deleteById(Collection<String> rkList) {
		for (String string : rkList) {
			SHCUtil.getSHC("employeeEquip").delete(new StringRowKey(string));
		}
	}

}
