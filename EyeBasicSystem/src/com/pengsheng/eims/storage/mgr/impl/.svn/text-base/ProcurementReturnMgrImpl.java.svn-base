package com.pengsheng.eims.storage.mgr.impl;

import java.util.Iterator;
import java.util.List;

import com.pengsheng.eims.basic.dao.SupplierDao;
import com.pengsheng.eims.components.dao.InTransitDetailsDao;
import com.pengsheng.eims.sales.dao.GuitarManagementDao;
import com.pengsheng.eims.sales.persistence.InTransitStorageEntryPo;
import com.pengsheng.eims.sales.persistence.InTransitStorageTypePo;
import com.pengsheng.eims.storage.dao.ProcurementOrdersDao;
import com.pengsheng.eims.storage.dao.ProcurementReturnDao;
import com.pengsheng.eims.storage.dao.StrogeChangeDao;
import com.pengsheng.eims.storage.mgr.ProcurementReturnMgr;
import com.pengsheng.eims.storage.persistence.AllocationBarcodePo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.storage.persistence.StrogeChangePo;
import com.pengsheng.eims.storage.persistence.TracEntryPo;
import com.pengsheng.eims.storage.persistence.TracPo;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;

public class ProcurementReturnMgrImpl extends BaseJdbcDaoSupport implements ProcurementReturnMgr{
	
	private ProcurementOrdersDao procurementOrdersDao;
	private ProcurementReturnDao procurementReturnDao;
	private StrogeChangeDao strogeChangeDao;
	private SupplierDao supplierDao;
	private LogisticsLogDao logisticsLogDao;
	private SystemParameterMgr systemParameterMgr;
	private InTransitDetailsDao inTransitDetailsDao = null;
	private GuitarManagementDao guitarManagementDao;
	
	public GuitarManagementDao getGuitarManagementDao() {
		return guitarManagementDao;
	}
	public void setGuitarManagementDao(GuitarManagementDao guitarManagementDao) {
		this.guitarManagementDao = guitarManagementDao;
	}
	public InTransitDetailsDao getInTransitDetailsDao() {
		return inTransitDetailsDao;
	}
	public void setInTransitDetailsDao(InTransitDetailsDao inTransitDetailsDao) {
		this.inTransitDetailsDao = inTransitDetailsDao;
	}
	public SystemParameterMgr getSystemParameterMgr() {
		return systemParameterMgr;
	}
	public void setSystemParameterMgr(SystemParameterMgr systemParameterMgr) {
		this.systemParameterMgr = systemParameterMgr;
	}
	public ProcurementOrdersDao getProcurementOrdersDao() {
		return procurementOrdersDao;
	}
	public void setProcurementOrdersDao(ProcurementOrdersDao procurementOrdersDao) {
		this.procurementOrdersDao = procurementOrdersDao;
	}		
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}
	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}
	public StrogeChangeDao getStrogeChangeDao() {
		return strogeChangeDao;
	}
	public void setStrogeChangeDao(StrogeChangeDao strogeChangeDao) {
		this.strogeChangeDao = strogeChangeDao;
	}
	public SupplierDao getSupplierDao() {
		return supplierDao;
	}
	public void setSupplierDao(SupplierDao supplierDao) {
		this.supplierDao = supplierDao;
	}
	public int getProcurementReturnCount(InventoryPo po) {
		return procurementReturnDao.getProcurementReturnCount(po);
	}

	public List<InventoryPo> getProcurementReturnList(InventoryPo po,
			int start, int size) {

		return procurementReturnDao.getProcurementReturnList(po, start, size);
	}

	public int getProcurementReturnStorageCount(InventoryPo po) {

		return procurementReturnDao.getProcurementReturnStorageCount(po);
	}

	public List<InventoryPo> getProcurementReturnStorageList(InventoryPo po,
			int start, int size) {

		return procurementReturnDao.getProcurementReturnStorageList(po, start,
				size);
	}

	public void insertProcurementReturn(InventoryPo po,
			List<InventoryEntryPo> list) {

		procurementReturnDao.insertProcurementReturn(po);// 单据主表

		//DecimalFormat format = new DecimalFormat("0.000000");

		Iterator<InventoryEntryPo> it = list.iterator();
		while (it.hasNext()) {
			InventoryEntryPo entryPo = it.next();
			entryPo.setCstieoutstockid(po.getCstioutstockid());// 发出仓位

			procurementReturnDao.insertProcurementReturnEntry(entryPo);// 单据明细表

			if ("1".equals(Utility.getName(po.getCstiauditstate()))) {
				StrogeChangePo changePo = new StrogeChangePo();
				changePo.setCshscgoodsid(entryPo.getCstiegoodsid());
				changePo.setCshscgoodsbarcode(entryPo.getCstiegoodsid()
						.replace(".", ""));
				changePo.setCshscstockid(entryPo.getCstieoutstockid());
				changePo.setCshscgoodsquantity("-"
						+ entryPo.getCstiegoodsquantity());
				changePo.setCshsccostprice(entryPo.getCstiecostprice());
				changePo.setCshscnottaxrate(entryPo.getCstienottaxrate());
				changePo.setCshscchangeid(po.getCstibillid());
				strogeChangeDao.insertStrogeChange(changePo);// 商品库存当月库存变更表
			}

			if ("1".equals(Utility.getName(po.getCstiauditstate()))) {
				StrogeChangePo changePo = new StrogeChangePo();
				changePo.setCshscgoodsid(entryPo.getCstiegoodsid());
				changePo.setCshscgoodsbarcode(entryPo.getCstiegoodsid()
						.replace(".", ""));
				changePo.setCshscstockid(entryPo.getCstieoutstockid());
				changePo.setCshscgoodsquantity("-"
						+ entryPo.getCstiegoodsquantity());
				changePo.setCshsccostprice(entryPo.getCstiecostprice());
				changePo.setCshscnottaxrate(entryPo.getCstienottaxrate());
				changePo.setCshscchangeid(po.getCstibillid());
				strogeChangeDao.insertStrogeChangeLog(changePo, entryPo
						.getCstiepcbarcode());// 商品库存当月库存变更表
			}
		}
	}

	public void updateProcurementReturn(InventoryPo po,
			List<InventoryEntryPo> list,LogisticsLogPo logPo) {

		procurementReturnDao.updateProcurementReturn(po);// 单据主表
		procurementReturnDao.deleteProcurementReturnEntry(po);// 删除单据明细表
				
		Iterator<InventoryEntryPo> it = list.iterator();
		while (it.hasNext()) {
			InventoryEntryPo entryPo = it.next();
			entryPo.setCstieoutstockid(po.getCstioutstockid());// 发出仓位
			entryPo.setBgcretailPrice(inTransitDetailsDao.getSalesGoodsInfo(entryPo.getCstiegoodsid()).getBgiretailprice());
			
			procurementReturnDao.insertProcurementReturnEntry(entryPo);// 单据明细表
			
			if ("1".equals(Utility.getName(po.getCstiauditstate()))) {
				StrogeChangePo changePo = new StrogeChangePo();
				changePo.setCshscgoodsid(entryPo.getCstiegoodsid());
				changePo.setCshscgoodsbarcode(entryPo.getCstiegoodsid()
						.replace(".", ""));
				changePo.setCshscstockid(entryPo.getCstieoutstockid());
				changePo.setCshscgoodsquantity("-"
						+ entryPo.getCstiegoodsquantity());
				changePo.setCshsccostprice(entryPo.getCstiecostprice());
				changePo.setCshscnottaxrate(entryPo.getCstienottaxrate());
				changePo.setCshscchangeid(po.getCstibillid());
				strogeChangeDao.insertStrogeChange(changePo);// 商品库存当月库存变更表
			}

			if ("1".equals(Utility.getName(po.getCstiauditstate()))) {
				StrogeChangePo changePo = new StrogeChangePo();
				changePo.setCshscgoodsid(entryPo.getCstiegoodsid());
				changePo.setCshscgoodsbarcode(entryPo.getCstiegoodsid()
						.replace(".", ""));
				changePo.setCshscstockid(entryPo.getCstieoutstockid());
				changePo.setCshscgoodsquantity("-"
						+ entryPo.getCstiegoodsquantity());
				changePo.setCshsccostprice(entryPo.getCstiecostprice());
				changePo.setCshscnottaxrate(entryPo.getCstienottaxrate());
				changePo.setCshscchangeid(po.getCstibillid());
				strogeChangeDao.insertStrogeChangeLog(changePo, entryPo
						.getCstiepcbarcode());// 商品库存当月库存变更表
			}

		}
		
		if ("1".equals(Utility.getName(po.getCstifinanceauditstate()))){
			inTransitDetailsDao.insertSupplierDealingEntry(po);  // 新增应付款
			
			List<InventoryEntryPo> elist = inTransitDetailsDao.getStorageCostEntryByBillID(po);  // 更新库存表的结算成本
			for (InventoryEntryPo epo : elist){
				inTransitDetailsDao.updateStorageCostEntry(epo);    
			}
		}
		
		logisticsLogDao.insertLog(logPo); //添加日志
	}

	public InventoryPo getProcurementReturn(InventoryPo po) {

		return procurementReturnDao.getProcurementReturn(po);
	}

	public void deleteProcurementReturn(InventoryPo po,LogisticsLogPo logPo) {

		procurementReturnDao.deleteProcurementReturn(po);
		procurementReturnDao.deleteProcurementReturnEntry(po);
		procurementReturnDao.deleteGoodsBarCode(po);
		
		InTransitStorageEntryPo outipo = new InTransitStorageEntryPo();
		outipo.setCshtsebillid(po.getCstibillid());
		guitarManagementDao.deleteInTransitStroge(outipo);
		
		logisticsLogDao.insertLog(logPo); //添加日志

	}
	
	public List<InventoryEntryPo> getAllocationBarcode(String billid){
		return this.procurementReturnDao.getAllocationBarcode(billid);
	}
	
	public List<InventoryEntryPo> getReallocationList(InventoryPo po)
	{
		return procurementReturnDao.getReallocationList(po);
	}

	public ProcurementReturnDao getProcurementReturnDao() {
		return procurementReturnDao;
	}

	public void setProcurementReturnDao(
			ProcurementReturnDao procurementReturnDao) {
		this.procurementReturnDao = procurementReturnDao;
	}

	public List<InventoryEntryPo> getProcurementReturnEntryList(InventoryPo po) {
		return this.procurementReturnDao.getProcurementReturnEntryList(po);
	}

	/**
	 * 新增商品退货单
	 */
	public void insertProcurementReturnStorage(InventoryPo po,
			List<InventoryEntryPo> list,List<AllocationBarcodePo> allocationBarcodeList,LogisticsLogPo logPo) {

		procurementReturnDao.insertProcurementReturn(po);// 单据主表

		if("1".equals(po.getCstiauditstate()))
		{
			if(!"".equals(po.getCstisourcebillid()))
			{
				procurementReturnDao.insertAllocationStatus(po);
			}
		}	
				
		InTransitStorageEntryPo outipo2 = new InTransitStorageEntryPo();
		outipo2.setCshtsebillid(po.getCstibillid());
		guitarManagementDao.deleteInTransitStroge(outipo2);
		
		Iterator<InventoryEntryPo> it = list.iterator();
		while (it.hasNext()) {
			InventoryEntryPo entryPo = it.next();
			entryPo.setCstieoutstockid(po.getCstioutstockid());// 发出仓位
			String uuid = this.uuid.generate();
			entryPo.setCstieid(uuid);
			procurementReturnDao.insertProcurementReturnEntryStorage(entryPo);// 单据明细表

			if ("1".equals(Utility.getName(po.getCstiauditstate()))) {
				StrogeChangePo changePo = new StrogeChangePo();
				changePo.setCshscgoodsid(entryPo.getCstiegoodsid());
				changePo.setCshscgoodsbarcode(entryPo.getCstiegoodsid().replace(".", ""));
				changePo.setCshscstockid(entryPo.getCstieoutstockid());
				changePo.setCshscgoodsquantity("-" + entryPo.getCstiegoodsquantity());
				changePo.setCshsccostprice(entryPo.getCstiecostprice());
				changePo.setCshscnottaxrate(entryPo.getCstienottaxrate());
				changePo.setCshscchangeid(po.getCstibillid());
				strogeChangeDao.insertStrogeChange(changePo);// 商品库存当月库存变更表
			}

			if ("1".equals(Utility.getName(po.getCstiauditstate()))) {
				StrogeChangePo changePo = new StrogeChangePo();
				changePo.setCshscgoodsid(entryPo.getCstiegoodsid());
				changePo.setCshscgoodsbarcode(entryPo.getCstiebarcode());
				changePo.setCshscstockid(entryPo.getCstieoutstockid());
				changePo.setCshsccostprice(entryPo.getCstiecostprice());
				changePo.setCshscnottaxrate(entryPo.getCstienottaxrate());
				changePo.setCshscchangeid(po.getCstibillid());
				changePo.setCshscgoodsquantity("-" + entryPo.getCstiegoodsquantity());
				
				strogeChangeDao.insertStrogeChangeLog(changePo, Utility.getName(entryPo.getCstiebarcode()));// 商品库存当月库存变更表
				strogeChangeDao.insertStrogeChangeLogTemp(changePo, Utility.getName(entryPo.getCstiebarcode()));// 商品库存当月库存变更表(9张新表)
			}
			
			InTransitStorageTypePo inTransitStorageTypePo = inTransitDetailsDao.getInTransitStorageSwitch("2");  // mdxs 表示门店销售
			if (Utility.getName(inTransitStorageTypePo.getCshstinenabled()).equals("1")){
				if (!"1".equals(Utility.getName(po.getCstiauditstate()))) {
					//不是定制片，需插入在途库存
					if(!Utility.getName(entryPo.getCstiegoodsid()).equals("")&&!Utility.getName(entryPo.getCstiegoodsid()).substring(8,9).equals("D")){
						InTransitStorageEntryPo outipo = new InTransitStorageEntryPo();
						outipo.setCshtseentryid(uuid);
						outipo.setCshtsemoduleid("2");
						outipo.setCshtsebillid(po.getCstibillid());
						
						outipo.setCshtsegoodsID(entryPo.getCstiegoodsid());
						outipo.setCshtseoutstockid(entryPo.getCstieoutstockid());
						outipo.setCshtsedepartmenttype(po.getCstidepartmentid());
						outipo.setCshtsegoodsNum("-"+entryPo.getCstiegoodsquantity());
						outipo.setCshtsegoodsbarcode(entryPo.getCstiebarcode());
						outipo.setCshtseinoroutStock("2");
						guitarManagementDao.deleteInTransitStroge(outipo);
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

	public void updateProcurementReturnStorage(InventoryPo po,
			List<InventoryEntryPo> list,List<AllocationBarcodePo> allocationBarcodeList,LogisticsLogPo logPo) {
		
		procurementReturnDao.updateProcurementReturnStorage(po);// 单据主表
		if("1".equals(po.getCstiauditstate()))
		{
			if(!"".equals(po.getCstisourcebillid()))
			{
				procurementReturnDao.insertAllocationStatus(po);
			}
		}	
		procurementReturnDao.deleteProcurementReturnEntry(po);// 删除单据明细表
		procurementReturnDao.deleteGoodsBarCode(po);
		
		InTransitStorageEntryPo outipo1 = new InTransitStorageEntryPo();
		outipo1.setCshtsebillid(po.getCstibillid());
		guitarManagementDao.deleteInTransitStroge(outipo1);
		
		Iterator<InventoryEntryPo> it = list.iterator();
		while (it.hasNext()) {
			InventoryEntryPo entryPo = it.next();
			entryPo.setCstieoutstockid(po.getCstioutstockid());// 发出仓位
			String uuid = this.uuid.generate();
			entryPo.setCstieid(uuid);
			procurementReturnDao.insertProcurementReturnEntryStorage(entryPo);// 单据明细表

			if ("1".equals(Utility.getName(po.getCstiauditstate()))) {
				StrogeChangePo changePo = new StrogeChangePo();
				changePo.setCshscgoodsid(entryPo.getCstiegoodsid());
				changePo.setCshscgoodsbarcode(entryPo.getCstiegoodsid()
						.replace(".", ""));
				changePo.setCshscstockid(entryPo.getCstieoutstockid());
				changePo.setCshscgoodsquantity("-"
						+ entryPo.getCstiegoodsquantity());
				changePo.setCshsccostprice(entryPo.getCstiecostprice());
				changePo.setCshscnottaxrate(entryPo.getCstienottaxrate());
				changePo.setCshscchangeid(po.getCstibillid());
				strogeChangeDao.insertStrogeChange(changePo);// 商品库存当月库存变更表
			}

			if ("1".equals(Utility.getName(po.getCstiauditstate()))) {
				StrogeChangePo changePo = new StrogeChangePo();
				changePo.setCshscgoodsid(entryPo.getCstiegoodsid());
				changePo.setCshscgoodsbarcode(entryPo.getCstiebarcode());
				changePo.setCshscstockid(entryPo.getCstieoutstockid());
				changePo.setCshsccostprice(entryPo.getCstiecostprice());
				changePo.setCshscnottaxrate(entryPo.getCstienottaxrate());
				changePo.setCshscchangeid(po.getCstibillid());
				changePo.setCshscgoodsquantity("-" + entryPo.getCstiegoodsquantity());
				
				strogeChangeDao.insertStrogeChangeLog(changePo, Utility.getName(entryPo.getCstiebarcode()));// 商品库存当月库存变更表
				strogeChangeDao.insertStrogeChangeLogTemp(changePo, Utility.getName(entryPo.getCstiebarcode()));// 商品库存当月库存变更表(9张新表)
			}
			
			InTransitStorageTypePo inTransitStorageTypePo = inTransitDetailsDao.getInTransitStorageSwitch("2");  // mdxs 表示门店销售
			if (Utility.getName(inTransitStorageTypePo.getCshstinenabled()).equals("1")){
				if (!"1".equals(Utility.getName(po.getCstiauditstate()))) {
					//不是定制片，需插入在途库存
					if(!Utility.getName(entryPo.getCstiegoodsid()).equals("")&&!Utility.getName(entryPo.getCstiegoodsid()).substring(8,9).equals("D")){
						InTransitStorageEntryPo outipo = new InTransitStorageEntryPo();
						outipo.setCshtseentryid(uuid);
						outipo.setCshtsemoduleid("2");
						outipo.setCshtsebillid(po.getCstibillid());
						
						outipo.setCshtsegoodsID(entryPo.getCstiegoodsid());
						outipo.setCshtseoutstockid(entryPo.getCstieoutstockid());
						outipo.setCshtsedepartmenttype(po.getCstidepartmentid());
						outipo.setCshtsegoodsNum("-"+entryPo.getCstiegoodsquantity());
						outipo.setCshtsegoodsbarcode(entryPo.getCstiebarcode());
						outipo.setCshtseinoroutStock("2");
						guitarManagementDao.deleteInTransitStroge(outipo);
						guitarManagementDao.insertInTransitStroge(outipo);
					}
				}else{
					InTransitStorageEntryPo outipo = new InTransitStorageEntryPo();
					
					outipo.setCshtsebillid(po.getCstibillid());
					guitarManagementDao.deleteInTransitStroge(outipo);
				}
			}

		}
		
		if(allocationBarcodeList != null){
			for(int i = 0; i < allocationBarcodeList.size(); i++){
				procurementReturnDao.insertGoodsBarCode(allocationBarcodeList.get(i));
			}
		}
		
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	public List<InventoryEntryPo> getStockGoodsForBrand(InventoryPo po){
		return procurementReturnDao.getStockGoodsForBrand(po);
	}
	
	public List<TracEntryPo> getStoreStockGoodsForBrand(TracPo po){
		return procurementReturnDao.getStoreStockGoodsForBrand(po);
	}
	
	/**
	 * 获取业务单据商品条码
	 * @param po
	 * @return
	 */
	public List<AllocationBarcodePo> getInventoryBarcode(InventoryPo po){
		return procurementReturnDao.getInventoryBarcode(po);
	}
}
