package com.qingting.customer.dao;

import java.util.Calendar;
import java.util.List;

import com.qingting.customer.common.pojo.hbasedo.Project;
import com.qingting.customer.hbase.doandkey.SimpleHbaseDOWithKeyResult;

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
	 * @Title: insertProjectByUserId
	 * @Description: 插入一条项目数据通过userId
	 * @param project
	 * @param userId 
	 * @return void
	 * @throws
	 */
	void insertProjectByUserId(Project project,Integer userId);
	/**
	 * 
	 * @Title: deleteProjectByUserIdAndCalendar
	 * @Description: 删除一条项目数据通过userId和Calendar
	 * @param userId
	 * @param calendar 
	 * @return void
	 * @throws
	 */
	void deleteProjectByUserIdAndCalendar(Integer userId,Calendar calendar);
	/**
	 * 
	 * @Title: updateProjectByUserIdAndCalendar
	 * @Description: 更新一条项目数据通过userId和Calendar
	 * @param project
	 * @param userId
	 * @param calendar
	 * @return void
	 * @throws
	 */
	void updateProjectByUserIdAndCalendar(Project project,Integer userId,Calendar calendar);
	/**
	 * 
	 * @Title: listProjectByUserId
	 * @Description: 查询所有项目通过userId
	 * @param userId
	 * @return 
	 * @return List<SimpleHbaseDOWithKeyResult<Project>>
	 * @throws
	 */
	List<SimpleHbaseDOWithKeyResult<Project>> listProjectByUserId(Integer userId);
}
