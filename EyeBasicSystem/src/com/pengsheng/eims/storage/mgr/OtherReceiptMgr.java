package com.pengsheng.eims.storage.mgr;

import java.util.List;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;

public interface OtherReceiptMgr {

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
	 * 新增其他入库管理
	 * @param po
	 * @param list
	 */
	public void insertOtherReceipt(InventoryPo po,List<InventoryEntryPo> list,LogisticsLogPo logPo);
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
	 * @param list
	 */
	public void updateOtherReceipt(InventoryPo po,List<InventoryEntryPo> list,LogisticsLogPo logPo);
	/**
	 * 删除其他入库管理
	 * @param po
	 */
	public void deleteOtherReceipt(InventoryPo po,LogisticsLogPo logPo);

}
