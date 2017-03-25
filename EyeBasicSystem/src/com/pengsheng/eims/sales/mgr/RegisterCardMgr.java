package com.pengsheng.eims.sales.mgr;

import java.util.List;

import com.pengsheng.eims.sales.persistence.RechargeRecordPo;

public interface RegisterCardMgr {

	/**
	 * 充值卡消费数量
	 * @param customerID
	 * @return
	 */
	public int getRegisterCardCount(String customerID);
	/**
	 * 遍历充值卡消费
	 * @param customerID
	 * @param start
	 * @param size
	 * @return
	 */
	public List<RechargeRecordPo> getRegisterCardList(String customerID,int start, int size);
	
}
