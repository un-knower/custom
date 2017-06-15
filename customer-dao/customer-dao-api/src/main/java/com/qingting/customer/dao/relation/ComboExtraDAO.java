package com.qingting.customer.dao.relation;

import java.util.List;

import com.qingting.customer.common.pojo.hbasedo.relation.ComboExtra;

/**
 * 
 * @ClassName: ComboExtraDAO
 * @Description: 套餐和配置特权关系实体
 * @author zlf
 * @date 2017年6月15日 下午7:00:04
 *
 */
public interface ComboExtraDAO {
	/**
	 * 
	 * @Title: insertComboExtra
	 * @Description: 插入一条套餐和配置特权信息
	 * @param comboExtra 
	 * @return void
	 * @throws
	 */
	void insertComboExtra(ComboExtra comboExtra);
	/**
	 * 
	 * @Title: deleteComboExtraByRowKey
	 * @Description: 删除一条套餐和配置特权信息通过rowKey
	 * @param rowKey 
	 * @return void
	 * @throws
	 */
	void deleteComboExtraByRowKey(String rowKey);
	/**
	 * 
	 * @Title: updateComboExtraByRowKey
	 * @Description: 修改套餐和配置特权信息通过rowKey
	 * @param comboExtra 
	 * @return void
	 * @throws
	 */
	void updateComboExtraByRowKey(ComboExtra comboExtra);
	/**
	 * 
	 * @Title: getComboExtraByRowKey
	 * @Description: 获得套餐和配置特权信息通过rowKey
	 * @param rowKey
	 * @return 
	 * @return ComboExtra
	 * @throws
	 */
	ComboExtra getComboExtraByRowKey(String rowKey);
	/**
	 * 
	 * @Title: listComboExtra
	 * @Description: 查询所有套餐和配置特权信息
	 * @return 
	 * @return List<ComboExtra>
	 * @throws
	 */
	List<ComboExtra> listComboExtra();
}
