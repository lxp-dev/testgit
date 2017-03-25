package com.pengsheng.eims.basic.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.dao.StealthAccessoriesDao;
import com.pengsheng.eims.basic.mgr.StealthAccessoriesMgr;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;

public class StealthAccessoriesMgrImpl implements StealthAccessoriesMgr {
	
	private LogisticsLogDao logisticsLogDao;	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}
	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	private StealthAccessoriesDao stealthAccessoriesDao;
	
	public StealthAccessoriesDao getStealthAccessoriesDao() {
		return stealthAccessoriesDao;
	}
	public void setStealthAccessoriesDao(StealthAccessoriesDao stealthAccessoriesDao) {
		this.stealthAccessoriesDao = stealthAccessoriesDao;
	}
	public int getStealthAccessoriesCount(GoodsInfoPo po) {
		return stealthAccessoriesDao.getStealthAccessoriesCount(po);
	}
	public List<GoodsInfoPo> getStealthAccessoriesList(GoodsInfoPo po,
			int start, int size) {
		
		return stealthAccessoriesDao.getStealthAccessoriesList(po, start, size);
	}
	public void insertStealthAccessories(GoodsInfoPo po,LogisticsLogPo logPo) {
		stealthAccessoriesDao.insertStealthAccessories(po);
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	public void updateStealthAccessories(GoodsInfoPo po,LogisticsLogPo logPo) {

		stealthAccessoriesDao.updateStealthAccessories(po);
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	public GoodsInfoPo getStealthAccessories(GoodsInfoPo po) {
		return stealthAccessoriesDao.getStealthAccessories(po);
	}
	public void deleteStealthAccessories(GoodsInfoPo po,LogisticsLogPo logPo) {

		stealthAccessoriesDao.deleteStealthAccessories(po);
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	public void updateStealthAccessoriesDisable(GoodsInfoPo po,LogisticsLogPo logPo) {

		stealthAccessoriesDao.updateStealthAccessoriesDisable(po);
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
}
