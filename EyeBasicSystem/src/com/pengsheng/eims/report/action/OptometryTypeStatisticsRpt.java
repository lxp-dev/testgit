package com.pengsheng.eims.report.action;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.basicaction.BaseAction;

public class OptometryTypeStatisticsRpt extends BaseAction {
	
	private DepartmentsMgr departmentsMgr;
	
	private DepartmentsPo departmentsPo;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	
	
	
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

	public DepartmentsPo getDepartmentsPo() {
		return departmentsPo;
	}

	public void setDepartmentsPo(DepartmentsPo departmentsPo) {
		this.departmentsPo = departmentsPo;
	}

	/**
	 * 初始化验光类型统计表页面
	 * @return
	 */
	public String initOptometryTypeStatistics(){
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		
		DepartmentsPo departPo = new DepartmentsPo();
		departPo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		
		departmentsPo = departmentsMgr.getDepartment(departPo);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		String[] strArray = super.getReportDefultDate(systemParameterPo);

		request.setAttribute("tBgnDate",strArray[0]);
		request.setAttribute("tEndDate",strArray[1]);
		
		return SUCCESS;
	}

}
