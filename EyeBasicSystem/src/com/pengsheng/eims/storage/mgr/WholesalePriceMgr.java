package com.pengsheng.eims.storage.mgr;

import java.util.List;

import com.pengsheng.eims.basic.persistence.BrandPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.persistence.WholesalePriceEntryPo;
import com.pengsheng.eims.storage.persistence.WholesalePricePo;

public interface WholesalePriceMgr {
	public void insertWholesalePrice(WholesalePricePo wholesalePricePo,List<WholesalePriceEntryPo> wholesalePriceEntryList,LogisticsLogPo logPo);
	public void wholesalePriceEntryInsert(WholesalePriceEntryPo wholesalePriceEntryPo);
	public List<WholesalePricePo> getWholesalePriceList(WholesalePricePo wholesalePricePo,int start , int size);
	public int getWholesalePriceCount(WholesalePricePo wholesalePricePo);
	public void deleteWholesalePrice(WholesalePricePo wholesalePricePo,LogisticsLogPo logPo);
	
	public void updateWholesalePrice(WholesalePricePo wholesalePricePo,List<WholesalePriceEntryPo> wholesalePriceEntryList,LogisticsLogPo logPo);
	public WholesalePricePo getWholesalePrice(WholesalePricePo wholesalePricePo);
	public List<WholesalePriceEntryPo> getWholesalePriceEntryList(WholesalePricePo wholesalePricePo);
	/**
	 * 得到调价明细信息表体
	 * @param adcostPricePo
	 * @return
	 */
	public List<WholesalePriceEntryPo> getWholesalePriceEntryList(BrandPo brandPo);

}
