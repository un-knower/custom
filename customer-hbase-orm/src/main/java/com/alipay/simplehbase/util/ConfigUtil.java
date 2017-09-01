package com.alipay.simplehbase.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.core.io.Resource;

import com.alipay.simplehbase.cache.CachedFileSystemResource;
import com.alipay.simplehbase.config.HBaseDataSource;
import com.alipay.simplehbase.core.Nullable;

/**
 * ConfigUtil.
 * 
 * @author xinzhi
 * */
public class ConfigUtil {

    /** log. */
    private static Logger log = Logger.getLogger(ConfigUtil.class);

    /**
     * Return positive integer value by parsing the value with key in config,
     * otherwise returns defaultValue.
     * */
    public static int parsePositiveInt(Map<String, String> config, String key,
            int defaultValue) {
        Util.checkNull(config);
        Util.checkEmptyString(key);
        Util.check(defaultValue > 0);

        try {
            String vaule = config.get(key);
            int result = Integer.parseInt(vaule);
            if (result > 0) {
                return result;
            } else {
                return defaultValue;
            }
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * Load config file.
     * */
    public static Map<String, String> loadConfigFile(
            @Nullable InputStream inputStream) throws IOException {

        Map<String, String> result = new HashMap<String, String>();
        if (inputStream == null) {
            return result;
        }

        LineNumberReader lineNumberReader = null;
        try {
            lineNumberReader = new LineNumberReader(new InputStreamReader(
                    inputStream));
            for (String line = lineNumberReader.readLine(); line != null; line = lineNumberReader
                    .readLine()) {

                String[] parts = line.split("=");
                if (parts == null || parts.length != 2) {
                    log.warn("wrong config line.  line=" + line);
                    continue;
                }

                result.put(parts[0], parts[1]);
            }
        } finally {
            if (lineNumberReader != null) {
                lineNumberReader.close();
            }
        }

        return result;
    }

    private ConfigUtil() {
    }
    
    /**
     * 数据源配置文件解析
     */
    private static String classpath=null;
	private static String hbaseSiteFile;
	private static String zkConfigFile;
	public static HBaseDataSource hbaseDataSource;
	
    static{
    	String system=System.getProperty("os.name");
		if(system.indexOf("Windows")!=-1){//window系统
			String str=Thread.currentThread().getContextClassLoader().getResource("").getPath();
			System.out.println("str="+str);
			System.out.println("index="+str.indexOf("/"));
			if(str.indexOf("/")==0){
				System.out.println("str.substring(1)="+str.substring(1));
				classpath=str.substring(1);
			}else{
				classpath=str;
			}
		}else{
			classpath=Thread.currentThread().getContextClassLoader().getResource("").getPath();
		}
		hbaseSiteFile = classpath+"hbase_site";
		zkConfigFile = classpath+"zk_conf";
		hbaseDataSource = new HBaseDataSource();
		List<Resource> hbaseConfigResources = new ArrayList<Resource>();
		hbaseConfigResources.add(new CachedFileSystemResource(
				hbaseSiteFile));
		hbaseConfigResources.add(new CachedFileSystemResource(
				zkConfigFile));
		hbaseDataSource.setHbaseConfigResources(hbaseConfigResources);
		hbaseDataSource.init();
    }

	public static HBaseDataSource getHbaseDataSource() {
		return hbaseDataSource;
	}

	public static void setHbaseDataSource(HBaseDataSource hbaseDataSource) {
		ConfigUtil.hbaseDataSource = hbaseDataSource;
	}
    
}
