package com.pengsheng.eims.casehistory.mgr.impl;

import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.casehistory.dao.GlassesHistoryNDao;
import com.pengsheng.eims.casehistory.mgr.GlassesHistoryNMgr;
import com.pengsheng.eims.casehistory.persistence.HisInfoPo;

public class GlassesHistoryNMgrImpl implements GlassesHistoryNMgr {
	private LogisticsLogDao logisticsLogDao;
	
	private GlassesHistoryNDao glassesHistoryNDao;

	public GlassesHistoryNDao getGlassesHistoryNDao() {
		return glassesHistoryNDao;
	}

	public void setGlassesHistoryNDao(GlassesHistoryNDao glassesHistoryNDao) {
		this.glassesHistoryNDao = glassesHistoryNDao;
	}

	/**
	 * 新增戴镜史信息
	 * @param hisInfoPo
	 */
	public void insertGlassesHistory(HisInfoPo hisInfoPo,LogisticsLogPo logPo) {
		logisticsLogDao.insertLog(logPo);  //新增日志
		
		glassesHistoryNDao.deleteGlassesHistory(hisInfoPo);
		glassesHistoryNDao.insertGlassesHistory(hisInfoPo);
		
	}

	/**
	 * 查询戴镜史信息
	 * @param hisInfoPo
	 * @return
	 */
	public HisInfoPo selectGlassesHistory(HisInfoPo hisInfoPo) {
		return glassesHistoryNDao.selectGlassesHistory(hisInfoPo);
	}
	
	/**
	 * 更新戴镜史信息
	 * @param hisInfoPo
	 */
	public void updateGlassesHistory(HisInfoPo hisInfoPo,LogisticsLogPo logPo){
		logisticsLogDao.insertLog(logPo);  //新增日志
		glassesHistoryNDao.updateGlassesHistory(hisInfoPo);
	}

	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

}
