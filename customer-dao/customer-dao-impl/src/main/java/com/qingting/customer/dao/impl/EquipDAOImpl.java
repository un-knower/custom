package com.qingting.customer.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.alipay.simplehbase.client.QueryExtInfo;
import com.alipay.simplehbase.client.SimpleHbaseClient;
import com.alipay.simplehbase.client.rowkey.BytesRowKey;
import com.alipay.simplehbase.client.rowkey.RowKeyUtil;
import com.alipay.simplehbase.client.rowkey.StringRowKey;
import com.alipay.simplehbase.enums.SerialType;
import com.alipay.simplehbase.sequence.RedisSerialNum;
import com.alipay.simplehbase.util.FilterUtils;
import com.qingting.customer.common.pojo.common.StringUtils;
import com.qingting.customer.common.pojo.hbasedo.Area;
import com.qingting.customer.common.pojo.hbasedo.Equip;
import com.qingting.customer.common.pojo.hbasedo.User;
import com.qingting.customer.common.pojo.model.Pagination;
import com.qingting.customer.common.pojo.util.DateUtil;
import com.qingting.customer.dao.EquipDAO;
import com.qingting.customer.dao.util.Common;
import com.qingting.customer.dao.util.RandomUtil;
import com.qingting.customer.dao.util.SHCUtil;
import com.qingting.customer.hbase.doandkey.SimpleHbaseDOWithKeyResult;
import com.qingting.customer.hbase.rowkey.RowKey;

@Repository("equipDAO")
public class EquipDAOImpl implements EquipDAO {
	@Resource(name="redisTemplate")
	public RedisTemplate<String, Integer> redisTemplate;
	
	private static SimpleHbaseClient tClient=SHCUtil.getSHC("equip");
	private final static String SEQUENCE="equip_id_seq";
	private final static byte dataVersion=0;
	
	private final static int RANDOM_LENGTH=2;
	private final static int EQUIP_CODE_LENGTH=12;
	
	private static RowKey createRowKey(String equipCode,Integer userId){
		return RowKeyUtil.getRowKey(RandomUtil.getRandomCode(RANDOM_LENGTH),equipCode,userId);
	}
	
	private static List<Equip> setContentOfRowKey(List<SimpleHbaseDOWithKeyResult<Equip>> listHbase){
		List<Equip> list=new ArrayList<Equip>();
		for (SimpleHbaseDOWithKeyResult<Equip> result : listHbase) {
			Equip equip = result.getT();
			byte[] rowkey=result.getRowKey().toBytes();
			
			equip.setRowKey(result.getRowKey().toString());
			
			byte[] equipCode=new byte[EQUIP_CODE_LENGTH];
			System.arraycopy(rowkey, RANDOM_LENGTH, equipCode, 0, EQUIP_CODE_LENGTH);//中间mobile
			equip.setEquipCode(new String(equipCode));
			
			byte[] userId=new byte[4];
			System.arraycopy(rowkey, RANDOM_LENGTH+EQUIP_CODE_LENGTH, userId, 0, 4);//后4个字节id
			equip.setUserId(Bytes.toInt(userId));
			
			list.add(equip);
		}
		return list;
	}
	
	@Override
	public void insertEquip(Equip equip) {
		int num=RedisSerialNum.getSerialNum(redisTemplate, SEQUENCE);
		equip.setId(num);
		tClient.insertObject(createRowKey(equip.getEquipCode(),equip.getUserId()), equip);
	}

	@Override
	public void deleteEquipByRowKey(String rowKey) {
		tClient.delete(new StringRowKey(rowKey));
	}

	@Override
	public void updateEquipByRowKey(Equip equip) {
		tClient.updateObjectWithVersion(new StringRowKey(equip.getRowKey()), equip, dataVersion);
	}

	@Override
	public Pagination<Equip> listEquipByEquipCodeAndUserId(String equipCode,Integer userId,Integer pageNo,Integer pageSize) {
		QueryExtInfo queryExtInfo = new QueryExtInfo();
		queryExtInfo.setLimit((pageNo-1)*pageSize, pageSize);
		List<Equip> list=null;
		Pagination<Equip> page=new Pagination<Equip>();
		
		if( StringUtils.isBlank(equipCode) && StringUtils.isZeroOrNull(userId) ){//都空
			list=setContentOfRowKey(
					tClient.findObjectAndKeyList(RowKeyUtil.getStringStringIntMinRowKey(RANDOM_LENGTH,EQUIP_CODE_LENGTH), RowKeyUtil.getStringStringIntMaxRowKey(RANDOM_LENGTH,EQUIP_CODE_LENGTH), Equip.class,queryExtInfo)
					);
			page.setRowCount(tClient.count(RowKeyUtil.getStringStringMinRowKey(RANDOM_LENGTH,EQUIP_CODE_LENGTH), RowKeyUtil.getStringStringMaxRowKey(RANDOM_LENGTH,EQUIP_CODE_LENGTH), null));
		}else if( !StringUtils.isBlank(equipCode) && StringUtils.isZeroOrNull(userId) ){//设备编号不为空，用户ID空
			list=setContentOfRowKey(
					tClient.findObjectAndKeyList(RowKeyUtil.getStringStringIntMinRowKey(RANDOM_LENGTH,equipCode),RowKeyUtil.getStringStringIntMaxRowKey(RANDOM_LENGTH,equipCode), Equip.class,FilterUtils.getContainFilter(equipCode),queryExtInfo)
					);
			page.setRowCount(tClient.count(RowKeyUtil.getStringStringIntMinRowKey(RANDOM_LENGTH,equipCode),RowKeyUtil.getStringStringIntMaxRowKey(RANDOM_LENGTH,equipCode), FilterUtils.getContainFilter(equipCode)));
		}else if( StringUtils.isBlank(equipCode) && !StringUtils.isZeroOrNull(userId) ){//设备编号空，用户ID不为空
			list=setContentOfRowKey(
					tClient.findObjectAndKeyList(RowKeyUtil.getStringStringIntMinRowKey(RANDOM_LENGTH,EQUIP_CODE_LENGTH,userId),RowKeyUtil.getStringStringIntMaxRowKey(RANDOM_LENGTH,EQUIP_CODE_LENGTH,userId), Equip.class,FilterUtils.getContainFilter(userId),queryExtInfo)
					);
			page.setRowCount(tClient.count(RowKeyUtil.getStringStringIntMinRowKey(RANDOM_LENGTH,EQUIP_CODE_LENGTH,userId),RowKeyUtil.getStringStringIntMaxRowKey(RANDOM_LENGTH,EQUIP_CODE_LENGTH,userId), FilterUtils.getContainFilter(userId)));
		}else{//都不为空
			list=setContentOfRowKey(
					tClient.findObjectAndKeyList(RowKeyUtil.getStringStringIntMinRowKey(RANDOM_LENGTH,equipCode,userId),RowKeyUtil.getStringStringIntMaxRowKey(RANDOM_LENGTH,equipCode,userId), Equip.class,FilterUtils.getContainFilter(equipCode),queryExtInfo)
					);
			page.setRowCount(tClient.count(RowKeyUtil.getStringStringIntMinRowKey(RANDOM_LENGTH,equipCode,userId),RowKeyUtil.getStringStringIntMaxRowKey(RANDOM_LENGTH,equipCode,userId), FilterUtils.getContainFilter(equipCode)));
		}
		
		page.setList(list);
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		return page;
		
	}
}
