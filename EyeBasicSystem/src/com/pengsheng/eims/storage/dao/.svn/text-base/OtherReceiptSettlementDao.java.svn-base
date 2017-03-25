package com.pengsheng.eims.storage.dao;

import java.util.List;

import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;

public interface OtherReceiptSettlementDao {
	/**
	 * 查询其它入库结算数量
	 * @param po
	 * @return
	 */
	public int getOtherReceiptSettlementCount(InventoryPo po);
	/**
	 * 查询其它入库结算
	 * @param po
	 * @param start
	 * @param size
	 * @return
	 */
	public List<InventoryPo> getOtherReceiptSettlementList(InventoryPo po,int start, int size);
	/**
	 * 其它入库结算详细
	 * @param po
	 * @return
	 */
	public InventoryPo getOtherReceiptlSettlement(InventoryPo po);
	/**
	 * 遍历其它入库结算信息
	 * @param po
	 * @return
	 */
	public List<InventoryEntryPo> getOtherReceiptSettlementEntryList(InventoryPo po);
	/**
	 * 修改其它入库结算
	 * @param po
	 */
	public void updateOtherReceiptSettlement(InventoryPo po);
	/**
	 * 修改其它入库明细表信息
	 * @param po
	 */
	public void updateOtherReceiptSettlementEntry(InventoryEntryPo po);


}
