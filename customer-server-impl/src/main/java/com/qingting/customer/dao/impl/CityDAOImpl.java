package com.qingting.customer.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.alipay.simplehbase.client.PutRequest;
import com.alipay.simplehbase.client.QueryExtInfo;
import com.alipay.simplehbase.client.SimpleHbaseClient;
import com.alipay.simplehbase.client.rowkey.RowKeyUtil;
import com.alipay.simplehbase.util.FilterUtils;
import com.smart.mvc.model.Pagination;
import com.smart.mvc.util.StringUtils;
import com.qingting.customer.dao.CityDAO;
import com.qingting.customer.dao.util.Common;
import com.qingting.customer.dao.util.SHCUtil;
import com.qingting.customer.hbase.doandkey.SimpleHbaseDOWithKeyResult;
import com.qingting.customer.hbase.rowkey.RowKey;
import com.qingting.customer.model.Area;
import com.qingting.customer.model.City;

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
			city.setProvinceCode(new String(rowkey,0,6));//省编码
			city.setCode(new String(rowkey,6,6));//自身编号
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
	public Pagination<City> listCity(String proCode,String code,Integer pageNo,Integer pageSize){
		QueryExtInfo queryExtInfo = new QueryExtInfo();
		queryExtInfo.setLimit((pageNo-1)*pageSize, pageSize);
		Pagination<City> page=new Pagination<City>();
		List<City> list=null;
		System.out.println("省代码:"+(proCode!=null?proCode:null)+".length:"+(proCode!=null?proCode.length():null)+".");
		System.out.println("市代码:"+(code!=null?code:null)+".length:"+(code!=null?code.length():null)+".");
		if( StringUtils.isBlank(proCode) && StringUtils.isBlank(code)){//都为空
			list=setContentOfRowKey(
				tClient.findObjectAndKeyList(RowKeyUtil.getStringStringMinRowKey(6,6), RowKeyUtil.getStringStringMaxRowKey(6,6), City.class,queryExtInfo)
				);
			page.setRowCount(tClient.count(RowKeyUtil.getStringStringMinRowKey(6,6), RowKeyUtil.getStringStringMaxRowKey(6,6), null));
		}else if(!StringUtils.isBlank(proCode) && StringUtils.isBlank(code)){//省不为空，自身代码空
			list=setContentOfRowKey(
					tClient.findObjectAndKeyList(RowKeyUtil.getRowKey(proCode,Common.MINCITYCODE), RowKeyUtil.getRowKey(proCode,Common.MAXCITYCODE), City.class,FilterUtils.getContainFilter(proCode),queryExtInfo)
					);
			page.setRowCount(tClient.count(RowKeyUtil.getRowKey(proCode,Common.MINCITYCODE), RowKeyUtil.getRowKey(proCode,Common.MAXCITYCODE),FilterUtils.getContainFilter(proCode)));
		}else if(StringUtils.isBlank(proCode) && !StringUtils.isBlank(code)){//省代码空，自身代码不为空
			list=setContentOfRowKey(
					tClient.findObjectAndKeyList(RowKeyUtil.getRowKey(Common.MINCITYCODE,code), RowKeyUtil.getRowKey(Common.MAXCITYCODE,code), City.class,FilterUtils.getContainFilter(code),queryExtInfo)
					);
			page.setRowCount(tClient.count(RowKeyUtil.getRowKey(Common.MINCITYCODE,code), RowKeyUtil.getRowKey(Common.MAXCITYCODE,code),FilterUtils.getContainFilter(code)));
		}else{//都不为空
			list=setContentOfRowKey(
					tClient.findObjectAndKeyList(RowKeyUtil.getRowKey(proCode,code), RowKeyUtil.lastByteOfRowKeyPlusOne(RowKeyUtil.getRowKey(proCode,code)), City.class,queryExtInfo)
					);
			page.setRowCount(tClient.count(RowKeyUtil.getRowKey(proCode,code), RowKeyUtil.lastByteOfRowKeyPlusOne(RowKeyUtil.getRowKey(proCode,code)),null));
		}
		if(list!=null){
			page.setList(list);
			page.setPageNo(pageNo);
			page.setPageSize(pageSize);
			return page;
		}else{
			return null;
		}
	}
	
}
