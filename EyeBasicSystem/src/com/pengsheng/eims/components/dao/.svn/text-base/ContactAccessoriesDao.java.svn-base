package com.pengsheng.eims.components.dao;

import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;

public interface ContactAccessoriesDao {
	
	/**
	 * 得到隐形辅料商品个数
	 * @param goodsInfoPo
	 * @return
	 */
	public int getContactAccessoriesCount(GoodsInfoPo goodsInfoPo);
	
	/**
	 * 得到隐形辅料商品信息
	 * @param goodsInfoPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<GoodsInfoPo> contactAccessoriesList(GoodsInfoPo goodsInfoPo , int start , int size);
	
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
