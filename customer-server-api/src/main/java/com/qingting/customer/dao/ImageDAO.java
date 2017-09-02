package com.qingting.customer.dao;

import java.util.List;

import com.qingting.customer.model.Image;

public interface ImageDAO{
	/**
	 * 
	 * @Title: insertImage
	 * @Description: 插入一条图片信息
	 * @param image 
	 * @return void
	 * @throws
	 */
	void insertImage(Image image);
	/**
	 * 
	 * @Title: deleteImageByRowKey
	 * @Description: 删除一条图片信息通过rowKey
	 * @param rowKey 
	 * @return void
	 * @throws
	 */
	void deleteImageByRowKey(String rowKey);
	/**
	 * 
	 * @Title: updateImageByRowKey
	 * @Description: 修改一条图片信息通过rowKey
	 * @param image 
	 * @return void
	 * @throws
	 */
	void updateImageByRowKey(Image image);
	/**
	 * 
	 * @Title: getImageByRowKey
	 * @Description: 获得一条图片信息通过rowKey
	 * @param rowKey
	 * @return 
	 * @return Image
	 * @throws
	 */
	Image getImageByRowKey(String rowKey);
	/**
	 * 
	 * @Title: listImage
	 * @Description: 获得所有图片信息
	 * @return 
	 * @return List<Image>
	 * @throws
	 */
	List<Image> listImage();
}