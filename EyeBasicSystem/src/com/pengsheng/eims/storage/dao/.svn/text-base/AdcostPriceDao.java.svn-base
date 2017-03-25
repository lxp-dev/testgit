package com.pengsheng.eims.storage.dao;

import java.util.List;

import com.pengsheng.eims.basic.persistence.BrandPo;
import com.pengsheng.eims.storage.persistence.AdcostPricePo;
import com.pengsheng.eims.storage.persistence.AdcostPriceEntryPo;

public interface AdcostPriceDao {

	/**
	 * 新增调价单
	 */
	public void adcostPriceInsert(AdcostPricePo adcostPricePo);
	
	/**
	 * 新增调价明细
	 */
	public void adcostPriceEntryInsert(AdcostPriceEntryPo adcostPriceEntryPo);
	
	/**
	 * 查询调价单LIst
	 */
	public List<AdcostPricePo> getAdcostPriceList(AdcostPricePo adcostPricePo,int start , int size);
	
	/**
	 * 得到调价单数量
	 */
	public int getAdcostPriceCount(AdcostPricePo adcostPricePo);
	
	/**
	 * 删除调价单
	 */
	public void adcostPriceDelete(AdcostPricePo adcostPricePo);
	
	/**
	 * 删除调价明细
	 */
	public void adcostPriceEntryDelete(AdcostPricePo adcostPricePo);
	
	/**
	 * 修改调价单
	 */
	public void adcostPriceUpdate(AdcostPricePo adcostPricePo);
	
	/**
	 * 获得调价单实体类
	 */
	public AdcostPricePo getAdcostPrice(AdcostPricePo adcostPricePo);
	
	/**
	 * 获取调价单明细List
	 */
	public List<AdcostPriceEntryPo> getAdcostPriceEntryList(AdcostPricePo adcostPricePo);
	
	/**
	 * 得到调价明细信息表体
	 * @param adcostPricePo
	 * @return
	 */
	public List<AdcostPriceEntryPo> getAdcostPriceEntryList(BrandPo brandPo);
	
}
