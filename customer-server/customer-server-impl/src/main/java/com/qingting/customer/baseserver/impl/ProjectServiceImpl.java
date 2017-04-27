package com.qingting.customer.baseserver.impl;

import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qingting.customer.baseserver.ProjectService;
import com.qingting.customer.common.pojo.hbasedo.Project;
import com.qingting.customer.dao.ProjectDAO;
import com.qingting.customer.hbase.doandkey.SimpleHbaseDOWithKeyResult;

@Service("projectService")
public class ProjectServiceImpl implements ProjectService {
	@Resource
	ProjectDAO projectDAO;
	@Override
	public void insertProjectByUserId(Project project, Integer userId) {
		 projectDAO.insertProjectByUserId(project, userId);
	}

	@Override
	public void deleteProjectByUserIdAndCalendar(Integer userId, Calendar calendar) {
		projectDAO.deleteProjectByUserIdAndCalendar(userId, calendar);
	}

	@Override
	public void updateProjectByUserIdAndCalendar(Project project, Integer userId, Calendar calendar) {
		projectDAO.updateProjectByUserIdAndCalendar(project, userId, calendar);
	}

	@Override
	public List<SimpleHbaseDOWithKeyResult<Project>> listProjectByUserId(Integer userId) {
		return projectDAO.listProjectByUserId(userId);
	}

}
