package com.pengsheng.eims.basic.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.dao.OtherGoodsDao;
import com.pengsheng.eims.basic.mgr.OtherGoodsMgr;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;

public class OtherGoodsMgrImpl implements OtherGoodsMgr {
	
	private LogisticsLogDao logisticsLogDao;	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}
	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

    private OtherGoodsDao otherGoodsDao;
	
	public int getOtherGoodsCount(GoodsInfoPo po) {
		return otherGoodsDao.getOtherGoodsCount(po);
	}
	
	public List<GoodsInfoPo> getOtherGoodsList(GoodsInfoPo po, int start,
			int size) {
		
		return otherGoodsDao.getOtherGoodsList(po, start, size);
	}
	
	public void insertOtherGoods(GoodsInfoPo po,LogisticsLogPo logPo) {

		otherGoodsDao.insertOtherGoods(po);
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	public void updateOtherGoods(GoodsInfoPo po,LogisticsLogPo logPo) {

		otherGoodsDao.updateOtherGoods(po);
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	public GoodsInfoPo getOtherGoods(GoodsInfoPo po) {
		return otherGoodsDao.getOtherGoods(po);
	}
	
	public void deleteOtherGoods(GoodsInfoPo po,LogisticsLogPo logPo) {

		otherGoodsDao.deleteOtherGoods(po);
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	public void updateOtherGoodsDisable(GoodsInfoPo po,LogisticsLogPo logPo) {

		otherGoodsDao.updateOtherGoodsDisable(po);
		logisticsLogDao.insertLog(logPo); //添加日志
	}

	public OtherGoodsDao getOtherGoodsDao() {
		return otherGoodsDao;
	}

	public void setOtherGoodsDao(OtherGoodsDao otherGoodsDao) {
		this.otherGoodsDao = otherGoodsDao;
	}
	
	/**
	 * 	获取商品库存数量
	 */
	
	public int getGoodsNumber(GoodsInfoPo po){
		return this.otherGoodsDao.getGoodsNumber(po);
	}
}
