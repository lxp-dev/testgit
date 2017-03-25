package com.pengsheng.eims.basic.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.dao.PresbyopicGlassesDao;
import com.pengsheng.eims.basic.mgr.PresbyopicGlassesMgr;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;

public class PresbyopicGlassesMgrImpl implements PresbyopicGlassesMgr {
	
	private LogisticsLogDao logisticsLogDao;	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}
	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}


    private PresbyopicGlassesDao presbyopicGlassesDao;
	
	public int getPresbyopicGlassesCount(GoodsInfoPo po) {
		
		return presbyopicGlassesDao.getPresbyopicGlassesCount(po);
	}
	
	public List<GoodsInfoPo> getPresbyopicGlassesList(GoodsInfoPo po, int start,
			int size) {
		
		return presbyopicGlassesDao.getPresbyopicGlassesList(po, start, size);
	}
	
	public void insertPresbyopicGlasses(GoodsInfoPo po,LogisticsLogPo logPo) {
		presbyopicGlassesDao.insertPresbyopicGlasses(po);
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	public void updatePresbyopicGlasses(GoodsInfoPo po,LogisticsLogPo logPo) {
		presbyopicGlassesDao.updatePresbyopicGlasses(po);
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	public GoodsInfoPo getPresbyopicGlasses(GoodsInfoPo po) {
		
		return presbyopicGlassesDao.getPresbyopicGlasses(po);
	}
	
	public void deletePresbyopicGlasses(GoodsInfoPo po,LogisticsLogPo logPo) {

		presbyopicGlassesDao.deletePresbyopicGlasses(po);
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	public void updatePresbyopicGlassesDisable(GoodsInfoPo po,LogisticsLogPo logPo) {

		presbyopicGlassesDao.updatePresbyopicGlassesDisable(po);
		logisticsLogDao.insertLog(logPo); //添加日志
	}

	public PresbyopicGlassesDao getPresbyopicGlassesDao() {
		return presbyopicGlassesDao;
	}

	public void setPresbyopicGlassesDao(PresbyopicGlassesDao presbyopicGlassesDao) {
		this.presbyopicGlassesDao = presbyopicGlassesDao;
	}
}
