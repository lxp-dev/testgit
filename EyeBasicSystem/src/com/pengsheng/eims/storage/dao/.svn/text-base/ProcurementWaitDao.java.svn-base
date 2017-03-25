package com.pengsheng.eims.storage.dao;

import java.util.List;

import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.storage.persistence.ProcurementOrdersPo;
import com.pengsheng.eims.storage.persistence.VerificationPo;

public interface ProcurementWaitDao {
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
	 * 插入转单的主表信息
	 * 
	 * @param inventoryPo
	 */
	public void insertProcurementInventoryPo(InventoryPo inventoryPo);

	/**
	 * 插入转单从表信息
	 * 
	 * @param inventoryEntryPo
	 */
	public void insertProcurementInventoryEntryPo(
			InventoryEntryPo inventoryEntryPo);

	/**
	 * 新增核销表
	 * 
	 * @param po
	 *            VerificationPo
	 */
	public void insertVerification(VerificationPo po);

}
