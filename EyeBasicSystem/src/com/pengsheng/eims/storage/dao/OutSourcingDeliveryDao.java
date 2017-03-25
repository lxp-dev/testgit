package com.pengsheng.eims.storage.dao;

import java.util.List;

import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.storage.persistence.AllocationPo;
import com.pengsheng.eims.storage.persistence.ConsignProcessReceiptPo;

public interface OutSourcingDeliveryDao {

	/**
	 * 获取未发料的框镜委外收货单列表
	 */
	public List<SalesBasicPo> getNotMaterialsSalesBillList(ConsignProcessReceiptPo crpo);
	
	/**
	 * 委外配送修改
	 */
	public void updateNotMaterialsSalesBill(ConsignProcessReceiptPo crpo);
	
	/**
	 * 新增调拨单
	 */
	public void insertConsignProcessReceiptToAlloction(AllocationPo apo);
	
	/**
	 * 新增调拨单明细
	 */
	public void insertConsignProcessReceiptToAlloctionEntry(ConsignProcessReceiptPo crpo);
	
}
