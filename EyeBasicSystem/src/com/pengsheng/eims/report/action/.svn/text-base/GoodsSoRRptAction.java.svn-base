package com.pengsheng.eims.report.action;

import java.util.List;

import com.pengsheng.eims.basic.mgr.VarietyMgr;
import com.pengsheng.eims.basic.mgr.WarehouseMgr;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.util.basicaction.BaseAction;

public class GoodsSoRRptAction extends BaseAction {
	
	private List<WarehousePo> warehouseList;	
	private WarehouseMgr warehouseMgr;
	
	private List<GoodsCategoryPo> goodsCategorys;	
	private VarietyMgr varietyMgr;
	
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
	
	public String initGoodsSoR() throws Exception{
		goodsCategorys = varietyMgr.getGoodsCategorys();		
		return SUCCESS;
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
}