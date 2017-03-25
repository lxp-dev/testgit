package com.pengsheng.eims.personnel.mgr;

import java.util.List;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.personnel.persistence.TrainLevelPo;

public interface TrainLevelMgr 
{
	/**
	 * 插入培训等级Po
	 * @param po
	 */
	public void insertTrainLevelPo(TrainLevelPo po,LogisticsLogPo logPo);
	
	/**
	 * 
	 * 判断培训等级编号是否存在
	 * @return
	 */
	public int getTrainLevelPoId(TrainLevelPo po);
	
	/**
	 * 
	 * 判断培训等级名称是否存在
	 * @return
	 */
	public int getTrainLevelPoName(TrainLevelPo po);
	/**
	 * 
	 * 更新时判断培训等级编号是否存在
	 * @return
	 */
	public int getTrainLevelPoIdUpdate(TrainLevelPo po);
	
	/**
	 * 
	 * 更新时判断培训等级名称是否存在
	 * @return
	 */
	public int getTrainLevelPoNameUpdate(TrainLevelPo po);
	
	/**
	 * 删除培训等级Po
	 * @param po
	 */
	public void deleteTrainLevelPo(TrainLevelPo po,LogisticsLogPo logPo);
	
	/**
	 * 更新培训等级Po
	 * @param po
	 */
	public void updateTrainLevelPo(TrainLevelPo po,LogisticsLogPo logPo);
	
	/**
	 * 查询培训等级Po
	 * @param po
	 */
	public TrainLevelPo selectTrainLevelPo(TrainLevelPo po);
	
	/**
	 * 查询培训等级Count
	 * @param po
	 */
	public int selectTrainLevelCount(TrainLevelPo po);
	
	/**
	 * 查询培训等级List
	 * @param po
	 */
	public List<TrainLevelPo> selectTrainLevelList(TrainLevelPo po, int start, int size);
}
