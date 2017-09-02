package com.qingting.customer.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.alipay.simplehbase.client.QueryExtInfo;
import com.alipay.simplehbase.client.SimpleHbaseClient;
import com.alipay.simplehbase.client.rowkey.RowKeyUtil;
import com.alipay.simplehbase.sequence.RedisSerialNum;
import com.alipay.simplehbase.util.FilterUtils;
import com.alipay.simplehbase.util.HbaseOriginService;
import com.smart.mvc.model.Pagination;
import com.smart.mvc.util.RandomUtil;
import com.smart.mvc.util.StringUtils;
import com.qingting.customer.dao.MessageDAO;
import com.qingting.customer.dao.util.SHCUtil;
import com.qingting.customer.hbase.doandkey.SimpleHbaseDOWithKeyResult;
import com.qingting.customer.hbase.rowkey.RowKey;
import com.qingting.customer.model.Message;
@Repository("messageDAO")
public class MessageDAOImpl implements MessageDAO{
	
	@Resource(name="redisTemplate")
	public RedisTemplate<String, Long> redisTemplate;
	
	private static SimpleHbaseClient tClient=SHCUtil.getSHC("message");
	
	private static HbaseOriginService index=new HbaseOriginService("messageIndex",new String[]{"mif"},null);
	
	private final static String SEQUENCE="messageIndex_id_seq";
	
	private final static int RANDOM_LENGTH=2;
	private final static int SORTCODE_LENGTH=4;
	
	private static RowKey createRowKey(Long millis){
		return RowKeyUtil.getRowKey(RandomUtil.getRandomCode(RANDOM_LENGTH),millis);
	}
	private static RowKey createIndexRowKey(Integer userId,byte sortCode,Long id){
		return RowKeyUtil.getRowKey(userId,sortCode,id);
	}
	private static List<Message> setContentOfRowKey(List<SimpleHbaseDOWithKeyResult<Message>> listHbase){
		List<Message> list=new ArrayList<Message>();
		for (SimpleHbaseDOWithKeyResult<Message> result : listHbase) {
			list.add(getMessageFromResult(result));
		}
		return list;
	}
	
	private static Message getMessageFromResult(SimpleHbaseDOWithKeyResult<Message> result){
		Message message = result.getT();
		byte[] rowkey=result.getRowKey().toBytes();
		System.out.println("getMessageFromResult行键:");
		for (byte b : rowkey) {
			System.out.print(b+" ");
		}
		int timeLength=rowkey.length-RANDOM_LENGTH;
		byte[] createTime=new byte[timeLength];
		System.arraycopy(rowkey, RANDOM_LENGTH, createTime, 0, timeLength);
		Calendar cal=Calendar.getInstance();
		
		long time=Bytes.toLong(createTime);
		
		cal.setTimeInMillis(time);
		message.setCreateTime(cal);
		
		//message.setRowKey(new String(rowkey,Charset.forName("UTF-8")));
		
		return message;
	}
	/**
	 * 因为rowkey经过了散列，插入消息同时，需要插入消息对应的索引，以便查询
	 */
	@Override
	public void insertMessage(Message message) {
		System.out.println("插入信息："+message);
		//MessageIndex messageIndex=new MessageIndex();
		long num=RedisSerialNum.getSerialNumLong(redisTemplate, SEQUENCE);
		message.setId(num);
		message.setCreateTime(Calendar.getInstance());
		
		
		RowKey indexRowKey=createIndexRowKey(message.getUserId(),message.getType(),num);
		RowKey value=createRowKey(message.getCreateTime().getTimeInMillis());
		//String string = new String(value.toBytes(),Charset.forName("UTF-8"));
		//messageIndex.setValue(string);
		
		//indexClient.putObject(indexRowKey, messageIndex);//索引表
		index.put(indexRowKey, "mif", "value", value.toBytes());
		tClient.putObject(value, message);//消息表
	}
	/**
	 * 同时还需删除索引表索引
	 */
	@Override
	public void deleteMessage(List<Message> messages){
		System.out.println("DAO删除信息deleteMessage(List<String> rowkeys)..");
		List<RowKey> rowKeyIndexList = new ArrayList<RowKey>();
		for (Message message : messages) {
			System.out.println("userId:"+message.getUserId()+".sortCode:"+message.getType()+".id:"+message.getId());
			rowKeyIndexList.add(createIndexRowKey(message.getUserId(), message.getType(), message.getId()));
		}
		/*List<RowKey> rowKeylist=setIndexOfRowKey(
			indexClient.findObjectAndKeyBatch(rowKeyIndexList,MessageIndex.class)
		);*/
		//获得信息表对应的行键
		List<RowKey> rowKeylist=index.indexBatchGet(rowKeyIndexList, "mif", "value");
		//删除索引表数据
		index.deleteIndex(rowKeyIndexList);//删除索引
		for (RowKey rowKey : rowKeylist) {
			System.out.println("deleteMessage行健:");
			for (byte b : rowKey.toBytes()) {
				System.out.print(b+" ");
			}
		}
		/*List<RowKey> rowKeylist = new ArrayList<RowKey>();
		for (String string : rowkeys) {
			rowKeylist.add(covertStringToRowKey(string));
			System.out.println("deleteMessage行键:");
			for (byte b : covertStringToRowKey(string).toBytes()) {
				System.out.print((int)(b&0xFF)+" ");
			}
		}*/
		tClient.deleteList(rowKeylist);//删除消息
	}
	
	
	@Override
	public void updateMessage(Message message) {
		//tClient.updateObject(getMessageRowKey(message.getUserId(),message.getSortCode(),message.getId()), message,dataVersion);
		tClient.putObject(index.indexGet(createIndexRowKey(message.getUserId(),message.getType(),message.getId()), null, null, "value"), message);
	}
	
	/*public RowKey getMessageRowKey(Integer userId,String sortCode,Long id){
		SimpleHbaseDOWithKeyResult<MessageIndex> result = indexClient.findObjectAndKey(createIndexRowKey(userId, sortCode, id), MessageIndex.class);
		MessageIndex obj=result.getT();
		return new StringRowKey(obj.getValue());
	}*/
	@Override
	public Message getMessage(Integer userId,Byte type,Long id) {
		return tClient.findObject(index.indexGet(createIndexRowKey(userId,type,id), null, null, "value"), Message.class);
	}
	
	/**
	 * 后台管理查询消息
	 */
	@Override
	public Pagination<Message> listMessage(Pagination<Message> page) {
		QueryExtInfo queryExtInfo = new QueryExtInfo();
		//queryExtInfo.setLimit((pageNo-1)*pageSize, pageSize);
		//queryExtInfo.setLimit((page.getPageNo()-1)*page.getPageSize(), page.getPageSize());
		
		List<RowKey> listRowKey=null;
		List<Message> list=null;
		Map<String, Object> map=null;
		
		Long endId=null;
		Integer userId=null;
		Byte sortCode=0;
		
		Integer lastPageNo=null;
		Integer realityCount=null;
		if(page.getMap()!=null){
			map=page.getMap();
			if(map.get("endId")!=null)
				endId=(Long)map.get("endId");
			if(map.get("userId")!=null)
				userId=(Integer)map.get("userId");
			if(map.get("sortCode")!=null)
				sortCode=(Byte)map.get("sortCode");
			if(map.get("lastPageNo")!=null)
				lastPageNo=(Integer)map.get("lastPageNo");
			if(map.get("realityCount")!=null)
				realityCount=(Integer)map.get("realityCount");
		}else{
			map=new HashMap<String,Object>();
		}
		
		RowKey startRowKey=null;
		RowKey endRowKey=null;
		
		
		if(page.getPageNo()==1){//首页
			System.out.println("首页.");
			queryExtInfo.setLimit(0, page.getPageSize());
			
			startRowKey=RowKeyUtil.getIntStringLongMinRowKey(SORTCODE_LENGTH);
			endRowKey=RowKeyUtil.getIntStringLongMaxRowKey(SORTCODE_LENGTH);
			//listRowKey=index.indexScan(startRowKey,endRowKey,null,queryExtInfo, "value");
		}else if(page.getPageNo()==lastPageNo+1){//下一页
			System.out.println("下一页.");
			if(!StringUtils.isZeroOrNull(endId) && !StringUtils.isZeroOrNull(userId) && !StringUtils.isZeroOrNull(sortCode)){
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
			if(!StringUtils.isZeroOrNull(endId) && !StringUtils.isZeroOrNull(userId) && !StringUtils.isZeroOrNull(sortCode)){
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
		}
		
		listRowKey=index.indexScan(startRowKey,endRowKey,null,queryExtInfo,"value");
		page.setRowCount(index.count(RowKeyUtil.getIntStringLongMinRowKey(SORTCODE_LENGTH),RowKeyUtil.getIntStringLongMaxRowKey(SORTCODE_LENGTH), null));
		
		list=setContentOfRowKey(
				tClient.findObjectAndKeyBatch(listRowKey,Message.class)
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
	}
	/**
	 * 前端页面查询对应用户的消息
	 */
	@Override
	public List<Message> listMessageByEndId(Long endId,Integer userId,Byte type,Integer pageSize){
		QueryExtInfo queryExtInfo = new QueryExtInfo();
		queryExtInfo.setLimit(0, pageSize);
		List<RowKey> listRowKey=null;
		List<Message> list=null;
		System.out.println("endId:"+endId+".userId:"+userId+".sortCode:"+type+".pageSize:"+pageSize+".");
		//Map<String,Object> result=new HashMap<String,Object>();
		if(StringUtils.isZeroOrNull(userId) && StringUtils.isZeroOrNull(type) ){//全空
			list=setContentOfRowKey(
					tClient.findObjectAndKeyList(RowKeyUtil.getIntStringLongMinRowKey(SORTCODE_LENGTH),RowKeyUtil.getIntStringLongMaxRowKey(SORTCODE_LENGTH),Message.class,queryExtInfo)
					);
			
			//page.setRowCount(tClient.count(RowKeyUtil.getIntStringLongMinRowKey(SORTCODE_LENGTH),RowKeyUtil.getIntStringLongMaxRowKey(SORTCODE_LENGTH), null));
		}/*else if(!StringUtils.isZeroOrNull(userId) && StringUtils.isBlank(sortCode) ){
			listRowKey = setIndexOfRowKey(
					indexClient.findObjectAndKeyList(RowKeyUtil.getIntStringLongMinRowKey(userId,SORTCODE_LENGTH),RowKeyUtil.getIntStringLongMaxRowKey(userId,SORTCODE_LENGTH),MessageIndex.class,FilterUtils.getPrefixFilter(userId),queryExtInfo)
					);
			list=setContentOfRowKey(
					tClient.findObjectAndKeyBatch(listRowKey,Message.class)
					);
			//page.setRowCount(tClient.count(RowKeyUtil.getIntStringLongMinRowKey(userId,SORTCODE_LENGTH),RowKeyUtil.getIntStringLongMaxRowKey(userId,SORTCODE_LENGTH), FilterUtils.getPrefixFilter(userId)));
		}*/else if(!StringUtils.isZeroOrNull(userId) && !StringUtils.isZeroOrNull(type) ){
			
			if(endId!=null){
				/*listRowKey = setIndexOfRowKey(
						indexClient.findObjectAndKeyList(RowKeyUtil.getRowKey(endRowKey),RowKeyUtil.getIntStringLongMaxRowKey(userId,sortCode),MessageIndex.class,FilterUtils.getPrefixFilter(userId),queryExtInfo)
						);*/
				listRowKey=index.indexScan(RowKeyUtil.getRowKey(userId,type,endId),RowKeyUtil.getRowKey(userId,type,Long.MAX_VALUE),FilterUtils.getPrefixFilter(userId),queryExtInfo, "value");
			}else{
				/*listRowKey = setIndexOfRowKey(
						indexClient.findObjectAndKeyList(RowKeyUtil.getIntStringLongMinRowKey(userId,sortCode),RowKeyUtil.getIntStringLongMaxRowKey(userId,sortCode),MessageIndex.class,FilterUtils.getPrefixFilter(userId),queryExtInfo)
						);*/
				RowKey start=RowKeyUtil.getRowKey(userId,type,0L);
				RowKey end=RowKeyUtil.getRowKey(userId,type,Long.MAX_VALUE);
				System.out.println("start:");
				for (byte b : start.toBytes()) {
					System.out.print((int)(b&0xFF)+" ");
				}
				System.out.println("end:");
				for (byte b : end.toBytes()) {
					System.out.print((int)(b&0xFF)+" ");
				}
				System.out.println(".");
				listRowKey=index.indexScan(start,end,FilterUtils.getPrefixFilter(userId),queryExtInfo, "value");
			/*if(map.get("rowKeyList")!=null){
				listRowKey = (List<RowKey>)map.get("rowKeyList");
				list=setContentOfRowKey(
						tClient.findObjectAndKeyBatch(listRowKey,Message.class)
						);
				if(map.get("endRowKey")!=null){
					result.put("endRowKey", map.get("endRowKey"));
				}
				result.put("list", list);
			}*/
			}
			System.out.println("listMessageByEndId中rowKey:");
			for (RowKey rowKey : listRowKey) {
				System.out.println(new String(rowKey.toBytes()));
			}
			if(listRowKey!=null && listRowKey.size()>0){
				list=setContentOfRowKey(
						tClient.findObjectAndKeyBatch(listRowKey,Message.class)
						);
			}else{
				list=null;
			}
			//page.setRowCount(tClient.count(RowKeyUtil.getIntStringLongMinRowKey(userId,sortCode),RowKeyUtil.getIntStringLongMaxRowKey(userId,sortCode), FilterUtils.getPrefixFilter(userId)));
		}
		
		/*page.setList(list);
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);*/
		return list;
	}
	@Override
	public void setRead(Integer userId, Byte type, Long id) {
		//List<RowKey> listRowKey = index.indexScan(RowKeyUtil.getRowKey(userId,sortCode,id),RowKeyUtil.getRowKey(userId,sortCode,id+1),FilterUtils.getPrefixFilter(userId),null ,"value");
		RowKey rowKey = index.indexGet(RowKeyUtil.getRowKey(userId,type,id), FilterUtils.getPrefixFilter(userId), null, "value");
		tClient.put(rowKey/*listRowKey.get(0)*/, "mf", "readFlag", new byte[]{(byte)0xFF});
		
	}
	@Override
	public void setStatus(Integer userId,Byte type,Long id,String status){
		tClient.put(index.indexGet(createIndexRowKey(userId,type,id), null, null, "value"),"mf","status",Bytes.toBytes(status));
	}
}
