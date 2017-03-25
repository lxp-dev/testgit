package com.pengsheng.eims.basic.action;

import java.io.File;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.pengsheng.eims.basic.mgr.FittingTemplateTypeMgr;
import com.pengsheng.eims.basic.persistence.FittingTemplateTypePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.ModulePo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class FittingTemplateTypeAction extends BaseAction {

	private FittingTemplateTypeMgr fittingTemplateTypeMgr = null;
	private SystemParameterMgr systemParameterMgr = null;
	private SystemParameterPo systemParameterPo = null;
	private PersonPermissionMgr personPermissionMgr = null;
	private List<FittingTemplateTypePo> fittingTemplateTypeList = null;
	private FittingTemplateTypePo fittingTemplateTypePo = null;
	private String actionTypeID;
	private String actionImgUrl;
	private String actionFinereportRequestString;
	private String actionReportingServiceRequestString;
	private String actionReportTitle;

	/**
	 *  初始化打印单据模板查询
	 */
	public String initFittingTemplateTypeSel() throws Exception{
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
		
		fittingTemplateTypeList = fittingTemplateTypeMgr.getFittingTemplateTypeList(null);
		
		return SUCCESS;
	}
	
	/**
	 * 获取当前类型对应的模版
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getFittingTemplateTypeInfo() throws Exception {
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		
		fittingTemplateTypePo = fittingTemplateTypeMgr.getFittingTemplateTypePo(actionTypeID);
		return SUCCESS;
	}
	
	/**
	 *  更新默认模版
	 */
	public String updateFittingTemplateType() throws Exception{
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
		
		String typeID = Utility.getName(request.getParameter("typeID"));
		String id = Utility.getName(request.getParameter("id"));
		
		FittingTemplateTypePo fittingTemplateTypePo = new FittingTemplateTypePo();
		fittingTemplateTypePo.setBfttid(typeID);
		fittingTemplateTypePo.setBftid(id);
		
		fittingTemplateTypeMgr.updateFittingTemplateTypePo(fittingTemplateTypePo);
		request.setAttribute("flag", GlobalConstants.REFRESH);
		return SUCCESS;
	}

	/**
	 *  更新默认模版
	 */
	public String updateFittingTemplateTypeShowtype() throws Exception{
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
		
		String showType = Utility.getName(request.getParameter("showType"));
		String typeID = Utility.getName(request.getParameter("typeID"));
		
		fittingTemplateTypeMgr.updateFittingTemplateTypeShowtype(typeID, showType);

		request.setAttribute("flag", GlobalConstants.UPADTE);
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		
		return SUCCESS;
	}
	
	public FittingTemplateTypeMgr getFittingTemplateTypeMgr() {
		return fittingTemplateTypeMgr;
	}

	public void setFittingTemplateTypeMgr(
			FittingTemplateTypeMgr fittingTemplateTypeMgr) {
		this.fittingTemplateTypeMgr = fittingTemplateTypeMgr;
	}

	public SystemParameterMgr getSystemParameterMgr() {
		return systemParameterMgr;
	}

	public void setSystemParameterMgr(SystemParameterMgr systemParameterMgr) {
		this.systemParameterMgr = systemParameterMgr;
	}

	public SystemParameterPo getSystemParameterPo() {
		return systemParameterPo;
	}

	public void setSystemParameterPo(SystemParameterPo systemParameterPo) {
		this.systemParameterPo = systemParameterPo;
	}

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public List<FittingTemplateTypePo> getFittingTemplateTypeList() {
		return fittingTemplateTypeList;
	}

	public void setFittingTemplateTypeList(
			List<FittingTemplateTypePo> fittingTemplateTypeList) {
		this.fittingTemplateTypeList = fittingTemplateTypeList;
	}

	public FittingTemplateTypePo getFittingTemplateTypePo() {
		return fittingTemplateTypePo;
	}

	public void setFittingTemplateTypePo(FittingTemplateTypePo fittingTemplateTypePo) {
		this.fittingTemplateTypePo = fittingTemplateTypePo;
	}

	public String getActionTypeID() {
		return actionTypeID;
	}

	public void setActionTypeID(String actionTypeID) {
		this.actionTypeID = actionTypeID;
	}

	public String getActionImgUrl() {
		return actionImgUrl;
	}

	public void setActionImgUrl(String actionImgUrl) {
		this.actionImgUrl = actionImgUrl;
	}

	public String getActionReportTitle() {
		return actionReportTitle;
	}

	public void setActionReportTitle(String actionReportTitle) {
		this.actionReportTitle = actionReportTitle;
	}

	public String getActionFinereportRequestString() {
		return actionFinereportRequestString;
	}

	public void setActionFinereportRequestString(
			String actionFinereportRequestString) {
		this.actionFinereportRequestString = actionFinereportRequestString;
	}

	public String getActionReportingServiceRequestString() {
		return actionReportingServiceRequestString;
	}

	public void setActionReportingServiceRequestString(
			String actionReportingServiceRequestString) {
		this.actionReportingServiceRequestString = actionReportingServiceRequestString;
	}
}