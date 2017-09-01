package com.qingting.customer.dao;

import java.util.List;

import com.qingting.customer.model.hbasedo.EmployeeSort;

public interface EmployeeSortDAO{
	/**
	 * 
	 * @Title: insertEmployeeSort
	 * @Description: 插入员工分类信息
	 * @param employeeSort 
	 * @return void
	 * @throws
	 */
	void insertEmployeeSort(EmployeeSort employeeSort);
	/**
	 * 
	 * @Title: deleteEmployeeSortByRowKey
	 * @Description: 删除员工分类信息通过rowKey
	 * @param rowKey 
	 * @return void
	 * @throws
	 */
	void deleteEmployeeSortByRowKey(String rowKey);
	/**
	 * 
	 * @Title: updateEmployeeSortByRowKey
	 * @Description: 修改员工分类信息通过rowKey
	 * @param employeeSort 
	 * @return void
	 * @throws
	 */
	void updateEmployeeSortByRowKey(EmployeeSort employeeSort);
	/**
	 * 
	 * @Title: getEmployeeSortByRowKey
	 * @Description: 获得员工分类信息通过rowKey
	 * @param rowKey
	 * @return 
	 * @return EmployeeSort
	 * @throws
	 */
	EmployeeSort getEmployeeSortByRowKey(String rowKey);
	/**
	 * 
	 * @Title: listEmployeeSort
	 * @Description: 获得所有员工分类信息
	 * @return 
	 * @return List<EmployeeSort>
	 * @throws
	 */
	List<EmployeeSort> listEmployeeSort();
}