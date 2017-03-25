package com.pengsheng.eims.storage.mgr;

import java.util.List;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;

public interface OtherDatabaseManagementMgr {

	/**
	 * 获取其它出库的数量
	 * @param po InventoryPo
	 * @return int 数量
	 */	
	public int getOtherDatabaseManagementCount(InventoryPo po);
	/**
	 * 获取其它出库的list
	 * @param po InventoryPo
	 * @param start
	 * @param size 
	 * @return list InventoryPo的list
	 */	
	public List<InventoryPo> getOtherDatabaseManagementList(InventoryPo po,int start, int size);
	/**
	 * 新增其它出库主表
	 * @param po InventoryPo
	 */		
	public void insertOtherDatabaseManagement(InventoryPo po,List<InventoryEntryPo> list,LogisticsLogPo logPo);
	
	/**
	 * 获取其它出库的po
	 * @param po InventoryPo
	 * @return po InventoryPo
	 */		
	public InventoryPo getOtherDatabaseManagement(InventoryPo po);
	
	/**
	 * 获取其它出库明细表的list
	 * @param po
	 * @return
	 */
	public List<InventoryEntryPo> getOtherDatabaseManagementEntryList(InventoryPo po);	
	
	/**
	 * 修改其它出库
	 * @param po InventoryPo
	 */		
	public void updateOtherDatabaseManagement(InventoryPo po,List<InventoryEntryPo> list,LogisticsLogPo logPo);
	/**
	 * 删除其它出库
	 * @param po InventoryPo
	 */	
	public void deleteOtherDatabaseManagement(InventoryPo po,LogisticsLogPo logPo);
}
