package com.pengsheng.weixin.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

import com.pengsheng.weixin.po.AccessToken;
import com.pengsheng.weixin.util.WeixinUtil;

 
public class SendWeChatMessage {
	 public void sendMessage(String appID,String appSecret,String openID,String content) throws UnsupportedEncodingException 
	    { 
	  
	    	AccessToken at = WeixinUtil.getAccessToken(appID, appSecret);
	        
	        String token = at.getToken(); 
	        String strJson = "{\"touser\" :\""+ openID +"\","; 
	        strJson += "\"msgtype\":\"text\","; 
	        strJson += "\"text\":{"; 
	        strJson += "\"content\":\""+ content +"\""; 
	        strJson += "}}"; 
	        String url = WeixinConstants.SEND_MSG_URL + token; 
	  
	        this.post(url, strJson); 
	    } 
	  
	    /**  
	     * 发送HttpPost请求  
	     *   
	     * @param strURL  
	     *            服务地址  
	     * @param params  
	     *            json字符串,例如: "{ \"id\":\"12345\" }" ;其中属性名必须带双引号<br/>  
	     * @return 成功:返回json字符串<br/>  
	     */  
	    public void post(String strURL, String params) {   
   
	        try {   
	            URL url = new URL(strURL);// 创建连接   
	            HttpURLConnection connection = (HttpURLConnection) url   
	                    .openConnection();   
	            connection.setDoOutput(true);   
	            connection.setDoInput(true);   
	            connection.setUseCaches(false);   
	            connection.setInstanceFollowRedirects(true);   
	            connection.setRequestMethod("POST"); // 设置请求方式   
	            connection.setRequestProperty("Accept", "application/json"); // 设置接收数据的格式   
	            connection.setRequestProperty("Content-Type", "application/json"); // 设置发送数据的格式   
	            connection.connect();   
	            OutputStreamWriter out = new OutputStreamWriter(   
	                    connection.getOutputStream(), "UTF-8"); // utf-8编码   
	            out.append(params);   
	            out.flush();   
	            out.close();    
	            
	            // 读取响应   
	            int length = (int) connection.getContentLength();// 获取长度   
	            InputStream is = connection.getInputStream();   
//	            if (length != -1) {   
//	                byte[] data = new byte[length];   
//	                byte[] temp = new byte[512];   
//	                int readLen = 0;   
//	                int destPos = 0;   
//	                while ((readLen = is.read(temp)) > 0) {   
//	                    System.arraycopy(temp, 0, data, destPos, readLen);   
//	                    destPos += readLen;   
//	                }   
//
//	            }
	        } catch (IOException e) {   
	            // TODO Auto-generated catch block   
	            e.printStackTrace();   
	        }   
	    } 
	    
	    public static void main(String[] args) {
	    	SendWeChatMessage weChat = new SendWeChatMessage();
	    	try {
				weChat.sendMessage("","","","This is a testing!");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
    }
