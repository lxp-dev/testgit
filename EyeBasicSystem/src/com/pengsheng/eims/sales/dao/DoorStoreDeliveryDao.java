package com.pengsheng.eims.sales.dao;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.sales.persistence.DistributionEntryPo;
import com.pengsheng.eims.sales.persistence.DistributionPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.storage.persistence.AllocationPo;
import com.pengsheng.eims.util.tools.Utility;

public interface DoorStoreDeliveryDao {

	/**
	 * 查询门店配送信息
	 * 
	 * @return
	 */
	public List<SalesBasicPo> getSalesBasicPos(SalesBasicPo po,String type);

	/**
	 * 修改在途状态
	 * 
	 * @return
	 */
	public void updateSalesBasicPos(SalesBasicPo salesBasicPo);
	
	/**
	 * 查询在途状态
	 * 
	 * @return
	 */
	public InTransitPo selectInTransit(InTransitPo inTransitPo);

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
	public void insertDistributionEntry(DistributionPo distributionPo,DistributionEntryPo distributionEntryPo);
	
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
	 * 修改在途状态
	 * 
	 * @return
	 */
	public void updateSalesIntrnsitInfo(SalesBasicPo salesBasicPo);
	
	/**
	 * 查询调拨配送信息
	 */
	public int selectAllocationSendOrSendedsCount(AllocationPo po);
	
	/**
	 * 查询调拨配送信息
	 */
	public List<AllocationPo> selectAllocationSendOrSendeds(AllocationPo po, int start, int size);
	
	/**
	 * 修改调拨单配送状态
	 * 
	 * @return
	 */
	public void updateAllocationSendBillId(AllocationPo po);
	
	/**
	 * 新增配送记录明细表
	 * 
	 * @param po
	 */
	public void insertAllocationSendEntry(DistributionPo distributionPo,
			DistributionEntryPo distributionEntryPo);
	
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
