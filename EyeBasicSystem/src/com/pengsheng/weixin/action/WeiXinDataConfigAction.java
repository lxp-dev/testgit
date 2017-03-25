package com.pengsheng.weixin.action;

import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.weixin.mgr.ConfigurationMgr;
import com.pengsheng.weixin.mgr.WeiXinDataConfigMgr;
import com.pengsheng.weixin.persistence.WeiXinDataConfigPo;

public class WeiXinDataConfigAction extends BaseAction {

	private PersonPermissionMgr personPermissionMgr;
	private ConfigurationMgr configurationMgr;
	private WeiXinDataConfigMgr weiXinDataConfigMgr;
	private WeiXinDataConfigPo weiXinDataConfigPo;
	
	/**
	 * 初始化微信数据配置
	 */
	public String initWeixinDataConfigSel() throws Exception {
				
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
				
		weiXinDataConfigPo = weiXinDataConfigMgr.getWeiXinDataConfigPo();
		
		return SUCCESS;
	}
	
	/**
	 * 保存微信数据配置
	 */
	public String insertWeixinDataConfig() {
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
		
		if (!Utility.getName(weiXinDataConfigPo.getWdcdepartmentpicurl()).equals("")) {
			weiXinDataConfigPo.setWdcdepartmentpicurl(weiXinDataConfigPo.getWdcdepartmentpicurl().replaceAll(
					",", ""));
		}
		if (!Utility.getName(weiXinDataConfigPo.getWdccmslargepicurl()).equals("")) {
			weiXinDataConfigPo.setWdccmslargepicurl(weiXinDataConfigPo.getWdccmslargepicurl().replaceAll(
					",", ""));
		}
		if (!Utility.getName(weiXinDataConfigPo.getWdccmssmallpicurl()).equals("")) {
			weiXinDataConfigPo.setWdccmssmallpicurl(weiXinDataConfigPo.getWdccmssmallpicurl().replaceAll(
					",", ""));
		}
		if (!Utility.getName(weiXinDataConfigPo.getWdcpersoncenterpicurl()).equals("")) {
			weiXinDataConfigPo.setWdcpersoncenterpicurl(weiXinDataConfigPo.getWdcpersoncenterpicurl().replaceAll(
					",", ""));
		}		
		weiXinDataConfigMgr.insertWeiXinDataConfigPo(weiXinDataConfigPo);
		
		weiXinDataConfigPo = weiXinDataConfigMgr.getWeiXinDataConfigPo();
		
		this.clearMessages();
		this.addActionMessage("配置成功！");
		
		return SUCCESS;
	}
	
	public ConfigurationMgr getConfigurationMgr() {
		return configurationMgr;
	}

	public void setConfigurationMgr(ConfigurationMgr configurationMgr) {
		this.configurationMgr = configurationMgr;
	}

	public WeiXinDataConfigMgr getWeiXinDataConfigMgr() {
		return weiXinDataConfigMgr;
	}

	public void setWeiXinDataConfigMgr(WeiXinDataConfigMgr weiXinDataConfigMgr) {
		this.weiXinDataConfigMgr = weiXinDataConfigMgr;
	}

	public WeiXinDataConfigPo getWeiXinDataConfigPo() {
		return weiXinDataConfigPo;
	}

	public void setWeiXinDataConfigPo(WeiXinDataConfigPo weiXinDataConfigPo) {
		this.weiXinDataConfigPo = weiXinDataConfigPo;
	}

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

}
