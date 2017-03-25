package com.pengsheng.eims.logistics.mgr.impl;

import java.util.Iterator;
import java.util.List;

import com.pengsheng.eims.logistics.dao.InvoiceDao;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.dao.VoucherDao;
import com.pengsheng.eims.logistics.mgr.InvoiceMgr;
import com.pengsheng.eims.logistics.persistence.InvoiceEntryPo;
import com.pengsheng.eims.logistics.persistence.InvoicePo;
import com.pengsheng.eims.logistics.persistence.InvoiceTypePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.util.bean.UUIDHexGenerator;
import com.pengsheng.eims.util.tools.Utility;

public class InvoiceMgrImpl implements InvoiceMgr {
	
	private InvoiceDao invoiceDao = null;
	private VoucherDao voucherDao = null;
	protected UUIDHexGenerator uuid = UUIDHexGenerator.getInstance();
	
	public VoucherDao getVoucherDao() {
		return voucherDao;
	}
	public void setVoucherDao(VoucherDao voucherDao) {
		this.voucherDao = voucherDao;
	}
	public InvoiceDao getInvoiceDao() {
		return invoiceDao;
	}
	public void setInvoiceDao(InvoiceDao invoiceDao) {
		this.invoiceDao = invoiceDao;
	}
	
	private LogisticsLogDao logisticsLogDao;	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}
	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	public void deleteInvoice(InvoicePo invoicePo) {
		invoiceDao.deleteInvoice(invoicePo);
	}

    /**
     * 查询发票总数
     */
	public int getInvoiceCount(InvoicePo invoicePo) {
		return invoiceDao.getInvoiceCount(invoicePo);
	}

    /**
     * 查询发票
     */
	public List<InvoicePo> getInvoiceList(InvoicePo invoicePo,int start,int size) {
		return invoiceDao.getInvoiceList(invoicePo, start, size);
	}

	public InvoicePo getInvocePo(InvoicePo invoicePo) {
		return invoiceDao.getInvocePo(invoicePo);
	}

	public int getInvoiceEntryCount(InvoiceEntryPo invoiceEntryPo) {		
		return invoiceDao.getInvoiceEntryCount(invoiceEntryPo);
	}
	
	public List<InvoiceEntryPo> getInvoiceEntryPoList(InvoiceEntryPo invoiceEntryPo,int start,int size) {
		return invoiceDao.getInvoiceEntryPoList(invoiceEntryPo,start,size);
	}
	
	/**
	 * 模块：发票管理
	 * 描述：查询发票明细(未分页)
	 * 优化记录：1. szk 2011-08-10
	 *           
	 */
	public List<InvoiceEntryPo> getInvoiceEntryPoList(InvoiceEntryPo invoiceEntryPo) {
		return invoiceDao.getInvoiceEntryPoList(invoiceEntryPo);
	}

	
	/**
	 * 模块：发票管理
	 * 描述：新增发票
	 * 优化记录：1. szk 2011-08-10
	 *           
	 */
	public void insertInvoice(InvoicePo invoicePo,InvoiceEntryPo invoiceEntryPo,String companyID,LogisticsLogPo logPo) {
		boolean flag = false;//用于判定单据类型
		
		
		invoicePo.setLiipaymentday(voucherDao.selCurrentAccountPeriod(companyID).getsLvvDateLowerLimit());		
		//发票主表
		invoiceDao.invoiceInsert(invoicePo);
		
		//从表
		String[] lieiegoodsid = invoiceEntryPo.getLieiegoodsid().split(",");
		if (lieiegoodsid == null){
			return;
		}
		 
		for(int i = 0; i < lieiegoodsid.length; i++){
			InvoiceEntryPo temp = new InvoiceEntryPo();
		    if (invoiceEntryPo.getLieiebillid().split(",")[0].trim().substring(0,4).equalsIgnoreCase("pout")){
		    	flag = false;
		    }else{
		    	flag = true;
		    }
			temp.setLieieid(invoiceEntryPo.getLieieid().split(",")[i].trim());
			temp.setLieiebillid(invoiceEntryPo.getLieiebillid().split(",")[i].trim());
			temp.setLieiecheckgoodsquantity(invoiceEntryPo.getLieiecheckgoodsquantity().split(",")[i].trim());
			temp.setLieiecostprice(invoiceEntryPo.getLieiecostprice().split(",")[i].trim());
			temp.setLieiecostpriceamount(invoiceEntryPo.getLieiecostpriceamount().split(",")[i].trim());
			temp.setLieiegoodsid(lieiegoodsid[i].trim());
			temp.setLieiegoodsname(invoiceEntryPo.getLieiegoodsname().split(",")[i].trim());
			temp.setLieiegoodsquantity(invoiceEntryPo.getLieiegoodsquantity().split(",")[i].trim());
			temp.setLieieinvoiceid(invoicePo.getLiiid().trim());
			temp.setLieietaxrate(invoiceEntryPo.getLieietaxrate().split(",")[i].trim());
			temp.setLieienottaxrate(invoiceEntryPo.getLieienottaxrate().split(",")[i].trim());
			temp.setLieienottaxrateamount(invoiceEntryPo.getLieienottaxrateamount().split(",")[i].trim());
			temp.setLieiespec(invoiceEntryPo.getLieiespec().split(",")[i].trim());
			temp.setLieietaxamount(invoiceEntryPo.getLieietaxamount().split(",")[i].trim());
			
			invoiceDao.invoiceEntryInsert(temp);
			
			InventoryEntryPo inventoryEntryPo = new InventoryEntryPo();
			inventoryEntryPo.setCstieid(temp.getLieieid());
			inventoryEntryPo.setCstiecheckgoodsquantity(temp.getLieiecheckgoodsquantity());
		    inventoryEntryPo.setIsupdate("");
			
			invoiceDao.inventoryEntryUpdate(inventoryEntryPo);
		}
		
		//插入冲回相关表中
		invoiceDao.reversalInsert(invoicePo.getLiiid());
		invoiceDao.reversalEntryInsert(invoicePo.getLiiid());
		
		if("1".equals(Utility.getName(invoicePo.getLiiauditstatue()))){
			invoiceDao.invoiceAllAudit(invoicePo);
		}		
		
		//更新基表核销状态
		List<InvoicePo> poList = invoiceDao.getInvoiceEntryOfBills(invoicePo);
		if (!poList.isEmpty()){
			Iterator<InvoicePo> it = poList.iterator();
			while (it.hasNext()){
				InvoicePo po = (InvoicePo)it.next();
				invoiceDao.updateInvoiceState(po);
			}
		}
		
		logPo.setsLogBillList(Utility.getName(invoiceDao.getBillByInvoice(invoicePo.getLiiid())));
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	public void deleteInvoice(String invoiceID,LogisticsLogPo logPo) {		
		List<InventoryEntryPo> inventoryEntryList = invoiceDao.getBillAndGoodidList(invoiceID);
		Iterator<InventoryEntryPo> it = inventoryEntryList.iterator();
		while(it.hasNext()){
			InventoryEntryPo po = (InventoryEntryPo)it.next();
			po.setIsupdate("");
			invoiceDao.inventoryEntryUpdate(po);
		}
		
		//更新基表核销状态
		InvoicePo invoicePo = new InvoicePo();
		invoicePo.setLiiid(invoiceID);			
		List<InvoicePo> poList = invoiceDao.getInvoiceEntryOfBills(invoicePo);
		if (!poList.isEmpty()){
			Iterator<InvoicePo> its = poList.iterator();
			while (its.hasNext()){
				InvoicePo po = (InvoicePo)its.next();
				invoiceDao.updateInvoiceState(po);
			}
		}
		
		invoiceDao.invoiceDelete(invoiceID);
		invoiceDao.invoiceEntryDelete(invoiceID);
		invoiceDao.reversalDelete(invoiceID);
		invoiceDao.reversalEntryDelete(invoiceID);
		
		if (logPo != null){
			logisticsLogDao.insertLog(logPo); //添加日志
		}
		
	}


	public void updateInvoice(InvoicePo invoicePo, InvoiceEntryPo invoiceEntryPo,String companyID,LogisticsLogPo logPo) {
//		isDelete = true;
		this.deleteInvoice(invoicePo.getLiiid(),null);
		this.insertInvoice(invoicePo, invoiceEntryPo,companyID,logPo);
	}
	
//	public void invoiceUpdate(InvoicePo invoicePo){
//		invoiceDao.invoiceUpdate(invoicePo);
//	}
	
	public List<InvoiceTypePo> getInvoiceTypeList(){
		return invoiceDao.getInvoiceTypeList();
	}
	
	public void auditAll(InvoicePo po,LogisticsLogPo logPo){
		invoiceDao.invoiceAllAudit(po);
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	public void auditUnAll(InvoicePo invoicePo,LogisticsLogPo logPo){
		invoiceDao.invoiceAllUnAudit(invoicePo);
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	public void auditPart(InvoicePo po,LogisticsLogPo logPo){
		invoiceDao.invoiceAllAudit(po);
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	public void auditUnPart(InvoicePo invoicePo,LogisticsLogPo logPo){
		invoiceDao.invoiceAllUnAudit(invoicePo);
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	public List<InvoiceEntryPo> getInvoiceBillList(String billID){
		return invoiceDao.getInvoiceBillList(billID);
	}
	
	public InvoiceEntryPo getInvoceSum(InvoicePo invoicePo){
		return invoiceDao.getInvoceSum(invoicePo);
	}
	
	public InvoiceEntryPo getInvoiceAmountBySupplierID(InvoicePo invoicePo){
		return invoiceDao.getInvoiceAmountBySupplierID(invoicePo);
	}
	
	/**
	 * 查询采购单据总数
	 */
	public int getProcurementBillCount(InvoicePo po){
		return invoiceDao.getProcurementBillCount(po);
	}
	
	/**
	 * 查询采购单据列表
	 */
	public List<InvoiceEntryPo> getProcurementBillList(InvoicePo po,int start,int size){
		return invoiceDao.getProcurementBillList(po,start,size);
	}
	
	public void insertInvoiceByBill(InvoicePo invoicePo,InvoiceEntryPo invoiceEntryPo,String companyID,LogisticsLogPo logPo) {

		invoicePo.setLiipaymentday(voucherDao.selCurrentAccountPeriod(companyID).getsLvvDateLowerLimit());		
		//发票主表
		invoiceDao.invoiceInsert(invoicePo);
		
		//从表
		String[] lieiebillid = invoiceEntryPo.getLieiebillid().split(",");
		if (lieiebillid == null){
			return;
		}
		 
		for(int i = 0; i < lieiebillid.length; i++){
			
			InvoiceEntryPo temp = new InvoiceEntryPo();		
			temp.setLieieinvoiceid(invoicePo.getLiiid().trim());
			temp.setLieiebillid(invoiceEntryPo.getLieiebillid().split(",")[i].trim());
			temp.setLieienottaxrateamount(invoiceEntryPo.getLieienottaxrateamount().split(",")[i].trim());			
			temp.setLieietaxamount(invoiceEntryPo.getLieietaxamount().split(",")[i].trim());
			temp.setLieiecostpriceamount(invoiceEntryPo.getLieiecostpriceamount().split(",")[i].trim());
			
			if (Utility.getName(invoicePo.getLiiisinvoiceform()).equals("2")){
				temp.setLieiesourcenottaxrateamount(invoiceEntryPo.getLieiesourcenottaxrateamount().split(",")[i].trim());			
				temp.setLieiesourcetaxamount(invoiceEntryPo.getLieiesourcetaxamount().split(",")[i].trim());
				temp.setLieiesourcecostpriceamount(invoiceEntryPo.getLieiesourcecostpriceamount().split(",")[i].trim());	
			}
			
			invoiceDao.invoiceEntryInsert(temp);
		}

		if("1".equals(Utility.getName(invoicePo.getLiiauditstatue()))){
			invoiceDao.invoiceAllAudit(invoicePo);
		}		
		
		logPo.setsLogBillList(Utility.getName(invoiceDao.getBillByInvoice(invoicePo.getLiiid())));
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	public void updateInvoiceByBill(InvoicePo invoicePo,InvoiceEntryPo invoiceEntryPo,String companyID,LogisticsLogPo logPo){
		this.deleteInvoiceByBill(invoicePo,null);
		this.insertInvoiceByBill(invoicePo, invoiceEntryPo,companyID,logPo);
	}
	
	public void deleteInvoiceByBill(InvoicePo invoicePo,LogisticsLogPo logPo){
		
		invoiceDao.invoiceDelete(invoicePo.getLiiid());
		invoiceDao.invoiceEntryDelete(invoicePo.getLiiid());
		
		if (logPo != null){
			logisticsLogDao.insertLog(logPo); //添加日志
		}
	}
	
}
