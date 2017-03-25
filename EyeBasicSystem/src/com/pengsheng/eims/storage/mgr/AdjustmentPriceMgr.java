package com.pengsheng.eims.storage.mgr;

import java.util.List;

import com.pengsheng.eims.basic.persistence.BrandPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.persistence.AdjustmentPriceEntryPo;
import com.pengsheng.eims.storage.persistence.AdjustmentPricePo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;

public interface AdjustmentPriceMgr {
	public void adjustmentPriceEntryInsert(AdjustmentPriceEntryPo adjustmentPriceEntryPo);
	public List<AdjustmentPricePo> getAdjuestmentPriceList(AdjustmentPricePo adjustmentPricePo,int start , int size);
	public int getAdjuestmentPriceCount(AdjustmentPricePo adjustmentPricePo);
	public void deleteAdjustmentPrice(AdjustmentPricePo adjustmentPricePo,LogisticsLogPo logPo);
	
	public void updateAdjustmentPrice(AdjustmentPricePo adjustmentPricePo,List<AdjustmentPriceEntryPo> adjustmentPriceEntryList,LogisticsLogPo logPo,SystemParameterPo spo);
	public AdjustmentPricePo getAdjuestmentPrice(AdjustmentPricePo adjustmentPricePo);
	public List<AdjustmentPriceEntryPo> getAdjuestmentPriceEntryList(AdjustmentPricePo adjustmentPricePo);
	/**
	 * 按品种获取商品
	 * */
	public List<AdjustmentPriceEntryPo> getAdjuestmentPriceEntryList(BrandPo brandPo);
	/**
	 * 查询商品信息
	 * @param goodsids
	 * @param vs
	 * @return
	 */
	public List<GoodsInfoPo> selectDimensionPos(List<String> goodsids,List<String> vs,String whichretail);
	
	public void updateChangePriceBill(AdjustmentPricePo adjustmentPricePo,String type,LogisticsLogPo logPo);
	
	public void insertAdjustmentPrice(AdjustmentPricePo adjustmentPricePo,List<AdjustmentPriceEntryPo> adjustmentPriceEntryList,LogisticsLogPo logPo,SystemParameterPo spo);

}
