package com.pengsheng.eims.yklogistics.mgr.impl;

import java.util.Iterator;
import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.yklogistics.dao.CalDao;
import com.pengsheng.eims.yklogistics.dao.LogisticsLogDao;
import com.pengsheng.eims.yklogistics.mgr.CalMgr;
import com.pengsheng.eims.logistics.persistence.LCTCostingTempPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;

public class CalMgrImpl implements CalMgr {
	
	private CalDao ykcalDao;
    private LogisticsLogDao yklogisticsLogDao = null;

	public CalDao getYkcalDao() {
		return ykcalDao;
	}
	public void setYkcalDao(CalDao ykcalDao) {
		this.ykcalDao = ykcalDao;
	}
	public LogisticsLogDao getYklogisticsLogDao() {
		return yklogisticsLogDao;
	}
	public void setYklogisticsLogDao(LogisticsLogDao yklogisticsLogDao) {
		this.yklogisticsLogDao = yklogisticsLogDao;
	}
	
	public void insertRealCalStorage(String date,LogisticsLogPo logPo) {	
		ykcalDao.delLastMonth();
		ykcalDao.fromCurrentToLastMonth();
		this.ykcalDao.realCalStorageDel();
		this.ykcalDao.realCalStorage(date);
		
		yklogisticsLogDao.insertLog(logPo);
	}
	public int selCurrentDate(String date){
		return ykcalDao.selCurrentDate(date);
	}
	
	public void insertMoniCalRetrun(LogisticsLogPo logPo) {
		this.ykcalDao.moniCalRetrun();
		
		yklogisticsLogDao.insertLog(logPo);
	}
	public int selLastDate(String date){
		return ykcalDao.selLastDate(date);
	}

	public void insertRealCalRetrun(String date,LogisticsLogPo logPo) {
		
		ykcalDao.delHistoryMonth(date);
		ykcalDao.fromCurrentToHistory();
		
		List<InventoryEntryPo> lst = ykcalDao.selRealCal(date);
		Iterator<InventoryEntryPo> it = lst.iterator();
		while (it.hasNext()){
			InventoryEntryPo po = (InventoryEntryPo)it.next();
			ykcalDao.realCalRetrun(po);
			ykcalDao.updateNotTaxRateAmount(po);
		}
		
		yklogisticsLogDao.insertLog(logPo);
	}


	public List<LCTCostingTempPo> getResultList(GoodsInfoPo goodsInfoPo,int start , int size) {
		return this.ykcalDao.getResultList(goodsInfoPo,start ,size);
	}


	public int getResultCount(GoodsInfoPo goodsInfoPo) {
		return this.ykcalDao.getResultCount(goodsInfoPo);
	}

	public int getLastMonthDataCount(){
		return 0;
	}
	
	public void delLastMonth(){
		ykcalDao.delLastMonth();
	}
	public void delHistoryMonth(String date){
		ykcalDao.delHistoryMonth(date);
	}
	public void fromCurrentToLastMonth(){
		ykcalDao.fromCurrentToLastMonth();
	}
	
	public void fromCurrentToHistory(){
		ykcalDao.fromCurrentToHistory();
	}
	
}
