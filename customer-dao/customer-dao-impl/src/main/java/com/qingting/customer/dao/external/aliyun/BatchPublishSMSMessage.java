package com.qingting.customer.dao.external.aliyun;

import com.aliyun.mns.client.CloudAccount;
import com.aliyun.mns.client.CloudTopic;
import com.aliyun.mns.client.MNSClient;
import com.aliyun.mns.common.ServiceException;
import com.aliyun.mns.model.BatchSmsAttributes;
import com.aliyun.mns.model.MessageAttributes;
import com.aliyun.mns.model.RawTopicMessage;
import com.aliyun.mns.model.TopicMessage;

public class BatchPublishSMSMessage {
	/** 访问控制AccessKeyId/YourAccessId */
	private static String accessKeyId="LTAIxMRH63HPhmCW";
	/** 访问控制accessKeySecret/YourAccessKey */
	private static String accessKeySecret="S1aoH8VXPN6YxMTpJgmXN3kAiqZkgp";
	/** 队列>获取Endpoint */
	private static String endpoint="https://1029380931589600.mns.cn-hangzhou.aliyuncs.com/";
	/** 主体名称 */
	private static String topicName="sms.topic-cn-hangzhou";
	/** 签名名称 */
	private static String signName="智慧饮水管家";
	/** 模板CODE */
	private static String templateCode="SMS_66010192";
	
	public static String txCode(String phone,String code){
		/**
         * Step 1. 获取主题引用
         */
        CloudAccount account = new CloudAccount(accessKeyId, accessKeySecret, endpoint);
        MNSClient client = account.getMNSClient();
        CloudTopic topic = client.getTopicRef(topicName);
        /**
         * Step 2. 设置SMS消息体（必须）
         *
         * 注：目前暂时不支持消息内容为空，需要指定消息内容，不为空即可。
         */
        RawTopicMessage msg = new RawTopicMessage();
        msg.setMessageBody("sms-message");
        /**
         * Step 3. 生成SMS消息属性
         */
        MessageAttributes messageAttributes = new MessageAttributes();
        BatchSmsAttributes batchSmsAttributes = new BatchSmsAttributes();
        // 3.1 设置发送短信的签名（SMSSignName）
        batchSmsAttributes.setFreeSignName(signName);
        // 3.2 设置发送短信使用的模板（SMSTempateCode）
        batchSmsAttributes.setTemplateCode(templateCode);
        // 3.3 设置发送短信所使用的模板中参数对应的值（在短信模板中定义的，没有可以不用设置）
        BatchSmsAttributes.SmsReceiverParams smsReceiverParams = new BatchSmsAttributes.SmsReceiverParams();
        smsReceiverParams.setParam("code", code);
        //smsReceiverParams.setParam("$YourSMSTemplateParamKey2", "$value2");
        // 3.4 增加接收短信的号码
        batchSmsAttributes.addSmsReceiver(phone, smsReceiverParams);
        //batchSmsAttributes.addSmsReceiver("$YourReceiverPhoneNumber2", smsReceiverParams);
        messageAttributes.setBatchSmsAttributes(batchSmsAttributes);
        TopicMessage ret=null;
        try {
            /**
             * Step 4. 发布SMS消息
             */
            ret = topic.publishMessage(msg, messageAttributes);
            System.out.println("MessageId: " + ret.getMessageId());
            System.out.println("MessageMD5: " + ret.getMessageBodyMD5());
            System.out.println("MessageBody:"+ret.getMessageBody());
            System.out.println("tag:"+ret.getMessageTag());
        } catch (ServiceException se) {
            System.out.println(se.getErrorCode() + se.getRequestId());
            System.out.println(se.getMessage());
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        client.close();
        return ret.getMessageTag();
	}
	
	public static void main(String[] args) {
		String accessKeyId="LTAIxMRH63HPhmCW";
		String accessKeySecret="S1aoH8VXPN6YxMTpJgmXN3kAiqZkgp";
		String endpoint="https://1029380931589600.mns.cn-shenzhen.aliyuncs.com/";
		String topicName="sms.topic-cn-shenzhen";
		String signName="智慧饮水管家";
		String templateCode="SMS_66010192";
		String code="1234";
		String phone="17701879780";
        /**
         * Step 1. 获取主题引用
         */
        CloudAccount account = new CloudAccount(accessKeyId, accessKeySecret, endpoint);
        MNSClient client = account.getMNSClient();
        CloudTopic topic = client.getTopicRef(topicName);
        /**
         * Step 2. 设置SMS消息体（必须）
         *
         * 注：目前暂时不支持消息内容为空，需要指定消息内容，不为空即可。
         */
        RawTopicMessage msg = new RawTopicMessage();
        msg.setMessageBody("sms-message");
        /**
         * Step 3. 生成SMS消息属性
         */
        MessageAttributes messageAttributes = new MessageAttributes();
        BatchSmsAttributes batchSmsAttributes = new BatchSmsAttributes();
        // 3.1 设置发送短信的签名（SMSSignName）
        batchSmsAttributes.setFreeSignName(signName);
        // 3.2 设置发送短信使用的模板（SMSTempateCode）
        batchSmsAttributes.setTemplateCode(templateCode);
        // 3.3 设置发送短信所使用的模板中参数对应的值（在短信模板中定义的，没有可以不用设置）
        BatchSmsAttributes.SmsReceiverParams smsReceiverParams = new BatchSmsAttributes.SmsReceiverParams();
        smsReceiverParams.setParam("code", code);
        //smsReceiverParams.setParam("$YourSMSTemplateParamKey2", "$value2");
        // 3.4 增加接收短信的号码
        batchSmsAttributes.addSmsReceiver(phone, smsReceiverParams);
        //batchSmsAttributes.addSmsReceiver("$YourReceiverPhoneNumber2", smsReceiverParams);
        messageAttributes.setBatchSmsAttributes(batchSmsAttributes);
        try {
            /**
             * Step 4. 发布SMS消息
             */
            TopicMessage ret = topic.publishMessage(msg, messageAttributes);
            System.out.println("MessageId: " + ret.getMessageId());
            System.out.println("MessageMD5: " + ret.getMessageBodyMD5());
            System.out.println("MessageBody:"+ret.getMessageBody());
            System.out.println("tag:"+ret.getMessageTag());
        } catch (ServiceException se) {
            System.out.println(se.getErrorCode() + se.getRequestId());
            System.out.println(se.getMessage());
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        client.close();
    }
}
