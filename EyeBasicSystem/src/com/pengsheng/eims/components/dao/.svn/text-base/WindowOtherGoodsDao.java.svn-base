package com.pengsheng.eims.components.dao;

import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;

public interface WindowOtherGoodsDao {
	
	/**
	 * 得到其他商品信息数量
	 * @param goodsInfoPo
	 * @return
	 */
	public int getOtherGoodsCount(GoodsInfoPo goodsInfoPo);
	
	/**
	 * 查询其他商品信息
	 * @param goodsInfoPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<GoodsInfoPo> selectOtherGoodsList(GoodsInfoPo goodsInfoPo , int start , int size);
	
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
