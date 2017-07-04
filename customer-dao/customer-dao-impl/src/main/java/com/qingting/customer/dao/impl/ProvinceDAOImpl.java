package com.qingting.customer.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.stereotype.Repository;

import com.alipay.simplehbase.client.PutRequest;
import com.alipay.simplehbase.client.SimpleHbaseClient;
import com.alipay.simplehbase.client.rowkey.RowKeyUtil;
import com.qingting.customer.common.pojo.hbasedo.Province;
import com.qingting.customer.dao.ProvinceDAO;
import com.qingting.customer.dao.util.SHCUtil;
import com.qingting.customer.hbase.doandkey.SimpleHbaseDOWithKeyResult;
import com.qingting.customer.hbase.rowkey.RowKey;


@Repository("provinceDAO")
public class ProvinceDAOImpl implements ProvinceDAO {
	
	private static SimpleHbaseClient tClient=SHCUtil.getSHC("province");
	private final static String SEQUENCE="province_id_seq";
	private final static byte dataVersion=0;
	
	/**
	 * RowKey=ID(4字节)
	 */
	private static RowKey createRowKey(Integer num){
		return RowKeyUtil.getRowKey(num);
	}
	private static List<Province> setContentOfRowKey(List<SimpleHbaseDOWithKeyResult<Province>> listHbase){
		List<Province> list=new ArrayList<Province>();
		for (SimpleHbaseDOWithKeyResult<Province> result : listHbase) {
			Province province = result.getT();
			byte[] rowkey=result.getRowKey().toBytes();
			province.setId(Bytes.toInt(rowkey));
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
			list.add(new PutRequest<Province>(createRowKey(province.getId()), province));
		}
		tClient.putObjectList(list);
	}

	@Override
	public List<Province> listProvince(Integer id,String code) {
		List<Province> list=null;
		if(id==null && code==null)
			list=setContentOfRowKey(
				tClient.findObjectAndKeyList(RowKeyUtil.getMinRowKey(0), RowKeyUtil.getMaxRowKey(0), Province.class)
				);
		else if(id!=null)
			list=setContentOfRowKey(
					tClient.findObjectAndKeyList(RowKeyUtil.getMinRowKey(id), RowKeyUtil.getMaxRowKey(id), Province.class)
					);
		else
			list=setContentOfRowKey(
					tClient.findObjectAndKeyList(RowKeyUtil.getMinRowKey(0), RowKeyUtil.getMaxRowKey(0), Province.class)
					);
		return list;
	}

}
