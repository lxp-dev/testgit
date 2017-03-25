package com.pengsheng.eims.yklogistics.dao;

import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.logistics.persistence.LCTCostingTempPo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;


public interface CalDao {	
	public void realCalStorage(String date);
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
	public int selLastDate(String date);
	
	/**
	 *  更新基础信息的商品的平均成本
	 */
	public void updateGoodsAverageNotTaxRate();
}
