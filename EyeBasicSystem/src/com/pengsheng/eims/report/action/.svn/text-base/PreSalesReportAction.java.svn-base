package com.pengsheng.eims.report.action;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.sales.mgr.PreSalesMgr;
import com.pengsheng.eims.sales.persistence.PreBrandPo;
import com.pengsheng.eims.sales.persistence.PreDepPo;
import com.pengsheng.eims.sales.persistence.PrePlanPo;
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

public class PreSalesReportAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	
	private DepartmentsMgr departmentsMgr;
	private List<DepartmentsPo> departmentsList;
	private PrePlanPo prePlanPo;
	private List<PreDepPo> preDepPoList;
	private List<PreBrandPo> preBrandPoList;
	private PreSalesMgr preSalesMgr;
	private PersonPermissionMgr personPermissionMgr;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private List<CompanyNamePo> companyNamePos;
	private CompanyNameMgr companyNameMgr;
	
	public String initPreSales() {
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
		
		departmentsList = departmentsMgr.getDepartments("1", "0");
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		preSalesMgr.updatePreDepPoOverdue();
		
		companyNamePos = companyNameMgr.getCompanyNameForSelect(null);
		
		if(null != prePlanPo && !"".equals(Utility.getName(prePlanPo.getPlanId()))) {
			prePlanPo = preSalesMgr.getPrePlanPo(prePlanPo);
			preDepPoList = preSalesMgr.getPreDepPoList(prePlanPo);
		}
		
//		if(null != preDepPoList && preDepPoList.size() > 0) {
//			preBrandPoList = preSalesMgr.getPreBrandPoList(preDepPoList.get(0));
//		}
		return SUCCESS;
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

	public PrePlanPo getPrePlanPo() {
		return prePlanPo;
	}

	public void setPrePlanPo(PrePlanPo prePlanPo) {
		this.prePlanPo = prePlanPo;
	}

	public List<PreDepPo> getPreDepPoList() {
		return preDepPoList;
	}

	public void setPreDepPoList(List<PreDepPo> preDepPoList) {
		this.preDepPoList = preDepPoList;
	}

	public List<PreBrandPo> getPreBrandPoList() {
		return preBrandPoList;
	}

	public void setPreBrandPoList(List<PreBrandPo> preBrandPoList) {
		this.preBrandPoList = preBrandPoList;
	}

	public PreSalesMgr getPreSalesMgr() {
		return preSalesMgr;
	}

	public void setPreSalesMgr(PreSalesMgr preSalesMgr) {
		this.preSalesMgr = preSalesMgr;
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

	public List<CompanyNamePo> getCompanyNamePos() {
		return companyNamePos;
	}

	public void setCompanyNamePos(List<CompanyNamePo> companyNamePos) {
		this.companyNamePos = companyNamePos;
	}

	public CompanyNameMgr getCompanyNameMgr() {
		return companyNameMgr;
	}

	public void setCompanyNameMgr(CompanyNameMgr companyNameMgr) {
		this.companyNameMgr = companyNameMgr;
	}

}
