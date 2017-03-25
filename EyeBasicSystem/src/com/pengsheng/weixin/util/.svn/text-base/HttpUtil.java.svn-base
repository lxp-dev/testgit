package com.pengsheng.weixin.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.sf.json.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;

public class HttpUtil {

	public static String getUrl(String url){
		String result = null;
		try {
			// 根据地址获取请求
			HttpGet request = new HttpGet(url);
			// 获取当前客户端对象
			HttpClient httpClient = new DefaultHttpClient();
			// 通过请求对象获取响应对象
			HttpResponse response = httpClient.execute(request);
			
			// 判断网络连接状态码是否正常(0--200都数正常)
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				result= EntityUtils.toString(response.getEntity());
			} 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public static InputStream postUrl(String url, Map<String, String> params)
			throws ClientProtocolException, IOException {

		// 调用重载方法
		return postUrl(url, params, "UTF-8");
	}

	public static InputStream postUrl(String url, Map<String, String> params,
			String encoding) throws ClientProtocolException, IOException {
		// 创建一个集合存放所使用的请求参数
		List<BasicNameValuePair> param = new ArrayList<BasicNameValuePair>(); // 参数
		param.add(new BasicNameValuePair("par", "request-post"));

		if (params!=null) {
			// 添加参数
			
			// 通过传递的map对象获取传递的参数,map对象为用户所填写的内容
			Iterator<Entry<String, String>> iterator = params.entrySet().iterator();
			while (iterator.hasNext()) {
				Entry<String, String> entry = (Entry<String, String>) iterator
						.next();

				param.add(new BasicNameValuePair((String) entry.getKey(),
						(String) entry.getValue()));
			}
		}
		
		// 通过post方式获取请求对象
		HttpPost request = new HttpPost(url);
		// 使用对应编码方式将集合解析为实体
		HttpEntity entity = new UrlEncodedFormEntity(param, encoding);
		// 设置post实体
		request.setHeader("Content-Type",
				"application/x-www-form-urlencoded; charset=utf-8");
		request.setEntity(entity);
		// 获取客户端对象
		HttpClient client = new DefaultHttpClient();
		client.getParams().setParameter(
				CoreConnectionPNames.CONNECTION_TIMEOUT, 100000); // 设置请求超时时间
		client.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 100000); // 读取超时

		// 执行post方法并获得相应对象
		HttpResponse response = client.execute(request);
		if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
			return response.getEntity().getContent();
			
			//EntityUtils.toString(response.getEntity());
		} else {
			return null;
		}
	}
	
	
	
	public static String postUrl2(String url, Map<String, String> params)
			throws ClientProtocolException, IOException {

		// 调用重载方法
		return postUrl2(url, params, "UTF-8");
	}

	public static String postUrl2(String url, Map<String, String> params,
			String encoding) throws ClientProtocolException, IOException {
		// 创建一个集合存放所使用的请求参数
		List<BasicNameValuePair> param = new ArrayList<BasicNameValuePair>(); // 参数
		param.add(new BasicNameValuePair("par", "request-post"));

		if (params!=null) {
			// 添加参数
			
			// 通过传递的map对象获取传递的参数,map对象为用户所填写的内容
			Iterator<Entry<String, String>> iterator = params.entrySet().iterator();
			while (iterator.hasNext()) {
				Entry<String, String> entry = (Entry<String, String>) iterator
						.next();

				param.add(new BasicNameValuePair((String) entry.getKey(),
						(String) entry.getValue()));
			}
		}
		
		// 通过post方式获取请求对象
		HttpPost request = new HttpPost(url);
		// 使用对应编码方式将集合解析为实体
		HttpEntity entity = new UrlEncodedFormEntity(param, encoding);
		// 设置post实体
		request.setHeader("Content-Type",
				"application/x-www-form-urlencoded; charset=utf-8");
		request.setEntity(entity);
		// 获取客户端对象
		HttpClient client = new DefaultHttpClient();
		client.getParams().setParameter(
				CoreConnectionPNames.CONNECTION_TIMEOUT, 100000); // 设置请求超时时间
		client.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 100000); // 读取超时

		// 执行post方法并获得相应对象
		HttpResponse response = client.execute(request);
		if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
			return EntityUtils.toString(response.getEntity());
		} else {
			return null;
		}
	}
	
	public static void main(String[] args) {
		
		try {
			Map<String, String> params=new HashMap<String, String>();
			params.put("customerid", "M10");
			String aa=postUrl2("http://127.0.0.1:8080/eims/getCustomerInfoJson.action",params);
			System.out.println(aa);
			
			JSONObject jsonObject=JSONObject.fromObject(aa);
			JSONObject html=jsonObject.getJSONObject("result");
			System.out.println(html);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
