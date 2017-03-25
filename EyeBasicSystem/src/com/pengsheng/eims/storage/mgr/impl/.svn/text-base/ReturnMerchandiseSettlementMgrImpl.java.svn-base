package com.pengsheng.eims.storage.mgr.impl;

import java.util.Iterator;
import java.util.List;

import com.pengsheng.eims.storage.dao.ReturnMerchandiseSettlementDao;
import com.pengsheng.eims.storage.mgr.ReturnMerchandiseSettlementMgr;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;

public class ReturnMerchandiseSettlementMgrImpl implements
		ReturnMerchandiseSettlementMgr {

	private ReturnMerchandiseSettlementDao returnMerchandiseSettlementDao;

	public ReturnMerchandiseSettlementDao getReturnMerchandiseSettlementDao() {
		return returnMerchandiseSettlementDao;
	}

	public void setReturnMerchandiseSettlementDao(
			ReturnMerchandiseSettlementDao returnMerchandiseSettlementDao) {
		this.returnMerchandiseSettlementDao = returnMerchandiseSettlementDao;
	}

	/**
	 * 商品退货结算详细
	 */
	public InventoryPo getReturnMerchandiseSettlement(InventoryPo po) {

		return returnMerchandiseSettlementDao
				.getReturnMerchandiseSettlement(po);
	}

	/**
	 * 查询采购收货结算数量
	 */
	public int getReturnMerchandiseSettlementCount(InventoryPo po) {

		return returnMerchandiseSettlementDao
				.getReturnMerchandiseSettlementCount(po);
	}

	/**
	 * 遍历商品退货结算信息
	 */
	public List<InventoryEntryPo> getReturnMerchandiseSettlementEntryList(
			InventoryPo po) {

		return returnMerchandiseSettlementDao
				.getReturnMerchandiseSettlementEntryList(po);
	}

	/**
	 * 查询商品退货结算
	 */
	public List<InventoryPo> getReturnMerchandiseSettlementList(InventoryPo po,
			int start, int size) {

		return returnMerchandiseSettlementDao
				.getReturnMerchandiseSettlementList(po, start, size);
	}

	/**
	 * 修改商品退货结算
	 */
	public void updateReturnMerchandiseSettlement(InventoryPo po,
			List<InventoryEntryPo> list) {
		returnMerchandiseSettlementDao.updateReturnMerchandiseSettlement(po);
		Iterator<InventoryEntryPo> it = list.iterator();
		while (it.hasNext()) {
			InventoryEntryPo entryPo = it.next();
			returnMerchandiseSettlementDao
					.updateReturnMerchandiseSettlementEntry(entryPo);
		}

		if ("1".equals(po.getCstifinanceauditstate())) {
			returnMerchandiseSettlementDao.returnimportOrders(po
					.getCstibillid());
		}

	}

}
