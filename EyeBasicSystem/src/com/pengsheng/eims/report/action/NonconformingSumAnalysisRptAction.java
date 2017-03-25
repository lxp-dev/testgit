package com.pengsheng.eims.report.action;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.mgr.NonconformingProductMgr;
import com.pengsheng.eims.basic.mgr.SupplierMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.basic.persistence.NonconformingProductPo;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.basicaction.BaseAction;

public class NonconformingSumAnalysisRptAction extends BaseAction {
	
	private SupplierMgr supplierMgr;	
	private List<GoodsCategoryPo> goodsCategoryList;
	private List<DepartmentsPo> departmentsList;	
	private DepartmentsMgr departmentsMgr;
	private List<NonconformingProductPo> nonconformingProductMaxList; // 不合格品原因List
	private NonconformingProductMgr nonconformingProductMgr;
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
	public List<NonconformingProductPo> getNonconformingProductMaxList() {
		return nonconformingProductMaxList;
	}
	public void setNonconformingProductMaxList(
			List<NonconformingProductPo> nonconformingProductMaxList) {
		this.nonconformingProductMaxList = nonconformingProductMaxList;
	}
	public NonconformingProductMgr getNonconformingProductMgr() {
		return nonconformingProductMgr;
	}
	public void setNonconformingProductMgr(
			NonconformingProductMgr nonconformingProductMgr) {
		this.nonconformingProductMgr = nonconformingProductMgr;
	}
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
	public SupplierMgr getSupplierMgr() {
		return supplierMgr;
	}
	public void setSupplierMgr(SupplierMgr supplierMgr) {
		this.supplierMgr = supplierMgr;
	}
	public List<GoodsCategoryPo> getGoodsCategoryList() {
		return goodsCategoryList;
	}
	public void setGoodsCategoryList(List<GoodsCategoryPo> goodsCategoryList) {
		this.goodsCategoryList = goodsCategoryList;
	}

	/**
	 * 初始化采购汇总表页面
	 * @return
	 */
	public String initNonconformingSumAnalysisRpt(){
		
		nonconformingProductMaxList = nonconformingProductMgr.getNonconformingProductMaxList();
		goodsCategoryList = supplierMgr.getGoodsCategoryList();
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		String[] strArray = super.getReportDefultDate(systemParameterPo);
		
		request.setAttribute("tBgnDate",strArray[0]);
		request.setAttribute("tEndDate",strArray[1]);
		
		return SUCCESS;
	}
	
}
