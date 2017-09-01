package com.qingting.customer.dao;

import java.util.List;

import com.qingting.customer.Dao;
import com.qingting.customer.model.hbasedo.Area;
import com.qingting.customer.model.page.Pagination;

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
	 * @param code
	 * @param pageNo
	 * @param pageSize
	 * @return 
	 * @return Pagination<Area>
	 * @throws
	 */
	Pagination<Area> listArea(String cityCode,String code,Integer pageNo,Integer pageSize);
}
