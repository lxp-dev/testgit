package com.pengsheng.eims.components.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.components.dao.WindowInspectionDao;
import com.pengsheng.eims.components.mgr.WindowInspectionMgr;

public class WindowInspectionMgrImpl implements WindowInspectionMgr{

	private WindowInspectionDao windowInspectionDao;
	public WindowInspectionDao getWindowInspectionDao() {
		return windowInspectionDao;
	}

	public void setWindowInspectionDao(WindowInspectionDao windowInspectionDao) {
		this.windowInspectionDao = windowInspectionDao;
	}


	public int getWindowInspectionNormolCount(GoodsInfoPo goodsInfoPo) {
		// TODO Auto-generated method stub
		return this.windowInspectionDao.getWindowInspectionNormolCount(goodsInfoPo);
	}


	public List<GoodsInfoPo> getWindowInspectionNormolList(
			GoodsInfoPo goodsInfoPo,int start , int size) {
		// TODO Auto-generated method stub
		return this.windowInspectionDao.getWindowInspectionNormolList(goodsInfoPo,start ,size);
	}
	
	public int getWindowInspectionOtherCount(GoodsInfoPo goodsInfoPo){		
		return this.windowInspectionDao.getWindowInspectionOtherCount(goodsInfoPo);
	}
	

	public List<GoodsInfoPo> getWindowInspectionOtherList(
			GoodsInfoPo goodsInfoPo,int start , int size) {
		// TODO Auto-generated method stub
		return this.windowInspectionDao.getWindowInspectionOtherList(goodsInfoPo,start ,size);
	}	
}
