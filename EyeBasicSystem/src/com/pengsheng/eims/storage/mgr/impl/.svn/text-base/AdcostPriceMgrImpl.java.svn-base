package com.pengsheng.eims.storage.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.persistence.BrandPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.quartz.dao.AdcostPriceJobDao;
import com.pengsheng.eims.storage.dao.AdcostPriceDao;
import com.pengsheng.eims.storage.mgr.AdcostPriceMgr;
import com.pengsheng.eims.storage.persistence.AdcostPriceEntryPo;
import com.pengsheng.eims.storage.persistence.AdcostPricePo;
import com.pengsheng.eims.storage.persistence.AdjustmentPriceEntryPo;
import com.pengsheng.eims.util.tools.Utility;

public class AdcostPriceMgrImpl implements AdcostPriceMgr {
	
	private AdcostPriceDao adcostPriceDao;
	private AdcostPriceJobDao adcostPriceJobDao;
	private LogisticsLogDao logisticsLogDao;
	
	public AdcostPriceJobDao getAdcostPriceJobDao() {
		return adcostPriceJobDao;
	}

	public void setAdcostPriceJobDao(AdcostPriceJobDao adcostPriceJobDao) {
		this.adcostPriceJobDao = adcostPriceJobDao;
	}

	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	public AdcostPriceDao getAdcostPriceDao() {
		return adcostPriceDao;
	}

	public void setAdcostPriceDao(AdcostPriceDao adcostPriceDao) {
		this.adcostPriceDao = adcostPriceDao;
	}

	/**
	 * 查询调价表信息
	 * @param adcostPricePo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<AdcostPricePo> getAdcostPriceList(AdcostPricePo adcostPricePo,int start, int size) {
		// TODO Auto-generated method stub
		return adcostPriceDao.getAdcostPriceList(adcostPricePo , start , size);
	}
	
	/**
	 * 得到调价表数量
	 * @param adcostPricePo
	 * @return
	 */
	public int getAdcostPriceCount(AdcostPricePo adcostPricePo) {
		// TODO Auto-generated method stub
		return adcostPriceDao.getAdcostPriceCount(adcostPricePo);
	}
	
	/**
	 * 新增调价表及明细表
	 * @param adcostPricePo
	 * @param adcostPriceEntryPo
	 */
	public void insertAdcostPrice(AdcostPricePo adcostPricePo,List<AdcostPriceEntryPo> adcostPriceEntryList,LogisticsLogPo logPo) {
		
		//新增调价表
		adcostPriceDao.adcostPriceInsert(adcostPricePo);
		
		//新增调价明细表
		for(int i=0;i<adcostPriceEntryList.size();i++){
			AdcostPriceEntryPo adcostPriceEntryPo=adcostPriceEntryList.get(i);
			adcostPriceDao.adcostPriceEntryInsert(adcostPriceEntryPo);
		}
		
		if (Utility.getName(adcostPricePo.getCprapflag()).equals("0")){  //实时调价
			if (!Utility.getName(adcostPricePo.getCpracauditstate()).equals("0")){
				for(int i=0;i<adcostPriceEntryList.size();i++){
					AdcostPriceEntryPo adcostPriceEntryPo=adcostPriceEntryList.get(i);
					adcostPriceJobDao.adcostPriceEffective(adcostPriceEntryPo);
				}
			}
		}
		
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	/**
	 * 新增调价明细表
	 * @param adcostPriceEntryPo
	 */
	public void adcostPriceEntryInsert(AdcostPriceEntryPo adcostPriceEntryPo) {
		// TODO Auto-generated method stub
		
		adcostPriceDao.adcostPriceEntryInsert(adcostPriceEntryPo);
		
	}
	
	/**
	 * 更新调价信息
	 * @param adcostPricePo
	 * @param adcostPriceEntryPo
	 */
	public void updateAdcostPrice(AdcostPricePo adcostPricePo,List<AdcostPriceEntryPo> adcostPriceEntryList,LogisticsLogPo logPo) {
		// TODO Auto-generated method stub
		
		//新增调价主表
		adcostPriceDao.adcostPriceUpdate(adcostPricePo);
		
		//删除调价明细表
		adcostPriceDao.adcostPriceEntryDelete(adcostPricePo);
		
		//新增调价明细表
		for (int i = 0; i < adcostPriceEntryList.size(); i++) {
			AdcostPriceEntryPo adcostPriceEntryPo = adcostPriceEntryList.get(i);
			this.adcostPriceDao.adcostPriceEntryInsert(adcostPriceEntryPo);
		}
		
		if (Utility.getName(adcostPricePo.getCprapflag()).equals("0")){  //实时调价
			if (!Utility.getName(adcostPricePo.getCpracauditstate()).equals("0")){
				for(int i=0;i<adcostPriceEntryList.size();i++){
					AdcostPriceEntryPo adcostPriceEntryPo=adcostPriceEntryList.get(i);
					adcostPriceJobDao.adcostPriceEffective(adcostPriceEntryPo);
				}
			}
		}
		
		logisticsLogDao.insertLog(logPo); //添加日志
	}

	/**
	 * 删除调价信息
	 * @param adcostPricePo
	 */
	public void deleteAdcostPrice(AdcostPricePo adcostPricePo,LogisticsLogPo logPo) {
		// TODO Auto-generated method stub
		
		//删除调价主表
		adcostPriceDao.adcostPriceDelete(adcostPricePo);
		
		//删除调价明细表
		adcostPriceDao.adcostPriceEntryDelete(adcostPricePo);
		
		logisticsLogDao.insertLog(logPo); //添加日志
	}

	/**
	 * 得到调价信息表头
	 * @param adcostPricePo
	 * @return
	 */
	public AdcostPricePo getAdcostPrice(AdcostPricePo adcostPricePo) {
		return adcostPriceDao.getAdcostPrice(adcostPricePo);
	}

	/**
	 * 得到调价明细信息表体
	 * @param adcostPricePo
	 * @return
	 */
	public List<AdcostPriceEntryPo> getAdcostPriceEntryList(AdcostPricePo adcostPricePo) {
		return adcostPriceDao.getAdcostPriceEntryList(adcostPricePo);
	}
	/**
	 * 得到调价明细信息表体
	 * @param adcostPricePo
	 * @return
	 */
	public List<AdcostPriceEntryPo> getAdcostPriceEntryList(BrandPo brandPo){
		
		return adcostPriceDao.getAdcostPriceEntryList(brandPo);
	}
}
