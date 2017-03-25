package com.pengsheng.eims.storage.dao;

import java.util.List;

import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.storage.persistence.ConsignProcessOrderDetailsPo;
import com.pengsheng.eims.storage.persistence.ConsignProcessReceiptDetailsPo;
import com.pengsheng.eims.storage.persistence.ConsignProcessReceiptPo;
import com.pengsheng.eims.storage.persistence.InventoryTempEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryTempPo;
import com.pengsheng.eims.storage.persistence.StrogeChangePo;
import com.pengsheng.eims.storage.persistence.StrogeLogPo;

public interface ConsignProcessTakeDao {
	
	/**
	 * 得到委外收货单数量
	 * 
	 * @param po
	 * @return
	 */
	
	public int getConsignProcessReceiptCount(ConsignProcessReceiptPo po);
	/**
	 * 取所有委外收货单
	 * 
	 * @param po
	 * @param start
	 * @param size
	 * @return
	 */
	public List<ConsignProcessReceiptPo> getConsignProcessReceiptList(
			ConsignProcessReceiptPo po, int start, int size);	
		
	/**
	 * 取委外订单主表
	 * 
	 * @param po
	 * @return
	 */
	public ConsignProcessReceiptPo getConsignProcessReceipt(
			ConsignProcessReceiptPo po);

	/**
	 * 取委外订单明细
	 * 
	 * @param po
	 * @return
	 */
	public List<ConsignProcessReceiptDetailsPo> getConsignProcessReceiptEntryList(
			ConsignProcessReceiptPo po);
	
	/**
	 * 得到顾客信息
	 * @param consignProcessOrderDetailsPo
	 * @return
	 */
	public ConsignProcessOrderDetailsPo getCustomer(ConsignProcessOrderDetailsPo consignProcessOrderDetailsPo);
	
	/**
	 * 得到商品信息 柱镜、球镜等
	 * @param consignProcessOrderDetailsPo
	 * @return
	 */
	public List<ConsignProcessOrderDetailsPo> getGoods(ConsignProcessOrderDetailsPo consignProcessOrderDetailsPo);
	
	/**
	 * 得到商品信息 代码、批号、收入仓位
	 * @param consignProcessOrderDetailsPo
	 * @return
	 */
	public List<ConsignProcessOrderDetailsPo>  getGoodsWarehouse(ConsignProcessOrderDetailsPo consignProcessOrderDetailsPo);
	
	/**
	 * 得到仓位信息
	 * @param warehousePo
	 * @return
	 */
	public List<WarehousePo> getWarehouse(WarehousePo warehousePo);
	
	/**
	 * 委外订单开窗查询，回带订单号及配镜单
	 * @param consignProcessOrderDetailsPo
	 * @return
	 */
	public int getSalesid(ConsignProcessOrderDetailsPo consignProcessOrderDetailsPo);
	
	public int getSalesids(ConsignProcessOrderDetailsPo consignProcessOrderDetailsPo);
	
	/**
	 * 委外订单开窗查询，回带订单号及配镜单
	 * @param consignProcessOrderDetailsPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<ConsignProcessOrderDetailsPo> selectSalesid(ConsignProcessOrderDetailsPo consignProcessOrderDetailsPo , int start , int size);
	
	public List<ConsignProcessOrderDetailsPo> selectSalesids(ConsignProcessOrderDetailsPo consignProcessOrderDetailsPo , int start , int size);
	
	/**
	 * 更新销售单主表在途
	 * @param salesid
	 */
	public void updateSalesBasic(String salesid,String intransit);
	
	public void updateSalesStatus(String salesid);
	
	/**
	 * 新增收货主表
	 * @param consignProcessReceiptPo
	 */
	public void insertReceipt(ConsignProcessReceiptPo consignProcessReceiptPo);
	
	/**
	 * 新增收货明细表
	 * @param consignProcessReceiptDetailsPo
	 */
	public void insertReceiptDetails(ConsignProcessReceiptDetailsPo consignProcessReceiptDetailsPo);
	
	/**
	 * 新增在途明细表
	 * @param inTransitPo
	 */
	public void insertIntransit(InTransitPo inTransitPo);
	
	/**
	 * 新增当月库存变更表
	 * @param strogeChangePo
	 */
	public void insertStrogeChange(StrogeChangePo strogeChangePo);
	
	/**
	 * 新增当月库存日志表
	 * @param strogeLogPo
	 */
	public void insertStrogeLog(StrogeLogPo strogeLogPo);
	
	/**
	 * 业务临时表
	 * @param inventoryTempPo
	 */
	public void insertInventoryTemp(InventoryTempPo inventoryTempPo);
	
	/**
	 * 业务明细临时表
	 * @param inventoryTempEntryPo
	 */
	public void insertInventoryTempEntry(InventoryTempEntryPo inventoryTempEntryPo);
	
	/**
	 * 向订单系统回写信息
	 * @param consignProcessReceiptPo
	 */
	public void insertOrdersInfo(String deliveryid , String ordersid , String personid);
	
	/**
	 * 得到订单系统发货信息数量
	 * @param consignProcessReceiptPo
	 * @return
	 */
	public int getdeliveryCount(ConsignProcessReceiptPo consignProcessReceiptPo);
	
	/**
	 * 得到订单系统发货信息
	 * @param consignProcessReceiptPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<ConsignProcessReceiptPo> selectdeliveryList(ConsignProcessReceiptPo consignProcessReceiptPo , int start , int size);
	
	/**
	 * 更新销售基表中隐形订做片的商品条码
	 * @param salesDetailPo
	 */
	public void updateDetailsBarcode(SalesDetailPo salesDetailPo);
	
	/**
	 * 更新订单明细表到货状态
	 * @param salesid
	 */
	public void updateConsignProcessOrdersDetailsState(String salesid);
	
	/**
	 * 查询配镜单的镜盒镜布
	 * @param salesid
	 */
    public List<SalesDetailPo> getSalesDetailPoForAccessories(String salesid);
	/**
	 * 查询在途明细表
	 * @param inTransitPo top1
	 */
	public InTransitPo getIntransitPo(InTransitPo inTransitPo);
	
	/**
	 * 委外订单开窗查询配镜单
	 * @param consignProcessOrderDetailsPo
	 * @return
	 */
	public int getSalesidsW(ConsignProcessOrderDetailsPo consignProcessOrderDetailsPo);

/**
	 * 委外订单开窗查询配镜单
	 * @param consignProcessOrderDetailsPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<ConsignProcessOrderDetailsPo> selectSalesidsW(
			ConsignProcessOrderDetailsPo consignProcessOrderDetailsPo,
			int start, int size);
	
	/**
	 * 业务临时表
	 * @param inventoryTempPo
	 */
	public void insertInventory(InventoryTempPo inventoryTempPo);
	
	/**
	 * 业务明细临时表
	 * @param inventoryTempEntryPo
	 */
	public void insertInventoryEntry(InventoryTempPo inventoryTempPo);
	
	public SalesBasicPo getSalesBasicPo(String salesID);
	
	/**
	 * 查询镜片商品是否一个订制片一个成品片
	 * @param consignProcessReceiptPo
	 * @return
	 */
	public List<ConsignProcessOrderDetailsPo> selectGlassesIsDandC(ConsignProcessOrderDetailsPo po);
	
	/**
	 * 查询配镜单中的镜架、太阳镜、老花镜
	 */
	public List<ConsignProcessOrderDetailsPo> getFrameGoods(ConsignProcessOrderDetailsPo consignProcessOrderDetailsPo);
	
}
