package com.pengsheng.eims.sales.mgr.impl;

import java.util.List;

import com.pengsheng.eims.sales.dao.RegisterCardDao;
import com.pengsheng.eims.sales.mgr.RegisterCardMgr;
import com.pengsheng.eims.sales.persistence.RechargeRecordPo;

public class RegisterCardMgrImpl implements RegisterCardMgr {

	private RegisterCardDao registerCardDao;
	public RegisterCardDao getRegisterCardDao() {
		return registerCardDao;
	}

	public void setRegisterCardDao(RegisterCardDao registerCardDao) {
		this.registerCardDao = registerCardDao;
	}

	/**
	 * 充值卡消费数量
	 */
	public int getRegisterCardCount(String customerID) {
		
		return registerCardDao.getRegisterCardCount(customerID);
	}

	/**
	 * 遍历充值卡消费
	 */
	public List<RechargeRecordPo> getRegisterCardList(
			String customerID, int start, int size) {
		
		return registerCardDao.getRegisterCardList(customerID, start, size);
	}

}
