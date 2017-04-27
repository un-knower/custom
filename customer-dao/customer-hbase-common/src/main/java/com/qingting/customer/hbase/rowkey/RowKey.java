package com.qingting.customer.hbase.rowkey;

/**
 * RowKey.
 * 
 * <pre>
 * The row key of hbase table.
 * </pre>
 * 
 * @author xinzhi
 * */
public interface RowKey {

    /**
     * Convert row key to bytes.
     * 
     * @return row key's bytes.
     * */
    public byte[] toBytes();
}
