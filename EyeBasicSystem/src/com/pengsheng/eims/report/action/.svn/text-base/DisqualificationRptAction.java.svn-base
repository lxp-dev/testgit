package com.pengsheng.eims.report.action;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.mgr.VarietyMgr;
import com.pengsheng.eims.basic.mgr.WarehouseMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.sales.mgr.ProcessDistributionMgr;
import com.pengsheng.eims.storage.mgr.StockSearchMgr;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.basicaction.BaseAction;

public class DisqualificationRptAction extends BaseAction {

	private List<DepartmentsPo> departmentsList;

	private VarietyMgr varietyMgr;

	private List<GoodsCategoryPo> goodsCategorys;

	private DepartmentsMgr departmentsMgr;
	
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

	public VarietyMgr getVarietyMgr() {
		return varietyMgr;
	}

	public void setVarietyMgr(VarietyMgr varietyMgr) {
		this.varietyMgr = varietyMgr;
	}

	public List<GoodsCategoryPo> getGoodsCategorys() {
		return goodsCategorys;
	}

	public void setGoodsCategorys(List<GoodsCategoryPo> goodsCategorys) {
		this.goodsCategorys = goodsCategorys;
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
	 * 不合格品明细报表
	 * 
	 * @return
	 */
	public String initDisqualification() throws Exception {

		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		DepartmentsPo deppo = new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		List<DepartmentsPo> departmentsList1 = departmentsMgr
				.getDepartments(deppo);
		departmentsList = new ArrayList<DepartmentsPo>();
		for (int i = 0; i < departmentsList1.size(); i++) {
			if ("1".equals(departmentsList1.get(i).getBdptype())
					|| "2".equals(departmentsList1.get(i).getBdptype())
					|| "3".equals(departmentsList1.get(i).getBdptype())) {
				departmentsList.add(departmentsList1.get(i));
			}
		}
		goodsCategorys = varietyMgr.getGoodsCategorys();
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		String[] strArray = super.getReportDefultDate(systemParameterPo);

		request.setAttribute("tBgnDate",strArray[0]);
		request.setAttribute("tEndDate",strArray[1]);
		return SUCCESS;
	}

}
