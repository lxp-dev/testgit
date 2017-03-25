package rtx;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
   
/**
 * 验证RTX用户
 * @author moyongsheng
 * 2012-10-19
 */

public class Signauth 
 {
    public boolean auth(String strUser, String strSign, String rtxIp) throws UnsupportedEncodingException 
    {
       	boolean bRet = false;
       	strSign = java.net.URLEncoder.encode(strSign,"GB2312");
       	String strURL = "http://"+ rtxIp +":8012/SignAuth.cgi?user=" + strUser + "&sign=" + strSign;
      	String szEncodeResult;
      	String szResult;

        try
        {
        	java.net.URL url = new URL(strURL);
        	HttpURLConnection httpConnection = (HttpURLConnection)url.openConnection();
        
        	BufferedReader reader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));   
        	String strResult=reader.readLine();  
        
        	if(strResult.compareToIgnoreCase("success!") == 0)
        	{
        		bRet = true;
        	}
        
        }
        catch(Exception e)
        {
        	System.out.println("系统出错"+e);
        }
        
		return bRet;
    }

}



