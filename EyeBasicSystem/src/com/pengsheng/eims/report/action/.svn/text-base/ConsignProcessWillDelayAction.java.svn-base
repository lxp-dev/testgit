package com.pengsheng.eims.report.action;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.storage.mgr.SpectaclesMaterialsMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.basicaction.BaseAction;

public class ConsignProcessWillDelayAction extends BaseAction {
	
	
	private SpectaclesMaterialsMgr spectaclesMaterialsMgr;
	
	
	private List<DepartmentsPo> departmentsList;
	
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


	public List<DepartmentsPo> getDepartmentsList() {
		return departmentsList;
	}


	public void setDepartmentsList(List<DepartmentsPo> departmentsList) {
		this.departmentsList = departmentsList;
	}


	public SpectaclesMaterialsMgr getSpectaclesMaterialsMgr() {
		return spectaclesMaterialsMgr;
	}


	public void setSpectaclesMaterialsMgr(
			SpectaclesMaterialsMgr spectaclesMaterialsMgr) {
		this.spectaclesMaterialsMgr = spectaclesMaterialsMgr;
	}


	/**
	 * 委外预误期表
	 * @return
	 */
	public String initConsignProcessWillDelaySel(){
		
		// 取得登陆人允许操作的仓位&部门 Begin
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		DepartmentsPo deppo = new DepartmentsPo();
		deppo.setBdpregid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		departmentsList = spectaclesMaterialsMgr.getdepartment(deppo);
		// 取得登陆人允许操作的仓位&部门 End
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		String[] strArray = super.getReportDefultDate(systemParameterPo);

		request.setAttribute("tBgnDate",strArray[0]);
		request.setAttribute("tEndDate",strArray[1]);
		
		return SUCCESS;
	}

}
