package com.pengsheng.eims.bjtrhistory.mgr.impl;

import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.bjtrhistory.dao.GlassesHistoryBjtrNDao;
import com.pengsheng.eims.bjtrhistory.mgr.GlassesHistoryBjtrMgr;
import com.pengsheng.eims.bjtrhistory.persistence.HisInfoPo;

public class GlassesHistoryBjtrMgrImpl implements GlassesHistoryBjtrMgr {
	private LogisticsLogDao logisticsLogDao;
	
	private GlassesHistoryBjtrNDao glassesHistoryBjtrDao;

	public GlassesHistoryBjtrNDao getGlassesHistoryBjtrDao() {
		return glassesHistoryBjtrDao;
	}

	public void setGlassesHistoryBjtrDao(GlassesHistoryBjtrNDao glassesHistoryBjtrDao) {
		this.glassesHistoryBjtrDao = glassesHistoryBjtrDao;
	}

	/**
	 * 新增戴镜史信息
	 * @param hisInfoPo
	 */
	public void insertGlassesHistory(HisInfoPo hisInfoPo,LogisticsLogPo logPo) {
		logisticsLogDao.insertLog(logPo);  //新增日志
		
		glassesHistoryBjtrDao.deleteGlassesHistory(hisInfoPo);
		glassesHistoryBjtrDao.insertGlassesHistory(hisInfoPo);
		
	}

	/**
	 * 查询戴镜史信息
	 * @param hisInfoPo
	 * @return
	 */
	public HisInfoPo selectGlassesHistory(HisInfoPo hisInfoPo) {
		return glassesHistoryBjtrDao.selectGlassesHistory(hisInfoPo);
	}
	
	/**
	 * 更新戴镜史信息
	 * @param hisInfoPo
	 */
	public void updateGlassesHistory(HisInfoPo hisInfoPo,LogisticsLogPo logPo){
		logisticsLogDao.insertLog(logPo);  //新增日志
		glassesHistoryBjtrDao.updateGlassesHistory(hisInfoPo);
	}

	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

}
