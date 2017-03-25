package com.pengsheng.eims.report.action;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.system.mgr.CompanyNameMgr;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.CompanyNamePo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;

public class CompanyReportAction extends BaseAction {
	private List<DepartmentsPo> departmentsList;
	private DepartmentsMgr departmentsMgr;
	private PersonPermissionMgr personPermissionMgr;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private CompanyNameMgr companyNameMgr;
	private CompanyNamePo companyNamePo;
	private List<CompanyNamePo> companyNamePos;
	
	public String initCompanyViceGoodsCount() throws Exception{
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");	
		companyNamePos = companyNameMgr.getCompanyNameForSelect(null);
		
		String[] strArray = super.getReportDefultDate(systemParameterPo);
		
		request.setAttribute("tBgnDate",strArray[0]);
		request.setAttribute("tEndDate",strArray[1]);
		
		String startTime = request.getParameter("startTime");
		String salesType = request.getParameter("salesType");
		
		request.setAttribute("startTime", startTime);
		request.setAttribute("salesType", salesType);
		
		return SUCCESS;
	}
	
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}
	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
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

	public CompanyNameMgr getCompanyNameMgr() {
		return companyNameMgr;
	}

	public void setCompanyNameMgr(CompanyNameMgr companyNameMgr) {
		this.companyNameMgr = companyNameMgr;
	}

	public CompanyNamePo getCompanyNamePo() {
		return companyNamePo;
	}

	public void setCompanyNamePo(CompanyNamePo companyNamePo) {
		this.companyNamePo = companyNamePo;
	}

	public List<CompanyNamePo> getCompanyNamePos() {
		return companyNamePos;
	}

	public void setCompanyNamePos(List<CompanyNamePo> companyNamePos) {
		this.companyNamePos = companyNamePos;
	}
}
