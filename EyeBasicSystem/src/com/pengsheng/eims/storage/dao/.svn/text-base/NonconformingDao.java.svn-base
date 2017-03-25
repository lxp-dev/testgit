package com.pengsheng.eims.storage.dao;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.storage.persistence.AllocationPo;
import com.pengsheng.eims.storage.persistence.NonconformingEntryPo;
import com.pengsheng.eims.storage.persistence.NonconformingPo;

public interface NonconformingDao {

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
	 * 得到不合格品详细信息放入List<NonconformingEntryPo>中
	 * 
	 * @param po
	 * @return
	 */
	public List<NonconformingEntryPo> getNonconformingEntryList(
			NonconformingPo po);

	/**
	 * 新增不合格品信息填入业务表中
	 * 
	 * @param po
	 */
	public void insertNonconforming(NonconformingPo po);

	/**
	 * 新增不合格品信息填入业务明细表中
	 * 
	 * @param po
	 */
	public void insertNonconformingEntry(NonconformingEntryPo po);

	/**
	 * 更新不合格品信息
	 * 
	 * @param po
	 */
	public void updateNonconforming(NonconformingPo po);

	/**
	 * 删除不合格品信息
	 * 
	 * @param po
	 */
	public void deleteNonconforming(NonconformingPo po);

	/**
	 * 删除不合格品详细信息
	 * 
	 * @param po
	 */
	public void deleteNonconformingEntry(NonconformingPo po);

	public void doNonconforming(NonconformingPo po);

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
			String... billids);

	/**
	 * 更新不合格品单汇总状态
	 * 
	 * @param billids
	 */
	public void updateNonconformingState(String... billids);

	/**
	 * 生成调拨汇总
	 * 
	 * @param allocationPo
	 * @param billids
	 */
	public void biilderAllcoactionBarcode(AllocationPo allocationPo,
			String... billids);
	
	/**
	 * 获取检查结论
	 * 
	 * @param po
	 * @return
	 */
	public SalesBasicPo getSalesBasicPo(NonconformingPo po);
	public SalesBasicPo getSalesBasicPoFinished(NonconformingPo po);
	
	/**
	 * 仓位查询
	 */
	
	public WarehousePo getWarehousePo(String did);
}
