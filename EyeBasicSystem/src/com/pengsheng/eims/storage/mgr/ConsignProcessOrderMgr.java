package com.pengsheng.eims.storage.mgr;

import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.storage.persistence.ConsignProcessOrderDetailsPo;
import com.pengsheng.eims.storage.persistence.ConsignProcessOrderPo;

public interface ConsignProcessOrderMgr {

	/**
	 * 取商品类别集合
	 * 
	 * @return
	 */
	public List<GoodsCategoryPo> getGoodsCategorys();
	public ConsignProcessOrderPo searchSaleReam(String id);
	/**
	 * 取委外订单合计
	 * 
	 * @param consignProcessOrderPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<ConsignProcessOrderPo> getConsignProcessOrderList(
			ConsignProcessOrderPo consignProcessOrderPo, int start, int size);

	/**
	 * 取委外订单总数
	 * 
	 * @param consignProcessOrderPo
	 * @return
	 */
	public int getConsignProcessOrderCount(
			ConsignProcessOrderPo consignProcessOrderPo);

	/**
	 * 得到委外订单主表
	 * 
	 * @param consignProcessOrderPo
	 * @return
	 */
	public ConsignProcessOrderPo getConsignProcessOrder(ConsignProcessOrderPo consignProcessOrderPo);
	
	public ConsignProcessOrderPo getConsignProcessOrderSeles(ConsignProcessOrderPo consignProcessOrderPo);

	/**
	 * 得到委外订单从表
	 * 
	 * @param consignProcessOrderDetailsPo
	 * @return
	 */
	public List<ConsignProcessOrderDetailsPo> getConsignProcessOrderDetailsList(
			ConsignProcessOrderDetailsPo consignProcessOrderDetailsPo);

	public List<ConsignProcessOrderDetailsPo> getConsignProcessOrderSelesDetailsList(
			ConsignProcessOrderDetailsPo consignProcessOrderDetailsPo);
	/**
	 * 增加委外订单、明细
	 * 
	 * @param consignProcessOrderPo
	 * @param consignProcessOrderDetails
	 */
	public void insertConsignProcessOrder(
			ConsignProcessOrderPo consignProcessOrderPo,
			List<ConsignProcessOrderDetailsPo> consignProcessOrderDetails,
			SalesBasicPo salesBasicPo, InTransitPo inTransitPo,LogisticsLogPo logPo);

	/**
	 * 更新委外订单
	 * 
	 * @param consignProcessOrderPo
	 * @param consignProcessOrderDetails
	 */
	public void updateConsignProcessOrder(
			ConsignProcessOrderPo consignProcessOrderPo,
			List<ConsignProcessOrderDetailsPo> consignProcessOrderDetails,
			SalesBasicPo salesBasicPo, InTransitPo inTransitPo,LogisticsLogPo logPo);

	/**
	 * 删除订单、明细
	 * 
	 * @param id
	 */
	public void delConsignProcessOrder(String id,LogisticsLogPo logPo);
}
