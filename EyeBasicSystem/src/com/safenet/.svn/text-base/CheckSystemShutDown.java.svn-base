package com.safenet;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.pengsheng.eims.util.GlobalConstants;

public class CheckSystemShutDown {
	
	private static String getSystemShutDownDate(String desStr){
		   Encrypt encrypt = new Encrypt();
		   encrypt.setKey(GlobalConstants.DES_KEY);    //调用set函数设置密钥。		   
		   encrypt.setDesString(desStr);   //将要解密的密文传送给Encrypt.java进行解密计算。
		   String result = encrypt.getStrM().replace("sleep", ""); //调用get函数获取解密后明文。
		   return result;
	}
	
	public static void main(String[] args) {
		CheckSystemShutDown checkSystemShutDown = new CheckSystemShutDown();

		System.out.println(checkSystemShutDown.getDistanceDays());
	}
	/**
	 * 返回值：与当天对比没到期，返回0；已经大于当日日期，返回差值；如果系统设置日期有问题，返回-1；
	 * @return
	 */
	 private static long getDistanceDays(){
		 	String str1 = getSystemShutDownDate(GlobalConstants.SYSTEM_SHUTDOWN_DATE);
	        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");  
	        Date one;  
	        Date two;  
		 	Date date=new Date();
		 	String str2=df.format(date);
	        long days=0;  
	        try {  
	            one = df.parse(str1);  
	            two = df.parse(str2);  
	            long time1 = one.getTime();  
	            long time2 = two.getTime();  
	            long diff ;  
	            diff = time2 - time1;  
	            days = diff / (1000 * 60 * 60 * 24);  
	        } catch (ParseException e) {  
	        	return -1; 
	        }  
	        if(days>0){
	        	return days; 
	        }
	        return 0;  
	    } 
	 
	 /**
	  * 判断系统是否开始查询变慢，每多一天，查询延迟多10秒
	  */
	 public static void execSleep(){
		 long i = getDistanceDays();
			if(i!=0){
				if(i==-1){
					System.out.print("发现系统运行变慢，无限延迟!"); 
					try{
						Thread.sleep(50000000);
					}
					catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else if(i>0){
					System.out.print("发现系统运行变慢，延迟："+i*10000); 
					try{
						Thread.sleep(i*10000);
					}
					catch (InterruptedException e) {
						e.printStackTrace();
					}
				}			
			}	
			
//		long i = getDistanceDays();
//		if(i>0){
//			System.out.print("发现系统运行变慢，延迟："+i*10000); 
//			try{
//				Thread.sleep(i*10000);
//			}
//			catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
	 }
}