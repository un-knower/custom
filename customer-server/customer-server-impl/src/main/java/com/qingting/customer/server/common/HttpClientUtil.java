package com.qingting.customer.server.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod; 
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.URIException; 
import org.apache.commons.httpclient.methods.GetMethod; 
import org.apache.commons.httpclient.methods.PostMethod; 
import org.apache.commons.httpclient.params.HttpMethodParams; 
import org.apache.commons.httpclient.util.URIUtil; 
import org.apache.commons.lang.StringUtils; 

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map; 

public class HttpClientUtil {
	private static Logger LOGGER = LoggerFactory.getLogger(HttpClientUtil.class); 
	/** 
     * 向指定URL发送AJAX-POST方法的请求，返回json字符串 
     *@param url 发送请求的URL 
     *@return URL所代表远程资源的响应 
     */ 
	public static String sendPost(String url, String param) { 
	    OutputStreamWriter out= null;
	    BufferedReader in= null;
	    String result= "";
        try{
        	URL realUrl= new URL(url);
            // 打开和URL之间的连接
            URLConnection conn= realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept","*/*");
            conn.setRequestProperty("connection","Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流             
            out= new OutputStreamWriter(conn.getOutputStream(),"UTF-8");
            // 发送请求参数
            out.write(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in= new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while((line= in.readLine()) !=null) {
                result+= line;
            }
        }catch(Exception e) {
        	LOGGER.error("发送 POST请求出现异常！");
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                 }
                if(in!=null){
                    in.close();
                 }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
     } 
	/** 
     * 执行一个HTTP GET请求，返回请求响应的HTML 
     * 
     * @param url                 请求的URL地址 
     * @param queryString 请求的查询参数,可以为null 
     * @return 返回请求响应的HTML 
     */ 
    public static String doGet(String url, String queryString) { 
	    String response = null; 
	    HttpClient client = new HttpClient(); 
	    HttpMethod method = new GetMethod(url); 
	    try { 
	        if (StringUtils.isNotBlank(queryString)) 
	                method.setQueryString(URIUtil.encodeQuery(queryString)); 
	        client.executeMethod(method); 
	        if (method.getStatusCode() == HttpStatus.SC_OK) { 
	                response = method.getResponseBodyAsString(); 
	        } 
	    } catch (URIException e) { 
	    	LOGGER.error("执行HTTP Get请求时，编码查询字符串“" + queryString + "”发生异常！", e); 
	    } catch (IOException e) { 
	    	LOGGER.error("执行HTTP Get请求" + url + "时，发生异常！", e); 
	    } finally { 
	            method.releaseConnection(); 
	    } 
	    return response; 
    } 

    /** 
     * 执行一个HTTP POST请求，返回请求响应的HTML 
     * 
     * @param url        请求的URL地址 
     * @param params 请求的查询参数,可以为null 
     * @return 返回请求响应的HTML 
     */ 
    public static String doPost(String url, Map<String, String> params) { 
        String response = null; 
        HttpClient client = new HttpClient(); 
        HttpMethod method = new PostMethod(url); 
        /*for (Iterator it = params.entrySet().iterator(); it.hasNext();) { 

        }*/ 
        //设置Http Post数据 
        if (params != null) { 
            HttpMethodParams p = new HttpMethodParams(); 
            for (Map.Entry<String, String> entry : params.entrySet()) { 
                    p.setParameter(entry.getKey(), entry.getValue()); 
            } 
            method.setParams(p); 
        } 
        try { 
            client.executeMethod(method); 
            if (method.getStatusCode() == HttpStatus.SC_OK) { 
                    response = method.getResponseBodyAsString(); 
            } 
        } catch (IOException e) { 
        	LOGGER.error("执行HTTP Post请求" + url + "时，发生异常！", e); 
        } finally { 
            method.releaseConnection(); 
        } 

        return response; 
    }
    /*public static void main(String[] args) {
		String doGet = doPost("https://www.baidu.com/", null);
		System.out.println(doGet);
	}*/
    
    public static void method(HttpClient client,String url,String body){  
        PostMethod  method = new PostMethod(url);  
          //"count":10,"ignoreCase":"false","paras":["a%"],"queryId":"getMenu"  
          NameValuePair[] postData = new NameValuePair[]{};    
          //postData[0] = new NameValuePair("count", 10);   
          method.setRequestBody(body);//addParameters(postData);   
            
            
          // Provide custom retry handler is necessary  
          /*method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,  
                  new DefaultHttpMethodRetryHandler(3, false));*/  
    
          try {  
            // Execute the method.  
            int statusCode = client.executeMethod(method);  
    
            if (statusCode != HttpStatus.SC_OK) {  
              System.err.println("Method failed: " + method.getStatusLine());  
            }  
    
            // Read the response body.  
            byte[] responseBody = method.getResponseBody();  
    
            // Deal with the response.  
            // Use caution: ensure correct character encoding and is not binary data  
            System.out.println(new String(responseBody,"utf-8"));  
          } catch (HttpException e) {  
              System.err.println("Fatal protocol violation: " + e.getMessage());  
              e.printStackTrace();  
            } catch (IOException e) {  
              System.err.println("Fatal transport error: " + e.getMessage());  
              e.printStackTrace();  
            } finally {  
              // Release the connection.  
              method.releaseConnection();  
            }    
    }  
    private static String url = "http://192.168.10.20:8088/mqttServer/equip/addEquip"; 
    public static void main(String[] args) {  
      // Create an instance of HttpClient.  
      HttpClient client = new HttpClient();  
        
      //String body ="[{equipCode:\"12345\",username:\"test\",password:\"test\"}]";  
      String body ="equipCode:\"12345\"&username:\"test\"&password:\"test\"";  
      // Create a method instance.  
      method(client,url,body);  
        
      url = "http://192.168.10.20:8088/mqttServer/equip/addEquip";  
        
      body = "[{equipCode:\"12345\",username:\"test\",password:\"test\"}]";  
      method(client,url,body);  
    }  
}
