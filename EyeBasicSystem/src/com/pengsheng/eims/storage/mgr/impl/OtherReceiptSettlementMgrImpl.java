package com.pengsheng.eims.storage.mgr.impl;

import java.util.Iterator;
import java.util.List;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.dao.OtherReceiptSettlementDao;
import com.pengsheng.eims.storage.mgr.OtherReceiptSettlementMgr;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;

public class OtherReceiptSettlementMgrImpl implements OtherReceiptSettlementMgr {
	
	private LogisticsLogDao logisticsLogDao;	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}
	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	private OtherReceiptSettlementDao otherReceiptSettlementDao;
	public OtherReceiptSettlementDao getOtherReceiptSettlementDao() {
		return otherReceiptSettlementDao;
	}

	public void setOtherReceiptSettlementDao(
			OtherReceiptSettlementDao otherReceiptSettlementDao) {
		this.otherReceiptSettlementDao = otherReceiptSettlementDao;
	}


	/**
	 * 其它入库结算详细
	 * @param po
	 * @return
	 */
	public InventoryPo getOtherReceiptSettlement(InventoryPo po) {
		return otherReceiptSettlementDao.getOtherReceiptlSettlement(po);
	}

	/**
	 * 查询其它入库结算数量
	 * @param po
	 * @return
	 */
	public int getOtherReceiptSettlementCount(InventoryPo po) {
		return otherReceiptSettlementDao.getOtherReceiptSettlementCount(po);
	}

	/**
	 * 委外其它入库结算业务单明细表信息
	 * @param po
	 * @return
	 */
	public List<InventoryEntryPo> getOtherReceiptSettlementDetailsList(
			InventoryPo po) {
		return otherReceiptSettlementDao.getOtherReceiptSettlementEntryList(po);
	}

	/**
	 * 其它入库结算业务单明细表信息
	 * @param po
	 * @return
	 */
	public List<InventoryPo> getOtherReceiptSettlementList(InventoryPo po,
			int start, int size) {
		return otherReceiptSettlementDao.getOtherReceiptSettlementList(po, start, size);
	}

	/**
	 * 修改其它入库结算主表信息
	 * @param po
	 */
	public void updateOtherReceiptSettlement(InventoryPo po,
			List<InventoryEntryPo> list,LogisticsLogPo logPo) {
		    otherReceiptSettlementDao.updateOtherReceiptSettlement(po);
			
			Iterator<InventoryEntryPo> it=list.iterator();
			while(it.hasNext()){
				InventoryEntryPo entryPo=it.next();			
				otherReceiptSettlementDao.updateOtherReceiptSettlementEntry(entryPo);
			}
			logisticsLogDao.insertLog(logPo); //添加日志
	}

}
