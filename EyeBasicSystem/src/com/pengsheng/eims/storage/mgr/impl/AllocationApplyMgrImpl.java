package com.pengsheng.eims.storage.mgr.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.dao.AllocationApplyDao;
import com.pengsheng.eims.storage.dao.ProcurementReceiptDao;
import com.pengsheng.eims.storage.dao.StrogeChangeDao;
import com.pengsheng.eims.storage.mgr.AllocationApplyMgr;
import com.pengsheng.eims.storage.persistence.AllocationBarcodePo;
import com.pengsheng.eims.storage.persistence.AllocationEntryPo;
import com.pengsheng.eims.storage.persistence.AllocationPo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.storage.persistence.StrogeChangePo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.SmsLertsPo;

public class AllocationApplyMgrImpl implements AllocationApplyMgr {
	
	private AllocationApplyDao allocationApplyDao = null;
	
	private ProcurementReceiptDao procurementReceiptDao;
	
	public ProcurementReceiptDao getProcurementReceiptDao() {
		return procurementReceiptDao;
	}
	public void setProcurementReceiptDao(ProcurementReceiptDao procurementReceiptDao) {
		this.procurementReceiptDao = procurementReceiptDao;
	}
	private StrogeChangeDao strogeChangeDao;

	public StrogeChangeDao getStrogeChangeDao() {
		return strogeChangeDao;
	}
	public void setStrogeChangeDao(StrogeChangeDao strogeChangeDao) {
		this.strogeChangeDao = strogeChangeDao;
	}
	
	public int getAllocationCount(AllocationPo po,DepartmentsPo departmentsPo) {
		
		return allocationApplyDao.getAllocationCount(po,departmentsPo);
	}
	public AllocationApplyDao getAllocationApplyDao() {
		return allocationApplyDao;
	}
	public void setAllocationApplyDao(AllocationApplyDao allocationApplyDao) {
		this.allocationApplyDao = allocationApplyDao;
	}
	public List<AllocationPo> getAllocationList(AllocationPo po, DepartmentsPo departmentsPo,int start,
			int size) {
		
		return allocationApplyDao.getAllocationList(po,departmentsPo, start, size);
	}
	
	public int getReAllocationCount(AllocationPo po,DepartmentsPo departmentsPo) {
		
		return allocationApplyDao.getReAllocationCount(po,departmentsPo);
	}
	public List<AllocationPo> getReAllocationList(AllocationPo po, DepartmentsPo departmentsPo,int start,
			int size) {
		
		return allocationApplyDao.getReAllocationList(po,departmentsPo, start, size);
	}
	
	private LogisticsLogDao logisticsLogDao;
	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	public void insertAllocation(AllocationPo po, List<AllocationEntryPo> list,SmsLertsPo smsLertsPo,List<PersonInfoPo> personInfoList,List<AllocationBarcodePo> allocationBarcodeList,LogisticsLogPo logPo) {
		allocationApplyDao.insertAllocation(po);//新增调拨申请主表
		if("1".equals(po.getCshaaauditstate()))
		{
			allocationApplyDao.insertAllocationStatus(po);
		}
		Iterator<AllocationEntryPo> it=list.iterator();
		while(it.hasNext()){
			AllocationEntryPo entryPo=it.next();
			allocationApplyDao.insertAllocationEntry(entryPo);//新增调拨明细表
		}
	}
	
	public void updateAllocation(AllocationPo po, List<AllocationEntryPo> list,SmsLertsPo smsLertsPo,List<PersonInfoPo> personInfoList,List<AllocationBarcodePo> allocationBarcodeList,LogisticsLogPo logPo) {
		logisticsLogDao.insertLog(logPo);  //新增日志
		
		allocationApplyDao.updateAllocation(po);//更新调拨主表
		allocationApplyDao.deleteAllocationEntry(po);//删除调拨明细表
//		allocationApplyDao.deleteAllocationBarcode(po);
		if("1".equals(po.getCshaaauditstate()))
		{
			allocationApplyDao.insertAllocationStatus(po);
		}
		Iterator<AllocationEntryPo> it=list.iterator();
		while(it.hasNext()){
			AllocationEntryPo entryPo=it.next();
			allocationApplyDao.insertAllocationEntry(entryPo);//新增调拨明细表
		}
	}
	
	public void deleteAllocation(AllocationPo po,List<PersonInfoPo> personInfoList,SmsLertsPo smsLertsPo,LogisticsLogPo logPo) {
		logisticsLogDao.insertLog(logPo);  //新增日志
		
		/*if(personInfoList!=null){
			for(int i=0;i<personInfoList.size();i++){
				PersonInfoPo personInfoPo = personInfoList.get(i);
			
				smsLertsPo.setCstslreceiveperson(personInfoPo.getId());
				smsLertsPo.setCstslreceivedepartment(personInfoPo.getDepartmentID());
				smsLertsPo.setCstslflag("0");
				this.allocationApplyDao.insertSms(smsLertsPo);
			}
		}*/
		allocationApplyDao.deleteAllocation(po);//删除调拨主表
		allocationApplyDao.deleteAllocationEntry(po);//删除调拨明细表
		
		
		
		//删除调拨条码批号表
//		allocationApplyDao.deleteAllocationBarcode(po);
	}
	public AllocationPo getAllocation(AllocationPo po) {
		
		return allocationApplyDao.getAllocation(po);
	}
	public List<AllocationEntryPo> getAllocationEntryList(AllocationPo po) {
		
		return allocationApplyDao.getAllocationEntryList(po);
	}
	
	public int getAllocationCount(AllocationPo po){
		
		return allocationApplyDao.getAllocationCount(po);
	}
	/*
	 * (non-Javadoc)确认收货
	 * @see com.pengsheng.eims.storage.mgr.AllocationMgr#updateAllocationReceive(com.pengsheng.eims.storage.persistence.AllocationPo)
	 */
	public void updateAllocationReceive(AllocationPo po,LogisticsLogPo logPo) {
		logisticsLogDao.insertLog(logPo);  //新增日志
		
		allocationApplyDao.updateAllocationReceive(po);//修改收货状态
		
		AllocationPo allocationPo=allocationApplyDao.getAllocation(po);
		InventoryPo inventoryPo=new InventoryPo();
		inventoryPo.setCstibillid(allocationPo.getCshaabillid());
		inventoryPo.setCstibilltypeid("4");
		inventoryPo.setCstiinstockid(allocationPo.getCshaainstockid());
		inventoryPo.setCstioutstockid(allocationPo.getCshaaoutstockid());
		inventoryPo.setCstidepartmentid(allocationPo.getCshaaoutdepartmentid());
		inventoryPo.setCsticreateperson(allocationPo.getCshaacreateperson());
		inventoryPo.setCstibilldate(allocationPo.getCshaabilldate());
		inventoryPo.setCstiauditperson(allocationPo.getCshaaauditperson());
		inventoryPo.setCstiauditdate(allocationPo.getCshaaconsigndate());
		inventoryPo.setCstiauditstate("1");
		inventoryPo.setCstiremark(allocationPo.getCshaaremark());
		
		allocationApplyDao.insertAllocationForInventory(inventoryPo);//写入业务单据主表
		
		List<AllocationEntryPo> allocationEntryList=allocationApplyDao.getAllocationEntryList(po);
		Iterator<AllocationEntryPo> iter=allocationEntryList.iterator();
		while(iter.hasNext()){
			AllocationEntryPo allocationEntryPo=iter.next();
			
			InventoryEntryPo inventoryEntryPo=new InventoryEntryPo();
			inventoryEntryPo.setCstiebillid(allocationEntryPo.getCshaaebillid());
			inventoryEntryPo.setCstiegoodsid(allocationEntryPo.getCshaaegoodsid());
			inventoryEntryPo.setCstiegoodsquantity("1");
			inventoryEntryPo.setCstieoutstockid(allocationEntryPo.getCshaaoutstockid());
			inventoryEntryPo.setCstieinstockid(allocationEntryPo.getCshaainstockid());			
			inventoryEntryPo.setCstienottaxrate(allocationEntryPo.getCshaaenottaxrate());
			inventoryEntryPo.setCstietaxrate(allocationEntryPo.getCshaaetaxrate());
			inventoryEntryPo.setCstiecostprice(allocationEntryPo.getCshaaecostprice());
			inventoryEntryPo=getAllocationEntryPo(inventoryEntryPo);//处理 成本合计(不含税)、价税合计、税额合计
			
			
			List<AllocationBarcodePo> allocationBarcodePos = allocationApplyDao.getAllocationBarcode(po,allocationEntryPo.getCshaaegoodsid());
			
			for(int i=0;i<allocationBarcodePos.size();i++){
				inventoryEntryPo.setCstiebarcode(allocationBarcodePos.get(i).getCshabgoodsbarcode());
				allocationApplyDao.insertAllocationForInventoryEntry(inventoryEntryPo);//写入业务单据明细表
			}
			
			StrogeChangePo inchangePo=new StrogeChangePo();
			inchangePo.setCshscgoodsid(allocationEntryPo.getCshaaegoodsid());
			inchangePo.setCshscgoodsbarcode(allocationEntryPo.getCshaaegoodsBarCode());
			inchangePo.setCshscstockid(allocationEntryPo.getCshaainstockid());
			inchangePo.setCshscgoodsquantity(allocationEntryPo.getCshaaeallocationquantity());
			inchangePo.setCshsccostprice(allocationEntryPo.getCshaaecostprice());
			inchangePo.setCshscnottaxrate(allocationEntryPo.getCshaaenottaxrate());
			inchangePo.setCshscchangeid(allocationEntryPo.getCshaaebillid());
			strogeChangeDao.insertStrogeChange(inchangePo);//商品库存当月库存变更表 收入仓位
			
			StrogeChangePo inchangeLogPo=new StrogeChangePo();
			inchangeLogPo.setCshscgoodsid(allocationEntryPo.getCshaaegoodsid());
			inchangeLogPo.setCshscgoodsbarcode(allocationEntryPo.getCshaaegoodsBarCode());
			inchangeLogPo.setCshscstockid(allocationEntryPo.getCshaainstockid());
			inchangeLogPo.setCshscgoodsquantity("1");
			inchangeLogPo.setCshsccostprice(allocationEntryPo.getCshaaecostprice());
			inchangeLogPo.setCshscnottaxrate(allocationEntryPo.getCshaaenottaxrate());
			inchangeLogPo.setCshscchangeid(allocationEntryPo.getCshaaebillid());
			for(int i=0;i<allocationBarcodePos.size();i++){
				if(allocationBarcodePos.size()==1){
					inchangeLogPo.setCshscgoodsquantity(allocationEntryPo.getCshaaeallocationquantity());
				}
				strogeChangeDao.insertStrogeChangeLog(inchangeLogPo,allocationBarcodePos.get(i).getCshabgoodsbarcode());//商品库存当月库存变更日志表 收入仓位
			}
		
			
			StrogeChangePo outchangePo=new StrogeChangePo();
			outchangePo.setCshscgoodsid(allocationEntryPo.getCshaaegoodsid());
			outchangePo.setCshscgoodsbarcode(allocationEntryPo.getCshaaegoodsBarCode());
			outchangePo.setCshscstockid(allocationEntryPo.getCshaaoutstockid());
			outchangePo.setCshscgoodsquantity("-"+allocationEntryPo.getCshaaeallocationquantity());
			outchangePo.setCshsccostprice(allocationEntryPo.getCshaaecostprice());
			outchangePo.setCshscnottaxrate(allocationEntryPo.getCshaaenottaxrate());
			outchangePo.setCshscchangeid(allocationEntryPo.getCshaaebillid());
			strogeChangeDao.insertStrogeChange(outchangePo);//商品库存当月库存变更表 发出仓位
			
			StrogeChangePo outchangeLogPo=new StrogeChangePo();
			outchangeLogPo.setCshscgoodsid(allocationEntryPo.getCshaaegoodsid());
			outchangeLogPo.setCshscgoodsbarcode(allocationEntryPo.getCshaaegoodsBarCode());
			outchangeLogPo.setCshscstockid(allocationEntryPo.getCshaaoutstockid());
			outchangeLogPo.setCshscgoodsquantity("-1");
			outchangeLogPo.setCshsccostprice(allocationEntryPo.getCshaaecostprice());
			outchangeLogPo.setCshscnottaxrate(allocationEntryPo.getCshaaenottaxrate());
			outchangeLogPo.setCshscchangeid(allocationEntryPo.getCshaaebillid());
//			strogeChangeDao.insertStrogeChange(outchangePo);//商品库存当月库存变更表 发出仓位
			for(int i=0;i<allocationBarcodePos.size();i++){
				if(allocationBarcodePos.size()==1){
					outchangeLogPo.setCshscgoodsquantity("-"+allocationEntryPo.getCshaaeallocationquantity());
				}
				strogeChangeDao.insertStrogeChangeLog(outchangeLogPo,allocationBarcodePos.get(i).getCshabgoodsbarcode());
			}
			
		}
		
	}
	
	private InventoryEntryPo getAllocationEntryPo(InventoryEntryPo po){
		
		BigDecimal nottaxrate=new BigDecimal(po.getCstienottaxrate());
		BigDecimal costprice=new BigDecimal(po.getCstiecostprice());		
		BigDecimal goodsquantity=new BigDecimal(po.getCstiegoodsquantity());
		
		BigDecimal one = new BigDecimal("1"); 
		
		BigDecimal nottaxrateamount=nottaxrate.multiply(goodsquantity);
		nottaxrateamount=nottaxrateamount.divide(one, 6, BigDecimal.ROUND_HALF_UP);
		BigDecimal costpriceamount=costprice.multiply(goodsquantity);
		costpriceamount=costpriceamount.divide(one, 2, BigDecimal.ROUND_HALF_UP);
		BigDecimal taxamount=costpriceamount.subtract(nottaxrateamount);
		taxamount=taxamount.divide(one, 2, BigDecimal.ROUND_HALF_UP);
		
		po.setCstienottaxrateamount(nottaxrateamount.toString());
		po.setCstiecostpriceamount(costpriceamount.toEngineeringString());
		po.setCstietaxamount(taxamount.toString());
		
		return po;
	}
	
	public void returnAudit(String billID){
		this.allocationApplyDao.returnAudit(billID);
	}
	
	public void insertSms(SmsLertsPo smsLertsPo,
			List<PersonInfoPo> personInfoList) {
		
	}
	
	public List<AllocationBarcodePo> getAllocationBarcode(
			AllocationPo allocationPo) {
		return this.allocationApplyDao.getAllocationBarcode(allocationPo);
	}
}
