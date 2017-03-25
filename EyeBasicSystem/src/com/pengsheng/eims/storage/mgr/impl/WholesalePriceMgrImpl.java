package com.pengsheng.eims.storage.mgr.impl;

import java.util.List;

import com.pengsheng.eims.quartz.dao.WholesalePriceJobDao;
import com.pengsheng.eims.storage.dao.WholesalePriceDao;
import com.pengsheng.eims.storage.mgr.WholesalePriceMgr;
import com.pengsheng.eims.storage.persistence.WholesalePriceEntryPo;
import com.pengsheng.eims.storage.persistence.WholesalePricePo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.basic.persistence.BrandPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;

public class WholesalePriceMgrImpl extends BaseJdbcDaoSupport implements WholesalePriceMgr {
	
	private LogisticsLogDao logisticsLogDao;	
	private WholesalePriceJobDao wholesalePriceJobDao = null;
	
	public WholesalePriceJobDao getWholesalePriceJobDao() {
		return wholesalePriceJobDao;
	}
	public void setWholesalePriceJobDao(WholesalePriceJobDao wholesalePriceJobDao) {
		this.wholesalePriceJobDao = wholesalePriceJobDao;
	}
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}
	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	private WholesalePriceDao wholesalePriceDao;
	
	public WholesalePriceDao getWholesalePriceDao() {
		return wholesalePriceDao;
	}

	public void setWholesalePriceDao(WholesalePriceDao wholesalePriceDao) {
		this.wholesalePriceDao = wholesalePriceDao;
	}

	
	public void deleteWholesalePrice(WholesalePricePo wholesalePricePo,LogisticsLogPo logPo) {
		// TODO Auto-generated method stub
		this.wholesalePriceDao.wholesalePriceDelete(wholesalePricePo);
		this.wholesalePriceDao.wholesalePriceEntryDelete(wholesalePricePo);
		logisticsLogDao.insertLog(logPo); //添加日志
	}


	public void wholesalePriceEntryInsert(
			WholesalePriceEntryPo wholesalePriceEntryPo) {
		// TODO Auto-generated method stub
		
		this.wholesalePriceDao.wholesalePriceEntryInsert(wholesalePriceEntryPo);
	}

	
	public void insertWholesalePrice(WholesalePricePo wholesalePricePo,List<WholesalePriceEntryPo> wholesalePriceEntryList,LogisticsLogPo logPo) {

		for(int i=0;i<wholesalePriceEntryList.size();i++){
			WholesalePriceEntryPo wholesalePriceEntryPo=wholesalePriceEntryList.get(i);
			this.wholesalePriceDao.wholesalePriceEntryInsert(wholesalePriceEntryPo);
		}
		
		wholesalePriceDao.wholesalePriceInsert(wholesalePricePo);
		
		if (Utility.getName(wholesalePricePo.getCprwpflag()).equals("0")){  //实时调价
			if (!Utility.getName(wholesalePricePo.getCprwpauditstate()).equals("0")){
				for(int i=0;i<wholesalePriceEntryList.size();i++){
					WholesalePriceEntryPo wholesalePriceEntryPo=wholesalePriceEntryList.get(i);
					wholesalePriceJobDao.wholesalePriceEffective(wholesalePriceEntryPo);
				}
			}
		}
		
		logisticsLogDao.insertLog(logPo); //添加日志
	}


	public void updateWholesalePrice(WholesalePricePo wholesalePricePo,List<WholesalePriceEntryPo> wholesalePriceEntryList,LogisticsLogPo logPo) {

		this.wholesalePriceDao.wholesalePriceUpdate(wholesalePricePo);
		
		this.wholesalePriceDao.wholesalePriceEntryDelete(wholesalePricePo);
		for (int i = 0; i < wholesalePriceEntryList.size(); i++) {
			WholesalePriceEntryPo wholesalePriceEntryPo=wholesalePriceEntryList.get(i);
			wholesalePriceDao.wholesalePriceEntryInsert(wholesalePriceEntryPo);
		}
		
		if (Utility.getName(wholesalePricePo.getCprwpflag()).equals("0")){  //实时调价
			if (!Utility.getName(wholesalePricePo.getCprwpauditstate()).equals("0")){
				for(int i = 0;i < wholesalePriceEntryList.size(); i++){
					WholesalePriceEntryPo wholesalePriceEntryPo=wholesalePriceEntryList.get(i);
					wholesalePriceJobDao.wholesalePriceEffective(wholesalePriceEntryPo);
				}
			}
		}
		
		logisticsLogDao.insertLog(logPo); //添加日志
	}


	public int getWholesalePriceCount(WholesalePricePo wholesalePricePo) {
		return wholesalePriceDao.getWholesalePriceCount(wholesalePricePo);
	}


	public List<WholesalePricePo> getWholesalePriceList(
			WholesalePricePo wholesalePricePo,int start , int size) {
		return wholesalePriceDao.getWholesalePriceList(wholesalePricePo, start, size);
	}


	public WholesalePricePo getWholesalePrice(
			WholesalePricePo wholesalePricePo) {
		return this.wholesalePriceDao.getWholesalePrice(wholesalePricePo);
	}

	
	public List<WholesalePriceEntryPo> getWholesalePriceEntryList(
			WholesalePricePo wholesalePricePo) {
		return this.wholesalePriceDao.getWholesalePriceEntryList(wholesalePricePo);
	}
	/**
	 * 得到调价明细信息表体
	 * @param adcostPricePo
	 * @return
	 */
	public List<WholesalePriceEntryPo> getWholesalePriceEntryList(BrandPo brandPo){
		
		return wholesalePriceDao.getWholesalePriceEntryList(brandPo);
	}
}
