package com.qingting.customer.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.alipay.simplehbase.client.PutRequest;
import com.alipay.simplehbase.client.SimpleHbaseClient;
import com.alipay.simplehbase.client.rowkey.RowKeyUtil;
import com.qingting.customer.common.pojo.hbasedo.Area;
import com.qingting.customer.dao.AreaDAO;
import com.qingting.customer.dao.util.Common;
import com.qingting.customer.dao.util.SHCUtil;
import com.qingting.customer.hbase.doandkey.SimpleHbaseDOWithKeyResult;
import com.qingting.customer.hbase.rowkey.RowKey;

@Repository("areaDAO")
public class AreaDAOImpl implements AreaDAO {
	
	private static SimpleHbaseClient tClient=SHCUtil.getSHC("area");
	private final static String SEQUENCE="area_id_seq";
	private final static byte dataVersion=0;
	
	
	
	private static RowKey createRowKey(String cityCode,String code){
		return RowKeyUtil.getRowKey(cityCode,code);
	}
	private static List<Area> setContentOfRowKey(List<SimpleHbaseDOWithKeyResult<Area>> listHbase){
		List<Area> list=new ArrayList<Area>();
		for (SimpleHbaseDOWithKeyResult<Area> result : listHbase) {
			Area Area = result.getT();
			byte[] rowkey=result.getRowKey().toBytes();
			Area.setCityCode(new String(rowkey,0,6));
			Area.setCode(new String(rowkey,6,6));
			list.add(Area);
		}
		return list;
	}
	@Override
	public Area get(Integer rk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Area t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Area t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Collection<Integer> rkList) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertAreaList(List<Area> areaList) {
		List<PutRequest<Area>> list=new ArrayList<PutRequest<Area>>();
		for (Area Area : areaList) {
			list.add(new PutRequest<Area>(createRowKey(Area.getCityCode(),Area.getCode()), Area));
		}
		tClient.putObjectList(list);
	}

	@Override
	public List<Area> listArea(String cityCode) {
		List<Area> list=null;
		if(cityCode==null || cityCode.equals(""))//城市代码空，查所有
			list=setContentOfRowKey(
				tClient.findObjectAndKeyList(RowKeyUtil.getStringStringMinRowKey(6,6), RowKeyUtil.getStringStringMaxRowKey(6,6), Area.class)
				);
		else
			list=setContentOfRowKey(
					tClient.findObjectAndKeyList(RowKeyUtil.getRowKey(cityCode,Common.MINCITYCODE), RowKeyUtil.getRowKey(cityCode,Common.MAXCITYCODE), Area.class)
					);
		return list;
	}

}
