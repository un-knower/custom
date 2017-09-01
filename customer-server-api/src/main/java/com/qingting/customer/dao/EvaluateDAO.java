package com.qingting.customer.dao;

import java.util.List;

import com.qingting.customer.model.hbasedo.Evaluate;

public interface EvaluateDAO{
	/**
	 * 
	 * @Title: insertEvaluate
	 * @Description: 插入评价信息
	 * @param evaluate 
	 * @return void
	 * @throws
	 */
	void insertEvaluate(Evaluate evaluate);
	/**
	 * 
	 * @Title: deleteEvaluateByRowKey
	 * @Description: 删除评价信息
	 * @param rowKey 
	 * @return void
	 * @throws
	 */
	void deleteEvaluateByRowKey(String rowKey);
	/**
	 * 
	 * @Title: updateEvaluateByRowKey
	 * @Description: 修改评价信息通过rowKey
	 * @param evaluate 
	 * @return void
	 * @throws
	 */
	void updateEvaluateByRowKey(Evaluate evaluate);
	/**
	 * 
	 * @Title: getEvaluateByRowKey
	 * @Description: 获得评价信息通过rowKey
	 * @param rowKey
	 * @return 
	 * @return Evaluate
	 * @throws
	 */
	Evaluate getEvaluateByRowKey(String rowKey);
	/**
	 * 
	 * @Title: listEvaluateByEquipId
	 * @Description: 获得对应设备的所有评价信息
	 * @param equipId
	 * @return 
	 * @return List<Evaluate>
	 * @throws
	 */
	List<Evaluate> listEvaluateByEquipId(Integer equipId);
	/**
	 * 
	 * @Title: listEvaluate
	 * @Description: 获得所有评价信息
	 * @return 
	 * @return List<Evaluate>
	 * @throws
	 */
	List<Evaluate> listEvaluate();
}