package com.pengsheng.eims.basic.mgr;

import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;

public interface OtherGoodsMgr {
	
	public int getOtherGoodsCount(GoodsInfoPo po);
	
	public List<GoodsInfoPo> getOtherGoodsList(GoodsInfoPo po,int start, int size);
	
	public void insertOtherGoods(GoodsInfoPo po,LogisticsLogPo logPo);
	
	public void updateOtherGoods(GoodsInfoPo po,LogisticsLogPo logPo);
	
	public GoodsInfoPo getOtherGoods(GoodsInfoPo po);
	
	public void deleteOtherGoods(GoodsInfoPo po,LogisticsLogPo logPo);
	
	public void updateOtherGoodsDisable(GoodsInfoPo po,LogisticsLogPo logPo);

	/**
	 * 	获取商品库存数量
	 */
	
	public int getGoodsNumber(GoodsInfoPo po);
}
