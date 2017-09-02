package com.qingting.customer.server.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qingting.customer.dao.ProjectSortDAO;
import com.qingting.customer.model.ProjectSort;
import com.qingting.customer.server.ProjectSortService;

@Service("projectSortService")
public class ProjectSortServiceImpl implements ProjectSortService {
	@Resource
	ProjectSortDAO projectSortDAO;
	@Override
	public void insertProjectSort(ProjectSort projectSort) {
		projectSortDAO.insertProjectSort(projectSort);
	}

	@Override
	public void deleteProjectSortByRowKey(String rowKey) {
		projectSortDAO.deleteProjectSortByRowKey(rowKey);
	}

	@Override
	public void updateProjectSortByRowKey(ProjectSort projectSort) {
		projectSortDAO.updateProjectSortByRowKey(projectSort);
	}

	@Override
	public ProjectSort getProjectSortByRowKey(String rowKey) {
		return projectSortDAO.getProjectSortByRowKey(rowKey);
	}

	@Override
	public List<ProjectSort> listProjectSort() {
		return projectSortDAO.listProjectSort();
	}

}
