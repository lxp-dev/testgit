package com.pengsheng.eims.report.action;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.mgr.SupplierMgr;
import com.pengsheng.eims.basic.mgr.VarietyMgr;
import com.pengsheng.eims.basic.mgr.WarehouseMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.basicaction.BaseAction;

public class AllocationRptAction extends BaseAction {
	
	private List<WarehousePo> warehouseList;
	
	private WarehouseMgr warehouseMgr;
	
	private SupplierMgr supplierMgr;
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
	public SupplierMgr getSupplierMgr() {
		return supplierMgr;
	}
	public void setSupplierMgr(SupplierMgr supplierMgr) {
		this.supplierMgr = supplierMgr;
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
	private List<DepartmentsPo> departmentsList;
	
    private VarietyMgr varietyMgr;
	
	private List<GoodsCategoryPo> goodsCategorys;
	
	private DepartmentsMgr departmentsMgr;
	
	
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


	/**
	 * 调拨明细表
	 * @return
	 * @throws Exception
	 */
	public String initAllocation() throws Exception{
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
		
		goodsCategorys = supplierMgr.getGoodsCategoryList();
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		String[] strArray = super.getReportDefultDate(systemParameterPo);
				
		request.setAttribute("tBgnDate",strArray[0]);
		request.setAttribute("tEndDate",strArray[1]);
		
		return SUCCESS;
	}
	
	/**
	 * 调拨明细表
	 * @return
	 * @throws Exception
	 */
	public String initAllocationTr() throws Exception{
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
		
		goodsCategorys = supplierMgr.getGoodsCategoryList();
		
		return SUCCESS;
	}

}
