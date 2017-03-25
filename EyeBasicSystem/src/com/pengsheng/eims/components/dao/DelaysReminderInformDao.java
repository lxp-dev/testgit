package com.pengsheng.eims.components.dao;

import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.member.persistence.SmsRecordPo;

public interface DelaysReminderInformDao {

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
