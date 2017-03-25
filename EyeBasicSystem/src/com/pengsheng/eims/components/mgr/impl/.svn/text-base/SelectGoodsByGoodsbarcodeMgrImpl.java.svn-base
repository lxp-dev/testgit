package com.pengsheng.eims.components.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.components.dao.SelectGoodsByGoodsbarcodeDao;
import com.pengsheng.eims.components.mgr.SelectGoodsByGoodsbarcodeMgr;

public class SelectGoodsByGoodsbarcodeMgrImpl implements
		SelectGoodsByGoodsbarcodeMgr {

	private SelectGoodsByGoodsbarcodeDao selectGoodsByGoodsbarcodeDao;
	
	public SelectGoodsByGoodsbarcodeDao getSelectGoodsByGoodsbarcodeDao() {
		return selectGoodsByGoodsbarcodeDao;
	}

	public void setSelectGoodsByGoodsbarcodeDao(
			SelectGoodsByGoodsbarcodeDao selectGoodsByGoodsbarcodeDao) {
		this.selectGoodsByGoodsbarcodeDao = selectGoodsByGoodsbarcodeDao;
	}

	/**
	 * 根据条码查询商品数量
	 * @param goodsInfoPo
	 * @return
	 */
	public int goodsByGoodsbarcodeCount(GoodsInfoPo goodsInfoPo) {
		// TODO Auto-generated method stub
		return selectGoodsByGoodsbarcodeDao.goodsByGoodsbarcodeCount(goodsInfoPo);
	}

	/**
	 * 根据条码查询商品
	 * @param goodsInfoPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<GoodsInfoPo> selectGoodsByGoodsbarcode(GoodsInfoPo goodsInfoPo,
			int start, int size) {
		// TODO Auto-generated method stub
		return selectGoodsByGoodsbarcodeDao.selectGoodsByGoodsbarcode(goodsInfoPo, start, size);
	}

}
