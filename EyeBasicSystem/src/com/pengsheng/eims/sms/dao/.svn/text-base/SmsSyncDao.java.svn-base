/**
 * 
 */
package com.pengsheng.eims.sms.dao;

import java.util.List;

import com.pengsheng.eims.member.persistence.SmsRecordPo;

/**
 * @author Liuqian
 * 
 */
public interface SmsSyncDao {

	/**
	 * 得到所有没有发送的短信
	 * 
	 * @return
	 */
	public List<SmsRecordPo> getSmsList();

	/**
	 * 更新短信状态为已发送
	 * 
	 * @param id
	 */
	public void updateSmsFlag(String id);
}
