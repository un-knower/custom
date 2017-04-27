package com.qingting.customer.dao;

import java.util.Calendar;
import java.util.List;


import com.qingting.customer.common.pojo.hbasedo.ComParam;
import com.qingting.customer.hbase.doandkey.SimpleHbaseDOWithKeyResult;

public interface ComParamDAO {
	/**
	 * 
	 * @Title: insertComParamByEnable
	 * @Description: 插入一条通用参数通过enable
	 * @param comParam
	 * @param enable 
	 * @return void
	 * @throws
	 */
	void insertComParamByEnable(ComParam comParam,Boolean enable);
	/**
	 * 
	 * @Title: deleteComParamByEnableAndCalendar
	 * @Description: 删除一条通用参数通过EnableAndCalendar
	 * @param enable
	 * @param calendar 
	 * @return void
	 * @throws
	 */
	void deleteComParamByEnableAndCalendar(Boolean enable,Calendar calendar);
	/**
	 * 
	 * @Title: updateComParamByEnableAndCalendar
	 * @Description: 更新一条通用参数通过EnableAndCalendar
	 * @param enable
	 * @param calendar 
	 * @return void
	 * @throws
	 */
	void updateComParamByEnableAndCalendar(ComParam comParam,Boolean enable,Calendar calendar);
	/**
	 * 
	 * @Title: getComParamByEnable
	 * @Description: 获得激活的通用参数
	 * @return 
	 * @return ComParam
	 * @throws
	 */
	ComParam getComParamOfEnable();
	/**
	 * 
	 * @Title: listComParamAndKey
	 * @Description: 获得所有的通用参数
	 * @return 
	 * @return List<SimpleHbaseDOWithKeyResult<ComParam>>
	 * @throws
	 */
	List<SimpleHbaseDOWithKeyResult<ComParam>> listComParamAndKey();
}
