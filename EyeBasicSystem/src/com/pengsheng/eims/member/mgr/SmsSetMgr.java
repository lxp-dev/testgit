package com.pengsheng.eims.member.mgr;

import java.util.List;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.persistence.SmsRecordPo;
import com.pengsheng.eims.member.persistence.SmsSetPo;
import com.pengsheng.eims.system.persistence.SendNotePo;


public interface SmsSetMgr {
	
	/**
	 * 查询短息维护信息
	 * @param smsSetPo
	 * @return
	 */
	public SmsSetPo getSmsSetPo();

	/**
	 * 修改短息维护信息并新增短信记录表信息
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
	 * 重发短信
	 */
	public void reSemdSmsRecord(SmsRecordPo smsRecordPo,SendNotePo snpo,String sendContent,String newSendContent);
	
	/**
	 * 发送短信
	 */
	public void sendSmsRecord(SendNotePo snpo);
}
