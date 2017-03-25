package com.pengsheng.eims.storage.mgr.impl;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.dao.AllocationApplyDao;
import com.pengsheng.eims.storage.dao.AllocationApplyForAppDao;
import com.pengsheng.eims.storage.dao.ProcurementReceiptDao;
import com.pengsheng.eims.storage.dao.StrogeChangeDao;
import com.pengsheng.eims.storage.mgr.AllocationApplyForAppMgr;
import com.pengsheng.eims.storage.persistence.AllocationBarcodePo;
import com.pengsheng.eims.storage.persistence.AllocationEntryPo;
import com.pengsheng.eims.storage.persistence.AllocationPo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.storage.persistence.StrogeChangePo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.SmsLertsPo;

public class AllocationApplyForAppMgrImpl implements AllocationApplyForAppMgr {
	
	private AllocationApplyForAppDao allocationApplyForAppDao = null;
	
	private LogisticsLogDao logisticsLogDao;
	
	private ProcurementReceiptDao procurementReceiptDao;
	private StrogeChangeDao strogeChangeDao;
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
		allocationApplyForAppDao.deleteAllocation(po);//删除调拨主表
		allocationApplyForAppDao.deleteAllocationEntry(po);//删除调拨明细表
		
		
		
		//删除调拨条码批号表
//		allocationApplyDao.deleteAllocationBarcode(po);
	}

	public AllocationPo getAllocation(AllocationPo po) {
		
		return allocationApplyForAppDao.getAllocation(po);
	}
	public List<AllocationBarcodePo> getAllocationBarcode(
			AllocationPo allocationPo) {
		return this.allocationApplyForAppDao.getAllocationBarcode(allocationPo);
	}
	
	public int getAllocationCount(AllocationPo po){
		
		return allocationApplyForAppDao.getAllocationCount(po);
	}
	public int getAllocationCount(AllocationPo po,DepartmentsPo departmentsPo) {
		
		return allocationApplyForAppDao.getAllocationCount(po,departmentsPo);
	}
	
	public List<AllocationEntryPo> getAllocationEntryList(AllocationPo po) {
		
		return allocationApplyForAppDao.getAllocationEntryList(po);
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
	
	public List<AllocationPo> getAllocationList(AllocationPo po, DepartmentsPo departmentsPo,int start,
			int size) {
		
		return allocationApplyForAppDao.getAllocationList(po,departmentsPo, start, size);
	}
	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public ProcurementReceiptDao getProcurementReceiptDao() {
		return procurementReceiptDao;
	}

	public int getReAllocationCount(AllocationPo po,DepartmentsPo departmentsPo) {
		
		return allocationApplyForAppDao.getReAllocationCount(po,departmentsPo);
	}
	
	public List<AllocationPo> getReAllocationList(AllocationPo po, DepartmentsPo departmentsPo,int start,
			int size) {
		
		return allocationApplyForAppDao.getReAllocationList(po,departmentsPo, start, size);
	}
	
	public StrogeChangeDao getStrogeChangeDao() {
		return strogeChangeDao;
	}
	public void insertAllocation(AllocationPo po, List<AllocationEntryPo> list,SmsLertsPo smsLertsPo,List<PersonInfoPo> personInfoList,List<AllocationBarcodePo> allocationBarcodeList,LogisticsLogPo logPo) {
		allocationApplyForAppDao.insertAllocation(po);//新增调拨申请主表
		if("1".equals(po.getCshaaauditstate()))
		{
			allocationApplyForAppDao.insertAllocationStatus(po);
		}
		Iterator<AllocationEntryPo> it=list.iterator();
		while(it.hasNext()){
			AllocationEntryPo entryPo=it.next();
			allocationApplyForAppDao.insertAllocationEntry(entryPo);//新增调拨明细表
		}
	}
	public void insertSms(SmsLertsPo smsLertsPo,
			List<PersonInfoPo> personInfoList) {
		
	}
	
	public void returnAudit(String billID){
		this.allocationApplyForAppDao.returnAudit(billID);
	}
	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}
	
	public void setProcurementReceiptDao(ProcurementReceiptDao procurementReceiptDao) {
		this.procurementReceiptDao = procurementReceiptDao;
	}
	
	public void setStrogeChangeDao(StrogeChangeDao strogeChangeDao) {
		this.strogeChangeDao = strogeChangeDao;
	}
	
	public void updateAllocation(AllocationPo po, List<AllocationEntryPo> list,SmsLertsPo smsLertsPo,List<PersonInfoPo> personInfoList,List<AllocationBarcodePo> allocationBarcodeList,LogisticsLogPo logPo) {
		logisticsLogDao.insertLog(logPo);  //新增日志
		
		allocationApplyForAppDao.updateAllocation(po);//更新调拨主表
		allocationApplyForAppDao.deleteAllocationEntry(po);//删除调拨明细表
//		allocationApplyDao.deleteAllocationBarcode(po);
		if("1".equals(po.getCshaaauditstate()))
		{
			allocationApplyForAppDao.insertAllocationStatus(po);
		}
		Iterator<AllocationEntryPo> it=list.iterator();
		while(it.hasNext()){
			AllocationEntryPo entryPo=it.next();
			allocationApplyForAppDao.insertAllocationEntry(entryPo);//新增调拨明细表
		}
	}
	
	/*
	 * (non-Javadoc)确认收货
	 * @see com.pengsheng.eims.storage.mgr.AllocationMgr#updateAllocationReceive(com.pengsheng.eims.storage.persistence.AllocationPo)
	 */
	public void updateAllocationReceive(AllocationPo po,LogisticsLogPo logPo) {
		logisticsLogDao.insertLog(logPo);  //新增日志
		
		allocationApplyForAppDao.updateAllocationReceive(po);//修改收货状态
		
		AllocationPo allocationPo=allocationApplyForAppDao.getAllocation(po);
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
		
		allocationApplyForAppDao.insertAllocationForInventory(inventoryPo);//写入业务单据主表
		
		List<AllocationEntryPo> allocationEntryList=allocationApplyForAppDao.getAllocationEntryList(po);
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
			
			
			List<AllocationBarcodePo> allocationBarcodePos = allocationApplyForAppDao.getAllocationBarcode(po,allocationEntryPo.getCshaaegoodsid());
			
			for(int i=0;i<allocationBarcodePos.size();i++){
				inventoryEntryPo.setCstiebarcode(allocationBarcodePos.get(i).getCshabgoodsbarcode());
				allocationApplyForAppDao.insertAllocationForInventoryEntry(inventoryEntryPo);//写入业务单据明细表
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

	public AllocationApplyForAppDao getAllocationApplyForAppDao() {
		return allocationApplyForAppDao;
	}

	public void setAllocationApplyForAppDao(
			AllocationApplyForAppDao allocationApplyForAppDao) {
		this.allocationApplyForAppDao = allocationApplyForAppDao;
	}
	
	/**
	 * 获取调拨单据数量
	 */
	public int getProcurementOrdersForAppCount(AllocationPo po,DepartmentsPo departmentsPo){
		return allocationApplyForAppDao.getProcurementOrdersForAppCount(po, departmentsPo);
	}
	
	/**
	 * 获取调拨单据
	 */
	public List<AllocationPo> getProcurementOrdersForAppList(AllocationPo po,DepartmentsPo departmentsPo, int start,int size){
		return allocationApplyForAppDao.getProcurementOrdersForAppList(po, departmentsPo, start, size);
	}
}
