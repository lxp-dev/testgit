package com.pengsheng.eims.basic.dao;

import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;

public interface OtherGoodsDao {

	public int getOtherGoodsCount(GoodsInfoPo po);
	
	public List<GoodsInfoPo> getOtherGoodsList(GoodsInfoPo po,int start, int size);
	
	public void insertOtherGoods(GoodsInfoPo po);
	
	public void updateOtherGoods(GoodsInfoPo po);
	
	public GoodsInfoPo getOtherGoods(GoodsInfoPo po);
	
	public void deleteOtherGoods(GoodsInfoPo po);
	
	public void updateOtherGoodsDisable(GoodsInfoPo po);	
	
	/**
	 * 	获取商品库存数量
	 */
	
	public int getGoodsNumber(GoodsInfoPo po);
}
