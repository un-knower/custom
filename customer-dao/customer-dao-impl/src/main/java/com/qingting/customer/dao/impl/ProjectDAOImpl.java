package com.qingting.customer.dao.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.alipay.simplehbase.util.SHCUtil;
import com.qingting.customer.common.pojo.hbasedo.Project;
import com.qingting.customer.common.pojo.rowkey.ProjectRowKey;
import com.qingting.customer.common.pojo.util.DateUtil;
import com.qingting.customer.dao.ProjectDAO;
import com.qingting.customer.hbase.doandkey.SimpleHbaseDOWithKeyResult;
@Repository("projectDAO")
public class ProjectDAOImpl implements ProjectDAO {

	@Override
	public void insertProjectByUserId(Project project, Integer userId) {
		SHCUtil.getSHC("project").insertObject(new ProjectRowKey(userId), project);
	}
	
	@Override
	public void deleteProjectByUserIdAndCalendar(Integer userId, Calendar calendar) {
		SHCUtil.getSHC("project").delete(new ProjectRowKey(userId,calendar));
	}

	@Override
	public void updateProjectByUserIdAndCalendar(Project project,Integer userId, Calendar calendar) {
		SHCUtil.getSHC("project").updateObjectWithVersion(new ProjectRowKey(userId,calendar), project, project.getVersion());
	}

	@Override
	public List<SimpleHbaseDOWithKeyResult<Project>> listProjectByUserId(Integer userId) {
		//return SHCUtil.getSHC("project").findObjectList(new ProjectRowKey(userId,DateUtil.getStart()),new ProjectRowKey(userId,Calendar.getInstance()), Project.class);
		return SHCUtil.getSHC("project").findObjectAndKeyList(new ProjectRowKey(userId,DateUtil.getStart()),new ProjectRowKey(userId,Calendar.getInstance()), Project.class);
	}

	

}
