package com.pengsheng.eims.components.mgr.impl;

import com.pengsheng.eims.components.dao.DelaysReminderInformDao;
import com.pengsheng.eims.components.mgr.DelaysReminderMgr;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.member.persistence.SmsRecordPo;

public class DelaysReminderInformMgrImpl implements DelaysReminderMgr {
	
	private DelaysReminderInformDao delaysReminderInformDao;

	public DelaysReminderInformDao getDelaysReminderInformDao() {
		return delaysReminderInformDao;
	}

	public void setDelaysReminderInformDao(
			DelaysReminderInformDao delaysReminderInformDao) {
		this.delaysReminderInformDao = delaysReminderInformDao;
	}

	/**
	 * 查询顾客信息
	 */
	public CustomerInfoPo getCustomerInfo(String salesid) {
		
		return delaysReminderInformDao.getCustomerInfo(salesid);
	}

	/**
	 * 新增短信记录表 
	 */
	public void insertSmsRecord(SmsRecordPo smsRecordPo) {
		
		delaysReminderInformDao.insertSmsRecord(smsRecordPo);
	}

}
