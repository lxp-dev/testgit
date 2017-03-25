package com.pengsheng.eims.storage.mgr;

import java.util.List;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.storage.persistence.AllocationPo;
import com.pengsheng.eims.storage.persistence.ConsignProcessReceiptPo;

public interface OutSourcingDeliveryMgr {

	/**
	 * 获取未发料的框镜委外收货单列表
	 */
	public List<SalesBasicPo> getNotMaterialsSalesBillList(ConsignProcessReceiptPo crpo);
	
	/**
	 * 委外配送修改
	 */
	public void updateNotMaterialsSalesBill(AllocationPo apo,ConsignProcessReceiptPo crpo,LogisticsLogPo logPo);
	
}
