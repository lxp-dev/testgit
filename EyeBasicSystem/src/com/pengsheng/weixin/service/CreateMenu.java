package com.pengsheng.weixin.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.weixin.persistence.ConfigurationPo;
import com.pengsheng.weixin.persistence.WeiXinMenuPo;
import com.pengsheng.weixin.persistence.WeiXinRegisterDepartmentPo;
import com.pengsheng.weixin.po.AccessToken;
import com.pengsheng.weixin.po.ButtonType;
import com.pengsheng.weixin.po.CommonButton;
import com.pengsheng.weixin.po.ComplexButton;
import com.pengsheng.weixin.po.Menu;
import com.pengsheng.weixin.po.Button;
import com.pengsheng.weixin.po.ViewButton;
import com.pengsheng.weixin.util.WeixinUtil;
  
/** 
 * 菜单管理器类 
 *  
 * @author 
 * @date 
 */  
public  class CreateMenu{  

    public static int  generationmenumanager(WeiXinMenuPo weiXinMenuPo,ConfigurationPo configurationPo,WeiXinRegisterDepartmentPo weiXinRegisterDepartmentPo) {  
    
    	// 微信号原始ID   
    	String toUserName = weiXinRegisterDepartmentPo.getWrdaccount();
        // 第三方用户唯一凭证   
    	String appId = weiXinRegisterDepartmentPo.getWrdappid();  
        // 第三方用户唯一凭证密钥  
    	String appSecret = weiXinRegisterDepartmentPo.getWrdappsecret(); 
        
        // 调用接口获取access_token  
        AccessToken at = WeixinUtil.getAccessToken(appId, appSecret);  
        int result = 0;
        if (null != at) {  
            // 调用接口创建菜单  
            result = WeixinUtil.createMenu(getMenu(toUserName,appId,weiXinMenuPo,Utility.getName(configurationPo.getWcrurl())), at.getToken());  
//        	Menu a =getMenu(weiXinMenuPo,Utility.getName(configurationPo.getWcrurl()));
        }  
        
        return result;
    }  
  
    /** 
     * 组装菜单数据 
     *  
     * @return 
     */  
    private static Menu getMenu(String toUserName,String appId,WeiXinMenuPo weiXinMenuPo,String url) {  
    	
    	Button btn11=null;
    	Button btn12=null;
    	Button btn13=null;
    	Button btn14=null;
    	Button btn15=null;
    	
    	Button btn21=null;
    	Button btn22=null;
    	Button btn23=null;
    	Button btn24=null;
    	Button btn25=null;
    	
    	Button btn31=null;
    	Button btn32=null;
    	Button btn33=null;
    	Button btn34=null;
    	Button btn35=null;
    	
    	List<Button> buttonList1 = new ArrayList();
    	List<Button> buttonList2 = new ArrayList();
    	List<Button> buttonList3 = new ArrayList();
    	
    	ComplexButton mainBtn1 = new ComplexButton();
    	ComplexButton mainBtn2 = new ComplexButton();
    	ComplexButton mainBtn3 = new ComplexButton();
    	

    	
    	buttonList1 = addButtonToButtonList(toUserName,appId,weiXinMenuPo.getWmcflag11(),weiXinMenuPo.getWmctypeid11(),weiXinMenuPo.getWmcname11(),weiXinMenuPo.getWmccontent11(),"11",url,btn11,buttonList1);
    	buttonList1 = addButtonToButtonList(toUserName,appId,weiXinMenuPo.getWmcflag12(),weiXinMenuPo.getWmctypeid12(),weiXinMenuPo.getWmcname12(),weiXinMenuPo.getWmccontent12(),"12",url,btn12,buttonList1);
    	buttonList1 = addButtonToButtonList(toUserName,appId,weiXinMenuPo.getWmcflag13(),weiXinMenuPo.getWmctypeid13(),weiXinMenuPo.getWmcname13(),weiXinMenuPo.getWmccontent13(),"13",url,btn13,buttonList1);
    	buttonList1 = addButtonToButtonList(toUserName,appId,weiXinMenuPo.getWmcflag14(),weiXinMenuPo.getWmctypeid14(),weiXinMenuPo.getWmcname14(),weiXinMenuPo.getWmccontent14(),"14",url,btn14,buttonList1);
    	buttonList1 = addButtonToButtonList(toUserName,appId,weiXinMenuPo.getWmcflag15(),weiXinMenuPo.getWmctypeid15(),weiXinMenuPo.getWmcname15(),weiXinMenuPo.getWmccontent15(),"15",url,btn15,buttonList1);
    	
    	buttonList2 = addButtonToButtonList(toUserName,appId,weiXinMenuPo.getWmcflag21(),weiXinMenuPo.getWmctypeid21(),weiXinMenuPo.getWmcname21(),weiXinMenuPo.getWmccontent21(),"21",url,btn21,buttonList2);
    	buttonList2 = addButtonToButtonList(toUserName,appId,weiXinMenuPo.getWmcflag22(),weiXinMenuPo.getWmctypeid22(),weiXinMenuPo.getWmcname22(),weiXinMenuPo.getWmccontent22(),"22",url,btn22,buttonList2);
    	buttonList2 = addButtonToButtonList(toUserName,appId,weiXinMenuPo.getWmcflag23(),weiXinMenuPo.getWmctypeid23(),weiXinMenuPo.getWmcname23(),weiXinMenuPo.getWmccontent23(),"23",url,btn23,buttonList2);
    	buttonList2 = addButtonToButtonList(toUserName,appId,weiXinMenuPo.getWmcflag24(),weiXinMenuPo.getWmctypeid24(),weiXinMenuPo.getWmcname24(),weiXinMenuPo.getWmccontent24(),"24",url,btn24,buttonList2);
    	buttonList2 = addButtonToButtonList(toUserName,appId,weiXinMenuPo.getWmcflag25(),weiXinMenuPo.getWmctypeid25(),weiXinMenuPo.getWmcname25(),weiXinMenuPo.getWmccontent25(),"25",url,btn25,buttonList2);
    	
    	buttonList3 = addButtonToButtonList(toUserName,appId,weiXinMenuPo.getWmcflag31(),weiXinMenuPo.getWmctypeid31(),weiXinMenuPo.getWmcname31(),weiXinMenuPo.getWmccontent31(),"31",url,btn31,buttonList3);
    	buttonList3 = addButtonToButtonList(toUserName,appId,weiXinMenuPo.getWmcflag32(),weiXinMenuPo.getWmctypeid32(),weiXinMenuPo.getWmcname32(),weiXinMenuPo.getWmccontent32(),"32",url,btn32,buttonList3);
    	buttonList3 = addButtonToButtonList(toUserName,appId,weiXinMenuPo.getWmcflag33(),weiXinMenuPo.getWmctypeid33(),weiXinMenuPo.getWmcname33(),weiXinMenuPo.getWmccontent33(),"33",url,btn33,buttonList3);
    	buttonList3 = addButtonToButtonList(toUserName,appId,weiXinMenuPo.getWmcflag34(),weiXinMenuPo.getWmctypeid34(),weiXinMenuPo.getWmcname34(),weiXinMenuPo.getWmccontent34(),"34",url,btn34,buttonList3);
    	buttonList3 = addButtonToButtonList(toUserName,appId,weiXinMenuPo.getWmcflag35(),weiXinMenuPo.getWmctypeid35(),weiXinMenuPo.getWmcname35(),weiXinMenuPo.getWmccontent35(),"35",url,btn35,buttonList3);
    	
//    	if(weiXinMenuPo.getWmcflag11().equals("1")){
//		if(weiXinMenuPo.getWmctypeid11().equals("1")){
//			btn11 = new ViewButton();
//	        btn11.setName(weiXinMenuPo.getWmcname11());  
//	        ((ViewButton) btn11).setType("view");  
//	        ((ViewButton) btn11).setUrl(weiXinMenuPo.getWmccontent11()); 
//		}else if(weiXinMenuPo.getWmctypeid11().equals("2")){
//			btn11 = new ViewButton();
//	        btn11.setName(weiXinMenuPo.getWmcname11());  
//	        ((ViewButton) btn11).setType("view");  
//	        ((ViewButton) btn11).setUrl(url+"/initUserCmsContentDetails.action?hid=" + weiXinMenuPo.getWmccontent11()); 
//		}else{
//			btn11 = new CommonButton();
//	        btn11.setName(weiXinMenuPo.getWmcname11());  
//	        ((CommonButton) btn11).setType("click");  
//	        ((CommonButton) btn11).setKey("11");	
//		} 
//		buttonList1.add(btn11);
//	}
    	
//    	if(weiXinMenuPo.getWmcflag12().equals("1")){
//    		if(weiXinMenuPo.getWmctypeid12().equals("1")){
//    			btn12 = new ViewButton();
//    	        btn12.setName(weiXinMenuPo.getWmcname12());  
//    	        ((ViewButton) btn12).setType("view");  
//    	        ((ViewButton) btn12).setUrl(weiXinMenuPo.getWmccontent12()); 
//    		}else if(weiXinMenuPo.getWmctypeid12().equals("2")){
//    			btn12 = new ViewButton();
//    	        btn12.setName(weiXinMenuPo.getWmcname12());  
//    	        ((ViewButton) btn12).setType("view");  
//    	        ((ViewButton) btn12).setUrl(url+"/initUserCmsContentDetails.action?hid=" + weiXinMenuPo.getWmccontent12()); 
//    		}else{
//    			btn12 = new CommonButton();
//    	        btn12.setName(weiXinMenuPo.getWmcname12());  
//    	        ((CommonButton) btn12).setType("click");  
//    	        ((CommonButton) btn12).setKey("12");	
//    		}    		
//    		buttonList1.add(btn12);
//    	}
//    	  
//    	if(weiXinMenuPo.getWmcflag13().equals("1")){
//    		if(weiXinMenuPo.getWmctypeid13().equals("1")){
//    			btn13 = new ViewButton();
//    	        btn13.setName(weiXinMenuPo.getWmcname13());  
//    	        ((ViewButton) btn13).setType("view");  
//    	        ((ViewButton) btn13).setUrl(weiXinMenuPo.getWmccontent13()); 
//    		}else if(weiXinMenuPo.getWmctypeid13().equals("2")){
//    			btn13 = new ViewButton();
//    	        btn13.setName(weiXinMenuPo.getWmcname13());  
//    	        ((ViewButton) btn13).setType("view");  
//    	        ((ViewButton) btn13).setUrl(url+"/initUserCmsContentDetails.action?hid=" + weiXinMenuPo.getWmccontent13()); 
//    		}else{
//    			btn13 = new CommonButton();
//    	        btn13.setName(weiXinMenuPo.getWmcname13());  
//    	        ((CommonButton) btn13).setType("click");  
//    	        ((CommonButton) btn13).setKey("13");	
//    		}   	
//    		buttonList1.add(btn13);
//    	}  	
//    	  
//    	if(weiXinMenuPo.getWmcflag14().equals("1")){
//    		if(weiXinMenuPo.getWmctypeid14().equals("1")){
//    			btn14 = new ViewButton();
//    	        btn14.setName(weiXinMenuPo.getWmcname14());  
//    	        ((ViewButton) btn14).setType("view");  
//    	        ((ViewButton) btn14).setUrl(weiXinMenuPo.getWmccontent14()); 
//    		}else if(weiXinMenuPo.getWmctypeid14().equals("2"))
//    		{
//    			btn14 = new ViewButton();
//    	        btn14.setName(weiXinMenuPo.getWmcname14());  
//    	        ((ViewButton) btn14).setType("view");  
//    	        ((ViewButton) btn14).setUrl(url+"/initUserCmsContentDetails.action?hid=" + weiXinMenuPo.getWmccontent14()); 
//    		}else{
//    			btn14 = new CommonButton();
//    	        btn14.setName(weiXinMenuPo.getWmcname14());  
//    	        ((CommonButton) btn14).setType("click");  
//    	        ((CommonButton) btn14).setKey("14");	
//    		}   		
//    		buttonList1.add(btn14);
//    	} 
//    	  
//    	if(weiXinMenuPo.getWmcflag15().equals("1")){
//    		if(weiXinMenuPo.getWmctypeid15().equals("1")){
//    			btn15 = new ViewButton();
//    	        btn15.setName(weiXinMenuPo.getWmcname15());  
//    	        ((ViewButton) btn15).setType("view");  
//    	        ((ViewButton) btn15).setUrl(weiXinMenuPo.getWmccontent15()); 
//    		}else if(weiXinMenuPo.getWmctypeid14().equals("2")){
//    			btn15 = new ViewButton();
//    	        btn15.setName(weiXinMenuPo.getWmcname15());  
//    	        ((ViewButton) btn15).setType("view");  
//    	        ((ViewButton) btn15).setUrl(url+"/initUserCmsContentDetails.action?hid=" + weiXinMenuPo.getWmccontent15());     			
//    		}else{
//    			btn15 = new CommonButton();
//    	        btn15.setName(weiXinMenuPo.getWmcname15());  
//    	        ((CommonButton) btn15).setType("click");  
//    	        ((CommonButton) btn15).setKey("15");	
//    		}   
//    		buttonList1.add(btn15);
//    	}
//    	  
//    	if(weiXinMenuPo.getWmcflag21().equals("1")){
//    		if(weiXinMenuPo.getWmctypeid21().equals("1")){
//    			btn21 = new ViewButton();
//    	        btn21.setName(weiXinMenuPo.getWmcname21());  
//    	        ((ViewButton) btn21).setType("view");  
//    	        ((ViewButton) btn21).setUrl(weiXinMenuPo.getWmccontent21()); 
//    		}else if(weiXinMenuPo.getWmctypeid21().equals("2")){
//    			btn21 = new ViewButton();
//    	        btn21.setName(weiXinMenuPo.getWmcname21());  
//    	        ((ViewButton) btn21).setType("view");  
//    	        ((ViewButton) btn21).setUrl(url+"/initUserCmsContentDetails.action?hid=" + weiXinMenuPo.getWmccontent21());    			
//    		}else{
//    			btn21 = new CommonButton();
//    	        btn21.setName(weiXinMenuPo.getWmcname21());  
//    	        ((CommonButton) btn21).setType("click");  
//    	        ((CommonButton) btn21).setKey("21");	
//    		}  
//    		buttonList2.add(btn21);
//    	}    	
//    	  
//    	if(weiXinMenuPo.getWmcflag22().equals("1")){
//    		if(weiXinMenuPo.getWmctypeid22().equals("1")){
//    			btn22 = new ViewButton();
//    	        btn22.setName(weiXinMenuPo.getWmcname22());  
//    	        ((ViewButton) btn22).setType("view");  
//    	        ((ViewButton) btn22).setUrl(weiXinMenuPo.getWmccontent22()); 
//    		}else if(weiXinMenuPo.getWmctypeid22().equals("2")){
//    			btn22 = new ViewButton();
//    	        btn22.setName(weiXinMenuPo.getWmcname22());  
//    	        ((ViewButton) btn22).setType("view");  
//    	        ((ViewButton) btn22).setUrl(url+"/initUserCmsContentDetails.action?hid=" + weiXinMenuPo.getWmccontent22()); 
//    		}else{
//    			btn22 = new CommonButton();
//    	        btn22.setName(weiXinMenuPo.getWmcname22());  
//    	        ((CommonButton) btn22).setType("click");  
//    	        ((CommonButton) btn22).setKey("22");	
//    		}   	
//    		buttonList2.add(btn22);
//    	}    	
//    	  
//    	if(weiXinMenuPo.getWmcflag23().equals("1")){
//    		if(weiXinMenuPo.getWmctypeid23().equals("1")){
//    			btn23 = new ViewButton();
//    	        btn23.setName(weiXinMenuPo.getWmcname23());  
//    	        ((ViewButton) btn23).setType("view");  
//    	        ((ViewButton) btn23).setUrl(weiXinMenuPo.getWmccontent23()); 
//    		}else if(weiXinMenuPo.getWmctypeid23().equals("2")){
//    			btn23 = new ViewButton();
//    	        btn23.setName(weiXinMenuPo.getWmcname23());  
//    	        ((ViewButton) btn23).setType("view");  
//    	        ((ViewButton) btn23).setUrl(url+"/initUserCmsContentDetails.action?hid=" + weiXinMenuPo.getWmccontent23());    			
//    		}else{
//    			btn23 = new CommonButton();
//    	        btn23.setName(weiXinMenuPo.getWmcname23());  
//    	        ((CommonButton) btn23).setType("click");  
//    	        ((CommonButton) btn23).setKey("23");	
//    		}   		
//    		buttonList2.add(btn23);
//    	}    	
//    	  
//    	if(weiXinMenuPo.getWmcflag24().equals("1")){
//    		if(weiXinMenuPo.getWmctypeid24().equals("1")){
//    			btn24 = new ViewButton();
//    	        btn24.setName(weiXinMenuPo.getWmcname24());  
//    	        ((ViewButton) btn24).setType("view");  
//    	        ((ViewButton) btn24).setUrl(weiXinMenuPo.getWmccontent24()); 
//    		}else if(weiXinMenuPo.getWmctypeid24().equals("2")){
//    			btn24 = new ViewButton();
//    	        btn24.setName(weiXinMenuPo.getWmcname24());  
//    	        ((ViewButton) btn24).setType("view");  
//    	        ((ViewButton) btn24).setUrl(url+"/initUserCmsContentDetails.action?hid=" + weiXinMenuPo.getWmccontent24());		
//    		}else{
//    			btn24 = new CommonButton();
//    	        btn24.setName(weiXinMenuPo.getWmcname24());  
//    	        ((CommonButton) btn24).setType("click");  
//    	        ((CommonButton) btn24).setKey("24");	
//    		}    		
//    		buttonList2.add(btn24);
//    	}  
//    	  
//    	if(weiXinMenuPo.getWmcflag25().equals("1")){
//    		if(weiXinMenuPo.getWmctypeid25().equals("1")){
//    			btn25 = new ViewButton();
//    	        btn25.setName(weiXinMenuPo.getWmcname25());  
//    	        ((ViewButton) btn25).setType("view");  
//    	        ((ViewButton) btn25).setUrl(weiXinMenuPo.getWmccontent25()); 
//    		}else if(weiXinMenuPo.getWmctypeid25().equals("2")){
//    			btn25 = new ViewButton();
//    	        btn25.setName(weiXinMenuPo.getWmcname25());  
//    	        ((ViewButton) btn25).setType("view");  
//    	        ((ViewButton) btn25).setUrl(url+"/initUserCmsContentDetails.action?hid=" + weiXinMenuPo.getWmccontent25());   			
//    		}else{
//    			btn25 = new CommonButton();
//    	        btn25.setName(weiXinMenuPo.getWmcname25());  
//    	        ((CommonButton) btn25).setType("click");  
//    	        ((CommonButton) btn25).setKey("25");	
//    		}    		
//    		buttonList2.add(btn25);
//    	}  
//    	  
//    	if(weiXinMenuPo.getWmcflag31().equals("1")){
//    		if(weiXinMenuPo.getWmctypeid31().equals("1")){
//    			btn31 = new ViewButton();
//    	        btn31.setName(weiXinMenuPo.getWmcname31());  
//    	        ((ViewButton) btn31).setType("view");  
//    	        ((ViewButton) btn31).setUrl(weiXinMenuPo.getWmccontent31()); 
//    		}else if(weiXinMenuPo.getWmctypeid31().equals("2")){
//    			btn31 = new ViewButton();
//    	        btn31.setName(weiXinMenuPo.getWmcname31());  
//    	        ((ViewButton) btn31).setType("view");  
//    	        ((ViewButton) btn31).setUrl(url+"/initUserCmsContentDetails.action?hid=" + weiXinMenuPo.getWmccontent31());    			
//    		}else{
//    			btn31 = new CommonButton();
//    	        btn31.setName(weiXinMenuPo.getWmcname31());  
//    	        ((CommonButton) btn31).setType("click");  
//    	        ((CommonButton) btn31).setKey("31");	
//    		}   
//    		buttonList3.add(btn31);
//    	} 
//    	  
//    	if(weiXinMenuPo.getWmcflag32().equals("1")){
//    		if(weiXinMenuPo.getWmctypeid32().equals("1")){
//    			btn32 = new ViewButton();
//    	        btn32.setName(weiXinMenuPo.getWmcname32());  
//    	        ((ViewButton) btn32).setType("view");  
//    	        ((ViewButton) btn32).setUrl(weiXinMenuPo.getWmccontent32()); 
//    		}else if(weiXinMenuPo.getWmctypeid32().equals("2")){
//    			btn32 = new ViewButton();
//    	        btn32.setName(weiXinMenuPo.getWmcname32());  
//    	        ((ViewButton) btn32).setType("view");  
//    	        ((ViewButton) btn32).setUrl(url+"/initUserCmsContentDetails.action?hid=" + weiXinMenuPo.getWmccontent32());    			
//    		}else{
//    			btn32 = new CommonButton();
//    	        btn32.setName(weiXinMenuPo.getWmcname32());  
//    	        ((CommonButton) btn32).setType("click");  
//    	        ((CommonButton) btn32).setKey("32");	
//    		}    	
//    		buttonList3.add(btn32);
//    	}  
//    	  
//    	if(weiXinMenuPo.getWmcflag33().equals("1")){
//    		if(weiXinMenuPo.getWmctypeid33().equals("1")){
//    			btn33 = new ViewButton();
//    	        btn33.setName(weiXinMenuPo.getWmcname33());  
//    	        ((ViewButton) btn33).setType("view");  
//    	        ((ViewButton) btn33).setUrl(weiXinMenuPo.getWmccontent33()); 
//    		}else if(weiXinMenuPo.getWmctypeid33().equals("2")){
//    			btn33 = new ViewButton();
//    	        btn33.setName(weiXinMenuPo.getWmcname33());  
//    	        ((ViewButton) btn33).setType("view");  
//    	        ((ViewButton) btn33).setUrl(url+"/initUserCmsContentDetails.action?hid=" + weiXinMenuPo.getWmccontent33());     			
//    		}else{
//    			btn33 = new CommonButton();
//    	        btn33.setName(weiXinMenuPo.getWmcname33());  
//    	        ((CommonButton) btn33).setType("click");  
//    	        ((CommonButton) btn33).setKey("33");	
//    		}   
//    		buttonList3.add(btn33);
//    	}    
//    	  
//    	if(weiXinMenuPo.getWmcflag34().equals("1")){
//    		if(weiXinMenuPo.getWmctypeid34().equals("1")){
//    			btn34 = new ViewButton();
//    	        btn34.setName(weiXinMenuPo.getWmcname34());  
//    	        ((ViewButton) btn34).setType("view");  
//    	        ((ViewButton) btn34).setUrl(weiXinMenuPo.getWmccontent34()); 
//    		}else if(weiXinMenuPo.getWmctypeid34().equals("2")){
//    			btn34 = new ViewButton();
//    	        btn34.setName(weiXinMenuPo.getWmcname34());  
//    	        ((ViewButton) btn34).setType("view");  
//    	        ((ViewButton) btn34).setUrl(url+"/initUserCmsContentDetails.action?hid=" + weiXinMenuPo.getWmccontent34());    			
//    		}else{
//    			btn34 = new CommonButton();
//    	        btn34.setName(weiXinMenuPo.getWmcname34());  
//    	        ((CommonButton) btn34).setType("click");  
//    	        ((CommonButton) btn34).setKey("34");	
//    		}    	
//    		buttonList3.add(btn34);
//    	} 
//    	  
//    	if(weiXinMenuPo.getWmcflag35().equals("1")){
//    		if(weiXinMenuPo.getWmctypeid35().equals("1")){
//    			btn35 = new ViewButton();
//    	        btn35.setName(weiXinMenuPo.getWmcname35());  
//    	        ((ViewButton) btn35).setType("view");  
//    	        ((ViewButton) btn35).setUrl(weiXinMenuPo.getWmccontent35()); 
//    		}else if(weiXinMenuPo.getWmctypeid35().equals("2")){
//    			btn35 = new ViewButton();
//    	        btn35.setName(weiXinMenuPo.getWmcname35());  
//    	        ((ViewButton) btn35).setType("view");  
//    	        ((ViewButton) btn35).setUrl(url+"/initUserCmsContentDetails.action?hid=" + weiXinMenuPo.getWmccontent35());     			
//    		}else{
//    			btn35 = new CommonButton();
//    	        btn35.setName(weiXinMenuPo.getWmcname35());  
//    	        ((CommonButton) btn35).setType("click");  
//    	        ((CommonButton) btn35).setKey("35");	
//    		}   
//    		buttonList3.add(btn35);
//    	}    	
   
    	Button[] b1 = new Button[buttonList1.size()] ;
    	for(int i=0;i<buttonList1.size();i++){
    		b1[i] = (Button)buttonList1.get(i);
    	}
    	
    	Button[] b2 = new Button[buttonList2.size()] ;
    	for(int i=0;i<buttonList2.size();i++){
    		b2[i] = (Button)buttonList2.get(i);
    	}
    	
    	Button[] b3 = new Button[buttonList3.size()] ;
    	for(int i=0;i<buttonList3.size();i++){
    		b3[i] = (Button)buttonList3.get(i);
    	}
    	
    	int i = 0;
    	List<ButtonType> list = new ArrayList<ButtonType>();
    	
    	ButtonType buttonType1 = new ButtonType();
    	if(weiXinMenuPo.getWmcflag1().equals("1")){
            mainBtn1.setName(weiXinMenuPo.getWmcname1()); 
            mainBtn1.setSub_button(b1);
            i++;
            
            buttonType1.setTypeid("1");
            buttonType1.setButtonobj(mainBtn1);
            list.add(buttonType1);
    	}else if(weiXinMenuPo.getWmcflag1().equals("2")){
    		Button btn1= new Button();
    		btn1 = addButtonToButton(toUserName,appId,weiXinMenuPo.getWmcflag1(),weiXinMenuPo.getWmctypeid1(),weiXinMenuPo.getWmcname1(),weiXinMenuPo.getWmccontent1(),"1",url,btn1);
    		
            i++;
            buttonType1.setTypeid("2");
            buttonType1.setButtonobj(btn1);
            list.add(buttonType1);
    	} 
    	
    	ButtonType buttonType2 = new ButtonType();
    	if(weiXinMenuPo.getWmcflag2().equals("1")){
            mainBtn2.setName(weiXinMenuPo.getWmcname2());  
            mainBtn2.setSub_button(b2);    
            i++;
            
            buttonType2.setTypeid("1");
            buttonType2.setButtonobj(mainBtn2);
            list.add(buttonType2);
    	}else if(weiXinMenuPo.getWmcflag2().equals("2")){
    		Button btn2 = new Button();
    		btn2 = addButtonToButton(toUserName,appId,weiXinMenuPo.getWmcflag2(),weiXinMenuPo.getWmctypeid2(),weiXinMenuPo.getWmcname2(),weiXinMenuPo.getWmccontent2(),"2",url,btn2);
            i++;

            buttonType2.setTypeid("2");
            buttonType2.setButtonobj(btn2);
            list.add(buttonType2);
    	} 

        ButtonType buttonType3 = new ButtonType();
    	if(weiXinMenuPo.getWmcflag3().equals("1")){
            mainBtn3.setName(weiXinMenuPo.getWmcname3());  
            mainBtn3.setSub_button(b3);   
            i++;

            buttonType3.setTypeid("1");
            buttonType3.setButtonobj(mainBtn3);
            list.add(buttonType3);
    	}else if(weiXinMenuPo.getWmcflag3().equals("2")){
    		Button btn3 = new Button();
    		btn3 = addButtonToButton(toUserName,appId,weiXinMenuPo.getWmcflag3(),weiXinMenuPo.getWmctypeid3(),weiXinMenuPo.getWmcname3(),weiXinMenuPo.getWmccontent3(),"3",url,btn3);
            i++;
            buttonType3.setTypeid("2");
            buttonType3.setButtonobj(btn3);
            list.add(buttonType3);
    	}      	
  
    	Button[] button = new Button[i];
    	Iterator it = list.iterator(); 
    	int j = 0;
    	while (it.hasNext()) {  
    		ButtonType bt = new ButtonType();
    		bt = (ButtonType)it.next();
    		button[j] = bt.getButtonobj(); 
    	    j++;
    	}  

//    	if(weiXinMenuPo.getWmcflag1().equals("1")){
//            mainBtn1.setName(weiXinMenuPo.getWmcname1()); 
//            mainBtn1.setSub_button(b1);
//            button[0] = mainBtn1;
//    	} 
//    	if(weiXinMenuPo.getWmcflag2().equals("1")){
//            mainBtn2.setName(weiXinMenuPo.getWmcname2());  
//            mainBtn2.setSub_button(b2);    
//            button[1] = mainBtn2;
//    	}   
//    	if(weiXinMenuPo.getWmcflag3().equals("1")){
//            mainBtn3.setName(weiXinMenuPo.getWmcname3());  
//            mainBtn3.setSub_button(b3);   
//            button[2] = mainBtn3;
//    	} 
    	
        /** 
         * 这是公众号xiaoqrobot目前的菜单结构，每个一级菜单都有二级菜单项<br> 
         *  
         * 在某个一级菜单下没有二级菜单的情况，menu该如何定义呢？<br> 
         * 比如，第三个一级菜单项不是“更多体验”，而直接是“幽默笑话”，那么menu应该这样定义：<br> 
         * menu.setButton(new Button[] { mainBtn1, mainBtn2, btn33 }); 
         */  
        Menu menu = new Menu(); 
        
        
//        menu.setButton(new Button[] { mainBtn1, mainBtn2, mainBtn3 });
        menu.setButton(button);
  
        return menu;  
    }  
    
    /**
     * 
     * @param toUserName	生成菜单对应的微信号原始ID；
     * @param appId			生成菜单对应的微信号appId；
     * @param flag			启用隐藏菜单；1：启用；
     * @param typeID		链接类型ID；	
     * @param name			菜单名称；
     * @param content		内容；外部网址为带Http的url；内部文章为以逗号连接的文章id字符串；
     * @param key			菜单的ID;
     * @param serverUrl		服务器的URL；
     * @param buttonObj		当前的Button对象；
     * @param buttonList	当前的ButtonList对象；
     * @return buttonList 	返回装入Button对象的List;
     */
    public static List<Button> addButtonToButtonList(String toUserName,String appId,String flag,String typeID,String name,String content,String key,String serverUrl, Button buttonObj,List<Button> buttonList){
    	if(flag.equals("1")){
    		
			String weburl_result = "";
			String weburl_title="https://open.weixin.qq.com/connect/oauth2/authorize?appid="+ appId +"&redirect_uri=";
			String weburl_end="&response_type=code&scope=snsapi_base&state=1#wechat_redirect";
			
			String weburl0="";
			String weburl1="";
			if(!content.equals("")){
				weburl0=content.substring(0, 1);
				weburl1=content.substring(5, content.length());	
			}			
			
    		if(typeID.equals("1")){
    				
				try {
					if(weburl0.equals("2")){
						weburl1 = weburl1.replace("WEIXIN_TOUSERNAME", toUserName);
						weburl1 = URLEncoder.encode(weburl1,"utf-8");
						weburl_result = weburl_title + weburl1 + weburl_end;
					}else{
						weburl_result = weburl1;
					}
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}				
    			
//				System.out.println(weburl_result);
				
    			buttonObj = new ViewButton();
    			buttonObj.setName(name);  
    	        ((ViewButton) buttonObj).setType("view");  
    	        ((ViewButton) buttonObj).setUrl(weburl_result); 
    		}else if(typeID.equals("2")){
    			buttonObj = new ViewButton();
    			buttonObj.setName(name);  
    	        ((ViewButton) buttonObj).setType("view");  
    	        ((ViewButton) buttonObj).setUrl(serverUrl+"/initUserCmsContentDetails.action?hid=" + weburl1); 
    		}else if(typeID.equals("4")){
    			buttonObj = new ViewButton();
    			buttonObj.setName(name);  
    	        ((ViewButton) buttonObj).setType("view");  
    	        ((ViewButton) buttonObj).setUrl(serverUrl+"/initUserCmsContentList.action?type=" + weburl1); 
    		}else{
    			buttonObj = new CommonButton();
    			buttonObj.setName(name);  
    	        ((CommonButton) buttonObj).setType("click");  
    	        ((CommonButton) buttonObj).setKey(key);	
    		} 
    		buttonList.add(buttonObj);
    	}
    	return buttonList;
    }
    
    /**
     * 
     * @param toUserName	生成菜单对应的微信号原始ID；
     * @param appId			生成菜单对应的微信号appId；
     * @param flag			启用隐藏菜单；1：启用；
     * @param typeID		链接类型ID；	
     * @param name			菜单名称；
     * @param content		内容；外部网址为带Http的url；内部文章为以逗号连接的文章id字符串；
     * @param key			菜单的ID;
     * @param serverUrl		服务器的URL；
     * @param buttonObj		当前的Button对象；
     * @param buttonList	当前的ButtonList对象；
     * @return buttonList 	返回装入Button对象的List;
     */
    public static Button addButtonToButton(String toUserName,String appId,String flag,String typeID,String name,String content,String key,String serverUrl, Button buttonObj){
		String weburl_result = "";
		String weburl_title="https://open.weixin.qq.com/connect/oauth2/authorize?appid="+ appId +"&redirect_uri=";
		String weburl_end="&response_type=code&scope=snsapi_base&state=1#wechat_redirect";
		String weburl0=content.substring(0, 1);
		String weburl1=content.substring(5, content.length());
		
    	if(typeID.equals("1")){
    			
				try {
					if(weburl0.equals("2")){
						weburl1 = weburl1.replace("WEIXIN_TOUSERNAME", toUserName);
						weburl1 = URLEncoder.encode(weburl1,"utf-8");
						weburl_result = weburl_title + weburl1 + weburl_end;
					}else{
						weburl_result = weburl1;
					}
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}				
    			
//				System.out.println(weburl_result);
				
    			buttonObj = new ViewButton();
    			buttonObj.setName(name);  
    	        ((ViewButton) buttonObj).setType("view");  
    	        ((ViewButton) buttonObj).setUrl(weburl_result); 
    		}else if(typeID.equals("2")){
    			buttonObj = new ViewButton();
    			buttonObj.setName(name);  
    	        ((ViewButton) buttonObj).setType("view");  
    	        ((ViewButton) buttonObj).setUrl(serverUrl+"/initUserCmsContentDetails.action?hid=" + weburl1); 
    		}else if(typeID.equals("4")){
    			buttonObj = new ViewButton();
    			buttonObj.setName(name);  
    	        ((ViewButton) buttonObj).setType("view");  
    	        ((ViewButton) buttonObj).setUrl(serverUrl+"/initUserCmsContentList.action?type=" + weburl1); 
    		}else{
    			buttonObj = new CommonButton();
    			buttonObj.setName(name);  
    	        ((CommonButton) buttonObj).setType("click");  
    	        ((CommonButton) buttonObj).setKey(key);	
    		} 

    	return buttonObj;
    }
}
