package com.pengsheng.eims.sales.mgr;

import java.util.List;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.sales.persistence.DistributionEntryPo;
import com.pengsheng.eims.sales.persistence.DistributionPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.storage.persistence.AllocationPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;

public interface DoorStoreDeliveryMgr {
	/** 
	 * 查询门店配送信息
	 * @return
	 */
	public List<SalesBasicPo> getSalesBasicPos(SalesBasicPo po,String type);
	/**
	 * 修改在途状态
	 * @return
	 */
	public void updateSalesBasicPos(SystemParameterPo systemParameterPo,String[] ssesbsalesid,String[] ssesbdragstype,InTransitPo inTransitPo,DistributionPo distributionPo,LogisticsLogPo logPo);

	/**
	 * 获取门店已配送的数量
	 * @return
	 */
	public int getDoorStoreYetDeliveryCount(DistributionPo distributionPo);
	
	/**
	 * 获取门店已配送的列表
	 * @return
	 */
	public List<DistributionPo> getDoorStoreYetDeliveryList(DistributionPo distributionPo,int start,int size);
	
	/**
	 * 新增在途查询明细表信息
	 * @param po
	 */
	public void insertInTransit(InTransitPo inTransitPo);

	/**
	 * 新增配送记录主表
	 * @param po
	 */
	public void insertDistribution(DistributionPo distributionPo);
	//public void insertDistribution(String[] ssesbsalesid);
	/**
	 * 新增配送记录明细表
	 * @param po
	 */
	public void insertDistributionEntry(DistributionEntryPo  distributionEntryPo);
	
	/**
	 * 获取门店已配送信息
	 * @return
	 */
	public DistributionPo getDoorStoreYetDeliveryDetail(DistributionPo distributionPo);
	
	/**
	 * 获取门店已配送明细
	 * @return
	 */
	public List<DistributionEntryPo> getDoorStoreYetDeliveryEntryDetail(DistributionPo distributionPo);
	
	/**
	 * 查询调拨配送信息
	 */
	public int selectAllocationSendOrSendedsCount(AllocationPo po);
	
	/**
	 * 查询调拨配送信息
	 */
	public List<AllocationPo> selectAllocationSendOrSendeds(AllocationPo po, int start, int size);
	
	/**
	 * 调拨配送更新方法
	 */
	public void updateAllocationSends(String[] ssesbsalesid,DistributionPo distributionPo,LogisticsLogPo logPo);
	
	/**
	 * 获取门店已配送的数量
	 * @return
	 */
	public int selectAllocationSendedCount(DistributionPo distributionPo);
	
	/**
	 * 获取门店已配送的列表
	 * @return
	 */
	public List<DistributionPo> selectAllocationSendedList(DistributionPo distributionPo,int start,int size);
	
	/**
	 * 获取调拨已配送明细
	 * @return
	 */
	public List<DistributionEntryPo> getAllocationSendedEntryDetail(DistributionPo distributionPo);
}
