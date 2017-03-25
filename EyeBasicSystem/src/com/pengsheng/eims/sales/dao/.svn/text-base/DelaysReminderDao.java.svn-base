package com.pengsheng.eims.sales.dao;

import java.util.List;

import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.member.persistence.SmsRecordPo;
import com.pengsheng.eims.member.persistence.SmsSetPo;
import com.pengsheng.eims.sales.persistence.DelaysReminderPo;




public interface DelaysReminderDao {
	
	/**
	 * 误期提醒信息数量
	 * @param po
	 * @return
	 */
	public int getDelaysRemindertCount(DelaysReminderPo po);
	
	
	/**
	 * 遍历误期提醒信息
	 * @param po
	 * @param start
	 * @param size
	 * @return
	 */
	public List<DelaysReminderPo> getDelaysRemindertList(DelaysReminderPo po,int start, int size);

	
	
	/**
	 * 修改通知状态
	 * @param ssedrid
	 */
	public void updateDelaysRemindert(String salesid, String noticePerson);
	/**
	 * 
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
	
	/**
	 * 获取短信平台维护表信息
	 * @param smsSetPo
	 * @return
	 */
	public SmsSetPo getSmsSet();
	
	/**
	 * 获取误期的天数
	 * @param salesid
	 * @return
	 */
	public DelaysReminderPo getDelaysReminder(String salesid);
}
