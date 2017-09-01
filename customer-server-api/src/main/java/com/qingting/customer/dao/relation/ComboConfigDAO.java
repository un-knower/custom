package com.qingting.customer.dao.relation;

import java.util.List;

import com.qingting.customer.model.hbasedo.relation.ComboConfig;

public interface ComboConfigDAO {
	/**
	 * 
	 * @Title: insertComboConfig
	 * @Description: 插入一条套餐配置关系信息
	 * @param comboConfig 
	 * @return void
	 * @throws
	 */
	void insertComboConfig(ComboConfig comboConfig);
	/**
	 * 
	 * @Title: deleteComboConfigByRowKey
	 * @Description: 删除一条套餐配置关系信息
	 * @param rowKey 
	 * @return void
	 * @throws
	 */
	void deleteComboConfigByRowKey(String rowKey);
	/**
	 * 
	 * @Title: updateComboConfigByRowKey
	 * @Description: 修改一条套餐配置关系信息
	 * @param comboConfig 
	 * @return void
	 * @throws
	 */
	void updateComboConfigByRowKey(ComboConfig comboConfig);
	/**
	 * 
	 * @Title: getComboConfigByRowKey
	 * @Description: 获得一条套餐配置关系信息
	 * @param rowKey
	 * @return 
	 * @return ComboConfig
	 * @throws
	 */
	ComboConfig getComboConfigByRowKey(String rowKey);
	/**
	 * 
	 * @Title: listComboConfig
	 * @Description: 获得所有套餐配置关系信息
	 * @return 
	 * @return List<ComboConfig>
	 * @throws
	 */
	List<ComboConfig> listComboConfig();
}

