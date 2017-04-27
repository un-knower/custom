package com.qingting.customer.dao;

import java.util.Calendar;
import java.util.List;

import com.qingting.customer.common.pojo.hbasedo.Attention;
import com.qingting.customer.hbase.doandkey.SimpleHbaseDOWithKeyResult;

public interface AttentionDAO {
	/**
	 * 
	 * @Title: insertAttentionByUserId
	 * @Description: 插入一条关注的项目数据通过userId
	 * @param attention
	 * @param userId 
	 * @return void
	 * @throws
	 */
	void insertAttentionByUserId(Attention attention,Integer userId);
	/**
	 * 
	 * @Title: deleteAttentionByUserIdAndCalendar
	 * @Description: 删除一条关注的项目数据通过UserIdAndCalendar
	 * @param userId
	 * @param calendar 
	 * @return void
	 * @throws
	 */
	void deleteAttentionByUserIdAndCalendar(Integer userId,Calendar calendar);
	/**
	 * 
	 * @Title: updateAttentionByUserIdAndCalendar
	 * @Description: 更新一条关注的项目数据通过UserIdAndCalendar
	 * @param attention
	 * @param userId
	 * @param calendar 
	 * @return void
	 * @throws
	 */
	void updateAttentionByUserIdAndCalendar(Attention attention,Integer userId,Calendar calendar);
	/**
	 * 
	 * @Title: listAttentionByUserId
	 * @Description: 获得所有关注的项目数据通过UserId
	 * @param userId
	 * @return 
	 * @return List<SimpleHbaseDOWithKeyResult<Attention>>
	 * @throws
	 */
	List<SimpleHbaseDOWithKeyResult<Attention>> listAttentionByUserId(Integer userId);
}
