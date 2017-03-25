package com.pengsheng.eims.storage.mgr;

import java.util.List;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.storage.persistence.ProcurementOrdersPo;

public interface ProcurementWaitMgr {

	/**
	 * 得到待收货订单信息
	 * 
	 * @param inventoryPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<ProcurementOrdersPo> getProcurementWaitList(
			ProcurementOrdersPo procurementOrdersPo, int start, int size);

	/**
	 * 得到待收获订单信息总个数
	 * 
	 * @param inventoryPo
	 * @return
	 */
	public int getProcurementWaitCount(ProcurementOrdersPo procurementOrdersPo);

	/**
	 * 得到转单页面中的详细信息
	 * 
	 * @param inventoryPo
	 * @return
	 */
	public List<InventoryEntryPo> getProcurementInventoryEntryList(
			InventoryEntryPo inventoryEntryPo);

	/**
	 * 得到转单详细信息个数
	 * 
	 * @param inventoryPo
	 * @return
	 */
	public int getProcurementInventoryEntryCount(
			InventoryEntryPo inventoryEntryPo);

	/**
	 * 新增转单
	 * 
	 * @param po
	 *            InventoryPo
	 */
	public void insertProcurementWaitAll(InventoryPo inventoryPo,
			List<InventoryEntryPo> list,LogisticsLogPo logPo);

}
