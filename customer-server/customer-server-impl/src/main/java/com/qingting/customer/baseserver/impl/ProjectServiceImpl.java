package com.qingting.customer.baseserver.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qingting.customer.baseserver.ProjectService;
import com.qingting.customer.common.pojo.hbasedo.Project;
import com.qingting.customer.dao.ProjectDAO;

@Service("projectService")
public class ProjectServiceImpl implements ProjectService {
	@Resource
	ProjectDAO projectDAO;

	@Override
	public void insertProject(Project project) {
		projectDAO.insertProject(project);
	}

	@Override
	public void deleteProjectByRowKey(String rowKey) {
		projectDAO.deleteProjectByRowKey(rowKey);
	}

	@Override
	public void updateProjectByRowKey(Project project) {
		projectDAO.updateProjectByRowKey(project);
	}

	@Override
	public List<Project> listProjectByUserId(Integer userId) {
		return projectDAO.listProjectByUserId(userId);
	}
	
}
