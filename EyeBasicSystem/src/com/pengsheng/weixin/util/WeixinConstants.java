package com.pengsheng.weixin.util;

public final class WeixinConstants {
	
    // 获取access_token的接口地址（GET） 限200（次/天）  
    public final static String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";  
 
    // 菜单创建（POST） 限100（次/天）  
    public final static String MENU_CREATE_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";  
       
    // 获取code,用户同意授权
    public final static String GET_USERINFO_CODE_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=1#wechat_redirect";
    
    // 应用授权作用域
    public final static String SCOPE = "snsapi_userinfo"; //应用授权作用域，snsapi_base （不弹出授权页面，直接跳转，只能获取用户openid），snsapi_userinfo （弹出授权页面，可通过openid拿到昵称、性别、所在地。并且，即使在未关注的情况下，只要用户授权，也能获取其信息）
    
    // 获取token-URL 
    public final static String GET_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
    
    // 获取用户信息-URL
    public final static String GET_USERINFO_URL = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
    
    // 发送微信客服信息-URL
    public final static String SEND_MSG_URL = "https://api.weixin.qq.com/cgi-bin/message/custom/send?&body=0&access_token=";    
}
