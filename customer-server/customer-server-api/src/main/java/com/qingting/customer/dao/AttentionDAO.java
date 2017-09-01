package com.qingting.customer.dao;

import java.util.List;

import com.qingting.customer.common.pojo.hbasedo.Attention;

public interface AttentionDAO {
	/**
	 * 
	 * @Title: insertAttention
	 * @Description: 插入一条关注的项目数据
	 * @param attention
	 * @return void
	 * @throws
	 */
	void insertAttention(Attention attention);
	/**
	 * 
	 * @Title: deleteAttentionByRowKey
	 * @Description: 删除一条关注的项目数据通过rowKey
	 * @param rowKey 
	 * @return void
	 * @throws
	 */
	void deleteAttentionByRowKey(String rowKey);
	/**
	 * 
	 * @Title: updateAttentionByRowKey
	 * @Description: 更新一条关注的项目数据通过rowKey
	 * @param attention
	 * @return void
	 * @throws
	 */
	void updateAttentionByRowKey(Attention attention);
	/**
	 * 
	 * @Title: listAttentionByUserId
	 * @Description: 获得所有关注的项目数据通过UserId
	 * @param userId
	 * @return List<Attention>
	 * @throws
	 */
	List<Attention> listAttentionByUserId(Integer userId);
}
