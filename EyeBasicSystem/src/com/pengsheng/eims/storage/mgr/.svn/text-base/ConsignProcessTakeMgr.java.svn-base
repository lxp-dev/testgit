package com.pengsheng.eims.storage.mgr;

import java.util.List;

import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.storage.persistence.ConsignProcessOrderDetailsPo;
import com.pengsheng.eims.storage.persistence.ConsignProcessReceiptDetailsPo;
import com.pengsheng.eims.storage.persistence.ConsignProcessReceiptPo;
import com.pengsheng.eims.storage.persistence.InventoryTempPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;

public interface ConsignProcessTakeMgr {
	
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
	 * 新增收货表及其他表
	 * @param salesid
	 * @param receiptList
	 * @param consignReceiptPo
	 * @param inTransitPo
	 */
	public void insertReceipt(SystemParameterPo systemParameterPo,String salesid , List<ConsignProcessReceiptDetailsPo> receiptList , 
			ConsignProcessReceiptPo consignReceiptPo , InTransitPo inTransitPo , InventoryTempPo inventoryTempPo,LogisticsLogPo logPo);
	
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
	 * 查询配镜单中的镜架、太阳镜、老花镜
	 */
	public List<ConsignProcessOrderDetailsPo> getFrameGoods(ConsignProcessOrderDetailsPo consignProcessOrderDetailsPo);
	
}
