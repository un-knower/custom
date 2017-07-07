package com.qingting.customer.dao;

import java.util.List;

import com.qingting.customer.Dao;
import com.qingting.customer.common.pojo.hbasedo.Area;

public interface AreaDAO extends Dao<Area, Integer>{
	/**
	 * 
	 * @Title: insertAreaList
	 * @Description: 批量插入
	 * @param areaList 
	 * @return void
	 * @throws
	 */
	void insertAreaList(List<Area> areaList);
	/**
	 * 
	 * @Title: listArea
	 * @Description: 查询区信息
	 * @param cityCode
	 * @return 
	 * @return List<Area>
	 * @throws
	 */
	List<Area> listArea(String cityCode);
}
