package com.pengsheng.eims.basic.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.dao.GlassesFinishDao;
import com.pengsheng.eims.basic.mgr.GlassesFinishMgr;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;

public class GlassesFinishMgrImpl implements GlassesFinishMgr {
	
	private LogisticsLogDao logisticsLogDao;	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}
	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}


    private GlassesFinishDao glassesFinishDao;
	
	public int getGlassesFinishCount(GoodsInfoPo po) {
		
		return glassesFinishDao.getGlassesFinishCount(po);
	}
	
	public List<GoodsInfoPo> getGlassesFinishList(GoodsInfoPo po, int start,
			int size) {
		
		return glassesFinishDao.getGlassesFinishList(po, start, size);
	}
	
	public void insertGlassesFinish(GoodsInfoPo po,LogisticsLogPo logPo) {

		glassesFinishDao.insertGlassesFinish(po);
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	public void updateGlassesFinish(GoodsInfoPo po,LogisticsLogPo logPo) {

		glassesFinishDao.updateGlassesFinish(po);
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	public GoodsInfoPo getGlassesFinish(GoodsInfoPo po) {
		
		return glassesFinishDao.getGlassesFinish(po);
	}
	
	public void deleteGlassesFinish(GoodsInfoPo po,LogisticsLogPo logPo) {

		glassesFinishDao.deleteGlassesFinish(po);
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	public void updateGlassesFinishDisable(GoodsInfoPo po,LogisticsLogPo logPo) {

		glassesFinishDao.updateGlassesFinishDisable(po);
		logisticsLogDao.insertLog(logPo); //添加日志
	}

	public GlassesFinishDao getGlassesFinishDao() {
		return glassesFinishDao;
	}

	public void setGlassesFinishDao(GlassesFinishDao glassesFinishDao) {
		this.glassesFinishDao = glassesFinishDao;
	}
}
