package com.pengsheng.eims.storage.mgr;

import java.util.List;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;

public interface OtherOutMgr {

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
	 * 将数据插入业务及业务明细表中
	 * @param po
	 * @param list
	 */
	public void insertOtherOut(InventoryPo po,List<InventoryEntryPo> list,LogisticsLogPo logPo);
	
	/**
	 * 更新业务及业务明细表数据
	 * @param po
	 * @param list
	 */
	public void updateOtherOut(InventoryPo po,List<InventoryEntryPo> list,LogisticsLogPo logPo);
	
	/**
	 * 删除其他出库业务表中
	 * @param po
	 */
	public void deleteOtherOut(InventoryPo po,LogisticsLogPo logPo);
}
