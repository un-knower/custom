package com.qingting.customer.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.alipay.simplehbase.client.SimpleHbaseClient;
import com.alipay.simplehbase.client.rowkey.RowKeyUtil;
import com.alipay.simplehbase.client.rowkey.StringRowKey;
import com.alipay.simplehbase.sequence.RedisSerialNum;
import com.qingting.customer.common.pojo.hbasedo.User;
import com.qingting.customer.dao.UserDAO;
import com.qingting.customer.dao.util.SHCUtil;
import com.qingting.customer.hbase.doandkey.SimpleHbaseDOWithKeyResult;
import com.qingting.customer.hbase.rowkey.RowKey;
@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
	@Autowired
	public RedisTemplate<String, Integer> redisTemplate;
	
	private static SimpleHbaseClient tClient=SHCUtil.getSHC("user");
	private final static String SEQUENCE="user_id_seq";
	private final static byte dataVersion=0;
	/**
	 * RowKey=Mobile倒叙+用户ID(12字节)
	 */
	private static RowKey createRowKey(User user,Integer num){
		//反转
		String temp=new StringBuffer(user.getMobile()).reverse().toString();
		return RowKeyUtil.getRowKey(Long.parseLong(temp),num);
	}
	private static List<User> setContentOfRowKey(List<SimpleHbaseDOWithKeyResult<User>> listHbase){
		List<User> list=new ArrayList<User>();
		for (SimpleHbaseDOWithKeyResult<User> result : listHbase) {
			User user = result.getT();
			byte[] rowkey=result.getRowKey().toBytes();
			
			//user.setRowKey(new String(rowkey));
			
			byte[] mobile=new byte[8];
			System.arraycopy(rowkey, 0, mobile, 0, 8);//前8个字节mobile
			String temp=String.valueOf(Bytes.toLong(mobile));
			user.setMobile(new StringBuffer(temp).reverse().toString());
			byte[] id=new byte[4];
			System.arraycopy(rowkey, 0, id, 0, 4);//前4个字节id
			user.setId(Bytes.toInt(id));
			
			list.add(user);
		}
		return list;
	}
	@Override
	public void insertUser(User user) {
		System.out.println("插入user");
		int num=RedisSerialNum.getSerialNum(redisTemplate, SEQUENCE);
		user.setId(num);
		tClient.putObject(createRowKey(user,num), user);
	}

	@Override
	public void deleteUserByRowKey(String rowKey) {
		tClient.delete(new StringRowKey(rowKey));
	}

	@Override
	public void updateUserByRowKey(User user) {
		//tClient.updateObjectWithVersion(new StringRowKey(user.getRowKey()), user, dataVersion);

	}

	@Override
	public User getUserByRowKey(String rowKey) {
		SimpleHbaseDOWithKeyResult<User> result = tClient.findObjectAndKey(new StringRowKey(rowKey), User.class);
		User user=result.getT();
		//user.setContentOfRowKey(result.getRowKey().toBytes());
		return user;
	}

	@Override
	public List<User> listUser() {
		/*RowKey startRowKey=new BytesRowKey(RowKeyUtil.getBytes(DateUtil.getStartOfMillis()));
		RowKey endRowKey=new BytesRowKey(RowKeyUtil.getBytes(DateUtil.getMillisOfStart()));
		List<SimpleHbaseDOWithKeyResult<User>> listDOWithKey = tClient.findObjectAndKeyList(startRowKey,endRowKey, User.class);
		List<User> list=new ArrayList<User>();
		for (SimpleHbaseDOWithKeyResult<User> result : listDOWithKey) {
			User user = result.getT();
			user.setContentOfRowKey(result.getRowKey().toBytes());
			list.add(user);
		}
		return list;*/
		return setContentOfRowKey(
				tClient.findObjectAndKeyList(RowKeyUtil.getMinRowKey(null, 11, null),RowKeyUtil.getMaxRowKey(null, 11, null), User.class)
				);
	}

	@Override
	public User getUserByMobile(String mobile) {
		/*Map<String, Object> para = new HashMap<String, Object>();
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
		}*/
		List<User> list=setContentOfRowKey(
				tClient.findObjectAndKeyList(RowKeyUtil.getMinRowKey(mobile, 11, null), RowKeyUtil.getMaxRowKey(mobile, 11, null), User.class)
				);
		if(list.size()>1)
			throw new RuntimeException("存在多个相同账户！请检查程序逻辑");
		else if(list.size()==1){
			return list.get(0);
		}else{
			return null;
		}
	}

}
