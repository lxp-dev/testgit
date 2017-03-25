package com.pengsheng.eims.storage.dao;

import java.util.List;

import com.pengsheng.eims.storage.persistence.AllocationBarcodePo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;

public interface SalesOutDao {
	
	public int getSalesOutCount(InventoryPo po);
	
	public List<InventoryPo> getSalesOutList(InventoryPo po,int start, int size);
	
	public InventoryPo getSalesOut(InventoryPo po);
		
	public List<InventoryEntryPo> getSalesOutEntryList(InventoryPo po);
	
	public void insertSalesOut(InventoryPo po);
	
	public void insertSalesOutEntry(InventoryEntryPo po);
	public void insertAllocationStatus(InventoryPo po);
	
	public void updateSalesOut(InventoryPo po);
	
	public void deleteSalesOut(InventoryPo po);
	
	public void deleteSalesOutEntry(InventoryPo po);
	
	public List<InventoryEntryPo> getReallocationList(InventoryPo po);
	/**
	 * 新增业务单据的商品条码
	 * 
	 * @param poID
	 */
	public void insertGoodsBarCode(AllocationBarcodePo allocationBarcodePo);
	
	/**
	 * 删除业务单据的商品条码
	 * 
	 * @param poID
	 */
	public void deleteGoodsBarCode(InventoryPo po);
	
	/**
	 * 获取业务单据商品条码
	 * @param po
	 * @return
	 */
	public List<AllocationBarcodePo> getInventoryBarcode(InventoryPo po);
}
