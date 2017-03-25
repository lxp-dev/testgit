package com.pengsheng.eims.quartz.mgr.impl;

import java.util.List;

import com.pengsheng.eims.quartz.dao.AdSalesInInventoryDao;
import com.pengsheng.eims.quartz.dao.WholesalePriceJobDao;
import com.pengsheng.eims.quartz.mgr.WholesalePriceJobMgr;
import com.pengsheng.eims.storage.persistence.WholesalePriceEntryPo;
import com.pengsheng.eims.system.persistence.QuartzLogPo;

public class WholesalePriceJobMgrImpl implements WholesalePriceJobMgr{
	
	private WholesalePriceJobDao wholesalePriceJobDao;
	private AdSalesInInventoryDao adSalesInInventoryDao;
	
	public AdSalesInInventoryDao getAdSalesInInventoryDao() {
		return adSalesInInventoryDao;
	}
	public void setAdSalesInInventoryDao(AdSalesInInventoryDao adSalesInInventoryDao) {
		this.adSalesInInventoryDao = adSalesInInventoryDao;
	}
	public WholesalePriceJobDao getWholesalePriceJobDao() {
		return wholesalePriceJobDao;
	}
	public void setWholesalePriceJobDao(WholesalePriceJobDao wholesalePriceJobDao) {
		this.wholesalePriceJobDao = wholesalePriceJobDao;
	}
	
	public void updateWholesalePriceEffective(String date,QuartzLogPo logPo) {
		// TODO Auto-generated method stub
		List<WholesalePriceEntryPo> wholesalePriceEntryList=this.wholesalePriceJobDao.getWholesalePriceEffectiveList(date);
		for(int i=0;i<wholesalePriceEntryList.size();i++){
			WholesalePriceEntryPo wholesalePriceEntryPo=wholesalePriceEntryList.get(i);
			this.wholesalePriceJobDao.wholesalePriceEffective(wholesalePriceEntryPo);
			this.wholesalePriceJobDao.updateEffectiveState(wholesalePriceEntryPo);
		}
		
		adSalesInInventoryDao.updateQuartzExecLog(logPo);
	}
	

}
