package com.pengsheng.eims.report.action;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.util.basicaction.BaseAction;

public class OptometryWorkRptAction extends BaseAction {
	
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
	
	public String initOptometryWork() throws Exception{
		
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdptype("1");
		
		departmentsList = departmentsMgr.getDepartmentsInfo(deppo);	
		
		return SUCCESS;
	}
	
}