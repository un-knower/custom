package com.alipay.simplehbase.client.rowkey;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.hadoop.hbase.util.Bytes;

import com.qingting.customer.hbase.rowkey.RowKey;

public class LongRowKey implements RowKey {

	private long value;

    public LongRowKey(long value) {
        this.value = value;
    }

    @Override
    public byte[] toBytes() {
        return Bytes.toBytes(value);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
