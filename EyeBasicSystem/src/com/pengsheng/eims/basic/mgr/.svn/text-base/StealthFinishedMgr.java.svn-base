package com.pengsheng.eims.basic.mgr;

import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;

public interface StealthFinishedMgr {

	public int getStealthFinishedCount(GoodsInfoPo po);
	
	public List<GoodsInfoPo> getStealthFinishedList(GoodsInfoPo po,int start, int size);
	
	public void insertStealthFinished(GoodsInfoPo po,LogisticsLogPo logPo);
	
	public void updateStealthFinished(GoodsInfoPo po,LogisticsLogPo logPo);
	
	public GoodsInfoPo getStealthFinished(GoodsInfoPo po);
	
	public void deleteStealthFinished(GoodsInfoPo po,LogisticsLogPo logPo);
	
	public void updateStealthFinishedDisable(GoodsInfoPo po,LogisticsLogPo logPo);
	
	public void insertStealthFinishedBulk(SystemParameterPo systemParameterPo,GoodsInfoPo po,LogisticsLogPo logPo);
}
