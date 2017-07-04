package com.alipay.simplehbase.client.rowkeytextfun;

import com.alipay.simplehbase.client.rowkey.LongRowKey;
import com.qingting.customer.hbase.rowkey.RowKey;

public class LongTextFunc implements RowKeyTextFunc {

	@Override
    public RowKey func(String text) {
        long value = Long.parseLong(text);
        return new LongRowKey(value);
    }

    @Override
    public String funcName() {
        return "longkey";
    }

    @Override
    public String desc() {
        return "use long as rowkey";
    }
}
