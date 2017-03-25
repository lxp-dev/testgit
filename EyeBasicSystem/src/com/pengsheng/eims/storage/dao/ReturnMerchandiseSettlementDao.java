package com.pengsheng.eims.storage.dao;

import java.util.List;

import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;

public interface ReturnMerchandiseSettlementDao {

	/**
	 * 查询商品退货结算数量
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
	 * 商品退货结算详细
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
	public void updateReturnMerchandiseSettlement(InventoryPo po);

	/**
	 * 修改业务单明细表信息
	 * 
	 * @param po
	 */
	public void updateReturnMerchandiseSettlementEntry(InventoryEntryPo po);

	/**
	 * 采购退货导入订单系统
	 * 
	 * @param poID
	 */
	public void returnimportOrders(String poID);

}
