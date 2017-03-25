package com.pengsheng.eims.basic.action;

import java.net.URLDecoder;
import java.util.List;

import com.pengsheng.eims.basic.mgr.OpenCloseConfigurationMgr;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.StatusModulePo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;

public class OpenCloseConfigurationAction extends BaseAction {
	
	private OpenCloseConfigurationMgr opencloseConfigurationMgr;
	private PersonPermissionMgr personPermissionMgr;
	
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}
	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}
	public OpenCloseConfigurationMgr getOpencloseConfigurationMgr() {
		return opencloseConfigurationMgr;
	}
	public void setOpencloseConfigurationMgr(
			OpenCloseConfigurationMgr opencloseConfigurationMgr) {
		this.opencloseConfigurationMgr = opencloseConfigurationMgr;
	}
	public StatusModulePo getStatusModulePo() {
		return statusModulePo;
	}
	public void setStatusModulePo(StatusModulePo statusModulePo) {
		this.statusModulePo = statusModulePo;
	}
	public List<StatusModulePo> getOpenCloseConfigurationList() {
		return openCloseConfigurationList;
	}
	public void setOpenCloseConfigurationList(
			List<StatusModulePo> openCloseConfigurationList) {
		this.openCloseConfigurationList = openCloseConfigurationList;
	}
	private StatusModulePo statusModulePo;
	
	private List<StatusModulePo> openCloseConfigurationList;
	
	/**
	 * 开关配置查询
	 */
	public String initStatus()throws Exception{
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

		openCloseConfigurationList = opencloseConfigurationMgr.getStatusList();// 模块权限获取

		
	
		return SUCCESS;
	}
	
	/**
	 * 初始化关变更配置
	 */
	public String selinitStatusguan()throws Exception{
		
		String id = Utility.getName(request.getParameter("hid"));
		String name = Utility.getName(request.getParameter("hname"));
		statusModulePo = new StatusModulePo();
		statusModulePo.setFsmstatusid(id);
		statusModulePo.setFsmstatusremark(URLDecoder.decode(name,"UTF-8"));

		//statusModulePo = glassesFrameMgr.getGlassesFrame(goodsInfoPo);
		

		return SUCCESS;
	}
	
	/**
	 * 修改关闭变更配置
	 */
	public String updateStatusguan()throws Exception{
		
		String id = Utility.getName(request.getParameter("hid"));
		statusModulePo = new StatusModulePo();
		statusModulePo.setFsmstatusid(id);
		statusModulePo.setFsmstatuscode("1");
		//statusModulePo.setFsmstatusremark(name);

		opencloseConfigurationMgr.updateStatusModule(statusModulePo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		return SUCCESS;
	}
	
	/**
	 * 初始化开变更配置
	 */
	public String selinitStatuskai()throws Exception{
		String id = Utility.getName(request.getParameter("hid"));
		String name = Utility.getName(request.getParameter("hname"));
		statusModulePo = new StatusModulePo();
		statusModulePo.setFsmstatusid(id);
		statusModulePo.setFsmstatusremark(URLDecoder.decode(name,"UTF-8"));
		return SUCCESS;
	}
	
	/**
	 * 修改开启变更配置
	 */
	public String updateStatuskai()throws Exception{
		
		String id = Utility.getName(request.getParameter("hid"));
		statusModulePo = new StatusModulePo();
		statusModulePo.setFsmstatusid(id);
		statusModulePo.setFsmstatuscode("0");
		//statusModulePo.setFsmstatusremark(name);

		opencloseConfigurationMgr.updateStatusModule(statusModulePo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		return SUCCESS;
	}
	
	
}
