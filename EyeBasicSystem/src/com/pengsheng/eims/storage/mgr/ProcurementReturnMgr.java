package com.pengsheng.eims.storage.mgr;

import java.util.List;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.persistence.AllocationBarcodePo;
import com.pengsheng.eims.storage.persistence.AllocationEntryPo;
import com.pengsheng.eims.storage.persistence.AllocationPo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.storage.persistence.TracEntryPo;
import com.pengsheng.eims.storage.persistence.TracPo;

public interface ProcurementReturnMgr {

	public int getProcurementReturnCount(InventoryPo po);

	public List<InventoryPo> getProcurementReturnList(InventoryPo po,
			int start, int size);

	public int getProcurementReturnStorageCount(InventoryPo po);

	public List<InventoryPo> getProcurementReturnStorageList(InventoryPo po,
			int start, int size);

	public InventoryPo getProcurementReturn(InventoryPo po);

	public List<InventoryEntryPo> getProcurementReturnEntryList(InventoryPo po);

	public void insertProcurementReturn(InventoryPo po,
			List<InventoryEntryPo> list);

	public void updateProcurementReturn(InventoryPo po,
			List<InventoryEntryPo> list,LogisticsLogPo logPo);

	public void deleteProcurementReturn(InventoryPo po,LogisticsLogPo logPo);
	
	public List<InventoryEntryPo> getReallocationList(InventoryPo po);
	
	public List<InventoryEntryPo> getAllocationBarcode(String billid);

	/**
	 * 新增商品退货单
	 */
	public void insertProcurementReturnStorage(InventoryPo po,
			List<InventoryEntryPo> list,List<AllocationBarcodePo> allocationBarcodeList,LogisticsLogPo logPo);

	/**
	 * 更新商品退货
	 * 
	 * @param po
	 * @param list
	 */
	public void updateProcurementReturnStorage(InventoryPo po,
			List<InventoryEntryPo> list,List<AllocationBarcodePo> allocationBarcodeList,LogisticsLogPo logPo);
	
	/**
	 * 获取业务单据商品条码
	 * @param po
	 * @return
	 */
	public List<AllocationBarcodePo> getInventoryBarcode(InventoryPo po);
	
	public List<InventoryEntryPo> getStockGoodsForBrand(InventoryPo po);
	
	public List<TracEntryPo> getStoreStockGoodsForBrand(TracPo po);
}
