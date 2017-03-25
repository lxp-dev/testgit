package com.pengsheng.eims.basic.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.dao.StealthCustomLensesDao;
import com.pengsheng.eims.basic.mgr.StealthCustomLensesMgr;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;

public class StealthCustomLensesMgrImpl implements StealthCustomLensesMgr {
	
	private LogisticsLogDao logisticsLogDao;	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}
	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

    private StealthCustomLensesDao stealthCustomLensesDao;
	
	public int getStealthCustomLensesCount(GoodsInfoPo po) {
		
		return stealthCustomLensesDao.getStealthCustomLensesCount(po);
	}
	
	public List<GoodsInfoPo> getStealthCustomLensesList(GoodsInfoPo po, int start,
			int size) {
		return stealthCustomLensesDao.getStealthCustomLensesList(po, start, size);
	}
	
	public void insertStealthCustomLenses(GoodsInfoPo po,LogisticsLogPo logPo) {
		stealthCustomLensesDao.insertStealthCustomLenses(po);
		logisticsLogDao.insertLog(logPo); //添加日志
		
	}
	
	public void updateStealthCustomLenses(GoodsInfoPo po,LogisticsLogPo logPo) {

		stealthCustomLensesDao.updateStealthCustomLenses(po);
		logisticsLogDao.insertLog(logPo); //添加日志
		
	}
	
	public GoodsInfoPo getStealthCustomLenses(GoodsInfoPo po) {
		
		return stealthCustomLensesDao.getStealthCustomLenses(po);
	}
	
	public void deleteStealthCustomLenses(GoodsInfoPo po,LogisticsLogPo logPo) {

		stealthCustomLensesDao.deleteStealthCustomLenses(po);
		logisticsLogDao.insertLog(logPo); //添加日志
		
	}
	public void updateStealthCustomLensesDisable(GoodsInfoPo po,LogisticsLogPo logPo) {

		stealthCustomLensesDao.updateStealthCustomLensesDisable(po);
		logisticsLogDao.insertLog(logPo); //添加日志
		
	}

	public StealthCustomLensesDao getStealthCustomLensesDao() {
		return stealthCustomLensesDao;
	}

	public void setStealthCustomLensesDao(StealthCustomLensesDao stealthCustomLensesDao) {
		this.stealthCustomLensesDao = stealthCustomLensesDao;
	}
}
