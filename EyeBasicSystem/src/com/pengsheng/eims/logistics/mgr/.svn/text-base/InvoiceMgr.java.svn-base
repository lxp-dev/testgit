package com.pengsheng.eims.logistics.mgr;

import java.util.List;

import com.pengsheng.eims.logistics.persistence.InvoiceEntryPo;
import com.pengsheng.eims.logistics.persistence.InvoicePo;
import com.pengsheng.eims.logistics.persistence.InvoiceTypePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;

public interface InvoiceMgr {
    /**
     * 查询发票总数
     */
	public int getInvoiceCount(InvoicePo invoicePo);
	public List<InvoicePo> getInvoiceList(InvoicePo invoicePo,int start ,int size);
	public void deleteInvoice(InvoicePo invoicePo);
	public InvoicePo getInvocePo(InvoicePo invoicePo);
	public int getInvoiceEntryCount(InvoiceEntryPo invoiceEntryPo);
	public List<InvoiceEntryPo> getInvoiceEntryPoList(InvoiceEntryPo invoiceEntryPo,int start,int size);
	public void insertInvoice(InvoicePo invoicePo,InvoiceEntryPo invoiceEntryPo,String companyID,LogisticsLogPo logPo);
	public void deleteInvoice(String invoiceID,LogisticsLogPo logPo);
	public void updateInvoice(InvoicePo invoicePo,InvoiceEntryPo invoiceEntryPo,String companyID,LogisticsLogPo logPo);
	
	/**
	 * 模块：发票管理
	 * 描述：查询发票明细(未分页)
	 * 优化记录：1. szk 2011-08-10
	 *           
	 */
	public List<InvoiceEntryPo> getInvoiceEntryPoList(InvoiceEntryPo invoiceEntryPo);
	public List<InvoiceTypePo> getInvoiceTypeList();
	
//	public void invoiceUpdate(InvoicePo invoicePo);
	
	public void auditAll(InvoicePo po,LogisticsLogPo logPo);
	public void auditUnAll(InvoicePo invoicePo,LogisticsLogPo logPo);
	
	public List<InvoiceEntryPo> getInvoiceBillList(String billID);
	public InvoiceEntryPo getInvoceSum(InvoicePo invoicePo);
	public InvoiceEntryPo getInvoiceAmountBySupplierID(InvoicePo invoicePo);
	
	public void auditPart(InvoicePo po,LogisticsLogPo logPo);
	public void auditUnPart(InvoicePo invoicePo,LogisticsLogPo logPo);
	
	/**
	 * 查询采购单据总数
	 */
	public int getProcurementBillCount(InvoicePo po);
	
	/**
	 * 查询采购单据列表
	 */
	public List<InvoiceEntryPo> getProcurementBillList(InvoicePo po,int start,int size);
	
	public void insertInvoiceByBill(InvoicePo invoicePo,InvoiceEntryPo invoiceEntryPo,String companyID,LogisticsLogPo logPo);
	
	public void updateInvoiceByBill(InvoicePo invoicePo,InvoiceEntryPo invoiceEntryPo,String companyID,LogisticsLogPo logPo);
	
	public void deleteInvoiceByBill(InvoicePo invoicePo,LogisticsLogPo logPo);
}
