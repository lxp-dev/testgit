package com.pengsheng.eims.basic.action;

import java.io.File;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.pengsheng.eims.basic.mgr.SystemModuleMgr;
import com.pengsheng.eims.system.persistence.ModulePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.bean.UUIDHexGenerator;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class SystemModuleAction extends BaseAction {

	protected UUIDHexGenerator uuid = UUIDHexGenerator.getInstance();
	private ModulePo modulePo;

	private List<ModulePo> modulePoMaxList; // List
	private List<ModulePo> modulePoMinList; // List

	private SystemModuleMgr systemModuleMgr;
	
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	
	private File[] upload;
	private String[] uploadContentType;
	private String[] uploadFileName;
	private String savePath;
	
	
	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public File[] getUpload() {
		return upload;
	}

	public void setUpload(File[] upload) {
		this.upload = upload;
	}

	public String[] getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String[] uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String[] getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String[] uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public ModulePo getModulePo() {
		return modulePo;
	}

	public void setModulePo(ModulePo modulePo) {
		this.modulePo = modulePo;
	}

	public List<ModulePo> getModulePoMaxList() {
		return modulePoMaxList;
	}

	public void setModulePoMaxList(List<ModulePo> modulePoMaxList) {
		this.modulePoMaxList = modulePoMaxList;
	}

	public List<ModulePo> getModulePoMinList() {
		return modulePoMinList;
	}

	public void setModulePoMinList(List<ModulePo> modulePoMinList) {
		this.modulePoMinList = modulePoMinList;
	}

	public SystemModuleMgr getSystemModuleMgr() {
		return systemModuleMgr;
	}

	public void setSystemModuleMgr(SystemModuleMgr systemModuleMgr) {
		this.systemModuleMgr = systemModuleMgr;
	}

	private PersonPermissionMgr personPermissionMgr;
	
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	/**
	 * 查询页面初始化
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initSystemModuleSel() throws Exception {
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		modulePoMaxList=systemModuleMgr.getSystemModuleMaxList();
		return SUCCESS;
	}

	/**
	 * 查询页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String selSystemModule() throws Exception {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		String moduleid=Utility.getName(request.getParameter("moduleid"));
		
		modulePoMaxList=systemModuleMgr.getSystemModuleMaxList();
		if(!moduleid.equals("")){
			ModulePo tmp=  new ModulePo();
			tmp.setModuleid(moduleid);
			modulePoMinList=systemModuleMgr.getSystemModuleMinList(tmp);
		}
		request.setAttribute("moduleidpage", moduleid);
		return SUCCESS;
	}
	
	/**
	 * 新增页面初始化
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initSystemModuleInsert() throws Exception {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		modulePo = new ModulePo();
		modulePoMaxList=systemModuleMgr.getSystemModuleMaxList();
		return SUCCESS;
	}

	/**
	 * 新增module
	 * 
	 * @return
	 * @throws Exception
	 */
	public String insertSystemModule() throws Exception {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 1 表示状态
		logPo.setsLogContent("系统模块维护:" + modulePo.getModuleid() + "新增!");
		if("0".equals(modulePo.getModuleID()))
		{
			modulePo.setModuleparentid("0");
		}
		systemModuleMgr.insertSystemModule(modulePo,logPo);

		modulePo = new ModulePo();
		modulePoMaxList=systemModuleMgr.getSystemModuleMaxList();
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}

	/**
	 * 更新module
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initSystemModuleUpdate() throws Exception {	
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		String moduleid=Utility.getName(request.getParameter("hid"));
		ModulePo tmp = new ModulePo();
		tmp.setModuleid(moduleid);
		modulePoMaxList=systemModuleMgr.getSystemModuleMaxList();
		modulePo = systemModuleMgr.getSystemModule(tmp);
		return SUCCESS;
	}

	/**
	 * 更新module
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updateSystemModule() throws Exception {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 1 表示状态
		logPo.setsLogContent("系统模块维护:" + modulePo.getModuleid() + "修改!");
		
		systemModuleMgr.updateSystemModule(modulePo,logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}

	/**
	 * 刪除页面初始化
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initSystemModuleDelete() throws Exception {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		String moduleid=Utility.getName(request.getParameter("hid"));
		ModulePo tmp = new ModulePo();
		tmp.setModuleid(moduleid);
		modulePo = systemModuleMgr.getSystemModule(tmp);
		return SUCCESS;
	}

	/**
	 * 刪除Module
	 * 
	 * @return
	 * @throws Exception
	 */
	public String deleteSystemModule() throws Exception {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 1 表示状态
		logPo.setsLogContent("系统模块维护:" + modulePo.getModuleid() + "删除!");
		
		systemModuleMgr.deleteSystemModule(modulePo,logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}
	
	/**
	 * 停用页面初始化
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initSystemModuleDisable() throws Exception {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		String moduleid=Utility.getName(request.getParameter("hid"));
		ModulePo tmp = new ModulePo();
		tmp.setModuleid(moduleid);
		modulePo = systemModuleMgr.getSystemModule(tmp);
		return SUCCESS;
	}

	/**
	 * 停用Module中子节点
	 * 
	 * @return
	 * @throws Exception
	 */
	public String disableSystemModule() throws Exception {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 1 表示状态
		logPo.setsLogContent("系统模块维护:" + modulePo.getModuleid() + "停用!");
		
		systemModuleMgr.disableSystemModule(modulePo,logPo);

		this.clearMessages();
		this.addActionMessage(getText("停用成功！"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}
	
	/**
	 * 启用页面初始化
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initSystemModuleAble() throws Exception {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		String moduleid=Utility.getName(request.getParameter("hid"));
		ModulePo tmp = new ModulePo();
		tmp.setModuleid(moduleid);
		modulePo = systemModuleMgr.getSystemModule(tmp);
		return SUCCESS;
	}

	/**
	 * 启用Module子节点
	 * 
	 * @return
	 * @throws Exception
	 */
	public String ableSystemModule() throws Exception {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 1 表示状态
		logPo.setsLogContent("系统模块维护:" + modulePo.getModuleid() + "启用!");
		
		systemModuleMgr.ableSystemModule(modulePo,logPo);

		this.clearMessages();
		this.addActionMessage(getText("启用成功！"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}
	/**
	 * 新增页面初始化
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initSystemModuleImport() throws Exception {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		

		return SUCCESS;
	}

	/**
	 * 新增module
	 * 
	 * @return
	 * @throws Exception
	 */
	public String importSystemModule() throws Exception {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 1 表示状态
		logPo.setsLogContent("系统模块维护:期初权限导入!");
		
		systemModuleMgr.insertImportModuleExcel(upload,ServletActionContext.getServletContext().getRealPath(this.getSavePath()), this.getUploadFileName(), this.getUploadContentType(),logPo);
	
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}

	/**
	 * 获取Module对应的帮助信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getSystemModuleHelp() throws Exception {
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		String flag = Utility.getName(request.getParameter("flag"));
		String httpUrl = Utility.getName(request.getParameter("httpUrl"));
		
		request.setAttribute("moduleID", moduleID);
		ModulePo tmp = new ModulePo();
		tmp.setModuleid(moduleID);
		modulePo = systemModuleMgr.getSystemModuleHelp(tmp);
		
		request.setAttribute("flag", flag);
		request.setAttribute("httpUrl", httpUrl);
		return SUCCESS;
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
}
