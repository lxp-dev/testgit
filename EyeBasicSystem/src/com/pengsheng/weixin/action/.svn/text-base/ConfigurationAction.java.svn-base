package com.pengsheng.weixin.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.weixin.mgr.ConfigurationMgr;
import com.pengsheng.weixin.mgr.WeiXinCmsContentMgr;
import com.pengsheng.weixin.mgr.WeiXinCmsTypeMgr;
import com.pengsheng.weixin.mgr.WeiXinMenuConfigMgr;
import com.pengsheng.weixin.mgr.WeiXinRegisterDepartmentMgr;
import com.pengsheng.weixin.persistence.ConfigurationPo;
import com.pengsheng.weixin.persistence.WeiXinCmsTypePo;
import com.pengsheng.weixin.persistence.WeiXinMenuPo;
import com.pengsheng.weixin.persistence.WeiXinMenuTypePo;
import com.pengsheng.weixin.persistence.WeiXinRegisterDepartmentPo;
import com.pengsheng.weixin.service.CreateMenu;
import com.pengsheng.weixin.service.PastUtil;

public class ConfigurationAction extends BaseAction {
	private PersonPermissionMgr personPermissionMgr;
	private ConfigurationMgr configurationMgr;
	private WeiXinMenuConfigMgr weiXinMenuConfigMgr;
	private WeiXinCmsContentMgr weiXinCmsContentMgr;
	private WeiXinCmsTypeMgr weiXinCmsTypeMgr;
	private WeiXinMenuPo weiXinMenuPo;
	private List<WeiXinMenuTypePo> weiXinMenuTypeList;
	private ConfigurationPo configurationPo;
	private WeiXinRegisterDepartmentMgr weiXinRegisterDepartmentMgr;
	
	private String jsonResult;
	

	/**
	 * 通过Ajax返回客服系统用的哪种
	 */
	public String getDuokefuTypeAjax(){
		configurationPo = configurationMgr.getConfigurationDetail();
		return SUCCESS;
	}
	
	/**
	 * 初始化配置管理
	 */
	public String initWeiXinConfigurationSel() {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		configurationPo = configurationMgr.getConfigurationDetail();
		return SUCCESS;
	}
	
	/**
	 * 新增配置管理
	 */
	public String insertWeiXinConfiguration() {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent("微信配置信息已修改成功!");	
		
		configurationMgr.insertConfigurationInfo(configurationPo, logPo);
		
		configurationPo = configurationMgr.getConfigurationDetail();
		
		request.setAttribute("url", "'initWeiXinConfigurationSel.action?moduleID="+moduleID+"'");
		this.clearMessages();
		this.addActionMessage("配置成功！");
		request.setAttribute("flag", GlobalConstants.MOVE);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化微信菜单配置
	 */
	public String initConfigWeixinMenu() {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		weiXinMenuPo = weiXinMenuConfigMgr.getWeiXinMenuPo();
		weiXinMenuTypeList = weiXinMenuConfigMgr.getWeiXinMenuTypeList();
		
		List<WeiXinRegisterDepartmentPo> registerDepartmentList = new ArrayList();
		registerDepartmentList = weiXinRegisterDepartmentMgr.selectWeiXinRegisterDepartments();
		
		request.setAttribute("registerDepartmentList", registerDepartmentList);
		return SUCCESS;
	}

	/**
	 * 微信菜单配置保存数据
	 */
	public String insertConfigWeixinMenu() {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent("微信菜单配置成功!");	
		
		weiXinMenuConfigMgr.insertWeiXinMenuPo(weiXinMenuPo, logPo);
		weiXinMenuTypeList = weiXinMenuConfigMgr.getWeiXinMenuTypeList();
		
		request.setAttribute("url", "'initConfigWeixinMenu.action?moduleID="+moduleID+"'");
		this.clearMessages();
		this.addActionMessage("微信菜单配置成功！");
		request.setAttribute("flag", GlobalConstants.MOVE);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化微信菜单参数配置
	 */
	public String initConfigWeixinMenuDetail() {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		String menuID = request.getParameter("menuID");
		
		weiXinMenuPo = weiXinMenuConfigMgr.getWeiXinMenuPo();
		weiXinMenuTypeList = weiXinMenuConfigMgr.getWeiXinMenuTypeList();
		
		if(weiXinMenuPo.getWmcid1()==null || weiXinMenuPo.getWmcid1().equals("")){
			this.clearMessages();
			this.addActionMessage("请先填写菜单名称，保存后再配置对应参数！");
			request.setAttribute("flag", "openUpdate2");
			return "error";
		}
		
		String menuName = getWeixinMenuConfigName(weiXinMenuPo,menuID);
		String menuType = getWeixinMenuConfigTypeid(weiXinMenuPo,menuID);
		String weburl = getWeixinMenuConfigContent(weiXinMenuPo,menuID);
		String weburlName = "";
		
		if(menuType.equals("4")){//指定单一文章类型
			WeiXinCmsTypePo tmp1 = new WeiXinCmsTypePo();
			tmp1.setWcmstid(weburl);
			weburlName = weiXinCmsTypeMgr.getWeiXinCmsTypePo(tmp1).getWcmstname();
		}else if(menuType.equals("2")||menuType.equals("3")||menuType.equals("14")){//内部文章
			weburlName = weiXinCmsContentMgr.getWeiXinCmsContentTitles(getWeixinMenuConfigContent(weiXinMenuPo,menuID));
		}
		
		configurationPo = configurationMgr.getConfigurationDetail();
		
		request.setAttribute("eims_url", configurationPo.getWcrurl());
		request.setAttribute("menuName", getWeixinMenuConfigName(weiXinMenuPo,menuID));
		request.setAttribute("menuType", getWeixinMenuConfigTypeid(weiXinMenuPo,menuID));
		request.setAttribute("weburl", getWeixinMenuConfigContent(weiXinMenuPo,menuID));
		
		request.setAttribute("weburlName", weburlName);
		request.setAttribute("menuID", menuID);
		
		return SUCCESS;
	}
		
	/**
	 * 微信菜单配置保存数据
	 */
	public String insertConfigWeixinMenuDetail() {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		String menuID = request.getParameter("menuID");
		String menuTypeid = request.getParameter("menuTypeid");
		String weburl = Utility.getName(request.getParameter("weburl"));
		String webtype = Utility.getName(request.getParameter("webtype"));  
		String webtypename = Utility.getName(request.getParameter("webtypename"));  
		if(webtype.equals("2")){
			if(webtypename.equals("个人中心")){
				weburl = "2|01|"+weburl;
			}else if(webtypename.equals("专家团队")){
				weburl = "2|02|"+weburl;
			}else if(webtypename.equals("附近门店(左右结构)")){
				weburl = "2|03|"+weburl;
			}else if(webtypename.equals("我的预约")){
				weburl = "2|04|"+weburl;
			}
			else if(webtypename.equals("附近门店(上下结构)")){
				weburl = "2|05|"+weburl;
			}
		}else{
			weburl = "1|00|"+weburl;
		}
		
//		String[] contentStr = weburl.split("redirect_uri=");
//		if(contentStr.length>1){
//			String tmp=contentStr[1];
//			
//			tmp = tmp.substring(0,tmp.length()-65);
//			try {
//				weburl = contentStr[0] + "redirect_uri=" + URLEncoder.encode(tmp,"utf-8") +"&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect" ;
//			} catch (UnsupportedEncodingException e) {
//				e.printStackTrace();
//			}				
//		}
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent("微信菜单参数配置成功!");	
		
		weiXinMenuConfigMgr.updateWeiXinMenuDetail(menuID,menuTypeid ,weburl,logPo);
		
		this.clearMessages();
		this.addActionMessage("微信菜单参数配置成功！");
		request.setAttribute("flag", "openUpdate");
		
		return SUCCESS;
	}

	/**
	 * 查看微信菜单效果
	 */
	public String initViewWeixinMenu() {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		configurationPo = configurationMgr.getConfigurationDetail();
		weiXinMenuPo = weiXinMenuConfigMgr.getWeiXinMenuPo();
		
		return SUCCESS;
	}
	
	//生成菜单
	public void GenerationMenuManager() throws IOException{
		PrintWriter out;
		String weiXinID = Utility.getName(request.getParameter("weiXinID"));
		
		WeiXinRegisterDepartmentPo weiXinRegisterDepartmentPo = new WeiXinRegisterDepartmentPo();
		weiXinRegisterDepartmentPo.setWrdid(weiXinID);		
		weiXinRegisterDepartmentPo = weiXinRegisterDepartmentMgr.getWeiXinRegisterDepartmentPo(weiXinRegisterDepartmentPo);
		
		weiXinMenuPo = weiXinMenuConfigMgr.getWeiXinMenuPo();
		configurationPo = configurationMgr.getConfigurationDetail();  
		int resultInt = CreateMenu.generationmenumanager(weiXinMenuPo,configurationPo,weiXinRegisterDepartmentPo);
		
		response.setCharacterEncoding("utf-8"); 
		out = ServletActionContext.getResponse().getWriter();
			if(resultInt == 0){
				out.print("生成成功!");
			}else{
				out.print("生成失败：【ErrorCode = "+ resultInt+"】\n失败原因：【"+configurationMgr.getCreateMenuReturnTitle(resultInt+"").getWmttitle()+"】");
			}
		out.close();
	}
	
	public String getWeixinMenuConfigContent(WeiXinMenuPo weiXinMenuPo,String eventKey){
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
		}else if(eventKey.equals("1")){
			return weiXinMenuPo.getWmccontent1();
		}else if(eventKey.equals("2")){
			return weiXinMenuPo.getWmccontent2();
		}else if(eventKey.equals("3")){
			return weiXinMenuPo.getWmccontent3();
		}else{
			return "";
		}		
	}
	
	public String getWeixinMenuConfigTypeid(WeiXinMenuPo weiXinMenuPo,String eventKey){
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
		}else if(eventKey.equals("1")){
			return weiXinMenuPo.getWmctypeid1();
		}else if(eventKey.equals("2")){
			return weiXinMenuPo.getWmctypeid2();
		}else if(eventKey.equals("3")){
			return weiXinMenuPo.getWmctypeid3();
		}else{
			return "";
		}		
	}
	
	public String getWeixinMenuConfigName(WeiXinMenuPo weiXinMenuPo,String eventKey){
		if(eventKey.equals("11")){
			return weiXinMenuPo.getWmcname11();
		}else if(eventKey.equals("12")){
			return weiXinMenuPo.getWmcname12();
		}else if(eventKey.equals("13")){
			return weiXinMenuPo.getWmcname13();
		}else if(eventKey.equals("14")){
			return weiXinMenuPo.getWmcname14();
		}else if(eventKey.equals("15")){
			return weiXinMenuPo.getWmcname15();
		}else if(eventKey.equals("21")){
			return weiXinMenuPo.getWmcname21();
		}else if(eventKey.equals("22")){
			return weiXinMenuPo.getWmcname22();
		}else if(eventKey.equals("23")){
			return weiXinMenuPo.getWmcname23();
		}else if(eventKey.equals("24")){
			return weiXinMenuPo.getWmcname24();
		}else if(eventKey.equals("25")){
			return weiXinMenuPo.getWmcname25();
		}else if(eventKey.equals("31")){
			return weiXinMenuPo.getWmcname31();
		}else if(eventKey.equals("32")){
			return weiXinMenuPo.getWmcname32();
		}else if(eventKey.equals("33")){
			return weiXinMenuPo.getWmcname33();
		}else if(eventKey.equals("34")){
			return weiXinMenuPo.getWmcname34();
		}else if(eventKey.equals("35")){
			return weiXinMenuPo.getWmcname35();
		}else if(eventKey.equals("1")){
			return weiXinMenuPo.getWmcname1();
		}else if(eventKey.equals("2")){
			return weiXinMenuPo.getWmcname2();
		}else if(eventKey.equals("3")){
			return weiXinMenuPo.getWmcname3();
		}else{
			return "";
		}		
	}
	 
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public ConfigurationMgr getConfigurationMgr() {
		return configurationMgr;
	}

	public void setConfigurationMgr(ConfigurationMgr configurationMgr) {
		this.configurationMgr = configurationMgr;
	}

	public ConfigurationPo getConfigurationPo() {
		return configurationPo;
	}

	public void setConfigurationPo(ConfigurationPo configurationPo) {
		this.configurationPo = configurationPo;
	}

	public WeiXinMenuConfigMgr getWeiXinMenuConfigMgr() {
		return weiXinMenuConfigMgr;
	}

	public void setWeiXinMenuConfigMgr(WeiXinMenuConfigMgr weiXinMenuConfigMgr) {
		this.weiXinMenuConfigMgr = weiXinMenuConfigMgr;
	}

	public WeiXinMenuPo getWeiXinMenuPo() {
		return weiXinMenuPo;
	}

	public void setWeiXinMenuPo(WeiXinMenuPo weiXinMenuPo) {
		this.weiXinMenuPo = weiXinMenuPo;
	}

	public List<WeiXinMenuTypePo> getWeiXinMenuTypeList() {
		return weiXinMenuTypeList;
	}

	public void setWeiXinMenuTypeList(List<WeiXinMenuTypePo> weiXinMenuTypeList) {
		this.weiXinMenuTypeList = weiXinMenuTypeList;
	}

	public WeiXinCmsContentMgr getWeiXinCmsContentMgr() {
		return weiXinCmsContentMgr;
	}

	public void setWeiXinCmsContentMgr(WeiXinCmsContentMgr weiXinCmsContentMgr) {
		this.weiXinCmsContentMgr = weiXinCmsContentMgr;
	}

	public WeiXinCmsTypeMgr getWeiXinCmsTypeMgr() {
		return weiXinCmsTypeMgr;
	}

	public void setWeiXinCmsTypeMgr(WeiXinCmsTypeMgr weiXinCmsTypeMgr) {
		this.weiXinCmsTypeMgr = weiXinCmsTypeMgr;
	}

	public WeiXinRegisterDepartmentMgr getWeiXinRegisterDepartmentMgr() {
		return weiXinRegisterDepartmentMgr;
	}

	public void setWeiXinRegisterDepartmentMgr(
			WeiXinRegisterDepartmentMgr weiXinRegisterDepartmentMgr) {
		this.weiXinRegisterDepartmentMgr = weiXinRegisterDepartmentMgr;
	}

	public String getJsonResult() {
		return jsonResult;
	}

	public void setJsonResult(String jsonResult) {
		this.jsonResult = jsonResult;
	}
}
