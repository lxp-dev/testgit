package com.pengsheng.eims.member.dao;

import java.util.List;

import com.pengsheng.eims.member.persistence.SmsRecordPo;
import com.pengsheng.eims.member.persistence.SmsSetPo;




public interface SmsSetDao {
	
	/**
	 * 查询短息维护信息
	 * @param smsSetPo
	 * @return
	 */
	public SmsSetPo getSmsSetPo();

	/**
	 * 修改短息维护信息
	 * @param smsSetPo
	 */
	public void updateSmsSetPo(SmsSetPo smsSetPo);
	
	/**
	 * 查询短息记录Count
	 * @param smsRecordPo
	 * @return
	 */
	public int selectSmsRecordCount(SmsRecordPo smsRecordPo);
	
	/**
	 * 查询短息记录List
	 * @param smsRecordPo
	 * @return
	 */
	public List<SmsRecordPo> selectSmsRecordList(SmsRecordPo smsRecordPo,int start ,int size);
	
	/**
	 * 查询短息记录List
	 * @param smsRecordPo
	 * @return
	 */
	public List<SmsRecordPo> selectSmsRecordList(SmsRecordPo smsRecordPo);
}
