package com.qingting.customer.server;

import java.util.List;

import com.qingting.customer.common.pojo.hbasedo.Attention;
import com.qingting.customer.common.pojo.hbasedo.Equip;
import com.qingting.customer.common.pojo.model.Pagination;
import com.smart.mvc.model.WebResult;

public interface EquipService {
	/**
	 * 
	 * @Title: getEquipCodeOfNew
	 * @Description: 获得最新的设备编号
	 * @param preCode
	 * @return 
	 * @return String
	 * @throws
	 */
	String getEquipCodeOfNew(String preCode);
	/**
	 * 
	 * @Title: insertEquip
	 * @Description: 添加设备
	 * @param equip
	 * @param username
	 * @param password 
	 * @return void
	 * @throws
	 */
	WebResult<String> insertEquip(Equip equip,String username,String password);
	/**
	 * 
	 * @Title: updateUserOfEquip
	 * @Description: 给设备绑定用户,如果设备存在了用户,则删除用户,绑定新用户
	 * @param userId
	 * @param equipCode 
	 * @return void
	 * @throws
	 */
	void updateUserOfEquip(Integer userId,String equipCode);
	/**
	 * 
	 * @Title: updateUserOfNewEquip
	 * @Description: 给设备绑定用户,如果设备存在了用户,则返回提示信息,不存在则绑定
	 * @param userId
	 * @param equipCode
	 * @return 
	 * @return String
	 * @throws
	 */
	String updateUserOfNewEquip(Integer userId,String equipCode);
	/**
	 * 
	 * @Title: updateUserAndRelevanceOfEquip
	 * @Description: 绑定设备的（用户、滤芯组合、水源）,如果设备存在了用户,则删除用户,绑定新用户
	 * @param userId
	 * @param filterGroupId
	 * @param waterAreaId
	 * @param equipCode 
	 * @return void
	 * @throws
	 */
	void updateUserAndRelevanceOfEquip(Integer userId,Integer filterGroupId,Integer waterAreaId,String equipCode);
	/**
	 * 
	 * @Title: updateUserAndRelevanceOfNewEquip
	 * @Description: 绑定设备的（用户、滤芯组合、水源）,如果设备存在了用户,则返回提示信息,不存在则绑定
	 * @param userId
	 * @param filterGroupId
	 * @param waterAreaId
	 * @param equipCode
	 * @return 
	 * @return String(绑定成功返回Null,设备存在用户返回<设备已存在用户，请联系管理员>)
	 * @throws
	 */
	String updateUserAndRelevanceOfNewEquip(Integer userId,Integer filterGroupId,Integer waterAreaId,String equipCode);
	/**
	 * 
	 * @Title: deleteEquipByEquipCode
	 * @Description: 删除一个设备
	 * @param equipCode 
	 * @return void
	 * @throws
	 */
	void deleteEquipByEquipCode(String equipCode);
	/**
	 * 
	 * @Title: updateEquipByEquipCode
	 * @Description: 更新设备信息通过设备编号
	 * @param equip 
	 * @return void
	 * @throws
	 */
	void updateEquipByEquipCode(Equip equip);
	/**
	 * 
	 * @Title: listEquipByEquipCodeAndUserId
	 * @Description: 查询设备
	 * @param page
	 * @return 
	 * @return Pagination<Equip>
	 * @throws
	 */
	Pagination<Equip> listEquipByEquipCodeAndUserId(Pagination<Equip> page);
	
	/**
	 * 
	 * @Title: getEquip
	 * @Description: 查询设备
	 * @param equipCode
	 * @return 
	 * @return Equip
	 * @throws
	 */
	Equip getEquip(String equipCode);
	/**
	 * 
	 * @Title: searchEquip
	 * @Description: 搜索设备
	 * @param equipCode
	 * @return 
	 * @return List<Equip>
	 * @throws
	 */
	List<Equip> searchEquip(String equipCode);
	/**
	 * 
	 * @Title: checkIsOpen
	 * @Description: 查询设备是否公开
	 * @param equipCode
	 * @return 
	 * @return boolean
	 * @throws
	 */
	boolean checkIsOpen(String equipCode);
	/**
	 * 
	 * @Title: setOpen
	 * @Description: 设置设备是否公开
	 * @param equipCode
	 * @param isOpen
	 * @return 
	 * @return Boolean
	 * @throws
	 */
	Boolean setOpen(String equipCode,Boolean isOpen);
	/*********************************************关注的设备********************************************************/
	/**
	 * 
	 * @Title: addAttent
	 * @Description: 用户关注某个设备
	 * @param userId
	 * @param userName
	 * @param equipCode 
	 * @return void
	 * @throws
	 */
	void addAttent(Integer userId,String userName, String equipCode);
	/**
	 * 
	 * @Title: attentHandle
	 * @Description: 申请关注处理
	 * @param messageId
	 * @param userId
	 * @param equipCode
	 * @param status
	 * @param userSelfId 
	 * @return void
	 * @throws
	 */
	void attentHandle(Long messageId,Integer userId,String equipCode,byte status,Integer userSelfId);
	/**
	 * 
	 * @Title: listAttent
	 * @Description: 查询用户所有关注的设备信息
	 * @param userId
	 * @return 
	 * @return List<Attention>
	 * @throws
	 */
	List<Attention> listAttent(Integer userId);
	/**
	 * 
	 * @Title: countAttent
	 * @Description: 统计用户关注的设备数量
	 * @param userId
	 * @return 
	 * @return int
	 * @throws
	 */
	int countAttent(Integer userId);
	/**
	 * 
	 * @Title: listAttentEquip
	 * @Description: 前端查询用户所有关注的设备
	 * @param userId
	 * @return 
	 * @return List<Equip>
	 * @throws
	 */
	List<Equip> listAttentEquip(Integer userId);
	/**
	 * 
	 * @Title: deleteAttent
	 * @Description: 删除关注信息
	 * @param userId
	 * @param equipCode 
	 * @return void
	 * @throws
	 */
	void deleteAttent(Integer userId,String equipCode);
	
	/****************************************************************************************************************************/
	/**
	 * 
	 * @Title: getTopEquip
	 * @Description: 查用户的置顶设备信息
	 * @param userId
	 * @return 
	 * @return Equip
	 * @throws
	 */
	Equip getTopEquip(Integer userId);
	/**
	 * 
	 * @Title: setTop
	 * @Description: 设备置顶
	 * @param userId
	 * @param type
	 * @param equipCode 
	 * @return void
	 * @throws
	 */
	void setTop(Integer userId,String type,String equipCode);
	/**
	 * 
	 * @Title: listEquip
	 * @Description: 查询设备
	 * @param userId
	 * @param type
	 * @return 
	 * @return List<Equip>
	 * @throws
	 */
	List<Equip> listEquip(Integer userId,String type);
	/**
	 * 
	 * @Title: countEquip
	 * @Description: 统计用户自己的设备数量
	 * @param userId
	 * @return 
	 * @return int
	 * @throws
	 */
	int countEquip(Integer userId);
}
