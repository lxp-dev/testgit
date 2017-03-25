package com.pengsheng.eims.storage.mgr;

import java.util.List;

import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;

public interface ReturnMerchandiseSettlementMgr {

	/**
	 * 查询采购收货结算数量
	 * 
	 * @param po
	 * @return
	 */
	public int getReturnMerchandiseSettlementCount(InventoryPo po);

	/**
	 * 查询商品退货结算
	 * 
	 * @param po
	 * @param start
	 * @param size
	 * @return
	 */
	public List<InventoryPo> getReturnMerchandiseSettlementList(InventoryPo po,
			int start, int size);

	/**
	 *商品退货结算详细
	 * 
	 * @param po
	 * @return
	 */
	public InventoryPo getReturnMerchandiseSettlement(InventoryPo po);

	/**
	 * 遍历商品退货结算信息
	 * 
	 * @param po
	 * @return
	 */
	public List<InventoryEntryPo> getReturnMerchandiseSettlementEntryList(
			InventoryPo po);

	/**
	 * 修改商品退货结算
	 * 
	 * @param po
	 */
	public void updateReturnMerchandiseSettlement(InventoryPo po,
			List<InventoryEntryPo> list);

}
