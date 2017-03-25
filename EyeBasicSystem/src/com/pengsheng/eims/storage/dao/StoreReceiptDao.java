package com.pengsheng.eims.storage.dao;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.storage.persistence.DeliverEntryPo;
import com.pengsheng.eims.storage.persistence.DeliveryDetailPo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.storage.persistence.ProcurementOrdersPo;
import com.pengsheng.eims.storage.persistence.VerificationPo;

/**
 * 客户批发收货dao接口
 */
public interface StoreReceiptDao {
	
	public void updateOrderDeliveryID(InventoryPo po);
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
	
	/**
	 * 获取库存收货的数量
	 * 
	 * @param po
	 *            InventoryPo
	 * @return int 数量
	 */
	public int selectStoreReceiptcount(InventoryPo po);

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
	 * 新增客户批发收货主表
	 * 
	 * @param po
	 *            InventoryPo
	 */
	public void insertStoreReceipt(InventoryPo po);

	/**
	 * 新增客户批发收货明细表
	 * 
	 * @param po
	 *            InventoryPo
	 */
	public void insertStoreReceiptEntry(InventoryEntryPo po);

	/**
	 * 新增核销表
	 * 
	 * @param po
	 *            VerificationPo
	 */
	public void insertVerification(VerificationPo po);

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
	 * 修改客户批发收货主表
	 * 
	 * @param po
	 *            InventoryPo
	 */
	public void updateStoreReceipt(InventoryPo po);

	/**
	 * 删除客户批发收货主表
	 * 
	 * @param po
	 *            InventoryPo
	 */
	public void deleteStoreReceipt(InventoryPo po);

	/**
	 * 删除客户批发收货明细表
	 * 
	 * @param po
	 *            InventoryPo
	 */
	public void deleteStoreReceiptEntry(InventoryPo po);

	/**
	 * 删除核销表
	 * 
	 * @param po
	 *            InventoryPo
	 */
	public void deleteVerification(InventoryPo po);

	public void updateOrder(InventoryPo inventoryPo);
	
	public void updateOrderStatus(InventoryPo inventoryPo);
	
	public void insertOrderStatus(InventoryPo inventoryPo);

	public String getGoodsBarCode(String goodsId);

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
	 * 订单系统订单状态更新到确认收货
	 * 
	 * @param id
	 * @return
	 */
	public String updateOrderStoreReceiptState(String id);
	
	/**
	 * 更新到确认收货标示
	 * 
	 * @param id
	 * @return
	 */
	public void updatestatusReceipt(InventoryPo po);
	
	/**
	* Description :获取某一品种的最大最小光度
	* 
	* @return :某一品种的最大最小光度
	*/
	public GoodsInfoPo getMaxMinGoods(GoodsInfoPo goodsInfoPo);
	
	/**
	* Description :获取某一品种的二维数组
	* 
	* @return :某一品种的二维数组
	*/
	public List<GoodsInfoPo> getstringContextGoodsList(GoodsInfoPo goodsInfoPo);
	
	
	/**
	 * 获取采购订单是否收货
	 * @param billid
	 * @return
	 */
	public int selectStoreIsReceipt(String billid);
	public int getStoreReceiptIsCustomizeCount(InventoryPo po);
	
	public void updateGoodsLastInStorageDate(String goodsID);
	
	/**
	 * 获取批发导入商品信息
	 */
	public GoodsInfoPo selectImportStorePo(String goodsid);
	
	/**
	 * 获取批发收货单中的类别与制造商
	 * 
	 * @param po
	 *            InventoryPo
	 * @return list List<InventoryEntryPo>
	 */
	public List<InventoryPo> getStoreCandS(InventoryPo po);
	
	/**
	 * 获取客户批发收货明细表中某类别某制造商的商品进行采购收货单生成
	 * 
	 * @param po
	 *            InventoryPo
	 * @return list List<InventoryEntryPo>
	 */
	public List<InventoryEntryPo> getStoreG(InventoryPo po);
	
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
	public void updateStoreFinancialSettlement(InventoryPo po);
	
	/**
	 * 根据业务明细查询商品代码
	 */
	public GoodsInfoPo getStoreGoodsInfoByInventoryEntry(InventoryEntryPo epo);
	
	/**
	 * 修改业务单明细表信息
	 * @param po
	 */
	public void updateStoreFinancialSettlementEntry(InventoryEntryPo po);
	
	/**
	 * 新增业务单据往来明细
	 */
	public void insertStoreSupplierDealingEntry(InventoryPo po);
	
	/**
	 * 根据单据编号查询商品成本
	 */
	public List<InventoryEntryPo> getStoreStorageCostEntryByBillID(InventoryPo po);
	
	/**
	 * 更新库存表的结算成本
	 */
	public void updateStoreStorageCostEntry(InventoryEntryPo epo);
	
}
