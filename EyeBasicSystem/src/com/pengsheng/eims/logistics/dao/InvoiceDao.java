package com.pengsheng.eims.logistics.dao;

import java.util.List;

import com.pengsheng.eims.logistics.persistence.InvoiceEntryPo;
import com.pengsheng.eims.logistics.persistence.InvoicePo;
import com.pengsheng.eims.logistics.persistence.InvoiceTypePo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;

public interface InvoiceDao {
    /**
     * 查询发票总数
     */
	public int getInvoiceCount(InvoicePo invoicePo);
	public List<InvoicePo> getInvoiceList(InvoicePo invoicePo,int start ,int size);
	public void deleteInvoice(InvoicePo invoicePo);
	public InvoicePo getInvocePo(InvoicePo invoicePo);
	
	public void invoiceInsert(InvoicePo invoicePo);
	public void invoiceEntryInsert(InvoiceEntryPo invoiceEntryPo);
	public void invoiceDelete(String invoiceID);
	public void reversalDelete(String invoiceID);
	public void invoiceEntryDelete(String invoiceID);
	public void reversalEntryDelete(String invoiceID);
	public void reversalInsert(String invoiceID);
	//入库
	public void reversalEntryInsert(String invoiceID);
	
	//出库
	public void inventoryUpdate(InventoryPo inventoryPo);
	public void inventoryEntryUpdate(InventoryEntryPo inventoryEntryPo);
	
	public int getInvoiceEntryCount(InvoiceEntryPo invoiceEntryPo);
	public List<InvoiceEntryPo> getInvoiceEntryPoList(InvoiceEntryPo invoiceEntryPo,int start,int size);
	
	/**
	 * 模块：发票管理
	 * 描述：查询发票明细(未分页)
	 * 优化记录：1. szk 2011-08-10
	 *           
	 */
	public List<InvoiceEntryPo> getInvoiceEntryPoList(InvoiceEntryPo invoiceEntryPo);
	public List<InvoiceTypePo> getInvoiceTypeList();
	
	public List<InventoryEntryPo> getBillAndGoodidList(String invoiceID);
//	public void invoiceUpdate(InvoicePo invoicePo);
	
	public List<InvoicePo> getInvoiceEntryOfBills(InvoicePo po);
	public void updateInvoiceState(InvoicePo po);
	
	public void updateInvoiceAbs(InvoicePo po);
	public void updateReversalAbs(InvoicePo po);
	
	public void invoiceAllAudit(InvoicePo po);
	public void invoiceAllUnAudit(InvoicePo invoicePo);
	
	public List<InvoiceEntryPo> getInvoiceBillList(String billID);
	public String getBillByInvoice(String invoiceID);
	public InvoiceEntryPo getInvoceSum(InvoicePo invoicePo);
	public InvoiceEntryPo getInvoiceAmountBySupplierID(InvoicePo invoicePo);
	
	/**
	 * 查询采购单据总数
	 */
	public int getProcurementBillCount(InvoicePo po);
	
	/**
	 * 查询采购单据列表
	 */
	public List<InvoiceEntryPo> getProcurementBillList(InvoicePo po,int start,int size);
	
}
