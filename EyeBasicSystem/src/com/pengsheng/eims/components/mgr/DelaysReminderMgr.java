package com.pengsheng.eims.components.mgr;

import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.member.persistence.SmsRecordPo;

public interface DelaysReminderMgr {
	
	/**
	 * 新增短信记录表 
	 * @param smsRecordPo
	 */
	public void insertSmsRecord(SmsRecordPo smsRecordPo);
	
	
	/**
	 * 查询顾客信息
	 * @param salesBasicPo
	 * @return
	 */
	public CustomerInfoPo getCustomerInfo(String salesid );

}
