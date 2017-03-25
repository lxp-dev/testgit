package com.pengsheng.eims.components.dao;

import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
/**
 * 商品开窗dao 接口
 */
public interface WindowInspectionDao {
	public int getWindowInspectionNormolCount(GoodsInfoPo goodsInfoPo);
	public List<GoodsInfoPo> getWindowInspectionNormolList(GoodsInfoPo goodsInfoPo,int start,int size);
	public int getWindowInspectionStealCount(GoodsInfoPo goodsInfoPo);
	public List<GoodsInfoPo> getWindowInspectionSteallList(GoodsInfoPo goodsInfoPo,int start,int size);
	public int getWindowInspectionOtherCount(GoodsInfoPo goodsInfoPo);
	public List<GoodsInfoPo> getWindowInspectionOtherList(GoodsInfoPo goodsInfoPo,int start,int size);
}
