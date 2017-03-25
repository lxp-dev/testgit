package com.pengsheng.eims.report.action;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.util.basicaction.BaseAction;

public class StealthBrandOptometristsRptAction extends BaseAction {

	private DepartmentsMgr departmentsMgr;

	private DepartmentsPo departmentsPo;

	public DepartmentsMgr getDepartmentsMgr() {
		return departmentsMgr;
	}

	public void setDepartmentsMgr(DepartmentsMgr departmentsMgr) {
		this.departmentsMgr = departmentsMgr;
	}

	public DepartmentsPo getDepartmentsPo() {
		return departmentsPo;
	}

	public void setDepartmentsPo(DepartmentsPo departmentsPo) {
		this.departmentsPo = departmentsPo;
	}

	/**
	 * 初始化验光类型统计表页面
	 * 
	 * @return
	 */
	public String stealthBrandOptometristsO() {
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");

		DepartmentsPo departPo = new DepartmentsPo();
		departPo.setBdpdepartmentid(personInfoPo.getDepartmentID());

		departmentsPo = departmentsMgr.getDepartment(departPo);

		return SUCCESS;
	}
	
	/**
	 * 初始化验光类型统计表页面
	 * 
	 * @return
	 */
	public String stealthBrandOptometristsT() {
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");

		DepartmentsPo departPo = new DepartmentsPo();
		departPo.setBdpdepartmentid(personInfoPo.getDepartmentID());

		departmentsPo = departmentsMgr.getDepartment(departPo);

		return SUCCESS;
	}

}
