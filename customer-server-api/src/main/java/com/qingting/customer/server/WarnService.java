package com.qingting.customer.server;

import java.util.List;

import com.qingting.customer.model.Warn;

public interface WarnService {
	/**
	 * 
	 * @Title: insertWarn
	 * @Description: 插入预警信息
	 * @param warn 
	 * @return void
	 * @throws
	 */
	void insertWarn(Warn warn);
	/**
	 * 
	 * @Title: deleteWarnByRowKey
	 * @Description: 删除预警信息通过rowKey
	 * @param rowKey 
	 * @return void
	 * @throws
	 */
	void deleteWarnByRowKey(String rowKey);
	/**
	 * 
	 * @Title: updateWarnByRowKey
	 * @Description: 修改预警信息通过rowKey
	 * @param warn 
	 * @return void
	 * @throws
	 */
	void updateWarnByRowKey(Warn warn);
	/**
	 * 
	 * @Title: getWarnById
	 * @Description: 查询预警信息通过rowKey
	 * @param rowKey
	 * @return Warn
	 * @throws
	 */
	Warn getWarnById(String rowKey);
	/**
	 * 
	 * @Title: listWarn
	 * @Description: 查询设备的所有预警信息通过equipId
	 * @param equipId
	 * @return List<Warn>
	 * @throws
	 */
	List<Warn> listWarn(String equipId);
}
