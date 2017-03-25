package com.pengsheng.eims.storage.dao;

import java.util.List;

import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;

public interface ConsignProcessSettlementDao {
	
	
	/**
	 * 查询委外收货结算数量
	 * @param po
	 * @return
	 */
	public int getConsignProcessSettlementCount(InventoryPo po);
	/**
	 * 显示委外收货结算主表信息并分页
	 * @param po
	 * @param start
	 * @param size
	 * @return
	 */
	public List<InventoryPo> getConsignProcessSettlementList(InventoryPo po,
			int start, int size);
	/**
	 * 委外收货结算业务单明细表信息
	 * @param po
	 * @return
	 */
	public List<InventoryEntryPo> getConsignProcessSettlementDetailsList(InventoryPo po);
	
	/**
	 * 委外收货结算详细
	 * @param po
	 * @return
	 */
	public InventoryPo getConsignProcessSettlement(InventoryPo po);
	
	/**
	 * 修改委外收货结算主表信息
	 * @param po
	 */
	public void updateConsignProcessSettlement(InventoryPo po);
	
	/**
	 * 修改委外收货结算明细表信息
	 * @param po
	 */
	public void updateConsignProcessSettlementDetails(InventoryEntryPo po);
	
	
}
