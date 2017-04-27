package com.alipay.simplehbase.client;

import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.NamespaceDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.log4j.Logger;

import com.alipay.simplehbase.config.HBaseDataSource;
import com.alipay.simplehbase.exception.SimpleHBaseException;
import com.alipay.simplehbase.util.AdminUtil;
import com.alipay.simplehbase.util.Util;

/**
 * SimpleHbaseAdminClient's implementation.
 * 
 * @author xinzhi
 * */
public class SimpleHbaseAdminClientImpl implements SimpleHbaseAdminClient {

	/** log. */
	private static Logger log = Logger
			.getLogger(SimpleHbaseAdminClientImpl.class);
	/**
	 * HBaseDataSource.
	 * */
	private HBaseDataSource hbaseDataSource;

	@Override
	public void createTable(HTableDescriptor tableDescriptor) {
		Util.checkNull(tableDescriptor);

		try {

			Admin admin = AdminUtil.getAdmin();
			NamespaceDescriptor[] namespaceDescriptors = admin
					.listNamespaceDescriptors();

			String namespace = tableDescriptor.getTableName()
					.getNamespaceAsString();
			boolean isExist = false;
			for (NamespaceDescriptor nd : namespaceDescriptors) {
				if (nd.getName().equals(namespace)) {
					isExist = true;
					break;
				}
			}
			log.info("namespace " + namespace + " isExist " + isExist);
			if (!isExist) {

				admin.createNamespace(NamespaceDescriptor.create(namespace)
						.build());
			}

			admin.createTable(tableDescriptor);
			HTableDescriptor newTableDescriptor = admin
					.getTableDescriptor(tableDescriptor.getTableName());

			log.info("create table " + newTableDescriptor);
		} catch (Exception e) {
			log.error(e);
			throw new SimpleHBaseException(e);
		}
	}

	@Override
	public void deleteTable(String tableName) {
		Util.checkEmptyString(tableName);

		try {
			Admin admin = AdminUtil.getAdmin();
			// delete table if table exist.
			if (admin.tableExists(TableName.valueOf(tableName))) {
				// disable table before delete it.
				if (!admin.isTableDisabled(TableName.valueOf(tableName))) {
					admin.disableTable(TableName.valueOf(tableName));
				}
				admin.deleteTable(TableName.valueOf(tableName));
			}
		} catch (Exception e) {
			log.error(e);
			throw new SimpleHBaseException(e);
		}
	}

	@Override
	public HBaseDataSource getHbaseDataSource() {
		return this.hbaseDataSource;
	}

	@Override
	public void setHbaseDataSource(HBaseDataSource hbaseDataSource) {
		this.hbaseDataSource = hbaseDataSource;
	}

}
