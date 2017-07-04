package com.alipay.simplehbase.client.rowkey;

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
    
    private static final int INTEGET_BYTENUM=4;
    
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
    public static RowKey getMaxRowKey(Integer value){
    	
    	byte[] bytes=new byte[INTEGET_BYTENUM];
    	
    	if(Util.integerIsBlank(value)){//Integer空
    		for(int i=0;i<INTEGET_BYTENUM;i++)
    			bytes[i]=(byte)0xFF;
    		return new BytesRowKey(bytes);
    	}else if(!Util.integerIsBlank(value)){//Integer不为空
    		return getEndRowKeyOfPrefix(getRowKey(value));
    	}else{
    		throw new SimpleHBaseException("Unable to get the MaxRowKey.");
    	}
    }
    public static RowKey getMinRowKey(Integer value){
    	
    	byte[] bytes=new byte[INTEGET_BYTENUM];
    	
    	if(Util.integerIsBlank(value)){//Integer空
    		return new BytesRowKey(bytes);
    	}else if(!Util.integerIsBlank(value)){//Integer不为空
    		return getRowKey(value);
    	}else{
    		throw new SimpleHBaseException("Unable to get the MinRowKey.");
    	}
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
    
    /**
     * 
     * @Title: getRowKey
     * @Description: 获得RowKey(value1+value2)
     * @param value1
     * @param value2
     * @return RowKey
     * @throws
     */
    public static RowKey getRowKey(Long value1,Integer value2){
    	return new BytesRowKey(
    			BytesUtil.merge(Bytes.toBytes(value1), Bytes.toBytes(value2))
    			);
    }
    /**
     * 
     * @Title: getRowKey
     * @Description: 获得RowKey(longText+value)
     * @param longText long类型数据的字符串
     * @param value
     * @return RowKey
     * @throws
     */
    public static RowKey getRowKey(String longText,Integer value){
    	return new BytesRowKey(
    			BytesUtil.merge(Bytes.toBytes(longText),Bytes.toBytes(value))
    			);
    }
    public static RowKey getMaxRowKey(String longText,Integer longTextLength,Integer value){
    	
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
}
