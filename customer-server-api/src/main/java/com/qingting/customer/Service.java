package com.qingting.customer;

import java.io.Serializable;
import java.util.Collection;


public interface Service<T, RK extends Serializable> {

	/**
	 * 插入实体
	 * 
	 * @param T
	 *            t
	 */
	public void insert(T t);
	
	/**
	 * 删除实体
	 * 
	 * @param T
	 *            t
	 */
	public void deleteById(Collection<RK> rkList);

	/**
	 * 更新实体
	 * 
	 * @param T
	 *            t
	 */
	public void update(T t);
	
	/**
	 * 
	 * @Title: get
	 * @Description: 通过rowKey行健查询实体
	 * @param rk
	 * @return T
	 * @throws
	 */
	public T get(RK rk);
}
