package com.pengsheng.eims.storage.dao;

import java.util.List;

import com.pengsheng.eims.storage.persistence.ConsignProcessOrderDetailsPo;
import com.pengsheng.eims.storage.persistence.ConsignProcessOrderPo;
import com.pengsheng.eims.storage.persistence.ConsignProcessReceiptDetailsPo;
import com.pengsheng.eims.storage.persistence.ConsignProcessReceiptPo;
import com.pengsheng.eims.storage.persistence.VerificationPo;

public interface ConsignProcessWaitDao {
	
	/**
	 * 委外查询表体信息  分页
	 * @param consignProcessOrderPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<ConsignProcessOrderPo> getConsignProcessOrderList(ConsignProcessOrderPo consignProcessOrderPo , int start , int size);
	
	/**
	 * 委外信息数量
	 * @param consignProcessOrderPo
	 * @return
	 */
	public int getConsignProcessOrderCount(ConsignProcessOrderPo consignProcessOrderPo);
	
	/**
	 * 委外商品详细信息 分页  更新页面表体
	 * @param consignProcessOrderDetailsPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<ConsignProcessOrderDetailsPo> getConsignProcessOrderDetailsList(ConsignProcessOrderDetailsPo consignProcessOrderDetailsPo , int start , int size);
	
	/**
	 * 委外商品详细信息数量
	 * @param consignProcessOrderDetailsPo
	 * @return
	 */
	public int getConsignProcessOrderDetailsCount(ConsignProcessOrderDetailsPo consignProcessOrderDetailsPo);
	
	/**
	 * 委外插入主表信息 
	 * @param inventoryPo
	 */
	public void insertConsignProcessReceipt(ConsignProcessReceiptPo consignProcessReceiptPo);
	
	/**
	 * 委外插入从表信息
	 * @param inventoryEntryPo
	 */
	public void insertConsignProcessReceiptDetails(ConsignProcessReceiptDetailsPo consignProcessReceiptDetailsPo);
	
	/**
	 * 新增核销表
	 * @param po VerificationPo
	 */		
	public void insertVerification(VerificationPo po);
	
	public void buildInventory(String id);

	public void buildInventoryEntry(String id);
}
