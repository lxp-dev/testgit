package com.pengsheng.eims.components.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.components.dao.WindowFinishedGlassesDao;
import com.pengsheng.eims.components.mgr.WindowFinishesGlassesMgr;

public class WindowFinishedGlassesMgrImpl implements WindowFinishesGlassesMgr {

	private WindowFinishedGlassesDao windowFinishedGlassesDao;
	
	public WindowFinishedGlassesDao getWindowFinishedGlassesDao() {
		return windowFinishedGlassesDao;
	}

	public void setWindowFinishedGlassesDao(
			WindowFinishedGlassesDao windowFinishedGlassesDao) {
		this.windowFinishedGlassesDao = windowFinishedGlassesDao;
	}

	/**
	 * 得到成品镜信息数量
	 * @param goodsInfoPo
	 * @return
	 */
	public int getFinishedGlassesCount(GoodsInfoPo goodsInfoPo) {
		// TODO Auto-generated method stub
		return windowFinishedGlassesDao.getFinishedGlassesCount(goodsInfoPo);
	}

	/**
	 * 得到成品镜信息
	 * @param goodsInfoPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<GoodsInfoPo> selectFinishedGlasses(GoodsInfoPo goodsInfoPo,
			int start, int size) {
		// TODO Auto-generated method stub
		return windowFinishedGlassesDao.selectFinishedGlasses(goodsInfoPo, start, size);
	}
	
	/**
	 * 根据商品条码得到商品信息数量
	 */
	public int getCountByGoodsbarcode(GoodsInfoPo goodsInfoPo) {
		// TODO Auto-generated method stub
		return windowFinishedGlassesDao.getCountByGoodsbarcode(goodsInfoPo);
	}

	/**
	 * 根据商品条码得到商品信息
	 */
	public List<GoodsInfoPo> getListByGoodsbarcode(GoodsInfoPo goodsInfoPo,
			int start, int size) {
		// TODO Auto-generated method stub
		return windowFinishedGlassesDao.getListByGoodsbarcode(goodsInfoPo, start, size);
	}

}
