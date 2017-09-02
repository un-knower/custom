package com.qingting.customer.dao;

import java.util.List;

import com.qingting.customer.model.ComParam;

public interface ComParamDAO {
	/**
	 * 
	 * @Title: insertComParam
	 * @Description: 插入一条通用参数
	 * @param comParam
	 * @return void
	 * @throws
	 */
	void insertComParam(ComParam comParam);
	/**
	 * 
	 * @Title: deleteComParamByRowKey
	 * @Description: 删除一条通用参数通过rowKey
	 * @param rowKey 
	 * @return void
	 * @throws
	 */
	void deleteComParamByRowKey(String rowKey);
	/**
	 * 
	 * @Title: updateComParamByRowKey
	 * @Description: 更新一条通用参数通过rowKey
	 * @param comParam 
	 * @return void
	 * @throws
	 */
	void updateComParamByRowKey(ComParam comParam);
	/**
	 * 
	 * @Title: getComParamByEnable
	 * @Description: 获得激活的通用参数
	 * @return ComParam
	 * @throws
	 */
	ComParam getComParamOfEnable();
	/**
	 * 
	 * @Title: listComParam
	 * @Description: 获得所有的通用参数(包括激活和未激活的)
	 * @return List<ComParam>
	 * @throws
	 */
	List<ComParam> listComParam();
}
