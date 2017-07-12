package com.qingting.customer.dao.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.alipay.simplehbase.client.rowkey.BytesRowKey;
import com.alipay.simplehbase.client.rowkey.StringRowKey;
import com.alipay.simplehbase.sequence.RedisSerialNum;
import com.qingting.customer.common.pojo.hbasedo.Project;
import com.qingting.customer.common.pojo.util.DateUtil;
import com.qingting.customer.common.pojo.util.RowKeyUtil;
import com.qingting.customer.dao.ProjectDAO;
import com.qingting.customer.dao.util.SHCUtil;
import com.qingting.customer.hbase.doandkey.SimpleHbaseDOWithKeyResult;
import com.qingting.customer.hbase.rowkey.RowKey;


@Repository("projectDAO")
public class ProjectDAOImpl implements ProjectDAO {
	@Autowired
	public RedisTemplate<String, Integer> redisTemplate;
	@Override
	public void insertProject(Project project) {
		int num=RedisSerialNum.getSerialNum(redisTemplate, "project_id_seq");
		RowKey rowKey = new BytesRowKey(RowKeyUtil.getBytes(project.getUserId(), project.getComboId(),DateUtil.getMillisOfStart(),num));
		SHCUtil.getSHC("project").insertObject(rowKey, project);
	}

	@Override
	public void deleteProjectByRowKey(String rowKey) {
		SHCUtil.getSHC("project").delete(new StringRowKey(rowKey));
	}

	@Override
	public void updateProjectByRowKey(Project project) {
		SHCUtil.getSHC("project").updateObjectWithVersion(new StringRowKey(project.getRowKey()), project, project.getVersion());
		                           
	}
	
	@Override
	public List<Project> listProjectByUserId(Integer userId) {
		RowKey startRowKey=new BytesRowKey(RowKeyUtil.getBytes(userId, DateUtil.getStartOfMillis()));
		RowKey endRowKey=new BytesRowKey(RowKeyUtil.getBytes(userId, DateUtil.getMillisOfStart()));
		List<SimpleHbaseDOWithKeyResult<Project>> listDOWithKey = SHCUtil.getSHC("project").findObjectAndKeyList(startRowKey,endRowKey, Project.class);
		List<Project> list=new ArrayList<Project>();
		for (SimpleHbaseDOWithKeyResult<Project> result : listDOWithKey) {
			Project project = result.getT();
			project.setContentOfRowKey(result.getRowKey().toBytes());
			list.add(project);
		}
		return list;
	}

	@Override
	public Project getProjectByRowkey(String rowKey) {
		SimpleHbaseDOWithKeyResult<Project> result = SHCUtil.getSHC("project").findObjectAndKey(new StringRowKey(rowKey), Project.class);
		Project project=result.getT();
		project.setContentOfRowKey(result.getRowKey().toBytes());
		return project;
	}
}
