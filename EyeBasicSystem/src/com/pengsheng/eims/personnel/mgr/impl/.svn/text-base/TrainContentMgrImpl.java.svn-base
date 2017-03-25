package com.pengsheng.eims.personnel.mgr.impl;

import java.util.List;

import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.personnel.dao.TrainContentDao;
import com.pengsheng.eims.personnel.mgr.TrainContentMgr;
import com.pengsheng.eims.personnel.persistence.TrainContentPo;

public class TrainContentMgrImpl implements TrainContentMgr
{
	private LogisticsLogDao logisticsLogDao;
	private TrainContentDao trainContentDao;
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}
	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}
	public TrainContentDao getTrainContentDao() {
		return trainContentDao;
	}
	public void setTrainContentDao(TrainContentDao trainContentDao) {
		this.trainContentDao = trainContentDao;
	}
	
	
	
	public void deleteTrainContentPo(TrainContentPo po,LogisticsLogPo logPo) {
		trainContentDao.deleteTrainContentPo(po);
		logisticsLogDao.insertLog(logPo);
	}

	
	public void insertTrainContentPo(TrainContentPo po,LogisticsLogPo logPo) {
		trainContentDao.insertTrainContentPo(po);
		logisticsLogDao.insertLog(logPo);
	}

	
	public int selectTrainContentCount(TrainContentPo po) {
		return trainContentDao.selectTrainContentCount(po);
	}
	public int getTrainContentPoId(TrainContentPo po){
		return trainContentDao.getTrainContentPoId(po);
	}
	public int getTrainContentPoName(TrainContentPo po){
		return trainContentDao.getTrainContentPoName(po);
	}
	public int getTrainContentPoIdUpdate(TrainContentPo po)
	{
		return trainContentDao.getTrainContentPoIdUpdate(po);
	}
	public int getTrainContentPoNameUpdate(TrainContentPo po)
	{
		return trainContentDao.getTrainContentPoNameUpdate(po);
	}
	
	public List<TrainContentPo> selectTrainContentList(TrainContentPo po, int start, int size) {
		
		return trainContentDao.selectTrainContentList(po, start, size);
	}

	
	public TrainContentPo selectTrainContentPo(TrainContentPo po) {
		
		return trainContentDao.selectTrainContentPo(po);
	}

	
	public void updateTrainContentPo(TrainContentPo po,LogisticsLogPo logPo) {
		trainContentDao.updateTrainContentPo(po);
		logisticsLogDao.insertLog(logPo);
	}

}
