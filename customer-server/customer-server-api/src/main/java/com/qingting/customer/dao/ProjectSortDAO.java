package com.qingting.customer.dao;

import java.util.List;

import com.qingting.customer.common.pojo.hbasedo.ProjectSort;

public interface ProjectSortDAO {
	/**
	 * 
	 * @Title: insertProjectSort
	 * @Description: 插入项目分类
	 * @param projectSort 
	 * @return void
	 * @throws
	 */
	void insertProjectSort(ProjectSort projectSort);
	/**
	 * 
	 * @Title: deleteProjectSortByRowKey
	 * @Description: 删除项目分类通过rowKey
	 * @param rowKey 
	 * @return void
	 * @throws
	 */
	void deleteProjectSortByRowKey(String rowKey);
	/**
	 * 
	 * @Title: updateProjectSortByRowKey
	 * @Description: 修改项目分类通过rowKey
	 * @param projectSort 
	 * @return void
	 * @throws
	 */
	void updateProjectSortByRowKey(ProjectSort projectSort);
	/**
	 * 
	 * @Title: getProjectSortByRowKey
	 * @Description: 获得项目分类信息通过rowKey
	 * @param rowKey
	 * @return 
	 * @return ProjectSort
	 * @throws
	 */
	ProjectSort getProjectSortByRowKey(String rowKey);
	/**
	 * 
	 * @Title: listProjectSort
	 * @Description: 获得所有项目分类信息
	 * @return 
	 * @return List<ProjectSort>
	 * @throws
	 */
	List<ProjectSort> listProjectSort();
}
