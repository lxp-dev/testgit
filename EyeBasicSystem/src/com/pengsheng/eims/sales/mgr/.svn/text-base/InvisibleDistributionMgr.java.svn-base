package com.pengsheng.eims.sales.mgr;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.sales.persistence.DistributionEntryPo;
import com.pengsheng.eims.sales.persistence.DistributionPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.storage.persistence.AllocationPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;

public interface InvisibleDistributionMgr {
	/**
	 * 获取门店
	 * 
	 * @param po
	 * @return
	 */
	public List<WarehousePo> getWarehouseList(DepartmentsPo po);

	/**
	 * 查询隐形订做片配送信息
	 * 
	 * @return
	 */
	// public List<SalesBasicPo> getSalesBasicPos(String customerID);
	public List<SalesBasicPo> getSalesBasicPos(SalesBasicPo salesBasicPo);

	/**
	 * 修改在途状态
	 * 
	 * @return
	 */
	public void updateSalesBasicPos(SystemParameterPo systemParameterPo,AllocationPo allocationPo,
			String[] ssesbsalesid, InTransitPo inTransitPo,
			DistributionPo distributionPo,LogisticsLogPo logPo);

	/**
	 * 新增在途查询明细表信息
	 * 
	 * @param po
	 */
	public void insertInTransit(InTransitPo inTransitPo);

	/**
	 * 新增配送记录主表
	 * 
	 * @param po
	 */
	public void insertDistribution(DistributionPo distributionPo);

	// public void insertDistribution(String[] ssesbsalesid);
	/**
	 * 新增配送记录明细表
	 * 
	 * @param po
	 */
	public void insertDistributionEntry(DistributionEntryPo distributionEntryPo);
	
	/**
	 * 获取需要隐形配送的门店
	 */
	public List<WarehousePo> getDistributionStoreList(DepartmentsPo po);
	
	public String updateSalesBasicPosCheck(SystemParameterPo systemParameterPo,AllocationPo allocationPo,
			String[] ssesbsalesid, InTransitPo inTransitPo,
			DistributionPo distributionPo,LogisticsLogPo logPo);
}
