package com.pengsheng.eims.storage.mgr;

import java.util.List;

import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.storage.persistence.AllocationBarcodePo;
import com.pengsheng.eims.storage.persistence.AllocationEntryPo;
import com.pengsheng.eims.storage.persistence.AllocationPo;
import com.pengsheng.eims.storage.persistence.NonconformingEntryPo;
import com.pengsheng.eims.storage.persistence.NonconformingPo;
import com.pengsheng.eims.system.persistence.SmsLertsPo;

public interface NonconformingMgr {

	/**
	 * 得到不合格品信息数量
	 * 
	 * @param po
	 * @return
	 */
	public int getNonconformingCount(NonconformingPo po);

	/**
	 * 得到不合格品信息
	 * 
	 * @param po
	 * @param start
	 * @param size
	 * @return
	 */
	public List<NonconformingPo> getNonconformingList(NonconformingPo po,
			int start, int size);

	/**
	 * 得到不合格品详细信息
	 * 
	 * @param po
	 * @return
	 */
	public NonconformingPo getNonconforming(NonconformingPo po);

	/**
	 * 得到List类型的不合格品详细信息
	 * 
	 * @param po
	 * @return
	 */
	public List<NonconformingEntryPo> getNonconformingEntryList(
			NonconformingPo po);

	/**
	 * 新增不合格品信息填入业务及业务明细表中
	 * 
	 * @param po
	 * @param list
	 */
	public void insertNonconforming(NonconformingPo po,List<NonconformingEntryPo> list,LogisticsLogPo logPo,AllocationPo allocationPo, List<AllocationEntryPo> elist,SmsLertsPo smsLertsPo, List<AllocationBarcodePo> allocationBarcodeList,LogisticsLogPo logPo1);
//	public void insertNonconforming(NonconformingPo po,List<NonconformingEntryPo> list,LogisticsLogPo logPo);

	/**
	 * 更新不合格品信息 业务及业务明细表中的信息
	 * 
	 * @param po
	 * @param list
	 */
	public void updateNonconforming(NonconformingPo po,
			List<NonconformingEntryPo> list);

	public void updateNonconforming(NonconformingPo po,
			List<NonconformingEntryPo> list, String flag,LogisticsLogPo logPo,AllocationPo allocationPo, List<AllocationEntryPo> elist,SmsLertsPo smsLertsPo, List<AllocationBarcodePo> allocationBarcodeList,LogisticsLogPo logPo1);
	
	public void updateNonconforming(NonconformingPo po,List<NonconformingEntryPo> list, String flag,LogisticsLogPo logPo,List<AllocationEntryPo> elist);
	
	/**
	 * 删除不合格品信息 业务表中的信息
	 * 
	 * @param po
	 */
	public void deleteNonconforming(NonconformingPo po,LogisticsLogPo logPo);

	/**
	 * 得到不合格品明细
	 * 
	 * @param shopcode
	 * @param cshanstartTime
	 * @param cshanendTime
	 * @return
	 */
	public List<NonconformingPo> getNonconformingList(String shopcode,
			String cshanstartTime, String cshanendTime);

	/**
	 * 不合格品汇总
	 * 
	 * @param allocationPo
	 * @param billids
	 */
	public void summaryAllocation(AllocationPo allocationPo, String... billids);
	
	/**
	 * 获得检查结论
	 * 
	 * @param po
	 * @return
	 */
	public SalesBasicPo getSalesBasicPo(NonconformingPo po);
	
	/**
	 * 仓位查询
	 */
	public WarehousePo getWarehousePo(String did);
}
