package com.pengsheng.eims.basic.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.dao.VisualOpticsDao;
import com.pengsheng.eims.basic.mgr.VisualOpticsMgr;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;

public class VisualOpticsMgrImpl implements VisualOpticsMgr {
	
	private LogisticsLogDao logisticsLogDao;	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}
	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

    private VisualOpticsDao visualOpticsDao;
	
	public int getVisualOpticsCount(GoodsInfoPo po) {
		return visualOpticsDao.getVisualOpticsCount(po);
	}
	
	public List<GoodsInfoPo> getVisualOpticsList(GoodsInfoPo po, int start,
			int size) {
		
		return visualOpticsDao.getVisualOpticsList(po, start, size);
	}
	
	public void insertVisualOptics(GoodsInfoPo po,LogisticsLogPo logPo) {
		visualOpticsDao.insertVisualOptics(po);
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	public void updateVisualOptics(GoodsInfoPo po,LogisticsLogPo logPo) {

		visualOpticsDao.updateVisualOptics(po);
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	public GoodsInfoPo getVisualOptics(GoodsInfoPo po) {
		
		return visualOpticsDao.getVisualOptics(po);
	}
	
	public void deleteVisualOptics(GoodsInfoPo po,LogisticsLogPo logPo) {

		visualOpticsDao.deleteVisualOptics(po);
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	public void updateVisualOpticsDisable(GoodsInfoPo po,LogisticsLogPo logPo) {

		visualOpticsDao.updateVisualOpticsDisable(po);
		logisticsLogDao.insertLog(logPo); //添加日志
	}

	public VisualOpticsDao getVisualOpticsDao() {
		return visualOpticsDao;
	}

	public void setVisualOpticsDao(VisualOpticsDao visualOpticsDao) {
		this.visualOpticsDao = visualOpticsDao;
	}
	
	/**
	 * 	获取商品库存数量
	 */
	
	public int getGoodsNumber(GoodsInfoPo po){
		return this.visualOpticsDao.getGoodsNumber(po);
	}
}
