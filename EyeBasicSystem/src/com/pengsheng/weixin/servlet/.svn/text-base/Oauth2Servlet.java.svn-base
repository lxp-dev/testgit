package com.pengsheng.weixin.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.weixin.persistence.WeiXinRegisterDepartmentPo;
import com.pengsheng.weixin.service.WeixinApi;
import com.pengsheng.weixin.util.GetWeiXinCode;
import com.pengsheng.weixin.util.HttpUtil;

/**
 * 
 * @author 简爱微萌
 * @Email zyw205@gmail.com 接口权限中设置OAuth2.0网页授权 域名 如：www.wechat68.com
 *        授权访问的URL：https://open.weixin.qq.com/connect/oauth2/authorize?appid=
 *        wx614c453e0d1dcd12
 *        &redirect_uri=http://www.wechat68.com/Javen/OauthTest
 *        &response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect
 */
public class Oauth2Servlet extends HttpServlet {

	private static final long serialVersionUID = -644518508267758016L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String webUrl = request.getRequestURL().toString().split("oauth2Servlet")[0];
		System.out.println("Oauth2Servlet.webUrl==" + webUrl);
		try {
			String code = Utility.getName(request.getParameter("code"));
			HttpSession session = request.getSession();
			
			//微信号对应原始ID写入Session
			String toUserName = Utility.getName(request.getParameter("toUserName"));
			String key = Utility.getName(request.getParameter("key"));
			if(!toUserName.equals("")){
				session.setAttribute("toUserName", toUserName);
			}else if(session.getAttribute("toUserName")!=null && !session.getAttribute("toUserName").toString().equals("")){
				toUserName = session.getAttribute("toUserName").toString();
			}
			//微信号对应原始ID写入Session
			
			WeiXinRegisterDepartmentPo weiXinRegisterDepartmentPo = WeixinApi.getWeiXinRegisterDepartmentPo(toUserName);
			
			String oauth_url = GetWeiXinCode.getCodeRequestURL(webUrl,weiXinRegisterDepartmentPo.getWrdappid());
			//检查是否已验证或者验证是否通过
			
			//如果session为空或者取消授权，重定向到授权页面
			if (code.equals("")) {
				response.sendRedirect(oauth_url);
				return;
			}

			if(!code.equals("")){				
				String accessTokenUrl = HttpUtil.getUrl(GetWeiXinCode.getAccessTokenURL(weiXinRegisterDepartmentPo.getWrdappid(), weiXinRegisterDepartmentPo.getWrdappsecret(), code));
				JSONObject accessTokenJsonObject = JSONObject.fromObject(accessTokenUrl);
				String access_token = accessTokenJsonObject.getString("access_token");
				System.out.println("access_token=="+access_token);
				String openid = Utility.getName(accessTokenJsonObject.getString("openid"));
				
				String userInfoURL = HttpUtil.getUrl(GetWeiXinCode.getUserInfoURL(access_token,openid));
				JSONObject userInfoJsonObject = JSONObject.fromObject(userInfoURL);
				
//							System.out.println("user_openid==" +userInfoJsonObject.getString("openid"));
//							System.out.println("user_nickname==" +userInfoJsonObject.getString("nickname"));
//							System.out.println("user_sex==" +userInfoJsonObject.getString("sex"));
//							System.out.println("user_province==" +userInfoJsonObject.getString("province"));
//							System.out.println("user_city==" +userInfoJsonObject.getString("city"));
//							System.out.println("user_country==" +userInfoJsonObject.getString("country"));
//							System.out.println("user_headimgurl==" +userInfoJsonObject.getString("headimgurl"));
					
				
				//用户验证后信息写入Session
//				session.setAttribute("userInfoJsonObject", userInfoJsonObject);
//				session.setAttribute("user_headimgurl", userInfoJsonObject.getString("headimgurl")); //微信用户头像
				//用户验证后信息写入Session
				
				
				if(!openid.equals("")&&userInfoJsonObject!=null && userInfoJsonObject.has("headimgurl")){
					WeixinApi.updateCustomerInfoWeixinPic(openid, Utility.getName(userInfoJsonObject.getString("headimgurl")));
				}
				
				String url= "";
				if(key.equals("8")){//进入个人中心
					url= webUrl + "initPersonCenterSel.action?openID=" + openid;
				}else if(key.equals("16")){//进入专家团队
					url= webUrl + "initUserDepartmentDoctor.action?openID=" + openid +"&zhenliao=" +Utility.getName(request.getParameter("zhenliao"));
				}else if(key.equals("14")){//进入预约
					url= webUrl + "initInsertWeiXinOptometryAppointmentPo.action?openID=" + openid;
				}
				else if(key.equals("5")){//进入门店列表
					url= webUrl + "/initWeiXinUserDepartmentsList.action?a="+ new Date().getTime();
				}else{
					url= webUrl + "initPersonCenterSel.action?openID=" + openid;
				}

				response.sendRedirect(url);
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}