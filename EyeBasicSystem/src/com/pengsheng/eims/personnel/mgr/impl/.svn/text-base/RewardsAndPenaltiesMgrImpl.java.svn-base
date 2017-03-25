package com.pengsheng.eims.personnel.mgr.impl;

import java.util.List;

import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.personnel.dao.RewardsAndPenaltiesDao;
import com.pengsheng.eims.personnel.mgr.RewardsAndPenaltiesMgr;
import com.pengsheng.eims.personnel.persistence.RewardsAndPenaltiesPo;

public class RewardsAndPenaltiesMgrImpl implements RewardsAndPenaltiesMgr{
	private LogisticsLogDao logisticsLogDao;
	private RewardsAndPenaltiesDao rewardsAndPenaltiesDao;
	
	public void deleteRewardsAndPenaltiesPo(RewardsAndPenaltiesPo po,
			LogisticsLogPo logPo) {
		rewardsAndPenaltiesDao.deleteRewardsAndPenaltiesPo(po);
		logisticsLogDao.insertLog(logPo);
	}

	
	public List<RewardsAndPenaltiesPo> getRewardsAndPenalties(
			RewardsAndPenaltiesPo po, int start, int size) {
		return rewardsAndPenaltiesDao.getRewardsAndPenalties(po, start, size);
	}

	
	public int getRewardsAndPenaltiesCount(RewardsAndPenaltiesPo po) {
		return rewardsAndPenaltiesDao.getRewardsAndPenaltiesCount(po);
	}

	
	public RewardsAndPenaltiesPo getRewardsAndPenaltiesPo(
			RewardsAndPenaltiesPo po) {
		return rewardsAndPenaltiesDao.getRewardsAndPenaltiesPo(po);
	}

	
	public void insertRewardsAndPenaltiesPo(RewardsAndPenaltiesPo po,
			LogisticsLogPo logPo) {
		rewardsAndPenaltiesDao.insertRewardsAndPenaltiesPo(po);
		logisticsLogDao.insertLog(logPo);
	}

	
	public void updateRewardsAndPenaltiesPo(RewardsAndPenaltiesPo po,
			LogisticsLogPo logPo) {
		rewardsAndPenaltiesDao.updateRewardsAndPenaltiesPo(po);
		logisticsLogDao.insertLog(logPo);
	}


	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}


	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}


	public RewardsAndPenaltiesDao getRewardsAndPenaltiesDao() {
		return rewardsAndPenaltiesDao;
	}


	public void setRewardsAndPenaltiesDao(
			RewardsAndPenaltiesDao rewardsAndPenaltiesDao) {
		this.rewardsAndPenaltiesDao = rewardsAndPenaltiesDao;
	}
	
}
