package com.qingting.customer.dao.impl;

import java.nio.charset.Charset;
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
import com.alipay.simplehbase.client.rowkey.StringRowKey;
import com.alipay.simplehbase.sequence.RedisSerialNum;
import com.alipay.simplehbase.util.FilterUtils;
import com.alipay.simplehbase.util.HbaseOriginService;
import com.qingting.customer.common.pojo.common.StringUtils;
import com.qingting.customer.common.pojo.hbasedo.Equip;
import com.qingting.customer.common.pojo.hbasedo.Message;
import com.qingting.customer.common.pojo.index.MessageIndex;
import com.qingting.customer.common.pojo.model.Pagination;
import com.qingting.customer.dao.MessageDAO;
import com.qingting.customer.dao.util.RandomUtil;
import com.qingting.customer.dao.util.SHCUtil;
import com.qingting.customer.hbase.doandkey.SimpleHbaseDOWithKeyResult;
import com.qingting.customer.hbase.rowkey.RowKey;
@Repository("messageDAO")
public class MessageDAOImpl implements MessageDAO{
	
	@Resource(name="redisTemplate")
	public RedisTemplate<String, Long> redisTemplate;
	
	private static SimpleHbaseClient tClient=SHCUtil.getSHC("message");
	private static SimpleHbaseClient indexClient=SHCUtil.getSHC("messageIndex");
	//new byte[][]{}
	private static HbaseOriginService index=new HbaseOriginService("messageIndex",new String[]{"messageIndexFamily"},null);
	
	private final static String SEQUENCE="messageIndex_id_seq";
	
	private final static byte dataVersion=0;
	
	private final static int RANDOM_LENGTH=2;
	//private final static int MILLIS_LENGTH=8;
	private final static int SORTCODE_LENGTH=4;
	
	private static RowKey createRowKey(Long millis){
		return RowKeyUtil.getRowKey(RandomUtil.getRandomCode(RANDOM_LENGTH),millis);
	}
	private static RowKey createIndexRowKey(Integer userId,String sortCode,Long id){
		return RowKeyUtil.getRowKey(userId,sortCode,id);
	}
	private static List<Message> setContentOfRowKey(List<SimpleHbaseDOWithKeyResult<Message>> listHbase){
		List<Message> list=new ArrayList<Message>();
		for (SimpleHbaseDOWithKeyResult<Message> result : listHbase) {
			list.add(getMessageFromResult(result));
		}
		return list;
	}
	private static List<RowKey> setIndexOfRowKey(List<SimpleHbaseDOWithKeyResult<MessageIndex>> listHbase){
		List<RowKey> list=new ArrayList<RowKey>();
		for (SimpleHbaseDOWithKeyResult<MessageIndex> result : listHbase) {
			list.add(getMessageIndexFromResult(result));
		}
		return list;
	}
	private static RowKey getMessageIndexFromResult(SimpleHbaseDOWithKeyResult<MessageIndex> result){
		MessageIndex messageIndex = result.getT();
		return new StringRowKey(messageIndex.getValue());
	}
	/*private RowKey covertStringToRowKey(String string){
		String randomString = string.substring(0,RANDOM_LENGTH);
		String millisString = string.substring(RANDOM_LENGTH);
		Long millis=Long.valueOf(millisString);
		return createRowKey(randomString,millis);
	}*/
	
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
		
		message.setRowKey(new String(rowkey,Charset.forName("UTF-8")));
		
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
		RowKey indexRowKey=createIndexRowKey(message.getUserId(),message.getSortCode(),num);
		RowKey value=createRowKey(message.getCreateTime().getTimeInMillis());
		//String string = new String(value.toBytes(),Charset.forName("UTF-8"));
		//messageIndex.setValue(string);
		
		//indexClient.putObject(indexRowKey, messageIndex);//索引表
		index.put(indexRowKey, "messageIndexFamily", "value", value.toBytes());
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
			System.out.println("userId:"+message.getUserId()+".sortCode:"+message.getSortCode()+".id:"+message.getId());
			rowKeyIndexList.add(createIndexRowKey(message.getUserId(), message.getSortCode(), message.getId()));
		}
		List<RowKey> rowKeylist=setIndexOfRowKey(
			indexClient.findObjectAndKeyBatch(rowKeyIndexList,MessageIndex.class)
		);
		indexClient.deleteList(rowKeyIndexList);//删除索引
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
		tClient.putObject(getMessageRowKey(message.getUserId(),message.getSortCode(),message.getId()), message);
	}
	
	public RowKey getMessageRowKey(Integer userId,String sortCode,Long id){
		SimpleHbaseDOWithKeyResult<MessageIndex> result = indexClient.findObjectAndKey(createIndexRowKey(userId, sortCode, id), MessageIndex.class);
		MessageIndex obj=result.getT();
		return new StringRowKey(obj.getValue());
	}
	@Override
	public Message getMessage(Integer userId,String sortCode,Long id) {
		return getMessageFromResult(
				tClient.findObjectAndKey(getMessageRowKey(userId,sortCode,id), Message.class)
				);
	}
	
	/**
	 * 后台管理查询消息
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Pagination<Message> listMessage(Integer userId,String sortCode,Pagination<Message> page) {
		QueryExtInfo queryExtInfo = new QueryExtInfo();
		//queryExtInfo.setLimit((pageNo-1)*pageSize, pageSize);
		//queryExtInfo.setLimit((page.getPageNo()-1)*page.getPageSize(), page.getPageSize());
		
		List<RowKey> listRowKey=null;
		List<Message> list=null;
		
		Map<String,Object> map=null;
		
		//Pagination<Message> page=new Pagination<Message>();
		System.out.println("查询的endRowKey:");
		if(page.getEndRowKey()!=null)
			for(int i=0;i<page.convertFromEndRowKey().length;i++){
				System.out.print(page.convertFromEndRowKey()[i]+" ");
			}
		System.out.println(".");
	
		if(StringUtils.isZeroOrNull(userId) && StringUtils.isBlank(sortCode) ){//全空
			if(page.getPageNo()==1){//首页
				System.out.println("首页.");
				queryExtInfo.setLimit(0, page.getPageSize());
				/*listRowKey = setIndexOfRowKey(
						indexClient.findObjectAndKeyList(RowKeyUtil.getIntStringLongMinRowKey(SORTCODE_LENGTH),RowKeyUtil.getIntStringLongMaxRowKey(SORTCODE_LENGTH),MessageIndex.class,null,queryExtInfo)
						);*/
				map=index.indexScanOfMap(RowKeyUtil.getIntStringLongMinRowKey(SORTCODE_LENGTH),RowKeyUtil.getIntStringLongMaxRowKey(SORTCODE_LENGTH),null,queryExtInfo, "value");
			}else if(page.getPageNo()==page.getLastPageNo()+1){//下一页
				System.out.println("下一页.");
				queryExtInfo.setLimit(0, page.getPageSize());
				/*listRowKey = setIndexOfRowKey(
						indexClient.findObjectAndKeyList(RowKeyUtil.getRowKey(page.getEndRowKey()),RowKeyUtil.getIntStringLongMaxRowKey(SORTCODE_LENGTH),MessageIndex.class,null,queryExtInfo)
						);*/
				map=index.indexScanOfMap(RowKeyUtil.getRowKey(page.convertFromEndRowKey()),RowKeyUtil.getIntStringLongMaxRowKey(SORTCODE_LENGTH),null,queryExtInfo, "value");
			}else if(page.getPageNo()==page.getLastPageNo()-1){//上一页
				System.out.println("上一页.");
				queryExtInfo.setLimit(page.getRealityCount(), page.getPageSize());
				queryExtInfo.setReversed(true);
				/*listRowKey = setIndexOfRowKey(
						indexClient.findObjectAndKeyList(RowKeyUtil.getRowKey(page.getEndRowKey()),RowKeyUtil.getIntStringLongMaxRowKey(SORTCODE_LENGTH),MessageIndex.class,null,queryExtInfo)
						);*/
				map=index.indexScanOfMap(RowKeyUtil.getIntStringLongMinRowKey(SORTCODE_LENGTH),RowKeyUtil.getRowKey(page.convertFromEndRowKey()),null,queryExtInfo, "value");
			}else if(page.getPageNo()==page.getPageCount()){//尾页
				System.out.println("尾页.");
				queryExtInfo.setLimit(0,page.getRowCount()-(page.getPageCount()-1)*page.getPageSize());
				queryExtInfo.setReversed(true);
				/*listRowKey = setIndexOfRowKey(
						indexClient.findObjectAndKeyList(RowKeyUtil.getRowKey(page.getEndRowKey()),RowKeyUtil.getIntStringLongMaxRowKey(SORTCODE_LENGTH),MessageIndex.class,null,queryExtInfo)
						);*/
				map=index.indexScanOfMap(RowKeyUtil.getIntStringLongMinRowKey(SORTCODE_LENGTH),RowKeyUtil.getIntStringLongMaxRowKey(SORTCODE_LENGTH),null,queryExtInfo,"value");
			}else{//跳页查询
				System.out.println("跳页查询.");
				queryExtInfo.setLimit((page.getPageNo()-1)*page.getPageSize(), page.getPageSize());
				/*listRowKey = setIndexOfRowKey(
						indexClient.findObjectAndKeyList(RowKeyUtil.getIntStringLongMinRowKey(SORTCODE_LENGTH),RowKeyUtil.getIntStringLongMaxRowKey(SORTCODE_LENGTH),MessageIndex.class,null,queryExtInfo)
						);*/
				map=index.indexScanOfMap(RowKeyUtil.getIntStringLongMinRowKey(SORTCODE_LENGTH),RowKeyUtil.getIntStringLongMaxRowKey(SORTCODE_LENGTH),null,queryExtInfo,"value");
			}
			/*list=setContentOfRowKey(
					tClient.findObjectAndKeyList(RowKeyUtil.getIntStringLongMinRowKey(SORTCODE_LENGTH),RowKeyUtil.getIntStringLongMaxRowKey(SORTCODE_LENGTH),Message.class,queryExtInfo)
					);*/
			page.setRowCount(tClient.count(RowKeyUtil.getIntStringLongMinRowKey(SORTCODE_LENGTH),RowKeyUtil.getIntStringLongMaxRowKey(SORTCODE_LENGTH), null));
		}else if(!StringUtils.isZeroOrNull(userId) && StringUtils.isBlank(sortCode) ){//用户ID非空，分类编号空
			listRowKey = setIndexOfRowKey(
					indexClient.findObjectAndKeyList(RowKeyUtil.getIntStringLongMinRowKey(userId,SORTCODE_LENGTH),RowKeyUtil.getIntStringLongMaxRowKey(userId,SORTCODE_LENGTH),MessageIndex.class,FilterUtils.getPrefixFilter(userId),queryExtInfo)
					);
			page.setRowCount(tClient.count(RowKeyUtil.getIntStringLongMinRowKey(userId,SORTCODE_LENGTH),RowKeyUtil.getIntStringLongMaxRowKey(userId,SORTCODE_LENGTH), FilterUtils.getPrefixFilter(userId)));
		}else if(!StringUtils.isZeroOrNull(userId) && !StringUtils.isBlank(sortCode) ){//
			listRowKey = setIndexOfRowKey(
					indexClient.findObjectAndKeyList(RowKeyUtil.getIntStringLongMinRowKey(userId,sortCode),RowKeyUtil.getIntStringLongMaxRowKey(userId,sortCode),MessageIndex.class,FilterUtils.getPrefixFilter(userId),queryExtInfo)
					);
			page.setRowCount(tClient.count(RowKeyUtil.getIntStringLongMinRowKey(userId,sortCode),RowKeyUtil.getIntStringLongMaxRowKey(userId,sortCode), FilterUtils.getPrefixFilter(userId)));
		}
		
		if(map.get("rowkeyList")!=null){
			System.out.println("行键查询结束.");
			for (RowKey rowKey : (List<RowKey>)map.get("rowkeyList")) {
				System.out.println("查询到的行键:");
				for (byte b : rowKey.toBytes()) {
					System.out.print(b+" ");
				}
				System.out.println(".");
			}
			listRowKey = (List<RowKey>)map.get("rowkeyList");
			list=setContentOfRowKey(
					tClient.findObjectAndKeyBatch(listRowKey,Message.class)
					);
			page.setRealityCount(listRowKey.size());//返回的实际数据条数
		}
		page.setLastPageNo(page.getPageNo());//更新上一次的页码为本次请求页码
		
		if(map.get("endRowkey")!=null){
			page.convertToEndRowKey((byte[])map.get("endRowkey"));//结束数据的行键
		}
		
		page.setList(list);
		return page;
	}
	/**
	 * 前端页面查询对应用户的消息
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Message> listMessageByEndId(Long endId,Integer userId,String sortCode,Integer pageSize){
		QueryExtInfo queryExtInfo = new QueryExtInfo();
		queryExtInfo.setLimit(0, pageSize);
		List<RowKey> listRowKey=null;
		List<Message> list=null;
		
		//Map<String,Object> result=new HashMap<String,Object>();
		if(StringUtils.isZeroOrNull(userId) && StringUtils.isBlank(sortCode) ){//全空
			list=setContentOfRowKey(
					tClient.findObjectAndKeyList(RowKeyUtil.getIntStringLongMinRowKey(SORTCODE_LENGTH),RowKeyUtil.getIntStringLongMaxRowKey(SORTCODE_LENGTH),Message.class,queryExtInfo)
					);
			
			//page.setRowCount(tClient.count(RowKeyUtil.getIntStringLongMinRowKey(SORTCODE_LENGTH),RowKeyUtil.getIntStringLongMaxRowKey(SORTCODE_LENGTH), null));
		}else if(!StringUtils.isZeroOrNull(userId) && StringUtils.isBlank(sortCode) ){
			listRowKey = setIndexOfRowKey(
					indexClient.findObjectAndKeyList(RowKeyUtil.getIntStringLongMinRowKey(userId,SORTCODE_LENGTH),RowKeyUtil.getIntStringLongMaxRowKey(userId,SORTCODE_LENGTH),MessageIndex.class,FilterUtils.getPrefixFilter(userId),queryExtInfo)
					);
			list=setContentOfRowKey(
					tClient.findObjectAndKeyBatch(listRowKey,Message.class)
					);
			//page.setRowCount(tClient.count(RowKeyUtil.getIntStringLongMinRowKey(userId,SORTCODE_LENGTH),RowKeyUtil.getIntStringLongMaxRowKey(userId,SORTCODE_LENGTH), FilterUtils.getPrefixFilter(userId)));
		}else if(!StringUtils.isZeroOrNull(userId) && !StringUtils.isBlank(sortCode) ){
			Map<String,Object> map=null;
			if(endId!=null)
				/*listRowKey = setIndexOfRowKey(
						indexClient.findObjectAndKeyList(RowKeyUtil.getRowKey(endRowKey),RowKeyUtil.getIntStringLongMaxRowKey(userId,sortCode),MessageIndex.class,FilterUtils.getPrefixFilter(userId),queryExtInfo)
						);*/
				listRowKey=index.indexScan(RowKeyUtil.getRowKey(userId,sortCode,endId),RowKeyUtil.getIntStringLongMaxRowKey(userId,sortCode),FilterUtils.getPrefixFilter(userId),queryExtInfo, "value");
			else
				/*listRowKey = setIndexOfRowKey(
						indexClient.findObjectAndKeyList(RowKeyUtil.getIntStringLongMinRowKey(userId,sortCode),RowKeyUtil.getIntStringLongMaxRowKey(userId,sortCode),MessageIndex.class,FilterUtils.getPrefixFilter(userId),queryExtInfo)
						);*/
				listRowKey=index.indexScan(RowKeyUtil.getIntStringLongMinRowKey(userId,sortCode),RowKeyUtil.getIntStringLongMaxRowKey(userId,sortCode),FilterUtils.getPrefixFilter(userId),queryExtInfo, "value");
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
			list=setContentOfRowKey(
					tClient.findObjectAndKeyBatch(listRowKey,Message.class)
					);
			
			//page.setRowCount(tClient.count(RowKeyUtil.getIntStringLongMinRowKey(userId,sortCode),RowKeyUtil.getIntStringLongMaxRowKey(userId,sortCode), FilterUtils.getPrefixFilter(userId)));
		}
		
		/*page.setList(list);
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);*/
		return list;
	}
	@Override
	public void setRead(Integer userId, String sortCode, Long id) {
		List<RowKey> listRowKey = index.indexScan(RowKeyUtil.getRowKey(userId,sortCode,id),RowKeyUtil.getRowKey(userId,sortCode,id+1),FilterUtils.getPrefixFilter(userId),null ,"value");
		tClient.put(listRowKey.get(0), "messageFamily", "readFlag", new byte[]{(byte)0xFF});
		//tClient.put("insert into message(rowkey,readFlag) values("+obj.getValue()+","+true+") ");//where rowkey equal "+obj.getValue()
	}
	
	/*public void setRead(Integer userId, String sortCode, Long id) {
		SimpleHbaseDOWithKeyResult<MessageIndex> result = indexClient.findObjectAndKey(createIndexRowKey(userId, sortCode, id), MessageIndex.class);
		MessageIndex obj=result.getT();
		tClient.put(new StringRowKey(obj.getValue()), "messageFamily", "readFlag", new byte[]{(byte)0xFF});
		//tClient.put("insert into message(rowkey,readFlag) values("+obj.getValue()+","+true+") ");//where rowkey equal "+obj.getValue()
	}*/
}
