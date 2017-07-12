package com.qingting.customer.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.alipay.simplehbase.client.QueryExtInfo;
import com.alipay.simplehbase.client.SimpleHbaseClient;
import com.alipay.simplehbase.client.rowkey.RowKeyUtil;
import com.alipay.simplehbase.sequence.RedisSerialNum;
import com.alipay.simplehbase.util.FilterUtils;
import com.qingting.customer.common.pojo.common.StringUtils;
import com.qingting.customer.common.pojo.hbasedo.User;
import com.qingting.customer.common.pojo.model.Pagination;
import com.qingting.customer.dao.UserDAO;
import com.qingting.customer.dao.util.RandomUtil;
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
	
	private final static int RANDOM_LENGTH=2;
	private final static int MOBILE_LENGTH=11;
	/**
	 * RowKey=Mobile倒叙+用户ID(12字节)
	 */
	private static RowKey createRowKey(String mobile,Integer num){
		return RowKeyUtil.getRowKey(RandomUtil.getRandomCode(RANDOM_LENGTH),mobile,num);
	}
	private static List<User> setContentOfRowKey(List<SimpleHbaseDOWithKeyResult<User>> listHbase){
		List<User> list=new ArrayList<User>();
		for (SimpleHbaseDOWithKeyResult<User> result : listHbase) {
			User user = result.getT();
			byte[] rowkey=result.getRowKey().toBytes();
			
			user.setRowkey(result.getRowKey().toString());
			byte[] mobile=new byte[11];
			System.arraycopy(rowkey, RANDOM_LENGTH, mobile, 0, MOBILE_LENGTH);//中间mobile
			user.setMobile(new String(mobile));
			byte[] id=new byte[4];
			System.arraycopy(rowkey, RANDOM_LENGTH+MOBILE_LENGTH, id, 0, 4);//后4个字节id
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
		tClient.putObject(createRowKey(user.getMobile(),num), user);
	}

	@Override
	public void deleteUserByRowKey(String rowkey) {
		tClient.delete(RowKeyUtil.getRowKey(rowkey));
	}

	@Override
	public void updateUserByRowKey(User user) {
		tClient.updateObjectWithVersion(RowKeyUtil.getRowKey(user.getRowkey()), user, dataVersion);
	}

	@Override
	public Pagination<User> listUser(Integer pageNo,Integer pageSize) {
		QueryExtInfo queryExtInfo = new QueryExtInfo();
		queryExtInfo.setLimit((pageNo-1)*pageSize, pageSize);
		List<User> list=null;
		Pagination<User> page=new Pagination<User>();
		
		list=setContentOfRowKey(
				tClient.findObjectAndKeyList(RowKeyUtil.getIntLongMinRowKey(),RowKeyUtil.getIntLongMaxRowKey(), User.class,queryExtInfo)
				);
		
		if(list!=null){
			page.setList(list);
			page.setPageNo(pageNo);
			page.setPageSize(pageSize);
			return page;
		}else{
			return null;
		}
	}
	@Override
	public User getUserByMobileAndId(Integer id,String mobile) {
		
		/*System.out.println("mobile:"+mobile);
		
		Map<String, Object> para = new HashMap<String, Object>();
		para.put("mobile", mobile);
		List<User> list=setContentOfRowKey(
				tClient.findObjectAndKeyList(createRowKey(mobile,0), createRowKey(mobile,Integer.MAX_VALUE), User.class,"getUserByMobile",para)
				);
		System.out.println("list.size:"+list.size());
		for (User user : list) {
			System.out.println("user:"+user);
		}
		
		if(list.size()>1)
			throw new RuntimeException("存在多个相同账户！请检查程序逻辑");
		else if(list.size()==1){
			return list.get(0);
		}else{
			return null;
		}*/
		List<User> list=null;
		if(StringUtils.isZeroOrNull(id) && StringUtils.isBlank(mobile)){//都为空
			
		}else if(!StringUtils.isZeroOrNull(id) && StringUtils.isBlank(mobile)){//id不为空，mobile空
			list=setContentOfRowKey(
					tClient.findObjectAndKeyList(RowKeyUtil.getStringStringIntMinRowKey(RANDOM_LENGTH,MOBILE_LENGTH,id),RowKeyUtil.getStringStringIntMaxRowKey(RANDOM_LENGTH,MOBILE_LENGTH,id), User.class,FilterUtils.getContainFilter(id),null)
					);
		}else if(StringUtils.isZeroOrNull(id) && !StringUtils.isBlank(mobile)){//id为空，mobile不为空
			list=setContentOfRowKey(
					tClient.findObjectAndKeyList(RowKeyUtil.getStringStringIntMinRowKey(RANDOM_LENGTH,mobile),RowKeyUtil.getStringStringIntMaxRowKey(RANDOM_LENGTH,mobile), User.class,FilterUtils.getContainFilter(mobile),null)
					);
		}else{//都不为空
			list=setContentOfRowKey(
					tClient.findObjectAndKeyList(RowKeyUtil.getStringStringIntMinRowKey(RANDOM_LENGTH,mobile,id),RowKeyUtil.getStringStringIntMaxRowKey(RANDOM_LENGTH,mobile,id), User.class)
					);
		}
		if(list==null){
			return null;
		}else if(list.size()>1){
			throw new RuntimeException("存在多个相同账户！请检查程序逻辑");
		}else if(list.size()==1){
			return list.get(0);
		}else{
			return null;
		}
	}

}
