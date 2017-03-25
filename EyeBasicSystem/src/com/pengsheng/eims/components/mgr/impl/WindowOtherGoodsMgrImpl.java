package com.pengsheng.eims.components.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.components.dao.WindowOtherGoodsDao;
import com.pengsheng.eims.components.mgr.WindowOtherGoodsMgr;

public class WindowOtherGoodsMgrImpl implements WindowOtherGoodsMgr {

	private WindowOtherGoodsDao windowOtherGoodsDao;
	
	public WindowOtherGoodsDao getWindowOtherGoodsDao() {
		return windowOtherGoodsDao;
	}

	public void setWindowOtherGoodsDao(WindowOtherGoodsDao windowOtherGoodsDao) {
		this.windowOtherGoodsDao = windowOtherGoodsDao;
	}

	/**
	 * 得到其他商品信息数量
	 * @param goodsInfoPo
	 * @return
	 */
	public int getOtherGoodsCount(GoodsInfoPo goodsInfoPo) {
		// TODO Auto-generated method stub
		return windowOtherGoodsDao.getOtherGoodsCount(goodsInfoPo);
	}

	/**
	 * 查询其他商品信息
	 * @param goodsInfoPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<GoodsInfoPo> selectOtherGoodsList(GoodsInfoPo goodsInfoPo,
			int start, int size) {
		// TODO Auto-generated method stub
		return windowOtherGoodsDao.selectOtherGoodsList(goodsInfoPo, start, size);
	}
	
	/**
	 * 根据商品条码得到商品信息数量
	 */
	public int getCountByGoodsbarcode(GoodsInfoPo goodsInfoPo) {
		// TODO Auto-generated method stub
		return windowOtherGoodsDao.getCountByGoodsbarcode(goodsInfoPo);
	}

	/**
	 * 根据商品条码得到商品信息
	 */
	public List<GoodsInfoPo> getListByGoodsbarcode(GoodsInfoPo goodsInfoPo,
			int start, int size) {
		// TODO Auto-generated method stub
		return windowOtherGoodsDao.getListByGoodsbarcode(goodsInfoPo, start, size);
	}

}
