package com.pengsheng.eims.basic.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.dao.GiftsDao;
import com.pengsheng.eims.basic.mgr.GiftsMgr;
import com.pengsheng.eims.basic.persistence.GiftsPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;

public class GiftsMgrImpl extends BaseJdbcDaoSupport implements GiftsMgr {
	
	private LogisticsLogDao logisticsLogDao;	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}
	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	private GiftsDao giftsDao;
	public GiftsDao getGiftsDao() {
		return giftsDao;
	}

	public void setGiftsDao(GiftsDao giftsDao) {
		this.giftsDao = giftsDao;
	}

	public void deleteGifts(GiftsPo giftsPo,LogisticsLogPo logPo) {
		// TODO Auto-generated method stub
		this.giftsDao.deleteGifts(giftsPo);
		logisticsLogDao.insertLog(logPo); //添加日志
		
	}

	public void insertGifts(GiftsPo giftsPo,LogisticsLogPo logPo) {
		this.giftsDao.insertGifts(giftsPo);
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	public int getGiftsCount(GiftsPo po){
		return giftsDao.getGiftsCount(po);
	}

	public void updateGifts(GiftsPo giftsPo,LogisticsLogPo logPo) {
		// TODO Auto-generated method stub
		this.giftsDao.updateGifts(giftsPo);
		logisticsLogDao.insertLog(logPo); //添加日志
	}

	/*
	 * 修改赠品
	 */
	public void updateGiftsDepartment(GiftsPo giftsPo,LogisticsLogPo logPo){
		this.giftsDao.updateGiftsDepartment(giftsPo);
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	public List<GiftsPo> getGifts() {
		// TODO Auto-generated method stub
		return this.giftsDao.getGifts();
	}

	public void ableGifts(GiftsPo giftsPo,LogisticsLogPo logPo) {
		// TODO Auto-generated method stub
		this.giftsDao.ableGifts(giftsPo);
		logisticsLogDao.insertLog(logPo); //添加日志
	}

	public void disableGifts(GiftsPo giftsPo,LogisticsLogPo logPo) {
		// TODO Auto-generated method stub
		this.giftsDao.disableGifts(giftsPo);
		logisticsLogDao.insertLog(logPo); //添加日志
	}

	public GiftsPo getGift(GiftsPo giftsPo) {
		// TODO Auto-generated method stub
		return this.giftsDao.getGift(giftsPo);
	}
	
	public List<GiftsPo> getGifts(GiftsPo giftsPo) {
		// TODO Auto-generated method stub
		return this.giftsDao.getGifts(giftsPo);
	}

	public int getGiftsCount2(GiftsPo po){
		return giftsDao.getGiftsCount2(po);
	}
	
	public List<GiftsPo> getGifts(GiftsPo giftsPo, int start, int size) {
		// TODO Auto-generated method stub
		return this.giftsDao.getGifts(giftsPo,start,size);
	}
	
}
