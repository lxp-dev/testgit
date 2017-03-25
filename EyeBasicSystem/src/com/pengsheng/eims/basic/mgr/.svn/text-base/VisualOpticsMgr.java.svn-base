package com.pengsheng.eims.basic.mgr;

import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;

public interface VisualOpticsMgr {
	
	public int getVisualOpticsCount(GoodsInfoPo po);
	
	public List<GoodsInfoPo> getVisualOpticsList(GoodsInfoPo po,int start, int size);
	
	public void insertVisualOptics(GoodsInfoPo po,LogisticsLogPo logPo);
	
	public void updateVisualOptics(GoodsInfoPo po,LogisticsLogPo logPo);
	
	public GoodsInfoPo getVisualOptics(GoodsInfoPo po);
	
	public void deleteVisualOptics(GoodsInfoPo po,LogisticsLogPo logPo);
	
	public void updateVisualOpticsDisable(GoodsInfoPo po,LogisticsLogPo logPo);

	/**
	 * 	获取商品库存数量
	 */
	
	public int getGoodsNumber(GoodsInfoPo po);
}
