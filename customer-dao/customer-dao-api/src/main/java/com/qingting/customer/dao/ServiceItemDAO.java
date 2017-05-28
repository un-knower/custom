package com.qingting.customer.dao;

import java.util.List;

import com.qingting.customer.common.pojo.hbasedo.ServiceItem;

public interface ServiceItemDAO {
	/**
	 * 
	 * @Title: insertServiceItem
	 * @Description: 插入一条服务项
	 * @param serviceItem 
	 * @return void
	 * @throws
	 */
	void insertServiceItem(ServiceItem serviceItem);
	/**
	 * 
	 * @Title: deleteServiceItemByRowKey
	 * @Description: 删除一条服务项通过rowkey
	 * @param rowKey 
	 * @return void
	 * @throws
	 */
	void deleteServiceItemByRowKey(String rowKey);
	/**
	 * 
	 * @Title: updateServiceItemByRowKey
	 * @Description: 修改一条服务项通过rowKey
	 * @param serviceItem 
	 * @return void
	 * @throws
	 */
	void updateServiceItemByRowKey(ServiceItem serviceItem);
	/**
	 * 
	 * @Title: getServiceItemByRowKey
	 * @Description: 获得一条服务项
	 * @param rowKey
	 * @return 
	 * @return ServiceItem
	 * @throws
	 */
	ServiceItem getServiceItemByRowKey(String rowKey);
	/**
	 * 
	 * @Title: listServiceItem
	 * @Description: 获得所有服务项
	 * @return 
	 * @return List<ServiceItem>
	 * @throws
	 */
	List<ServiceItem> listServiceItem();
}
