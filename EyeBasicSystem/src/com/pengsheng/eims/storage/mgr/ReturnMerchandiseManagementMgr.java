package com.pengsheng.eims.storage.mgr;

import java.util.List;

import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.storage.persistence.VerificationPo;

public interface ReturnMerchandiseManagementMgr {
	/**
	 * 获取采购商品退货的数量
	 * @param po InventoryPo
	 * @return int 数量
	 */	
	public int getReturnMerchandiseManagementCount(InventoryPo po);
	/**
	 * 获取采购商品退货的list
	 * @param po InventoryPo
	 * @param start
	 * @param size 
	 * @return list InventoryPo的list
	 */	
	public List<InventoryPo> getReturnMerchandiseManagementList(InventoryPo po,int start, int size);
	/**
	 * 新增采购商品退货主表
	 * @param po InventoryPo
	 */		
	public void insertReturnMerchandiseManagement(InventoryPo po,List<InventoryEntryPo> list);
	
	/**
	 * 获取采购商品退货的po
	 * @param po InventoryPo
	 * @return po InventoryPo
	 */		
	public InventoryPo getReturnMerchandiseManagement(InventoryPo po);
	
	/**
	 * 获取采购商品退货明细表的list
	 * @param po
	 * @return
	 */
	public List<InventoryEntryPo> getReturnMerchandiseManagementEntryList(InventoryPo po);	
	
	/**
	 * 修改采购商品退货单
	 * @param po InventoryPo
	 */		
	public void updateReturnMerchandiseManagement(InventoryPo po,List<InventoryEntryPo> list);
	/**
	 * 删除采购商品退货单
	 * @param po InventoryPo
	 */	
	public void deleteReturnMerchandiseManagement(InventoryPo po);

}
