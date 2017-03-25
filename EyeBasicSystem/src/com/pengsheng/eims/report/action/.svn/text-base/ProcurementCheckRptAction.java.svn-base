package com.pengsheng.eims.report.action;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.mgr.VarietyMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.basicaction.BaseAction;

public class ProcurementCheckRptAction extends BaseAction{
	
	private List<GoodsCategoryPo> goodsCategorys;
	private VarietyMgr varietyMgr;
	private SystemParameterPo systemParameterPo;
	private SystemParameterMgr systemParameterMgr;
	
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



	public List<GoodsCategoryPo> getGoodsCategorys() {
		return goodsCategorys;
	}



	public void setGoodsCategorys(List<GoodsCategoryPo> goodsCategorys) {
		this.goodsCategorys = goodsCategorys;
	}



	public VarietyMgr getVarietyMgr() {
		return varietyMgr;
	}



	public void setVarietyMgr(VarietyMgr varietyMgr) {
		this.varietyMgr = varietyMgr;
	}



	public String initProcurementCheckRpt(){
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");		
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		String[] strArray = super.getReportDefultDate(systemParameterPo);
		
		request.setAttribute("tBgnDate",strArray[0]);
		request.setAttribute("tEndDate",strArray[1]);
		
		goodsCategorys = varietyMgr.getGoodsCategorys();
		return SUCCESS;
	}
}
