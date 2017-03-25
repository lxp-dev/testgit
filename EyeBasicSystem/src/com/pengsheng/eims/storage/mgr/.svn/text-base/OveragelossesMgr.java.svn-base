package com.pengsheng.eims.storage.mgr;

import java.util.List;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;

public interface OveragelossesMgr {
	/**
	 * 得到盘盈盘亏总数
	 * 
	 * @param po
	 * @return
	 */
	public int getOveragelossesCount(InventoryPo po);

	/**
	 * 得到盘盈盘亏分页
	 * 
	 * @param po
	 * @param start
	 * @param size
	 * @return
	 */
	public List<InventoryPo> getOveragelossesList(InventoryPo po, int start,
			int size);

	/**
	 * 得到盘盈盘亏
	 * 
	 * @param po
	 * @return
	 */
	public InventoryPo getOveragelosses(InventoryPo po);
	
	public void insertOveragelosses(InventoryPo inventoryPo,List<InventoryEntryPo> list,LogisticsLogPo logPo);

	/**
	 * 删除盘盈盘亏单
	 * 
	 * @param po
	 */
	public void deleteOveragelosses(InventoryPo po,LogisticsLogPo logPo);

	/**
	 * 盘盈盘亏明细分页
	 * 
	 * @param po
	 * @param start
	 * @param size
	 * @return
	 */
	public List<InventoryEntryPo> getOveragelossesEntryList(InventoryPo po,
			int start, int size);
	public List<InventoryEntryPo> getOveragelossesEntryFactList(InventoryPo po,int start, int size);

	/**
	 * 盘盈盘亏明细总数
	 * 
	 * @param inventoryPo
	 * @return
	 */
	public int getOveragelossesEntryCount(InventoryPo inventoryPo);
	public int getOveragelossesEntryFactCount(InventoryPo inventoryPo);
	
	/**
	 * 审核盘盈盘亏单
	 * 
	 * @param inventoryPo
	 */
	public void auditOveragelosses(InventoryPo inventoryPo,LogisticsLogPo logPo);
}
