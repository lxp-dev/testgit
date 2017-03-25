package com.pengsheng.eims.report.action;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.basicaction.BaseAction;

public class FrameGlassRptAction extends BaseAction {
	
	private List<DepartmentsPo> departmentsList;	
	private DepartmentsMgr departmentsMgr;
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


	/**
	 * 框镜销售单据分类表
	 * @return
	 * @throws Exception
	 */
	public String initFrameGlass() throws Exception{
		
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdptype("1");
		
		departmentsList = departmentsMgr.getDepartmentsInfo(deppo);	
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		return SUCCESS;
	}
	
	/**
	 * 北京同仁框镜销售单据分类表
	 * @return
	 * @throws Exception
	 */
	public String initFrameGlassTr() throws Exception{
		
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdptype("1");
		
		departmentsList = departmentsMgr.getDepartmentsInfo(deppo);	
		
		return SUCCESS;
	}


}
