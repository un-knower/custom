package com.alipay.simplehbase.util;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;

import com.alipay.simplehbase.client.DeleteRequest;
import com.alipay.simplehbase.client.PutRequest;
import com.alipay.simplehbase.core.Nullable;
import com.alipay.simplehbase.exception.SimpleHBaseException;
import com.qingting.customer.hbase.rowkey.RowKey;

/**
 * Client Util.
 * 
 * @author xinzhi
 * */
public class Util {

    /**
     * Check boolean is NOT false.
     * */
    public static void check(boolean bool) {
        if (bool == false) {
            throw new SimpleHBaseException("bool is false.");
        }
    }

    /**
     * Check object is NOT null.
     * */
    public static void checkNull(Object obj) {
        if (obj == null) {
            throw new SimpleHBaseException("obj  is null.");
        }
    }

    /**
     * Check for string is NOT null or empty string.
     * No return.
     * Throw SimpleHBaseException.
     * */
    public static void checkEmptyString(String str) {
        if (StringUtil.isEmptyString(str)) {
            throw new SimpleHBaseException("str is null or empty.");
        }
    }
    
    /**
	 * 验证可能为空格或者""及null的字符串
	 * 
	 * <pre>
	 *   Util.stringIsBlank(null)      = true
	 *   Util.stringIsBlank(&quot;&quot;)        = true
	 *   Util.stringIsBlank(&quot; &quot;)       = true
	 *   Util.stringIsBlank(&quot;bob&quot;)     = false
	 *   Util.stringIsBlank(&quot;  bob  &quot;) = false
	 * </pre>
	 * 
	 * @param cs
	 *            可能为空格或者""及null的字符序列
	 * @return
	 */
	public static boolean stringIsBlank(final CharSequence cs) {
		int strLen;
		if (cs == null || (strLen = cs.length()) == 0) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if ((Character.isWhitespace(cs.charAt(i)) == false)) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean integerIsBlank(Integer integer){
		if(integer==null || integer.equals(0))
			return true;
		else
			return false;
	}
	
    /**
     * Check the value's length.
     * */
    public static void checkLength(byte[] values, int length) {
        Util.checkNull(values);

        if (values.length != length) {
            throw new SimpleHBaseException("checkLength error. values.length="
                    + values.length + " length=" + length);
        }
    }

    /**
     * Check string's length.
     * */
    public static void checkLength(String str, int length) {
        Util.checkNull(str);

        if (str.length() != length) {
            throw new SimpleHBaseException("checkLength error. str=" + str
                    + " length=" + length);
        }
    }

    /**
     * Check rowKey.
     * 
     * <pre>
     * rowKey is not null.
     * the result of rowKey's toBytes is not null.
     * </pre>
     * 
     * */
    public static void checkRowKey(RowKey rowKey) {
        checkNull(rowKey);

        if (rowKey.toBytes() == null) {
            throw new SimpleHBaseException("rowkey bytes is null. rowKey = "
                    + rowKey);
        }
    }

    /**
     * Check rowKey list.
     * 
     * <pre>
     * rowKeyList is not null or empty.
     * each row key in list is valid.
     * </pre>
     * 
     * */
    public static void checkRowKeyList(List<RowKey> rowKeyList) {
        Util.checkNull(rowKeyList);
        Util.check(!rowKeyList.isEmpty());

        for (RowKey rowKey : rowKeyList) {
            Util.checkRowKey(rowKey);
        }
    }

    /**
     * Check put request.
     * */
    public static void checkPutRequest(PutRequest<?> putRequest) {
        checkNull(putRequest);
        checkRowKey(putRequest.getRowKey());
        checkNull(putRequest.getT());
    }

    /**
     * Check Delete request.
     * */
    public static void checkDeleteRequest(DeleteRequest deleteRequest) {
        checkNull(deleteRequest);
        checkRowKey(deleteRequest.getRowKey());
    }

    /**
     * Check for 2 objects have identity type.
     * */
    public static void checkIdentityType(Object one, Object other) {
        checkNull(one);
        checkNull(other);

        if (one.getClass() != other.getClass()) {
            throw new SimpleHBaseException("not same type. one = " + one
                    + " other = " + other);
        }
    }

    /**
     * Check for 2 objects are equal.
     * */
    public static void checkEquals(Object one, Object other) {
        if (one == other) {
            return;
        }

        if (one == null || other == null) {
            throw new SimpleHBaseException("null object. one = " + one
                    + " other = " + other);
        }
        if (!one.equals(other)) {
            throw new SimpleHBaseException("not equal object. one = " + one
                    + " other = " + other);
        }
    }

    /**
     * Close Closeable.
     * */
    public static void close(@Nullable Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e) {
            throw new SimpleHBaseException("close closeable exception.", e);
        }
    }

    private Util() {
    }
}
