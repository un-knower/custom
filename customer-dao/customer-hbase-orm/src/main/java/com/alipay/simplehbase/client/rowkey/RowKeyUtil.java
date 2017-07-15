package com.alipay.simplehbase.client.rowkey;

import java.nio.ByteBuffer;

import org.apache.hadoop.hbase.util.Bytes;

import com.alipay.simplehbase.exception.SimpleHBaseException;
import com.alipay.simplehbase.util.BytesUtil;
import com.alipay.simplehbase.util.Util;
import com.qingting.customer.hbase.rowkey.RowKey;

/**
 * RowKeyUtil.
 * 
 * @author xinzhi.zhang
 * */
public class RowKeyUtil {
	
    /**
     * Used by scanners, etc when they want to start at the beginning of a
     * region
     */
    public static RowKey START_ROW = new BytesRowKey(new byte[0]);
    /**
     * Last row in a table.
     */
    public static RowKey END_ROW   = new BytesRowKey(new byte[0]);

    /**
     * Append rowKey's bytes's by appending ZERO byte at tail.
     * 
     * */
    public static RowKey appendZeroToRowKey(RowKey rowKey) {
        Util.checkRowKey(rowKey);
        byte[] oldKey = rowKey.toBytes();
        byte[] newKey = BytesUtil.merge(oldKey, BytesUtil.ZERO);
        return new BytesRowKey(newKey);
    }

    /**
     * Compute the end row key of specified prefix rowkey.
     * 
     * <pre>
     * The prefixRowKey's bytes can not be empty or all of 0xFF.
     * </pre>
     * 
     * @param prefixRowKey prefixRowKey.
     * @return endRowKey for this prefixRowKey.
     * */
    public static RowKey getEndRowKeyOfPrefix(RowKey prefixRowKey) {
        Util.checkRowKey(prefixRowKey);
        byte[] rowkeyBytes = prefixRowKey.toBytes();

        Util.check(rowkeyBytes.length != 0);

        boolean isAllByteIsFF = true;
        for (byte b : rowkeyBytes) {
            if ((b & 0xFF) != 0xFF) {
                isAllByteIsFF = false;
                break;
            }
        }

        if (isAllByteIsFF) {
            throw new SimpleHBaseException(
                    "the prefix row key is all of 0xFF. prefixRowKey="
                            + prefixRowKey);
        }

        return new BytesRowKey(BytesUtil.increaseLastByte(rowkeyBytes));
    }
    public static byte[] plusOne(byte[] bytes){
    	int temp=0;
    	for(int i=bytes.length-1;i>-1;i--){
    		temp=(int)(bytes[i]&0xFF)+1;
    		if(temp<256){
    			bytes[i]=(byte)temp;
    			break;
    		}else{
    			bytes[i]=0;
    		}
    	}
    	return bytes;
    }
    public static RowKey lastByteOfRowKeyPlusOne(RowKey rowkey){
    	byte[] rowkeyBytes=rowkey.toBytes();
    	return new BytesRowKey(plusOne(rowkeyBytes));
    }
    
    private static final byte[] INT_MAX_BYTES=new byte[]{(byte)0xFF,(byte)0xFF,(byte)0xFF,(byte)0xFF};
    private static final byte[] INT_MIN_BYTES=new byte[]{(byte)0,(byte)0,(byte)0,(byte)0};
    
    private static final byte[] LONG_MAX_BYTES=new byte[]{(byte)0xFF,(byte)0xFF,(byte)0xFF,(byte)0xFF,
    		(byte)0xFF,(byte)0xFF,(byte)0xFF,(byte)0xFF};
    private static final byte[] LONG_MIN_BYTES=new byte[]{(byte)0,(byte)0,(byte)0,(byte)0,(byte)0,(byte)0,(byte)0,(byte)0};
    
    private static final byte[] INT_LONG_MAX_BYTES=new byte[]{(byte)0xFF,(byte)0xFF,(byte)0xFF,(byte)0xFF,
    		(byte)0xFF,(byte)0xFF,(byte)0xFF,(byte)0xFF,
    		(byte)0xFF,(byte)0xFF,(byte)0xFF,(byte)0xFF
    	};
    private static final byte[] INT_LONG_MIN_BYTES=new byte[]{(byte)0,(byte)0,(byte)0,(byte)0,
    		(byte)0,(byte)0,(byte)0,(byte)0,
    		(byte)0,(byte)0,(byte)0,(byte)0
    	};
    /**
     * 
     * @Title: getRowKey
     * @Description: 获得IntRowKey
     * @param value
     * @return 
     * @return RowKey
     * @throws
     */
    public static RowKey getRowKey(Integer value){
    	return new IntRowKey(value);
    }
    public static RowKey getRowKey(Long value){
    	return new LongRowKey(value);
    }
    public static RowKey getRowKey(String value){
    	return new StringRowKey(value);
    }
    public static RowKey getRowKey(byte[] value){
    	return new BytesRowKey(value);
    }
    public static RowKey getRowKey(byte[] value1,String value2){
    	return new BytesRowKey(
    			BytesUtil.merge(value1, Bytes.toBytes(value2))
    			);
    }
    public static RowKey getRowKey(Long value1,Integer value2){
    	return new BytesRowKey(
    			BytesUtil.merge(Bytes.toBytes(value1), Bytes.toBytes(value2))
    			);
    }
    public static RowKey getRowKey(Long value1,String value2){
    	return new BytesRowKey(
    			BytesUtil.merge(Bytes.toBytes(value1), Bytes.toBytes(value2))
    			);
    }
    public static RowKey getRowKey(String str,Integer value){
    	return new BytesRowKey(
    			BytesUtil.merge(Bytes.toBytes(str),Bytes.toBytes(value))
    			);
    }
    public static RowKey getRowKey(String str,Long value){
    	return new BytesRowKey(
    			BytesUtil.merge(Bytes.toBytes(str),Bytes.toBytes(value))
    			);
    }
    public static RowKey getRowKey(String str1,String str2){
    	return new BytesRowKey(
    			BytesUtil.merge(Bytes.toBytes(str1),Bytes.toBytes(str2))
    			);
    }
    public static RowKey getRowKey(String value1,byte[] bytes,Long value3){
    	return new BytesRowKey(
    			BytesUtil.merge(Bytes.toBytes(value1),bytes, Bytes.toBytes(value3))
    			);
    }
    public static RowKey getRowKey(String value1,Long value2,Integer value3){
    	return new BytesRowKey(
    			BytesUtil.merge(Bytes.toBytes(value1),Bytes.toBytes(value2), Bytes.toBytes(value3))
    			);
    }
    public static RowKey getRowKey(String value1,String value2,Integer value3){
    	return new BytesRowKey(
    			BytesUtil.merge(Bytes.toBytes(value1),Bytes.toBytes(value2), Bytes.toBytes(value3))
    			);
    }
    public static RowKey getRowKey(String value1,String value2,Long value3){
    	return new BytesRowKey(
    			BytesUtil.merge(Bytes.toBytes(value1),Bytes.toBytes(value2), Bytes.toBytes(value3))
    			);
    }
    public static RowKey getRowKey(String value1,String value2,String value3){
    	return new BytesRowKey(
    			BytesUtil.merge(Bytes.toBytes(value1),Bytes.toBytes(value2), Bytes.toBytes(value3))
    			);
    }
    
    
    /*public static RowKey getMaxRowKey(String longText,Integer longTextLength,Integer value){
    	
    	byte[] bytes=new byte[longTextLength+INTEGET_BYTENUM];
    	
    	if(Util.stringIsBlank(longText) && Util.integerIsBlank(value)){//String为空,Integer空
    		for(int i=0;i<longTextLength+INTEGET_BYTENUM;i++)
    			bytes[i]=(byte)0xFF;
    		return new BytesRowKey(bytes);
    	}else if(!Util.stringIsBlank(longText) && Util.integerIsBlank(value)){//String不为空,Integer空
    		byte[] longTextByte=BytesUtil.increaseLastByte(Bytes.toBytes(longText));
    		for(int i=0;i<longTextLength;i++)
    			bytes[i]=longTextByte[i];
    		for(int i=0;i<INTEGET_BYTENUM;i++){
    			bytes[longTextLength+i]=(byte) 0xFF;
    		}
    		return new BytesRowKey(bytes);
    	}else if(!Util.stringIsBlank(longText) && !Util.integerIsBlank(value)){//String不为空,Integer不为空
    		return getEndRowKeyOfPrefix(getRowKey(longText,value));
    	}else{
    		throw new SimpleHBaseException("Unable to get the MaxRowKey.");
    	}
    }
    public static RowKey getMinRowKey(String longText,Integer longTextLength,Integer value){
    	
    	byte[] bytes=new byte[longTextLength+INTEGET_BYTENUM];
    	
    	if(Util.stringIsBlank(longText) && Util.integerIsBlank(value)){//String为空,Integer空
    		return new BytesRowKey(bytes);
    	}else if(!Util.stringIsBlank(longText) && Util.integerIsBlank(value)){//String不为空,Integer空
    		return getRowKey(longText,value);
    	}else if(!Util.stringIsBlank(longText) && !Util.integerIsBlank(value)){//String不为空,Integer不为空
    		return getRowKey(longText,value);
    	}else{
    		throw new SimpleHBaseException("Unable to get the MinRowKey.");
    	}
    }
    
    
    
    public static RowKey getMinRowKey(String value1,Long value2,Integer value3){
    	byte[] temp;
    	if(value1==null){
    		temp=new byte[1];
    	}else{
    		temp=Bytes.toBytes(value1);
    	}
    	return new BytesRowKey(
    			BytesUtil.merge(temp,Bytes.toBytes(value2), Bytes.toBytes(value3))
    			);
    }
    public static RowKey getMaxRowKey(String value1,Long value2,Integer value3){
    	byte[] temp;
    	if(value1==null){
    		temp=new byte[32];
    		for(int i=0;i<32;i++){
    			temp[i]=(byte)0xff;
    		}
    	}else{
    		temp=Bytes.toBytes(value1);
    	}
    	return new BytesRowKey(
    			BytesUtil.merge(temp,Bytes.toBytes(value2), Bytes.toBytes(value3))
    			);
    }*/
    //===================================获得最大最小RowKey================================
    /**
     * 
     * @Title: getIntMaxRowKey
     * @Description: 
     * @param value
     * @return 
     * @return RowKey
     * @throws
     */
    public static RowKey getIntMaxRowKey(){
    	return new BytesRowKey(INT_MAX_BYTES);
    }
    public static RowKey getIntMinRowKey(){
    	return new BytesRowKey(INT_MIN_BYTES);
    }
    public static RowKey getStringMaxRowKey(int strLength){
    	byte[] bytes=new byte[strLength];
    	for (int i=0;i<strLength;i++) {
			bytes[i]=(byte)0xFF;
		}
    	return new BytesRowKey(bytes);
    }
    public static RowKey getStringMinRowKey(int strLength){
    	byte[] bytes=new byte[strLength];
    	for (int i=0;i<strLength;i++) {
			bytes[i]=(byte)0;
		}
    	return new BytesRowKey(bytes);
    }
    public static RowKey getIntLongMaxRowKey(){
    	return new BytesRowKey(INT_LONG_MAX_BYTES);
    }
    public static RowKey getIntLongMinRowKey(){
    	return new BytesRowKey(INT_LONG_MIN_BYTES);
    }
    /**
     * 
     * @Title: getStringIntMaxRowKey
     * @Description: rowkey(String byte steady.Int byte 0xFF)
     * @param str
     * @return 
     * @return RowKey
     * @throws
     */
    public static RowKey getStringIntMaxRowKey(String str){
    	int length=0;
    	byte[] strs=null;
    	if(str!=null){
    		length=str.length();
    		strs=Bytes.toBytes(str);
    	}
    	byte[] bytes=new byte[length+4];
    	for(int i=0;i<length;i++){
    		bytes[i]=strs[i];
    	}
    	for(int i=0;i<4;i++){
    		bytes[i+length]=(byte)0xFF;
    	}
    	return new BytesRowKey(bytes); 
    }
    /**
     * 
     * @Title: getStringIntMinRowKey
     * @Description: rowkey(String byte steady.Int byte 0x00)
     * @param str
     * @return 
     * @return RowKey
     * @throws
     */
    public static RowKey getStringIntMinRowKey(String str){
    	int length=0;
    	byte[] strs=null;
    	if(str!=null){
    		length=str.length();
    		strs=Bytes.toBytes(str);
    	}
    	byte[] bytes=new byte[length+4];
    	for(int i=0;i<length;i++){
    		bytes[i]=strs[i];
    	}
    	for(int i=0;i<4;i++){
    		bytes[i+length]=(byte)0;
    	}
    	return new BytesRowKey(bytes); 
    }
    public static RowKey getLongStringMaxRowKey(int strLength){
    	byte[] bytes=new byte[strLength+8];
    	for (int i=0;i<strLength+8;i++) {
			bytes[i]=(byte)0xFF;
		}
    	return new BytesRowKey(bytes);
    }
    public static RowKey getLongStringMinRowKey(int strLength){
    	byte[] bytes=new byte[strLength+8];
    	for (int i=0;i<strLength+8;i++) {
			bytes[i]=(byte)0;
		}
    	return new BytesRowKey(bytes);
    }
    /**
     * 
     * @Title: getStringLongMaxRowKey
     * @Description: rowkey(all byte 0xFF)
     * @param strLength
     * @return 
     * @return RowKey
     * @throws
     */
    public static RowKey getStringLongMaxRowKey(int strLength){
    	byte[] bytes=new byte[strLength+8];
    	for (int i=0;i<strLength+8;i++) {
			bytes[i]=(byte)0xFF;
		}
    	return new BytesRowKey(bytes);
    }
    /**
     * 
     * @Title: getStringLongMinRowKey
     * @Description: rowkey(all byte 0x00)
     * @param strLength
     * @return 
     * @return RowKey
     * @throws
     */
    public static RowKey getStringLongMinRowKey(int strLength){
    	byte[] bytes=new byte[strLength+8];
    	for (int i=0;i<strLength+8;i++) {
			bytes[i]=(byte)0;
		}
    	return new BytesRowKey(bytes);
    }
    /**
     * 
     * @Title: getStringLongMaxRowKey
     * @Description: rowkey(String byte steady.Long byte 0xFF)
     * @param str
     * @return 
     * @return RowKey
     * @throws
     */
    public static RowKey getStringLongMaxRowKey(String str){
    	int length=0;
    	byte[] strs=null;
    	if(str!=null){
    		length=str.length();
    		strs=Bytes.toBytes(str);
    	}
    	byte[] bytes=new byte[length+8];
    	for(int i=0;i<length;i++){
    		bytes[i]=strs[i];
    	}
    	for(int i=0;i<8;i++){
    		bytes[i+length]=(byte)0xFF;
    	}
    	return new BytesRowKey(bytes); 
    }
    /**
     * 
     * @Title: getStringLongMinRowKey
     * @Description: rowkey(String byte steady.Long byte 0x00)
     * @param str
     * @return 
     * @return RowKey
     * @throws
     */
    public static RowKey getStringLongMinRowKey(String str){
    	int length=0;
    	byte[] strs=null;
    	if(str!=null){
    		length=str.length();
    		strs=Bytes.toBytes(str);
    	}
    	byte[] bytes=new byte[length+8];
    	for(int i=0;i<length;i++){
    		bytes[i]=strs[i];
    	}
    	for(int i=0;i<8;i++){
    		bytes[i+length]=(byte)0;
    	}
    	return new BytesRowKey(bytes); 
    }
    public static RowKey getStringStringMaxRowKey(int length1,int length2){
    	byte[] bytes=new byte[length1+length2];
    	for (int i=0;i<length1+length2;i++) {
			bytes[i]=(byte)0xFF;
		}
    	return new BytesRowKey(bytes);
    }
    public static RowKey getStringStringMinRowKey(int length1,int length2){
    	byte[] bytes=new byte[length1+length2];
    	for (int i=0;i<length1+length2;i++) {
			bytes[i]=(byte)0;
		}
    	return new BytesRowKey(bytes);
    }
    /**
     * 
     * @Title: getStringbytesLongMaxRowKey
     * @Description: rowkey(String byte steady.bytes byte oxFF.Long byte 0xFF)
     * @param strLength
     * @param bytesLength
     * @return 
     * @return RowKey
     * @throws
     */
    public static RowKey getStringbytesLongMaxRowKey(String str,int bytesLength){
    	int length=0;
    	byte[] strs=null;
    	if(str!=null){
    		length=str.length();
    		strs=Bytes.toBytes(str);
    	}
    	byte[] bytes=new byte[length+bytesLength+8];
    	for(int i=0;i<length;i++){//字符串原样转换
    		bytes[i]=strs[i];
    	}
    	for(int i=0;i<bytesLength+8;i++){//字节数组和long的字节最大
    		bytes[i+length]=(byte)0xFF;
    	}
    	return new BytesRowKey(bytes);
    }
    /**
     * 
     * @Title: getStringbytesLongMinRowKey
     * @Description: rowkey(String byte steady.bytes byte ox00.Long byte 0x00)
     * @param strLength
     * @param bytesLength
     * @return 
     * @return RowKey
     * @throws
     */
    public static RowKey getStringbytesLongMinRowKey(String str,int bytesLength){
    	int length=0;
    	byte[] strs=null;
    	if(str!=null){
    		length=str.length();
    		strs=Bytes.toBytes(str);
    	}
    	byte[] bytes=new byte[length+bytesLength+8];
    	for(int i=0;i<length;i++){//字符串原样转换
    		bytes[i]=strs[i];
    	}
    	for(int i=0;i<bytesLength+8;i++){//字节数组和long的字节小
    		bytes[i+length]=(byte)0x00;
    	}
    	return new BytesRowKey(bytes);
    }
    /**
     * 
     * @Title: getStringbytesLongMaxRowKey
     * @Description: rowkey(String byte 0xFF.bytes byte oxFF.Long byte 0xFF)
     * @param strLength
     * @param bytesLength
     * @return 
     * @return RowKey
     * @throws
     */
    public static RowKey getStringbytesLongMaxRowKey(int strLength,int bytesLength){
    	
    	byte[] bytes=new byte[strLength+bytesLength+8];
    	
    	for(int i=0;i<strLength+bytesLength+8;i++){//字符串和字节数组和long的字节最大
    		bytes[i]=(byte)0xFF;
    	}
    	return new BytesRowKey(bytes);
    }
    /**
     * 
     * @Title: getStringbytesLongMinRowKey
     * @Description: rowkey(String byte steady.bytes byte ox00.Long byte 0x00)
     * @param strLength
     * @param bytesLength
     * @return 
     * @return RowKey
     * @throws
     */
    public static RowKey getStringbytesLongMinRowKey(int strLength,int bytesLength){
    	byte[] bytes=new byte[strLength+bytesLength+8];
    	for(int i=0;i<strLength+bytesLength+8;i++){//字节数组和long的字节小
    		bytes[i]=(byte)0x00;
    	}
    	return new BytesRowKey(bytes);
    }
    
    
    public static RowKey getStringIntIntMaxRowKey(int strLength){
    	byte[] bytes=new byte[strLength+8];
    	for (int i=0;i<strLength+8;i++) {
			bytes[i]=(byte)0xFF;
		}
    	return new BytesRowKey(bytes);
    }
    public static RowKey getStringIntIntMinRowKey(int strLength){
    	byte[] bytes=new byte[strLength+8];
    	for (int i=0;i<strLength+8;i++) {
			bytes[i]=(byte)0;
		}
    	return new BytesRowKey(bytes);
    }
    public static RowKey getStringStringIntMaxRowKey(int length1,int length2){
    	byte[] bytes=new byte[length1+length2+4];
    	for (int i=0;i<length1+length2+4;i++) {
			bytes[i]=(byte)0xFF;
		}
    	return new BytesRowKey(bytes);
    }
    public static RowKey getStringStringIntMinRowKey(int length1,int length2){
    	byte[] bytes=new byte[length1+length2+4];
    	for (int i=0;i<length1+length2+4;i++) {
			bytes[i]=(byte)0;
		}
    	return new BytesRowKey(bytes);
    }
    /**
     * 
     * @Title: getStringStringIntMaxRowKey
     * @Description: RowKey(string1 byte 0xFF.string2 byte steady.Int byte 0xFF)
     * @param length
     * @param str
     * @return 
     * @return RowKey
     * @throws
     */
    public static RowKey getStringStringIntMaxRowKey(int str1Length,String str){
    	int length=0;
    	byte[] strs=null;
    	if(str!=null){
    		length=str.length();
    		strs=Bytes.toBytes(str);
    	}
    	byte[] bytes=new byte[str1Length+length+4];
    	for(int i=0;i<str1Length;i++){
    		bytes[i]=(byte)0xFF;
    	}
    	for (int i=0;i<length;i++) {
			bytes[str1Length+i]=(byte)strs[i];
		}
    	for(int i=0;i<4;i++){
    		bytes[str1Length+length+i]=(byte)0xFF;
    	}
    	return new BytesRowKey(bytes);
    }
    /**
     * 
     * @Title: getStringStringIntMinRowKey
     * @Description: RowKey(string1 byte 0x00.string2 byte steady.Int byte 0x00)
     * @param str1Length
     * @param str
     * @return 
     * @return RowKey
     * @throws
     */
    public static RowKey getStringStringIntMinRowKey(int str1Length,String str){
    	int length=0;
    	byte[] strs=null;
    	if(str!=null){
    		length=str.length();
    		strs=Bytes.toBytes(str);
    	}
    	byte[] bytes=new byte[str1Length+length+4];
    	for(int i=0;i<str1Length;i++){
    		bytes[i]=(byte)0x00;
    	}
    	for (int i=0;i<length;i++) {
			bytes[str1Length+i]=(byte)strs[i];
		}
    	for(int i=0;i<4;i++){
    		bytes[str1Length+length+i]=(byte)0x00;
    	}
    	return new BytesRowKey(bytes);
    }
    
    
    
    /**
     * 
     * @Title: getStringStringIntMaxRowKey
     * @Description: RowKey(string1 byte 0xFF.string2 byte 0xFF.Int byte steady)
     * @param length
     * @param str
     * @return 
     * @return RowKey
     * @throws
     */
    public static RowKey getStringStringIntMaxRowKey(int str1Length,int str2Length,Integer value){
    	
    	byte[] bytes=new byte[str1Length+str2Length+4];
    	for(int i=0;i<str1Length+str2Length;i++){
    		bytes[i]=(byte)0xFF;
    	}
    	for (int i=0;i<4;i++) {
			bytes[str1Length+str2Length+i]=(byte)( (value>>(8*(3-i))) & 0xFF );
		}
    	return new BytesRowKey(bytes);
    }
    /**
     * 
     * @Title: getStringStringIntMinRowKey
     * @Description: RowKey(string1 byte 0x00.string2 byte 0x00.Int byte steady)
     * @param str1Length
     * @param str
     * @return 
     * @return RowKey
     * @throws
     */
    public static RowKey getStringStringIntMinRowKey(int str1Length,int str2Length,Integer value){
    	byte[] bytes=new byte[str1Length+str2Length+4];
    	for(int i=0;i<str1Length+str2Length;i++){
    		bytes[i]=(byte)0x00;
    	}
    	for (int i=0;i<4;i++) {
			bytes[str1Length+str2Length+i]=(byte)( (value>>(8*(3-i))) & 0xFF );
		}
    	return new BytesRowKey(bytes);
    }
    /**
     * 
     * @Title: getStringStringIntMaxRowKey
     * @Description: RowKey(string1 byte 0xFF.string2 byte steady.Int byte steady)
     * @param length
     * @param str
     * @return 
     * @return RowKey
     * @throws
     */
    public static RowKey getStringStringIntMaxRowKey(int str1Length,String str2,Integer value){
    	int length=0;
    	byte[] strs=null;
    	if(str2!=null){
    		length=str2.length();
    		strs=Bytes.toBytes(str2);
    	}
    	byte[] bytes=new byte[str1Length+length+4];
    	for(int i=0;i<str1Length;i++){
    		bytes[i]=(byte)0xFF;
    	}
    	for(int i=0;i<length;i++){
    		bytes[str1Length+i]=strs[i];
    	}
    	for (int i=0;i<4;i++) {
			bytes[str1Length+length+i]=(byte)( (value>>(8*(3-i))) & 0xFF );
		}
    	return new BytesRowKey(bytes);
    }
    /**
     * 
     * @Title: getStringStringIntMinRowKey
     * @Description: RowKey(string1 byte 0x00.string2 byte steady.Int byte steady)
     * @param str1Length
     * @param str
     * @return 
     * @return RowKey
     * @throws
     */
    public static RowKey getStringStringIntMinRowKey(int str1Length,String str2,Integer value){
    	int length=0;
    	byte[] strs=null;
    	if(str2!=null){
    		length=str2.length();
    		strs=Bytes.toBytes(str2);
    	}
    	byte[] bytes=new byte[str1Length+length+4];
    	for(int i=0;i<str1Length;i++){
    		bytes[i]=(byte)0x00;
    	}
    	for(int i=0;i<length;i++){
    		bytes[str1Length+i]=strs[i];
    	}
    	for (int i=0;i<4;i++) {
			bytes[str1Length+length+i]=(byte)( (value>>(8*(3-i))) & 0xFF );
		}
    	return new BytesRowKey(bytes);
    }
}
