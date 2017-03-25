package com.pengsheng.eims.basic.mgr;

import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;

public interface GlassesFinishMgr {
	
	public int getGlassesFinishCount(GoodsInfoPo po);
	
	public List<GoodsInfoPo> getGlassesFinishList(GoodsInfoPo po,int start, int size);
	
	public void insertGlassesFinish(GoodsInfoPo po,LogisticsLogPo logPo);
	
	public void updateGlassesFinish(GoodsInfoPo po,LogisticsLogPo logPo);
	
	public GoodsInfoPo getGlassesFinish(GoodsInfoPo po);
	
	public void deleteGlassesFinish(GoodsInfoPo po,LogisticsLogPo logPo);
	
	public void updateGlassesFinishDisable(GoodsInfoPo po,LogisticsLogPo logPo);

}
