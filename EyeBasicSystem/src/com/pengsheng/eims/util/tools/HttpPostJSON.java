package com.pengsheng.eims.util.tools;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.codehaus.jackson.map.ObjectMapper;

import com.pengsheng.eims.his.persistence.HisParamPo;

/**
 * mysflying 2016-11-22 封装一个http请求的工具类
 * 
 */
public class HttpPostJSON {

	/**
	 * URL return JSON
	 * @param urlstr
	 * @return
	 */
	public static String postJSON(String urlSpec, String data)throws Exception  {
		
		 URL url = new URL(urlSpec);
		    URLConnection connection = url.openConnection();
		    connection.setDoOutput(true);
		    OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
		    writer.write(data);
		    writer.flush();

		    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		    String line = "";
		    StringBuilder builder = new StringBuilder();
		    while((line = reader.readLine()) != null) {
		        builder.append(line);
		    }
		    return builder.toString();
	}
	
	public static String postJSON(String urlstr)  {
		 
		StringBuilder json = new StringBuilder();
		URL oracle = null;
		try {
			oracle = new URL(urlstr);
		} catch (MalformedURLException e) {
			return json.append("URL错误或过长!").toString();
		}
		
		URLConnection yc;
		try {
			yc = oracle.openConnection();
		} catch (IOException e) {
			return json.append("URL错误，不能打开连接!").toString(); 
		}
		BufferedReader in = null;
		    
		try {
			in = new BufferedReader(new InputStreamReader(yc.getInputStream(),"UTF-8"));  
		} catch (UnsupportedEncodingException e) {
			return json.append("URL错误，编码异常!").toString();
		} catch (IOException e) {
			return json.append("URL错误，输入流异常!").toString();
		}
		String inputLine = null;

		try {
			while ((inputLine = in.readLine()) != null) {
				json.append(inputLine);
			}
			in.close();
		} catch (IOException e) {
			return json.append("数据读取异常!").toString();
		}
		 
		String Strjson = json.toString();
		System.out.println("返回数据: "+Strjson);

		return Strjson;
	}

	/**
	 * URL return JSON
	 * @param urlstr
	 * @param jsonObj
	 * @return
	 */
	public static String postJSON(String urlstr, JSONObject jsonObj) {

		BufferedReader reader = null;
		HttpURLConnection connection = null;

		try {
			// 创建连接
			URL url = new URL(urlstr);
			connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestMethod("POST");
			connection.setUseCaches(false);
			connection.setInstanceFollowRedirects(true);
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			   
			connection.connect();

			// POST请求
			DataOutputStream out = new DataOutputStream(connection.getOutputStream());

			out.writeBytes(jsonObj.toString());
			out.flush();
			out.close();

			// 读取响应
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));
			String lines;
			StringBuffer sb = new StringBuffer("");
			while ((lines = reader.readLine()) != null) {
				lines = new String(lines.getBytes(),"UTF-8");
				sb.append(lines);
			}
			System.out.println("返回值：" + sb.toString());
			return sb.toString();
			// 断开连接
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			connection.disconnect();
		}
		return "";

	}

	public static void main(String[] args) {
		
		//demo();
		
		//getCusMsg();
		
		//getCusMsg2();
		
		//getCannelSalesPayFee();

		getSalesNotPayFeeItem();

		System.out.println("调用结束！");

	}
	
	/**
	 * 提交待交费用
	 */
	public static void getSalesNotPayFeeItem(){
        JSONObject obj = new JSONObject();
        obj.element("billid", "X0010220161101134999");
        obj.element("memberid", "4813");
        obj.element("posid", "1192");
        obj.element("posname", "张三");
        obj.element("totalmoney","318.00");
        obj.element("type","1");
        obj.element("createtime", "2016-03-06 11:09:32");
  
        Map<String, String> params = new HashMap<String, String>();
        params.put("detailno", "'0'");
        params.put("goodstype","'SB001000201'");
        params.put("goodsmoney", "'100.00'");

        Map<String, String> params1 = new HashMap<String, String>();
        params1.put("detailno", "'1'");
        params1.put("goodstype","'Q00110005A'");
        params1.put("goodsmoney", "'218.00'");
        
        String[] paramsArray = new String[2];
        paramsArray[0] = params.toString();
        paramsArray[1] = params1.toString();
        
        obj.element("goodsinfo", paramsArray);
        obj.element("interfaceID", "3");
        
		String url="http://121.199.21.95:3336/getinfo.html?paramStr=" + obj.toString();
		
		System.out.println("待收费项目接口入参：" + url);

		String resultStr = "";
		try {
			resultStr = HttpPostJSON.postJSON(url,obj);

			HisParamPo hisParamPo = new HisParamPo();
			hisParamPo = toObject(resultStr,hisParamPo);
			
			if (Utility.getName(hisParamPo.getResultCode()).equals("1")){
				System.out.println("调用成功！");
			}else{
				System.out.println("调用失败：" + Utility.getName(hisParamPo.getResultMsg()));
			}

		} catch (IOException e) {
			System.out.println("待收费项目接口调用失败：" + e.getMessage());
		} catch (Exception e) {
			System.out.println("待收费项目提交后返回状态解析失败：" + e.getMessage());
		}

	}
	
	/**
	 * 作废
	 */
	public static void getCannelSalesPayFee(){
        JSONObject obj = new JSONObject();
        obj.element("billid", "AAB82A3A78364E8F860B9FE9999274D7");
        obj.element("interfaceID", "5");
        
		String url="http://121.199.21.95:3336/getinfo.html?&paramStr=" + obj.toString();
		
		System.out.println("作废待收费项目接口入参：" + url);
		
		String resultStr = "";
		try {
			resultStr = HttpPostJSON.postJSON(url,obj);
			
			HisParamPo hisParamPo = new HisParamPo();
			hisParamPo = toObject(resultStr,hisParamPo);
			
			if (Utility.getName(hisParamPo.getResultCode()).equals("1")){
				System.out.println("作废成功！");
			}else{
				System.out.println("作废失败：" + Utility.getName(hisParamPo.getResultMsg()));
			}

		} catch (IOException e) {
			System.out.println("作废待收费项目接口调用失败：" + e.getMessage());
		} catch (Exception e) {
			System.out.println("作废待收费项目数据解析失败：" + e.getMessage());
		}
	}
	
	/**
	 * 查询患者信息（输入一个HIS中不存在的ID，需要返回一个空串）
	 */
	public static void getCusMsg2(){
        JSONObject obj = new JSONObject();
        obj.element("cardno", "0030006qwe");
        obj.element("interfaceID", "1");       
		
		String url="http://121.199.21.95:3336/getinfo.html?&paramStr=" + obj.toString();
		
		System.out.println("检索患者信息接口入参：" + url);
		HttpPostJSON.postJSON(url,obj);
	}
	
	/**
	 * 查询患者信息（输入一个HIS已存在的ID）
	 */
	public static void getCusMsg(){
        JSONObject obj = new JSONObject();
        obj.element("cardno", "0000030006");
        obj.element("interfaceID", "1");
        
		String url="http://121.199.21.95:3336/getinfo.html?paramStr=" + obj.toString();
		
		System.out.println("检索患者信息接口入参：" + url);
		HttpPostJSON.postJSON(url,obj);
	}
	
	/**
	 * demo
	 */
	public static void demo(){
        JSONObject obj = new JSONObject();
        obj.element("app_name", "视光系统");
        obj.element("app_ip", "10.21.243.234");
        obj.element("app_port", 8080);
        obj.element("app_type", "001");
        obj.element("app_area", "asd");
        
        Map<String, String> params1 = new HashMap<String, String>();
        params1.put("a", "1");
        params1.put("b", "2");

        Map<String, String> params2 = new HashMap<String, String>();
        params2.put("aa", "11");
        params2.put("bb", "22");
        
        String[] str = new String[2];
        str[0] = params1.toString();
        str[1] = params2.toString();
        
        obj.element("params", str);
        
        System.out.println("paramStr = " + obj.toString());
        
		String url="http://www.tuling123.com/openapi/api?key=be12dd3c0bac3654e78aa69e4b36a6dd";
		HttpPostJSON.postJSON(url,obj);
	}
	
	public static HisParamPo toObject(String jsonString, HisParamPo hisParamPo) throws Exception {

		ObjectMapper objectMapper = new ObjectMapper();

		return (HisParamPo) objectMapper.readValue(jsonString, hisParamPo.getClass());
	}
		
}
