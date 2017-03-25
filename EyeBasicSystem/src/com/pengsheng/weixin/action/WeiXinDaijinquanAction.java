package com.pengsheng.weixin.action;

import java.util.List;

import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.weixin.mgr.WeiXinDaijinquanMgr;
import com.pengsheng.weixin.persistence.DaijinquanPo;

public class WeiXinDaijinquanAction  extends BaseAction {
	
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private PersonPermissionMgr personPermissionMgr;
	private WeiXinDaijinquanMgr weiXinDaijinquanMgr;
	private DaijinquanPo daijinquanPo;

	private List<DaijinquanPo> DaijinquanPoList;
	private String isFirstExec; 
	
	public String getIsFirstExec() {
		return isFirstExec;
	}
	public void setIsFirstExec(String isFirstExec) {
		this.isFirstExec = isFirstExec;
	}
	
	
	public List<DaijinquanPo> getDaijinquanPoList() {
		return DaijinquanPoList;
	}
	public void setDaijinquanPoList(List<DaijinquanPo> DaijinquanPoList) {
		this.DaijinquanPoList = DaijinquanPoList;
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
	
	public String initWeiDaijinquanSetInsert() throws Exception{
		
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
		daijinquanPo=new DaijinquanPo();
		daijinquanPo = weiXinDaijinquanMgr.selectStoredValueCardFlagPo(daijinquanPo);
		return SUCCESS;
	}
	public String insertWeiDaijinquanSet() throws Exception{
		
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
		weiXinDaijinquanMgr.InStoredValueCardFlag(daijinquanPo);
		this.clearMessages();
		this.addActionMessage(getText("保存成功！"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		return SUCCESS;
	}
	public DaijinquanPo getDaijinquanPo() {
		return daijinquanPo;
	}
	public void setDaijinquanPo(DaijinquanPo daijinquanPo) {
		this.daijinquanPo = daijinquanPo;
	}
	public WeiXinDaijinquanMgr getWeiXinDaijinquanMgr() {
		return weiXinDaijinquanMgr;
	}
	public void setWeiXinDaijinquanMgr(WeiXinDaijinquanMgr weiXinDaijinquanMgr) {
		this.weiXinDaijinquanMgr = weiXinDaijinquanMgr;
	}
}
