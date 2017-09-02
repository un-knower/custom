package com.qingting.customer.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.alipay.simplehbase.client.rowkey.BytesRowKey;
import com.alipay.simplehbase.client.rowkey.RowKeyUtil;
import com.alipay.simplehbase.client.rowkey.StringRowKey;
import com.smart.mvc.util.DateUtil;
import com.qingting.customer.dao.ProjectSortDAO;
import com.qingting.customer.dao.util.SHCUtil;
import com.qingting.customer.hbase.doandkey.SimpleHbaseDOWithKeyResult;
import com.qingting.customer.hbase.rowkey.RowKey;
import com.qingting.customer.model.ProjectSort;
@Repository("projectSortDAO")
public class ProjectSortDAOImpl implements ProjectSortDAO {

	@Override
	public void insertProjectSort(ProjectSort projectSort) {
		RowKey rowKey = RowKeyUtil.getRowKey(DateUtil.getMillisOfStart());
		SHCUtil.getSHC("projectSort").insertObject(rowKey, projectSort);
	}

	@Override
	public void deleteProjectSortByRowKey(String rowKey) {
		SHCUtil.getSHC("projectSort").delete(new StringRowKey(rowKey));
	}

	@Override
	public void updateProjectSortByRowKey(ProjectSort projectSort) {
		SHCUtil.getSHC("projectSort").updateObjectWithVersion(new StringRowKey(projectSort.getRowKey()), projectSort, projectSort.getVersion());
	}

	@Override
	public ProjectSort getProjectSortByRowKey(String rowKey) {
		SimpleHbaseDOWithKeyResult<ProjectSort> result = SHCUtil.getSHC("projectSort").findObjectAndKey(new StringRowKey(rowKey), ProjectSort.class);
		ProjectSort projectSort=result.getT();
		projectSort.setContentOfRowKey(result.getRowKey().toBytes());
		return projectSort;
	}

	@Override
	public List<ProjectSort> listProjectSort() {
		RowKey startRowKey=RowKeyUtil.getRowKey(DateUtil.getStartOfMillis());
		RowKey endRowKey=RowKeyUtil.getRowKey(DateUtil.getMillisOfStart());
		List<SimpleHbaseDOWithKeyResult<ProjectSort>> listDOWithKey = SHCUtil.getSHC("projectSort").findObjectAndKeyList(startRowKey,endRowKey, ProjectSort.class);
		List<ProjectSort> list=new ArrayList<ProjectSort>();
		for (SimpleHbaseDOWithKeyResult<ProjectSort> result : listDOWithKey) {
			ProjectSort projectSort = result.getT();
			projectSort.setContentOfRowKey(result.getRowKey().toBytes());
			list.add(projectSort);
		}
		return list;
	}

}
