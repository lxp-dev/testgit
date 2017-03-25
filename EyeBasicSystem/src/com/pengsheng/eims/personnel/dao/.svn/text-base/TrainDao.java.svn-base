package com.pengsheng.eims.personnel.dao;

import java.util.List;

import com.pengsheng.eims.basic.persistence.RolePo;
import com.pengsheng.eims.personnel.persistence.MonthWagePo;
import com.pengsheng.eims.personnel.persistence.TrainPo;
import com.pengsheng.eims.personnel.persistence.WagePo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;

public interface TrainDao 
{
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
	public void insertTrainPo(TrainPo po) ;
	
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
	public void updateTrainPo(TrainPo po) ;
	
	/**
	 * 删除培训信息
	 * 
	 * @param 
	 */
	public void deleteTrainPo(TrainPo po);
	
	public void deleteTrainResultsPo(TrainPo po);
	
	/**
	 * 新增培训信息
	 */
	public void insertTrainResultsPo(TrainPo po);
}
