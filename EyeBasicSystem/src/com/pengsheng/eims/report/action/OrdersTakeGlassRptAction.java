package com.pengsheng.eims.report.action;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.util.basicaction.BaseAction;

public class OrdersTakeGlassRptAction extends BaseAction {
	
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
	 * 订做取镜查询表
	 * @return
	 */
	public String initOrdersTakeGlassSel(){
		
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		
		DepartmentsPo departPo = new DepartmentsPo();
		departPo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		
		departmentsPo = departmentsMgr.getDepartment(departPo);
		
		return SUCCESS;
	}

}
