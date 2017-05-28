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
import com.qingting.customer.common.pojo.hbasedo.ServiceDetail;
import com.qingting.customer.common.pojo.util.RowKeyUtil;
import com.qingting.customer.dao.ServiceDetailDAO;
import com.qingting.customer.hbase.doandkey.SimpleHbaseDOWithKeyResult;
import com.qingting.customer.hbase.rowkey.RowKey;
@Repository("serviceDetailDAO")
public class ServiceDetailDAOImpl implements ServiceDetailDAO {
	@Autowired
	public RedisTemplate<String, Integer> redisTemplate;
	@Override
	public void insertServiceDetail(ServiceDetail serviceDetail) {
		int num=RedisSerialNum.getSerialNum(redisTemplate, "serviceDetail_id_seq");
		RowKey rowKey = new BytesRowKey(RowKeyUtil.getBytes(num));
		SHCUtil.getSHC("serviceDetail").insertObject(rowKey, serviceDetail);
	}

	@Override
	public void deleteServiceDetailByRowKey(String rowKey) {
		SHCUtil.getSHC("serviceDetail").delete(new StringRowKey(rowKey));
	}

	@Override
	public void updateServiceDetailByRowKey(ServiceDetail serviceDetail) {
		SHCUtil.getSHC("serviceDetail").updateObjectWithVersion(new StringRowKey(serviceDetail.getRowKey()), serviceDetail, serviceDetail.getVersion());
	}

	@Override
	public ServiceDetail getServiceDetailByRowKey(String rowKey) {
		SimpleHbaseDOWithKeyResult<ServiceDetail> result = SHCUtil.getSHC("serviceDetail").findObjectAndKey(new StringRowKey(rowKey), ServiceDetail.class);
		ServiceDetail serviceDetail=result.getT();
		serviceDetail.setContentOfRowKey(result.getRowKey().toBytes());
		return serviceDetail;
	}

	@Override
	public List<ServiceDetail> listServiceDetail() {
		RowKey startRowKey=new BytesRowKey(RowKeyUtil.getBytes(0));
		RowKey endRowKey=new BytesRowKey(RowKeyUtil.getBytes(Integer.MAX_VALUE));
		List<SimpleHbaseDOWithKeyResult<ServiceDetail>> listDOWithKey = SHCUtil.getSHC("serviceDetail").findObjectAndKeyList(startRowKey,endRowKey, ServiceDetail.class);
		List<ServiceDetail> list=new ArrayList<ServiceDetail>();
		for (SimpleHbaseDOWithKeyResult<ServiceDetail> result : listDOWithKey) {
			ServiceDetail serviceDetail = result.getT();
			serviceDetail.setContentOfRowKey(result.getRowKey().toBytes());
			list.add(serviceDetail);
		}
		return list;
	}

}
