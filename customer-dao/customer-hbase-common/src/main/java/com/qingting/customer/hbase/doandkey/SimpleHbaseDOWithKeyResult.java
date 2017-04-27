package com.qingting.customer.hbase.doandkey;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import com.qingting.customer.hbase.rowkey.RowKey;

/**
 * DOWithKeyResult.
 * 
 * <pre>
 * All the cell on latest timestamp are mapped to one DO.
 * </pre>
 * 
 * @author xinzhi.zhang
 * */
public class SimpleHbaseDOWithKeyResult<T> {
    /** rowkey. */
    private RowKey rowKey;
    /** The mapping result of DO. */
    private T      t;

    public void setT(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public RowKey getRowKey() {
        return rowKey;
    }

    public void setRowKey(RowKey rowKey) {
        this.rowKey = rowKey;
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
