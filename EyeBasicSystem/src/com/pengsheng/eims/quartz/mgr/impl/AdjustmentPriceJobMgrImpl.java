package com.pengsheng.eims.quartz.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.quartz.dao.AdSalesInInventoryDao;
import com.pengsheng.eims.quartz.dao.AdjustmentPriceJobDao;
import com.pengsheng.eims.quartz.mgr.AdjustmentPriceJobMgr;
import com.pengsheng.eims.storage.persistence.AdjustmentPriceEntryPo;
import com.pengsheng.eims.system.dao.SystemParameterDao;
import com.pengsheng.eims.system.persistence.QuartzLogPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;

public class AdjustmentPriceJobMgrImpl implements AdjustmentPriceJobMgr{
	
	private AdjustmentPriceJobDao adjustmentPriceJobDao;
	private AdSalesInInventoryDao adSalesInInventoryDao;
	private SystemParameterDao systemParameterDao;
	
	public SystemParameterDao getSystemParameterDao() {
		return systemParameterDao;
	}
	public void setSystemParameterDao(SystemParameterDao systemParameterDao) {
		this.systemParameterDao = systemParameterDao;
	}
	public AdSalesInInventoryDao getAdSalesInInventoryDao() {
		return adSalesInInventoryDao;
	}
	public void setAdSalesInInventoryDao(AdSalesInInventoryDao adSalesInInventoryDao) {
		this.adSalesInInventoryDao = adSalesInInventoryDao;
	}
	public AdjustmentPriceJobDao getAdjustmentPriceJobDao() {
		return adjustmentPriceJobDao;
	}
	public void setAdjustmentPriceJobDao(AdjustmentPriceJobDao adjustmentPriceJobDao) {
		this.adjustmentPriceJobDao = adjustmentPriceJobDao;
	}
	
	public void updateAadjustmentPriceEffective(String date,QuartzLogPo logPo,SystemParameterPo spo) {
		
		List<AdjustmentPriceEntryPo> adjustmentPriceEntryList = this.adjustmentPriceJobDao.getAdjustmentPriceEffectiveList(date);
		
		for(int i=0;i<adjustmentPriceEntryList.size();i++){
			AdjustmentPriceEntryPo adjustmentPriceEntryPo=adjustmentPriceEntryList.get(i);
			adjustmentPriceEntryPo.setCprapewhichprice(adjustmentPriceEntryPo.getCprapewhichprice());
			
			this.adjustmentPriceJobDao.adjustmentPriceEffective(adjustmentPriceEntryPo);
			
			adjustmentPriceJobDao.updateAdjustmentPriceEffectiveFlySheet(adjustmentPriceEntryPo);
			
			this.adjustmentPriceJobDao.updateEffectiveState(adjustmentPriceEntryPo);
			
			GoodsInfoPo gpo = new GoodsInfoPo();
			gpo.setBgigoodsid(adjustmentPriceEntryPo.getCprapegoodsid());
			systemParameterDao.updateGoodsViewNameForChangePrice(spo, gpo);
		}
		
		if (logPo != null){
			adSalesInInventoryDao.updateQuartzExecLog(logPo);
		}

	}
	

}
