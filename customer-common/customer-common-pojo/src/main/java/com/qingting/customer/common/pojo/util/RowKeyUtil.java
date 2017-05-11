package com.qingting.customer.common.pojo.util;

import java.util.Calendar;

import org.apache.hadoop.hbase.util.Bytes;

import com.qingting.customer.hbase.rowkey.RowKey;

public class RowKeyUtil {
	public static byte[] getBytes(long a){
		byte[] a1 = Bytes.toBytes(a);
		return a1;
	}
	public static byte[] getBytes(boolean a,long b){
		byte[] a1 = Bytes.toBytes(a);
		byte[] b1 = Bytes.toBytes(b);
		byte[] bytes=new byte[a1.length+b1.length];
		int i=0,j=0;
		for(i=0;i<a1.length;i++){
			bytes[j]=a1[i];
			j++;
		}
		for(i=0;i<b1.length;i++){
			bytes[j]=b1[i];
			j++;
		}
		return bytes;
		
	}
	public static byte[] getBytes(int a,long b){
		byte[] a1 = Bytes.toBytes(a);
		byte[] b1 = Bytes.toBytes(b);
		byte[] bytes=new byte[a1.length+b1.length];
		int i=0,j=0;
		for(i=0;i<a1.length;i++){
			bytes[j]=a1[i];
			j++;
		}
		for(i=0;i<b1.length;i++){
			bytes[j]=b1[i];
			j++;
		}
		return bytes;
		
	}
	public static byte[] getBytes(int a,Calendar calendar){
		byte[] a1 = Bytes.toBytes(a);
		//byte[] b1 = Bytes.toBytes(b);
		//byte[] bytes=new byte[a1.length+b1.length];
		/*int i=0,j=0;
		for(i=0;i<a1.length;i++){
			bytes[j]=a1[i];
			j++;
		}
		for(i=0;i<a1.length;i++){
			bytes[j]=b1[i];
			j++;
		}
		return bytes;*/
		return null;
	}
	public static byte[] getBytes(boolean a,long b,int c){
		byte[] a1 = Bytes.toBytes(a);
		byte[] b1 = Bytes.toBytes(b);
		byte[] c1 = Bytes.toBytes(c);
		byte[] bytes=new byte[a1.length+b1.length+c1.length];
		int i=0,j=0;
		for(i=0;i<a1.length;i++){
			bytes[j]=a1[i];
			j++;
		}
		for(i=0;i<b1.length;i++){
			bytes[j]=b1[i];
			j++;
		}
		for(i=0;i<c1.length;i++){
			bytes[j]=c1[i];
			j++;
		}
		return bytes;
		
	}
	public static byte[] getBytes(int a,boolean b,int c){
		byte[] a1 = Bytes.toBytes(a);
		byte[] b1 = Bytes.toBytes(b);
		byte[] c1 = Bytes.toBytes(c);
		byte[] bytes=new byte[a1.length+b1.length+c1.length];
		int i=0,j=0;
		for(i=0;i<a1.length;i++){
			bytes[j]=a1[i];
			j++;
		}
		for(i=0;i<b1.length;i++){
			bytes[j]=b1[i];
			j++;
		}
		for(i=0;i<c1.length;i++){
			bytes[j]=c1[i];
			j++;
		}
		return bytes;
		
	}
	public static byte[] getBytes(int a,boolean b,long c){
		byte[] a1 = Bytes.toBytes(a);
		byte[] b1 = Bytes.toBytes(b);
		byte[] c1 = Bytes.toBytes(c);
		byte[] bytes=new byte[a1.length+b1.length+c1.length];
		int i=0,j=0;
		for(i=0;i<a1.length;i++){
			bytes[j]=a1[i];
			j++;
		}
		for(i=0;i<b1.length;i++){
			bytes[j]=b1[i];
			j++;
		}
		for(i=0;i<c1.length;i++){
			bytes[j]=c1[i];
			j++;
		}
		return bytes;
		
	}
	public static byte[] getBytes(int a,long b,int c){
		byte[] a1 = Bytes.toBytes(a);
		byte[] b1 = Bytes.toBytes(b);
		byte[] c1 = Bytes.toBytes(c);
		byte[] bytes=new byte[a1.length+b1.length+c1.length];
		int i=0,j=0;
		for(i=0;i<a1.length;i++){
			bytes[j]=a1[i];
			j++;
		}
		for(i=0;i<b1.length;i++){
			bytes[j]=b1[i];
			j++;
		}
		for(i=0;i<c1.length;i++){
			bytes[j]=c1[i];
			j++;
		}
		return bytes;
		
	}
	public static byte[] getBytes(String a,long b,int c){
		byte[] a1 = Bytes.toBytes(a);
		byte[] b1 = Bytes.toBytes(b);
		byte[] c1 = Bytes.toBytes(c);
		byte[] bytes=new byte[a1.length+b1.length+c1.length];
		int i=0,j=0;
		for(i=0;i<a1.length;i++){
			bytes[j]=a1[i];
			j++;
		}
		for(i=0;i<b1.length;i++){
			bytes[j]=b1[i];
			j++;
		}
		for(i=0;i<c1.length;i++){
			bytes[j]=c1[i];
			j++;
		}
		return bytes;
		
	}
	public static byte[] getBytes(long a,byte[] array,long b,int c){
		byte[] a1 = Bytes.toBytes(a);
		byte[] b1 = Bytes.toBytes(b);
		byte[] c1 = Bytes.toBytes(c);
		byte[] bytes=new byte[a1.length+array.length+b1.length+c1.length];
		int i=0,j=0;
		for(i=0;i<a1.length;i++){
			bytes[j]=a1[i];
			j++;
		}
		for(i=0;i<array.length;i++){
			bytes[j]=array[i];
			j++;
		}
		for(i=0;i<b1.length;i++){
			bytes[j]=b1[i];
			j++;
		}
		for(i=0;i<c1.length;i++){
			bytes[j]=c1[i];
			j++;
		}
		return bytes;
		
	}
	public static String getString(RowKey rowKey){
		return new String(rowKey.toBytes());
	}
}
