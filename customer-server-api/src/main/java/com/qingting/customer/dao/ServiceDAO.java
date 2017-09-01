package com.qingting.customer.dao;

import java.util.List;

import com.qingting.customer.model.hbasedo.Service;

public interface ServiceDAO{
	/**
	 * 
	 * @Title: insertService
	 * @Description: 插入一条服务信息
	 * @param service 
	 * @return void
	 * @throws
	 */
	void insertService(Service service);
	/**
	 * 
	 * @Title: deleteServiceByRowKey
	 * @Description: 删除一条服务信息
	 * @param rowKey 
	 * @return void
	 * @throws
	 */
	void deleteServiceByRowKey(String rowKey);
	/**
	 * 
	 * @Title: updateServiceByRowKey
	 * @Description: 修改一条服务信息
	 * @param service 
	 * @return void
	 * @throws
	 */
	void updateServiceByRowKey(Service service);
	/**
	 * 
	 * @Title: getServiceByRowKey
	 * @Description: 获得一条服务信息通过rowKey
	 * @param rowKey
	 * @return 
	 * @return Service
	 * @throws
	 */
	Service getServiceByRowKey(String rowKey);
	/**
	 * 
	 * @Title: listServiceByEquipId
	 * @Description: 获得对应设备的所有服务信息
	 * @param equipId
	 * @return 
	 * @return List<Service>
	 * @throws
	 */
	List<Service> listServiceByEquipId(String equipId);
}