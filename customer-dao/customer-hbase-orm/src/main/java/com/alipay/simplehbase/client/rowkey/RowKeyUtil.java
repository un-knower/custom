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
    public static RowKey getRowKey(Long value1,Integer value2){
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
    public static RowKey getRowKey(String value1,Long value2,Integer value3){
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
    public static RowKey getStringLongMaxRowKey(int strLength){
    	byte[] bytes=new byte[strLength+8];
    	for (int i=0;i<strLength+8;i++) {
			bytes[i]=(byte)0xFF;
		}
    	return new BytesRowKey(bytes);
    }
    public static RowKey getStringLongMinRowKey(int strLength){
    	byte[] bytes=new byte[strLength+8];
    	for (int i=0;i<strLength+8;i++) {
			bytes[i]=(byte)0;
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
}
