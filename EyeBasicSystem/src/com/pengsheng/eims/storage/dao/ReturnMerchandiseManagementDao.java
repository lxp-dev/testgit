package com.pengsheng.eims.storage.dao;

import java.util.List;

import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.storage.persistence.VerificationPo;

public interface ReturnMerchandiseManagementDao {
	/**
	 * 获取采购商品退货的数量
	 * 
	 * @param po
	 *            InventoryPo
	 * @return int 数量
	 */
	public int getReturnMerchandiseManagementCount(InventoryPo po);

	/**
	 * 获取采购商品退货的list
	 * 
	 * @param po
	 *            InventoryPo
	 * @param start
	 * @param size
	 * @return list InventoryPo的list
	 */
	public List<InventoryPo> getReturnMerchandiseManagementList(InventoryPo po,
			int start, int size);

	/**
	 * 新增采购商品退货主表
	 * 
	 * @param po
	 *            InventoryPo
	 */
	public void insertReturnMerchandiseManagement(InventoryPo po);

	/**
	 * 获取采购商品退货的po
	 * 
	 * @param po
	 *            InventoryPo
	 * @return po InventoryPo
	 */
	public InventoryPo getReturnMerchandiseManagement(InventoryPo po);

	/**
	 * 新增采购商品退货明细表
	 * 
	 * @param po
	 */
	public void insertReturnMerchandiseManagementEntry(InventoryEntryPo po);

	/**
	 * 获取采购商品退货明细表的list
	 * 
	 * @param po
	 * @return
	 */
	public List<InventoryEntryPo> getReturnMerchandiseManagementEntryList(
			InventoryPo po);

	/**
	 * 新增核销表
	 * 
	 * @param po
	 *            VerificationPo
	 */
	public void insertVerification(VerificationPo po);

	/**
	 * 修改采购商品退货主表
	 * 
	 * @param po
	 *            InventoryPo
	 */
	public void updateReturnMerchandiseManagement(InventoryPo po);

	/**
	 * 删除采购商品退货主表
	 * 
	 * @param po
	 *            InventoryPo
	 */
	public void deleteReturnMerchandiseManagement(InventoryPo po);

	/**
	 * 删除采购商品退货明细表
	 * 
	 * @param po
	 *            InventoryPo
	 */
	public void deleteReturnMerchandiseManagementEntry(InventoryPo po);

	/**
	 * 删除核销表
	 * 
	 * @param po
	 *            InventoryPo
	 */
	public void deleteVerification(InventoryPo po);

	/**
	 * 采购退货转订单系统
	 * 
	 * @param poID
	 */
	public void returnimportOrders(String poID);

}
