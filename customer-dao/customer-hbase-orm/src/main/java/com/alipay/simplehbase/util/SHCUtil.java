package com.alipay.simplehbase.util;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.springframework.core.io.Resource;

import com.alipay.simplehbase.cache.CachedFileSystemResource;
import com.alipay.simplehbase.client.SimpleHbaseAdminClient;
import com.alipay.simplehbase.client.SimpleHbaseAdminClientImpl;
import com.alipay.simplehbase.client.SimpleHbaseClient;
import com.alipay.simplehbase.client.SimpleHbaseClientFactory;
import com.alipay.simplehbase.client.SimpleHbaseClientImpl;
import com.alipay.simplehbase.config.HBaseDataSource;
import com.alipay.simplehbase.config.HBaseTableConfig;



public class SHCUtil{
	final public static String classpath=Thread.currentThread().getContextClassLoader().getResource("").getPath();

	final public static String HbaseSiteFile = classpath+"hbase_site";
	final public static String ZkConfigFile = classpath+"zk_conf";

	final public static List<String> xmlFile=
			new ArrayList<>(Arrays.asList(
					"project","equip","monitor",
					"user","message"
					));;
	private static volatile SimpleHbaseClient simpleHbaseClient;
	private static volatile SimpleHbaseAdminClient simpleHbaseAdminClient;
	private static List<SimpleHbaseClient> listSHC=new ArrayList<SimpleHbaseClient>();
	
	public void createTable(String tableName,String columnFamily) {
		// create new table.
		HTableDescriptor tableDescriptor = new HTableDescriptor(
				TableNameUtil.getTableName(tableName));
		tableDescriptor.addFamily(new HColumnDescriptor(columnFamily)
				.setMaxVersions(1));
		simpleHbaseAdminClient.createTable(tableDescriptor);
	}
	public void deleteTable(String tableName) {
		// delete the Table
		simpleHbaseAdminClient.deleteTable(tableName);
	}
	static{
		HBaseDataSource hbaseDataSource = new HBaseDataSource();
		List<Resource> hbaseConfigResources = new ArrayList<Resource>();
		hbaseConfigResources.add(new CachedFileSystemResource(
				SHCUtil.HbaseSiteFile));
		hbaseConfigResources.add(new CachedFileSystemResource(
				SHCUtil.ZkConfigFile));
		hbaseDataSource.setHbaseConfigResources(hbaseConfigResources);
		hbaseDataSource.init();
		//获得hbase客户端管理对象，建表用
		simpleHbaseAdminClient = SimpleHbaseClientFactory.getWrapper(
				SimpleHbaseAdminClient.class, new SimpleHbaseAdminClientImpl());
		simpleHbaseAdminClient.setHbaseDataSource(hbaseDataSource);
		
		for (String str: xmlFile) {
			HBaseTableConfig hbaseTableConfig = new HBaseTableConfig();
			hbaseTableConfig.setConfigResource(new CachedFileSystemResource(
					classpath+str+".xml"));
			hbaseTableConfig.init();

			SimpleHbaseClient tClient = new SimpleHbaseClientImpl();
			tClient.setHbaseDataSource(hbaseDataSource);
			tClient.setHbaseTableConfig(hbaseTableConfig);
			simpleHbaseClient = SimpleHbaseClientFactory.getSimpleHbaseClient(tClient);
			listSHC.add(tClient);
			System.out.println("xmlFile="+xmlFile);
			
			try {
				if(AdminUtil.getAdmin().tableExists(TableNameUtil.getTableName(str))){
					System.out.println("表存在："+str);
				}else{
					System.out.println("表不存在，准备创建:~~~~~");
					// 如表不存在则创建
					HTableDescriptor tableDescriptor = new HTableDescriptor(TableNameUtil.getTableName(str));
					tableDescriptor.addFamily(new HColumnDescriptor(str+"Family").setMaxVersions(1));
					simpleHbaseAdminClient.createTable(tableDescriptor);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	/*static {
		HBaseDataSource hbaseDataSource = new HBaseDataSource();

		List<Resource> hbaseConfigResources = new ArrayList<Resource>();
		// If run on hbase cluster, modify the following config files.
		// If run on hbase stand alone mode, comment out the following config
		// files.
		//System.out.println("路径："+Thread.currentThread().getContextClassLoader().getResource("").getPath());
		//File file=new File(Thread.currentThread().getContextClassLoader().getResource("").getPath()+SHCUtil.HbaseSiteFile);
		//System.out.println("文件存在吗？"+file.exists());
		hbaseConfigResources.add(new CachedFileSystemResource(
				SHCUtil.HbaseSiteFile));
		hbaseConfigResources.add(new CachedFileSystemResource(
				SHCUtil.ZkConfigFile));
		hbaseDataSource.setHbaseConfigResources(hbaseConfigResources);

		hbaseDataSource.init();

		HBaseTableConfig hbaseTableConfig = new HBaseTableConfig();
		hbaseTableConfig.setConfigResource(new CachedFileSystemResource(
				MyRecordXmlFile));
		hbaseTableConfig.init();

		// SimpleHbaseClient tClient = new SimpleHbaseClientImpl();
		shc = new SimpleHbaseClientImpl();
		shc.setHbaseDataSource(hbaseDataSource);
		shc.setHbaseTableConfig(hbaseTableConfig);

		simpleHbaseClient = SimpleHbaseClientFactory.getSimpleHbaseClient(shc);

		simpleHbaseAdminClient = SimpleHbaseClientFactory.getWrapper(
				SimpleHbaseAdminClient.class, new SimpleHbaseAdminClientImpl());
		simpleHbaseAdminClient.setHbaseDataSource(simpleHbaseClient
				.getHbaseDataSource());
		
	}*/
	/**
	 * 
	 * @Title: getSHC
	 * @Description: 获得对应Table预先创建的simpleHbaseClient对象
	 * @param fileName
	 * @return 
	 * @return SimpleHbaseClient
	 * @throws
	 */
	public static SimpleHbaseClient getSHC(String fileName) {
		for(int i=0;i<xmlFile.size();i++){
			if(fileName.equals(xmlFile.get(i))){
				if(listSHC.get(i)!=null){
					return listSHC.get(i);
				}else{
					System.out.println("没有创建对应的SimpleHbaseClient实体");
				}
			}
		}
		System.out.println("找不到对应的实体xml文件，请确保xml文件名正确");
		return null;
	}
}
