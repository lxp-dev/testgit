package com.pengsheng.eims.personnel.mgr.impl;

import java.util.List;

import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;

import com.pengsheng.eims.personnel.dao.TrainLevelDao;
import com.pengsheng.eims.personnel.mgr.TrainLevelMgr;
import com.pengsheng.eims.personnel.persistence.PostPo;
import com.pengsheng.eims.personnel.persistence.TrainLevelPo;

public class TrainLevelMgrImpl implements TrainLevelMgr
{
	private LogisticsLogDao logisticsLogDao;
	private TrainLevelDao trainLevelDao;
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}
	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}
	public TrainLevelDao getTrainLevelDao() {
		return trainLevelDao;
	}
	public void setTrainLevelDao(TrainLevelDao trainLevelDao) {
		this.trainLevelDao = trainLevelDao;
	}
	
	
	
	public void deleteTrainLevelPo(TrainLevelPo po,LogisticsLogPo logPo) {
		trainLevelDao.deleteTrainLevelPo(po);
		logisticsLogDao.insertLog(logPo);
	}

	
	public void insertTrainLevelPo(TrainLevelPo po,LogisticsLogPo logPo) {
		trainLevelDao.insertTrainLevelPo(po);
		logisticsLogDao.insertLog(logPo);
	}

	
	public int selectTrainLevelCount(TrainLevelPo po) {
		return trainLevelDao.selectTrainLevelCount(po);
	}
	public int getTrainLevelPoId(TrainLevelPo po){
		return trainLevelDao.getTrainLevelPoId(po);
	}
	public int getTrainLevelPoName(TrainLevelPo po){
		return trainLevelDao.getTrainLevelPoName(po);
	}
	public int getTrainLevelPoIdUpdate(TrainLevelPo po)
	{
		return trainLevelDao.getTrainLevelPoIdUpdate(po);
	}
	public int getTrainLevelPoNameUpdate(TrainLevelPo po)
	{
		return trainLevelDao.getTrainLevelPoNameUpdate(po);
	}
	
	public List<TrainLevelPo> selectTrainLevelList(TrainLevelPo po, int start, int size) {
		
		return trainLevelDao.selectTrainLevelList(po, start, size);
	}

	
	public TrainLevelPo selectTrainLevelPo(TrainLevelPo po) {
		
		return trainLevelDao.selectTrainLevelPo(po);
	}

	
	public void updateTrainLevelPo(TrainLevelPo po,LogisticsLogPo logPo) {
		trainLevelDao.updateTrainLevelPo(po);
		logisticsLogDao.insertLog(logPo);
	}


	
	
}
