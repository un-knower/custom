package com.qingting.customer.baseserver.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.ByteArrayRequestEntity;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpRequestEntityUtils
{
    protected static final int httpConnectionTimeOut = 30;
    
    protected final static Logger log = LoggerFactory.getLogger(HttpRequestEntityUtils.class);
    
    public static String post(String url, String params)
        throws IOException
    {
        String body = null;
        HttpClient httpClient = null;
        PostMethod method = null;
        
        try
        {
            httpClient = new HttpClient();
            
            method = new PostMethod(url);
            // 链接超时30秒
            httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(1000 * httpConnectionTimeOut);
            // 读取超时30秒
            httpClient.getHttpConnectionManager().getParams().setSoTimeout(1000 * httpConnectionTimeOut); //
            
            log.info("create http post:" + url);
            //RequestEntity requestEntity = new StringRequestEntity(params,"application/json","utf-8");
            RequestEntity requestEntity = new ByteArrayRequestEntity(params.getBytes("utf-8"),"application/x-www-form-urlencoded");
            method.setRequestEntity(requestEntity);
            
            httpClient.executeMethod(method);
            if (method.getStatusCode() == HttpStatus.SC_OK)
            {
                body = method.getResponseBodyAsString();
            }
            else
            {
                log.error("method.getStatusCode()" + method.getStatusCode());
            }
        }
        catch (IOException e)
        {
            log.error("IOException", e);
            throw e;
        }
        catch (Exception e)
        {
            log.error("Exception", e);
            throw e;
        }
        finally
        {
            if (method != null)
            {
                method.releaseConnection();
            }
        }
        return body;
    }
    
    public static String postPushStream(String url, InputStream inputStream)
        throws IOException
    {
        String body = null;
        HttpClient httpClient = null;
        PostMethod method = null;
        
        try
        {
            httpClient = new HttpClient();
            
            method = new PostMethod(url);
            // 链接超时30秒
            httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(1000 * httpConnectionTimeOut);
            // 读取超时30秒
            httpClient.getHttpConnectionManager().getParams().setSoTimeout(1000 * httpConnectionTimeOut); //
            
            log.info("create http post:" + url);
            RequestEntity requestEntity = new InputStreamRequestEntity(inputStream, "UTF-8");
            
            method.setRequestEntity(requestEntity);
            if (method.getStatusCode() == HttpStatus.SC_OK)
            {
                body = method.getResponseBodyAsString();
            }
            else
            {
                log.error("method.getStatusCode()" + method.getStatusCode());
            }
        }
        catch (IOException e)
        {
            log.error("IOException", e);
            throw e;
        }
        catch (Exception e)
        {
            log.error("Exception", e);
            throw e;
        }
        finally
        {
            if (method != null)
            {
                method.releaseConnection();
            }
        }
        return body;
    }
    
    public static InputStream postGetStream(String url, String params)
        throws IOException
    {
        InputStream body = null;
        HttpClient httpClient = null;
        PostMethod method = null;
        try
        {
            httpClient = new HttpClient();
            
            method = new PostMethod(url);
            // 链接超时30秒
            httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(1000 * httpConnectionTimeOut);
            // 读取超时30秒
            httpClient.getHttpConnectionManager().getParams().setSoTimeout(1000 * httpConnectionTimeOut); //
            
            log.info("create http post:" + url);
            RequestEntity requestEntity = new ByteArrayRequestEntity(params.getBytes("UTF-8"));
            
            method.setRequestEntity(requestEntity);
            if (method.getStatusCode() == HttpStatus.SC_OK)
            {
                body = method.getResponseBodyAsStream();
            }
            else
            {
                log.error("method.getStatusCode()" + method.getStatusCode());
            }
        }
        catch (IOException e)
        {
            log.error("IOException", e);
            throw e;
        }
        catch (Exception e)
        {
            log.error("Exception", e);
            throw e;
        }
        finally
        {
            if (method != null)
            {
                method.releaseConnection();
            }
        }
        return body;
    }
    
    public static String get(String url)
        throws IOException
    {
        String body = null;
        HttpClient httpClient = null;
        GetMethod method = null;
        
        try
        {
            httpClient = new HttpClient();
            
            method = new GetMethod(url);
            // 链接超时30秒
            httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(1000 * httpConnectionTimeOut);
            // 读取超时30秒
            httpClient.getHttpConnectionManager().getParams().setSoTimeout(1000 * httpConnectionTimeOut); //
            
            httpClient.executeMethod(method);
            
            log.info("create http get:" + url);
            if (method.getStatusCode() == HttpStatus.SC_OK)
            {
                body = method.getResponseBodyAsString();
            }
            else
            {
                log.error("method.getStatusCode()" + method.getStatusCode());
            }
        }
        catch (IOException e)
        {
            log.error("IOException", e);
            throw e;
        }
        catch (Exception e)
        {
            log.error("Exception", e);
            throw e;
        }
        finally
        {
            if (method != null)
            {
                method.releaseConnection();
            }
        }
        return body;
    }
    public static void main(String[] args) {
		try {
			//System.out.println(get("http://192.168.10.20:8088/mqttServer/testRule/get?topic=Monitor1"));
			//System.out.println(post("http://192.168.10.20:8088/mqttServer/equip/addEquip","{equipCode:\"1234567\",username:\"test\",password:\"test\"}"));
			System.out.println(post("http://192.168.10.20:8088/mqttServer/equip/addEquip","equipCode=\"123456\"&username=\"test\"&password=\"test\""));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}