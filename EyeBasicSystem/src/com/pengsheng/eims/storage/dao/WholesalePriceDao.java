package com.pengsheng.eims.storage.dao;

import java.util.List;

import com.pengsheng.eims.basic.persistence.BrandPo;
import com.pengsheng.eims.storage.persistence.WholesalePriceEntryPo;
import com.pengsheng.eims.storage.persistence.WholesalePricePo;

public interface WholesalePriceDao {
	/**
	 * 新增批发调价单
	 */
	public void wholesalePriceInsert(WholesalePricePo wholesalePricePo);
	/**
	 * 新增批发调价明细
	 */
	public void wholesalePriceEntryInsert(WholesalePriceEntryPo wholesalePriceEntryPo);
	/**
	 * 获取批发调价单LIst
	 */
	public List<WholesalePricePo> getWholesalePriceList(WholesalePricePo wholesalePricePo,int start , int size);
	/**
	 * 获取批发调价单数量
	 */
	public int getWholesalePriceCount(WholesalePricePo wholesalePricePo);
	/**
	 * 删除批发调价单
	 */
	public void wholesalePriceDelete(WholesalePricePo wholesalePricePo);
	/**
	 * 删除批发调价明细
	 */
	public void wholesalePriceEntryDelete(WholesalePricePo wholesalePricePo);
	/**
	 * 修改批发调价单
	 */
	public void wholesalePriceUpdate(WholesalePricePo wholesalePricePo);
	/**
	 * 获得批发调价单实体类
	 */
	public WholesalePricePo getWholesalePrice(WholesalePricePo wholesalePricePo);
	/**
	 * 获取批发调价单明细List
	 */
	public List<WholesalePriceEntryPo> getWholesalePriceEntryList(WholesalePricePo wholesalePricePo);
	/**
	 * 获取批发调价单明细List
	 */
	public List<WholesalePriceEntryPo> getWholesalePriceEntryList(BrandPo brandPo);
}
