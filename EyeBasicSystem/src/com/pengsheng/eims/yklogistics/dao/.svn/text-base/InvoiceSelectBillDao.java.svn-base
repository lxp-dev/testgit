package com.pengsheng.eims.yklogistics.dao;

import java.util.List;

import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;

public interface InvoiceSelectBillDao {
	
	/**
	 * 得到业务表信息数量
	 * @param invoicePo
	 * @return
	 */
	public int getSelectBillCount(InventoryPo inventoryPo);
	public int getSelBillCount(InventoryPo inventoryPo);
	
	/**
	 * 查询业务表信息List
	 * @param invoicePo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<InventoryPo> selectSelectBill(InventoryPo inventoryPo , int start , int size);
	public List<InventoryPo> selSelectBill(InventoryPo inventoryPo , int start , int size);
	
	/**
	 * 查询业务表信息List
	 * @param invoicePo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<InventoryPo> selectSelectBill(InventoryPo inventoryPo);
	
	/**
	 * 详细开窗表头
	 * @param inventoryPo
	 * @return
	 */
	public InventoryPo getBill(InventoryPo inventoryPo);
	
	/**
	 * 详细开窗表体
	 * @param inventoryEntryPo
	 * @return
	 */
	public List<InventoryEntryPo> getBillEntry(InventoryEntryPo inventoryEntryPo);
	
	/**
	 * 得到明细商品信息
	 * @param inventoryPo
	 * @return
	 */
	public List<InventoryEntryPo> getBillGoods(InventoryPo inventoryPo);
	
	public InventoryPo getBillSum(InventoryPo inventoryPo);
	

}
