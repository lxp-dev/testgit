package com.pengsheng.eims.basic.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.dao.StealthCustomLensesDDao;
import com.pengsheng.eims.basic.mgr.StealthCustomLensesDMgr;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;

public class StealthCustomLensesDMgrImpl implements StealthCustomLensesDMgr {
	private LogisticsLogDao logisticsLogDao;
	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}
	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

    private StealthCustomLensesDDao stealthCustomLensesDDao;
	
	public int getStealthCustomLensesCount(GoodsInfoPo po) {
		return stealthCustomLensesDDao.getStealthCustomLensesCount(po);
	}
	
	public List<GoodsInfoPo> getStealthCustomLensesList(GoodsInfoPo po, int start,
			int size) {
		return stealthCustomLensesDDao.getStealthCustomLensesList(po, start, size);
	}
	
	public void insertStealthCustomLenses(GoodsInfoPo po,LogisticsLogPo logPo) {
		stealthCustomLensesDDao.insertStealthCustomLenses(po);
		logisticsLogDao.insertLog(logPo); //添加日志
		
	}
	
	public void updateStealthCustomLenses(GoodsInfoPo po,LogisticsLogPo logPo) {

		stealthCustomLensesDDao.updateStealthCustomLenses(po);
		logisticsLogDao.insertLog(logPo); //添加日志
		
	}
	
	public GoodsInfoPo getStealthCustomLenses(GoodsInfoPo po) {
		
		return stealthCustomLensesDDao.getStealthCustomLenses(po);
	}
	
	public void deleteStealthCustomLenses(GoodsInfoPo po,LogisticsLogPo logPo) {

		stealthCustomLensesDDao.deleteStealthCustomLenses(po);
		logisticsLogDao.insertLog(logPo); //添加日志
		
	}
	public void updateStealthCustomLensesDisable(GoodsInfoPo po,LogisticsLogPo logPo) {

		stealthCustomLensesDDao.updateStealthCustomLensesDisable(po);
		logisticsLogDao.insertLog(logPo); //添加日志
		
	}
	public StealthCustomLensesDDao getStealthCustomLensesDDao() {
		return stealthCustomLensesDDao;
	}
	public void setStealthCustomLensesDDao(StealthCustomLensesDDao stealthCustomLensesDDao) {
		this.stealthCustomLensesDDao = stealthCustomLensesDDao;
	}
}
