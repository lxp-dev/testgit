package com.pengsheng.eims.storage.dao;

import java.util.List;

import com.pengsheng.eims.basic.persistence.BrandPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.storage.persistence.AdjustmentPriceEntryPo;
import com.pengsheng.eims.storage.persistence.AdjustmentPricePo;

public interface AdjustmentPriceDao {
	/**
	 * 新增调价单
	 */
	public void adjustmentPriceInsert(AdjustmentPricePo adjustmentPricePo);
	/**
	 * 新增调价明细
	 */
	public void adjustmentPriceEntryInsert(AdjustmentPriceEntryPo adjustmentPriceEntryPo);
	/**
	 * 获取调价单LIst
	 */
	public List<AdjustmentPricePo> getAdjuestmentPriceList(AdjustmentPricePo adjustmentPricePo,int start , int size);
	/**
	 * 获取调价单数量
	 */
	public int getAdjuestmentPriceCount(AdjustmentPricePo adjustmentPricePo);
	/**
	 * 删除调价单
	 */
	public void adjustmentPriceDelete(AdjustmentPricePo adjustmentPricePo);
	/**
	 * 删除调价明细
	 */
	public void adjustmentPriceEntryDelete(AdjustmentPricePo adjustmentPricePo);
	/**
	 * 修改调价单
	 */
	public void adjustmentPriceUpdate(AdjustmentPricePo adjustmentPricePo);
	/**
	 * 获得调价单实体类
	 */
	public AdjustmentPricePo getAdjuestmentPrice(AdjustmentPricePo adjustmentPricePo);
	/**
	 * 获取调价单明细List
	 */
	public List<AdjustmentPriceEntryPo> getAdjuestmentPriceEntryList(AdjustmentPricePo adjustmentPricePo);
	/**
	 * 按品种获取商品
	 * */
	public List<AdjustmentPriceEntryPo> getAdjuestmentPriceEntryList(BrandPo brandPo);
	/**
	 * 查询商品
	 */
	public GoodsInfoPo selectDimensionPo(String goodsid,String v,String whichretail);
	
	/**
	 * 零售价调价单立即生效
	 */
	public void updateAdjustmentPrice(AdjustmentPricePo adjustmentPricePo);
	
	/**
	 * 成本价调价单立即生效
	 */
	public void updateCostPrice(AdjustmentPricePo adjustmentPricePo);
	
	/**
	 * 批发价调价单立即生效
	 */
	public void updateWholesalePrice(AdjustmentPricePo adjustmentPricePo);
	
}
