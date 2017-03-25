package com.pengsheng.eims.storage.dao;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;

public interface OveragelossesDao {

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
	 * 审核盘盈盘亏单
	 * 
	 * @param inventoryPo
	 */
	public void updateOveragelosses(InventoryPo inventoryPo);

	/**
	 * 更新盘点表未生成盘盈或盘亏单
	 * 
	 * @param billid
	 *            单号
	 * @param type
	 *            0 盘盈， 1 盘亏
	 */
	public void updateCheckStorage(String billid, String type);

	/**
	 * 新增盘盈盘亏单
	 * 
	 * @param po
	 */
	public void insertOveragelosses(InventoryPo po);

	/**
	 * 新增盘盈盘亏单明细
	 * 
	 * @param po
	 */
	public void insertOveragelossesEntry(InventoryEntryPo po);
	
	/**
	 * 删除盘盈盘亏单
	 * 
	 * @param po
	 */
	public void deleteOveragelosses(InventoryPo po);

	/**
	 * 删除盘盈盘亏单明细
	 * 
	 * @param po
	 */
	public void deleteOveragelossesEntry(InventoryPo po);

	/**
	 * 得到盘盈盘亏
	 * 
	 * @param po
	 * @return
	 */
	public InventoryPo getOveragelosses(InventoryPo po);

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
	 * 盘盈盘亏明细不分页
	 * 
	 * @param po
	 * @return
	 */
	public List<InventoryEntryPo> getOveragelossesEntrys(InventoryPo po);
}
