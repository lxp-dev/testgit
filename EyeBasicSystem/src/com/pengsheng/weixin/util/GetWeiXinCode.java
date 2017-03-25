package com.pengsheng.weixin.util;

import java.net.URLEncoder;

/**
 * 获取微信的code
 */
public class GetWeiXinCode {
	/**
	 * 获取Code URL
	 * */
    public static String getCodeRequestURL(String webAPPUrl,String appID){
    	
    	String getCodeRequest = WeixinConstants.GET_USERINFO_CODE_URL;
        getCodeRequest  = getCodeRequest.replace("APPID", appID);
        getCodeRequest  = getCodeRequest.replace("REDIRECT_URI",webAPPUrl + "oauth2Servlet");	// 授权后重定向的回调链接地址，请使用urlencode对链接进行处理 
        getCodeRequest  = getCodeRequest.replace("SCOPE", WeixinConstants.SCOPE);
        return getCodeRequest;
    }
    
	/**
	 * 获取授权令牌URL
	 * */
	public static String getAccessTokenURL(String appid, String secret,String code) {
		String accessTokenUrl = WeixinConstants.GET_ACCESS_TOKEN_URL;
		
		accessTokenUrl = accessTokenUrl.replace("APPID",appid);
		accessTokenUrl = accessTokenUrl.replace("SECRET",secret);
		accessTokenUrl = accessTokenUrl.replace("CODE", code);
		
		return accessTokenUrl;
	}
	
	/**
	 * 获取用户信息URL
	 * */
	public static String getUserInfoURL(String token, String openid) {
		String userInfoUrl = WeixinConstants.GET_USERINFO_URL;
		
		userInfoUrl = userInfoUrl.replace("ACCESS_TOKEN",token);
		userInfoUrl = userInfoUrl.replace("OPENID", openid);
		return userInfoUrl;
	}
	
    public static String urlEnodeUTF8(String str){
        String result = str;
        try {
            result = URLEncoder.encode(str,"UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}			
