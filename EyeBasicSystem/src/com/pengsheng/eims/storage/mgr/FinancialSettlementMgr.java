package com.pengsheng.eims.storage.mgr;

import java.util.List;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;

public interface FinancialSettlementMgr {
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
	public void updateFinancialSettlement(InventoryPo po,List<InventoryEntryPo> list,LogisticsLogPo logPo);
	
	/**
	 * 批量财务结算
	 * @param po
	 */
	public void insertFinancialSettlementBatch(List<InventoryPo> strList,LogisticsLogPo logPo);
		
}
