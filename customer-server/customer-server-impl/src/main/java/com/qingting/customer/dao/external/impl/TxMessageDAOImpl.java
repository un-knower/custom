package com.qingting.customer.dao.external.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.qingting.customer.dao.external.TxMessageDAO;
import com.qingting.customer.dao.external.util.NIMPost;

@Repository("txMessageDAO")
public class TxMessageDAOImpl implements TxMessageDAO {
	
	private static Logger logger = LoggerFactory.getLogger(TxMessageDAOImpl.class);
	
	private static String APPKEY = "205109dc931f265e656f0ac1debba897";  //AppKey
    private static String SECRET = "0c3a3c4a5782";  //AppSecret

	public static void main(String[] args){
		//BatchPublishSMSMessage.txCode("17701879780", "2143");
		
		String phone="17701879780";
		String url = "https://api.netease.im/sms/sendcode.action";
        List<NameValuePair> params = new ArrayList<NameValuePair>();

        params.add(new BasicNameValuePair("mobile", phone));
        params.add(new BasicNameValuePair("templateid", "3061345"));

        //UTF-8编码,解决中文问题
        HttpEntity entity;
        String res=null;
		try {
			entity = new UrlEncodedFormEntity(params, "UTF-8");
			res = NIMPost.postNIMServer(url, entity, APPKEY, SECRET);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}
        logger.info("createUser httpRes: {}", res);
        
	}

	@Override
	public String  txValidateCode(String phone) {
		String url = "https://api.netease.im/sms/sendcode.action";
        List<NameValuePair> params = new ArrayList<NameValuePair>();

        params.add(new BasicNameValuePair("mobile", phone));
        params.add(new BasicNameValuePair("templateid", "3061345"));

        //UTF-8编码,解决中文问题
        HttpEntity entity;
        String res=null;
		try {
			entity = new UrlEncodedFormEntity(params, "UTF-8");
			res = NIMPost.postNIMServer(url, entity, APPKEY, SECRET);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}
        logger.info("createUser httpRes: {}", res);
        return res;
	}
}
