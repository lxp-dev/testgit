package com.pengsheng.eims.basic.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.dao.HisInfoDao;
import com.pengsheng.eims.basic.mgr.HisInfoMgr;
import com.pengsheng.eims.basic.persistence.HisInfoPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;

public class HisInfoMgrImpl implements HisInfoMgr {

	private HisInfoDao hisInfoDao;
	private LogisticsLogDao logisticsLogDao;
		
	public HisInfoDao getHisInfoDao() {
		return hisInfoDao;
	}

	public void setHisInfoDao(HisInfoDao hisInfoDao) {
		this.hisInfoDao = hisInfoDao;
	}

	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	public void deleteHisInfoList(HisInfoPo hisInfoPo, LogisticsLogPo logPo) {

		hisInfoDao.deleteHisInfoList(hisInfoPo);
		
		logisticsLogDao.insertLog(logPo);
	}

	public HisInfoPo getHisInfoDetail(HisInfoPo hisInfoPo) {
		return hisInfoDao.getHisInfoDetail(hisInfoPo);
	}

	public List<HisInfoPo> getHisInfoList(HisInfoPo hisInfoPo) {
		return hisInfoDao.getHisInfoList(hisInfoPo);
	}

	public void insertHisInfoList(HisInfoPo hisInfoPo, LogisticsLogPo logPo) {

		hisInfoDao.insertHisInfoList(hisInfoPo);
		
		logisticsLogDao.insertLog(logPo);
	}

	public void updateHisInfoList(HisInfoPo hisInfoPo, LogisticsLogPo logPo) {

		hisInfoDao.updateHisInfoList(hisInfoPo);
		
		logisticsLogDao.insertLog(logPo);
	}

}
