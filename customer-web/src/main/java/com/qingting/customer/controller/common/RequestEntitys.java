package com.qingting.customer.controller.common;

import java.util.List;

public class RequestEntitys<T> {
	List<T> entitys;

	public List<T> getEntitys() {
		return entitys;
	}

	public void setEntitys(List<T> entitys) {
		this.entitys = entitys;
	}

	@Override
	public String toString() {
		return "RequestEntitys [entitys=" + entitys + "]";
	}

	
	
}
