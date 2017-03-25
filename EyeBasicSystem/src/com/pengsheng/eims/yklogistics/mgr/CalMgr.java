package com.pengsheng.eims.yklogistics.mgr;

import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.logistics.persistence.LCTCostingTempPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;


public interface CalMgr {	
	public void insertRealCalStorage(String date,LogisticsLogPo logPo);
	public void insertMoniCalRetrun(LogisticsLogPo logPo);
	public void insertRealCalRetrun(String date,LogisticsLogPo logPo);
	public List<LCTCostingTempPo> getResultList(GoodsInfoPo goodsInfoPo,int start , int size);
	public int getResultCount(GoodsInfoPo goodsInfoPo);
	
	public int getLastMonthDataCount();
	public void delLastMonth();
	public void fromCurrentToLastMonth();
	public void fromCurrentToHistory();
	public void delHistoryMonth(String date);
	public int selCurrentDate(String date);
	public int selLastDate(String date);
}
