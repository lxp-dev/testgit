package com.pengsheng.eims.storage.mgr.impl;

import java.util.Iterator;
import java.util.List;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.dao.OtherDatabaseSettlementDao;
import com.pengsheng.eims.storage.mgr.OtherDatabaseSettlementMgr;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;

public class OtherDatabaseSettlementMgrImpl implements
		OtherDatabaseSettlementMgr {
	
	private LogisticsLogDao logisticsLogDao;	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}
	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	private OtherDatabaseSettlementDao otherDatabaseSettlementDao;

	public OtherDatabaseSettlementDao getOtherDatabaseSettlementDao() {
		return otherDatabaseSettlementDao;
	}

	public void setOtherDatabaseSettlementDao(
			OtherDatabaseSettlementDao otherDatabaseSettlementDao) {
		this.otherDatabaseSettlementDao = otherDatabaseSettlementDao;
	}

	/**
	 * 查询其它出库结算数量
	 */
	public int getOtherDatabaseSettlementCount(InventoryPo po) {
		
		return otherDatabaseSettlementDao.getOtherDatabaseSettlementCount(po);
	}

	/**
	 *  遍历其它出库结算信息
	 */
	public List<InventoryEntryPo> getOtherDatabaseSettlementEntryList(
			InventoryPo po) {
		
		return otherDatabaseSettlementDao.getOtherDatabaseSettlementEntryList(po);
	}

	/**
	 * 查询其它出库结算
	 */
	public List<InventoryPo> getOtherDatabaseSettlementList(InventoryPo po,
			int start, int size) {
		
		return otherDatabaseSettlementDao.getOtherDatabaseSettlementList(po, start, size);
	}

	/**
	 * 其它出库结算详细
	 */
	public InventoryPo getOtherDatabaseSettlement(InventoryPo po) {
		
		return otherDatabaseSettlementDao.getOtherDatabaseSettlement(po);
	}

	/**
	 * 修改其它出库结算
	 */
	public void updateOtherDatabaseSettlement(InventoryPo po,
			List<InventoryEntryPo> list,LogisticsLogPo logPo) {
		otherDatabaseSettlementDao.updateOtherDatabaseSettlement(po);
		Iterator<InventoryEntryPo> it=list.iterator();
		while(it.hasNext()){
			InventoryEntryPo entryPo=it.next();			
			otherDatabaseSettlementDao.updateOtherDatabaseSettlementEntry(entryPo);		
		}
		logisticsLogDao.insertLog(logPo); //添加日志
	}

}
