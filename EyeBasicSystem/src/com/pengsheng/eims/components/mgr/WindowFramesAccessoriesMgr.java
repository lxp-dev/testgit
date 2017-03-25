package com.pengsheng.eims.components.mgr;

import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;

public interface WindowFramesAccessoriesMgr {

	/**
	 * 得到镜架辅料信息数量
	 * @param goodsInfoPo
	 * @return
	 */
	public int getFramesAccessoriesCount(GoodsInfoPo goodsInfoPo);
	
	/**
	 * 查询镜架辅料信息
	 * @param goodsInfoPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<GoodsInfoPo> selectFramesAccessoriesList(GoodsInfoPo goodsInfoPo , int start , int size);
	
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
