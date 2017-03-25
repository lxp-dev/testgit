package com.pengsheng.weixin.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.pengsheng.weixin.po.AccessToken;

/**
 * 
 */
public class WeixinNewUtil {
	protected final static Logger log = LogManager.getLogger(WeixinUtil.class);
	// 获取access_token的接口地址（GET） 限200（次/天）
	public final static String access_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	// 上传图文消息地址 (用作)
	public final static String upload_resource_article_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	// 主动发送客服消息url
	public final static String SEND_CUSTOM_URL = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";
	// 微信模板消息调用接口URL
	public final static String TEMPLATE_MSG_URL = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
	// 微信授权获取access_token url
	public final static String AUTH_ACCESS_TOKEN = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
	// 微信授权获取用户信息 url
	public final static String AUTH_GET_USER_INFO = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
	// 接收消息类型：文本
	public final static String RECRIVE_TEXT = "text";
	// 接收消息类型：图片
	public final static String RECRIVE_IMAGE = "image";
	// 接收消息类型：语音
	public final static String RECRIVE_VOICE = "voice";
	// 接收消息类型：视频
	public final static String RECRIVE_VIDEO = "video";
	// 接收消息类型：地理位置
	public final static String RECRIVE_LOCATION = "location";
	// 接收消息类型：链接
	public final static String RECRIVE_LINK = "link";
	// 接收消息类型：推送
	public final static String RECRIVE_EVENT = "event";
	// 回复消息类型：文本
	public final static String REQUEST_TEXT = "text";
	// 回复消息类型：图片
	public final static String REQUEST_IMAGE = "image";
	// 回复消息类型：语音
	public final static String REQUEST_VOICE = "voice";
	// 回复消息类型：视频
	public final static String REQUEST_VIDEO = "video";
	// 回复消息类型：音乐
	public final static String REQUEST_MUSIC = "music";
	// 回复消息类型：图文
	public final static String REQUEST_NEWS = "news";
	// 事件类型：subscribe(订阅)
	public final static String EVENT_SUBSCRIBE = "subscribe";
	// 事件类型：unsubscribe(取消订阅)
	public final static String EVENT_UNSUBSCRIBE = "unsubscribe";
	// 事件类型：LOCATION(上报地理位置事件)
	public final static String EVENT_LOCATION = "LOCATION";
	// 事件类型：CLICK(自定义菜单点击事件)
	public final static String EVENT_CLICK = "CLICK";
	/**
	 * 扫描带参数二维码事件 用户扫描带场景值二维码时，可能推送以下两种事件：
	 * 1.如果用户还未关注公众号，则用户可以关注公众号，关注后微信会将带场景值关注事件推送给开发者。
	 * 2.如果用户已经关注公众号，则微信会将带场景值扫描事件推送给开发者。
	 */
	// 事件类型：subscribe(用户未关注时，进行关注后的事件推送)
	public final static String EVENT_QRCODE_SUBSCRIBE = "subscribe";
	// 事件类型：scan(用户已关注时的事件推送)
	public final static String EVENT_QRCODE_SCAN = "scan";
	// 获取access_token的接口地址（GET） 限200（次/天）
	public final static String GET_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	// 开发者可通过OpenID来获取用户基本信息 url
	protected final static String GET_PERSONALINF_URL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
	// 通过OpenID获取查询用户所在分组url
	protected final static String GET_PERSONGROUPID_URL = "https://api.weixin.qq.com/cgi-bin/groups/getid?access_token=ACCESS_TOKEN";
	/**
	 * OAuth2.0引导关注者打开 用户同意授权，获取code页面url
	 * 1.scope的设置为：snsapi_base（不弹出授权页面，直接跳转，只能获取用户openid），snsapi_userinfo
	 * （弹出授权页面) 2.redirect_uri：授权后重定向的回调链接地址，请使用urlencode对链接进行处理
	 * 方法再commonutil的urlEncodeUTF8()
	 */
	public final static String FANS_GET_CODE = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";
	// OAuth2.0通过code换取网页授权access_token
	protected final static String OAUTH2_ACCESSTOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
	// OAuth2.0刷新access_token
	protected final static String REFRESH_ACCESSTOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN";
	// OAuth2.0拉取用户信息(需scope为 snsapi_userinfo)
	protected final static String OAUTH2_USERINFO_URL = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
	// 生成临时二维码url
	protected final static String TEMPORARY_QRCODE_URL = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=ACCESS_TOKEN";
	// 生成永久二维码url
	protected final static String PERMANENT_QRCODE_URL = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=ACCESS_TOKEN";
	// 换取二维码url
	protected final static String GET_QRCODE_URL = "https://mp.weixin.qq.com/cgi-bin/shoMyna Wangrcode?ticket=TICKET";
	// 获取关注者列表url
	protected final static String GET_USERLIST_URL = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&next_openid=NEXT_OPENID";
	// 获取所有分组信息url
	protected final static String GET_GROUPS_URL = "https://api.weixin.qq.com/cgi-bin/groups/get?access_token=ACCESS_TOKEN";
	// 创建分组url
	protected final static String CREATE_GROUPS_URL = "https://api.weixin.qq.com/cgi-bin/groups/create?access_token=ACCESS_TOKEN";
	// 修改分组url
	protected final static String UPDATE_GROUPS_URL = "https://api.weixin.qq.com/cgi-bin/groups/update?access_token=ACCESS_TOKEN";
	// 移动用户分组url
	protected final static String REMOVE_MEMBER_URL = "https://api.weixin.qq.com/cgi-bin/groups/members/update?access_token=ACCESS_TOKEN";
	// 上传多媒体文件url
	protected final static String UPLOAD_MEDIA_URL = "http://file.api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";
	// 下载多媒体文件url
	protected final static String DOWNLOAD_MEDIA_URL = "http://file.api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";
	// 菜单创建（POST） 限100（次/天）
	protected final static String CREATE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	// 菜单查询（GET）
	protected final static String GET_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
	// 菜单删除（GET）
	protected final static String DELETE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";

	/**
	 * URL编码(utf-8)
	 * 
	 * @param source
	 * @return String
	 */
	public static String urlEncodeUTF8(String source) {
		String result = source;
		try {
			result = URLEncoder.encode(source, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 根据类型判断文件扩展名
	 * 
	 * @param contentType
	 *            内容类型
	 * @return String
	 */
	public static String getFileExt(String contentType) {
		String fileExt = "";
		if ("image/jpeg".equals(contentType)) {
			fileExt = ".jpg";
		} else if ("audio/mpeg".equals(contentType)) {
			fileExt = ".mp3";
		} else if ("audio/amr".equals(contentType)) {
			fileExt = ".amr";
		} else if ("video/mp4".equals(contentType)) {
			fileExt = ".mp4";
		} else if ("video/mpeg4".equals(contentType)) {
			fileExt = ".mp4";
		}
		return fileExt;
	}

	/**
	 * 发起https请求并获取结果
	 * 
	 * @param requestUrl
	 *            请求地址
	 * @param requestMethod
	 *            请求方式（GET、POST）
	 * @param outputStr
	 *            提交的数据
	 * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
	 */
	public static JSONObject httpRequest(String requestUrl,
			String requestMethod, String outputStr) {
		JSONObject jsonObject = null;
		StringBuffer buffer = new StringBuffer();
		try {
			// 创建SSLContext对象，并使用我们指定的信任管理器初始化
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();
			URL url = new URL(requestUrl);
			HttpsURLConnection httpUrlConn = (HttpsURLConnection) url
					.openConnection();
			httpUrlConn.setSSLSocketFactory(ssf);
			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);
			// 设置请求方式（GET/POST）
			httpUrlConn.setRequestMethod(requestMethod);
			if ("GET".equalsIgnoreCase(requestMethod))
				httpUrlConn.connect();
			// 当有数据需要提交时
			if (null != outputStr) {
				OutputStream outputStream = httpUrlConn.getOutputStream();
				// 注意编码格式，防止中文乱码
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}
			// 将返回的输入流转换成字符串
			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(
					inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(
					inputStreamReader);
			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			// 释放资源
			inputStream.close();
			inputStream = null;
			httpUrlConn.disconnect();
			jsonObject = JSONObject.fromObject(buffer.toString());
		} catch (ConnectException ce) {
			System.out.println("Weixin server connection timed out.");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("https request error:{}" + e);
		}
		return jsonObject;
	}

	/**
	 * 发起http请求
	 * 
	 * @param requestUrl
	 * @param requestMethod
	 * @param outputStr
	 * @return
	 */
	public static String httpStringRequest(String requestUrl,
			String requestMethod, String outputStr) {
		String jsonObject = null;
		StringBuffer buffer = new StringBuffer();
		try {
			// 创建SSLContext对象，并使用我们指定的信任管理器初始化
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();
			URL url = new URL(requestUrl);
			HttpsURLConnection httpUrlConn = (HttpsURLConnection) url
					.openConnection();
			httpUrlConn.setSSLSocketFactory(ssf);
			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);
			// 设置请求方式（GET/POST）
			httpUrlConn.setRequestMethod(requestMethod);
			if ("GET".equalsIgnoreCase(requestMethod))
				httpUrlConn.connect();
			// 当有数据需要提交时
			if (null != outputStr) {
				OutputStream outputStream = httpUrlConn.getOutputStream();
				// 注意编码格式，防止中文乱码
				outputStream.write(outputStr.getBytes("UTF-8"));
				System.out.println("------------------------" + outputStr);
				outputStream.close();
			}
			// 将返回的输入流转换成字符串
			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(
					inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(
					inputStreamReader);
			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			// 释放资源
			inputStream.close();
			inputStream = null;
			httpUrlConn.disconnect();
			jsonObject = buffer.toString();
		} catch (ConnectException ce) {
			System.out.println("Weixin server connection timed out.");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("https request error:{}" + e);
		}
		return jsonObject;
	}

	/**
	 * 获取access_token
	 * 
	 * @param appid
	 *            凭证
	 * @param appsecret
	 *            密钥
	 * @return
	 * @throws Exception
	 */
	public static AccessToken getAccessToken(String appid, String appsecret)
			throws Exception {
		AccessToken accessToken = null;
		String requestUrl = access_token_url.replace("APPID", appid).replace(
				"APPSECRET", appsecret);
		System.out.println("requestUrl" + requestUrl);
		JSONObject jsonObject = httpRequest(requestUrl, "GET", null);
		System.out.println("jsonObject" + jsonObject);
		// 如果请求成功
		if (null != jsonObject) {
			try {
				accessToken = new AccessToken();
				accessToken.setToken(jsonObject.getString("access_token"));
				accessToken.setExpiresIn(jsonObject.getInt("expires_in"));
			} catch (JSONException e) {
				accessToken = null;
				log.error(e.getMessage());
				e.printStackTrace();
				throw new Exception("token获取失败，请检查您的appId等配置");
				// 获取token失败
			}
		}
		return accessToken;
	}

	/**
	 * 调用微信JS接口的临时票据
	 * 
	 * @param access_token
	 *            接口访问凭证
	 * @return
	 */
	public static String getJsApiTicket(String access_token) {
		String url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";

		String requestUrl = url.replace("ACCESS_TOKEN", access_token);
		// 发起GET请求获取凭证
		JSONObject jsonObject = httpRequest(requestUrl, "GET", null);
		String ticket = null;
		if (null != jsonObject) {
			try {
				ticket = jsonObject.getString("ticket");
			} catch (JSONException e) {
				ticket = null;
				log.error(e.getMessage());
				e.printStackTrace();
			}
		}
		return ticket;
	}

	// 菜单创建（POST） 限100（次/天）
	public static String menu_create_url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

	/**
	 * 发送客服消息方法
	 * 
	 * @param accessToken
	 *            接口访问凭证
	 * @param jsonMsg
	 *            json格式客服消息
	 * @return true|false
	 */
	public static boolean sendCustomMessage(String accessToken, String jsonMsg) {
		log.info(jsonMsg);
		boolean result = false;
		String requestUrl = SEND_CUSTOM_URL
				.replace("ACCESS_TOKEN", accessToken);
		// 发送客服消息
		JSONObject jsonObject = httpRequest(requestUrl, "POST", jsonMsg);
		if (null != jsonObject) {
			int errorCode = jsonObject.getInt("errcode");
			String errorMsg = jsonObject.getString("errmsg");
			if (0 == errorCode) {
				result = true;
				log.info(errorMsg);
			} else {
				log.error(errorMsg);
			}
		}
		return result;
	}

	/**
	 * 下载多媒体文件
	 * 
	 * @param accessToken
	 *            调用接口凭证
	 * @param mediaId
	 *            媒体文件ID
	 * @param savePath
	 *            保存路径
	 * @return String 保存文件路径
	 */
	public static String getMedia(String accessToken, String mediaId,
			String savePath) {
		String filePath = null;
		String requestUrl = DOWNLOAD_MEDIA_URL.replace("ACCESS_TOKEN",
				accessToken).replace("MEDIA_ID", mediaId);
		try {
			URL url = new URL(requestUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoInput(true);
			conn.setRequestMethod("GET");
			if (!savePath.endsWith("/")) {
				savePath += "/";
			}
			// 根据内容类型获取扩展名
			String fileExt = getFileExt(conn.getHeaderField("Content-Type"));
			// 将mediaId作为文件名
			filePath = savePath + mediaId + fileExt;
			BufferedInputStream bis = new BufferedInputStream(conn
					.getInputStream());
			FileOutputStream fos = new FileOutputStream(new File(filePath));
			byte[] buf = new byte[8096];
			int size = 0;
			while ((size = bis.read(buf)) != -1) {
				fos.write(buf, 0, size);
			}
			fos.close();
			bis.close();
			conn.disconnect();
			log.info("下载媒体文件成功,filePath=" + filePath);
		} catch (Exception e) {
			filePath = null;
			log.error("下载媒体文件失败:{}", e);
		}
		return filePath;
	}

	/**
	 * 判断字符是否是中文
	 * 
	 * @param c
	 *            字符
	 * @return 是否是中文
	 */
	public static boolean isChinese(char c) {
		Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
		if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
				|| ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
				|| ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
				|| ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
			return true;
		}
		return false;
	}

	/**
	 * 替换乱码的字符
	 * 
	 * @param strName
	 * @return
	 */
	public static String replaceMessy(String strName) {
		Pattern p = Pattern.compile("\\s*|\t*|\r*|\n*");
		Matcher m = p.matcher(strName);
		String after = m.replaceAll("");
		String temp = after.replaceAll("\\p{P}", "");
		char[] ch = temp.trim().toCharArray();
		for (int i = 0; i < ch.length; i++) {
			char c = ch[i];
			if (!Character.isLetterOrDigit(c)) {
				if (!isChinese(c)) {
					ch[i] = '?';
				}
			}
		}
		return new String(ch);
	}

	/**
	 * 查询用户所在分组
	 * 
	 * @param accessToken
	 *            调用接口凭证
	 * @param openId
	 *            普通用户的标识，对当前公众号唯一
	 * @return groupid
	 */
	public static int getPersonGroupId(String accessToken, String openId) {
		int groupId = 0;
		String requestUrl = GET_PERSONGROUPID_URL.replace("ACCESS_TOKEN",
				accessToken);
		// 需要提交的json数据
		String jsonData = "{\"openid\":\"%s\"}";
		// 创建分组
		JSONObject jsonObject = httpRequest(requestUrl, "POST", String.format(
				jsonData, openId));
		if (null != jsonObject) {
			try {
				groupId = jsonObject.getInt("groupid");
			} catch (JSONException e) {
				groupId = -1;
				int errorCode = jsonObject.getInt("errcode");
				String errorMsg = jsonObject.getString("errmsg");
				log.error(errorMsg);
			}
		}
		return groupId;
	}

	/**
	 * 发送模版消息
	 * 
	 * @param jsonStr
	 * @param accessToken
	 * @return
	 */
	public static String sendTemplateMsg(String jsonStr, String accessToken) {
		String requestUrl = WeixinNewUtil.TEMPLATE_MSG_URL.replace("ACCESS_TOKEN",
				accessToken);
		// 调用微信接口
		JSONObject jsonObject = WeixinUtil.httpRequest(requestUrl, "POST",
				jsonStr);
		return jsonObject.toString();
	}

}
