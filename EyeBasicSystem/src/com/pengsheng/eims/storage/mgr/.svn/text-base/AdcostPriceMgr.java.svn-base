package com.pengsheng.eims.storage.mgr;

import java.util.List;

import com.pengsheng.eims.basic.persistence.BrandPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.persistence.AdcostPriceEntryPo;
import com.pengsheng.eims.storage.persistence.AdcostPricePo;

public interface AdcostPriceMgr {
	
	/**
	 * 新增调价表及明细表
	 * @param adcostPricePo
	 * @param adcostPriceEntryPo
	 */
	public void insertAdcostPrice(AdcostPricePo adcostPricePo,List<AdcostPriceEntryPo> adcostPriceEntryList,LogisticsLogPo logPo);
	
	/**
	 * 新增调价明细表
	 * @param adcostPriceEntryPo
	 */
	public void adcostPriceEntryInsert(AdcostPriceEntryPo adcostPriceEntryPo);
	
	/**
	 * 查询调价表信息
	 * @param adcostPricePo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<AdcostPricePo> getAdcostPriceList(AdcostPricePo adcostPricePo,int start , int size);
	
	/**
	 * 得到调价表数量
	 * @param adcostPricePo
	 * @return
	 */
	public int getAdcostPriceCount(AdcostPricePo adcostPricePo);
	
	/**
	 * 删除调价信息
	 * @param adcostPricePo
	 */
	public void deleteAdcostPrice(AdcostPricePo adcostPricePo,LogisticsLogPo logPo);
	
	/**
	 * 更新调价信息
	 * @param adcostPricePo
	 * @param adcostPriceEntryPo
	 */
	public void updateAdcostPrice(AdcostPricePo adcostPricePo,List<AdcostPriceEntryPo> adcostPriceEntryList,LogisticsLogPo logPo);
	
	/**
	 * 得到调价信息表头
	 * @param adcostPricePo
	 * @return
	 */
	public AdcostPricePo getAdcostPrice(AdcostPricePo adcostPricePo);
	
	/**
	 * 得到调价明细信息表体
	 * @param adcostPricePo
	 * @return
	 */
	public List<AdcostPriceEntryPo> getAdcostPriceEntryList(AdcostPricePo adcostPricePo);
	
	/**
	 * 得到调价明细信息表体
	 * @param adcostPricePo
	 * @return
	 */
	public List<AdcostPriceEntryPo> getAdcostPriceEntryList(BrandPo brandPo);
	
}
