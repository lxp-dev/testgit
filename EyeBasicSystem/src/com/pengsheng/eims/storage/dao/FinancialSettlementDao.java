package com.pengsheng.eims.storage.dao;

import java.util.List;

import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;

public interface FinancialSettlementDao {
	/**
	 * 查询采购收货结算数量
	 * @param po
	 * @return
	 */
	public int getFinancialSettlementCount(InventoryPo po);
	/**
	 * 查询财务结算
	 * @param po
	 * @param start
	 * @param size
	 * @return
	 */
	public List<InventoryPo> getFinancialSettlementList(InventoryPo po,int start, int size);
	/**
	 * 财务结算详细
	 * @param po
	 * @return
	 */
	public InventoryPo getFinancialSettlement(InventoryPo po);
	/**
	 * 遍历财务结算信息
	 * @param po
	 * @return
	 */
	public List<InventoryEntryPo> getFinancialSettlementEntryList(InventoryPo po);
	/**
	 * 修改财务结算
	 * @param po
	 */
	public void updateFinancialSettlement(InventoryPo po);
	/**
	 * 修改业务单明细表信息
	 * @param po
	 */
	public void updateFinancialSettlementEntry(InventoryEntryPo po);
	
	/**
	 * 批量财务结算
	 * @param po
	 */
	public void insertFinancialSettlementBatch(InventoryPo po);
	
	/**
	 * 批量财务结算
	 * @param po
	 */
	public void insertFinancialSettlementEntryBatch(InventoryPo po);

	/**
	 * 修改财务结算(批发收货)
	 * @param po
	 */
	public void updateStoreFinancialSettlement(InventoryPo po);
}
