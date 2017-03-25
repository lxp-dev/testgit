package com.pengsheng.eims.quartz.dao;

import java.util.List;

import com.pengsheng.eims.storage.persistence.AdcostPriceEntryPo;

public interface AdcostPriceJobDao {
	
	/**
	 * 更改商品基表销售价格
	 */
	public void adcostPriceEffective(AdcostPriceEntryPo adcostPriceEntryPo);
	
	/**
	 * 获取生效调价单明细
	 */
	public List<AdcostPriceEntryPo> getAdcostPriceEffectiveList(String date);
	
	/**
	 * 更改调价单生效状态
	 */
	public void updateEffectiveState(AdcostPriceEntryPo adcostPriceEntryPo);
	
}
