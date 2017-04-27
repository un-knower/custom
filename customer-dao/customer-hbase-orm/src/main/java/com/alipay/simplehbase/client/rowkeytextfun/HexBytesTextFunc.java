package com.alipay.simplehbase.client.rowkeytextfun;

import com.alipay.simplehbase.client.rowkey.BytesRowKey;
import com.alipay.simplehbase.util.EncodingUtil;
import com.qingting.customer.hbase.rowkey.RowKey;

/**
 * HexBytesTextFunc.
 * 
 * @author xinzhi.zhang
 * */
public class HexBytesTextFunc implements RowKeyTextFunc {

    @Override
    public RowKey func(String hexStr) {
        return new BytesRowKey(EncodingUtil.parseBytesFromHexString(hexStr));
    }

    @Override
    public String funcName() {
        return "hexkey";
    }

    @Override
    public String desc() {
        return "use hex string as rowkey";
    }

}