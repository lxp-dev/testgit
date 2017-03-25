package com.pengsheng.eims.member.mgr.impl;

import java.util.List;

import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.dao.CustomerInfoDao;
import com.pengsheng.eims.member.dao.MemberUpGradeDao;
import com.pengsheng.eims.member.dao.SmsSetDao;
import com.pengsheng.eims.member.mgr.SmsSetMgr;
import com.pengsheng.eims.member.persistence.SmsRecordPo;
import com.pengsheng.eims.member.persistence.SmsSetPo;
import com.pengsheng.eims.system.mgr.SendNoteMgr;
import com.pengsheng.eims.system.persistence.SendNotePo;
import com.pengsheng.eims.util.tools.Utility;


public class SmsSetMgrImpl implements SmsSetMgr {
	
	private SmsSetDao smsSetDao;
	private LogisticsLogDao logisticsLogDao;
	private SendNoteMgr sendNoteMgr = null;
	
	public SmsSetDao getSmsSetDao() {
		return smsSetDao;
	}

	public void setSmsSetDao(SmsSetDao smsSetDao) {
		this.smsSetDao = smsSetDao;
	}

	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	public SendNoteMgr getSendNoteMgr() {
		return sendNoteMgr;
	}

	public void setSendNoteMgr(SendNoteMgr sendNoteMgr) {
		this.sendNoteMgr = sendNoteMgr;
	}
	
	/**
	 * 查询短息维护信息
	 */
	public SmsSetPo getSmsSetPo() {
		
		return smsSetDao.getSmsSetPo();
	}

	/**
	 * 修改短息维护信息
	 */
	public void updateSmsSetPo(SmsSetPo smsSetPo) {
			
			smsSetDao.updateSmsSetPo(smsSetPo);//修改短信平台信息
		
	}

	public int selectSmsRecordCount(SmsRecordPo smsRecordPo) {
		return smsSetDao.selectSmsRecordCount(smsRecordPo);
	}

	public List<SmsRecordPo> selectSmsRecordList(SmsRecordPo smsRecordPo,int start, int size) {
		return smsSetDao.selectSmsRecordList(smsRecordPo, start, size);
	}
	
	/**
	 * 重发短信
	 */
	public void reSemdSmsRecord(SmsRecordPo smsRecordPo,SendNotePo snpo,String sendContent,String newSendContent){
		List<SmsRecordPo> listTmp = smsSetDao.selectSmsRecordList(smsRecordPo);
		snpo.setSnnotecontent(newSendContent);
		
		for(int i = 0;i < listTmp.size(); i++){			
			snpo.setSncustomerid(Utility.getName(listTmp.get(i).getFsrreceiptperson()));
			snpo.setSncustomertelphone(Utility.getName(listTmp.get(i).getFsrreceipttel()));
			if(sendContent.equals("0")){
				snpo.setSnnotecontent(Utility.getName(listTmp.get(i).getFsrsendcontext()));
			}			
			
			sendNoteMgr.insertReSendNote(snpo);
		}
	}
	
	
	/**
	 * 发送短信
	 */
	public void sendSmsRecord(SendNotePo snpo){
		sendNoteMgr.insertReSendNote(snpo);
	}
}
