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
import com.qingting.customer.model.hbasedo.EquipSort;
import com.qingting.customer.model.hbasedo.UserSort;
import com.qingting.customer.model.page.Pagination;
import com.qingting.customer.dao.UserSortDAO;
import com.qingting.customer.dao.util.SHCUtil;
import com.qingting.customer.hbase.doandkey.SimpleHbaseDOWithKeyResult;
@Repository("userSortDAO")
public class UserSortDAOImpl implements UserSortDAO {
	@Autowired
	public RedisTemplate<String, Integer> redisTemplate;
	
	private static SimpleHbaseClient tClient=SHCUtil.getSHC("userSort");
	private final static String SEQUENCE="userSort_id_seq";
	private final static byte dataVersion=0;
	
	private static List<UserSort> setContentOfRowKey(List<SimpleHbaseDOWithKeyResult<UserSort>> listHbase){
		List<UserSort> list=new ArrayList<UserSort>();
		for (SimpleHbaseDOWithKeyResult<UserSort> result : listHbase) {
			UserSort userSort = result.getT();
			byte[] rowkey=result.getRowKey().toBytes();
			userSort.setId(Bytes.toInt(rowkey));
			list.add(userSort);
		}
		return list;
	}
	@Override
	public void insertUserSort(UserSort userSort) {
		int num=RedisSerialNum.getSerialNum(redisTemplate, SEQUENCE);
		System.out.println("用户分类当前序列号:"+num);
		userSort.setId(num);
		System.out.println(userSort);
		tClient.putObject(RowKeyUtil.getRowKey(num), userSort);
	}

	@Override
	public void deleteUserSortByRowKey(String rowKey) {
		tClient.delete(RowKeyUtil.getRowKey(rowKey));
	}

	@Override
	public void updateUserSortByRowKey(UserSort userSort) {
		tClient.updateObjectWithVersion(RowKeyUtil.getRowKey(userSort.getRowKey()), userSort, dataVersion);
	}

	@Override
	public UserSort getUserSortByRowKey(String rowKey) {
		List<UserSort> list =
				setContentOfRowKey(
						tClient.findObjectAndKeyList(RowKeyUtil.getRowKey(rowKey),RowKeyUtil.lastByteOfRowKeyPlusOne(RowKeyUtil.getRowKey(rowKey)), UserSort.class)
						);
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

	@Override
	public Pagination<UserSort> listUserSort(Integer pageNo,Integer pageSize) {
		QueryExtInfo queryExtInfo = new QueryExtInfo();
		queryExtInfo.setLimit((pageNo-1)*pageSize, pageSize);
		List<UserSort> list=null;
		Pagination<UserSort> page=new Pagination<UserSort>();
		
		list=setContentOfRowKey(
				tClient.findObjectAndKeyList(RowKeyUtil.getIntMinRowKey(),RowKeyUtil.getIntMaxRowKey(), UserSort.class,null,queryExtInfo)
				);
		page.setRowCount(tClient.count(RowKeyUtil.getIntMinRowKey(), RowKeyUtil.getIntMaxRowKey(), null));
		
		page.setList(list);
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		return page;
	}

}
