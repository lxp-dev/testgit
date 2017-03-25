package com.pengsheng.eims.util.tools;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;

public class SMSUtil {

	public static SMSUtil getInstance() {
		return new SMSUtil();
	}
	
	/**
	 * @param smsName:登录用户ID
	 * @param smsPw:MD5(企业代码+用户密码),32 位加密小写
	 * @param mobile
	 * @param content
	 * @param timeDate
	 * @return 返回值是以  0,32432;0开头表示成功;后面是消息编号 可以不管;
	 */
	public String sendSms(String smsName,String smsPw,String mobile,String content,String timeDate){
//	   mobile="15222239977";    
//	   content="短信定时接口测试2014-05-26 09:30:00";
//	   timeDate = "2014-05-26 09:30:00";
		
//	   timeDate=timeDate.replaceAll("/","-");
//	   timeDate=timeDate.replaceAll(" ","+");
//	   timeDate=timeDate.replaceAll(":","%3A");
			   
		//发送 即时信息 get 方式 使用GBK编码 
		String urlstr = null;		
		try {
			if(timeDate.equals("")){
//				urlstr = "http://api.52ao.com/?user="+ smsName +"&pass="+ smsPw +"&mobile="+mobile+"&content="+java.net.URLEncoder.encode(content,"gbk");
				urlstr = "http://210.5.158.31/hy?uid="+ smsName +"&auth="+ smsPw +"&mobile="+mobile+"&msg="+java.net.URLEncoder.encode(content,"gbk")+"&expid=0";
			}else{
//				urlstr = "http://api.52ao.com/?user="+ smsName +"&pass="+ smsPw +"&mobile="+mobile+"&content="+java.net.URLEncoder.encode(content,"gbk")+"&time="+ timeDate;
				urlstr = "http://210.5.158.31/hy?uid="+ smsName +"&auth="+ smsPw +"&mobile="+mobile+"&msg="+java.net.URLEncoder.encode(content,"gbk")+"&expid=0&time="+ timeDate;
			}			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String str=doGetRequest(urlstr);
		return str;
	}
	
	/*
	 * 获取剩余条数
	 */
	public static String getSmsCount(String smsName,String smsPw){
		String urlstr = null;		
//		urlstr="http://api.52ao.com/m/?user="+ smsName +"&pass="+smsPw;
		urlstr="http://210.5.158.31/hy/m?uid="+ smsName +"&auth="+smsPw;
		return doGetRequest(urlstr);
	}
	
	private static String doGetRequest(String urlstr) {
		String res = null;
		HttpClient client = new HttpClient(
				new MultiThreadedHttpConnectionManager());
		client.getParams().setIntParameter("http.socket.timeout", 10000);
		client.getParams().setIntParameter("http.connection.timeout", 5000);

		HttpMethod httpmethod = new GetMethod(urlstr);
		try {
			int statusCode = client.executeMethod(httpmethod);
			if (statusCode == HttpStatus.SC_OK) {
				res = httpmethod.getResponseBodyAsString();
			}
		} catch (HttpException e) { 
			e.printStackTrace();
		} catch (IOException e) { 
			e.printStackTrace();
		} finally {
			httpmethod.releaseConnection();
		}
		return res;
	} 
}
