package com.alipay.simplehbase.client.rowkeytextfun;

import com.alipay.simplehbase.client.rowkey.StringRowKey;
import com.qingting.customer.hbase.rowkey.RowKey;

/**
 * @author xinzhi
 * */
public class StringTextFunc implements RowKeyTextFunc {

    @Override
    public RowKey func(String text) {
        return new StringRowKey(text);
    }

    @Override
    public String funcName() {
        return "stringkey";
    }

    @Override
    public String desc() {
        return "use string as rowkey.";
    }

}