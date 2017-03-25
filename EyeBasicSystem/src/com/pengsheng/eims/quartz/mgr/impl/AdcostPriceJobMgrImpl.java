package com.pengsheng.eims.quartz.mgr.impl;

import java.util.List;

import com.pengsheng.eims.quartz.dao.AdSalesInInventoryDao;
import com.pengsheng.eims.quartz.dao.AdcostPriceJobDao;
import com.pengsheng.eims.quartz.mgr.AdcostPriceJobMgr;
import com.pengsheng.eims.storage.persistence.AdcostPriceEntryPo;
import com.pengsheng.eims.system.persistence.QuartzLogPo;

public class AdcostPriceJobMgrImpl implements AdcostPriceJobMgr {
	
	private AdcostPriceJobDao adcostPriceJobDao;
	private AdSalesInInventoryDao adSalesInInventoryDao;
	
	public AdSalesInInventoryDao getAdSalesInInventoryDao() {
		return adSalesInInventoryDao;
	}

	public void setAdSalesInInventoryDao(AdSalesInInventoryDao adSalesInInventoryDao) {
		this.adSalesInInventoryDao = adSalesInInventoryDao;
	}

	public AdcostPriceJobDao getAdcostPriceJobDao() {
		return adcostPriceJobDao;
	}

	public void setAdcostPriceJobDao(AdcostPriceJobDao adcostPriceJobDao) {
		this.adcostPriceJobDao = adcostPriceJobDao;
	}

	/**
	 * 调价管理
	 */
	public void updateAdcostPriceEffective(String date,QuartzLogPo logPo) {
		// TODO Auto-generated method stub
		List<AdcostPriceEntryPo> adcostPriceEntryList = adcostPriceJobDao.getAdcostPriceEffectiveList(date);
		
		for(int i = 0; i < adcostPriceEntryList.size(); i++){
			
			AdcostPriceEntryPo adcostPriceEntryPo = adcostPriceEntryList.get(i);
			
			adcostPriceJobDao.adcostPriceEffective(adcostPriceEntryPo);
			adcostPriceJobDao.updateEffectiveState(adcostPriceEntryPo);
			
		}
		
		adSalesInInventoryDao.updateQuartzExecLog(logPo);
		
	}

}
