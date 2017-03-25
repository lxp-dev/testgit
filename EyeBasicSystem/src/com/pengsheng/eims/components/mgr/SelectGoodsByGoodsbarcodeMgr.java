package com.pengsheng.eims.components.mgr;

import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;

public interface SelectGoodsByGoodsbarcodeMgr {

	/**
	 * 根据条码查询商品
	 * @param goodsInfoPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<GoodsInfoPo> selectGoodsByGoodsbarcode(GoodsInfoPo goodsInfoPo , int start , int size);
	
	/**
	 * 根据条码查询商品数量
	 * @param goodsInfoPo
	 * @return
	 */
	public int goodsByGoodsbarcodeCount(GoodsInfoPo goodsInfoPo);
}
