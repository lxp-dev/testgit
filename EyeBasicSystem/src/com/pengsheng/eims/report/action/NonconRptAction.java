package com.pengsheng.eims.report.action;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.util.basicaction.BaseAction;

public class NonconRptAction extends BaseAction {
	
	private List<DepartmentsPo> departmentsList;
	
	private DepartmentsMgr departmentsMgr;
	
	public List<DepartmentsPo> getDepartmentsList() {
		return departmentsList;
	}

	public void setDepartmentsList(List<DepartmentsPo> departmentsList) {
		this.departmentsList = departmentsList;
	}

	public DepartmentsMgr getDepartmentsMgr() {
		return departmentsMgr;
	}

	public void setDepartmentsMgr(DepartmentsMgr departmentsMgr) {
		this.departmentsMgr = departmentsMgr;
	}

	public String initNoncon() throws Exception{
		
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");		
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		
		departmentsList = departmentsMgr.getDepartments("1");	
		List<DepartmentsPo> departmentsList2 = departmentsMgr.getDepartments("2");	
	 
		for (int i = 0; i < departmentsList2.size(); i++){
			departmentsList.add(departmentsList2.get(i));
		}	 
		
		return SUCCESS;
	}


}