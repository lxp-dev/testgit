package com.pengsheng.eims.components.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.components.dao.WindowFramesAccessoriesDao;
import com.pengsheng.eims.components.mgr.WindowFramesAccessoriesMgr;

public class WindowFramesAccessoriesMgrImpl implements
		WindowFramesAccessoriesMgr {

	private WindowFramesAccessoriesDao windowFramesAccessoriesDao;
	
	public WindowFramesAccessoriesDao getWindowFramesAccessoriesDao() {
		return windowFramesAccessoriesDao;
	}

	public void setWindowFramesAccessoriesDao(
			WindowFramesAccessoriesDao windowFramesAccessoriesDao) {
		this.windowFramesAccessoriesDao = windowFramesAccessoriesDao;
	}

	/**
	 * 得到镜架辅料信息数量
	 * @param goodsInfoPo
	 * @return
	 */
	public int getFramesAccessoriesCount(GoodsInfoPo goodsInfoPo) {
		// TODO Auto-generated method stub
		return windowFramesAccessoriesDao.getFramesAccessoriesCount(goodsInfoPo);
	}

	/**
	 * 查询镜架辅料信息
	 * @param goodsInfoPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<GoodsInfoPo> selectFramesAccessoriesList(GoodsInfoPo goodsInfoPo,
			int start, int size) {
		// TODO Auto-generated method stub
		return windowFramesAccessoriesDao.selectFramesAccessoriesList(goodsInfoPo, start, size);
	}
	
	/**
	 * 根据商品条码得到商品信息数量
	 */
	public int getCountByGoodsbarcode(GoodsInfoPo goodsInfoPo) {
		// TODO Auto-generated method stub
		return windowFramesAccessoriesDao.getCountByGoodsbarcode(goodsInfoPo);
	}

	/**
	 * 根据商品条码得到商品信息
	 */
	public List<GoodsInfoPo> getListByGoodsbarcode(GoodsInfoPo goodsInfoPo,
			int start, int size) {
		// TODO Auto-generated method stub
		return windowFramesAccessoriesDao.getListByGoodsbarcode(goodsInfoPo, start, size);
	}

}
