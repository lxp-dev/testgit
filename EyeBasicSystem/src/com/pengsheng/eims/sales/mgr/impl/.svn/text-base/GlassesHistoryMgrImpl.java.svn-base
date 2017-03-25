package com.pengsheng.eims.sales.mgr.impl;

import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.sales.dao.GlassesHistoryDao;
import com.pengsheng.eims.sales.mgr.GlassesHistoryMgr;
import com.pengsheng.eims.sales.persistence.HisInfoPo;

public class GlassesHistoryMgrImpl implements GlassesHistoryMgr {
	private LogisticsLogDao logisticsLogDao;
	
	private GlassesHistoryDao glassesHistoryDao;

	public GlassesHistoryDao getGlassesHistoryDao() {
		return glassesHistoryDao;
	}

	public void setGlassesHistoryDao(GlassesHistoryDao glassesHistoryDao) {
		this.glassesHistoryDao = glassesHistoryDao;
	}

	/**
	 * 新增戴镜史信息
	 * @param hisInfoPo
	 */
	public void insertGlassesHistory(HisInfoPo hisInfoPo,LogisticsLogPo logPo) {
		logisticsLogDao.insertLog(logPo);  //新增日志
		
		glassesHistoryDao.deleteGlassesHistory(hisInfoPo);
		glassesHistoryDao.insertGlassesHistory(hisInfoPo);
		
	}

	/**
	 * 查询戴镜史信息
	 * @param hisInfoPo
	 * @return
	 */
	public HisInfoPo selectGlassesHistory(HisInfoPo hisInfoPo) {
		// TODO Auto-generated method stub
		return glassesHistoryDao.selectGlassesHistory(hisInfoPo);
	}
	
	/**
	 * 更新戴镜史信息
	 * @param hisInfoPo
	 */
	public void updateGlassesHistory(HisInfoPo hisInfoPo,LogisticsLogPo logPo){
		logisticsLogDao.insertLog(logPo);  //新增日志
		glassesHistoryDao.updateGlassesHistory(hisInfoPo);
	}

	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

}
