package com.pengsheng.eims.storage.mgr;

import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.persistence.DeliverEntryPo;
import com.pengsheng.eims.storage.persistence.DeliveryDetailPo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.storage.persistence.ProcurementOrdersPo;

/**
 * 采购收货mgr接口
 */
public interface ProcurementReceiptMgr {
	/*
	 * 
	 */
	public void updateOrderDeliveryID(InventoryPo po) ;
	/**
	 * Description :获取品种 
	 */
	public List<GoodsInfoPo> getProBrand(String proId);
	/**
	 * 获取采购收货的数量
	 * 
	 * @param po
	 *            InventoryPo
	 * @return int 数量
	 */
	public int getProcurementReceiptCount(InventoryPo po);

	public int getProcurementReceiptIsCustomizeCount(InventoryPo po);
	/**
	 * 获取采购收货的list
	 * 
	 * @param po
	 *            InventoryPo
	 * @param start
	 * @param size
	 * @return list InventoryPo的list
	 */
	public List<InventoryPo> getProcurementReceiptList(InventoryPo po,
			int start, int size);

	/**
	 * 新增采购收货单
	 * 
	 * @param po
	 *            InventoryPo
	 */
	public void insertProcurementReceipt(InventoryPo po,
			List<InventoryEntryPo> list,LogisticsLogPo logPo);
	
	/**
	 * 查询库存数量
	 * 
	 * @param po
	 *            InventoryPo
	 */
	public int selectProcurementReceipt(InventoryPo po);

	/**
	 * 获取采购收货的po
	 * 
	 * @param po
	 *            InventoryPo
	 * @return po InventoryPo
	 */
	public InventoryPo getProcurementReceipt(InventoryPo po);

	/**
	 * 获取采购收货明细表的list
	 * 
	 * @param po
	 *            InventoryPo
	 * @return list List<InventoryEntryPo>
	 */
	public List<InventoryEntryPo> getProcurementReceiptEntryList(InventoryPo po);

	/**
	 * 修改采购收货单
	 * 
	 * @param po
	 *            InventoryPo
	 */
	public void updateProcurementReceipt(InventoryPo po,
			List<InventoryEntryPo> list,LogisticsLogPo logPo);

	/**
	 * 删除采购收货单
	 * 
	 * @param po
	 *            InventoryPo
	 */
	public void deleteProcurementReceipt(InventoryPo po,LogisticsLogPo logPo);

	/**
	 * 取发货单明细
	 * 
	 * @param deliverID
	 * @return
	 */
	public List<DeliveryDetailPo> getDeliverEntryList(String deliverID);

	/**
	 * 采购订单list
	 * 
	 * @param po
	 *            订单po
	 * @param start
	 * @param size
	 * @return list 订单list
	 */
	public List<GoodsInfoPo> getProcurementOrdersList(ProcurementOrdersPo po);

	
	/**
	 * 获取采购订单是否收货
	 * @param sourceBillId
	 * @return
	 */
	public int selectProcurementIsReceipt(String billid);
	
	/**
	 * 根据公司和制造商查询绑定的供应商
	 */
	public String getSupplierByModeAndCompany(String companyID,String modeID);
	
}
