package com.pengsheng.eims.quartz.dao;

import com.pengsheng.eims.system.persistence.ExternalAccountParameterPo;

public interface FlysheetDao {

	/**
	 * 配镜单
	 */
	public void updateSalesBill();
	
	/**
	 * 销售商品
	 */
	public void updateSalesGoods();
	
	/**
	 * 附加费
	 */
	public void updateAdditionalCDetail();
	
	/**
	 * 加工要求
	 */
	public void updateSpecialPDetail();
	
	/**
	 * 在途	
	 */
	public void updateInTransit();
	
	/**
	 * 付款记录
	 */
	public void updateSalesLog();
	
	/**
	 * 当日配镜单
	 */
	public void updateSalesBillToday();
	
	/**
	 * 当日销售商品			
	 */
	public void updateSalesGoodsToday();
	
	/**
	 * 当月库存	
	 */
	public void updateStorageChange();
	
	/**
	 * 库存流水
	 */
	public void updateStorageLog();
	
	/**
	 * 商品信息
	 */
	public void updateGoodsInfo();
	
	/**
	 * 新增商品信息
	 */
	public void insertGoodsInfo();
	
	/**
	 * 更新商品零售价
	 */
	public void updateGoodsInfoAdjustmentPrice(ExternalAccountParameterPo epo);
	
}
