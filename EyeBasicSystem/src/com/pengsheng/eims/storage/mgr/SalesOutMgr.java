package com.pengsheng.eims.storage.mgr;

import java.util.List;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.persistence.AllocationBarcodePo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;

public interface SalesOutMgr {
	
	public int getSalesOutCount(InventoryPo po);
	
	public List<InventoryPo> getSalesOutList(InventoryPo po,int start, int size);
	
	public InventoryPo getSalesOut(InventoryPo po);
	
	public List<InventoryEntryPo> getSalesOutEntryList(InventoryPo po);	
	
	public void insertSalesOut(InventoryPo po,List<InventoryEntryPo> list,List<AllocationBarcodePo> allocationBarcodeList,LogisticsLogPo logPo);
	
	public void updateSalesOut(InventoryPo po,List<InventoryEntryPo> list,List<AllocationBarcodePo> allocationBarcodeList,LogisticsLogPo logPo);
	
	public void deleteSalesOut(InventoryPo po,LogisticsLogPo logPo);
	
	public List<InventoryEntryPo> getReallocationList(InventoryPo po);
	/**
	 * 获取业务单据商品条码
	 * @param po
	 * @return
	 */
	public List<AllocationBarcodePo> getInventoryBarcode(InventoryPo po);
}
