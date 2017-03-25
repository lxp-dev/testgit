package com.pengsheng.eims.storage.mgr.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.components.dao.InTransitDetailsDao;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.sales.dao.GuitarManagementDao;
import com.pengsheng.eims.sales.persistence.InTransitStorageEntryPo;
import com.pengsheng.eims.sales.persistence.InTransitStorageTypePo;
import com.pengsheng.eims.storage.dao.AllocationDao;
import com.pengsheng.eims.storage.dao.ProcurementReceiptDao;
import com.pengsheng.eims.storage.dao.StrogeChangeDao;
import com.pengsheng.eims.storage.mgr.AllocationMgr;
import com.pengsheng.eims.storage.persistence.AllocationBarcodePo;
import com.pengsheng.eims.storage.persistence.AllocationEntryPo;
import com.pengsheng.eims.storage.persistence.AllocationPo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.storage.persistence.StatusPo;
import com.pengsheng.eims.storage.persistence.StrogeChangePo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.SmsLertsPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.tools.Utility;

public class AllocationMgrImpl implements AllocationMgr {
	private AllocationDao allocationDao = null;
	private InTransitDetailsDao inTransitDetailsDao = null;
	private ProcurementReceiptDao procurementReceiptDao;
	private GuitarManagementDao guitarManagementDao;
	
	public InTransitDetailsDao getInTransitDetailsDao() {
		return inTransitDetailsDao;
	}
	public void setInTransitDetailsDao(InTransitDetailsDao inTransitDetailsDao) {
		this.inTransitDetailsDao = inTransitDetailsDao;
	}
	public GuitarManagementDao getGuitarManagementDao() {
		return guitarManagementDao;
	}
	public void setGuitarManagementDao(GuitarManagementDao guitarManagementDao) {
		this.guitarManagementDao = guitarManagementDao;
	}
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
	public AllocationDao getAllocationDao() {
		return allocationDao;
	}
	public void setAllocationDao(AllocationDao allocationDao) {
		this.allocationDao = allocationDao;
	}
	public int getAllocationCount(AllocationPo po,DepartmentsPo departmentsPo) {
		
		return allocationDao.getAllocationCount(po,departmentsPo);
	}
	public List<AllocationPo> getAllocationList(AllocationPo po, DepartmentsPo departmentsPo,int start,
			int size) {
		
		return allocationDao.getAllocationList(po,departmentsPo, start, size);
	}
	
	public int getReAllocationCount(AllocationPo po,DepartmentsPo departmentsPo) {
		
		return allocationDao.getReAllocationCount(po,departmentsPo);
	}
	public List<AllocationPo> getReAllocationList(AllocationPo po, DepartmentsPo departmentsPo,int start,
			int size) {
		
		return allocationDao.getReAllocationList(po,departmentsPo, start, size);
	}
	
	private LogisticsLogDao logisticsLogDao;
	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	public void insertAllocation(AllocationPo po, List<AllocationEntryPo> list,SmsLertsPo smsLertsPo,List<PersonInfoPo> personInfoList,List<AllocationBarcodePo> allocationBarcodeList,LogisticsLogPo logPo) {
		if(po.getCshaaoutstockid() != po.getCshaainstockid())
		{
			logisticsLogDao.insertLog(logPo);
		
			allocationDao.insertAllocation(po);//新增调拨主表
			
			if("1".equals(po.getCshaaauditstate())){
				if(!"".equals(Utility.getName(po.getCshaabillassociation()))){
					if("PIN".equals(po.getCshaabillassociation().substring(0,3).toString())){
						allocationDao.insertAllocationReceiptStatus(po);
						allocationDao.insertAllocationApplyReceiptStatus(po);
					}
					if("APP".equals(po.getCshaabillassociation().substring(0,3).toString())){
						allocationDao.insertAllocationStatus(po);
						allocationDao.insertAllocationApplyStatus(po);
					}
				}
			}
						
			InTransitStorageTypePo inTransitStorageTypePo = inTransitDetailsDao.getInTransitStorageSwitch("3");
			if (Utility.getName(inTransitStorageTypePo.getCshstinenabled()).equals("1")){
				Iterator<AllocationEntryPo> iter = list.iterator();
				while(iter.hasNext()){
					AllocationEntryPo allocationEntryPo=iter.next();
					//不是定制片，需插入在途库存
					if(!Utility.getName(allocationEntryPo.getCshaaegoodsid()).equals("")&&!Utility.getName(allocationEntryPo.getCshaaegoodsid()).substring(8,9).equals("D")){
						InTransitStorageEntryPo outipo = new InTransitStorageEntryPo();
						
						outipo.setCshtseentryid(allocationEntryPo.getCshaaeid());
						outipo.setCshtsemoduleid("3");
						outipo.setCshtsebillid(allocationEntryPo.getCshaaebillid());
						
						outipo.setCshtsegoodsID(allocationEntryPo.getCshaaegoodsid());
						outipo.setCshtseinstockid(po.getCshaainstockid());
						outipo.setCshtseoutstockid(po.getCshaaoutstockid());
						outipo.setCshtsedepartmenttype(po.getCshaaoutdepartmentid());
						outipo.setCshtsegoodsNum("-"+allocationEntryPo.getCshaaeallocationquantity());
						outipo.setCshtsegoodsbarcode(allocationEntryPo.getCshaaGoodsBarCode());
						outipo.setCshtseinoroutStock("2");
						guitarManagementDao.insertInTransitStroge(outipo);
					}					
				}					
			}
			
			Iterator<AllocationEntryPo> it=list.iterator();
			while(it.hasNext()){
				AllocationEntryPo entryPo=it.next();
				entryPo.setCshaaeoutstorageflag("1");
				
				AllocationEntryPo epo = allocationDao.getGoodsRegistrationNumByBarcode(entryPo);
				entryPo.setCshaaeguaranteeperiod(Utility.getName(epo.getCshaaeguaranteeperiod()));
				entryPo.setCshaaebatch(Utility.getName(epo.getCshaaebatch()));
				entryPo.setCshaaeregistrationnum(Utility.getName(epo.getCshaaeregistrationnum()));
				
				allocationDao.insertAllocationEntry(entryPo);//新增调拨明细表				
			}
			
			if("1".equals(po.getCshaaauditstate())&&"1".equals(po.getCshaaisautoreceipt())){
				List<InventoryEntryPo> inventoryEntryList = new ArrayList<InventoryEntryPo>();
				
				int lenth = list.size();
				for (int i = 0; i < lenth; i++) {			
					InventoryEntryPo inventoryEntryPo = new InventoryEntryPo();	
					inventoryEntryPo.setCstieid(list.get(i).getCshaaeid());
					inventoryEntryPo.setCstiegoodsid(list.get(i).getCshaaegoodsid());			
					inventoryEntryPo.setCstieoutstockid(Utility.getName(po.getCshaaoutstockid()));
					inventoryEntryPo.setCstieoutstorageflag("1");
					inventoryEntryPo.setCstiegoodsquantity(list.get(i).getCshaaeallocationquantity());
					inventoryEntryPo.setCstiebarcode(list.get(i).getCshaaGoodsBarCode());
					
					inventoryEntryList.add(inventoryEntryPo);
				}
				
				po.setCshaaconsignee(Utility.getName(po.getCshaaauditperson()));
				po.setCshaaconsignstate("1");
				
				this.updateAllocationReceive(po,inventoryEntryList,logPo);
			}
		}
	}
	
	public void updateAllocation(AllocationPo po, List<AllocationEntryPo> list,SmsLertsPo smsLertsPo,List<PersonInfoPo> personInfoList,List<AllocationBarcodePo> allocationBarcodeList,LogisticsLogPo logPo) {
		logisticsLogDao.insertLog(logPo);  //新增日志
		
		allocationDao.updateAllocation(po);//更新调拨主表
		
		if("1".equals(po.getCshaaauditstate())){
			if(!"".equals(Utility.getName(po.getCshaabillassociation()))){
				if("PIN".equals(po.getCshaabillassociation().substring(0,3).toString())){
					allocationDao.insertAllocationReceiptStatus(po);
					allocationDao.insertAllocationApplyReceiptStatus(po);
				}
				if("APP".equals(po.getCshaabillassociation().substring(0,3).toString())){
					allocationDao.insertAllocationStatus(po);
					allocationDao.insertAllocationApplyStatus(po);
				}
			}
		}
		
		InTransitStorageEntryPo opo = new InTransitStorageEntryPo();
		opo.setCshtsebillid(po.getCshaabillid());		
		guitarManagementDao.deleteInTransitStroge(opo);
		
		InTransitStorageTypePo inTransitStorageTypePo = inTransitDetailsDao.getInTransitStorageSwitch("3");
		if (Utility.getName(inTransitStorageTypePo.getCshstinenabled()).equals("1")){
			//新增在途库存的商品
			Iterator<AllocationEntryPo> iter = list.iterator();
			while(iter.hasNext()){
				AllocationEntryPo allocationEntryPo=iter.next();
				//不是定制片，需插入在途库存
				if(!Utility.getName(allocationEntryPo.getCshaaegoodsid()).equals("")&&!Utility.getName(allocationEntryPo.getCshaaegoodsid()).substring(8,9).equals("D")){
					InTransitStorageEntryPo outipo = new InTransitStorageEntryPo();
					
					outipo.setCshtseentryid(allocationEntryPo.getCshaaeid());
					outipo.setCshtsemoduleid("3");
					outipo.setCshtsebillid(allocationEntryPo.getCshaaebillid());
					
					outipo.setCshtsegoodsID(allocationEntryPo.getCshaaegoodsid());
					outipo.setCshtseinstockid(po.getCshaainstockid());
					outipo.setCshtseoutstockid(po.getCshaaoutstockid());
					outipo.setCshtsedepartmenttype(po.getCshaaoutdepartmentid());
					outipo.setCshtsegoodsNum("-"+allocationEntryPo.getCshaaeallocationquantity());
					outipo.setCshtsegoodsbarcode(allocationEntryPo.getCshaaGoodsBarCode());
					outipo.setCshtseinoroutStock("2");

					guitarManagementDao.insertInTransitStroge(outipo);
				}
			}
		}
		
		allocationDao.deleteAllocationEntry(po);//删除调拨明细表
		allocationDao.deleteAllocationBarcode(po);
		
		Iterator<AllocationEntryPo> it=list.iterator();
		while(it.hasNext()){
			AllocationEntryPo entryPo=it.next();
			entryPo.setCshaaeoutstorageflag("1");
			
			AllocationEntryPo epo = allocationDao.getGoodsRegistrationNumByBarcode(entryPo);
			entryPo.setCshaaeguaranteeperiod(Utility.getName(epo.getCshaaeguaranteeperiod()));
			entryPo.setCshaaebatch(Utility.getName(epo.getCshaaebatch()));
			entryPo.setCshaaeregistrationnum(Utility.getName(epo.getCshaaeregistrationnum()));
			
			allocationDao.insertAllocationEntry(entryPo);//新增调拨明细表
		}
		
		if("1".equals(po.getCshaaauditstate())&&"1".equals(po.getCshaaisautoreceipt())){
			List<InventoryEntryPo> inventoryEntryList = new ArrayList<InventoryEntryPo>();
			
			int lenth = list.size();
			for (int i = 0; i < lenth; i++) {			
				InventoryEntryPo inventoryEntryPo = new InventoryEntryPo();	
				inventoryEntryPo.setCstieid(list.get(i).getCshaaeid());
				inventoryEntryPo.setCstiegoodsid(list.get(i).getCshaaegoodsid());			
				inventoryEntryPo.setCstieoutstockid(Utility.getName(po.getCshaaoutstockid()));
				inventoryEntryPo.setCstieoutstorageflag("1");
				inventoryEntryPo.setCstiegoodsquantity(list.get(i).getCshaaeallocationquantity());
				inventoryEntryPo.setCstiebarcode(list.get(i).getCshaaGoodsBarCode());
				
				inventoryEntryList.add(inventoryEntryPo);
			}
			
			po.setCshaaconsignee(Utility.getName(po.getCshaaauditperson()));
			po.setCshaaconsignstate("1");
			
			this.updateAllocationReceive(po,inventoryEntryList,logPo);
		}
		
	}
	public void deleteAllocation(AllocationPo po,List<PersonInfoPo> personInfoList,SmsLertsPo smsLertsPo,LogisticsLogPo logPo,AllocationPo tempAllocationPo) {
		logisticsLogDao.insertLog(logPo);  //新增日志
		
		//删除关联
		allocationDao.updateAllocationAppStatus(po);
		allocationDao.deleteAllocationAppStatus(po);
		
		//删除调拨主表
		allocationDao.deleteAllocation(po);
		//删除调拨明细表		
		allocationDao.deleteAllocationEntry(po);		
		//删除调拨条码批号表
		allocationDao.deleteAllocationBarcode(po);

		InTransitStorageEntryPo ipo = new InTransitStorageEntryPo();
		ipo.setCshtsebillid(po.getCshaabillid());
		//删除在途库存
		guitarManagementDao.deleteInTransitStroge(ipo);
		allocationDao.updateAllocationReceive1(tempAllocationPo);
		allocationDao.updateAllocationReceive2(tempAllocationPo);
		
	}
	public AllocationPo getAllocation(AllocationPo po) {
		
		return allocationDao.getAllocation(po);
	}
	public List<AllocationEntryPo> getAllocationEntryList(AllocationPo po) {
		
		return allocationDao.getAllocationEntryList(po);
	}
	
	public List<AllocationEntryPo> getAllocationEntryList2(AllocationPo po) {
		
		return allocationDao.getAllocationEntryList2(po);
	}
	
	public int getAllocationCount(AllocationPo po){
		
		return allocationDao.getAllocationCount(po);
	}
	
	public List<AllocationEntryPo> getApplyList(AllocationPo po)
	{
		return allocationDao.getApplyList(po);
	}
	
	public List<AllocationEntryPo> getReallocationList(AllocationPo po)
	{
		return allocationDao.getReallocationList(po);
	}
	/**
	 * 调拨申请使用状态
	 */
	public void updateAllocationReceive1(AllocationPo po){
		 allocationDao.updateAllocationReceive1(po);
	}
	
	//查询调拨申请商品信息
	public List<AllocationEntryPo> getAlllyList(AllocationPo allocationPo) {
		return allocationDao.getAlllyList(allocationPo);
	}
	
	public List<AllocationEntryPo> getReceiptList(AllocationPo po)
	{
		return allocationDao.getReceiptList(po);
	}
	
	/*
	 * (non-Javadoc)确认收货
	 * @see com.pengsheng.eims.storage.mgr.AllocationMgr#updateAllocationReceive(com.pengsheng.eims.storage.persistence.AllocationPo)
	 */
	public void updateAllocationReceive(AllocationPo po,List<InventoryEntryPo> entryList,LogisticsLogPo logPo) {
		logisticsLogDao.insertLog(logPo);  //新增日志
		
		if (entryList != null && entryList.size() > 0 ){
			for (InventoryEntryPo entryPo : entryList){
				allocationDao.updateAllocationEntryOutStorageFlag(entryPo);
			}
		}
		
		allocationDao.updateAllocationReceive(po);//修改收货状态
		
		AllocationPo allocationPo = allocationDao.getAllocation(po);
		InventoryPo inventoryPo = new InventoryPo();
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
		inventoryPo.setCstiamounttype(Utility.getName(allocationPo.getCshaaamounttype()));
		
		allocationDao.insertAllocationForInventory(inventoryPo);//写入业务单据主表
		
		List<AllocationEntryPo> allocationEntryList = allocationDao.getAllocationEntryList2(po);
		Iterator<AllocationEntryPo> iter = allocationEntryList.iterator();
		while(iter.hasNext()){
			AllocationEntryPo allocationEntryPo=iter.next();
			
			InventoryEntryPo inventoryEntryPo=new InventoryEntryPo();
			inventoryEntryPo.setCstiebillid(allocationEntryPo.getCshaaebillid());
			inventoryEntryPo.setCstiegoodsid(allocationEntryPo.getCshaaegoodsid());
			inventoryEntryPo.setCstiegoodsquantity(allocationEntryPo.getCshaaeallocationquantity());
			inventoryEntryPo.setCstieoutstockid(allocationEntryPo.getCshaaoutstockid());
			inventoryEntryPo.setCstieinstockid(po.getCshaainstockid());			
			inventoryEntryPo.setCstienottaxrate(allocationEntryPo.getCshaaenottaxrate());
			inventoryEntryPo.setCstietaxrate(allocationEntryPo.getCshaaetaxrate());
			inventoryEntryPo.setCstiecostprice(allocationEntryPo.getCshaaecostprice());
			inventoryEntryPo.setCstieoutstorageflag("1");
			inventoryEntryPo=getAllocationEntryPo(inventoryEntryPo);//处理 成本合计(不含税)、价税合计、税额合计
			inventoryEntryPo.setCstiebarcode(allocationEntryPo.getCshaaegoodsBarCode());			
			inventoryEntryPo.setCstieguaranteeperiod(Utility.getName(allocationEntryPo.getCshaaeguaranteeperiod()));  // 效期
			inventoryEntryPo.setCstiebatch(Utility.getName(allocationEntryPo.getCshaaebatch()));  // 批号
			inventoryEntryPo.setCstieregistrationnum(Utility.getName(allocationEntryPo.getCshaaeregistrationnum()));  // 注册证号			
			inventoryEntryPo.setCstiewholesaleprice(Utility.getName(allocationEntryPo.getCshaaewholesaleprice()));  // 批发单价
			inventoryEntryPo.setCstiewholesalepriceamount(Utility.getName(allocationEntryPo.getCshaaewholesalepriceamount()));  // 批发合计
			
			allocationDao.insertAllocationForInventoryEntry(inventoryEntryPo);//写入业务单据明细表
			
			StrogeChangePo inchangePo=new StrogeChangePo();
			inchangePo.setCshscgoodsid(allocationEntryPo.getCshaaegoodsid());
			inchangePo.setCshscgoodsbarcode(allocationEntryPo.getCshaaegoodsBarCode());
			inchangePo.setCshscstockid(po.getCshaainstockid());			
			inchangePo.setCshscgoodsquantity(allocationEntryPo.getCshaaeallocationquantity());
			inchangePo.setCshsccostprice(allocationEntryPo.getCshaaecostprice());
			inchangePo.setCshscnottaxrate(allocationEntryPo.getCshaaenottaxrate());
			inchangePo.setCshscchangeid(allocationEntryPo.getCshaaebillid());
			strogeChangeDao.insertStrogeChange(inchangePo);//商品库存当月库存变更表 收入仓位
			
			StrogeChangePo inchangeLogPo=new StrogeChangePo();
			inchangeLogPo.setCshscgoodsid(allocationEntryPo.getCshaaegoodsid());
			inchangeLogPo.setCshscgoodsbarcode(allocationEntryPo.getCshaaegoodsBarCode());
			inchangeLogPo.setCshscstockid(po.getCshaainstockid());
			inchangeLogPo.setCshscfromstockid(allocationEntryPo.getCshaaoutstockid());
			inchangeLogPo.setCshscgoodsquantity(allocationEntryPo.getCshaaeallocationquantity());
			inchangeLogPo.setCshsccostprice(allocationEntryPo.getCshaaecostprice());
			inchangeLogPo.setCshscnottaxrate(allocationEntryPo.getCshaaenottaxrate());
			inchangeLogPo.setCshscchangeid(allocationEntryPo.getCshaaebillid());
			inchangeLogPo.setCshscgoodsquantity(allocationEntryPo.getCshaaeallocationquantity());
			strogeChangeDao.insertStrogeChangeLog(inchangeLogPo,allocationEntryPo.getCshaaegoodsBarCode());//商品库存当月库存变更日志表 收入仓位
			strogeChangeDao.insertStrogeChangeLogTemp(inchangeLogPo, allocationEntryPo.getCshaaegoodsBarCode());// 商品库存当月库存变更表(9张新表)
			
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
			outchangeLogPo.setCshscfromstockid(po.getCshaainstockid());
			outchangeLogPo.setCshscgoodsquantity("-"+allocationEntryPo.getCshaaeallocationquantity());
			outchangeLogPo.setCshsccostprice(allocationEntryPo.getCshaaecostprice());
			outchangeLogPo.setCshscnottaxrate(allocationEntryPo.getCshaaenottaxrate());
			outchangeLogPo.setCshscchangeid(allocationEntryPo.getCshaaebillid());
			strogeChangeDao.insertStrogeChangeLog(outchangeLogPo,allocationEntryPo.getCshaaegoodsBarCode());
			strogeChangeDao.insertStrogeChangeLogTemp(outchangeLogPo,allocationEntryPo.getCshaaegoodsBarCode());// 商品库存当月库存变更表(9张新表)
		}
			
		InTransitStorageTypePo inTransitStorageTypePo = inTransitDetailsDao.getInTransitStorageSwitch("3");  // 3 调拨
		if (Utility.getName(inTransitStorageTypePo.getCshstindelete()).equals("1")){
			//删除在途库存的商品
			InTransitStorageEntryPo ipo = new InTransitStorageEntryPo();
			ipo.setCshtsebillid(po.getCshaabillid());
			guitarManagementDao.deleteInTransitStroge(ipo);
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
		this.allocationDao.returnAudit(billID);
	}
	
	public void insertSms(SmsLertsPo smsLertsPo,
			List<PersonInfoPo> personInfoList) {
		
	}
	
	public List<AllocationBarcodePo> getAllocationBarcode(
			AllocationPo allocationPo) {
		return this.allocationDao.getAllocationBarcode(allocationPo);
	}
	
	/**
	 * 获取调拨单
	 */
	public StatusPo getStatusPo(StatusPo statusPo){
		return this.allocationDao.getStatusPo(statusPo);
	}
	
	public List<AllocationEntryPo> getAllocationBarcode(String billid){
		return this.allocationDao.getAllocationBarcode(billid);
	}
	
	/**
	 * 获取商品信息
	 */
	public GoodsInfoPo getGoodsInfoPo(GoodsInfoPo po){
		return this.allocationDao.getGoodsInfoPo(po);
	}
	
	public void updateAllocationEntryOutStorageFlag(List<InventoryEntryPo> entryList){		
		for (InventoryEntryPo po : entryList){
			allocationDao.updateAllocationEntryOutStorageFlag(po);
		}		
	}
	
	/**
	 * 收货时判断当前调拨单是否存在
	 */
	public int isExistAllocationBillByID(String billID){
		return allocationDao.isExistAllocationBillByID(billID);
	}
	
	/**
	 * 判断当前库存是否满足调拨条件
	 * @param po
	 * @return
	 */
	public List<GoodsInfoPo> checkNumber(GoodsInfoPo po){
		return allocationDao.checkNumber(po);
	}
	
	public void updateAllocationPrintType(AllocationPo po){
		allocationDao.updateAllocationPrintType(po);
	}
	
	public List<InventoryEntryPo> getAlllyList(String allbillid,String outstockid,String supplieriD){
		return allocationDao.getAlllyList(allbillid,outstockid,supplieriD);
	}
	
	public int getAllocationSettlementCount(AllocationPo po,DepartmentsPo departmentsPo){
		return allocationDao.getAllocationSettlementCount(po,departmentsPo);
	}
	
	public List<AllocationPo> getAllocationSettlementList(AllocationPo po,DepartmentsPo departmentsPo,int start, int size){
		return allocationDao.getAllocationSettlementList(po,departmentsPo,start,size);
	}
	
	public AllocationPo getAllocationSettlement(AllocationPo po){
		return allocationDao.getAllocationSettlement(po);
	}
	
	public List<AllocationEntryPo> getAllocationSettlementEntry(AllocationPo po){
		return allocationDao.getAllocationSettlementEntry(po);
	}
	
	public void updateAllocationSettlementEntry(AllocationPo po,List<InventoryEntryPo> entryList,LogisticsLogPo logPo){
		
		if("1".equals(Utility.getName(po.getCshaaauditstate()))){
			allocationDao.updateAllocationSettlement(po);
		}
		
		allocationDao.updateAllocationSettlementEntry(entryList);
		
		logisticsLogDao.insertLog(logPo);  //新增日志
	}
	
}
