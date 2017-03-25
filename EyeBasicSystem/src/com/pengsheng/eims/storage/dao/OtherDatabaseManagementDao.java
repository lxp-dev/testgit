package com.pengsheng.eims.storage.dao;

import java.util.List;

import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.storage.persistence.VerificationPo;

public interface OtherDatabaseManagementDao {
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
	public void insertOtherDatabaseManagement(InventoryPo po);
	
	/**
	 * 获取其它出库的po
	 * @param po InventoryPo
	 * @return po InventoryPo
	 */		
	public InventoryPo getOtherDatabaseManagement(InventoryPo po);

	/**
	 * 新增其它出库明细表
	 * @param po
	 */
	public void insertOtherDatabaseManagementEntry(InventoryEntryPo po);
	
	/**
	 * 获取其它出库明细表的list
	 * @param po
	 * @return
	 */
	public List<InventoryEntryPo> getOtherDatabaseManagementEntryList(InventoryPo po);	
	
	/**
	 * 新增核销表
	 * @param po VerificationPo
	 */		
	public void insertVerification(VerificationPo po);
	
	/**
	 * 修改其它出库主表
	 * @param po InventoryPo
	 */			
	public void updateOtherDatabaseManagement(InventoryPo po);
	/**
	 * 删除其它出库主表
	 * @param po InventoryPo
	 */		
	public void deleteOtherDatabaseManagement(InventoryPo po);
	/**
	 * 删除其它出库明细表
	 * @param po InventoryPo
	 */		
	public void deleteOtherDatabaseManagementEntry(InventoryPo po);
	/**
	 * 删除核销表
	 * @param po InventoryPo
	 */		
	public void deleteVerification(InventoryPo po);
	
	/**
	 *  新增其他出库在途库存
	 */
	public void insertOtherOutInTransitStorage(InventoryPo po);

}
