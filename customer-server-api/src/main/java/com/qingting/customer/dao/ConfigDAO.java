package com.qingting.customer.dao;

import java.util.List;

import com.qingting.customer.model.hbasedo.Config;

public interface ConfigDAO {
	/**
	 * 
	 * @Title: insertConfig
	 * @Description: 插入一条套餐配置
	 * @param config 
	 * @return void
	 * @throws
	 */
	void insertConfig(Config config);
	/**
	 * 
	 * @Title: deleteConfigByRowKey
	 * @Description: 删除一条套餐配置
	 * @param rowKey 
	 * @return void
	 * @throws
	 */
	void deleteConfigByRowKey(String rowKey);
	/**
	 * 
	 * @Title: updateConfigByRowKey
	 * @Description: 修改该一条套餐配置
	 * @param config 
	 * @return void
	 * @throws
	 */
	void updateConfigByRowKey(Config config);
	/**
	 * 
	 * @Title: getConfigByRowKey
	 * @Description: 获得一条套餐配置
	 * @param rowKey
	 * @return 
	 * @return Config
	 * @throws
	 */
	Config getConfigByRowKey(String rowKey);
	/**
	 * 
	 * @Title: listConfig
	 * @Description: 获得所有套餐配置
	 * @return 
	 * @return List<Config>
	 * @throws
	 */
	List<Config> listConfig();
}
