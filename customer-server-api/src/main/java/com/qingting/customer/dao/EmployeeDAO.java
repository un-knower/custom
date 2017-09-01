package com.qingting.customer.dao;

import java.util.List;

import com.qingting.customer.model.hbasedo.Employee;

public interface EmployeeDAO{
	/**
	 * 
	 * @Title: insertEmployee
	 * @Description: 插入员工信息
	 * @param employee 
	 * @return void
	 * @throws
	 */
	void insertEmployee(Employee employee);
	/**
	 * 
	 * @Title: deleteEmployeeByRowKey
	 * @Description: 删除员工信息通过rowKey
	 * @param rowKey 
	 * @return void
	 * @throws
	 */
	void deleteEmployeeByRowKey(String rowKey);
	/**
	 * 
	 * @Title: updateEmployeeByRowKey
	 * @Description: 修改员工信息通过rowKey
	 * @param employee 
	 * @return void
	 * @throws
	 */
	void updateEmployeeByRowKey(Employee employee);
	/**
	 * 
	 * @Title: getEmployeeByRowKey
	 * @Description: 获得员工信息通过rowKey
	 * @param rowKey
	 * @return 
	 * @return Employee
	 * @throws
	 */
	Employee getEmployeeByRowKey(String rowKey);
	/**
	 * 
	 * @Title: listEmployee
	 * @Description: 获得所有员工信息
	 * @return 
	 * @return List<Employee>
	 * @throws
	 */
	List<Employee> listEmployee();
}