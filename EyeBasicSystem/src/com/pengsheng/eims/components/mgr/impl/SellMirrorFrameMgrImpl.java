package com.pengsheng.eims.components.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.components.dao.InTransitDetailsDao;
import com.pengsheng.eims.components.dao.SellMirrorFrameDao;
import com.pengsheng.eims.components.mgr.SellMirrorFrameMgr;
import com.pengsheng.eims.sales.persistence.InTransitStorageEntryPo;
import com.pengsheng.eims.util.tools.Utility;

public class SellMirrorFrameMgrImpl implements SellMirrorFrameMgr {

	private SellMirrorFrameDao sellMirrorFrameDao;
	private InTransitDetailsDao inTransitDetailsDao;
	
	public InTransitDetailsDao getInTransitDetailsDao() {
		return inTransitDetailsDao;
	}

	public void setInTransitDetailsDao(InTransitDetailsDao inTransitDetailsDao) {
		this.inTransitDetailsDao = inTransitDetailsDao;
	}

	public SellMirrorFrameDao getSellMirrorFrameDao() {
		return sellMirrorFrameDao;
	}

	public void setSellMirrorFrameDao(SellMirrorFrameDao sellMirrorFrameDao) {
		this.sellMirrorFrameDao = sellMirrorFrameDao;
	}


	/**
	 * 查询销售镜架信息
	 */
	public int getSellMirrorFrameCount(GoodsInfoPo po) {
		
		return  sellMirrorFrameDao.getSellMirrorFrameCount(po);
	}
	
	public int getSellMirrorFrameCountAll(GoodsInfoPo po){
		return  sellMirrorFrameDao.getSellMirrorFrameCountAll(po);
	}
	
	public int getSellMirrorFrameCountBatch(GoodsInfoPo po){
		return  sellMirrorFrameDao.getSellMirrorFrameCountBatch(po);
	}
	
	public int getSellMirrorFrameCount1(GoodsInfoPo po) {
		
		return  sellMirrorFrameDao.getSellMirrorFrameCount1(po);
	}

	/**
	 * 遍历查询销售镜架信息
	 */
	public List<GoodsInfoPo> getSellMirrorFrameList(GoodsInfoPo po,
			int start, int size) {
		return sellMirrorFrameDao.getSellMirrorFrameList(po, start, size);
	}
	
	public List<GoodsInfoPo> getSellMirrorFrameListAll(GoodsInfoPo po,int start, int size){
		
		List<GoodsInfoPo> list = sellMirrorFrameDao.getSellMirrorFrameListAll(po, start, size);		
		
		return list;
		
	}
	
	public List<GoodsInfoPo> getSellMirrorFrameListBatch(GoodsInfoPo po,int start, int size){
		List<GoodsInfoPo> list = sellMirrorFrameDao.getSellMirrorFrameListBatch(po, start, size);
		
		return list;
	}
	
	public List<GoodsInfoPo> getSellMirrorFrameList1(GoodsInfoPo po,
			int start, int size) {
		return sellMirrorFrameDao.getSellMirrorFrameList1(po, start, size);
	}

	public List<GoodsInfoPo> getScanGoodsList(GoodsInfoPo po){
		List<GoodsInfoPo> list = sellMirrorFrameDao.getScanGoodsList(po);
		
		return list;
	}
	
	public List<GoodsInfoPo> getScanGoodsList1(GoodsInfoPo po){
		List<GoodsInfoPo> list = sellMirrorFrameDao.getScanGoodsList1(po);
		
		return list;
	}
	
	public int getSellMirrorFrameCountBatchNew(GoodsInfoPo po){
		return  sellMirrorFrameDao.getSellMirrorFrameCountBatchNew(po);
	}
	
	public List<GoodsInfoPo> getSellMirrorFrameListBatchNew(GoodsInfoPo po,int start, int size){
		return sellMirrorFrameDao.getSellMirrorFrameListBatchNew(po, start, size);
	}
	
	public int getSellMirrorFrameCountAllNew(GoodsInfoPo po){
		return  sellMirrorFrameDao.getSellMirrorFrameCountAllNew(po);
	}
	
	public List<GoodsInfoPo> getSellMirrorFrameListAllNew(GoodsInfoPo po,int start, int size){
		return sellMirrorFrameDao.getSellMirrorFrameListAllNew(po, start, size);	
	}
	
	public List<GoodsInfoPo> getScanGoodsListNew(GoodsInfoPo po){
		return sellMirrorFrameDao.getScanGoodsListNew(po);
	}
	
	public List<GoodsInfoPo> getScanGoodsList1New(GoodsInfoPo po){
		return sellMirrorFrameDao.getScanGoodsList1New(po);
	}
	
}
