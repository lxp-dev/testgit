package com.pengsheng.eims.storage.dao;

import java.util.List;

import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;

public interface OtherOutDao {
	/**
	 * 其他出库总数
	 * @param po
	 * @return
	 */
	public int getOtherOutCount(InventoryPo po);
	
	/**
	 * 其他出库详细信息
	 * @param po
	 * @param start
	 * @param size
	 * @return
	 */
	public List<InventoryPo> getOtherOutList(InventoryPo po,int start, int size);
	
	/**
	 * 其他出库详细中的总数
	 * @param po
	 * @return
	 */
	public InventoryPo getOtherOut(InventoryPo po);
	
	/**
	 * 其他出库中详细中的信息List	
	 * @param po
	 * @return
	 */
	public List<InventoryEntryPo> getOtherOutEntryList(InventoryPo po);
	
	/**
	 * 新增其他出库插入业务表中
	 * @param po
	 */
	public void insertOtherOut(InventoryPo po);
	
	/**
	 * 新增其他出库插入业务单明细表中
	 * @param po
	 */
	public void insertOtherOutEntry(InventoryEntryPo po);
	
	/**
	 * 更新其他出库
	 * @param po
	 */
	public void updateOtherOut(InventoryPo po);
	
	/**
	 * 删除其他出库业务表中
	 * @param po
	 */
	public void deleteOtherOut(InventoryPo po);
	
	/**
	 * 删除其他出库业务明细表中
	 * @param po
	 */
	public void deleteOtherOutEntry(InventoryPo po);
	
}
