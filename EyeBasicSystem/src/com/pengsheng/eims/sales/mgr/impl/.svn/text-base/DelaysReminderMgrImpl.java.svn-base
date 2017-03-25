package com.pengsheng.eims.sales.mgr.impl;

import java.util.List;

import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.member.persistence.SmsRecordPo;
import com.pengsheng.eims.member.persistence.SmsSetPo;
import com.pengsheng.eims.sales.dao.DelaysReminderDao;
import com.pengsheng.eims.sales.mgr.DelaysReminderMgr;
import com.pengsheng.eims.sales.persistence.DelaysReminderPo;
import com.pengsheng.sms.server.SynchronizationSMS;
import com.pengsheng.sms.server.persistence.SmsPo;
import com.pengsheng.sms.server.SynchronizationSMS;


public class DelaysReminderMgrImpl implements DelaysReminderMgr {
	private LogisticsLogDao logisticsLogDao;
	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}


	private DelaysReminderDao delaysReminderDao;

	public DelaysReminderDao getDelaysReminderDao() {
		return delaysReminderDao;
	}

	public void setDelaysReminderDao(DelaysReminderDao delaysReminderDao) {
		this.delaysReminderDao = delaysReminderDao;
	}

	/**
	 * 误期提醒信息数量
	 */
	public int getDelaysRemindertCount(DelaysReminderPo po) {

		return delaysReminderDao.getDelaysRemindertCount(po);
	}

	/**
	 * 遍历误期提醒信息
	 */
	public List<DelaysReminderPo> getDelaysRemindertList(DelaysReminderPo po,
			int start, int size) {

		return delaysReminderDao.getDelaysRemindertList(po, start, size);
	}

	/**
	 * 查询顾客信息
	 */
	public CustomerInfoPo getCustomerInfo(String salesid) {

		return delaysReminderDao.getCustomerInfo(salesid);
	}

	/**
	 * 新增短信记录表
	 * @throws Exception 
	 */
	public void insertSmsRecord(SmsRecordPo smsRecordPo) throws Exception {

//		SynchronizationSMS synchronizationSMS = SynchronizationSMS.getInstance();

		SmsPo sms = new SmsPo();
		sms.setSmsid(smsRecordPo.getFsrid());
		sms.setFromid("");
		sms.setPhone(smsRecordPo.getFsrreceipttel());
		sms.setContent(smsRecordPo.getFsrsendcontext());
		sms.setSendtime(smsRecordPo.getFsrsenddate());

		try {
//			synchronizationSMS.insertSMS(sms);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		delaysReminderDao.insertSmsRecord(smsRecordPo);
	}

	/**
	 * 获取短信平台维护表信息
	 */
	public SmsSetPo getSmsSet() {

		return delaysReminderDao.getSmsSet();
	}

	/**
	 * 修改通知状态
	 */
	public void updateDelaysRemindert(String salesid, String noticePerson,LogisticsLogPo logPo) {
		logisticsLogDao.insertLog(logPo);  //新增日志
		
		delaysReminderDao.updateDelaysRemindert(salesid, noticePerson);
	}

	/**
	 * 获取误期的天数
	 */
	public DelaysReminderPo getDelaysReminder(String salesid) {
		
		return delaysReminderDao.getDelaysReminder(salesid);
	}
}
