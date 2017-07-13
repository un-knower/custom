package com.qingting.customer.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.alipay.simplehbase.client.QueryExtInfo;
import com.alipay.simplehbase.client.SimpleHbaseClient;
import com.alipay.simplehbase.client.rowkey.BytesRowKey;
import com.alipay.simplehbase.client.rowkey.RowKeyUtil;
import com.alipay.simplehbase.client.rowkey.StringRowKey;
import com.alipay.simplehbase.sequence.RedisSerialNum;
import com.qingting.customer.common.pojo.hbasedo.Equip;
import com.qingting.customer.common.pojo.hbasedo.EquipSort;
import com.qingting.customer.common.pojo.hbasedo.UserSort;
import com.qingting.customer.common.pojo.model.Pagination;
import com.qingting.customer.common.pojo.util.DateUtil;
import com.qingting.customer.dao.EquipSortDAO;
import com.qingting.customer.dao.util.SHCUtil;
import com.qingting.customer.hbase.doandkey.SimpleHbaseDOWithKeyResult;
import com.qingting.customer.hbase.rowkey.RowKey;
@Repository("equipSortDAO")
public class EquipSortDAOImpl implements EquipSortDAO {
	@Autowired
	public RedisTemplate<String, Integer> redisTemplate;
	
	private static SimpleHbaseClient tClient=SHCUtil.getSHC("equipSort");
	private final static String SEQUENCE="equipSort_id_seq";
	private final static byte dataVersion=0;
	
	private static List<EquipSort> setContentOfRowKey(List<SimpleHbaseDOWithKeyResult<EquipSort>> listHbase){
		List<EquipSort> list=new ArrayList<EquipSort>();
		for (SimpleHbaseDOWithKeyResult<EquipSort> result : listHbase) {
			EquipSort equipSort = result.getT();
			byte[] rowkey=result.getRowKey().toBytes();
			equipSort.setId(Bytes.toInt(rowkey));
			list.add(equipSort);
		}
		return list;
	}
	@Override
	public void insertEquipSort(EquipSort equipSort) {
		int num=RedisSerialNum.getSerialNum(redisTemplate, SEQUENCE);
		equipSort.setId(num);
		tClient.insertObject(RowKeyUtil.getRowKey(num), equipSort);
	}

	@Override
	public void deleteEquipSortByRowKey(String rowKey) {
		tClient.delete(RowKeyUtil.getRowKey(rowKey));
	}

	@Override
	public void updateEquipSortByRowKey(EquipSort equipSort) {
		tClient.updateObjectWithVersion(RowKeyUtil.getRowKey(equipSort.getRowKey()), equipSort, dataVersion);
	}

	@Override
	public EquipSort getEquipSortByRowKey(String rowKey) {
		List<EquipSort> list =
				setContentOfRowKey(
						tClient.findObjectAndKeyList(RowKeyUtil.getRowKey(rowKey),RowKeyUtil.lastByteOfRowKeyPlusOne(RowKeyUtil.getRowKey(rowKey)), EquipSort.class)
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
	public Pagination<EquipSort> listEquipSort(Integer pageNo,Integer pageSize) {
		QueryExtInfo queryExtInfo = new QueryExtInfo();
		queryExtInfo.setLimit((pageNo-1)*pageSize, pageSize);
		List<EquipSort> list=null;
		Pagination<EquipSort> page=new Pagination<EquipSort>();
		
		list=setContentOfRowKey(
				tClient.findObjectAndKeyList(RowKeyUtil.getIntMinRowKey(),RowKeyUtil.getIntMaxRowKey(), EquipSort.class,null,queryExtInfo)
				);
		page.setRowCount(tClient.count(RowKeyUtil.getIntMinRowKey(), RowKeyUtil.getIntMaxRowKey(), null));
		
		page.setList(list);
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		return page;
		
	}

}
