package com.pengsheng.eims.storage.mgr.impl;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.dao.WholeApplyForAppDao;
import com.pengsheng.eims.storage.dao.ProcurementReceiptDao;
import com.pengsheng.eims.storage.dao.StrogeChangeDao;
import com.pengsheng.eims.storage.mgr.WholeApplyForAppMgr;
import com.pengsheng.eims.storage.persistence.WholeBarcodePo;
import com.pengsheng.eims.storage.persistence.WholeEntryPo;
import com.pengsheng.eims.storage.persistence.WholePo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.storage.persistence.StrogeChangePo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.SmsLertsPo;

public class WholeApplyForAppMgrImpl implements WholeApplyForAppMgr {
	
	private WholeApplyForAppDao wholeApplyForAppDao = null;
	
	private LogisticsLogDao logisticsLogDao;
	
	private ProcurementReceiptDao procurementReceiptDao;
	private StrogeChangeDao strogeChangeDao;
	public void deleteWhole(WholePo po,List<PersonInfoPo> personInfoList,SmsLertsPo smsLertsPo,LogisticsLogPo logPo) {
		logisticsLogDao.insertLog(logPo);  //新增日志
		
		wholeApplyForAppDao.deleteWhole(po);//删除调拨主表
		wholeApplyForAppDao.deleteWholeEntry(po);//删除调拨明细表
		
		
		
		//删除调拨条码批号表
//		wholeApplyDao.deleteWholeBarcode(po);
	}

	public WholePo getWhole(WholePo po) {
		
		return wholeApplyForAppDao.getWhole(po);
	}
	public List<WholeBarcodePo> getWholeBarcode(
			WholePo wholePo) {
		return this.wholeApplyForAppDao.getWholeBarcode(wholePo);
	}
	
	public int getWholeCount(WholePo po){
		
		return wholeApplyForAppDao.getWholeCount(po);
	}
	public int getWholeCount(WholePo po,DepartmentsPo departmentsPo) {
		return wholeApplyForAppDao.getWholeCount(po,departmentsPo);
	}
	
	public List<WholeEntryPo> getWholeEntryList(WholePo po) {
		
		return wholeApplyForAppDao.getWholeEntryList(po);
	}
	private InventoryEntryPo getWholeEntryPo(InventoryEntryPo po){
		
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
	
	public List<WholePo> getWholeList(WholePo po, DepartmentsPo departmentsPo,int start,
			int size) {
		
		return wholeApplyForAppDao.getWholeList(po,departmentsPo, start, size);
	}
	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public ProcurementReceiptDao getProcurementReceiptDao() {
		return procurementReceiptDao;
	}

	public int getReWholeCount(WholePo po,DepartmentsPo departmentsPo) {
		
		return wholeApplyForAppDao.getReWholeCount(po,departmentsPo);
	}
	
	public List<WholePo> getReWholeList(WholePo po, DepartmentsPo departmentsPo,int start,
			int size) {
		
		return wholeApplyForAppDao.getReWholeList(po,departmentsPo, start, size);
	}
	
	public StrogeChangeDao getStrogeChangeDao() {
		return strogeChangeDao;
	}
	public void insertWhole(WholePo po, List<WholeEntryPo> list,SmsLertsPo smsLertsPo,List<PersonInfoPo> personInfoList,List<WholeBarcodePo> wholeBarcodeList,LogisticsLogPo logPo) {
		wholeApplyForAppDao.insertWhole(po);//新增调拨申请主表
		if("1".equals(po.getCshawauditstate()))
		{
			wholeApplyForAppDao.insertWholeStatus(po);
		}
		Iterator<WholeEntryPo> it=list.iterator();
		while(it.hasNext()){
			WholeEntryPo entryPo=it.next();
			wholeApplyForAppDao.insertWholeEntry(entryPo);//新增调拨明细表
		}
	}
	public void insertSms(SmsLertsPo smsLertsPo,
			List<PersonInfoPo> personInfoList) {
		
	}
	
	public void returnAudit(String billID){
		this.wholeApplyForAppDao.returnAudit(billID);
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
	
	public void updateWhole(WholePo po, List<WholeEntryPo> list,SmsLertsPo smsLertsPo,List<PersonInfoPo> personInfoList,List<WholeBarcodePo> wholeBarcodeList,LogisticsLogPo logPo) {
		logisticsLogDao.insertLog(logPo);  //新增日志
		
		wholeApplyForAppDao.updateWhole(po);//更新调拨主表
		wholeApplyForAppDao.deleteWholeEntry(po);//删除调拨明细表
//		wholeApplyDao.deleteWholeBarcode(po);
		if("1".equals(po.getCshawauditstate()))
		{
			wholeApplyForAppDao.insertWholeStatus(po);
		}
		Iterator<WholeEntryPo> it=list.iterator();
		while(it.hasNext()){
			WholeEntryPo entryPo=it.next();
			wholeApplyForAppDao.insertWholeEntry(entryPo);//新增调拨明细表
		}
	}
	
	/*
	 * (non-Javadoc)确认收货
	 * @see com.pengsheng.eims.storage.mgr.WholeMgr#updateWholeReceive(com.pengsheng.eims.storage.persistence.WholePo)
	 */
	public void updateWholeReceive(WholePo po,LogisticsLogPo logPo) {
		logisticsLogDao.insertLog(logPo);  //新增日志
		
		wholeApplyForAppDao.updateWholeReceive(po);//修改收货状态
		
		WholePo wholePo=wholeApplyForAppDao.getWhole(po);
		InventoryPo inventoryPo=new InventoryPo();
		inventoryPo.setCstibillid(wholePo.getCshawbillid());
		inventoryPo.setCstibilltypeid("4");
		inventoryPo.setCstiinstockid(wholePo.getCshawinstockid());
		inventoryPo.setCstioutstockid(wholePo.getCshawoutstockid());
		inventoryPo.setCstidepartmentid(wholePo.getCshawoutdepartmentid());
		inventoryPo.setCsticreateperson(wholePo.getCshawcreateperson());
		inventoryPo.setCstibilldate(wholePo.getCshawbilldate());
		inventoryPo.setCstiauditperson(wholePo.getCshawauditperson());
		inventoryPo.setCstiauditdate(wholePo.getCshawconsigndate());
		inventoryPo.setCstiauditstate("1");
		inventoryPo.setCstiremark(wholePo.getCshawremark());
		
		wholeApplyForAppDao.insertWholeForInventory(inventoryPo);//写入业务单据主表
		
		List<WholeEntryPo> wholeEntryList=wholeApplyForAppDao.getWholeEntryList(po);
		Iterator<WholeEntryPo> iter=wholeEntryList.iterator();
		while(iter.hasNext()){
			WholeEntryPo wholeEntryPo=iter.next();
			
			InventoryEntryPo inventoryEntryPo=new InventoryEntryPo();
			inventoryEntryPo.setCstiebillid(wholeEntryPo.getCshawebillid());
			inventoryEntryPo.setCstiegoodsid(wholeEntryPo.getCshawegoodsid());
			inventoryEntryPo.setCstiegoodsquantity("1");
			inventoryEntryPo.setCstieoutstockid(wholeEntryPo.getCshawoutstockid());
			inventoryEntryPo.setCstieinstockid(wholeEntryPo.getCshawinstockid());			
			inventoryEntryPo.setCstienottaxrate(wholeEntryPo.getCshawenottaxrate());
			inventoryEntryPo.setCstietaxrate(wholeEntryPo.getCshawetaxrate());
			inventoryEntryPo.setCstiecostprice(wholeEntryPo.getCshawecostprice());
			inventoryEntryPo=getWholeEntryPo(inventoryEntryPo);//处理 成本合计(不含税)、价税合计、税额合计
			
			
			List<WholeBarcodePo> wholeBarcodePos = wholeApplyForAppDao.getWholeBarcode(po,wholeEntryPo.getCshawegoodsid());
			
			for(int i=0;i<wholeBarcodePos.size();i++){
				inventoryEntryPo.setCstiebarcode(wholeBarcodePos.get(i).getCshabgoodsbarcode());
				wholeApplyForAppDao.insertWholeForInventoryEntry(inventoryEntryPo);//写入业务单据明细表
			}
			
			StrogeChangePo inchangePo=new StrogeChangePo();
			inchangePo.setCshscgoodsid(wholeEntryPo.getCshawegoodsid());
			inchangePo.setCshscgoodsbarcode(wholeEntryPo.getCshawegoodsBarCode());
			inchangePo.setCshscstockid(wholeEntryPo.getCshawinstockid());
			inchangePo.setCshscgoodsquantity(wholeEntryPo.getCshawewholequantity());
			inchangePo.setCshsccostprice(wholeEntryPo.getCshawecostprice());
			inchangePo.setCshscnottaxrate(wholeEntryPo.getCshawenottaxrate());
			inchangePo.setCshscchangeid(wholeEntryPo.getCshawebillid());
			strogeChangeDao.insertStrogeChange(inchangePo);//商品库存当月库存变更表 收入仓位
			
			StrogeChangePo inchangeLogPo=new StrogeChangePo();
			inchangeLogPo.setCshscgoodsid(wholeEntryPo.getCshawegoodsid());
			inchangeLogPo.setCshscgoodsbarcode(wholeEntryPo.getCshawegoodsBarCode());
			inchangeLogPo.setCshscstockid(wholeEntryPo.getCshawinstockid());
			inchangeLogPo.setCshscgoodsquantity("1");
			inchangeLogPo.setCshsccostprice(wholeEntryPo.getCshawecostprice());
			inchangeLogPo.setCshscnottaxrate(wholeEntryPo.getCshawenottaxrate());
			inchangeLogPo.setCshscchangeid(wholeEntryPo.getCshawebillid());
			for(int i=0;i<wholeBarcodePos.size();i++){
				if(wholeBarcodePos.size()==1){
					inchangeLogPo.setCshscgoodsquantity(wholeEntryPo.getCshawewholequantity());
				}
				strogeChangeDao.insertStrogeChangeLog(inchangeLogPo,wholeBarcodePos.get(i).getCshabgoodsbarcode());//商品库存当月库存变更日志表 收入仓位
			}
		
			
			StrogeChangePo outchangePo=new StrogeChangePo();
			outchangePo.setCshscgoodsid(wholeEntryPo.getCshawegoodsid());
			outchangePo.setCshscgoodsbarcode(wholeEntryPo.getCshawegoodsBarCode());
			outchangePo.setCshscstockid(wholeEntryPo.getCshawoutstockid());
			outchangePo.setCshscgoodsquantity("-"+wholeEntryPo.getCshawewholequantity());
			outchangePo.setCshsccostprice(wholeEntryPo.getCshawecostprice());
			outchangePo.setCshscnottaxrate(wholeEntryPo.getCshawenottaxrate());
			outchangePo.setCshscchangeid(wholeEntryPo.getCshawebillid());
			strogeChangeDao.insertStrogeChange(outchangePo);//商品库存当月库存变更表 发出仓位
			
			StrogeChangePo outchangeLogPo=new StrogeChangePo();
			outchangeLogPo.setCshscgoodsid(wholeEntryPo.getCshawegoodsid());
			outchangeLogPo.setCshscgoodsbarcode(wholeEntryPo.getCshawegoodsBarCode());
			outchangeLogPo.setCshscstockid(wholeEntryPo.getCshawoutstockid());
			outchangeLogPo.setCshscgoodsquantity("-1");
			outchangeLogPo.setCshsccostprice(wholeEntryPo.getCshawecostprice());
			outchangeLogPo.setCshscnottaxrate(wholeEntryPo.getCshawenottaxrate());
			outchangeLogPo.setCshscchangeid(wholeEntryPo.getCshawebillid());
//			strogeChangeDao.insertStrogeChange(outchangePo);//商品库存当月库存变更表 发出仓位
			for(int i=0;i<wholeBarcodePos.size();i++){
				if(wholeBarcodePos.size()==1){
					outchangeLogPo.setCshscgoodsquantity("-"+wholeEntryPo.getCshawewholequantity());
				}
				strogeChangeDao.insertStrogeChangeLog(outchangeLogPo,wholeBarcodePos.get(i).getCshabgoodsbarcode());
			}
			
		}
		
	}

	public WholeApplyForAppDao getWholeApplyForAppDao() {
		return wholeApplyForAppDao;
	}

	public void setWholeApplyForAppDao(
			WholeApplyForAppDao wholeApplyForAppDao) {
		this.wholeApplyForAppDao = wholeApplyForAppDao;
	}
}
