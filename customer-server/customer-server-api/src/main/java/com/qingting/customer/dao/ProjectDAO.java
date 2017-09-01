package com.qingting.customer.dao;

import java.util.List;

import com.qingting.customer.common.pojo.hbasedo.Project;

/**
 * 
 * @ClassName: ProjectDAO
 * @Description: 项目数据库访问接口CRUD
 * @author zlf
 * @date 2017年4月24日 下午5:53:48
 *
 */
public interface ProjectDAO {
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
	 * @Title: getProjectByRowkey
	 * @Description: 查询某个项目
	 * @param rowKey
	 * @return Project
	 * @throws
	 */
	Project getProjectByRowkey(String rowKey);
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
