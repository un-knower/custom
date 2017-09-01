package com.qingting.customer.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.RegexStringComparator;
import org.apache.hadoop.hbase.filter.RowFilter;
import org.springframework.stereotype.Repository;

import com.alipay.simplehbase.client.PutRequest;
import com.alipay.simplehbase.client.QueryExtInfo;
import com.alipay.simplehbase.client.SimpleHbaseClient;
import com.alipay.simplehbase.client.rowkey.RowKeyUtil;
import com.alipay.simplehbase.util.FilterUtils;
import com.qingting.customer.common.pojo.common.StringUtils;
import com.qingting.customer.common.pojo.hbasedo.Area;
import com.qingting.customer.common.pojo.hbasedo.User;
import com.qingting.customer.common.pojo.model.Pagination;
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
			Area.setCityCode(new String(rowkey,0,6));//上级城市编号
			Area.setCode(new String(rowkey,6,6));//后六个自身编号
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
	public Pagination<Area> listArea(String cityCode,String code,Integer pageNo,Integer pageSize) {
		System.out.println("市代码:"+(cityCode!=null?cityCode:null)+".length:"+(cityCode!=null?cityCode.length():null)+".");
		System.out.println("区代码:"+(code!=null?code:null)+".length:"+(code!=null?code.length():null)+".");
		System.out.println("pageNo:"+pageNo+".pageSize:"+pageSize);
		QueryExtInfo queryExtInfo = new QueryExtInfo();
		queryExtInfo.setLimit((pageNo-1)*pageSize, pageSize);
		List<Area> list=null;
		Pagination<Area> page=new Pagination<Area>();
		if(StringUtils.isBlank(cityCode) && StringUtils.isBlank(code)){//都为空（查所有）
			list=setContentOfRowKey(
				tClient.findObjectAndKeyList(RowKeyUtil.getStringStringMinRowKey(6,6), RowKeyUtil.getStringStringMaxRowKey(6,6), Area.class,queryExtInfo)
				);
			page.setRowCount(tClient.count(RowKeyUtil.getStringStringMinRowKey(6,6), RowKeyUtil.getStringStringMaxRowKey(6,6), null));
		}else if(!StringUtils.isBlank(cityCode) && StringUtils.isBlank(code)){//市编码不为空，自身编码空（查市下边的所有区）
			list=setContentOfRowKey(
					tClient.findObjectAndKeyList(RowKeyUtil.getRowKey(cityCode,Common.MINCITYCODE), RowKeyUtil.getRowKey(cityCode,Common.MAXCITYCODE), Area.class,FilterUtils.getContainFilter(cityCode),queryExtInfo)
					);
			page.setRowCount(tClient.count(RowKeyUtil.getRowKey(cityCode,Common.MINCITYCODE), RowKeyUtil.getRowKey(cityCode,Common.MAXCITYCODE), FilterUtils.getContainFilter(cityCode)));
		}else if(StringUtils.isBlank(cityCode) && !StringUtils.isBlank(code)){//市编码空，自身不为空（查指定的区）
			list=setContentOfRowKey(
					tClient.findObjectAndKeyList(RowKeyUtil.getRowKey(Common.MINCITYCODE,code), RowKeyUtil.getRowKey(Common.MAXCITYCODE,code), Area.class,FilterUtils.getContainFilter(code),queryExtInfo)
					);
			page.setRowCount(tClient.count(RowKeyUtil.getRowKey(Common.MINCITYCODE,code), RowKeyUtil.getRowKey(Common.MAXCITYCODE,code), FilterUtils.getContainFilter(code)));
		}else{//都不为空
			list=setContentOfRowKey(
					tClient.findObjectAndKeyList(RowKeyUtil.getRowKey(cityCode,code), RowKeyUtil.lastByteOfRowKeyPlusOne(RowKeyUtil.getRowKey(cityCode,code)), Area.class,null,queryExtInfo)
					);
			page.setRowCount(tClient.count(RowKeyUtil.getRowKey(cityCode,code), RowKeyUtil.lastByteOfRowKeyPlusOne(RowKeyUtil.getRowKey(cityCode,code)), null));
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
