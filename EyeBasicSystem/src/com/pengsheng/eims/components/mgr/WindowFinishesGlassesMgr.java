package com.pengsheng.eims.components.mgr;

import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;

public interface WindowFinishesGlassesMgr {

	/**
	 * 得到成品镜信息数量
	 * @param goodsInfoPo
	 * @return
	 */
	public int getFinishedGlassesCount(GoodsInfoPo goodsInfoPo);
	
	/**
	 * 得到成品镜信息
	 * @param goodsInfoPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<GoodsInfoPo> selectFinishedGlasses(GoodsInfoPo goodsInfoPo  , int start , int size);
	
	/**
	 * 根据商品条码得到商品信息数量
	 * @param goodsInfoPo
	 * @return
	 */
	public int getCountByGoodsbarcode(GoodsInfoPo goodsInfoPo);
	
	/**
	 * 根据商品条码得到商品信息
	 * @param goodsInfoPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<GoodsInfoPo> getListByGoodsbarcode(GoodsInfoPo goodsInfoPo , int start , int size);
}
