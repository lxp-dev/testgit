package com.pengsheng.weixin.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.persistence.CashCouponPo;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.weixin.message.resp.Article;
import com.pengsheng.weixin.message.resp.NewsMessage;
import com.pengsheng.weixin.message.resp.TextMessage;
import com.pengsheng.weixin.mgr.ConfigurationMgr;
import com.pengsheng.weixin.mgr.WeiXinAutoReplyMgr;
import com.pengsheng.weixin.mgr.WeiXinCmsContentMgr;
import com.pengsheng.weixin.mgr.WeiXinDaijinquanMgr;
import com.pengsheng.weixin.mgr.WeiXinDataConfigMgr;
import com.pengsheng.weixin.mgr.WeiXinDepartmentsMgr;
import com.pengsheng.weixin.mgr.WeiXinMenuConfigMgr;
import com.pengsheng.weixin.mgr.WeiXinRegisterDepartmentMgr;
import com.pengsheng.weixin.mgr.WeiXinServiceMgr;
import com.pengsheng.weixin.persistence.ConfigurationPo;
import com.pengsheng.weixin.persistence.WeiXinCmsContentPo;
import com.pengsheng.weixin.persistence.WeiXinDataConfigPo;
import com.pengsheng.weixin.persistence.WeiXinMenuPo;
import com.pengsheng.weixin.persistence.WeiXinRegisterDepartmentPo;
import com.pengsheng.weixin.util.Distance;
import com.pengsheng.weixin.util.MessageUtil;

/**
 * 核心服务类
 */
public class WeixinApi implements ApplicationContextAware{
	
	/**
	 * 处理微信发来的请求
	 * 
	 * @param request
	 * @return
	 */
	private static ApplicationContext context;//声明一个静态变量保存 
	public void setApplicationContext(ApplicationContext contex) 
	 throws BeansException { 
	  this.context=contex; 
	} 
	public static ApplicationContext getContext(){ 
	 return context; 
	}

	public static String processRequest(HttpServletRequest request) {
		
		WeiXinDataConfigMgr weiXinDataConfigMgr=(WeiXinDataConfigMgr)context.getBean("weiXinDataConfigMgr");
		WeiXinMenuConfigMgr weiXinMenuConfigMgr = (WeiXinMenuConfigMgr)context.getBean("weiXinMenuConfigMgr");
		WeiXinDepartmentsMgr weiXinDepartmentsMgr = (WeiXinDepartmentsMgr)context.getBean("weiXinDepartmentsMgr");
		WeiXinCmsContentMgr weiXinCmsContentMgr = (WeiXinCmsContentMgr)context.getBean("weiXinCmsContentMgr");
		WeiXinServiceMgr weiXinServiceMgr=(WeiXinServiceMgr)context.getBean("weiXinServiceMgr");
		WeiXinAutoReplyMgr weiXinAutoReplyMgr=(WeiXinAutoReplyMgr)context.getBean("weiXinAutoReplyMgr");
		ConfigurationMgr configurationMgr = (ConfigurationMgr) context.getBean("configurationMgr");
		
		ConfigurationPo configurationPo = configurationMgr.getConfigurationDetail();
		WeiXinMenuPo weiXinMenuPo = weiXinMenuConfigMgr.getWeiXinMenuPo();
		WeiXinDataConfigPo WeiXinDataConfigPo = weiXinDataConfigMgr.getWeiXinDataConfigPo();
		
		String respMessage = null;
		try {
			// 默认返回的文本消息内容
			String respContent = "请求处理异常，请稍候尝试！";

			// xml请求解析
			Map<String, String> requestMap = MessageUtil.parseXml(request);

			// 发送方帐号（open_id）
			String fromUserName = requestMap.get("FromUserName");
			// 公众帐号
			String toUserName = requestMap.get("ToUserName");
			
			System.out.println("微信公众号原始ID(toUserName)：" + toUserName);
			// 消息类型
			String msgType = requestMap.get("MsgType");
			
			//会员验证
    		String weixinMessage="为了实现微信与本店之间更方便快捷的信息沟通，请先进行身份验证，即享受本店便捷服务。";

			// 回复文本消息
			TextMessage textMessage = new TextMessage();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
			textMessage.setFuncFlag(0);
			
			
			System.out.println("openID==" + fromUserName);
            // 创建图文消息  
            NewsMessage newsMessage = new NewsMessage();  
            newsMessage.setToUserName(fromUserName);  
            newsMessage.setFromUserName(toUserName);  
            newsMessage.setCreateTime(new Date().getTime());  
            newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);  
            newsMessage.setFuncFlag(0);
			
            List<Article> articleList = new ArrayList<Article>();

			// 文本消息
			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
				
				//文本消息
				String content=requestMap.get("Content");
				System.out.println(content);
				String hfString = Utility.getName(weiXinAutoReplyMgr.getWeiXinAutoReplyPo().getWartitlehf());
				
				if(configurationPo.getWcrkftype().equals("1")){
					textMessage.setToUserName(fromUserName);  
				    textMessage.setFromUserName(toUserName);  
				    textMessage.setCreateTime(new Date().getTime());  
				    textMessage.setMsgType("transfer_customer_service");  
				    respMessage = MessageUtil.textMessageToXml(textMessage);
				}else{
					if(!hfString.equals("")){
						textMessage.setContent(hfString);
					}else{
						textMessage.setContent("请等待处理...");
					}
					respMessage = MessageUtil.textMessageToXml(textMessage);
				}
			}
			// 图片消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
				textMessage.setContent("感谢您的关注！");
				respMessage = MessageUtil.textMessageToXml(textMessage);
			}
			// 地理位置消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
				
				String locationx=requestMap.get("Location_X");
				String locationy=requestMap.get("Location_Y");

				System.out.println("x:"+locationx+" y:"+locationy);
				
//				WeiXinCompanyInfoPo companyInfoPo=weiXinServiceMgr.getWeiXinCompanyInfo();
				
				DepartmentsPo departmentsPo = new DepartmentsPo();
				departmentsPo.setBdpissee("0");
				List<DepartmentsPo> departmentslist = weiXinDepartmentsMgr.getDepartmentsList(departmentsPo);
				departmentsPo=getDepartmentDistance(departmentslist,locationx,locationy);
				
                Article article1 = new Article();//附近门店  
                article1.setTitle(departmentsPo.getBdpdepartmentname()+" 距离您"+departmentsPo.getBdpsdistance()+"米");  
                article1.setDescription("");  
                article1.setPicUrl(configurationPo.getWcrurl()+departmentsPo.getBdppicurl());  
                article1.setUrl(configurationPo.getWcrurl()+"/initUserDepartmentsDetail.action?id="+departmentsPo.getBdpdepartmentid()+"&locationx="+locationx+"&locationy="+locationy);  

                Article article2 = new Article();//门店列表  
                article2.setTitle("点击可查看所有门店情况");  
                article2.setDescription("");  
                article2.setPicUrl("");
                article2.setUrl(configurationPo.getWcrurl()+"/initWeiXinUserDepartmentsList.action");
                
                articleList.add(article1);  
                articleList.add(article2);  
                
                // 设置图文消息个数  
                newsMessage.setArticleCount(articleList.size());  
                // 设置图文消息包含的图文集合  
                newsMessage.setArticles(articleList);  
                // 将图文消息对象转换成xml字符串  
                respMessage = MessageUtil.newsMessageToXml(newsMessage);
				
//				respContent="您的地理位置:\n"+locationx+","+locationy+"\n";				
//				respContent = respContent+"抱歉哟，您位置方圆10公里内无门店！";
//				textMessage.setContent(respContent);
//				respMessage = MessageUtil.textMessageToXml(textMessage);
			}
			// 链接消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
//				AutoReplyPo autoReplyPo=weiXinServiceMgr.getAutoReply("1");					
//				respContent=autoReplyPo.getWardescription();
//				textMessage.setContent(respContent);
//				respMessage = MessageUtil.textMessageToXml(textMessage);
			}
			// 音频消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
//				AutoReplyPo autoReplyPo=weiXinServiceMgr.getAutoReply("1");					
//				respContent=autoReplyPo.getWardescription();
//				textMessage.setContent(respContent);
//				respMessage = MessageUtil.textMessageToXml(textMessage);
			}
			// 事件推送
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
				// 事件类型
				String eventType = requestMap.get("Event");
				// 订阅
				if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
					String gzString = Utility.getName(weiXinAutoReplyMgr.getWeiXinAutoReplyPo().getWartitlegz());
					if(!gzString.equals("")){
						textMessage.setContent(gzString);
						respMessage = MessageUtil.textMessageToXml(textMessage);
					}else{
						textMessage.setContent("感谢您的关注！");
						respMessage = MessageUtil.textMessageToXml(textMessage);
					}
					
				}
				// 取消订阅
				else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
					// 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
				}
				// 自定义菜单点击事件
				else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
					// 事件KEY值，与创建自定义菜单时指定的KEY值对应
					String eventKey = requestMap.get("EventKey");
					String typeid = Utility.getName(getWeixinMenuConfigTypeid(weiXinMenuPo,eventKey));
					
					System.out.println("自定义 eventKey=="+eventKey);
					System.out.println("自定义 typeid=="+typeid);
					
					if (typeid.equals("3")) {//以图文形式打开指定文章列表	
						System.out.println("以图文形式打开指定文章列表");
						String contentStr = getWeixinMenuConfigContent(weiXinMenuPo, eventKey);
						String splitStr[] = contentStr.split(",");
						
						for(int i=0;i<splitStr.length;i++){
							WeiXinCmsContentPo tmp = new WeiXinCmsContentPo();
							tmp.setWcmscid(splitStr[i]);
							WeiXinCmsContentPo weiXinCmsContentPo = weiXinCmsContentMgr.selectWeiXinCmsContentPo(tmp);
							Article article = new Article();  
		                    article.setTitle(weiXinCmsContentPo.getWcmsctitle());  
		                    article.setDescription("");  
		                    
		                    if(i==0){//第一行大图
			                    if(!Utility.getName(weiXinCmsContentPo.getWcmscpicurl()).equals("")){
			                    	article.setPicUrl(configurationPo.getWcrurl()+weiXinCmsContentPo.getWcmscpicurl());  
			                    }else{
			                    	if(Utility.getName(WeiXinDataConfigPo.getWdccmslargepicurl()).equals("")){
			                    		article.setPicUrl(configurationPo.getWcrurl()+"/weixin_personcenter/default_images/personcenter.png");
			                    	}else{
			                    		article.setPicUrl(configurationPo.getWcrurl()+WeiXinDataConfigPo.getWdccmslargepicurl());
			                    	}			                    	
			                    }	
		                    }else{
			                    if(!Utility.getName(weiXinCmsContentPo.getWcmscpicurl()).equals("")){
			                    	article.setPicUrl(configurationPo.getWcrurl()+weiXinCmsContentPo.getWcmscpicurl());  
			                    }else{
			                    	if(Utility.getName(WeiXinDataConfigPo.getWdccmssmallpicurl()).equals("")){
			                    		article.setPicUrl(configurationPo.getWcrurl()+"/weixin_personcenter/default_images/weixin_small.png");
			                    	}else{
			                    		article.setPicUrl(configurationPo.getWcrurl()+WeiXinDataConfigPo.getWdccmssmallpicurl());
			                    	}
			                    	
			                    }
		                    }

		                    article.setUrl(configurationPo.getWcrurl()+"/initUserCmsContentDetails.action?hid="+splitStr[i]);
		                    articleList.add(article);
						}
						
	                    newsMessage.setArticleCount(articleList.size());  
	                    newsMessage.setArticles(articleList);  
	                    respMessage = MessageUtil.newsMessageToXml(newsMessage); 
					}
					else if (typeid.equals("5")) {//附近门店		
						System.out.println("附近门店");
						Article article = new Article();  
	                    article.setTitle("点击浏览所有门店信息");  
	                    article.setDescription("");  
	                    
	                    if(Utility.getName(WeiXinDataConfigPo.getWdcdepartmentpicurl()) ==""){
                    		article.setPicUrl(configurationPo.getWcrurl()+"/weixin_personcenter/default_images/mendianliebiao.jpg");
                    	}else{
                    		article.setPicUrl(configurationPo.getWcrurl()+WeiXinDataConfigPo.getWdcdepartmentpicurl());
                    	}	  
	                    
	                    article.setPicUrl(configurationPo.getWcrurl()+WeiXinDataConfigPo.getWdcdepartmentpicurl());  
	                    article.setUrl(configurationPo.getWcrurl()+"/initWeiXinUserDepartmentsListShow.action?a="+ new Date().getTime());
	                    articleList.add(article);
	                    
	                    article = new Article();  
	                    article.setTitle("点击文字输入旁边的“+”,发送您的位置，即可查看附近门店！");  
	                    article.setDescription("还不懂输入定位信息 ?");  
	                    article.setPicUrl(configurationPo.getWcrurl()+"/weixin/images/dingwei.png");  
	                    article.setUrl(configurationPo.getWcrurl()+"/initUserDepartmentsHelp.action");
	                    articleList.add(article);
	                    
	                    newsMessage.setArticleCount(articleList.size());  
	                    newsMessage.setArticles(articleList);  
	                    respMessage = MessageUtil.newsMessageToXml(newsMessage); 
					}else if (typeid.equals("6")) {//订单查询		
						System.out.println("订单查询	");
						CustomerInfoPo customerInfoPo=weiXinServiceMgr.getWeiXinCustomer(fromUserName);
				        if(customerInfoPo.getSmeciphone()==null){
				        	respContent=weixinMessage+"\n"+"<a href=\""+configurationPo.getWcrurl()+"/initWeiXinMemberBindSel.action?toUserName="+ toUserName +"&openID="+fromUserName+"\">请点击此处进行身份验证</a>";
			            }else{
			    		    if(customerInfoPo.getSmeciname()!=null &&!"".equals(customerInfoPo.getSmeciname())){
			    			    respContent="尊敬的顾客:"+customerInfoPo.getSmeciname()+",";
			    		    }else{
			    		    	respContent="尊敬的顾客 ,";
			    		    }
			            	int salesCount=weiXinServiceMgr.getSalesCount(fromUserName);
			            	if(salesCount>0){
				    		      respContent=respContent+"您最近一年有"+salesCount+"笔配镜记录。"+"\n";
					              respContent=respContent+"请点击"+"<a href=\""+configurationPo.getWcrurl()+"/initWeiXinSalesBillSel.action?openID="+fromUserName+"\"> 这里 </a> 查看详细配镜信息";
			            	}else{
			            		respContent=respContent+"您最近一年无配镜记录";
			            	}
			            }
						textMessage.setContent(respContent);
						respMessage = MessageUtil.textMessageToXml(textMessage);
					}else if (typeid.equals("7") || typeid.equals("9")) {//会员积分		
						System.out.println("会员积分");
						CustomerInfoPo customerInfoPo=weiXinServiceMgr.getWeiXinCustomer(fromUserName);
				        if(customerInfoPo.getSmeciphone()==null){
				        	respContent=weixinMessage+"\n"+"<a href=\""+configurationPo.getWcrurl()+"/initWeiXinMemberBindSel.action?toUserName="+ toUserName +"&openID="+fromUserName+"\">请点击此处进行身份验证</a>";
				        	textMessage.setContent(respContent);
							respMessage = MessageUtil.textMessageToXml(textMessage);
				        }else{		
			            	Article article = new Article();  
			            	article.setTitle("点击进入积分商城"); 
		                    article.setDescription("");  
		                    article.setPicUrl(configurationPo.getWcrurl()+"/weixin_personcenter/default_images/personcenter.png?1=1");  
		                    article.setUrl(configurationPo.getWcrurl()+"/initIntegralMallSel.action?toUserName="+ toUserName +"&openID="+fromUserName);		                    
		                    articleList.add(article);
		                    
		                    newsMessage.setArticleCount(articleList.size());  
		                    newsMessage.setArticles(articleList);  
		                    respMessage = MessageUtil.newsMessageToXml(newsMessage);
			            }
					}else if (typeid.equals("8")) {//个人中心			
						System.out.println("个人中心");
						CustomerInfoPo customerInfoPo=weiXinServiceMgr.getWeiXinCustomer(fromUserName);
				        if(customerInfoPo.getSmeciphone()==null){
				        	respContent=weixinMessage+"\n"+"<a href=\""+configurationPo.getWcrurl()+"/initWeiXinMemberBindSel.action?toUserName="+ toUserName +"&openID="+fromUserName+"\">请点击此处进行身份验证</a>";
							textMessage.setContent(respContent);
							respMessage = MessageUtil.textMessageToXml(textMessage);
			            }else{
			            	Article article = new Article();  
			            	article.setTitle("点击进入个人中心"); 
		                    article.setDescription("");  
		                    article.setPicUrl(configurationPo.getWcrurl()+"/weixin_personcenter/default_images/personcenter.png?1=1");  
		                    article.setUrl(configurationPo.getWcrurl()+"/oauth2Servlet?toUserName="+ toUserName +"&openID="+fromUserName);		                    
		                    articleList.add(article);
		                    
		                    newsMessage.setArticleCount(articleList.size());  
		                    newsMessage.setArticles(articleList);  
		                    respMessage = MessageUtil.newsMessageToXml(newsMessage);
			            }
					}else if (typeid.equals("10")) {//每日签到
						
						System.out.println("每日签到");
						CustomerInfoPo customerInfoPo=weiXinServiceMgr.getWeiXinCustomer(fromUserName);
				        if(customerInfoPo.getSmeciphone()==null){
				        	respContent=weixinMessage+"\n"+"<a href=\""+configurationPo.getWcrurl()+"/initWeiXinMemberBindSel.action?toUserName="+ toUserName +"&openID="+fromUserName+"\">请点击此处进行身份验证</a>";
			            }else{			            	
				    		if(customerInfoPo.getSmeciname()!=null &&!"".equals(customerInfoPo.getSmeciname())){
				    			respContent="尊敬的顾客:"+customerInfoPo.getSmeciname()+",";
				    		}else{
				    			respContent="尊敬的顾客 ,";
				    		}
			            	respContent=respContent+"请点击"+"<a href=\""+configurationPo.getWcrurl()+"/initWeiXinDailyAttendance.action?openID="+fromUserName+"\"> 这里 </a> 进行签到。";
			            }
						textMessage.setContent(respContent);
						respMessage = MessageUtil.textMessageToXml(textMessage);
					}else if (typeid.equals("11")) {//幸运抽奖	
						System.out.println("优幸运抽奖");
						CustomerInfoPo customerInfoPo=weiXinServiceMgr.getWeiXinCustomer(fromUserName);
						if(customerInfoPo.getSmeciphone()==null){
				        	respContent=weixinMessage+"\n"+"<a href=\""+configurationPo.getWcrurl()+"/initWeiXinMemberBindSel.action?toUserName="+ toUserName +"&openID="+fromUserName+"\">请点击此处进行身份验证</a>";
			            }else{
				    		if(customerInfoPo.getSmeciname()!=null &&!"".equals(customerInfoPo.getSmeciname())){
				    			respContent="尊敬的顾客:"+customerInfoPo.getSmeciname()+",";
				    		}else{
				    			respContent="尊敬的顾客 ,";
				    		}
				    		respContent=respContent+"欢迎使用幸运抽奖~"+"请点击"+"<a href=\""+configurationPo.getWcrurl()+"/initWeiXinScratchOffSel.action?openID="+fromUserName+"\"> 这里 </a> 进行抽奖";
			            }			            

						textMessage.setContent(respContent);
						respMessage = MessageUtil.textMessageToXml(textMessage);
					}else if (typeid.equals("12")) {//优惠券下载	
						System.out.println("优惠券下载");
						CustomerInfoPo customerInfoPo=weiXinServiceMgr.getWeiXinCustomer(fromUserName);
				        if(customerInfoPo.getSmeciphone()==null){
				        	respContent=weixinMessage+"\n"+"<a href=\""+configurationPo.getWcrurl()+"/initWeiXinMemberBindSel.action?toUserName="+ toUserName +"&openID="+fromUserName+"\">请点击此处进行身份验证</a>";
				        	textMessage.setContent(respContent);
							respMessage = MessageUtil.textMessageToXml(textMessage);
			            }else{
			            	WeiXinDaijinquanMgr weiXinChuZhiCardMgr=(WeiXinDaijinquanMgr)context.getBean("weiXinDaijinquanMgr");
							CashCouponPo cpo = weiXinChuZhiCardMgr.insertCashCouponByOpenID(fromUserName);
							
							if(!"".equals(Utility.getName(cpo.getBcccard()))){
								Article article = new Article();  	                    
			                    article.setTitle("代金券");  
			                    article.setDescription("欢迎领用"+cpo.getBccamount()+"元代金券，优惠券号："+cpo.getBcccard()+"，请您到店使用。");  
			                    article.setPicUrl(configurationPo.getWcrurl()+"/qrservlet?qrtext="+cpo.getBcccard());  
			                    article.setUrl(configurationPo.getWcrurl()+"/qrservlet?qrtext="+cpo.getBcccard());
			                    articleList.add(article);
			                    
			                    newsMessage.setArticleCount(articleList.size());  
			                    newsMessage.setArticles(articleList);  
								respMessage = MessageUtil.newsMessageToXml(newsMessage);
								
							}else{
								respContent="此期间暂不提供代金券";
								textMessage.setContent(respContent);
								respMessage = MessageUtil.textMessageToXml(textMessage);
							}
			            }			
					}else if (typeid.equals("13")) {//会员投诉	
						System.out.println("会员投诉");
						CustomerInfoPo customerInfoPo=weiXinServiceMgr.getWeiXinCustomer(fromUserName);
				        if(customerInfoPo.getSmeciphone()==null){
				        	respContent=weixinMessage+"\n"+"<a href=\""+configurationPo.getWcrurl()+"/initWeiXinMemberBindSel.action?toUserName="+ toUserName +"&openID="+fromUserName+"\">请点击此处进行身份验证</a>";
			            }else{
			            	if ((customerInfoPo.getSmeciname() != null) && (!"".equals(customerInfoPo.getSmeciname())))
			                    respContent = "尊敬的顾客:" + customerInfoPo.getSmeciname() + ",";
			                  else {
			                    respContent = "尊敬的顾客 ,";
			                  }
			                  respContent = respContent + "欢迎您使用服务建议。" + "\n";
			                  respContent = respContent + "请点击" + "<a href=\"" + configurationPo.getWcrurl() + "/initUserInsertCustomerComplain.action?openID=" + fromUserName + "\"> 这里 </a> 进行服务建议";
			            }
						textMessage.setContent(respContent);
						respMessage = MessageUtil.textMessageToXml(textMessage);
					}else if (typeid.equals("14")) {//验光预约
						System.out.println("预约挂号");
						CustomerInfoPo customerInfoPo=weiXinServiceMgr.getWeiXinCustomer(fromUserName);
				        if(customerInfoPo.getSmeciphone()==null){
				        	respContent=weixinMessage+"\n"+"<a href=\""+configurationPo.getWcrurl()+"/initWeiXinMemberBindSel.action?toUserName="+ toUserName +"&openID="+fromUserName+"\">请点击此处进行身份验证</a>";
							textMessage.setContent(respContent);
							respMessage = MessageUtil.textMessageToXml(textMessage);
			            }else{
			            	Article article = new Article();  
		                    article.setTitle("点击进入预约挂号");  
		                    article.setDescription("");  
		                    article.setPicUrl(configurationPo.getWcrurl()+"/weixin_personcenter/default_images/yuyue.jpg?1=1");  
		                    article.setUrl(configurationPo.getWcrurl()+"/initInsertWeiXinOptometryAppointmentPo.action?toUserName="+ toUserName +"&openID=" + fromUserName);		                    
		                    articleList.add(article);
		                    
		                    newsMessage.setArticleCount(articleList.size());  
		                    newsMessage.setArticles(articleList);  
		                    respMessage = MessageUtil.newsMessageToXml(newsMessage);
			            }
				        
					}else if (typeid.equals("15")) {//微商城	
						System.out.println("微商城");
						CustomerInfoPo customerInfoPo=weiXinServiceMgr.getWeiXinCustomer(fromUserName);
				        if(customerInfoPo.getSmeciphone()==null){
				        	respContent=weixinMessage+"\n"+"<a href=\""+configurationPo.getWcrurl()+"/initWeiXinMemberBindSel.action?toUserName="+ toUserName +"&openID="+fromUserName+"\">请点击此处进行身份验证</a>";
							textMessage.setContent(respContent);
							respMessage = MessageUtil.textMessageToXml(textMessage);
			            }else{
			            	Article article = new Article();  
		                    article.setTitle("点击进入微商城");  
		                    article.setDescription("");  
		                    article.setPicUrl(configurationPo.getWcrurl()+"/img/weixin/weishangcheng.png");  
		                    article.setUrl(configurationPo.getWcrurl()+"/selectMallGoodsList.action?openID=" + fromUserName);
		                    articleList.add(article);
		                    
		                    article = new Article();  
		                    article.setTitle("尊敬的顾客:" + customerInfoPo.getSmeciname());  
		                    article.setDescription("点击查看您的账户-->");  
		                    article.setPicUrl(configurationPo.getWcrurl()+"/img/weixin/user.jpg");  
		                    article.setUrl(configurationPo.getWcrurl()+"/selectUserCenterList.action?openID=" + fromUserName +"&userName="+customerInfoPo.getSmeciname());
		                    articleList.add(article);
		                    
		                    newsMessage.setArticleCount(articleList.size());  
		                    newsMessage.setArticles(articleList);  
		                    respMessage = MessageUtil.newsMessageToXml(newsMessage);
			            }
				        
					}else if (typeid.equals("16")) {//专家团队
						System.out.println("专家团队");
						Article article = new Article();  
	                    article.setTitle("点击进入专家团队");  
	                    article.setDescription("");  
	                    article.setPicUrl(configurationPo.getWcrurl()+"/weixin_personcenter/default_images/zhuanjiatuandui.jpg?1=1");  
	                    article.setUrl(configurationPo.getWcrurl()+"/initUserDepartmentDoctor.action?toUserName="+ toUserName +"&openID=" + fromUserName);		                    
	                    articleList.add(article);
	                    
	                    newsMessage.setArticleCount(articleList.size());  
	                    newsMessage.setArticles(articleList);  
	                    respMessage = MessageUtil.newsMessageToXml(newsMessage);
				        
					}else{
						textMessage.setContent("暂无服务!");
						respMessage = MessageUtil.textMessageToXml(textMessage);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return respMessage;
	}
	
	//获取附近门店
	public static DepartmentsPo getDepartmentDistance(List<DepartmentsPo> departmentslist,String locationx,String locationy){
		
		if(locationx.equals("")){
			locationx="0";
		}
		if(locationy.equals("")){
			locationx="0";
		}	
		
		double distanceTemp=100000000.00;
		DepartmentsPo departmentsPo=new DepartmentsPo();
		for(int i=0;i<departmentslist.size();i++){
			if(departmentslist.get(i).getBdplocationy().equals("")){
				departmentslist.get(i).setBdplocationy("0");
			}
			if(departmentslist.get(i).getBdplocationx().equals("")){
				departmentslist.get(i).setBdplocationx("0");
			}
			double distance = Distance.GetDistance(Double.parseDouble(locationy),Double.parseDouble(locationx),Double.parseDouble(departmentslist.get(i).getBdplocationy()),Double.parseDouble(departmentslist.get(i).getBdplocationx()));
			if(distance<distanceTemp){
				distanceTemp=distance;
				departmentsPo=departmentslist.get(i);
				departmentsPo.setBdpsdistance(String.valueOf(distance));
			}
		}
		return departmentsPo;
	}

	public static String getWeixinMenuConfigContent(WeiXinMenuPo weiXinMenuPo,String eventKey){
		if(eventKey.equals("11")){
			return weiXinMenuPo.getWmccontent11();
		}else if(eventKey.equals("12")){
			return weiXinMenuPo.getWmccontent12();
		}else if(eventKey.equals("13")){
			return weiXinMenuPo.getWmccontent13();
		}else if(eventKey.equals("14")){
			return weiXinMenuPo.getWmccontent14();
		}else if(eventKey.equals("15")){
			return weiXinMenuPo.getWmccontent15();
		}else if(eventKey.equals("21")){
			return weiXinMenuPo.getWmccontent21();
		}else if(eventKey.equals("22")){
			return weiXinMenuPo.getWmccontent22();
		}else if(eventKey.equals("23")){
			return weiXinMenuPo.getWmccontent23();
		}else if(eventKey.equals("24")){
			return weiXinMenuPo.getWmccontent24();
		}else if(eventKey.equals("25")){
			return weiXinMenuPo.getWmccontent25();
		}else if(eventKey.equals("31")){
			return weiXinMenuPo.getWmccontent31();
		}else if(eventKey.equals("32")){
			return weiXinMenuPo.getWmccontent32();
		}else if(eventKey.equals("33")){
			return weiXinMenuPo.getWmccontent33();
		}else if(eventKey.equals("34")){
			return weiXinMenuPo.getWmccontent34();
		}else if(eventKey.equals("35")){
			return weiXinMenuPo.getWmccontent35();
		}else{
			return "";
		}		
	}
	
	public static String getWeixinMenuConfigTypeid(WeiXinMenuPo weiXinMenuPo,String eventKey){
		if(eventKey.equals("11")){
			return weiXinMenuPo.getWmctypeid11();
		}else if(eventKey.equals("12")){
			return weiXinMenuPo.getWmctypeid12();
		}else if(eventKey.equals("13")){
			return weiXinMenuPo.getWmctypeid13();
		}else if(eventKey.equals("14")){
			return weiXinMenuPo.getWmctypeid14();
		}else if(eventKey.equals("15")){
			return weiXinMenuPo.getWmctypeid15();
		}else if(eventKey.equals("21")){
			return weiXinMenuPo.getWmctypeid21();
		}else if(eventKey.equals("22")){
			return weiXinMenuPo.getWmctypeid22();
		}else if(eventKey.equals("23")){
			return weiXinMenuPo.getWmctypeid23();
		}else if(eventKey.equals("24")){
			return weiXinMenuPo.getWmctypeid24();
		}else if(eventKey.equals("25")){
			return weiXinMenuPo.getWmctypeid25();
		}else if(eventKey.equals("31")){
			return weiXinMenuPo.getWmctypeid31();
		}else if(eventKey.equals("32")){
			return weiXinMenuPo.getWmctypeid32();
		}else if(eventKey.equals("33")){
			return weiXinMenuPo.getWmctypeid33();
		}else if(eventKey.equals("34")){
			return weiXinMenuPo.getWmctypeid34();
		}else if(eventKey.equals("35")){
			return weiXinMenuPo.getWmctypeid35();
		}else{
			return "";
		}		
	}
	
	public static WeiXinRegisterDepartmentPo getWeiXinRegisterDepartmentPo(String toUserName){
		WeiXinRegisterDepartmentMgr weiXinRegisterDepartmentMgr=(WeiXinRegisterDepartmentMgr)context.getBean("weiXinRegisterDepartmentMgr");
		WeiXinRegisterDepartmentPo weiXinRegisterDepartmentPo = new WeiXinRegisterDepartmentPo();
		weiXinRegisterDepartmentPo.setWrdaccount(toUserName);
		weiXinRegisterDepartmentPo = weiXinRegisterDepartmentMgr.getWeiXinRegisterDepartmentPo(weiXinRegisterDepartmentPo);
		return weiXinRegisterDepartmentPo;
	}
	
	public static void updateCustomerInfoWeixinPic(String openID,String picUrl){
		ConfigurationMgr configurationMgr = (ConfigurationMgr) context.getBean("configurationMgr");
		configurationMgr.updateCustomerInfoWeixinPic(openID, picUrl);
	}
}
