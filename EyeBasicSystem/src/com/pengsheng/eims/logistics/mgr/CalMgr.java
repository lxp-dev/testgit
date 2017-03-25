package com.pengsheng.eims.logistics.mgr;

import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.logistics.persistence.LCTCostingTempPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;


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
	
	/**
	 * 初始化加权平均计算
	 */
	public void updateWeightingCal(LogisticsLogPo logPo);
	
	/**
	 * 自动进行加权平均计算
	 */
	public void insertAutoCostAccount(String companyID,List<String> dateList,SystemParameterPo spo,LogisticsLogPo logPo);
	
	/**
	 * 初始化查看成本回填单据
	 */
	public int getCostResultBillCount(InventoryPo po);
	
	/**
	 * 查看成本回填单据
	 */
	public List<InventoryPo> getCostResultBillList(InventoryPo po,int start , int size);
	
	public void insertCostAccountNotBill(String companyID,SystemParameterPo spo,LogisticsLogPo logPo);
	
	public void insertCostAccountBill(String companyID,SystemParameterPo spo,LogisticsLogPo logPo);
	
	public void updateAccountPeriodSet(String companyID,String year,String month,LogisticsLogPo logPo);
	
}
