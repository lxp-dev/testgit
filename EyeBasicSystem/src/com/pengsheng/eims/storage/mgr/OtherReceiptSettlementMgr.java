package com.pengsheng.eims.storage.mgr;

import java.util.List;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;

public interface OtherReceiptSettlementMgr {

	/**
	 * 查询其它入库结算数量
	 * @param po
	 * @return
	 */
	public int getOtherReceiptSettlementCount(InventoryPo po);
	
	/**
	 * 显示其它入库结算主表信息并分页
	 * @param po
	 * @param start
	 * @param size
	 * @return
	 */
	public List<InventoryPo> getOtherReceiptSettlementList(InventoryPo po,
			int start, int size);
	/**
	 * 其它入库结算详细
	 * @param po
	 * @return
	 */
	public InventoryPo getOtherReceiptSettlement(InventoryPo po);
	
	/**
	 * 其它入库结算业务单明细表信息
	 * @param po
	 * @return
	 */
	public List<InventoryEntryPo> getOtherReceiptSettlementDetailsList(InventoryPo po);
	
	/**
	 * 其它入库收货结算主表信息
	 * @param po
	 */
	public void updateOtherReceiptSettlement(InventoryPo po,List<InventoryEntryPo> list,LogisticsLogPo logPo);
}
