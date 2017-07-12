package com.qingting.customer.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.alipay.simplehbase.client.rowkey.BytesRowKey;
import com.alipay.simplehbase.client.rowkey.StringRowKey;
import com.qingting.customer.common.pojo.hbasedo.Message;
import com.qingting.customer.common.pojo.util.DateUtil;
import com.qingting.customer.common.pojo.util.RowKeyUtil;
import com.qingting.customer.dao.MessageDAO;
import com.qingting.customer.dao.util.SHCUtil;
import com.qingting.customer.hbase.doandkey.SimpleHbaseDOWithKeyResult;
import com.qingting.customer.hbase.rowkey.RowKey;
@Repository("messageDAO")
public class MessageDAOImpl implements MessageDAO{
	/*public int getUnsignedByte (byte data){      //将data字节型数据转换为0~255 (0xFF 即BYTE)。
		return data&0x0FF;
	}

	public int getUnsignedByte (short data){      //将data字节型数据转换为0~65535 (0xFFFF 即 WORD)。
		return data&0x0FFFF;
	}

	public long getUnsignedIntt (int data){     //将int数据转换为0~4294967295 (0xFFFFFFFF即DWORD)。
		return data&0x0FFFFFFFFl;
	}*/
	public byte toByte(String str){
		return (byte)(Integer.valueOf(str)-127);
	}
	public byte[] convertIp(String ip){
		System.out.println("ip="+ip);
		String[] str=ip.split("\\.|:");
		System.out.println("分割后IP：");
		for (String string : str) {
			System.out.print(string+" ");
		}
		System.out.println();
		if(str.length==4){
			byte[] bytes=new byte[str.length];
			for(int i=0;i<str.length;i++){
				bytes[i]=toByte(str[i]);
			}
			return bytes;
		}else{
			throw new RuntimeException("传入的IP地址有误！请检查传入的参数。");
		}
		
	}
	@Override
	public void insertMessage(Message message) {
		System.out.println("插入信息："+message);
		RowKey rowKey = new BytesRowKey(RowKeyUtil.getBytes(Long.valueOf(message.getPhone()),convertIp(message.getIpAddr()), DateUtil.getMillisOfStart(),message.getMessageSortId()));
		SHCUtil.getSHC("message").insertObject(rowKey, message);
	}

	@Override
	public void deleteMessageByRowKey(String rowKey) {
		SHCUtil.getSHC("message").delete(new StringRowKey(rowKey));
		
	}

	@Override
	public void updateMessageByRowKey(Message message) {
		SHCUtil.getSHC("message").updateObjectWithVersion(new StringRowKey(message.getRowKey()), message, message.getVersion());
	}

	@Override
	public Message getMessageByRowKey(String rowKey) {
		SimpleHbaseDOWithKeyResult<Message> result = SHCUtil.getSHC("message").findObjectAndKey(new StringRowKey(rowKey), Message.class);
		Message message=result.getT();
		message.setContentOfRowKey(result.getRowKey().toBytes());
		return message;
	}

	@Override
	public List<Message> listMessage(String phone) {
		RowKey startRowKey=new BytesRowKey(RowKeyUtil.getBytes(Long.valueOf(phone),new byte[4],(long)0,0));
		RowKey endRowKey=new BytesRowKey(RowKeyUtil.getBytes(Long.valueOf(phone),new byte[]{(byte)0xff,(byte)0xff,(byte)0xff,(byte)0xff}, DateUtil.getMillisOfStart(),Integer.MAX_VALUE));
				
		//RowKey startRowKey=new BytesRowKey(RowKeyUtil.getBytes(phone, DateUtil.getStartOfMillis()));
		//RowKey endRowKey=new BytesRowKey(RowKeyUtil.getBytes(phone, DateUtil.getMillisOfStart()));
		List<SimpleHbaseDOWithKeyResult<Message>> listDOWithKey = SHCUtil.getSHC("message").findObjectAndKeyList(startRowKey,endRowKey, Message.class);
		List<Message> list=new ArrayList<Message>();
		for (SimpleHbaseDOWithKeyResult<Message> result : listDOWithKey) {
			Message message = result.getT();
			message.setContentOfRowKey(result.getRowKey().toBytes());
			list.add(message);
		}
		return list;
	}

	@Override
	public Integer countMessageOfTodayByPhone(String phone) {
		RowKey startRowKey=new BytesRowKey(RowKeyUtil.getBytes(Long.valueOf(phone),new byte[4],(long)0,0));
		RowKey endRowKey=new BytesRowKey(RowKeyUtil.getBytes(Long.valueOf(phone),new byte[]{(byte)0xff,(byte)0xff,(byte)0xff,(byte)0xff}, DateUtil.getMillisOfStart(),Integer.MAX_VALUE));
		List<Message> list = SHCUtil.getSHC("message").findObjectList(startRowKey,endRowKey, Message.class);
		return list.size();
	}

	@Override
	public Integer countMessageOfTodayByIp(String ip) {
		RowKey startRowKey=new BytesRowKey(RowKeyUtil.getBytes(0,convertIp(ip),(long)0,0));
		RowKey endRowKey=new BytesRowKey(RowKeyUtil.getBytes(Long.MAX_VALUE,convertIp(ip), DateUtil.getMillisOfStart(),Integer.MAX_VALUE));
		List<Message> list = SHCUtil.getSHC("message").findObjectList(startRowKey,endRowKey, Message.class);
		return list.size();
	}

}
