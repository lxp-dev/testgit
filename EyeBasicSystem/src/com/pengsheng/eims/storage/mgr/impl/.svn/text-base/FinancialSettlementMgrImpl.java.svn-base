package com.pengsheng.eims.storage.mgr.impl;

import java.util.Iterator;
import java.util.List;

import com.pengsheng.eims.storage.dao.FinancialSettlementDao;
import com.pengsheng.eims.storage.mgr.FinancialSettlementMgr;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.components.dao.InTransitDetailsDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;

public class FinancialSettlementMgrImpl implements FinancialSettlementMgr {
	
	private LogisticsLogDao logisticsLogDao;	
	private InTransitDetailsDao inTransitDetailsDao = null;
	private FinancialSettlementDao financialSettlementDao;
	
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
	public FinancialSettlementDao getFinancialSettlementDao() {
		return financialSettlementDao;
	}

	public void setFinancialSettlementDao(
			FinancialSettlementDao financialSettlementDao) {
		this.financialSettlementDao = financialSettlementDao;
	}

	/**
	 * 查询采购收货结算数量
	 * @param po
	 * @return
	 */
	public int getFinancialSettlementCount(InventoryPo po) {
		return financialSettlementDao.getFinancialSettlementCount(po);
	}

	/**
	 * 查询财务结算
	 * @param po
	 * @param start
	 * @param size
	 * @return
	 */
	public List<InventoryPo> getFinancialSettlementList(InventoryPo po,
			int start, int size) {

		return financialSettlementDao.getFinancialSettlementList(po, start, size);
	}

	/**
	 * 修改财务结算
	 * @param po
	 */
	public void updateFinancialSettlement(InventoryPo po,List<InventoryEntryPo> list,LogisticsLogPo logPo) {
		if("1".equals(po.getCstifinanceauditstate())){
			financialSettlementDao.updateFinancialSettlement(po);//单据主表
		}

		Iterator<InventoryEntryPo> it=list.iterator();
		while(it.hasNext()){
			InventoryEntryPo entryPo=it.next();
			entryPo.setBgcretailPrice(inTransitDetailsDao.getGoodsInfoByInventoryEntry(entryPo).getBgiretailprice());
			financialSettlementDao.updateFinancialSettlementEntry(entryPo);			
		}
		
		if ("1".equals(Utility.getName(po.getCstifinanceauditstate()))){
			inTransitDetailsDao.insertSupplierDealingEntry(po);     // 新增应付款

			List<InventoryEntryPo> elist = inTransitDetailsDao.getStorageCostEntryByBillID(po);  // 更新库存表的结算成本
			for (InventoryEntryPo epo : elist){
				inTransitDetailsDao.updateStorageCostEntry(epo);    
			}
			
		}
		
		logisticsLogDao.insertLog(logPo); //添加日志

	}

	/**
	 * 财务结算详细
	 * @param po
	 * @return
	 */
	public InventoryPo getFinancialSettlement(InventoryPo po) {

		return financialSettlementDao.getFinancialSettlement(po);
	}


	/**
	 * 遍历财务结算信息
	 * @param po
	 * @return
	 */
	public List<InventoryEntryPo> getFinancialSettlementEntryList(InventoryPo po) {
		return this.financialSettlementDao.getFinancialSettlementEntryList(po);
	}
	
	/**
	 * 批量财务结算
	 * @param po
	 */
	public void insertFinancialSettlementBatch(List<InventoryPo> inventoryList,LogisticsLogPo logPo){
		
		for (InventoryPo po : inventoryList){			
			financialSettlementDao.insertFinancialSettlementBatch(po);
			financialSettlementDao.insertFinancialSettlementEntryBatch(po);
			
			inTransitDetailsDao.insertSupplierDealingEntry(po);
			
			logPo.setsLogContent(Utility.getName(logPo.getsLogContent()) + Utility.getName(po.getCstibillid()));		
			logisticsLogDao.insertLog(logPo); //添加日志
		}		
	}
	
}
