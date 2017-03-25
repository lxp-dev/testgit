package com.pengsheng.eims.sales.dao;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.sales.persistence.DistributionEntryPo;
import com.pengsheng.eims.sales.persistence.DistributionPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.storage.persistence.AllocationPo;

public interface InvisibleDistributionDao {
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
	 * @param salesBasicPo
	 */
	public void updateSalesBasicPos(SalesBasicPo salesBasicPo);

	/**
	 * 新增在途查询明细表
	 * 
	 * @param po
	 */
	public void insertInTransit(InTransitPo inTransitPo);

	/**
	 * 新增配送记录主表
	 * 
	 * @param po
	 */
	public String insertDistribution(DistributionPo distributionPo);

	/**
	 * 新增配送记录明细表
	 * 
	 * @param po
	 */
	public void insertDistributionEntry(DistributionPo distributionPo,
			DistributionEntryPo distributionEntryPo);

	/**
	 * 生成副调拨
	 * 
	 * @param allocationPo
	 */
	public void summaryAllocation(AllocationPo allocationPo);

	/**
	 * 生成副调拨明细
	 * 
	 * @param allocationPo
	 * @param billids
	 */
	public void summaryAllocationEntry(AllocationPo allocationPo,
			String... salesIDs);

	/**
	 * 生成调拨汇总
	 * 
	 * @param allocationPo
	 * @param billids
	 */
	public void biilderAllcoactionBarcode(AllocationPo allocationPo,
			String... salesIDs);
	
	/**
	 * 获取委外收货单中隐形定制商品的条码
	 */
	public List<SalesDetailPo> getGoodsItemsByDelivery(String[] ssesbsalesid);
	
	/**
	 * 更新配镜单中隐形订制片的商品条码
	 */
	public void updateGoodsItemsByDelivery(SalesDetailPo po);
	
	/**
	 * 获取需要隐形配送的门店
	 */
	public List<WarehousePo> getDistributionStoreList(DepartmentsPo po);
	
	/**
	 * 判断是否已经插入过
	 * @param distributionPo
	 * @return
	 */
	public DistributionPo isInsertDistribution(DistributionPo distributionPo);
}
