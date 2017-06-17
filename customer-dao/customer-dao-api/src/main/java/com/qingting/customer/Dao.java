package com.qingting.customer;

import java.io.Serializable;
import java.util.Collection;

public interface Dao<T, RK extends Serializable> {
	
	/**
	 * 
	 * @Title: get
	 * @Description: 通过rowKey行健查询实体
	 * @param rk
	 * @return T
	 * @throws
	 */
	public T get(RK rk);

	/**
	 * 插入实体
	 * 
	 * @param T
	 *            t
	 */
	public boolean insert(T t);

	/**
	 * 更新实体
	 * 
	 * @param T
	 *            t
	 */
	public boolean update(T t);
	
	/**
	 * 删除实体
	 * 
	 * @param T
	 *            t
	 */
	public void deleteById(Collection<RK> rkList);
}
