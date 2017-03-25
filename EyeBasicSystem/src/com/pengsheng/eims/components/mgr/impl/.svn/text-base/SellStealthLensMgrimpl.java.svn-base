/**
 * 
 */
package com.pengsheng.eims.components.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoTempPo;
import com.pengsheng.eims.components.dao.CustomerOptometryDao;
import com.pengsheng.eims.components.dao.SellLensDao;
import com.pengsheng.eims.components.mgr.CustomerOptometryMgr;
import com.pengsheng.eims.components.mgr.SellLensMgr;
import com.pengsheng.eims.sales.persistence.OptometryPo;

/**
 * @author Liuqian
 * 
 */
public class SellStealthLensMgrimpl implements SellLensMgr {

	private SellLensDao sellLensDao;
	
	public SellLensDao getSellLensDao() {
		return sellLensDao;
	}

	public void setSellLensDao(SellLensDao sellLensDao) {
		this.sellLensDao = sellLensDao;
	}


	public int getSellLensCount(GoodsInfoTempPo goodsInfoTempPo) {
		// TODO Auto-generated method stub
		
		return this.sellLensDao.getSellLensCount(goodsInfoTempPo);
	}


	public List<GoodsInfoPo> getSellLensList(GoodsInfoTempPo goodsInfoTempPo, int start, int size) {
		// TODO Auto-generated method stub
		return this.sellLensDao.getSellLensList(goodsInfoTempPo, start, size);
	}

	

}
