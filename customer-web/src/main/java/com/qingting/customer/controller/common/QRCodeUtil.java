package com.qingting.customer.controller.common;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;  
import java.awt.Image;  
import java.awt.image.BufferedImage;  
import java.io.File;  
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;  
import java.util.Map;  
  
import javax.imageio.ImageIO;  
  
import jp.sourceforge.qrcode.QRCodeDecoder;  
import jp.sourceforge.qrcode.exception.DecodingFailedException;  
  
import com.google.zxing.BarcodeFormat;  
import com.google.zxing.Binarizer;  
import com.google.zxing.BinaryBitmap;  
import com.google.zxing.EncodeHintType;  
import com.google.zxing.LuminanceSource;  
import com.google.zxing.MultiFormatReader;  
import com.google.zxing.MultiFormatWriter;  
import com.google.zxing.NotFoundException;  
import com.google.zxing.WriterException;  
import com.google.zxing.common.BitMatrix;  
import com.google.zxing.common.HybridBinarizer;  
import com.swetake.util.Qrcode;  
  
/** 
 * 二维码生成工具类 
 * @author Cloud 
 * @data   2016-12-15 
 * QRCode 
 */  
  
public class QRCodeUtil {  
      
    //二维码颜色  
    private static final int BLACK = 0xFF000000;  
    //二维码颜色  
    private static final int WHITE = 0xFFFFFFFF;  
  
    /** 
     * <span style="font-size:18px;font-weight:blod;">ZXing 方式生成二维码</span> 
     * @param text    <a href="javascript:void();">二维码内容</a> 
     * @param width    二维码宽 
     * @param height    二维码高 
     * @param outPutPath    二维码生成保存路径 
     * @param imageType        二维码生成格式 
     */  
    public static void zxingCodeCreate(String text, int width, int height, String outPutPath, String imageType){  
        Map<EncodeHintType, String> his = new HashMap<EncodeHintType, String>();  
        //设置编码字符集  
        his.put(EncodeHintType.CHARACTER_SET, "utf-8");  
        try {  
            //1、生成二维码  
            BitMatrix encode = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height, his);  
              
            //2、获取二维码宽高  
            int codeWidth = encode.getWidth();  
            int codeHeight = encode.getHeight();  
              
            //3、将二维码放入缓冲流  
            BufferedImage image = new BufferedImage(codeWidth, codeHeight, BufferedImage.TYPE_INT_RGB);  
            for (int i = 0; i < codeWidth; i++) {  
                for (int j = 0; j < codeHeight; j++) {  
                    //4、循环将二维码内容定入图片  
                    image.setRGB(i, j, encode.get(i, j) ? BLACK : WHITE);  
                }  
            }  
            File outPutImage = new File(outPutPath);  
            //如果图片不存在创建图片  
            if(!outPutImage.exists())  
                outPutImage.createNewFile();  
            //5、将二维码写入图片  
            ImageIO.write(image, imageType, outPutImage);  
        } catch (WriterException e) {  
            e.printStackTrace();  
            System.out.println("二维码生成失败");  
        } catch (IOException e) {  
            e.printStackTrace();  
            System.out.println("生成二维码图片失败");  
        }  
    }  
    
    /** 
     * <span style="font-size:18px;font-weight:blod;">ZXing 方式生成二维码</span> 
     * @param code    <a href="javascript:void();">二维码内容</a> 
     * @param width    二维码宽 
     * @param height    二维码高 
     * @param outPutPath    二维码生成保存路径 
     * @param imageType        二维码生成格式 
     * @param text       二维码下方文字
     */  
    public static void zxingCodeAndTextCreate(String code,String text, int width, int height, String outPutPath, String imageType){  
        Map<EncodeHintType, String> his = new HashMap<EncodeHintType, String>();  
        //设置编码字符集  
        his.put(EncodeHintType.CHARACTER_SET, "utf-8");  
        try {  
            //1、生成二维码  
            BitMatrix encode = new MultiFormatWriter().encode(code, BarcodeFormat.QR_CODE, width, height, his);  
              
            //2、获取二维码宽高  
            int codeWidth = encode.getWidth();  
            int codeHeight = encode.getHeight(); 
            
            //3、将二维码放入缓冲流  
            BufferedImage image = new BufferedImage(codeWidth, codeHeight, BufferedImage.TYPE_INT_RGB);  
            for (int i = 0; i < codeWidth; i++) {  
                for (int j = 0; j < codeHeight; j++) {  
                    //4、循环将二维码内容定入图片  
                    image.setRGB(i, j, encode.get(i, j) ? BLACK : WHITE);  
                }  
            }  
            
            
            
          //带文字，此处添加45的文字高度 
            int newHeight= codeHeight+45;
            
            
          //新的图片，把带logo的二维码下面加上文字
            BufferedImage outImage = new BufferedImage(codeWidth, newHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D outg = outImage.createGraphics();
            outg.setBackground(Color.WHITE);
            outg.clearRect(0, 0, outImage.getWidth(), outImage.getHeight());     
            //outg.setPaint(Color.RED);  
            //画二维码到新的面板
            outg.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
            //画文字到新的面板
            
            outg.setColor(Color.BLACK); 
            outg.setFont(new Font("宋体",Font.BOLD, width/12)); //字体、字型、字号 
            int strWidth = outg.getFontMetrics().stringWidth(text);
            
            /*if (strWidth > 399) {
//              //长度过长就截取前面部分
//              outg.drawString(text, 0, image.getHeight() + (outImage.getHeight() - image.getHeight())/2 + 5 ); //画文字
                //长度过长就换行
                String productName1 = text.substring(0, text.length()/2);
                String productName2 = text.substring(text.length()/2, text.length());
                int strWidth1 = outg.getFontMetrics().stringWidth(productName1);
                int strWidth2 = outg.getFontMetrics().stringWidth(productName2);
                outg.drawString(productName1, 200  - strWidth1/2, image.getHeight() + (outImage.getHeight() - image.getHeight())/2 + 12 );
                BufferedImage outImage2 = new BufferedImage(400, 485, BufferedImage.TYPE_4BYTE_ABGR);
                Graphics2D outg2 = outImage2.createGraphics();
                outg2.drawImage(outImage, 0, 0, outImage.getWidth(), outImage.getHeight(), null);
                outg2.setColor(Color.BLACK); 
                outg2.setFont(new Font("宋体", Font.BOLD, 26)); //字体、字型、字号 
                outg2.drawString(productName2, 200  - strWidth2/2, outImage.getHeight() + (outImage2.getHeight() - outImage.getHeight())/2 + 5 );
                outg2.dispose(); 
                outImage2.flush();
                outImage = outImage2;
            }else {
                outg.drawString(text, 200  - strWidth/2 , image.getHeight() + (outImage.getHeight() - image.getHeight())/2 + 12 ); //画文字 
            }*/
            
            outg.drawString(text, image.getWidth()/2-strWidth/2 , image.getHeight() ); //画文字
            
            outg.dispose(); 
            outImage.flush();
            image = outImage;
            
            
            File outPutImage = new File(outPutPath);  
            //如果图片不存在创建图片  
            if(!outPutImage.exists())  
                outPutImage.createNewFile();  
            //5、将二维码写入图片  
            ImageIO.write(image, imageType, outPutImage);  
        } catch (WriterException e) {  
            e.printStackTrace();  
            System.out.println("二维码生成失败");  
        } catch (IOException e) {  
            e.printStackTrace();  
            System.out.println("生成二维码图片失败");  
        }  
    } 
    /** 
     * <span style="font-size:18px;font-weight:blod;">ZXing 方式生成二维码</span> 
     * @param code    <a href="javascript:void();">二维码内容</a> 
     * @param width    二维码宽 
     * @param height    二维码高 
     * @param outPutPath    二维码生成保存路径 
     * @param imageType        二维码生成格式 
     * @param text       二维码下方文字
     */  
    public static void zxingCodeAndTextCreateToResponse(String code,String text, int width, int height, String imageType,OutputStream output){  
        Map<EncodeHintType, String> his = new HashMap<EncodeHintType, String>();  
        //设置编码字符集  
        his.put(EncodeHintType.CHARACTER_SET, "utf-8");  
        try {  
            //1、生成二维码  
            BitMatrix encode = new MultiFormatWriter().encode(code, BarcodeFormat.QR_CODE, width, height, his);  
              
            //2、获取二维码宽高  
            int codeWidth = encode.getWidth();  
            int codeHeight = encode.getHeight(); 
            
            //3、将二维码放入缓冲流  
            BufferedImage image = new BufferedImage(codeWidth, codeHeight, BufferedImage.TYPE_INT_RGB);  
            for (int i = 0; i < codeWidth; i++) {  
                for (int j = 0; j < codeHeight; j++) {  
                    //4、循环将二维码内容定入图片  
                    image.setRGB(i, j, encode.get(i, j) ? BLACK : WHITE);  
                }  
            }  
            
            
            
          //带文字，此处添加45的文字高度 
            int newHeight= codeHeight+45;
            
            
          //新的图片，把带logo的二维码下面加上文字
            BufferedImage outImage = new BufferedImage(codeWidth, newHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D outg = outImage.createGraphics();
            outg.setBackground(Color.WHITE);
            outg.clearRect(0, 0, outImage.getWidth(), outImage.getHeight());     
            //outg.setPaint(Color.RED);  
            //画二维码到新的面板
            outg.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
            //画文字到新的面板
            
            outg.setColor(Color.BLACK); 
            outg.setFont(new Font("宋体",Font.BOLD, width/12)); //字体、字型、字号 
            int strWidth = outg.getFontMetrics().stringWidth(text);
            
            /*if (strWidth > 399) {
//              //长度过长就截取前面部分
//              outg.drawString(text, 0, image.getHeight() + (outImage.getHeight() - image.getHeight())/2 + 5 ); //画文字
                //长度过长就换行
                String productName1 = text.substring(0, text.length()/2);
                String productName2 = text.substring(text.length()/2, text.length());
                int strWidth1 = outg.getFontMetrics().stringWidth(productName1);
                int strWidth2 = outg.getFontMetrics().stringWidth(productName2);
                outg.drawString(productName1, 200  - strWidth1/2, image.getHeight() + (outImage.getHeight() - image.getHeight())/2 + 12 );
                BufferedImage outImage2 = new BufferedImage(400, 485, BufferedImage.TYPE_4BYTE_ABGR);
                Graphics2D outg2 = outImage2.createGraphics();
                outg2.drawImage(outImage, 0, 0, outImage.getWidth(), outImage.getHeight(), null);
                outg2.setColor(Color.BLACK); 
                outg2.setFont(new Font("宋体", Font.BOLD, 26)); //字体、字型、字号 
                outg2.drawString(productName2, 200  - strWidth2/2, outImage.getHeight() + (outImage2.getHeight() - outImage.getHeight())/2 + 5 );
                outg2.dispose(); 
                outImage2.flush();
                outImage = outImage2;
            }else {
                outg.drawString(text, 200  - strWidth/2 , image.getHeight() + (outImage.getHeight() - image.getHeight())/2 + 12 ); //画文字 
            }*/
            
            outg.drawString(text, image.getWidth()/2-strWidth/2 , image.getHeight() ); //画文字
            
            outg.dispose(); 
            outImage.flush();
            image = outImage;
            
            
            /*File outPutImage = new File(outPutPath);  
            //如果图片不存在创建图片  
            if(!outPutImage.exists())  
                outPutImage.createNewFile();*/  
            //5、将二维码写入图片  
            ImageIO.write(image, imageType, output);  
        } catch (WriterException e) {  
            e.printStackTrace();  
            System.out.println("二维码生成失败");  
        } catch (IOException e) {  
            e.printStackTrace();  
            System.out.println("生成二维码图片失败");  
        }  
    }   
    /** 
     * <span style="font-size:18px;font-weight:blod;">二维码解析</span> 
     * @param analyzePath    二维码路径 
     * @return 
     * @throws IOException 
     */  
    @SuppressWarnings({ "rawtypes", "unchecked" })  
    public static Object zxingCodeAnalyze(String analyzePath) throws Exception{  
        MultiFormatReader formatReader = new MultiFormatReader();  
        Object result = null;  
        try {  
            File file = new File(analyzePath);  
            if (!file.exists())  
            {  
                return "二维码不存在";  
            }  
            BufferedImage image = ImageIO.read(file);  
            LuminanceSource source = new BufferedImageLuminanceSource(image);  
            Binarizer binarizer = new HybridBinarizer(source);    
            BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);  
            Map hints = new HashMap();  
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");  
            result = formatReader.decode(binaryBitmap, hints);  
        } catch (NotFoundException e) {  
            e.printStackTrace();  
        }    
        return result;  
    }  
      
    /** 
     * <span style="font-size:18px;font-weight:blod;">QRCode 方式生成二维码</span> 
     * @param content    二维码内容 
     * @param imgPath    二维码生成路径 
     * @param version    二维码版本 
     * @param isFlag    是否生成Logo图片    为NULL不生成 
     */  
    public static void QRCodeCreate(String content, String imgPath, int version, String logoPath){  
         try {    
            Qrcode qrcodeHandler = new Qrcode();    
            //设置二维码排错率，可选L(7%) M(15%) Q(25%) H(30%)，排错率越高可存储的信息越少，但对二维码清晰度的要求越小      
            qrcodeHandler.setQrcodeErrorCorrect('M');    
            //N代表数字,A代表字符a-Z,B代表其他字符    
            qrcodeHandler.setQrcodeEncodeMode('B');    
            //版本1为21*21矩阵，版本每增1，二维码的两个边长都增4；所以版本7为45*45的矩阵；最高版本为是40，是177*177的矩阵    
            qrcodeHandler.setQrcodeVersion(version);  
            //根据版本计算尺寸  
            int imgSize = 67 + 12 * (version - 1) ;    
            byte[] contentBytes = content.getBytes("gb2312");    
            BufferedImage bufImg = new BufferedImage(imgSize , imgSize ,BufferedImage.TYPE_INT_RGB);    
            Graphics2D gs = bufImg.createGraphics();    
            gs.setBackground(Color.WHITE);    
            gs.clearRect(0, 0, imgSize , imgSize);    
            // 设定图像颜色 > BLACK  
            gs.setColor(Color.BLACK);  
            // 设置偏移量 不设置可能导致解析出错    
            int pixoff = 2;  
            // 输出内容 > 二维码    
            if (contentBytes.length > 0 && contentBytes.length < 130) {  
                boolean[][] codeOut = qrcodeHandler.calQrcode(contentBytes);  
                for (int i = 0; i < codeOut.length; i++) {  
                    for (int j = 0; j < codeOut.length; j++) {  
                        if (codeOut[j][i]) {    
                            gs.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3);  
                        }    
                    }    
                }    
            } else {    
                System.err.println("QRCode content bytes length = " + contentBytes.length + " not in [ 0,130 ]. ");    
            }  
           /* 判断是否需要添加logo图片 */  
            if(logoPath != null){  
                File icon = new File(logoPath);  
                if(icon.exists()){  
                    int width_4 = imgSize / 4;  
                    int width_8 = width_4 / 2;  
                    int height_4 = imgSize / 4;  
                    int height_8 = height_4 / 2;  
                    Image img = ImageIO.read(icon);  
                    gs.drawImage(img, width_4 + width_8, height_4 + height_8,width_4,height_4, null);  
                    gs.dispose();  
                    bufImg.flush();  
                }else{  
                    System.out.println("Error: logo图片不存在！");  
                }  
  
            }  
  
  
            gs.dispose();  
            bufImg.flush();  
            //创建二维码文件  
            File imgFile = new File(imgPath);  
            if(!imgFile.exists())  
                imgFile.createNewFile();  
            //根据生成图片获取图片  
            String imgType = imgPath.substring(imgPath.lastIndexOf(".") + 1, imgPath.length());  
            // 生成二维码QRCode图片    
            ImageIO.write(bufImg, imgType, imgFile);    
         } catch (Exception e) {    
             e.printStackTrace();    
         }  
    }  
    /** 
     * <span style="font-size:18px;font-weight:blod;">QRCode 方式生成二维码</span> 
     * @param code    二维码内容 
     * @param imgPath    二维码生成路径 
     * @param version    二维码版本 
     * @param isFlag    是否生成Logo图片    为NULL不生成 
     */  
    public static void QRCodeAndTextCreate(String code,String text, String imgPath, int version, String logoPath){  
         try {    
            Qrcode qrcodeHandler = new Qrcode();    
            //设置二维码排错率，可选L(7%) M(15%) Q(25%) H(30%)，排错率越高可存储的信息越少，但对二维码清晰度的要求越小      
            qrcodeHandler.setQrcodeErrorCorrect('M');    
            //N代表数字,A代表字符a-Z,B代表其他字符    
            qrcodeHandler.setQrcodeEncodeMode('B');    
            //版本1为21*21矩阵，版本每增1，二维码的两个边长都增4；所以版本7为45*45的矩阵；最高版本为是40，是177*177的矩阵    
            qrcodeHandler.setQrcodeVersion(version);  
            //根据版本计算尺寸  
            int imgSize = 67 + 12 * (version - 1) ;
            //imgSize*=4;
            System.out.println("imgSize:"+imgSize);
            byte[] contentBytes = code.getBytes("gb2312");    
            BufferedImage image = new BufferedImage(imgSize , imgSize ,BufferedImage.TYPE_INT_RGB);    
            Graphics2D gs = image.createGraphics();    
            gs.setBackground(Color.WHITE);    
            gs.clearRect(0, 0, imgSize , imgSize);    
            // 设定图像颜色 > BLACK  
            gs.setColor(Color.BLACK);  
            // 设置偏移量 不设置可能导致解析出错    
            int pixoff = 2;  
            // 输出内容 > 二维码    
            if (contentBytes.length > 0 && contentBytes.length < 130) {  
                boolean[][] codeOut = qrcodeHandler.calQrcode(contentBytes);  
                for (int i = 0; i < codeOut.length; i++) {  
                    for (int j = 0; j < codeOut.length; j++) {  
                        if (codeOut[j][i]) {    
                            gs.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3);  
                        }    
                    }    
                }    
            } else {    
                System.err.println("QRCode content bytes length = " + contentBytes.length + " not in [ 0,130 ]. ");    
            }  
           /* 判断是否需要添加logo图片 */  
            if(logoPath != null){  
                File icon = new File(logoPath);  
                if(icon.exists()){  
                    int width_4 = imgSize / 4;  
                    int width_8 = width_4 / 2;  
                    int height_4 = imgSize / 4;  
                    int height_8 = height_4 / 2;  
                    Image img = ImageIO.read(icon);  
                    gs.drawImage(img, width_4 + width_8, height_4 + height_8,width_4,height_4, null);  
                    gs.dispose();  
                    image.flush();  
                }else{  
                    System.out.println("Error: logo图片不存在！");  
                }  
  
            }  
            System.out.println("image(width:"+image.getWidth()+".height:"+image.getHeight()+")");
          //带文字，此处添加45的文字高度 
            int newHeight= imgSize+imgSize;
            
            
          //新的图片，把带logo的二维码下面加上文字
            BufferedImage outImage = new BufferedImage(imgSize, newHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D outg = outImage.createGraphics();
            outg.setBackground(Color.WHITE);
            outg.clearRect(0, 0, outImage.getWidth(), outImage.getHeight());     
            //outg.setPaint(Color.RED);  
            //画二维码到新的面板
            outg.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
            //画文字到新的面板
            
            outg.setColor(Color.BLACK); 
            outg.setFont(new Font("宋体",Font.BOLD, imgSize/12)); //字体、字型、字号 
            int strWidth = outg.getFontMetrics().stringWidth(text);
            
            /*if (strWidth > 399) {
//              //长度过长就截取前面部分
//              outg.drawString(text, 0, image.getHeight() + (outImage.getHeight() - image.getHeight())/2 + 5 ); //画文字
                //长度过长就换行
                String productName1 = text.substring(0, text.length()/2);
                String productName2 = text.substring(text.length()/2, text.length());
                int strWidth1 = outg.getFontMetrics().stringWidth(productName1);
                int strWidth2 = outg.getFontMetrics().stringWidth(productName2);
                outg.drawString(productName1, 200  - strWidth1/2, image.getHeight() + (outImage.getHeight() - image.getHeight())/2 + 12 );
                BufferedImage outImage2 = new BufferedImage(400, 485, BufferedImage.TYPE_4BYTE_ABGR);
                Graphics2D outg2 = outImage2.createGraphics();
                outg2.drawImage(outImage, 0, 0, outImage.getWidth(), outImage.getHeight(), null);
                outg2.setColor(Color.BLACK); 
                outg2.setFont(new Font("宋体", Font.BOLD, 26)); //字体、字型、字号 
                outg2.drawString(productName2, 200  - strWidth2/2, outImage.getHeight() + (outImage2.getHeight() - outImage.getHeight())/2 + 5 );
                outg2.dispose(); 
                outImage2.flush();
                outImage = outImage2;
            }else {
                outg.drawString(text, 200  - strWidth/2 , image.getHeight() + (outImage.getHeight() - image.getHeight())/2 + 12 ); //画文字 
            }*/
            System.out.println((image.getWidth()/2-strWidth/2) +":" +image.getHeight());
            outg.drawString(text, image.getWidth()/2-strWidth/2 , image.getHeight()+imgSize/12 ); //画文字
            
            outg.dispose(); 
            outImage.flush();
            image = outImage;
  
            gs.dispose();  
            image.flush();  
            //创建二维码文件  
            File imgFile = new File(imgPath);  
            if(!imgFile.exists())  
                imgFile.createNewFile();  
            //根据生成图片获取图片  
            String imgType = imgPath.substring(imgPath.lastIndexOf(".") + 1, imgPath.length());  
            // 生成二维码QRCode图片    
            ImageIO.write(image, imgType, imgFile);    
         } catch (Exception e) {    
             e.printStackTrace();    
         }  
    }  
    /** 
     * <span style="font-size:18px;font-weight:blod;">QRCode二维码解析</span> 
     * @param codePath    二维码路径 
     * @return    解析结果 
     */  
    public static String QRCodeAnalyze(String codePath) {  
        File imageFile = new File(codePath);  
        BufferedImage bufImg = null;    
        String decodedData = null;    
        try {  
            if(!imageFile.exists())  
                return "二维码不存在";  
            bufImg = ImageIO.read(imageFile);  
            
            QRCodeDecoder decoder = new QRCodeDecoder();    
            decodedData = new String(decoder.decode(new TwoDimensionCodeImage(bufImg)), "gb2312");    
        } catch (IOException e) {    
            System.out.println("Error: " + e.getMessage());    
            e.printStackTrace();    
        } catch (DecodingFailedException dfe) {    
            System.out.println("Error: " + dfe.getMessage());    
            dfe.printStackTrace();    
        }  
        return decodedData;  
    }  
  
}  