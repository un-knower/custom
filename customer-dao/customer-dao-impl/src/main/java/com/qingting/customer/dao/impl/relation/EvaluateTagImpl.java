package com.qingting.customer.dao.impl.relation;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.qingting.customer.common.pojo.hbasedo.relation.EvaluateTag;
import com.qingting.customer.dao.relation.EvaluateTagDAO;
@Repository("evaluateTagDAO")
public class EvaluateTagImpl implements EvaluateTagDAO {
	
	@Autowired
	public RedisTemplate<String, Integer> redisTemplate;
	
	@Override
	public EvaluateTag get(String rk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(EvaluateTag t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(EvaluateTag t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void deleteById(Collection<String> rkList) {
		// TODO Auto-generated method stub

	}

}
