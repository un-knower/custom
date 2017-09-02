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
import com.qingting.customer.dao.ProvinceDAO;
import com.qingting.customer.dao.util.Common;
import com.qingting.customer.dao.util.SHCUtil;
import com.qingting.customer.hbase.doandkey.SimpleHbaseDOWithKeyResult;
import com.qingting.customer.hbase.rowkey.RowKey;
import com.qingting.customer.model.Area;
import com.qingting.customer.model.Province;


@Repository("provinceDAO")
public class ProvinceDAOImpl implements ProvinceDAO {
	
	private static SimpleHbaseClient tClient=SHCUtil.getSHC("province");
	private final static String SEQUENCE="province_id_seq";
	private final static byte dataVersion=0;
	
	/**
	 * RowKey=ID(4字节)
	 */
	private static RowKey createRowKey(String code){
		return RowKeyUtil.getRowKey(code);
	}
	private static List<Province> setContentOfRowKey(List<SimpleHbaseDOWithKeyResult<Province>> listHbase){
		List<Province> list=new ArrayList<Province>();
		for (SimpleHbaseDOWithKeyResult<Province> result : listHbase) {
			Province province = result.getT();
			byte[] rowkey=result.getRowKey().toBytes();
			province.setCode(new String(rowkey));
			list.add(province);
		}
		return list;
	}
	@Override
	public Province get(Integer rk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Province t) {
		// TODO Auto-generated method stub
	}

	@Override
	public void update(Province t) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deleteById(Collection<Integer> rkList) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertProvinceList(List<Province> proList) {
		List<PutRequest<Province>> list=new ArrayList<PutRequest<Province>>();
		for (Province province : proList) {
			list.add(new PutRequest<Province>(createRowKey(province.getCode()), province));
		}
		tClient.putObjectList(list);
	}

	@Override
	public Pagination<Province> listProvince(String code,Integer pageNo,Integer pageSize) {
		QueryExtInfo queryExtInfo = new QueryExtInfo();
		queryExtInfo.setLimit((pageNo-1)*pageSize, pageSize);
		Pagination<Province> page=new Pagination<Province>();
		List<Province> list=null;
		System.out.println("省代码:"+(code!=null?code:null)+".length:"+(code!=null?code.length():null)+".");
		if(StringUtils.isBlank(code)){//省代码空（查所有）
			list=setContentOfRowKey(
				tClient.findObjectAndKeyList(RowKeyUtil.getRowKey(Common.MINCITYCODE), RowKeyUtil.getRowKey(Common.MAXCITYCODE), Province.class,queryExtInfo)
				);
			page.setRowCount(tClient.count(RowKeyUtil.getRowKey(Common.MINCITYCODE), RowKeyUtil.getRowKey(Common.MAXCITYCODE), null));
		}else{ //不为空（查对应的省）
			list=setContentOfRowKey(
					tClient.findObjectAndKeyList(RowKeyUtil.getRowKey(code), RowKeyUtil.lastByteOfRowKeyPlusOne(RowKeyUtil.getRowKey(code)), Province.class,FilterUtils.getContainFilter(code),queryExtInfo)
					);
			page.setRowCount(tClient.count(RowKeyUtil.getRowKey(code), RowKeyUtil.lastByteOfRowKeyPlusOne(RowKeyUtil.getRowKey(code)), FilterUtils.getContainFilter(code)));
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
