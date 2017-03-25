package com.pengsheng.eims.storage.mgr.impl;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import com.pengsheng.eims.sales.dao.GuitarManagementDao;
import com.pengsheng.eims.sales.persistence.InTransitStorageEntryPo;
import com.pengsheng.eims.sales.persistence.InTransitStorageTypePo;
import com.pengsheng.eims.storage.dao.SalesOutDao;
import com.pengsheng.eims.storage.dao.StrogeChangeDao;
import com.pengsheng.eims.storage.mgr.SalesOutMgr;
import com.pengsheng.eims.storage.persistence.AllocationBarcodePo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.storage.persistence.StrogeChangePo;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.components.dao.InTransitDetailsDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;

public class SalesOutMgrImpl extends BaseJdbcDaoSupport implements SalesOutMgr {
	private SystemParameterMgr systemParameterMgr;
	private LogisticsLogDao logisticsLogDao;
	private GuitarManagementDao guitarManagementDao;
	private InTransitDetailsDao inTransitDetailsDao = null;
	
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
	public SystemParameterMgr getSystemParameterMgr() {
		return systemParameterMgr;
	}
	public void setSystemParameterMgr(SystemParameterMgr systemParameterMgr) {
		this.systemParameterMgr = systemParameterMgr;
	}
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}
	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	private SalesOutDao salesOutDao;
	
	private StrogeChangeDao strogeChangeDao;

	public StrogeChangeDao getStrogeChangeDao() {
		return strogeChangeDao;
	}

	public void setStrogeChangeDao(StrogeChangeDao strogeChangeDao) {
		this.strogeChangeDao = strogeChangeDao;
	}

	public int getSalesOutCount(InventoryPo po) {
		return salesOutDao.getSalesOutCount(po);
	}

	public List<InventoryPo> getSalesOutList(InventoryPo po,
			int start, int size) {

		return salesOutDao.getSalesOutList(po, start, size);
	}

	public void insertSalesOut(InventoryPo po,List<InventoryEntryPo> list,List<AllocationBarcodePo> allocationBarcodeList,LogisticsLogPo logPo) {
		
		salesOutDao.insertSalesOut(po);// 单据主表
		if("1".equals(po.getCstiauditstate()))
		{
			if(!"".equals(po.getCstisourcebillid()))
			{
				salesOutDao.insertAllocationStatus(po);
			}
		}	
		Iterator<InventoryEntryPo> it = list.iterator();
		while (it.hasNext()) {
			InventoryEntryPo entryPo = it.next();
			String uuid = this.uuid.generate();
			entryPo.setCstieid(uuid);
			entryPo.setCstieoutstockid(po.getCstioutstockid());//发出仓位
			salesOutDao.insertSalesOutEntry(entryPo);// 单据明细表
			if("1".equals(Utility.getName(po.getCstiauditstate()))){
				StrogeChangePo changePo=new StrogeChangePo();
				changePo.setCshscgoodsid(entryPo.getCstiegoodsid());
				changePo.setCshscgoodsbarcode(entryPo.getCstiegoodsid().replace(".", ""));
				changePo.setCshscstockid(entryPo.getCstieoutstockid());
				if("-".equals(entryPo.getCstiegoodsquantity().toString().substring(0, 1))){
					changePo.setCshscgoodsquantity(entryPo.getCstiegoodsquantity().substring(1));
				}else{
					changePo.setCshscgoodsquantity("-"+entryPo.getCstiegoodsquantity());
				}
				
				changePo.setCshsccostprice(entryPo.getCstiecostprice());
				changePo.setCshscnottaxrate(entryPo.getCstienottaxrate());
				changePo.setCshscchangeid(po.getCstibillid());
				strogeChangeDao.insertStrogeChange(changePo);//商品库存当月库存变更表
			}
			
			if("1".equals(Utility.getName(po.getCstiauditstate()))){
				StrogeChangePo changePo = new StrogeChangePo();
				changePo.setCshscgoodsid(entryPo.getCstiegoodsid());
				changePo.setCshscgoodsbarcode(entryPo.getCstiegoodsid().replace(".", ""));
				changePo.setCshscstockid(entryPo.getCstieoutstockid());
				
				BigDecimal bg = new BigDecimal(Utility.getName(entryPo.getCstietaxrate()));
				bg = bg.multiply(new BigDecimal(0.01)).add(new BigDecimal(1));
				
				BigDecimal bg2 = new BigDecimal(Utility.getName(entryPo.getCstienottaxrate()));
				bg2 = bg2.multiply(bg).setScale(2, BigDecimal.ROUND_HALF_UP);
				
				changePo.setCshsccostprice(bg2.toString());
				changePo.setCshscnottaxrate(entryPo.getCstienottaxrate());	
			
				changePo.setCshscchangeid(po.getCstibillid());
				if("-".equals(entryPo.getCstiegoodsquantity().toString().substring(0, 1))){
					changePo.setCshscgoodsquantity(entryPo.getCstiegoodsquantity().substring(1));
				}else{
					changePo.setCshscgoodsquantity("-" + entryPo.getCstiegoodsquantity());
				}				
				
				strogeChangeDao.insertStrogeChangeLog(changePo, Utility.getName(entryPo.getCstiebarcode()));// 商品库存当月库存变更表
				strogeChangeDao.insertStrogeChangeLogTemp(changePo, Utility.getName(entryPo.getCstiebarcode()));// 商品库存当月库存变更表(9张新表)
			}
			
			InTransitStorageTypePo inTransitStorageTypePo = inTransitDetailsDao.getInTransitStorageSwitch("8");  //
			if (Utility.getName(inTransitStorageTypePo.getCshstinenabled()).equals("1")){
				if (!"1".equals(Utility.getName(po.getCstiauditstate()))) {
					//不是定制片，需插入在途库存
					if(!Utility.getName(entryPo.getCstiegoodsid()).equals("")&&!Utility.getName(entryPo.getCstiegoodsid()).substring(8,9).equals("D")){
						InTransitStorageEntryPo outipo = new InTransitStorageEntryPo();
						BigDecimal bg = new BigDecimal(entryPo.getCstiegoodsquantity());
						bg = bg.multiply(new BigDecimal(-1));

						outipo.setCshtsemoduleid("8");
						outipo.setCshtsebillid(po.getCstibillid());
						
						outipo.setCshtsegoodsID(entryPo.getCstiegoodsid());
						outipo.setCshtseoutstockid(entryPo.getCstieoutstockid());
						outipo.setCshtsedepartmenttype(po.getCstidepartmentid());
						outipo.setCshtsegoodsNum(bg.toString());
						outipo.setCshtsegoodsbarcode(entryPo.getCstiebarcode());
						outipo.setCshtseinoroutStock("2");
						
						guitarManagementDao.deleteInTransitStroge(outipo);
						
						outipo.setCshtseentryid(uuid);
						guitarManagementDao.insertInTransitStroge(outipo);
					}
				}else{
					InTransitStorageEntryPo outipo = new InTransitStorageEntryPo();
					
					outipo.setCshtsebillid(po.getCstibillid());
					guitarManagementDao.deleteInTransitStroge(outipo);
				}
			}

		}
		logisticsLogDao.insertLog(logPo); //添加日志
	}

	public void updateSalesOut(InventoryPo po,List<InventoryEntryPo> list,List<AllocationBarcodePo> allocationBarcodeList,LogisticsLogPo logPo) 
	{
		salesOutDao.updateSalesOut(po);//单据主表
		salesOutDao.deleteSalesOutEntry(po);//删除单据明细表
		salesOutDao.deleteGoodsBarCode(po);//删除条码表
		if("1".equals(po.getCstiauditstate()))
		{
			if(!"".equals(po.getCstisourcebillid()))
			{
				salesOutDao.insertAllocationStatus(po);
			}
		}
		
		InTransitStorageEntryPo outipo2 = new InTransitStorageEntryPo();
		outipo2.setCshtsebillid(po.getCstibillid());
		guitarManagementDao.deleteInTransitStroge(outipo2);
		
		Iterator<InventoryEntryPo> it=list.iterator();
		while(it.hasNext()){
			InventoryEntryPo entryPo=it.next();
			String uuid = this.uuid.generate();
			entryPo.setCstieid(uuid);
			entryPo.setCstieoutstockid(po.getCstioutstockid());//发出仓位
			
			salesOutDao.insertSalesOutEntry(entryPo);//单据明细表
			if("1".equals(Utility.getName(po.getCstiauditstate()))){
				StrogeChangePo changePo=new StrogeChangePo();
				changePo.setCshscgoodsid(entryPo.getCstiegoodsid());
				changePo.setCshscgoodsbarcode(entryPo.getCstiegoodsid().replace(".", ""));
				changePo.setCshscstockid(entryPo.getCstieoutstockid());
				if("-".equals(entryPo.getCstiegoodsquantity().substring(0,1).toString())){
					changePo.setCshscgoodsquantity(entryPo.getCstiegoodsquantity().substring(1));
				}else{
					changePo.setCshscgoodsquantity("-"+entryPo.getCstiegoodsquantity());
				}
					
				changePo.setCshsccostprice(entryPo.getCstiecostprice());
				changePo.setCshscnottaxrate(entryPo.getCstienottaxrate());
				changePo.setCshscchangeid(po.getCstibillid());
				strogeChangeDao.insertStrogeChange(changePo);//商品库存当月库存变更表
			}
			
			if("1".equals(Utility.getName(po.getCstiauditstate()))){
				StrogeChangePo changePo=new StrogeChangePo();
				changePo.setCshscgoodsid(entryPo.getCstiegoodsid());
				changePo.setCshscgoodsbarcode(entryPo.getCstiegoodsid().replace(".", ""));
				changePo.setCshscstockid(entryPo.getCstieoutstockid());
				if("-".equals(entryPo.getCstiegoodsquantity().toString().substring(0,1))){
					changePo.setCshscgoodsquantity(entryPo.getCstiegoodsquantity().substring(1));
				}else{
					changePo.setCshscgoodsquantity("-"+entryPo.getCstiegoodsquantity());
				}				

				BigDecimal bg = new BigDecimal(Utility.getName(entryPo.getCstietaxrate()));
				bg = bg.multiply(new BigDecimal(0.01)).add(new BigDecimal(1));
				
				BigDecimal bg2 = new BigDecimal(Utility.getName(entryPo.getCstienottaxrate()));
				bg2 = bg2.multiply(bg).setScale(2, BigDecimal.ROUND_HALF_UP);
				
				changePo.setCshsccostprice(bg2.toString());
				changePo.setCshscnottaxrate(entryPo.getCstienottaxrate());	
				
				changePo.setCshscchangeid(po.getCstibillid());

				strogeChangeDao.insertStrogeChangeLog(changePo, Utility.getName(entryPo.getCstiebarcode()));// 商品库存当月库存变更表
				strogeChangeDao.insertStrogeChangeLogTemp(changePo, Utility.getName(entryPo.getCstiebarcode()));// 商品库存当月库存变更表(9张新表)
			}
			
			InTransitStorageTypePo inTransitStorageTypePo = inTransitDetailsDao.getInTransitStorageSwitch("8");  //
			if (Utility.getName(inTransitStorageTypePo.getCshstinenabled()).equals("1")){
				if (!"1".equals(Utility.getName(po.getCstiauditstate()))) {
					//不是定制片，需插入在途库存
					if(!Utility.getName(entryPo.getCstiegoodsid()).equals("")&&!Utility.getName(entryPo.getCstiegoodsid()).substring(8,9).equals("D")){
						InTransitStorageEntryPo outipo = new InTransitStorageEntryPo();
						BigDecimal bg = new BigDecimal(entryPo.getCstiegoodsquantity());
						bg = bg.multiply(new BigDecimal(-1));
						
						outipo.setCshtsemoduleid("8");
						outipo.setCshtsebillid(po.getCstibillid());
						
						outipo.setCshtsegoodsID(entryPo.getCstiegoodsid());
						outipo.setCshtseoutstockid(entryPo.getCstieoutstockid());
						outipo.setCshtsedepartmenttype(po.getCstidepartmentid());
						outipo.setCshtsegoodsNum(bg.toString());
						outipo.setCshtsegoodsbarcode(entryPo.getCstiebarcode());
						outipo.setCshtseinoroutStock("2");
						
						guitarManagementDao.deleteInTransitStroge(outipo);
						
						outipo.setCshtseentryid(uuid);
						guitarManagementDao.insertInTransitStroge(outipo);
					}
				}else{
					InTransitStorageEntryPo outipo = new InTransitStorageEntryPo();
					
					outipo.setCshtsebillid(po.getCstibillid());
					guitarManagementDao.deleteInTransitStroge(outipo);
				}
			}

		}
		
		logisticsLogDao.insertLog(logPo); //添加日志
	}

	public InventoryPo getSalesOut(InventoryPo po) {

		return salesOutDao.getSalesOut(po);
	}

	public void deleteSalesOut(InventoryPo po,LogisticsLogPo logPo) {

		salesOutDao.deleteSalesOut(po);
		salesOutDao.deleteSalesOutEntry(po);
		salesOutDao.deleteGoodsBarCode(po);
		
		InTransitStorageEntryPo outipo = new InTransitStorageEntryPo();
		outipo.setCshtsebillid(po.getCstibillid());
		guitarManagementDao.deleteInTransitStroge(outipo);
		
		logisticsLogDao.insertLog(logPo); //添加日志

	}
	public List<InventoryEntryPo> getReallocationList(InventoryPo po)
	{
		return salesOutDao.getReallocationList(po);
	}

	public SalesOutDao getSalesOutDao() {
		return salesOutDao;
	}

	public void setSalesOutDao(
			SalesOutDao salesOutDao) {
		this.salesOutDao = salesOutDao;
	}

	public List<InventoryEntryPo> getSalesOutEntryList(InventoryPo po) {
		return this.salesOutDao.getSalesOutEntryList(po);
	}
	/**
	 * 获取业务单据商品条码
	 * @param po
	 * @return
	 */
	public List<AllocationBarcodePo> getInventoryBarcode(InventoryPo po)
	{
		return salesOutDao.getInventoryBarcode(po);
	}
}
