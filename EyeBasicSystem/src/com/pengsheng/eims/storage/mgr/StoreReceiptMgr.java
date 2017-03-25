package com.pengsheng.eims.storage.mgr;

import java.io.File;
import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.persistence.DeliverEntryPo;
import com.pengsheng.eims.storage.persistence.DeliveryDetailPo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.storage.persistence.ProcurementOrdersPo;

/**
 * 客户批发收货mgr接口
 */
public interface StoreReceiptMgr {
	/*
	 * 
	 */
	public void updateOrderDeliveryID(InventoryPo po) ;
	/**
	 * Description :获取品种 
	 */
	public List<GoodsInfoPo> getProBrand(String proId);
	/**
	 * 获取客户批发收货的数量
	 * 
	 * @param po
	 *            InventoryPo
	 * @return int 数量
	 */
	public int getStoreReceiptCount(InventoryPo po);

	public int getStoreReceiptIsCustomizeCount(InventoryPo po);
	/**
	 * 获取客户批发收货的list
	 * 
	 * @param po
	 *            InventoryPo
	 * @param start
	 * @param size
	 * @return list InventoryPo的list
	 */
	public List<InventoryPo> getStoreReceiptList(InventoryPo po,
			int start, int size);

	/**
	 * 新增客户批发收货单
	 * 
	 * @param po
	 *            InventoryPo
	 */
	public void insertStoreReceipt(InventoryPo po,
			List<InventoryEntryPo> list,LogisticsLogPo logPo);
	
	/**
	 * 查询库存数量
	 * 
	 * @param po
	 *            InventoryPo
	 */
	public int selectStoreReceipt(InventoryPo po);

	/**
	 * 获取客户批发收货的po
	 * 
	 * @param po
	 *            InventoryPo
	 * @return po InventoryPo
	 */
	public InventoryPo getStoreReceipt(InventoryPo po);

	/**
	 * 获取客户批发收货明细表的list
	 * 
	 * @param po
	 *            InventoryPo
	 * @return list List<InventoryEntryPo>
	 */
	public List<InventoryEntryPo> getStoreReceiptEntryList(InventoryPo po);

	/**
	 * 修改客户批发收货单
	 * 
	 * @param po
	 *            InventoryPo
	 */
	public void updateStoreReceipt(InventoryPo po,
			List<InventoryEntryPo> list,LogisticsLogPo logPo);

	/**
	 * 删除客户批发收货单
	 * 
	 * @param po
	 *            InventoryPo
	 */
	public void deleteStoreReceipt(InventoryPo po,LogisticsLogPo logPo);

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
	public List<GoodsInfoPo> getStoreOrdersList(ProcurementOrdersPo po);

	
	/**
	 * 获取采购订单是否收货
	 * @param sourceBillId
	 * @return
	 */
	public int selectStoreIsReceipt(String billid);
	
	public List<GoodsInfoPo> insertImportStoreFrameManyExcel(GoodsInfoPo goodsInfoPo,File[] upload, String filePath, String[] fFullName,String[] ContentType,LogisticsLogPo logPo);
	
	/**
	 * 财务结算详细
	 * @param po
	 * @return
	 */
	public InventoryPo getStoreFinancialSettlement(InventoryPo po);
	
	/**
	 * 遍历财务结算信息
	 * @param po
	 * @return
	 */
	public List<InventoryEntryPo> getStoreFinancialSettlementEntryList(InventoryPo po);
	
	/**
	 * 修改财务结算
	 * @param po
	 */
	public void updateStoreFinancialSettlement(InventoryPo po,List<InventoryEntryPo> list,LogisticsLogPo logPo);
}
