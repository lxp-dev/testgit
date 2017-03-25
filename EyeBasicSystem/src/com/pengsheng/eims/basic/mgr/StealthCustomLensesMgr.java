package com.pengsheng.eims.basic.mgr;

import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;

public interface StealthCustomLensesMgr {
	
	public int getStealthCustomLensesCount(GoodsInfoPo po);
	
	public List<GoodsInfoPo> getStealthCustomLensesList(GoodsInfoPo po,int start, int size);
	
	public void insertStealthCustomLenses(GoodsInfoPo po,LogisticsLogPo logPo);
	
	public void updateStealthCustomLenses(GoodsInfoPo po,LogisticsLogPo logPo);
	
	public GoodsInfoPo getStealthCustomLenses(GoodsInfoPo po);
	
	public void deleteStealthCustomLenses(GoodsInfoPo po,LogisticsLogPo logPo);
	
	public void updateStealthCustomLensesDisable(GoodsInfoPo po,LogisticsLogPo logPo);

}
