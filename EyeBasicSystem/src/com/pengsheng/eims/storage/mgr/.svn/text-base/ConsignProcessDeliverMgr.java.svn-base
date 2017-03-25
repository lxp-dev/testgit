package com.pengsheng.eims.storage.mgr;

import java.util.List;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.persistence.ConsignProcessOrderDetailsPo;
import com.pengsheng.eims.storage.persistence.DeliverEntryPo;
import com.pengsheng.eims.storage.persistence.DeliverPo;

/**
 * 委外送货mgr接口
 */
public interface ConsignProcessDeliverMgr {
	/**
	 * 获取委外送货的数量
	 * @param po DeliverPo
	 * @return int 数量
	 */		
	public int getConsignProcessDeliverCount(DeliverPo deliverPo);
	/**
	 * 获取委外送货的list
	 * @param po DeliverPo
	 * @param start
	 * @param size 
	 * @return list DeliverPo的list
	 */		
	public List<DeliverPo> getConsignProcessDeliverList(DeliverPo deliverPo,int start, int size);
	/**
	 * 新增委外送货表
	 * @param deliverPo DeliverPo
	 * @param deliverEntryPoList List<DeliverEntryPo>
	 */		
	public void insertConsignProcessDeliver(DeliverPo deliverPo,List<DeliverEntryPo> deliverEntryPoList,LogisticsLogPo logPo);
	/**
	 * 获取委外送货的主表
	 * @param deliverPo DeliverPo
	 * @return DeliverPo
	 */		
	public DeliverPo getConsignProcessDeliver(DeliverPo deliverPo);
	/**
	 * 获取委外送货的从表
	 * @param deliverPo DeliverPo
	 * @return list DeliverEntryPo的list
	 */		
	public List<ConsignProcessOrderDetailsPo> getConsignProcessDeliverEntryList(DeliverPo deliverPo);
	/**
	 * 修改委外送货表
	 * @param deliverPo DeliverPo
	 * @param deliverEntryPoList List<DeliverEntryPo>
	 */		
	public void updateConsignProcessDeliver(DeliverPo deliverPo,List<DeliverEntryPo> deliverEntryPoList,LogisticsLogPo logPo);
	/**
	 * 删除委外送货表
	 * @param deliverPo DeliverPo
	 */		
	public void deleteConsignProcessDeliver(DeliverPo deliverPo,LogisticsLogPo logPo);
	

}
