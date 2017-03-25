package com.pengsheng.eims.basic.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.dao.GoodsLevelDao;
import com.pengsheng.eims.basic.mgr.GoodsLevelMgr;
import com.pengsheng.eims.basic.persistence.GoodsLevelPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.dao.WorkTypeDao;
import com.pengsheng.eims.system.mgr.WorkTypeMgr;
import com.pengsheng.eims.system.persistence.PersonTypePo;
import com.pengsheng.eims.system.persistence.WorkTypePo;

/**
 * GoodsLeveleMgr 商品级别Mgr
 * 
 * @author zhangkun
 * @version 1.0
 * @see GoodsLeveleMgr
 */
public class GoodsLevelMgrImpl implements GoodsLevelMgr {



	private LogisticsLogDao logisticsLogDao = null;
	private GoodsLevelDao goodsLevelDao;
	
	
	public GoodsLevelDao getGoodsLevelDao() {
		return goodsLevelDao;
	}

	public void setGoodsLevelDao(GoodsLevelDao goodsLevelDao) {
		this.goodsLevelDao = goodsLevelDao;
	}
	

	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}



	public void insertGoodsLevel(GoodsLevelPo po, LogisticsLogPo logPo) {
		goodsLevelDao.insertGoodsLevel(po);
		logisticsLogDao.insertLog(logPo);
		
	}


	public int getGoodsLevelId(GoodsLevelPo po) {
		
		return goodsLevelDao.getGoodsLevelId(po);
	}


	public int getGoodsLevelName(GoodsLevelPo po) {
		
		return goodsLevelDao.getGoodsLevelName(po);
	}


	public int getGoodsLevelCount(GoodsLevelPo po) {
		return goodsLevelDao.getGoodsLevelCount(po);
		
	}


	public int getGoodsLevelNameUpdate(GoodsLevelPo po) {
		
		return goodsLevelDao.getGoodsLevelName(po);
	}


	public GoodsLevelPo getGoodsLevelPo(GoodsLevelPo po) {
		
		return goodsLevelDao.getGoodsLevelPo(po);
	}


	public List<GoodsLevelPo> getGoodsLevelList(GoodsLevelPo po, int start,
			int size) {
		// TODO Auto-generated method stub
		return goodsLevelDao.getGoodsLevelList(po, start, size);
	}


	public List getGoodsLevelList() {
		// TODO Auto-generated method stub
		return null;
	}


	public int getGoodsLevelWithGoods(GoodsLevelPo po) {
		// TODO Auto-generated method stub
		return 0;
	}


	public void updateGoodsLevel(GoodsLevelPo po, LogisticsLogPo logPo) {
		goodsLevelDao.updateGoodsLevel(po);
		logisticsLogDao.insertLog(logPo);
		
	}


	public int getGoodsLevelDiscountUpdate(GoodsLevelPo po) {
		
		return goodsLevelDao.getGoodsLevelDiscountUpdate(po);
	}


	public void deleteGoodsLevel(GoodsLevelPo po, LogisticsLogPo logPo) {
		goodsLevelDao.deleteGoodsLevel(po);		
		logisticsLogDao.insertLog(logPo);
	}
}
