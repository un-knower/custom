package com.qingting.customer.dao;

import java.util.List;

import com.qingting.customer.common.pojo.hbasedo.Formula;

public interface FormulaDAO {
	/**
	 * 
	 * @Title: insertFormula
	 * @Description: 插入一个公式
	 * @param formula 
	 * @return void
	 * @throws
	 */
	void insertFormula(Formula formula);
	/**
	 * 
	 * @Title: deleteFormulaByRowKey
	 * @Description: 删除一个公式通过rowKey
	 * @param rowKey 
	 * @return void
	 * @throws
	 */
	void deleteFormulaByRowKey(String rowKey);
	/**
	 * 
	 * @Title: updateFormulaById
	 * @Description: 修改该一个公式通过id
	 * @param formula 
	 * @return void
	 * @throws
	 */
	void updateFormulaByRowKey(Formula formula);
	/**
	 * 
	 * @Title: getFormulaByRowKey
	 * @Description: 查询公式通过RowKey
	 * @param rowKey
	 * @return 
	 * @return Formula
	 * @throws
	 */
	Formula getFormulaByRowKey(String rowKey);
	/**
	 * 
	 * @Title: listFormula
	 * @Description: 查询所有公式
	 * @return 
	 * @return List<Formula>
	 * @throws
	 */
	List<Formula> listFormula();
}
