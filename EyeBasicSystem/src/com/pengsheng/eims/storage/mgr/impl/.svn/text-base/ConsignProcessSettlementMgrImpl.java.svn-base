package com.pengsheng.eims.storage.mgr.impl;

import java.util.Iterator;
import java.util.List;

import com.pengsheng.eims.components.dao.InTransitDetailsDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.dao.ConsignProcessSettlementDao;
import com.pengsheng.eims.storage.mgr.ConsignProcessSettlementMgr;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;


public class ConsignProcessSettlementMgrImpl implements
		ConsignProcessSettlementMgr {
	
	private LogisticsLogDao logisticsLogDao;
	private InTransitDetailsDao inTransitDetailsDao = null;
	
	public InTransitDetailsDao getInTransitDetailsDao() {
		return inTransitDetailsDao;
	}
	public void setInTransitDetailsDao(InTransitDetailsDao inTransitDetailsDao) {
		this.inTransitDetailsDao = inTransitDetailsDao;
	}
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}
	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	private ConsignProcessSettlementDao consignProcessSettlementDao;
	
	public ConsignProcessSettlementDao getConsignProcessSettlementDao() {
		return consignProcessSettlementDao;
	}


	public void setConsignProcessSettlementDao(
			ConsignProcessSettlementDao consignProcessSettlementDao) {
		this.consignProcessSettlementDao = consignProcessSettlementDao;
	}


	/**
	 * 委外收货结算详细
	 * @param po
	 * @return
	 */
	public InventoryPo getConsignProcessSettlement(InventoryPo po) {
		
		return consignProcessSettlementDao.getConsignProcessSettlement(po);
	}


	/**
	 * 查询委外收货结算数量
	 * @param po
	 * @return
	 */
	public int getConsignProcessSettlementCount(InventoryPo po) {
		
		return consignProcessSettlementDao.getConsignProcessSettlementCount(po);
	}


	/**
	 * 显示委外收货结算主表信息并分页
	 * @param po
	 * @param start
	 * @param size
	 * @return
	 */
	public List<InventoryPo> getConsignProcessSettlementList(InventoryPo po,
			int start, int size) {
		
		return consignProcessSettlementDao.getConsignProcessSettlementList(po, start, size);
	}


	/**
	 * 委外收货结算业务单明细表信息
	 * @param po
	 * @return
	 */
	public List<InventoryEntryPo> getConsignProcessSettlementDetailsList(
			InventoryPo po) {
		return this.consignProcessSettlementDao.getConsignProcessSettlementDetailsList(po);
	}


	/**
	 * 修改委外收货结算主表信息
	 * @param po
	 */
	public void updateConsignProcessSettlement(InventoryPo po,
			List<InventoryEntryPo> list,LogisticsLogPo logPo) {
		
		consignProcessSettlementDao.updateConsignProcessSettlement(po);
		
		Iterator<InventoryEntryPo> it=list.iterator();
		while(it.hasNext()){
			InventoryEntryPo entryPo=it.next();
			entryPo.setBgcretailPrice(inTransitDetailsDao.getGoodsInfoByInventoryEntry(entryPo).getBgiretailprice());
			consignProcessSettlementDao.updateConsignProcessSettlementDetails(entryPo);		
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

	

}
