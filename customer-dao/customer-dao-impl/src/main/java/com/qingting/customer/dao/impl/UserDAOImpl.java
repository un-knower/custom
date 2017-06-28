package com.qingting.customer.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.alipay.simplehbase.client.rowkey.BytesRowKey;
import com.alipay.simplehbase.client.rowkey.StringRowKey;
import com.alipay.simplehbase.sequence.RedisSerialNum;
import com.alipay.simplehbase.util.SHCUtil;
import com.qingting.customer.common.pojo.hbasedo.User;
import com.qingting.customer.common.pojo.util.DateUtil;
import com.qingting.customer.common.pojo.util.RowKeyUtil;
import com.qingting.customer.dao.UserDAO;
import com.qingting.customer.hbase.doandkey.SimpleHbaseDOWithKeyResult;
import com.qingting.customer.hbase.rowkey.RowKey;
@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
	@Autowired
	public RedisTemplate<String, Integer> redisTemplate;
	@Override
	public void insertUser(User user) {
		//int num=RedisSerialNum.getSerialNum(redisTemplate, SerialType.SERIALNUM.getValue());
		int num=RedisSerialNum.getSerialNum(redisTemplate, "user_id_seq");
		RowKey rowKey = new BytesRowKey(RowKeyUtil.getBytes(num, DateUtil.getMillisOfStart()));
		boolean result = SHCUtil.getSHC("user").insertObject(rowKey, user);
		if(result==false)
			throw new RuntimeException("插入user失败.");
	}

	@Override
	public void deleteUserByRowKey(String rowKey) {
		SHCUtil.getSHC("user").delete(new StringRowKey(rowKey));
	}

	@Override
	public void updateUserByRowKey(User user) {
		SHCUtil.getSHC("user").updateObjectWithVersion(new StringRowKey(user.getRowKey()), user, user.getVersion());

	}

	@Override
	public User getUserByRowKey(String rowKey) {
		SimpleHbaseDOWithKeyResult<User> result = SHCUtil.getSHC("user").findObjectAndKey(new StringRowKey(rowKey), User.class);
		User user=result.getT();
		user.setContentOfRowKey(result.getRowKey().toBytes());
		return user;
	}

	@Override
	public List<User> listUser() {
		RowKey startRowKey=new BytesRowKey(RowKeyUtil.getBytes(DateUtil.getStartOfMillis()));
		RowKey endRowKey=new BytesRowKey(RowKeyUtil.getBytes(DateUtil.getMillisOfStart()));
		List<SimpleHbaseDOWithKeyResult<User>> listDOWithKey = SHCUtil.getSHC("user").findObjectAndKeyList(startRowKey,endRowKey, User.class);
		List<User> list=new ArrayList<User>();
		for (SimpleHbaseDOWithKeyResult<User> result : listDOWithKey) {
			User user = result.getT();
			user.setContentOfRowKey(result.getRowKey().toBytes());
			list.add(user);
		}
		return list;
	}

	@Override
	public User getUserByMobile(String mobile) {
		Map<String, Object> para = new HashMap<String, Object>();
		para.put("mobile", mobile);
		List<SimpleHbaseDOWithKeyResult<User>> list = SHCUtil.getSHC("user").findObjectAndKeyList(new StringRowKey(""),new StringRowKey(User.MAX_ROWKEY), User.class,"getUserByMobile",para);
		SimpleHbaseDOWithKeyResult<User> result;
		User user=null;
		if(list.size()>1)
			throw new RuntimeException("存在多个相同账户！请检查程序逻辑");
		else if(list.size()==1){
			result = list.get(0);
			user=result.getT();
			user.setContentOfRowKey(result.getRowKey().toBytes());
		}
		
		return user;
	}

}
