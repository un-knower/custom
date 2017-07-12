package com.alipay.simplehbase.client.service;

import java.util.List;
import java.util.Map;

import org.apache.hadoop.hbase.filter.Filter;

import com.alipay.simplehbase.client.PutRequest;
import com.alipay.simplehbase.client.QueryExtInfo;
import com.alipay.simplehbase.core.Nullable;
import com.alipay.simplehbase.exception.SimpleHBaseException;
import com.qingting.customer.hbase.doandkey.SimpleHbaseDOWithKeyResult;
import com.qingting.customer.hbase.rowkey.RowKey;


/**
 * BasicService
 * 
 * <pre>
 * Provides basic services.
 * </pre>
 * 
 * @author xinzhi.zhang
 * */
public interface BasicService {
    /**
     * Find object with row key.
     * 
     * @param rowKey rowKey.
     * @param type POJO type.
     * 
     * @return POJO.
     * */
    public <T> T findObject(RowKey rowKey, Class<? extends T> type);

    /**
     * Find object with row key.
     * 
     * @param rowKey rowKey.
     * @param type POJO type.
     * @param queryExtInfo queryExtInfo.
     * 
     * @return POJO.
     * */
    public <T> T findObject(RowKey rowKey, Class<? extends T> type,
            QueryExtInfo queryExtInfo);

    /**
     * Dynamic query to find POJO.
     * 
     * @param rowKey rowKey.
     * @param type POJO type.
     * @param id dynamic query id.
     * @param para parameter map.
     * 
     * @return POJO.
     * */
    public <T> T findObject(RowKey rowKey, Class<? extends T> type, String id,
            @Nullable Map<String, Object> para);

    /**
     * Dynamic query to find POJO.
     * 
     * @param rowKey rowKey.
     * @param type POJO type.
     * @param id dynamic query id.
     * @param para parameter map.
     * @param queryExtInfo queryExtInfo.
     * 
     * @return POJO.
     * */
    public <T> T findObject(RowKey rowKey, Class<? extends T> type, String id,
            @Nullable Map<String, Object> para, QueryExtInfo queryExtInfo);

    /**
     * Find POJO list with range in [startRowKey,endRowKey).
     * 
     * @param startRowKey startRowKey.
     * @param endRowKey endRowKey.
     * @param type POJO type.
     * @return POJO list.
     * */
    public <T> List<T> findObjectList(RowKey startRowKey, RowKey endRowKey,
            Class<? extends T> type);

    /**
     * Find POJO list with range in [startRowKey,endRowKey).
     * 
     * @param startRowKey startRowKey.
     * @param endRowKey endRowKey.
     * @param type POJO type.
     * @param queryExtInfo queryExtInfo.
     * 
     * @return POJO list.
     * */
    public <T> List<T> findObjectList(RowKey startRowKey, RowKey endRowKey,
            Class<? extends T> type, QueryExtInfo queryExtInfo);

    /**
     * Dynamic query to find POJO list with range in [startRowKey,endRowKey).
     * 
     * @param startRowKey startRowKey.
     * @param endRowKey endRowKey.
     * @param type POJO type.
     * @param id dynamic query id.
     * @param para parameter map.
     * 
     * @return POJO list.
     * */
    public <T> List<T> findObjectList(RowKey startRowKey, RowKey endRowKey,
            Class<? extends T> type, String id,
            @Nullable Map<String, Object> para);

    /**
     * Dynamic query to find POJO list with range in [startRowKey,endRowKey).
     * 
     * @param startRowKey startRowKey.
     * @param endRowKey endRowKey.
     * @param type POJO type.
     * @param id dynamic query id.
     * @param para parameter map.
     * @param queryExtInfo queryExtInfo.
     * 
     * @return POJO list.
     * */
    public <T> List<T> findObjectList(RowKey startRowKey, RowKey endRowKey,
            Class<? extends T> type, String id,
            @Nullable Map<String, Object> para, QueryExtInfo queryExtInfo);

    /**
     * Find object and row key with row key.
     * 
     * @param rowKey rowKey.
     * @param type POJO type.
     * 
     * @return POJO and key.
     * */
    public <T> SimpleHbaseDOWithKeyResult<T> findObjectAndKey(RowKey rowKey,
            Class<? extends T> type);

    /**
     * Find object and row key with row key.
     * 
     * @param rowKey rowKey.
     * @param type POJO type.
     * @param queryExtInfo queryExtInfo.
     * 
     * @return POJO and key.
     * */
    public <T> SimpleHbaseDOWithKeyResult<T> findObjectAndKey(RowKey rowKey,
            Class<? extends T> type, QueryExtInfo queryExtInfo);

    /**
     * Dynamic query to find POJO and row key.
     * 
     * @param rowKey rowKey.
     * @param type POJO type.
     * @param id dynamic query id.
     * @param para parameter map.
     * 
     * @return POJO and key.
     * */
    public <T> SimpleHbaseDOWithKeyResult<T> findObjectAndKey(RowKey rowKey,
            Class<? extends T> type, String id,
            @Nullable Map<String, Object> para);

    /**
     * Dynamic query to find POJO and row key.
     * 
     * @param rowKey rowKey.
     * @param type POJO type.
     * @param id dynamic query id.
     * @param para parameter map.
     * @param queryExtInfo queryExtInfo.
     * 
     * @return POJO and key.
     * */
    public <T> SimpleHbaseDOWithKeyResult<T> findObjectAndKey(RowKey rowKey,
            Class<? extends T> type, String id,
            @Nullable Map<String, Object> para, QueryExtInfo queryExtInfo);

    /**
     * Find POJO and row key list with range in [startRowKey,endRowKey).
     * 
     * @param startRowKey startRowKey.
     * @param endRowKey endRowKey.
     * @param type POJO type.
     * @return POJO and key list.
     * */
    public <T> List<SimpleHbaseDOWithKeyResult<T>> findObjectAndKeyList(
            RowKey startRowKey, RowKey endRowKey, Class<? extends T> type);

    /**
     * Find POJO and row key list with range in [startRowKey,endRowKey).
     * 
     * @param startRowKey startRowKey.
     * @param endRowKey endRowKey.
     * @param type POJO type.
     * @param queryExtInfo queryExtInfo.
     * 
     * @return POJO and key list.
     * */
    public <T> List<SimpleHbaseDOWithKeyResult<T>> findObjectAndKeyList(
            RowKey startRowKey, RowKey endRowKey, Class<? extends T> type,
            QueryExtInfo queryExtInfo);

    /**
     * Dynamic query to find POJO and row key list with range in
     * [startRowKey,endRowKey).
     * 
     * @param startRowKey startRowKey.
     * @param endRowKey endRowKey.
     * @param type POJO type.
     * @param id dynamic query id.
     * @param para parameter map.
     * 
     * @return POJO and key list.
     * */
    public <T> List<SimpleHbaseDOWithKeyResult<T>> findObjectAndKeyList(
            RowKey startRowKey, RowKey endRowKey, Class<? extends T> type,
            String id, @Nullable Map<String, Object> para);

    /**
     * Dynamic query to find POJO and row key list with range in
     * [startRowKey,endRowKey).
     * 
     * @param startRowKey startRowKey.
     * @param endRowKey endRowKey.
     * @param type POJO type.
     * @param id dynamic query id.
     * @param para parameter map.
     * @param queryExtInfo queryExtInfo.
     * 
     * @return POJO and key list.
     * */
    public <T> List<SimpleHbaseDOWithKeyResult<T>> findObjectAndKeyList(
            RowKey startRowKey, RowKey endRowKey, Class<? extends T> type,
            String id, @Nullable Map<String, Object> para,
            QueryExtInfo queryExtInfo);

    /**
     * Find POJO in batch mode.
     * 
     * @param rowKeyList rowKeyList.
     * @param type type.
     * 
     * @return POJO list.
     * */
    public <T> List<T> findObjectBatch(List<RowKey> rowKeyList,
            Class<? extends T> type);

    /**
     * Find POJO and key in batch mode.
     * 
     * @param rowKeyList rowKeyList.
     * @param type type.
     * 
     * @return POJO and key list.
     * */
    public <T> List<SimpleHbaseDOWithKeyResult<T>> findObjectAndKeyBatch(
            List<RowKey> rowKeyList, Class<? extends T> type);

    /**
     * Put POJO.
     * 
     * @param rowKey rowKey.
     * @param t POJO.
     * */
    public <T> void putObject(RowKey rowKey, T t);

    /**
     * Put POJO list.
     * 
     * @param putRequestList putObjectList.
     * */
    public <T> void putObjectList(List<PutRequest<T>> putRequestList);

    /**
     * Delete POJO.
     * 
     * @param rowKey rowKey.
     * @param type POJO type.
     * */
    public void deleteObject(RowKey rowKey, Class<?> type);

    /**
     * Delete POJO list.
     * 
     * @param rowKeyList rowKeyList.
     * @param type POJO type.
     * */
    public void deleteObjectList(List<RowKey> rowKeyList, Class<?> type);

    /**
     * Batch delete POJO list.
     * 
     * @param startRowKey startRowKey.
     * @param endRowKey endRowKey.
     * @param type POJO type.
     * 
     * */
    public void deleteObjectList(RowKey startRowKey, RowKey endRowKey,
            Class<?> type);

    /**
     * Delete.
     * 
     * @param rowKey rowKey.
     * */
    public void delete(RowKey rowKey);

    /**
     * Delete list.
     * 
     * @param rowKeyList rowKeyList.
     * */
    public void deleteList(List<RowKey> rowKeyList);

    /**
     * Batch delete list.
     * 
     * @param startRowKey startRowKey.
     * @param endRowKey endRowKey.
     * */
    public void deleteList(RowKey startRowKey, RowKey endRowKey);
    
    
    
    
    /**
     * author: zlf
     * date: 2017-07-11 
     * Dynamic query to find POJO and row key list with range in
     * [startRowKey,endRowKey).
     * 
     * @param startRowKey startRowKey.
     * @param endRowKey endRowKey.
     * @param type POJO type.
     * @param filter.
     * @param queryExtInfo queryExtInfo.
     * 
     * @return POJO and key list.
     * */
    public <T> List<SimpleHbaseDOWithKeyResult<T>> findObjectAndKeyList(
            RowKey startRowKey, RowKey endRowKey, Class<? extends T> type,
            Filter filter,QueryExtInfo queryExtInfo);
    /**
     * 求行数。求表中指定范围数据的行数。
     * 
     * <pre>
     * 注意:必须在创建表的时指定coprocessor:org.apache.hadoop.hbase.coprocessor.AggregateImplementation
     * ,否则无法运行
     * 
     * @param startRow
     * @param endRow
     * @param filter
     * @return
     * @throws SimpleHBaseException
     */
    public long count(RowKey startRowKey, RowKey endRowKey,Filter filter) throws SimpleHBaseException;
}
