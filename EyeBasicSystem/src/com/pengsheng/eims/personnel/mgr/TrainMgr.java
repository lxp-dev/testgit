package com.pengsheng.eims.personnel.mgr;

import java.util.List;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.personnel.persistence.TrainPo;

public interface TrainMgr {
	/**
	 * 查询培训信息List
	 * 
	 * @param 
	 * @return
	 */
	public List<TrainPo> getTrains(TrainPo po,int start, int size) ;
	/**
	 * 查询培训信息Count
	 * 
	 * @param 
	 * @return
	 */
	public int getTrainCount(TrainPo po) ;
	
	/**
	 * 新增培训信息
	 */
	public void insertTrainPo(TrainPo tpo,LogisticsLogPo logPo);
	
	/**
	 * 查询培训信息Po
	 * 
	 * @param 
	 * @return
	 */
	public TrainPo getTrainPo(TrainPo po);
	
	public List<TrainPo> getTrainResults(TrainPo po);
	
	/**
	 * 更新培训信息
	 * 
	 * @param 
	 */
	public void updateTrainPo(TrainPo po,LogisticsLogPo logPo) ;
	
	/**
	 * 删除培训信息
	 * 
	 * @param 
	 */
	public void deleteTrainPo(TrainPo po,LogisticsLogPo logPo) ;
	
}
