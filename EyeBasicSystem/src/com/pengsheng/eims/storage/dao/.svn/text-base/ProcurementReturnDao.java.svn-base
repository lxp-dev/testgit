package com.pengsheng.eims.storage.dao;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.storage.persistence.AllocationBarcodePo;
import com.pengsheng.eims.storage.persistence.AllocationEntryPo;
import com.pengsheng.eims.storage.persistence.AllocationPo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.storage.persistence.TracEntryPo;
import com.pengsheng.eims.storage.persistence.TracPo;
import com.pengsheng.eims.util.tools.Utility;

public interface ProcurementReturnDao {

	public int getProcurementReturnCount(InventoryPo po);

	public List<InventoryPo> getProcurementReturnList(InventoryPo po,
			int start, int size);

	public int getProcurementReturnStorageCount(InventoryPo po);

	public List<InventoryPo> getProcurementReturnStorageList(InventoryPo po,
			int start, int size);

	public InventoryPo getProcurementReturn(InventoryPo po);

	public List<InventoryEntryPo> getProcurementReturnEntryList(InventoryPo po);

	public void insertProcurementReturn(InventoryPo po);
	public void insertAllocationStatus(InventoryPo po);

	public void insertProcurementReturnEntry(InventoryEntryPo po);

	public void updateProcurementReturn(InventoryPo po);
	
	public List<InventoryEntryPo> getReallocationList(InventoryPo po);
	
	public List<InventoryEntryPo> getAllocationBarcode(String billid);

	/**
	 * 更新商品退货信息
	 */
	public void updateProcurementReturnStorage(InventoryPo po);

	public void deleteProcurementReturn(InventoryPo po);

	public void deleteProcurementReturnEntry(InventoryPo po);

	/**
	 * 新增商品退货信息
	 * 
	 * @param po
	 */
	public void insertProcurementReturnStorage(InventoryPo po);

	/**
	 * 新增商品退货明细表信息
	 * 
	 * @param po
	 */
	public void insertProcurementReturnEntryStorage(InventoryEntryPo po);

	/**
	 * 采购退货转订单
	 * 
	 * @param poID
	 */
	public void ProcurementReturnimportOrders(String poID);
	
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
	
	public List<InventoryEntryPo> getStockGoodsForBrand(InventoryPo po);
	
	public List<TracEntryPo> getStoreStockGoodsForBrand(TracPo po);
}
