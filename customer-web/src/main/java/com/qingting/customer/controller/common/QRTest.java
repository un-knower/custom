package com.qingting.customer.controller.common;


  
import java.awt.image.BufferedImage;  
import java.io.InputStream;  
import java.net.URL;  
  
import javax.imageio.ImageIO;  
  
  
 
  
import jp.sourceforge.qrcode.QRCodeDecoder;  
  
/** 
 * 二维码生成测试类 
 * @author Cloud 
 * @data   2016-11-21 
 * QRCodeTest 
 */  
  
public class QRTest {  
  
    public static void main(String[] args) throws Exception {  
        
             
            //QRCodeUtil.QRCodeCreate("uuuuu014266877", "E://qrcode.jpg", 1, "E://logo.png"); 
    	QRCodeUtil.QRCodeAndTextCreate("uuuuu014266877","uuuuu014266877", "E://qrcode.jpg", 1, "E://logo.png"); 
    	
    	QRCodeUtil.zxingCodeAndTextCreate("uuuuu014266877","uuuuu014266877", 200,200,"E://code.png", "jpg"); 
    	//QRCodeUtil.zxingCodeCreate("uuuuu014266877", 800,800,"E://code.png", "jpg"); 
           
        /** 
         *     QRcode 二维码解析测试 
         *    String qrcodeAnalyze = QRCodeUtil.QRCodeAnalyze("E://qrcode.jpg"); 
         */  
        /** 
         * ZXingCode 二维码生成测试 
         * QRCodeUtil.zxingCodeCreate("http://blog.csdn.net/u014266877", 300, 300, "E://zxingcode.jpg", "jpg"); 
         */  
        /** 
         * ZxingCode 二维码解析 
         *    String zxingAnalyze =  QRCodeUtil.zxingCodeAnalyze("E://zxingcode.jpg").toString(); 
         */  
        System.out.println("success");  
    }  
}  
