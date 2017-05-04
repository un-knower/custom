package com.qingting.customer.common.pojo.rowkey;

import java.io.Serializable;

import org.apache.hadoop.hbase.util.Bytes;

import com.qingting.customer.hbase.rowkey.RowKey;

public class BaseRowKey implements RowKey, Serializable {
	private static final long serialVersionUID = 9133821964236991160L;
	
	private int row;

    public BaseRowKey(int row) {
        this.row = row;
        
    }

    @Override
    public byte[] toBytes() {
        return Bytes.toBytes(row);
    }

}
