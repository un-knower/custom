package com.qingting.customer.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.filter.FilterList.Operator;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.alipay.simplehbase.client.QueryExtInfo;
import com.alipay.simplehbase.client.SimpleHbaseClient;
import com.alipay.simplehbase.client.rowkey.RowKeyUtil;
import com.alipay.simplehbase.client.rowkey.StringRowKey;
import com.alipay.simplehbase.sequence.RedisSerialNum;
import com.alipay.simplehbase.util.FilterUtils;
import com.alipay.simplehbase.util.HbaseOriginService;
import com.qingting.customer.model.common.AttentStatus;
import com.qingting.customer.model.common.FindEquipType;
import com.qingting.customer.model.common.StringUtils;
import com.qingting.customer.model.hbasedo.Attention;
import com.qingting.customer.model.hbasedo.Equip;
import com.qingting.customer.model.hbasedo.Message;
import com.qingting.customer.model.page.Pagination;
import com.qingting.customer.model.util.RandomUtil;
import com.qingting.customer.dao.EquipDAO;
import com.qingting.customer.dao.util.SHCUtil;
import com.qingting.customer.hbase.doandkey.SimpleHbaseDOWithKeyResult;
import com.qingting.customer.hbase.rowkey.RowKey;

@Repository("equipDAO")
public class EquipDAOImpl implements EquipDAO {
	@Resource(name="redisTemplate")
	public RedisTemplate<String, Integer> redisTemplate;
	
	private static SimpleHbaseClient tClient=SHCUtil.getSHC("equip");
	
	private static HbaseOriginService index=new HbaseOriginService("equipIndex",
			new String[]{"eif"},
			new byte[][]{
	});
	private static HbaseOriginService idIndex=new HbaseOriginService("idIndex",
			new String[]{"iif"},
			new byte[][]{
	});
	private static HbaseOriginService userEquipIndex=new HbaseOriginService("userEquipIndex",
			new String[]{"ueif"},
			new byte[][]{
	});
	private static HbaseOriginService userTopEquipIndex=new HbaseOriginService("userTopEquipIndex",
			new String[]{"utei"},
			new byte[][]{
	});
	
	private final static String SEQUENCE="equip_id_seq";
	private final static int RANDOM_LENGTH=2;
	private final static int EQUIP_CODE_LENGTH=12;
	
	private static RowKey createRowKey(String equipCode){
		return RowKeyUtil.getRowKey(RandomUtil.getRandomCode(RANDOM_LENGTH),equipCode);
	}
	private static RowKey createIndexRowKey(String equipCode){
		return RowKeyUtil.getRowKey(equipCode);
	}
	private static RowKey createUserEquipIndexRowKey(Integer userId,String equipCode){
		return RowKeyUtil.getRowKey(userId,equipCode);
	}
	
	
	private static List<Equip> setContentOfRowKey(List<SimpleHbaseDOWithKeyResult<Equip>> listHbase){
		List<Equip> list=new ArrayList<Equip>();
		for (SimpleHbaseDOWithKeyResult<Equip> result : listHbase) {
			Equip equip = result.getT();
			/*byte[] rowkey=result.getRowKey().toBytes();
			
			equip.setRowKey(result.getRowKey().toString());
			
			byte[] equipCode=new byte[EQUIP_CODE_LENGTH];
			System.arraycopy(rowkey, RANDOM_LENGTH, equipCode, 0, rowkey.length-RANDOM_LENGTH);//中间mobile
			equip.setEquipCode(new String(equipCode));
			
			byte[] userId=new byte[4];
			System.arraycopy(rowkey, RANDOM_LENGTH+EQUIP_CODE_LENGTH, userId, 0, 4);//后4个字节id
			equip.setUserId(Bytes.toInt(userId));*/
			
			list.add(equip);
		}
		return list;
	}
	
	@Override
	public void insertEquip(Equip equip) {
		int num=RedisSerialNum.getSerialNum(redisTemplate, SEQUENCE);
		equip.setId(num);
		equip.setIsOpen(false);
		equip.setIsTop(false);
		equip.setCreateTime(Calendar.getInstance());
		RowKey equipCodeIndexRowKey=createIndexRowKey(equip.getEquipCode());
		RowKey idIndexRowKey=RowKeyUtil.getRowKey(num);
		RowKey value=createRowKey(equip.getEquipCode());
		index.put(equipCodeIndexRowKey, "eif", "value", value.toBytes());
		idIndex.put(idIndexRowKey, "iif", "value", value.toBytes()); 
		tClient.putObject(value, equip);
	}
	public void initTopEquip(Integer userId,String type,String equipCode){
		System.out.println("initTopEquip中userId:"+userId);
		RowKey userTopEquipRowKey = RowKeyUtil.getRowKey(userId);
		RowKey indexGet = userTopEquipIndex.indexGet(userTopEquipRowKey, null, null, "code");
		if(indexGet==null){//用户还没有置顶设备
			/*List<RowKey> rowKeyOfUserEquip = getRowKeyOfUserEquip(userId);
			if(rowKeyOfUserEquip.size()<1){//用户不存在自己的设备
				
			}*/
			//更新用户置顶设备表
			putUserTopEquipIndex(userId,type,equipCode);
			//更新我的设备或关注的设备中的置顶标志
			if(type.equals(FindEquipType.MINE.getType())){//更新我的设备中的置顶标志
				RowKey indexRowKey=index.indexGet(createIndexRowKey(equipCode), null, null, "value");
				tClient.put(indexRowKey, "ef", "isTop", new byte[]{(byte)0xFF});
			}else if(type.equals(FindEquipType.ATTENT.getType())){//更新关注的设备中的置顶标志
				RowKey indexRowKey=attentIndex.indexGet(createAttentIndexRowKey(userId,equipCode), 
						FilterUtils.getSingleColumnValueFilter("aif", "status",new byte[]{AttentStatus.PASS.getValue()})
						, null, "value");
				attentTClient.put(indexRowKey, "af", "isTop", new byte[]{(byte)0xFF});
			}else{
				throw new RuntimeException("用户置顶设备表中的类型(不是mine或attent)异常.");
			}
		}
	}
	/**
	 * 给设备绑定用户,如果设备存在了用户,则删除用户,绑定新用户
	 */
	@Override
	public void updateUserOfEquip(Integer userId,String equipCode){
		RowKey indexRowKey=index.indexGet(createIndexRowKey(equipCode), null, null, "value");
		if(indexRowKey!=null){
			//查看该设备是否存在了用户
			RowKey rowKey = getRowKeyOfUserEquip(equipCode);
			if(rowKey!=null){//存在则删除
				userEquipIndex.delete(rowKey);
			}
			//创建新索引行键
			RowKey userIndexRowKey=createUserEquipIndexRowKey(userId,equipCode);
			//插入用户与设备关联索引
			userEquipIndex.put(userIndexRowKey, "ueif", "value", indexRowKey.toBytes());
			//更新设备表的用户ID
			tClient.put(indexRowKey, "ef", "userId", Bytes.toBytes(userId));
			initTopEquip(userId,FindEquipType.MINE.getType(),equipCode);
		}else{
			throw new RuntimeException("设备不存在.");
		}
	}
	/**
	 * 给设备绑定用户,如果设备存在了用户,则返回提示信息,不存在则绑定
	 */
	@Override
	public String updateUserOfNewEquip(Integer userId,String equipCode){
		RowKey indexRowKey=index.indexGet(createIndexRowKey(equipCode), null, null, "value");
		if(indexRowKey!=null){
			//查看该设备是否存在了用户
			RowKey rowKey = getRowKeyOfUserEquip(equipCode);
			if(rowKey!=null){//存在则删除
				//userEquipIndex.delete(rowKey);
				return "设备已存在用户，请联系管理员";
			}
			//创建新索引行键
			RowKey userIndexRowKey=createUserEquipIndexRowKey(userId,equipCode);
			//插入用户与设备关联索引
			userEquipIndex.put(userIndexRowKey, "ueif", "value", indexRowKey.toBytes());
			//更新设备表的用户ID
			tClient.put(indexRowKey, "ef", "userId", Bytes.toBytes(userId));
			initTopEquip(userId,FindEquipType.MINE.getType(),equipCode);
		}else{
			throw new RuntimeException("设备不存在.");
		}
		return null;
	}
	/**
	 * 绑定设备的（用户、滤芯组合、水源）,如果设备存在了用户,则删除用户,绑定新用户
	 */
	@Override
	public void updateUserAndRelevanceOfEquip(Integer userId,Integer filterGroupId,Integer waterAreaId,String equipCode){
		RowKey indexRowKey=index.indexGet(createIndexRowKey(equipCode), null, null, "value");
		if(indexRowKey!=null){
			//查看该设备是否存在了用户
			RowKey rowKey = getRowKeyOfUserEquip(equipCode);
			if(rowKey!=null){//存在则删除
				userEquipIndex.delete(rowKey);
			}
			//创建新索引行键
			RowKey userIndexRowKey=createUserEquipIndexRowKey(userId,equipCode);
			//插入用户与设备关联索引
			userEquipIndex.put(userIndexRowKey, "ueif", "value", indexRowKey.toBytes());
			//更新设备表的用户ID
			tClient.put(indexRowKey, "ef", new String[]{"userId","filterGroupId","waterAreaId"}, new byte[][]{Bytes.toBytes(userId),Bytes.toBytes(filterGroupId),Bytes.toBytes(waterAreaId)});
			initTopEquip(userId,FindEquipType.MINE.getType(),equipCode);
		}else{
			throw new RuntimeException("设备不存在.");
		}
	}
	/**
	 * 绑定设备的（用户、滤芯组合、水源）,如果设备存在了用户,则返回提示信息,不存在则绑定
	 */
	@Override
	public String updateUserAndRelevanceOfNewEquip(Integer userId,Integer filterGroupId,Integer waterAreaId,String equipCode){
		RowKey indexRowKey=index.indexGet(createIndexRowKey(equipCode), null, null, "value");
		if(indexRowKey!=null){
			//查看该设备是否存在了用户
			RowKey rowKey = getRowKeyOfUserEquip(equipCode);
			if(rowKey!=null){//存在则删除
				//userEquipIndex.delete(rowKey);
				System.out.println("设备已存在用户，请联系管理员");
				return "设备已存在用户，请联系管理员";
			}
			//创建新索引行键
			RowKey userIndexRowKey=createUserEquipIndexRowKey(userId,equipCode);
			//插入用户与设备关联索引
			userEquipIndex.put(userIndexRowKey, "ueif", "value", indexRowKey.toBytes());
			//更新设备表的用户ID
			tClient.put(indexRowKey, "ef", new String[]{"userId","filterGroupId","waterAreaId"}, new byte[][]{Bytes.toBytes(userId),Bytes.toBytes(filterGroupId),Bytes.toBytes(waterAreaId)});
			initTopEquip(userId,FindEquipType.MINE.getType(),equipCode);
		}else{
			throw new RuntimeException("设备不存在.");
		}
		return null;
	}
	/**
	 * 查询设备索引的RowKey
	 */
	/*public RowKey getIndexRowKeyOfEquip(String equipCode){
		List<RowKey> listRowKey=index.indexScan(createIndexRowKey(equipCode,Integer.MIN_VALUE), createIndexRowKey(equipCode,Integer.MAX_VALUE), FilterUtils.getSuffixFilter(equipCode), null, "value");
		if(listRowKey.size()==1){
			return listRowKey.get(0);
		}else if(listRowKey.size()==0){
			return null;
		}else{
			throw new RuntimeException("系统错误，一个设备存在多个所属用户.");
		}
	}*/
	/**
	 * 查询用户和设备关联索引中的用户ID(如果存在)，不存在则返回null
	 */
	@Override
	public Integer getUserIdOfUserEquip(String equipCode){
		//查看该设备是否存在了用户
		//List<RowKey> listRowKey=userEquipIndex.indexScan(createUserEquipIndexRowKey(Integer.MIN_VALUE,equipCode), createUserEquipIndexRowKey(Integer.MAX_VALUE,equipCode), FilterUtils.getSuffixFilter(equipCode), null, "value");
		List<RowKey> listRowKey=userEquipIndex.indexScanOfRowKey(createUserEquipIndexRowKey(0,equipCode), createUserEquipIndexRowKey(Integer.MAX_VALUE,equipCode), FilterUtils.getSuffixFilter(equipCode), null);
		if(listRowKey.size()==1){
			byte[] bytes = listRowKey.get(0).toBytes();
			byte[] userId=new byte[4];
			System.arraycopy(bytes, 0, userId, 0, 4);//前4个字节是用户ID
			for (byte b : userId) {
				System.out.println((b&0xFF)+" ");
			}
			return (userId[0]<<24) |
					(userId[1]<<16) |
					(userId[2]<<8) |
					userId[3];
		}else if(listRowKey.size()==0){
			return null;
		}else{
			throw new RuntimeException("系统错误，一个设备存在多个所属用户.");
		}
			
	}
	@Override
	public String getEquipCodeOfNew(String preCode){
		QueryExtInfo queryExtInfo = new QueryExtInfo();
		RowKey startRowKey=null;
		RowKey endRowKey=null;
		queryExtInfo.setLimit(0,1);
		queryExtInfo.setReversed(true);
		startRowKey=RowKeyUtil.getRowKey("000000000000");
		endRowKey=RowKeyUtil.getRowKey("zzzzzzzzzzzz");
		List<RowKey> rowKey = index.indexScanOfRowKey(startRowKey, endRowKey, FilterUtils.getPrefixFilter(preCode), queryExtInfo);
		if(rowKey.size()>0){
			System.out.println("查找到的rowKey.size:"+rowKey.size());
			System.out.println("get(0):"+Bytes.toString(rowKey.get(0).toBytes()));
			return Bytes.toString(rowKey.get(0).toBytes());
		}else{
			return null;
		}
	}
	/**
	 * 查询用户和设备关联索引中的行键(返回的equipIndex的RowKey)(如果存在)，不存在则返回null
	 */
	public RowKey getRowKeyOfUserEquip(String equipCode){
		
		//查看该设备是否存在了用户
		List<RowKey> listRowKey=userEquipIndex.indexScan(createUserEquipIndexRowKey(0,equipCode), createUserEquipIndexRowKey(Integer.MAX_VALUE,equipCode), FilterUtils.getSuffixFilter(equipCode), null, "value");
		for (RowKey rowKey : listRowKey) {
			System.out.println("用户和设备索引行键:"+new String(rowKey.toBytes()));
		}
		if(listRowKey.size()==1){
			return listRowKey.get(0);
		}else if(listRowKey.size()==0){
			return null;
		}else{
			throw new RuntimeException("系统错误，一个设备存在多个所属用户.");
		}	
	}
	/**
	 * 获得用户对应的所有设备索引
	 */
	public List<RowKey> getRowKeyOfUserEquip(Integer userId){
		return userEquipIndex.indexScan(RowKeyUtil.getRowKey(userId,"000000000000"), RowKeyUtil.getRowKey(userId,"zzzzzzzzzzzz"), FilterUtils.getPrefixFilter(userId), null, "value");
	}
	@Override
	public void deleteEquipByEquipCode(String equipCode) {
		RowKey indexRowKey=index.indexGet(createIndexRowKey(equipCode), null, null, "value");
		if(indexRowKey!=null){
			index.delete(indexRowKey);
			RowKey userEquipIndexRowKey=getRowKeyOfUserEquip(equipCode);
			if(userEquipIndexRowKey!=null){
				userEquipIndex.delete(userEquipIndexRowKey);
			}else{
				System.out.println("设备没有与用户关联");
			}
			tClient.delete(indexRowKey);
		}else{
			throw new RuntimeException("设备对应的索引不存在");
		}
		
	}

	@Override
	public void updateEquipByEquipCode(Equip equip) {
		//tClient.updateObjectWithVersion(new StringRowKey(equip.getRowKey()), equip, dataVersion);
		RowKey indexRowKey=index.indexGet(createIndexRowKey(equip.getEquipCode()), null, null, "value");
		tClient.putObject(indexRowKey, equip);
	}
	/**
	 * 后台查询设备，待核实实用性
	 */
	@Override
	public Pagination<Equip> listEquipByEquipCodeAndUserId(Pagination<Equip> page) {
		
		QueryExtInfo queryExtInfo = new QueryExtInfo();
		List<RowKey> listRowKey=null;
		List<Equip> list=null;
		Map<String, Object> map=null;
		
		Integer userId=null;
		String equipCode=null;
		
		Integer lastPageNo=null;
		Integer realityCount=null;
		if(page.getMap()!=null){
			map=page.getMap();
			/*if(map.get("endId")!=null)
				endId=(Long)map.get("endId");*/
			if(map.get("userId")!=null)
				userId=(Integer)map.get("userId");
			if(map.get("equipCode")!=null)
				equipCode=(String)map.get("equipCode");
			if(map.get("lastPageNo")!=null)
				lastPageNo=(Integer)map.get("lastPageNo");
			if(map.get("realityCount")!=null)
				realityCount=(Integer)map.get("realityCount");
		}else{
			map=new HashMap<String,Object>();
		}
		
		RowKey startRowKey=null;
		RowKey endRowKey=null;
		
		
		
		/*if(page.getPageNo()==1){//首页
			System.out.println("首页.");
			queryExtInfo.setLimit(0, page.getPageSize());
			
			startRowKey=RowKeyUtil.getRowKey("000000000000");
			endRowKey=RowKeyUtil.getRowKey("zzzzzzzzzzzz");
			//listRowKey=index.indexScan(startRowKey,endRowKey,null,queryExtInfo, "value");
		}else if(page.getPageNo()==lastPageNo+1){//下一页
			System.out.println("下一页.");
			if(!StringUtils.isZeroOrNull(userId) && !StringUtils.isBlank(equipCode)){
				startRowKey=createIndexRowKey(userId, sortCode, endId);
				queryExtInfo.setLimit(0, page.getPageSize());
			}else{
				startRowKey=RowKeyUtil.getIntStringLongMinRowKey(SORTCODE_LENGTH);
				queryExtInfo.setLimit((page.getPageNo()-1)*page.getPageSize(), page.getPageSize());
			}
			endRowKey=RowKeyUtil.getIntStringLongMaxRowKey(SORTCODE_LENGTH);
			
			//listRowKey=index.indexScan(startRowKey,endRowKey,null,queryExtInfo, "value");
		}else if(page.getPageNo()==lastPageNo-1){//上一页
			System.out.println("上一页.");
			
			startRowKey=RowKeyUtil.getIntStringLongMinRowKey(SORTCODE_LENGTH);
			if(!StringUtils.isZeroOrNull(endId) && !StringUtils.isZeroOrNull(userId) && !StringUtils.isBlank(sortCode)){
				endRowKey=createIndexRowKey(userId, sortCode, endId);
				queryExtInfo.setLimit(realityCount, page.getPageSize());
				queryExtInfo.setReversed(true);
			}else{
				endRowKey=RowKeyUtil.getIntStringLongMaxRowKey(SORTCODE_LENGTH);
				queryExtInfo.setLimit((page.getPageNo()-1)*page.getPageSize(), page.getPageSize());
			}
			//listRowKey=index.indexScan(startRowKey,endRowKey,null,queryExtInfo, "value");
		}else if(page.getPageNo()==page.getPageCount()){//尾页
			System.out.println("尾页.");
			queryExtInfo.setLimit(0,page.getPageSize());
			queryExtInfo.setReversed(true);
			
			startRowKey=RowKeyUtil.getIntStringLongMinRowKey(SORTCODE_LENGTH);
			endRowKey=RowKeyUtil.getIntStringLongMaxRowKey(SORTCODE_LENGTH);
			//listRowKey=index.indexScan(startRowKey,endRowKey,null,queryExtInfo,"value");
		}else{//跳页查询
			System.out.println("跳页查询.");
			queryExtInfo.setLimit((page.getPageNo()-1)*page.getPageSize(), page.getPageSize());
			
			startRowKey=RowKeyUtil.getIntStringLongMinRowKey(SORTCODE_LENGTH);
			endRowKey=RowKeyUtil.getIntStringLongMaxRowKey(SORTCODE_LENGTH);
			//listRowKey=index.indexScan(startRowKey,endRowKey,null,queryExtInfo,"value");
		}*/
		
		queryExtInfo.setLimit((page.getPageNo()-1)*page.getPageSize(), page.getPageSize());
		
		startRowKey=RowKeyUtil.getRowKey("000000000000");
		endRowKey=RowKeyUtil.getRowKey("zzzzzzzzzzzz");
		
		
		
		
		listRowKey=index.indexScan(startRowKey,endRowKey,null,queryExtInfo,"value");
		page.setRowCount(index.count(RowKeyUtil.getRowKey("000000000000"),RowKeyUtil.getRowKey("zzzzzzzzzzzz"), null));
		System.out.println("设备索引:");
		for (RowKey rowKey : listRowKey) {
			System.out.println(new String(rowKey.toBytes()));
		}
		System.out.println(".");
		list=setContentOfRowKey(
				tClient.findObjectAndKeyBatch(listRowKey,Equip.class)
				);
		
		/*if(map.get("rowKeyList")!=null){
			System.out.println("行键查询结束.");
			for (RowKey rowKey : (List<RowKey>)map.get("rowKeyList")) {
				System.out.println("查询到的行键:");
				for (byte b : rowKey.toBytes()) {
					System.out.print(b+" ");
				}
				System.out.println(".");
			}
			listRowKey = (List<RowKey>)map.get("rowKeyList");
			list=setContentOfRowKey(
					tClient.findObjectAndKeyBatch(listRowKey,Message.class)
					);
			
		}*/
		
		map.put("realityCount", listRowKey.size());//返回的实际数据条数
		map.put("lastPageNo", page.getPageNo());//更新上一次的页码为本次请求页码
		page.setMap(map);
		page.setList(list);
		return page;
		
		/*queryExtInfo.setLimit((pageNo-1)*pageSize, pageSize);
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
		return page;*/
		
	}
	/**
	 * 前端查询我的设备
	 */
	@Override
	public List<Equip> listEquip(Integer userId){
		List<RowKey> listRowKey = getRowKeyOfUserEquip(userId);
		System.out.println("userId:"+userId);
		System.out.println("EquipDAOImpl中listEquip中listRowKey：");
		if(listRowKey!=null){
			for (RowKey rowKey : listRowKey) {
				System.out.println(new String(rowKey.toBytes()));
			}
		}
		
		if(listRowKey!=null && listRowKey.size()>0)
			return tClient.findObjectBatch(listRowKey, Equip.class);
		else 
			return null;
	}
	@Override
	public int countEquip(Integer userId){
		return getRowKeyOfUserEquip(userId).size();
	}
	/**
	 * 内部用(更新用户的置顶设备)
	 */
	private void putUserTopEquipIndex(Integer userId,String type,String equipCode){
		RowKey rowKey = RowKeyUtil.getRowKey(userId);
		userTopEquipIndex.put(rowKey, "utei", new String[]{"type","code"}, new byte[][]{
			Bytes.toBytes(type),
			Bytes.toBytes(equipCode)
		});
	}
	/**
	 * 精确匹配的设备编号,查询对应的设备信息
	 */
	@Override
	public Equip getEquip(String equipCode){
		RowKey indexRowKey=index.indexGet(createIndexRowKey(equipCode), null, null, "value");
		return tClient.findObject(indexRowKey, Equip.class);
	}
	@Override
	public Equip getEquipById(Integer id) {
		RowKey indexRowKey=idIndex.indexGet(RowKeyUtil.getRowKey(id), null, null, "value");
		return tClient.findObject(indexRowKey, Equip.class);
	}
	/**
	 * 前端页面中关注设备时搜索用
	 */
	@Override
	public List<Equip> searchEquip(String equipCode){
		List<RowKey> listIndexRowKey=index.indexScan(FilterUtils.getContainFilter(equipCode), null, "value");
		//tClient.findObjectMV(rowKey, type, queryExtInfo)
		if(listIndexRowKey.size()>0)
			return tClient.findObjectBatch(listIndexRowKey, Equip.class);
		else
			return null;
	}
	/**
	 * 查询设备是否公开
	 */
	@Override
	public boolean checkIsOpen(String equipCode){
		RowKey indexRowKey=index.indexGet(createIndexRowKey(equipCode), null, null, "value");
		Equip equip = tClient.findObject(indexRowKey, Equip.class);
		return equip.getIsOpen();
	}
	@Override
	public Boolean setOpen(String equipCode,Boolean isOpen){
		RowKey indexRowKey=index.indexGet(createIndexRowKey(equipCode), null, null, "value");
		if(isOpen!=null){
			if(isOpen)
				tClient.put(indexRowKey, "ef", "isOpen", new byte[]{(byte)0xFF});
			else
				tClient.put(indexRowKey, "ef", "isOpen", new byte[]{(byte)0x00});
			return true;	
		}else{
			return null;
		}
	}
	/***********************************************关注的设备*****************************************/
	
	@Resource(name="redisTemplate")
	public RedisTemplate<String, Integer> attentRedisTemplate;
	
	private static SimpleHbaseClient attentTClient=SHCUtil.getSHC("attention");
	
	private static HbaseOriginService attentIndex=new HbaseOriginService("attentionIndex",
			new String[]{"aif"},
			new byte[][]{
	});
	
	private final static String ATTENT_SEQUENCE="attent_id_seq";
	
	private static RowKey createAttentRowKey(String equipCode,Integer id){
		return RowKeyUtil.getRowKey(RandomUtil.getRandomCode(RANDOM_LENGTH),equipCode,id);
	}
	private static RowKey createAttentIndexRowKey(Integer userId,String equipCode){
		return RowKeyUtil.getRowKey(userId,equipCode);
	}
	
	
	/**
	 * 插入关注的设备
	 */
	@Override
	public void insertAttent(Attention attention){
		System.out.println("attention:"+attention);
		int num=RedisSerialNum.getSerialNum(attentRedisTemplate, ATTENT_SEQUENCE);
		attention.setId(num);
		RowKey attentIndexRowKey=createAttentIndexRowKey(attention.getUserId(),attention.getEquipCode());
		RowKey value=createAttentRowKey(attention.getEquipCode(),num);
		attentIndex.put(attentIndexRowKey, "aif", new String[]{"value","status"}, new byte[][]{value.toBytes(),{attention.getStatus()}});
		attentTClient.putObject(value, attention);
	}
	/**
	 * 申请关注处理
	 * userId : 用户ID
	 * equipCode : 用户关注的设备编号
	 */
	@Override
	public void attentHandle(Integer userId,String equipCode,byte status){
		RowKey indexRowKey = attentIndex.indexGet(createAttentIndexRowKey(userId,equipCode), null, null, "value");
		attentTClient.put(indexRowKey, "af", "status", new byte[]{status});
		attentIndex.put(createAttentIndexRowKey(userId,equipCode), "aif", "status", new byte[]{status});
		initTopEquip(userId,FindEquipType.ATTENT.getType(),equipCode);
	}
	/**
	 * 查询用户所有关注的设备信息
	 */
	@Override
	public List<Attention> listAttent(Integer userId){
		List<Filter> filters=new ArrayList<Filter>();
		
		//只查找对应用户的，且已同意关注的设备
		filters.add(FilterUtils.getPrefixFilter(userId));
		filters.add(FilterUtils.getSingleColumnValueFilter("aif", "status",new byte[]{AttentStatus.PASS.getValue()}));
		
		FilterList filterList = new FilterList(Operator.MUST_PASS_ALL, filters);
		List<RowKey> listAttentIndexRowKey=attentIndex.indexScan(createAttentIndexRowKey(userId,"000000000000"), createAttentIndexRowKey(userId,"zzzzzzzzzzzz"),filterList, null, "value");
		return attentTClient.findObjectBatch(listAttentIndexRowKey, Attention.class);
	}
	@Override
	public int countAttent(Integer userId){
		List<Filter> filters=new ArrayList<Filter>();
		
		//只查找对应用户的，且已同意关注的设备
		filters.add(FilterUtils.getPrefixFilter(userId));
		filters.add(FilterUtils.getSingleColumnValueFilter("aif", "status",new byte[]{AttentStatus.PASS.getValue()}));
		
		FilterList filterList = new FilterList(Operator.MUST_PASS_ALL, filters);
		//获得关注索引表的行键
		List<RowKey> listAttentIndexRowKey=attentIndex.indexScanOfRowKey(createAttentIndexRowKey(userId,"000000000000"), createAttentIndexRowKey(userId,"zzzzzzzzzzzz"),filterList, null);
		return listAttentIndexRowKey.size();
	}
	@Override
	public List<Equip> listAttentEquip(Integer userId){
		List<Filter> filters=new ArrayList<Filter>();
		
		//只查找对应用户的，且已同意关注的设备
		filters.add(FilterUtils.getPrefixFilter(userId));
		filters.add(FilterUtils.getSingleColumnValueFilter("aif", "status",new byte[]{AttentStatus.PASS.getValue()}));
		
		FilterList filterList = new FilterList(Operator.MUST_PASS_ALL, filters);
		//获得关注索引表的行键
		List<RowKey> listAttentIndexRowKey=attentIndex.indexScanOfRowKey(createAttentIndexRowKey(userId,"000000000000"), createAttentIndexRowKey(userId,"zzzzzzzzzzzz"),filterList, null);
		
		//这里查询用户的关注设备信息——需要优化
		List<RowKey> listAttentIndex=attentIndex.indexScan(createAttentIndexRowKey(userId,"000000000000"), createAttentIndexRowKey(userId,"zzzzzzzzzzzz"),filterList, null, "value");
		List<Attention> listAttention = attentTClient.findObjectBatch(listAttentIndex, Attention.class);
		
		for (RowKey rowKey : listAttentIndexRowKey) {
			System.out.println("关注索引行键:");
			for (byte b : rowKey.toBytes()) {
				System.out.print(b+" ");
			}
		}
		
		//取出行键中的设备编号，且查出设备的索引行键
		List<RowKey> rowKey=new ArrayList<RowKey>();
		for (RowKey r : listAttentIndexRowKey) {
			byte[] rw=r.toBytes();
			byte[] bytes=new byte[rw.length-4];
			System.arraycopy(r.toBytes(), 4, bytes, 0, rw.length-4);
			//根据设备编号查设备行键索引
			RowKey indexRowKey=index.indexGet(RowKeyUtil.getRowKey(bytes), null, null, "value");
			rowKey.add(indexRowKey);
		}
		for (RowKey r : rowKey) {
			System.out.println("设备索引行键:");
			for (byte b : r.toBytes()) {
				System.out.print(b+" ");
			}
		}
		List<Equip> listEquip = tClient.findObjectBatch(rowKey, Equip.class);
		
		for (Equip equip : listEquip) {
			//将设备的一些信息，替换成 关注信息
			for (Attention attention : listAttention) {
				if(attention.getEquipCode().equals(equip.getEquipCode())){
					equip.setIsTop(attention.getIsTop());
				}
			}
		}
		
		return listEquip;
	}
	
	/**
	 * 
	 * @Title: deleteAttent
	 * @Description: 删除关注信息
	 * @param userId
	 * @param equipCode 
	 * @return void
	 * @throws
	 */
	@Override
	public void deleteAttent(Integer userId,String equipCode){
		
		//如果该设备置顶怎么办？
		RowKey userTopEquipRowKey = RowKeyUtil.getRowKey(userId);
		//查置顶设备的编号(编号的RowKey对象就是设备表的索引行键)
		RowKey equipCodeRowKey = userTopEquipIndex.indexGet(userTopEquipRowKey, null, null, "code");
		if( equipCode.equals( Bytes.toString(equipCodeRowKey.toBytes()) ) ){//关注的设备是置顶设备
			//取消用户当前的对应的置顶设备标志
			//attentTClient.put(indexRowKey, "af", "isTop", new byte[]{(byte)0x00});
			//如果还有关注的设备，则重新将查询的第一个置顶
			List<Attention> listAttent = listAttent(userId);
			if(listAttent.size()>0){
				//将查询的第一个关注设备设置为用户置顶设备
				putUserTopEquipIndex(userId,FindEquipType.ATTENT.getType(),listAttent.get(0).getEquipCode());
			}else{//没有了关注的设备，则看有没有自己的设备
				List<Equip> listEquip = listEquip(userId);
				if(listEquip.size()>0){
					//将查询的第一个用户自己的设备设置为用户置顶设备
					putUserTopEquipIndex(userId,FindEquipType.MINE.getType(),listEquip.get(0).getEquipCode());
				}
			}
		}
		
		RowKey indexRowKey = attentIndex.indexGet(createAttentIndexRowKey(userId,equipCode), null, null, "value");
		attentIndex.delete(createAttentIndexRowKey(userId,equipCode));
		attentTClient.delete(indexRowKey);
	}
	/****************************************************************************************************************************/
	/**
	 * 查用户的置顶设备信息
	 */
	@Override
	public Equip getTopEquip(Integer userId){
		RowKey userTopEquipRowKey = RowKeyUtil.getRowKey(userId);
		//查置顶设备的编号(编号的RowKey对象就是设备表的索引行键)
		RowKey indexRowKey = userTopEquipIndex.indexGet(userTopEquipRowKey, null, null, "code");
		//查设备表的行键
		RowKey rowKey=index.indexGet(indexRowKey, null, null,"value");
		return tClient.findObject(rowKey, Equip.class);
	}
	/**
	 * 将设备置顶
	 */
	@Override
	public void setTop(Integer userId,String type,String equipCode){
		//获得用户当前的置顶设备类型(我的或关注的)和编号
		RowKey userTopEquipRowKey = RowKeyUtil.getRowKey(userId);
		Map<String, byte[]> map = userTopEquipIndex.indexGet(userTopEquipRowKey,"utei",new String[]{"type","code"},null,null);
		String hisType = Bytes.toString(map.get("type"));
		String hisEquipCode =Bytes.toString(map.get("code"));
		System.out.println("hisType:"+hisType);
		System.out.println("hisEquipCode:"+hisEquipCode);
		//取消用户当前的对应的置顶设备标志
		if(hisType.equals(FindEquipType.MINE.getType())){//我的
			RowKey indexRowKey=index.indexGet(createIndexRowKey(hisEquipCode), null, null, "value");
			tClient.put(indexRowKey, "ef", "isTop", new byte[]{(byte)0x00});
		}else if(hisType.equals(FindEquipType.ATTENT.getType())){//关注的
			//RowKey rowKey = getIndexRowKeyOfEquip(equipCode);//查询设备索引的RowKey
			RowKey indexRowKey=attentIndex.indexGet(createAttentIndexRowKey(userId,hisEquipCode), 
					FilterUtils.getSingleColumnValueFilter("aif", "status",new byte[]{AttentStatus.PASS.getValue()})
					, null, "value");
			attentTClient.put(indexRowKey, "af", "isTop", new byte[]{(byte)0x00});
		}else{
			throw new RuntimeException("用户置顶设备表中的类型(不是mine或attent)异常.");
		}
		
		//更新用户置顶设备表
		putUserTopEquipIndex(userId,type,equipCode);
		//更新我的设备或关注的设备中的置顶标志
		if(type.equals(FindEquipType.MINE.getType())){//更新我的设备中的置顶标志
			RowKey indexRowKey=index.indexGet(createIndexRowKey(equipCode), null, null, "value");
			tClient.put(indexRowKey, "ef", "isTop", new byte[]{(byte)0xFF});
		}else if(type.equals(FindEquipType.ATTENT.getType())){//更新关注的设备中的置顶标志
			RowKey indexRowKey=attentIndex.indexGet(createAttentIndexRowKey(userId,equipCode), 
					FilterUtils.getSingleColumnValueFilter("aif", "status",new byte[]{AttentStatus.PASS.getValue()})
					, null, "value");
			attentTClient.put(indexRowKey, "af", "isTop", new byte[]{(byte)0xFF});
		}else{
			throw new RuntimeException("用户置顶设备表中的类型(不是mine或attent)异常.");
		}
	}

}
