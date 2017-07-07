package com.qingting.customer.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.alipay.simplehbase.client.PutRequest;
import com.alipay.simplehbase.client.SimpleHbaseClient;
import com.alipay.simplehbase.client.rowkey.RowKeyUtil;
import com.qingting.customer.common.pojo.hbasedo.City;
import com.qingting.customer.dao.CityDAO;
import com.qingting.customer.dao.util.Common;
import com.qingting.customer.dao.util.SHCUtil;
import com.qingting.customer.hbase.doandkey.SimpleHbaseDOWithKeyResult;
import com.qingting.customer.hbase.rowkey.RowKey;

@Repository("cityDAO")
public class CityDAOImpl implements CityDAO {
	
	private static SimpleHbaseClient tClient=SHCUtil.getSHC("city");
	private final static String SEQUENCE="city_id_seq";
	private final static byte dataVersion=0;
	
	/**
	 * RowKey=ID(4字节)
	 */
	private static RowKey createRowKey(String proCode,String code){
		return RowKeyUtil.getRowKey(proCode,code);
	}
	private static List<City> setContentOfRowKey(List<SimpleHbaseDOWithKeyResult<City>> listHbase){
		List<City> list=new ArrayList<City>();
		for (SimpleHbaseDOWithKeyResult<City> result : listHbase) {
			City city = result.getT();
			byte[] rowkey=result.getRowKey().toBytes();
			city.setProvinceCode(new String(rowkey,0,6));
			city.setCode(new String(rowkey,6,6));
			list.add(city);
		}
		return list;
	}
	
	@Override
	public City get(Integer rk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(City t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(City t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Collection<Integer> rkList) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertCityList(List<City> cityList) {
		List<PutRequest<City>> list=new ArrayList<PutRequest<City>>();
		for (City city : cityList) {
			list.add(new PutRequest<City>(createRowKey(city.getProvinceCode(),city.getCode()), city));
		}
		tClient.putObjectList(list);
	}

	@Override
	public List<City> listCity(String proCode) {
		List<City> list=null;
		if(proCode==null || proCode.equals(""))
			list=setContentOfRowKey(
				tClient.findObjectAndKeyList(RowKeyUtil.getStringStringMinRowKey(6,6), RowKeyUtil.getStringStringMaxRowKey(6,6), City.class)
				);
		else
			list=setContentOfRowKey(
					tClient.findObjectAndKeyList(RowKeyUtil.getRowKey(proCode,Common.MINCITYCODE), RowKeyUtil.getRowKey(proCode,Common.MAXCITYCODE), City.class)
					);
		return list;
	}

}
