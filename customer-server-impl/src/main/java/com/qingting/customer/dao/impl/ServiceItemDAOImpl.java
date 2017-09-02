package com.qingting.customer.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.alipay.simplehbase.client.rowkey.BytesRowKey;
import com.alipay.simplehbase.client.rowkey.RowKeyUtil;
import com.alipay.simplehbase.client.rowkey.StringRowKey;
import com.alipay.simplehbase.sequence.RedisSerialNum;
import com.qingting.customer.dao.ServiceItemDAO;
import com.qingting.customer.dao.util.SHCUtil;
import com.qingting.customer.hbase.doandkey.SimpleHbaseDOWithKeyResult;
import com.qingting.customer.hbase.rowkey.RowKey;
import com.qingting.customer.model.ServiceItem;
@Repository("serviceItemDAO")
public class ServiceItemDAOImpl implements ServiceItemDAO {
	@Autowired
	public RedisTemplate<String, Integer> redisTemplate;
	@Override
	public void insertServiceItem(ServiceItem serviceItem) {
		int num=RedisSerialNum.getSerialNum(redisTemplate, "serviceItem_id_seq");
		RowKey rowKey = RowKeyUtil.getRowKey(num);
		SHCUtil.getSHC("serviceItem").insertObject(rowKey, serviceItem);
	}

	@Override
	public void deleteServiceItemByRowKey(String rowKey) {
		SHCUtil.getSHC("serviceItem").delete(new StringRowKey(rowKey));

	}

	@Override
	public void updateServiceItemByRowKey(ServiceItem serviceItem) {
		SHCUtil.getSHC("serviceItem").updateObjectWithVersion(new StringRowKey(serviceItem.getRowKey()), serviceItem, serviceItem.getVersion());
	}

	@Override
	public ServiceItem getServiceItemByRowKey(String rowKey) {
		SimpleHbaseDOWithKeyResult<ServiceItem> result = SHCUtil.getSHC("serviceItem").findObjectAndKey(new StringRowKey(rowKey), ServiceItem.class);
		ServiceItem serviceItem=result.getT();
		//serviceItem.setContentOfRowKey(result.getRowKey().toBytes());
		return serviceItem;
	}

	@Override
	public List<ServiceItem> listServiceItem() {
		RowKey startRowKey=RowKeyUtil.getRowKey(0);
		RowKey endRowKey=RowKeyUtil.getRowKey(Integer.MAX_VALUE);
		List<SimpleHbaseDOWithKeyResult<ServiceItem>> listDOWithKey = SHCUtil.getSHC("serviceItem").findObjectAndKeyList(startRowKey,endRowKey, ServiceItem.class);
		List<ServiceItem> list=new ArrayList<ServiceItem>();
		for (SimpleHbaseDOWithKeyResult<ServiceItem> result : listDOWithKey) {
			ServiceItem serviceItem = result.getT();
			//serviceItem.setContentOfRowKey(result.getRowKey().toBytes());
			list.add(serviceItem);
		}
		return list;
	}

}
