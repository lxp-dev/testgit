/**
 * 
 */
package com.pengsheng.eims.sms.mgr.impl;

import com.pengsheng.eims.member.persistence.SmsRecordPo;
import com.pengsheng.eims.sms.dao.SmsSyncDao;
import com.pengsheng.eims.sms.mgr.SmsSyncMgr;
import com.pengsheng.sms.server.SynchronizationSMS;
import com.pengsheng.sms.server.persistence.SmsPo;

/**
 * @author Liuqian
 * 
 */
public class SmsSyncMgrImpl implements SmsSyncMgr {

	private SmsSyncDao smsSyncDao;

	public SmsSyncDao getSmsSyncDao() {
		return smsSyncDao;
	}

	public void setSmsSyncDao(SmsSyncDao smsSyncDao) {
		this.smsSyncDao = smsSyncDao;
	}

	
	public void syncSmsList() throws Exception {
		// TODO Auto-generated method stub

//		SynchronizationSMS synchronizationSMS = SynchronizationSMS
//				.getInstance();

		for (SmsRecordPo smsRecordPo : smsSyncDao.getSmsList()) {

			SmsPo sms = new SmsPo();
			sms.setSmsid(smsRecordPo.getFsrid());
			sms.setFromid("");
			sms.setPhone(smsRecordPo.getFsrreceipttel());
			sms.setContent(smsRecordPo.getFsrsendcontext());
			sms.setSendtime(smsRecordPo.getFsrsenddate());

			try {
//				synchronizationSMS.insertSMS(sms);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			smsSyncDao.updateSmsFlag(smsRecordPo.getFsrid());

		}
	}

}
