package com.pengsheng.eims.report.action;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.util.basicaction.BaseAction;

public class CustomerSalesDetailsQTAction extends BaseAction {

	private List<DepartmentsPo> departmentsList;
	
	private DepartmentsMgr departmentsMgr;
	
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

	/**
	 * 初始化顾客销售明细表页面
	 * @return
	 */
	public String initCustomerSalesDetailsSelQT(){
		
		// 取得登陆人允许操作的仓位&部门 Begin
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		DepartmentsPo deppo = new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		departmentsList = departmentsMgr.getDepartments(deppo);
		// 取得登陆人允许操作的仓位&部门 End
		
		return SUCCESS;
	}

}
