package com.qingting.customer.baseserver;

import java.util.List;

import com.qingting.customer.common.pojo.hbasedo.Project;

public interface ProjectService {
	/**
	 * 
	 * @Title: insertProject
	 * @Description: 插入一条项目数据
	 * @param project
	 * @return void
	 * @throws
	 */
	void insertProject(Project project);
	/**
	 * 
	 * @Title: deleteProjectByRowKey
	 * @Description: 删除一条项目数据通过rowKey
	 * @param rowKey
	 * @return void
	 * @throws
	 */
	void deleteProjectByRowKey(String rowKey);
	/**
	 * 
	 * @Title: updateProjectByRowKey
	 * @Description: 更新一条项目数据通过rowkey
	 * @param project
	 * @return void
	 * @throws
	 */
	void updateProjectByRowKey(Project project);
	/**
	 * 
	 * @Title: listProjectByUserId
	 * @Description: 查询用户的所有项目
	 * @param userId
	 * @return 
	 * @return List<Project>
	 * @throws
	 */
	List<Project> listProjectByUserId(Integer userId);
}
