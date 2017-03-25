package com.pengsheng.eims.storage.mgr;

import java.util.List;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.sales.persistence.DelaysReminderPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;

public interface StorageDelaysReminderMgr {

	/**
	 * 误期提醒信息数量
	 * 
	 * @param po
	 * @return
	 */
	public int getStoragetDelaysRemindertCount(DelaysReminderPo po);

	/**
	 * 遍历误期提醒信息
	 * 
	 * @param po
	 * @param start
	 * @param size
	 * @return
	 */
	public List<DelaysReminderPo> getStorageDelaysRemindertList(
			DelaysReminderPo po, int start, int size);

	/**
	 * 取出销售单中右眼镜片信息
	 * 
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getODDetailInfo(SalesBasicPo salesBasicPo);

	/**
	 * 取出销售单中左眼镜片信息
	 * 
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getOSDetailInfo(SalesBasicPo salesBasicPo);

	/**
	 * 新增误期信息
	 * 
	 * @param po
	 */
	public void insertDelaysRemindert(DelaysReminderPo po,LogisticsLogPo logPo);

	/**
	 * 删除误期查询
	 * 
	 * @param po
	 */
	public void deleteStorageDelaysRemindert(String id,LogisticsLogPo logPo);

	/**
	 * 查询误期信息
	 * 
	 * @param po
	 * @return
	 */
	public DelaysReminderPo getStorageDelaysRemindert(DelaysReminderPo po);

	/**
	 * 查询订单误期信息数量
	 * 
	 * @param po
	 */
	public int getOrderDelaysRemindertCount(DelaysReminderPo delaysReminderPo);

	/**
	 * 显示订单误期信息
	 * 
	 * @param po
	 * @param start
	 * @param size
	 * @return
	 */
	public List<DelaysReminderPo> getOrderDelaysRemindertList(
			DelaysReminderPo delaysReminderPo, int start, int size);

	/**
	 * 查询销售结帐基表信息
	 */
	public SalesBasicPo getSalesBasic(SalesBasicPo po);

}
