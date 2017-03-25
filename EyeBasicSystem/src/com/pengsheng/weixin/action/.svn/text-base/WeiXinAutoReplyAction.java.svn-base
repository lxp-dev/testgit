package com.pengsheng.weixin.action;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.weixin.mgr.WeiXinAutoReplyMgr;
import com.pengsheng.weixin.persistence.WeiXinAutoReplyPo;

public class WeiXinAutoReplyAction  extends BaseAction {
	
	private PersonPermissionMgr personPermissionMgr;
	private SystemParameterPo systemParameterPo;
	private SystemParameterMgr systemParameterMgr; 
	
	private WeiXinAutoReplyPo weiXinAutoReplyPo;
	private WeiXinAutoReplyMgr weiXinAutoReplyMgr;

	/**
	 * 初始化文章类型更新
	 */
	public String initUpdateWeiXinAutoReplyPo() throws Exception {
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
		
		weiXinAutoReplyPo = new WeiXinAutoReplyPo();		
		weiXinAutoReplyPo = weiXinAutoReplyMgr.getWeiXinAutoReplyPo();

		return SUCCESS;
	}
	
	/**
	 * 文章类型更新
	 */
	public String updateWeiXinAutoReplyPo() throws Exception {
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
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 表示状态
		logPo.setsLogContent("关注回复:" + weiXinAutoReplyPo.getWartitlegz()+" ；自动回复： "+weiXinAutoReplyPo.getWartitlehf() +"修改!");
		
		weiXinAutoReplyMgr.updateWeiXinAutoReply(weiXinAutoReplyPo, logPo);
		
		this.clearMessages();
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);		
		this.addActionMessage(getText("struts.messages.update.sucess"));
		return SUCCESS;
	}

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public SystemParameterPo getSystemParameterPo() {
		return systemParameterPo;
	}

	public void setSystemParameterPo(SystemParameterPo systemParameterPo) {
		this.systemParameterPo = systemParameterPo;
	}

	public SystemParameterMgr getSystemParameterMgr() {
		return systemParameterMgr;
	}

	public void setSystemParameterMgr(SystemParameterMgr systemParameterMgr) {
		this.systemParameterMgr = systemParameterMgr;
	}

	public WeiXinAutoReplyPo getWeiXinAutoReplyPo() {
		return weiXinAutoReplyPo;
	}

	public void setWeiXinAutoReplyPo(WeiXinAutoReplyPo weiXinAutoReplyPo) {
		this.weiXinAutoReplyPo = weiXinAutoReplyPo;
	}

	public WeiXinAutoReplyMgr getWeiXinAutoReplyMgr() {
		return weiXinAutoReplyMgr;
	}

	public void setWeiXinAutoReplyMgr(WeiXinAutoReplyMgr weiXinAutoReplyMgr) {
		this.weiXinAutoReplyMgr = weiXinAutoReplyMgr;
	}
}
