package com.pengsheng.eims.logistics.dao;

import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.logistics.persistence.AutoCostAccountPo;
import com.pengsheng.eims.logistics.persistence.LCTCostingTempPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;


public interface CalDao {	
	public void realCalStorage(String date,String flag);
	public void realCalStorageDel();
	public void moniCalRetrun();
	public void realCalRetrun(InventoryEntryPo po);
	public List<LCTCostingTempPo> getResultList(GoodsInfoPo goodsInfoPo,int start , int size);
	public int getResultCount(GoodsInfoPo goodsInfoPo);
	
	public List<InventoryEntryPo> selRealCal(String date);
	public int getLastMonthDataCount();
	public void delLastMonth();
	public void fromCurrentToLastMonth();
	public void fromCurrentToHistory();	
	public void delHistoryMonth(String date);
	public int selCurrentDate(String date);
	public void updateNotTaxRateAmount(InventoryEntryPo po) ;
	public void updateInventoryFillCostPrice(InventoryEntryPo po);
	public int selLastDate(String date);
	
	/**
	 *  更新基础信息的商品的平均成本
	 */
	public void updateGoodsAverageNotTaxRate();
	
	public void fromLastMonthToCurrentMonth();
	
	/**
	 * 自动进行加权平均计算
	 */
	public void autoCostAccount(String companyID,List<String> dateList);
	
	/**
	 * 初始化查看成本回填单据
	 */
	public int getCostResultBillCount(InventoryPo po);
	
	/**
	 * 查看成本回填单据
	 */
	public List<InventoryPo> getCostResultBillList(InventoryPo po,int start , int size);
	
	/**
	 * 成本回填单据
	 */
	public void updateBillAvgCostByCal(String date);	
	
	public void realCalStorage(List<AutoCostAccountPo> acaList,String flag,String companyID,String htbillflag);
	
	public void updateBillAvgCostByCal(String date,String companyID);	
	
	/**
	 * 自动进行成本计算完成
	 */
	public void autoCostAccountFinish(List<AutoCostAccountPo> acaList,String companyID);
	
	public void updateAccountPeriodSet(String companyID,String year,String month);
	
}
