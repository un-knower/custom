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
import com.alipay.simplehbase.util.HbaseOriginService;
import com.qingting.customer.model.common.StringUtils;
import com.qingting.customer.model.hbasedo.User;
import com.qingting.customer.model.page.Pagination;
import com.qingting.customer.model.util.RandomUtil;
import com.qingting.customer.dao.UserDAO;
import com.qingting.customer.dao.util.SHCUtil;
import com.qingting.customer.hbase.doandkey.SimpleHbaseDOWithKeyResult;
import com.qingting.customer.hbase.rowkey.RowKey;
@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
	@Autowired
	public RedisTemplate<String, Integer> redisTemplate;
	
	private static SimpleHbaseClient tClient=SHCUtil.getSHC("user");
	
	private static HbaseOriginService idIndex=new HbaseOriginService("userIdIndex",
			new String[]{"iif"},
			new byte[][]{
	});
	private static HbaseOriginService mobileIndex=new HbaseOriginService("userMobileIndex",
			new String[]{"mif"},
			new byte[][]{
	});
	
	private final static String SEQUENCE="user_id_seq";
	private final static int RANDOM_LENGTH=2;
	private final static int MOBILE_LENGTH=11;
	/**
	 * RowKey=Mobile倒叙+用户ID(12字节)
	 */
	private static RowKey createRowKey(Integer id){
		return RowKeyUtil.getRowKey(RandomUtil.getRandomCode(RANDOM_LENGTH),id);
	}
	private static List<User> setContentOfRowKey(List<SimpleHbaseDOWithKeyResult<User>> listHbase){
		List<User> list=new ArrayList<User>();
		for (SimpleHbaseDOWithKeyResult<User> result : listHbase) {
			User user = result.getT();
			/*byte[] rowkey=result.getRowKey().toBytes();
			
			user.setRowkey(new String(rowkey));
			byte[] mobile=new byte[11];
			System.arraycopy(rowkey, RANDOM_LENGTH, mobile, 0, MOBILE_LENGTH);//中间mobile
			user.setMobile(new String(mobile));
			byte[] id=new byte[4];
			System.arraycopy(rowkey, RANDOM_LENGTH+MOBILE_LENGTH, id, 0, 4);//后4个字节id
			user.setId(Bytes.toInt(id));*/
			
			list.add(user);
		}
		return list;
	}
	@Override
	public void insertUser(User user) {
		System.out.println("插入user");
		int num=RedisSerialNum.getSerialNum(redisTemplate, SEQUENCE);
		user.setId(num);
		RowKey value=createRowKey(num);
		idIndex.put(RowKeyUtil.getRowKey(num), "iif", "value", value.toBytes());
		mobileIndex.put(RowKeyUtil.getRowKey(user.getMobile()), "mif", "value", value.toBytes());
		tClient.putObject(value, user);
	}

	@Override
	public void deleteUserByRowKey(List<String> rowkeys) {
		List<RowKey> rowKeylist = new ArrayList<RowKey>();
		for (String string : rowkeys) {
			rowKeylist.add(RowKeyUtil.getRowKey(string));
		}
		tClient.deleteList(rowKeylist);
	}

	@Override
	public void updateUserByRowKey(User user) {
		//tClient.updateObjectWithVersion(RowKeyUtil.getRowKey(user.getRowkey()), user, dataVersion);
		tClient.putObject(RowKeyUtil.getRowKey(user.getRowkey()), user);
	}

	@Override
	public Pagination<User> listUser(Integer pageNo,Integer pageSize) {
		QueryExtInfo queryExtInfo = new QueryExtInfo();
		queryExtInfo.setLimit((pageNo-1)*pageSize, pageSize);
		List<User> list=null;
		Pagination<User> page=new Pagination<User>();
		
		
		list=tClient.findObjectList(RowKeyUtil.getMinRowKey(13),RowKeyUtil.getMaxRowKey(13), User.class,queryExtInfo);
				
		page.setRowCount(tClient.count(RowKeyUtil.getMinRowKey(13),RowKeyUtil.getMaxRowKey(13), null));
		
		page.setList(list);
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		return page;
	}
	@Override
	public User getUserByMobile(String mobile){
		RowKey rowKey = mobileIndex.indexGet(RowKeyUtil.getRowKey(mobile), null,null, "value");
		if(rowKey!=null && rowKey.toBytes().length>0)
			return tClient.findObject(rowKey, User.class);
		else
			return null;
	}
	@Override
	public User getUserById(Integer id){
		RowKey rowKey = idIndex.indexGet(RowKeyUtil.getRowKey(id), null,null, "value");
		return tClient.findObject(rowKey, User.class);
	}
	
	@Override
	public List<User> searchUserByMobile(String mobile){
		List<RowKey> listRowKey = mobileIndex.indexScan(FilterUtils.getContainFilter(mobile), null, "value");
		System.out.println("搜索到的用户size:"+listRowKey.size());
		List<User> list=tClient.findObjectBatch(listRowKey, User.class);
		for (User user : list) {
			System.out.println(user);
		}
		return list;
	}
}
