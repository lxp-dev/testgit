package com.pengsheng.eims.personnel.mgr;

import java.util.List;

import com.pengsheng.eims.basic.persistence.RolePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.personnel.persistence.MonthWagePo;
import com.pengsheng.eims.personnel.persistence.RewardsAndPenaltiesPo;
import com.pengsheng.eims.personnel.persistence.WagePo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;

public interface RewardsAndPenaltiesMgr 
{
	/**
	 * 查询奖惩List
	 * 
	 * @param 
	 * @return
	 */
	public List<RewardsAndPenaltiesPo> getRewardsAndPenalties(RewardsAndPenaltiesPo po,int start, int size) ;
	/**
	 * 查询奖惩Count
	 * 
	 * @param 
	 * @return
	 */
	public int getRewardsAndPenaltiesCount(RewardsAndPenaltiesPo po) ;
	
	/**
	 * 新增奖惩
	 */
	public void insertRewardsAndPenaltiesPo(RewardsAndPenaltiesPo po,LogisticsLogPo logPo) ;
	
	/**
	 * 查询奖惩Po
	 * 
	 * @param 
	 * @return
	 */
	public RewardsAndPenaltiesPo getRewardsAndPenaltiesPo(RewardsAndPenaltiesPo po);
	
	/**
	 * 更新奖惩
	 * 
	 * @param 
	 */
	public void updateRewardsAndPenaltiesPo(RewardsAndPenaltiesPo po,LogisticsLogPo logPo) ;
	
	/**
	 * 删除奖惩
	 * 
	 * @param 
	 */
	public void deleteRewardsAndPenaltiesPo(RewardsAndPenaltiesPo po,LogisticsLogPo logPo) ;
}
