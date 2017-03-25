package com.pengsheng.eims.report.action;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.mgr.VarietyMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.util.basicaction.BaseAction;

public class SalseBasicAccessoryRptQTAction extends BaseAction {

	private List<DepartmentsPo> departmentsList;
	
	public List<DepartmentsPo> getDepartmentsList() {
		return departmentsList;
	}


	public void setDepartmentsList(List<DepartmentsPo> departmentsList) {
		this.departmentsList = departmentsList;
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


	public DepartmentsMgr getDepartmentsMgr() {
		return departmentsMgr;
	}


	public void setDepartmentsMgr(DepartmentsMgr departmentsMgr) {
		this.departmentsMgr = departmentsMgr;
	}


	private VarietyMgr varietyMgr;
	
	private List<GoodsCategoryPo> goodsCategorys;
	
	private DepartmentsMgr departmentsMgr;
	
	
	/**
	 * 辅料销售明细报表
	 * @return
	 * @throws Exception
	 */
	public String initSalseBasicAccessoryQT()throws Exception{
		
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");		
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		List<DepartmentsPo> departmentsList1 = departmentsMgr.getDepartments(deppo);	
		departmentsList=new ArrayList<DepartmentsPo>();
		for(int i=0;i<departmentsList1.size();i++){
			if("1".equals(departmentsList1.get(i).getBdptype()))
			{	
				departmentsList.add(departmentsList1.get(i));
			}
		}
		goodsCategorys = varietyMgr.getGoodsCategorys();
		return SUCCESS;
	}
}
