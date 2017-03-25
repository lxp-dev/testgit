package com.pengsheng.eims.logistics.dao;

import java.util.List;

import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;

public interface ProofSelectBillDao {

	/**
	 * 得到业务表信息数量
	 * @param invoicePo
	 * @return
	 */
	public int getSelectBillCount(InventoryPo inventoryPo);
	public int getSalesBillCount(InventoryPo inventoryPo);
	
	/**
	 * 查询业务表信息List
	 * @param invoicePo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<InventoryPo> selectSelectBill(InventoryPo inventoryPo , int start , int size);
	public List<InventoryPo> selSalesOutStorageBill(InventoryPo inventoryPo , int start , int size);
	
	/**
	 * 得到发票信息数量
	 * @param invoicePo
	 * @return
	 */
	public int getSelectInvoice(InventoryPo inventoryPo);
	
	/**
	 * 查询发票信息List
	 * @param invoicePo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<InventoryPo> selectSelectInvoice(InventoryPo inventoryPo , int start , int size);
	
	/**
	 * 得到冲回信息数量
	 * @param 
	 * @return
	 */
	public int getSelectReversal(InventoryPo inventoryPo);
	
	/**
	 * 查询冲回信息List
	 * @param invoicePo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<InventoryPo> selectSelectReversal(InventoryPo inventoryPo , int start , int size);
	
	/**
	 * 详细开窗表头
	 * @param inventoryPo
	 * @return
	 */
	public InventoryPo getBill(InventoryPo inventoryPo);
	
	
	
	/**
	 * 详细开窗表体数量
	 * @param inventoryEntryPo
	 * @return
	 */
	public int getBillEntryCount(InventoryEntryPo inventoryEntryPo);
	
	/**
	 * 详细开窗表体
	 * @param inventoryEntryPo
	 * @return
	 */
	public List<InventoryEntryPo> getBillEntry(InventoryEntryPo inventoryEntryPo , int start , int size);
	public List<InventoryEntryPo> getBillEntry(InventoryEntryPo inventoryEntryPo);
	
	
	/**
	 * 详细发票表头
	 * @param inventoryPo
	 * @return
	 */
	public InventoryPo getInvoice(InventoryPo inventoryPo);
	
	
	
	/**
	 * 详细发票表体数量
	 * @param inventoryEntryPo
	 * @return
	 */
	public int getInvoiceEntryCount(InventoryEntryPo inventoryEntryPo);
	
	/**
	 * 详细发票表体
	 * @param inventoryEntryPo
	 * @return
	 */
	public List<InventoryEntryPo> getInvoiceEntry(InventoryEntryPo inventoryEntryPo , int start , int size);
	public List<InventoryEntryPo> getInvoiceEntry(InventoryEntryPo inventoryEntryPo);
	
	
	/**
	 * 详细冲回表头
	 * @param inventoryPo
	 * @return
	 */
	public InventoryPo getReversal(InventoryPo inventoryPo);
	
	
	/**
	 * 详细冲回表体数量
	 * @param inventoryEntryPo
	 * @return
	 */
	public int getReversalEntryCount(InventoryEntryPo inventoryEntryPo);
	
	/**
	 * 详细冲回表体
	 * @param inventoryEntryPo
	 * @return
	 */
	public List<InventoryEntryPo> getReversalEntry(InventoryEntryPo inventoryEntryPo , int start , int size);
	public List<InventoryEntryPo> getReversalEntry(InventoryEntryPo inventoryEntryPo); 
	
	
	/**
	 * 得到单据明细商品信息
	 * @param inventoryPo
	 * @return
	 */
	public List<InventoryEntryPo> getBillGoods(InventoryPo inventoryPo);
	
	/**
	 * 得到发票明细商品信息
	 * @param inventoryPo
	 * @return
	 */
	public List<InventoryEntryPo> getInvoiceGoods(InventoryPo inventoryPo);
	
	/**
	 * 得到冲回明细商品信息
	 * @param inventoryPo
	 * @return
	 */
	public List<InventoryEntryPo> getReversalGoods(InventoryPo inventoryPo);
	
	
	
	/**
	 * 得到盘盈盘亏总数
	 * 
	 * @param po
	 * @return
	 */
	public int getOveragelossesCount(InventoryPo po);

	/**
	 * 得到盘盈盘亏分页
	 * 
	 * @param po
	 * @param start
	 * @param size
	 * @return
	 */
	public List<InventoryPo> getOveragelossesList(InventoryPo po, int start, int size);
	
	
	/**
	 * 得到盘盈盘亏
	 * 
	 * @param po
	 * @return
	 */
	public InventoryPo getOveragelosses(InventoryPo po);
	
	
	/**
	 * 盘盈盘亏明细总数
	 * 
	 * @param inventoryPo
	 * @return
	 */
	public int getOveragelossesEntryCount(InventoryPo inventoryPo);
	
	
	/**
	 * 盘盈盘亏明细分页
	 * 
	 * @param po
	 * @param start
	 * @param size
	 * @return
	 */
	public List<InventoryEntryPo> getOveragelossesEntryList(InventoryPo po,	int start, int size);
	
	/**
	 * 得到仓位List
	 * @param warehousePo
	 * @return
	 */
	public List<WarehousePo> getWarehouseList(WarehousePo warehousePo);
	public List<WarehousePo> getWarehouseList();
	
}
