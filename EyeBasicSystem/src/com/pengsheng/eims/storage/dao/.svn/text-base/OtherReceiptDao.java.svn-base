package com.pengsheng.eims.storage.dao;

import java.util.List;

import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.storage.persistence.VerificationPo;

public interface OtherReceiptDao {

	/**
	 * 查询其它入库管理数量
	 * @param po
	 * @return
	 */
	public int getOtherReceiptCount(InventoryPo po);
	/**
	 * 遍历其它入库管理信息并分页
	 * @param po
	 * @param start
	 * @param size
	 * @return
	 */
	public List<InventoryPo> getOtherReceiptList(InventoryPo po,int start, int size);
	/**
	 * 新增其他入库管理信息
	 * @param po
	 */
	public void insertOtherReceipt(InventoryPo po);
	/**
	 * 新增其他入库管理明细表信息
	 * @param po
	 */
	public void insertOtherReceiptEntry(InventoryEntryPo po);
	/**
	 * 新增核销表信息
	 * @param po
	 */
	public void insertVerification(VerificationPo po);
	/**
	 * 查询其它入库管理
	 * @param po
	 * @return
	 */
	public InventoryPo getOtherReceipt(InventoryPo po);
	/**
	 * 查询其他入库管理详情
	 * @param po
	 * @return
	 */
	public List<InventoryEntryPo> getOtherReceiptEntryList(InventoryPo po);
	/**
	 * 修改其他入库管理
	 * @param po
	 */
	public void updateOtherReceipt(InventoryPo po);
	/**
	 * 删除其他入库管理
	 * @param po
	 */
	public void deleteOtherReceipt(InventoryPo po);
	/**
	 * 删除其他入库管理明细表
	 * @param po
	 */
	public void deleteOtherReceiptEntry(InventoryPo po);
	/**
	 * 删除核销表
	 * @param po
	 */
	public void deleteVerification(InventoryPo po);
	
}
