package com.qingting.customer.dao.external.util;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Firrela
 * @time 2016/3/7.
 */
public class MainTest {

    private static Logger logger = LoggerFactory.getLogger(MainTest.class);

    private static String APPKEY = "205109dc931f265e656f0ac1debba897";  //AppKey
    private static String SECRET = "0c3a3c4a5782";  //AppSecret

    public static final void main(String[] args) throws IOException {
        //String res = createUser("HelloWorld", "名字", UUIDUtil.getUUID());
        String res = txMessage("17701879780","【阿里云】验证码为：207689，云邮用户，您正在进行通过手机找回密码操作(工作人员不会向您索取，请勿泄露)");
        System.out.println(res);
        //TODO: 对结果的业务处理，如解析返回结果，并保存成功注册的用户
    }

    public static String createUser(String accid, String name, String token) throws IOException {
        
    	
    	String url = "https://api.netease.im/nimserver/user/create.action";
        List<NameValuePair> params = new ArrayList<NameValuePair>();

        params.add(new BasicNameValuePair("accid", accid));
        params.add(new BasicNameValuePair("name", name));
        params.add(new BasicNameValuePair("token", token));

        //UTF-8编码,解决中文问题
        HttpEntity entity = new UrlEncodedFormEntity(params, "UTF-8");

        String res = NIMPost.postNIMServer(url, entity, APPKEY, SECRET);
        logger.info("createUser httpRes: {}", res);
        return res;
    }
    public static String txMessage(String phone,String content) throws IOException{
    	String url = "https://api.netease.im/sms/sendcode.action";
        List<NameValuePair> params = new ArrayList<NameValuePair>();

        params.add(new BasicNameValuePair("mobile", phone));
        params.add(new BasicNameValuePair("templateid", "3061345"));
        
        //params.add(new BasicNameValuePair("name", name));
        //params.add(new BasicNameValuePair("token", token));

        //UTF-8编码,解决中文问题
        HttpEntity entity = new UrlEncodedFormEntity(params, "UTF-8");

        String res = NIMPost.postNIMServer(url, entity, APPKEY, SECRET);
        logger.info("createUser httpRes: {}", res);
        return res;
    }
}
