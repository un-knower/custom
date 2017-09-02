package com.qingting.customer.dao;

import java.util.List;

import com.qingting.customer.model.Tag;

public interface TagDAO{
	/**
	 * 
	 * @Title: insertTag
	 * @Description: 插入一条标签信息
	 * @param tag 
	 * @return void
	 * @throws
	 */
	void insertTag(Tag tag);
	/**
	 * 
	 * @Title: deleteTagByRowKey
	 * @Description: 删除一条标签信息
	 * @param rowKey 
	 * @return void
	 * @throws
	 */
	void deleteTagByRowKey(String rowKey);
	/**
	 * 
	 * @Title: updateTagByRowKey
	 * @Description: 修改一条标签信息
	 * @param tag 
	 * @return void
	 * @throws
	 */
	void updateTagByRowKey(Tag tag);
	/**
	 * 
	 * @Title: getTagByRowKey
	 * @Description: 获得一条标签信息通过rowKey
	 * @param tag
	 * @return 
	 * @return Tag
	 * @throws
	 */
	Tag getTagByRowKey(String rowKey);
	/**
	 * 
	 * @Title: listTagByRank
	 * @Description: 获得对应等级的所有标签
	 * @param rank
	 * @return 
	 * @return List<Tag>
	 * @throws
	 */
	List<Tag> listTagByRank(Integer rank);
}