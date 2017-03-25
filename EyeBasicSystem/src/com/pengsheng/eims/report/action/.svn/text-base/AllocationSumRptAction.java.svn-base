package com.pengsheng.eims.report.action;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.mgr.SupplierMgr;
import com.pengsheng.eims.basic.mgr.WarehouseMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.system.mgr.CompanyNameMgr;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.CompanyNamePo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.basicaction.BaseAction;

public class AllocationSumRptAction extends BaseAction {
	
	private List<WarehousePo> warehouseList;
	
	private WarehouseMgr warehouseMgr;
	
	private SystemParameterPo systemParameterPo;
	
	private SystemParameterMgr systemParameterMgr;
	
	private List<GoodsCategoryPo> goodsCategorys;
	
	private SupplierMgr supplierMgr;
	
	private List<CompanyNamePo> companyNamePos;
	
	private CompanyNameMgr companyNameMgr;
	
	public List<CompanyNamePo> getCompanyNamePos() {
		return companyNamePos;
	}
	public void setCompanyNamePos(List<CompanyNamePo> companyNamePos) {
		this.companyNamePos = companyNamePos;
	}
	public CompanyNameMgr getCompanyNameMgr() {
		return companyNameMgr;
	}
	public void setCompanyNameMgr(CompanyNameMgr companyNameMgr) {
		this.companyNameMgr = companyNameMgr;
	}
	public List<GoodsCategoryPo> getGoodsCategorys() {
		return goodsCategorys;
	}
	public void setGoodsCategorys(List<GoodsCategoryPo> goodsCategorys) {
		this.goodsCategorys = goodsCategorys;
	}
	public SupplierMgr getSupplierMgr() {
		return supplierMgr;
	}
	public void setSupplierMgr(SupplierMgr supplierMgr) {
		this.supplierMgr = supplierMgr;
	}
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
	public WarehouseMgr getWarehouseMgr() {
		return warehouseMgr;
	}
	public void setWarehouseMgr(WarehouseMgr warehouseMgr) {
		this.warehouseMgr = warehouseMgr;
	}
	public List<WarehousePo> getWarehouseList() {
		return warehouseList;
	}
	public void setWarehouseList(List<WarehousePo> warehouseList) {
		this.warehouseList = warehouseList;
	}
	
	public String initAllocationSum() throws Exception{
		//取得登陆人允许操作的仓位&部门 Begin		
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");		
		if("1".equals(personInfoPo.getDepartmenttype())){
			DepartmentsPo departmentsPo=new DepartmentsPo();
			departmentsPo.setBdpdepartmentid(personInfoPo.getDepartmentID());
			departmentsPo.setBdptype(personInfoPo.getDepartmenttype());
			warehouseList=warehouseMgr.getWarehouseList(departmentsPo);
		}else{
			warehouseList=warehouseMgr.getWarehouseList(new WarehousePo());
		}
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		
		companyNamePos = companyNameMgr.getCompanyNameForSelect(null);
		
		String[] strArray = super.getReportDefultDate(systemParameterPo);
		goodsCategorys = supplierMgr.getGoodsCategoryList();
		request.setAttribute("tBgnDate",strArray[0]);
		request.setAttribute("tEndDate",strArray[1]);
		return SUCCESS;
	}

	public String initAllocationCostSum() throws Exception{
		//取得登陆人允许操作的仓位&部门 Begin		
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");		
		if("1".equals(personInfoPo.getDepartmenttype())){
			DepartmentsPo departmentsPo=new DepartmentsPo();
			departmentsPo.setBdpdepartmentid(personInfoPo.getDepartmentID());
			departmentsPo.setBdptype(personInfoPo.getDepartmenttype());
			warehouseList=warehouseMgr.getWarehouseList(departmentsPo);
		}else{
			warehouseList=warehouseMgr.getWarehouseList(new WarehousePo());
		}
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		String[] strArray = super.getReportDefultDate(systemParameterPo);
		goodsCategorys = supplierMgr.getGoodsCategoryList();
		request.setAttribute("tBgnDate",strArray[0]);
		request.setAttribute("tEndDate",strArray[1]);
		return SUCCESS;
	}

}