package com.pengsheng.eims.hydsycasehistory.mgr.impl;

import com.pengsheng.eims.hydsycasehistory.dao.GlassesHistoryHydsyDao;
import com.pengsheng.eims.hydsycasehistory.mgr.GlassesHistoryHydsyMgr;
import com.pengsheng.eims.hydsycasehistory.persistence.HisInfoPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;

public class GlassesHistoryHydsyMgrImpl implements GlassesHistoryHydsyMgr {
	private LogisticsLogDao logisticsLogDao;
	
	private GlassesHistoryHydsyDao glassesHistoryHydsyDao;

	public GlassesHistoryHydsyDao getGlassesHistoryHydsyDao() {
		return glassesHistoryHydsyDao;
	}

	public void setGlassesHistoryHydsyDao(GlassesHistoryHydsyDao glassesHistoryHydsyDao) {
		this.glassesHistoryHydsyDao = glassesHistoryHydsyDao;
	}

	/**
	 * 新增戴镜史信息
	 * @param hisInfoPo
	 */
	public void insertGlassesHistory(HisInfoPo hisInfoPo,LogisticsLogPo logPo) {
		logisticsLogDao.insertLog(logPo);  //新增日志
		
		glassesHistoryHydsyDao.deleteGlassesHistory(hisInfoPo);
		glassesHistoryHydsyDao.insertGlassesHistory(hisInfoPo);
		
	}

	/**
	 * 查询戴镜史信息
	 * @param hisInfoPo
	 * @return
	 */
	public HisInfoPo selectGlassesHistory(HisInfoPo hisInfoPo) {
		return glassesHistoryHydsyDao.selectGlassesHistory(hisInfoPo);
	}
	
	/**
	 * 更新戴镜史信息
	 * @param hisInfoPo
	 */
	public void updateGlassesHistory(HisInfoPo hisInfoPo,LogisticsLogPo logPo){
		logisticsLogDao.insertLog(logPo);  //新增日志
		glassesHistoryHydsyDao.updateGlassesHistory(hisInfoPo);
	}

	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

}
