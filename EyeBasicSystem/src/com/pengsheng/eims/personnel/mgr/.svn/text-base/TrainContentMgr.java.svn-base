package com.pengsheng.eims.personnel.mgr;

import java.util.List;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.personnel.persistence.TrainContentPo;

public interface TrainContentMgr 
{
	/**
	 * 插入培训内容Po
	 * @param po
	 */
	public void insertTrainContentPo(TrainContentPo po,LogisticsLogPo logPo);
	
	/**
	 * 
	 * 判断培训内容编号是否存在
	 * @return
	 */
	public int getTrainContentPoId(TrainContentPo po);
	/**
	 * 
	 * 判断培训内容名称是否存在
	 * @return
	 */
	public int getTrainContentPoName(TrainContentPo po);
	
	/**
	 * 
	 * 更新时判断培训内容编号是否存在
	 * @return
	 */
	public int getTrainContentPoIdUpdate(TrainContentPo po);
	
	/**
	 * 
	 * 更新时判断培训内容名称是否存在
	 * @return
	 */
	public int getTrainContentPoNameUpdate(TrainContentPo po);
	/**
	 * 删除培训内容Po
	 * @param po
	 */
	public void deleteTrainContentPo(TrainContentPo po,LogisticsLogPo logPo);
	
	/**
	 * 更新培训内容Po
	 * @param po
	 */
	public void updateTrainContentPo(TrainContentPo po,LogisticsLogPo logPo);
	
	/**
	 * 查询培训内容Po
	 * @param po
	 */
	public TrainContentPo selectTrainContentPo(TrainContentPo po);
	
	/**
	 * 查询培训内容Count
	 * @param po
	 */
	public int selectTrainContentCount(TrainContentPo po);
	
	/**
	 * 查询培训内容List
	 * @param po
	 */
	public List<TrainContentPo> selectTrainContentList(TrainContentPo po, int start, int size);
}
