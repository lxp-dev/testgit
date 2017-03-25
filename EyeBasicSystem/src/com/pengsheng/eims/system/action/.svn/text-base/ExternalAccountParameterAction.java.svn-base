package com.pengsheng.eims.system.action;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.mgr.BrankCardMgr;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.mgr.ExternalAccountParameterMgr;
import com.pengsheng.eims.system.mgr.PersonInfoMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.ExternalAccountParameterPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;

public class ExternalAccountParameterAction extends BaseAction{
	private List<DepartmentsPo> departmentsPos;
	private String savePath;
	private ExternalAccountParameterPo  externalAccountParameterPo;
	private DepartmentsMgr departmentsMgr;	
	private List<DepartmentsPo> departmentsList;
	private ExternalAccountParameterMgr externalAccountParameterMgr;
	private PersonInfoMgr personInfoMgr;
	private List<PersonInfoPo> PersonInfoList;
	private BrankCardMgr brankCardMgr;
	private List brankCardList;

	public BrankCardMgr getBrankCardMgr() {
		return brankCardMgr;
	}

	public void setBrankCardMgr(BrankCardMgr brankCardMgr) {
		this.brankCardMgr = brankCardMgr;
	}


	public List getBrankCardList() {
		return brankCardList;
	}

	public void setBrankCardList(List brankCardList) {
		this.brankCardList = brankCardList;
	}

	public List<PersonInfoPo> getPersonInfoList() {
		return PersonInfoList;
	}

	public void setPersonInfoList(List<PersonInfoPo> personInfoList) {
		PersonInfoList = personInfoList;
	}

	public ExternalAccountParameterMgr getExternalAccountParameterMgr() {
		return externalAccountParameterMgr;
	}

	public void setExternalAccountParameterMgr(
			ExternalAccountParameterMgr externalAccountParameterMgr) {
		this.externalAccountParameterMgr = externalAccountParameterMgr;
	}

	public PersonInfoMgr getPersonInfoMgr() {
		return personInfoMgr;
	}

	public void setPersonInfoMgr(PersonInfoMgr personInfoMgr) {
		this.personInfoMgr = personInfoMgr;
	}

	public DepartmentsMgr getDepartmentsMgr() {
		return departmentsMgr;
	}

	public void setDepartmentsMgr(DepartmentsMgr departmentsMgr) {
		this.departmentsMgr = departmentsMgr;
	}

	public List<DepartmentsPo> getDepartmentsList() {
		return departmentsList;
	}

	public void setDepartmentsList(List<DepartmentsPo> departmentsList) {
		this.departmentsList = departmentsList;
	}

	public ExternalAccountParameterPo getExternalAccountParameterPo() {
		return externalAccountParameterPo;
	}

	public void setExternalAccountParameterPo(
			ExternalAccountParameterPo externalAccountParameterPo) {
		this.externalAccountParameterPo = externalAccountParameterPo;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public List<DepartmentsPo> getDepartmentsPos() {
		return departmentsPos;
	}

	public void setDepartmentsPos(List<DepartmentsPo> departmentsPos) {
		this.departmentsPos = departmentsPos;
	}

	/**
	 * 加载系统设置页面
	 * @return
	 */
	public String initExternalAccountParameter() {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		//取得登陆人允许操作的仓位&部门 Begin		
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");		
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		departmentsList = departmentsMgr.getDepartments(deppo);
		//取得登陆人允许操作的仓位&部门 End
		PersonInfoPo per=new PersonInfoPo();
		PersonInfoList=externalAccountParameterMgr.exportPersonInfo(per);
		request.setAttribute("companyAdmin", Utility.getName(request.getParameter("companyAdmin")));
		
		externalAccountParameterPo=new ExternalAccountParameterPo();
		externalAccountParameterPo=externalAccountParameterMgr.getExternalAccountParameterPo(externalAccountParameterPo);
		
		return SUCCESS;
	}
	
	/**
	 * 插入系统设置数据
	 * @return
	 */
	public String insertExternalAccountParameter() {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

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
		
		externalAccountParameterMgr.insertExternalAccountParameter(externalAccountParameterPo);
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		if(!"".equals(Utility.getName(request.getParameter("companyAdmin")))){
			request.setAttribute("url", "'initExternalAccountParameter.action?moduleID="+moduleID+"&companyAdmin="+request.getParameter("companyAdmin")+"'");
		}else{
			request.setAttribute("url", "'initExternalAccountParameter.action?moduleID="+moduleID+"'");
		}
		
		this.clearMessages();
		this.addActionMessage("更新成功！");
		request.setAttribute("flag", GlobalConstants.MOVE);
		
		return SUCCESS;
	}
	
	
	
	
	private PersonPermissionMgr personPermissionMgr;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;

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

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}
	
}
