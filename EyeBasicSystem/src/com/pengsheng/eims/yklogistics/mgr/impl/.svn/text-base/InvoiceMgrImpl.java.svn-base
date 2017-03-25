package com.pengsheng.eims.yklogistics.mgr.impl;

import java.util.Iterator;
import java.util.List;

import com.pengsheng.eims.yklogistics.dao.InvoiceDao;
import com.pengsheng.eims.yklogistics.dao.LogisticsLogDao;
import com.pengsheng.eims.yklogistics.mgr.InvoiceMgr;
import com.pengsheng.eims.logistics.persistence.InvoiceEntryPo;
import com.pengsheng.eims.logistics.persistence.InvoicePo;
import com.pengsheng.eims.logistics.persistence.InvoiceTypePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.util.tools.Utility;

public class InvoiceMgrImpl implements InvoiceMgr {
	
	private InvoiceDao ykinvoiceDao = null;
	private LogisticsLogDao yklogisticsLogDao;	

	public InvoiceDao getYkinvoiceDao() {
		return ykinvoiceDao;
	}

	public void setYkinvoiceDao(InvoiceDao ykinvoiceDao) {
		this.ykinvoiceDao = ykinvoiceDao;
	}

	public LogisticsLogDao getYklogisticsLogDao() {
		return yklogisticsLogDao;
	}

	public void setYklogisticsLogDao(LogisticsLogDao yklogisticsLogDao) {
		this.yklogisticsLogDao = yklogisticsLogDao;
	}

	public void deleteInvoice(InvoicePo invoicePo) {
		ykinvoiceDao.deleteInvoice(invoicePo);
	}

    /**
     * 查询发票总数
     */
	public int getInvoiceCount(InvoicePo invoicePo) {
		return ykinvoiceDao.getInvoiceCount(invoicePo);
	}

    /**
     * 查询发票
     */
	public List<InvoicePo> getInvoiceList(InvoicePo invoicePo,int start,int size) {
		return ykinvoiceDao.getInvoiceList(invoicePo, start, size);
	}

	public InvoicePo getInvocePo(InvoicePo invoicePo) {
		return ykinvoiceDao.getInvocePo(invoicePo);
	}

	public int getInvoiceEntryCount(InvoiceEntryPo invoiceEntryPo) {		
		return ykinvoiceDao.getInvoiceEntryCount(invoiceEntryPo);
	}
	
	public List<InvoiceEntryPo> getInvoiceEntryPoList(InvoiceEntryPo invoiceEntryPo,int start,int size) {
		return ykinvoiceDao.getInvoiceEntryPoList(invoiceEntryPo,start,size);
	}
	
	/**
	 * 模块：发票管理
	 * 描述：查询发票明细(未分页)
	 * 优化记录：1. szk 2011-08-10
	 *           
	 */
	public List<InvoiceEntryPo> getInvoiceEntryPoList(InvoiceEntryPo invoiceEntryPo) {
		return ykinvoiceDao.getInvoiceEntryPoList(invoiceEntryPo);
	}

	
	/**
	 * 模块：发票管理
	 * 描述：新增发票
	 * 优化记录：1. szk 2011-08-10
	 *           
	 */
	public void insertInvoice(InvoicePo invoicePo,InvoiceEntryPo invoiceEntryPo,LogisticsLogPo logPo) {
		boolean flag = false;//用于判定单据类型
		
		//发票主表
		ykinvoiceDao.invoiceInsert(invoicePo);
		
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
			
			ykinvoiceDao.invoiceEntryInsert(temp);
			
			InventoryEntryPo inventoryEntryPo = new InventoryEntryPo();
			inventoryEntryPo.setCstieid(temp.getLieieid());
			inventoryEntryPo.setCstiecheckgoodsquantity(temp.getLieiecheckgoodsquantity());
		    inventoryEntryPo.setIsupdate("");
			
			ykinvoiceDao.inventoryEntryUpdate(inventoryEntryPo);
		}
		
		//插入冲回相关表中
		ykinvoiceDao.reversalInsert(invoicePo.getLiiid());
		ykinvoiceDao.reversalEntryInsert(invoicePo.getLiiid());
		
		if("1".equals(Utility.getName(invoicePo.getLiiauditstatue()))){
			ykinvoiceDao.invoiceAllAudit(invoicePo);
		}		
		
		//更新基表核销状态
		List<InvoicePo> poList = ykinvoiceDao.getInvoiceEntryOfBills(invoicePo);
		if (!poList.isEmpty()){
			Iterator<InvoicePo> it = poList.iterator();
			while (it.hasNext()){
				InvoicePo po = (InvoicePo)it.next();
				ykinvoiceDao.updateInvoiceState(po);
			}
		}
		
		yklogisticsLogDao.insertLog(logPo); //添加日志
	}
	
	public void deleteInvoice(String invoiceID,LogisticsLogPo logPo) {		
		List<InventoryEntryPo> inventoryEntryList = ykinvoiceDao.getBillAndGoodidList(invoiceID);
		Iterator<InventoryEntryPo> it = inventoryEntryList.iterator();
		while(it.hasNext()){
			InventoryEntryPo po = (InventoryEntryPo)it.next();
			po.setIsupdate("");
			ykinvoiceDao.inventoryEntryUpdate(po);
		}
		
		//更新基表核销状态
		InvoicePo invoicePo = new InvoicePo();
		invoicePo.setLiiid(invoiceID);			
		List<InvoicePo> poList = ykinvoiceDao.getInvoiceEntryOfBills(invoicePo);
		if (!poList.isEmpty()){
			Iterator<InvoicePo> its = poList.iterator();
			while (its.hasNext()){
				InvoicePo po = (InvoicePo)its.next();
				ykinvoiceDao.updateInvoiceState(po);
			}
		}
		
		ykinvoiceDao.invoiceDelete(invoiceID);
		ykinvoiceDao.invoiceEntryDelete(invoiceID);
		ykinvoiceDao.reversalDelete(invoiceID);
		ykinvoiceDao.reversalEntryDelete(invoiceID);
		yklogisticsLogDao.insertLog(logPo); //添加日志
	}


	public void updateInvoice(InvoicePo invoicePo, InvoiceEntryPo invoiceEntryPo,LogisticsLogPo logPo) {
//		isDelete = true;
		this.deleteInvoice(invoicePo.getLiiid(),logPo);
		this.insertInvoice(invoicePo, invoiceEntryPo,logPo);
	}
	
//	public void invoiceUpdate(InvoicePo invoicePo){
//		invoiceDao.invoiceUpdate(invoicePo);
//	}
	
	public List<InvoiceTypePo> getInvoiceTypeList(){
		return ykinvoiceDao.getInvoiceTypeList();
	}
	
	public void auditAll(InvoicePo po,LogisticsLogPo logPo){
		ykinvoiceDao.invoiceAllAudit(po);
		yklogisticsLogDao.insertLog(logPo); //添加日志
	}
	
	public void auditUnAll(LogisticsLogPo logPo){
		ykinvoiceDao.invoiceAllUnAudit();
		yklogisticsLogDao.insertLog(logPo); //添加日志
	}
	
	public List<InvoiceEntryPo> getInvoiceBillList(String billID){
		return ykinvoiceDao.getInvoiceBillList(billID);
	}
}
