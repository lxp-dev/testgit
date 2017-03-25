package com.pengsheng.eims.personnel.mgr.impl;

import java.util.List;

import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.personnel.dao.TrainDao;
import com.pengsheng.eims.personnel.mgr.TrainMgr;
import com.pengsheng.eims.personnel.persistence.TrainPo;

public class TrainMgrImpl implements TrainMgr {
	private TrainDao trainDao;
	private LogisticsLogDao logisticsLogDao;
	/**
	 * 查询培训信息List
	 * 
	 * @param 
	 * @return
	 */
	public List<TrainPo> getTrains(TrainPo po,int start, int size){
		return trainDao.getTrains(po, start, size);
	}
	/**
	 * 查询培训信息Count
	 * 
	 * @param 
	 * @return
	 */
	public int getTrainCount(TrainPo po){
		return trainDao.getTrainCount(po);
	}
	
	/**
	 * 新增培训信息
	 */
	public void insertTrainPo(TrainPo po,LogisticsLogPo logPo){
		logisticsLogDao.insertLog(logPo);
		
		trainDao.insertTrainPo(po);
		
		for(int i=0; i<po.getMtpresultss().length; i++){
			TrainPo trpo = new TrainPo();
			trpo.setMtppersonid(po.getMtppersonids()[i]);
			trpo.setMtptrainid(po.getMttrainid());
			trpo.setMtpresults(po.getMtpresultss()[i]);
			trainDao.insertTrainResultsPo(trpo);
		}
	}
	
	/**
	 * 查询培训信息Po
	 * 
	 * @param 
	 * @return
	 */
	public TrainPo getTrainPo(TrainPo po){
		return trainDao.getTrainPo(po);
	}
	
	/**
	 * 更新培训信息
	 * 
	 * @param 
	 */
	public void updateTrainPo(TrainPo po,LogisticsLogPo logPo){
		logisticsLogDao.insertLog(logPo);
		
		trainDao.updateTrainPo(po);
		trainDao.deleteTrainResultsPo(po);
		
		for(int i=0; i<po.getMtpresultss().length; i++){
			TrainPo trpo = new TrainPo();
			trpo.setMtppersonid(po.getMtppersonids()[i]);
			trpo.setMtptrainid(po.getMttrainid());
			trpo.setMtpresults(po.getMtpresultss()[i]);
			trainDao.insertTrainResultsPo(trpo);
		}
	}
	
	/**
	 * 删除培训信息
	 * 
	 * @param 
	 */
	public void deleteTrainPo(TrainPo po,LogisticsLogPo logPo){
		logisticsLogDao.insertLog(logPo);
		
		trainDao.deleteTrainPo(po);
		trainDao.deleteTrainResultsPo(po);
	}
	
	public List<TrainPo> getTrainResults(TrainPo po){
		return trainDao.getTrainResults(po);
	}
	
	public TrainDao getTrainDao() {
		return trainDao;
	}
	public void setTrainDao(TrainDao trainDao) {
		this.trainDao = trainDao;
	}
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}
	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}
}
