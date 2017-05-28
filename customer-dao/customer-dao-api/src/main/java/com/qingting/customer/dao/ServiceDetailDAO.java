package com.qingting.customer.dao;

import java.util.List;

import com.qingting.customer.common.pojo.hbasedo.ServiceDetail;

public interface ServiceDetailDAO {
	/**
	 * 
	 * @Title: insertServiceDetail
	 * @Description: 插入一套服务内容
	 * @param serviceDetail 
	 * @return void
	 * @throws
	 */
	void insertServiceDetail(ServiceDetail serviceDetail);
	/**
	 * 
	 * @Title: deleteServiceDetailByRowKey
	 * @Description: 删除一条服务内容
	 * @param rowKey 
	 * @return void
	 * @throws
	 */
	void deleteServiceDetailByRowKey(String rowKey);
	/**
	 * 
	 * @Title: updateServiceDetailByRowKey
	 * @Description: 修改一条服务内容
	 * @param serviceDetail 
	 * @return void
	 * @throws
	 */
	void updateServiceDetailByRowKey(ServiceDetail serviceDetail);
	/**
	 * 
	 * @Title: getServiceDetailByRowKey
	 * @Description: 获得一条服务内容
	 * @param rowKey
	 * @return 
	 * @return ServiceDetail
	 * @throws
	 */
	ServiceDetail getServiceDetailByRowKey(String rowKey);
	/**
	 * 
	 * @Title: listServiceDetail
	 * @Description: 获得所有服务内容
	 * @return 
	 * @return List<ServiceDetail>
	 * @throws
	 */
	List<ServiceDetail> listServiceDetail();
}	
