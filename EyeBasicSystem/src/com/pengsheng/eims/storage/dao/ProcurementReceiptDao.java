package com.pengsheng.eims.storage.dao;

import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.storage.persistence.DeliverEntryPo;
import com.pengsheng.eims.storage.persistence.DeliveryDetailPo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.storage.persistence.ProcurementOrdersPo;
import com.pengsheng.eims.storage.persistence.VerificationPo;

/**
 * 采购收货dao接口
 */
public interface ProcurementReceiptDao {
	
	public void updateOrderDeliveryID(InventoryPo po);
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
	
	/**
	 * 获取库存收货的数量
	 * 
	 * @param po
	 *            InventoryPo
	 * @return int 数量
	 */
	public int selectProcurementReceiptcount(InventoryPo po);

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
	 * 新增采购收货主表
	 * 
	 * @param po
	 *            InventoryPo
	 */
	public void insertProcurementReceipt(InventoryPo po);

	/**
	 * 新增采购收货明细表
	 * 
	 * @param po
	 *            InventoryPo
	 */
	public void insertProcurementReceiptEntry(InventoryEntryPo po);

	/**
	 * 新增核销表
	 * 
	 * @param po
	 *            VerificationPo
	 */
	public void insertVerification(VerificationPo po);

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
	 * 修改采购收货主表
	 * 
	 * @param po
	 *            InventoryPo
	 */
	public void updateProcurementReceipt(InventoryPo po);

	/**
	 * 删除采购收货主表
	 * 
	 * @param po
	 *            InventoryPo
	 */
	public void deleteProcurementReceipt(InventoryPo po);

	/**
	 * 删除采购收货明细表
	 * 
	 * @param po
	 *            InventoryPo
	 */
	public void deleteProcurementReceiptEntry(InventoryPo po);

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
	public List<GoodsInfoPo> getProcurementOrdersList(ProcurementOrdersPo po);

	/**
	 * 订单系统订单状态更新到确认收货
	 * 
	 * @param id
	 * @return
	 */
	public String updateOrderProcurementReceiptState(String id);
	
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
	public int selectProcurementIsReceipt(String billid);
	public int getProcurementReceiptIsCustomizeCount(InventoryPo po);
	
	public void updateGoodsLastInStorageDate(String goodsID);
	
	/**
	 * 根据公司和制造商查询绑定的供应商
	 */
	public String getSupplierByModeAndCompany(String companyID,String modeID);
	
}
