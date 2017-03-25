package com.pengsheng.eims.storage.dao;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.storage.persistence.ConsignProcessOrderDetailsPo;
import com.pengsheng.eims.storage.persistence.ConsignProcessOrderPo;

public interface ConsignProcessOrderDao {

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
	 * @param procurementOrdersPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<ConsignProcessOrderPo> getConsignProcessOrderList(
			ConsignProcessOrderPo consignProcessOrderPo, int start, int size);

	/**
	 * 取委外订单总数
	 * 
	 * @param procurementOrdersPo
	 * @return
	 */
	public int getConsignProcessOrderCount(
			ConsignProcessOrderPo consignProcessOrderPo);

	/**
	 * 增加委外订单
	 * 
	 * @param brandPo
	 */
	public void insertConsignProcessOrder(
			ConsignProcessOrderPo consignProcessOrderPo);

	/**
	 * 增加委外订单明细
	 * 
	 * @param brandPo
	 */
	public void insertConsignProcessOrderDetails(
			ConsignProcessOrderDetailsPo consignProcessOrderDetailsPo);

	/**
	 * 得到委外订单主表
	 * 
	 * @param procurementOrdersPo
	 * @return
	 */
	public ConsignProcessOrderPo getConsignProcessOrder(
			ConsignProcessOrderPo consignProcessOrderPo);
	
	public ConsignProcessOrderPo getConsignProcessOrderSeles(
			ConsignProcessOrderPo consignProcessOrderPo);

	/**
	 * 得到委外订单从表
	 * 
	 * @param procurementOrdersEntryPo
	 * @return
	 */
	public List<ConsignProcessOrderDetailsPo> getConsignProcessOrderDetailsList(
			ConsignProcessOrderDetailsPo consignProcessOrderDetailsPo);
	
	public List<ConsignProcessOrderDetailsPo> getConsignProcessOrderSelesDetailsList(
			ConsignProcessOrderDetailsPo consignProcessOrderDetailsPo);

	/**
	 * 更新委外订单主表
	 * 
	 * @param consignProcessOrderPo
	 */
	public void updateConsignProcessOrder(
			ConsignProcessOrderPo consignProcessOrderPo);

	/**
	 * 删除委外订单主表
	 * 
	 * @param id
	 */
	public void delConsignProcessOrder(String id);

	/**
	 * 删除委外订单从表
	 * 
	 * @param id
	 */
	public void delConsignProcessOrderDetails(String id);

	/**
	 * 更新销售基表中的在途点
	 * 
	 * @param salesDetailPo
	 */
	public void updateMaterialsInTransit(SalesBasicPo salesBasicPo);

	/**
	 * 根据销售单号将信息插入在途明细表中
	 * 
	 * @param inTransitPo
	 */
	public void insertIntrnsitInfo(InTransitPo inTransitPo);

	/**
	 * 委外订单导入订单系统
	 * 
	 * @param poID
	 */
	public void consignimportOrders(String poID);
	
	/**
	 * 插入特殊加工要求详细表orders.orders.dbo.S_SE_SS_SalesSpecial
	 * 
	 * @param poID
	 */
	public void consignimportSpecialDetails(String salesid);
}
