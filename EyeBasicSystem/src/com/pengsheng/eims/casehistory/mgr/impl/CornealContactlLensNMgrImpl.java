package com.pengsheng.eims.casehistory.mgr.impl;

import java.util.List;

import com.pengsheng.eims.components.dao.DelaysReminderInformDao;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.dao.CustomerInfoDao;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.member.persistence.SmsRecordPo;
import com.pengsheng.eims.casehistory.dao.CornealContactlLensNDao;
import com.pengsheng.eims.casehistory.dao.OptometryBasicNDao;
import com.pengsheng.eims.casehistory.mgr.CornealContactlLensNMgr;
import com.pengsheng.eims.casehistory.persistence.CornealContactlLensPo;
import com.pengsheng.eims.casehistory.persistence.OptometryBasicPo;
import com.pengsheng.eims.casehistory.persistence.OptometryPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.SendNotePo;
import com.pengsheng.eims.util.tools.Utility;

public class CornealContactlLensNMgrImpl implements  CornealContactlLensNMgr
{
	private LogisticsLogDao logisticsLogDao;
//	private SystemParameterMgr systemParameterMgr;
//	private SystemParameterPo systemParameterPo;
//	private SendNoteMgr sendNoteMgr = null;
//	
//	public SendNoteMgr getSendNoteMgr() {
//		return sendNoteMgr;
//	}
//
//	public void setSendNoteMgr(SendNoteMgr sendNoteMgr) {
//		this.sendNoteMgr = sendNoteMgr;
//	}
//
//	public SystemParameterMgr getSystemParameterMgr() {
//		return systemParameterMgr;
//	}
//
//	public void setSystemParameterMgr(SystemParameterMgr systemParameterMgr) {
//		this.systemParameterMgr = systemParameterMgr;
//	}
//
//	public SystemParameterPo getSystemParameterPo() {
//		return systemParameterPo;
//	}
//
//	public void setSystemParameterPo(SystemParameterPo systemParameterPo) {
//		this.systemParameterPo = systemParameterPo;
//	}

	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}
	private CornealContactlLensNDao cornealContactlLensNDao;
	public CornealContactlLensNDao getCornealContactlLensNDao() {
		return cornealContactlLensNDao;
	}
	
	private CustomerInfoDao customerInfoDao;
	private DelaysReminderInformDao delaysReminderInformDao;
	private OptometryBasicNDao optometryBasicNDao;
	
	public OptometryBasicNDao getOptometryBasicNDao() {
		return optometryBasicNDao;
	}

	public void setOptometryBasicNDao(OptometryBasicNDao optometryBasicNDao) {
		this.optometryBasicNDao = optometryBasicNDao;
	}

	public void setCornealContactlLensNDao(CornealContactlLensNDao cornealContactlLensNDao) {
		this.cornealContactlLensNDao = cornealContactlLensNDao;
	}

	public void cornealContactlLensInsert(CornealContactlLensPo cornealContactlLensPo,OptometryPo optometryPo,OptometryBasicPo optometryBasicPo) {
		this.cornealContactlLensNDao.cornealContactlLensInsert(cornealContactlLensPo);
		
		if(optometryBasicPo!=null){
			if(this.optometryBasicNDao.getOptometryBasicCount2(optometryBasicPo)==0){
				this.optometryBasicNDao.optometryBasicInsert(optometryBasicPo);
			}else{
				
			}
		}	
		if(optometryPo!=null){
			if(this.optometryBasicNDao.getOptometryCount2(optometryPo)==0){
				this.optometryBasicNDao.optometryInsert(optometryPo);
			}else{	
				this.optometryBasicNDao.optometryUpdate(optometryPo);
			}
		}
	}
	
	public void cornealContactlLensInsert(CornealContactlLensPo cornealContactlLensPo,OptometryPo optometryPo,OptometryBasicPo optometryBasicPo,LogisticsLogPo logPo) 
	{
		logisticsLogDao.insertLog(logPo);  //新增日志
		
		this.cornealContactlLensNDao.cornealContactlLensInsert(cornealContactlLensPo);
		
		if(optometryBasicPo!=null){
			if(this.optometryBasicNDao.getOptometryBasicCount2(optometryBasicPo)==0){
				this.optometryBasicNDao.optometryBasicInsert(optometryBasicPo);
			}
		}
		
		if(optometryPo!=null){
			if(this.optometryBasicNDao.getOptometryCount2(optometryPo)==0){
				this.optometryBasicNDao.optometryInsert(optometryPo);
			}else{	
				this.optometryBasicNDao.optometryUpdate(optometryPo);
			}
		}
		
		if(!Utility.getName(optometryPo.getSopoyoptometrybasicid()).equals("")){
			this.optometryBasicNDao.updateOptoTime(optometryPo.getSopoyoptometrybasicid());
		}
		
		if(!Utility.getName(optometryPo.getSopoyoptometryid()).equals("")){
			this.optometryBasicNDao.updateOptoTime1(optometryPo.getSopoyoptometryid());
		}
	}

	public void cornealContactlLensInsertMessage(CornealContactlLensPo cornealContactlLensPo,OptometryPo optometryPo,OptometryBasicPo optometryBasicPo,SmsRecordPo smsRecordPo,String isSend,PersonInfoPo personInfoPo,String customerID,LogisticsLogPo logPo) 
	{
		logisticsLogDao.insertLog(logPo);  //新增日志
		
		this.cornealContactlLensNDao.cornealContactlLensInsert(cornealContactlLensPo);
		
		if(optometryBasicPo!=null){
			if(this.optometryBasicNDao.getOptometryBasicCount2(optometryBasicPo)==0){
				this.optometryBasicNDao.optometryBasicInsert(optometryBasicPo);
			}
		}
		
		if(optometryPo!=null){
			if(this.optometryBasicNDao.getOptometryCount2(optometryPo)==0){
				this.optometryBasicNDao.optometryInsert(optometryPo);
			}else{	
				this.optometryBasicNDao.optometryUpdate(optometryPo);
			}
		}
		
		if(!Utility.getName(optometryPo.getSopoyoptometrybasicid()).equals("")){
			this.optometryBasicNDao.updateOptoTime(optometryPo.getSopoyoptometrybasicid());
		}
		
		if(!Utility.getName(optometryPo.getSopoyoptometryid()).equals("")){
			this.optometryBasicNDao.updateOptoTime1(optometryPo.getSopoyoptometryid());
		}
	}
	
	
	public void cornealContactlLensUpdate(CornealContactlLensPo cornealContactlLensPo) {
		this.cornealContactlLensNDao.cornealContactlLensInsert(cornealContactlLensPo);

		
	}


	public List<CornealContactlLensPo> getCornealContactlLensList(CornealContactlLensPo cornealContactlLensPo) {
		return this.cornealContactlLensNDao.getCornealContactlLensList(cornealContactlLensPo);
	}

	
	public void cornealContactlLensDelete(CornealContactlLensPo cornealContactlLensPo) {
		this.cornealContactlLensNDao.cornealContactlLensDelete(cornealContactlLensPo);
	}

	
	public int getCornealContactlLensCount(OptometryPo optometryPo) {
		return this.cornealContactlLensNDao.getCornealContactlLensCount(optometryPo);
	}

	
	public void cornealContactlLensUpdate(CornealContactlLensPo cornealContactlLensPo,
			OptometryPo optometryPo) {
		this.cornealContactlLensNDao.cornealContactlLensDelete(cornealContactlLensPo);

		this.cornealContactlLensNDao.cornealContactlLensInsert(cornealContactlLensPo);
		
		this.optometryBasicNDao.optometryUpdate(optometryPo);
		if(!Utility.getName(optometryPo.getSopoyoptometrybasicid()).equals("")){
			this.optometryBasicNDao.updateOptoTime(optometryPo.getSopoyoptometrybasicid());
		}
		if(!Utility.getName(optometryPo.getSopoyoptometryid()).equals("")){
			this.optometryBasicNDao.updateOptoTime1(optometryPo.getSopoyoptometryid());
		}
		
	}
	
	public void cornealContactlLensUpdateMessage(CornealContactlLensPo cornealContactlLensPo,OptometryPo optometryPo,SmsRecordPo smsRecordPo,String isSend,PersonInfoPo personInfoPo,String customerID) {
		this.cornealContactlLensNDao.cornealContactlLensDelete(cornealContactlLensPo);
		
		this.cornealContactlLensNDao.cornealContactlLensInsert(cornealContactlLensPo);
		
		this.optometryBasicNDao.optometryUpdate(optometryPo);
		if(!Utility.getName(optometryPo.getSopoyoptometrybasicid()).equals("")){
			this.optometryBasicNDao.updateOptoTime(optometryPo.getSopoyoptometrybasicid());
		}
		if(!Utility.getName(optometryPo.getSopoyoptometryid()).equals("")){
			this.optometryBasicNDao.updateOptoTime1(optometryPo.getSopoyoptometryid());
		}
//		if(isSend.equals("1"))
//		{
//			CustomerInfoPo cpo = new CustomerInfoPo();
//			cpo.setSmecicustomerid(customerID);
//			CustomerInfoPo customerInfoPo = customerInfoDao.getCustomerInfo(cpo);
//			if(Utility.isMobile(customerInfoPo.getSmeciphone()))
//			{
//				smsRecordPo.setFsrreceiptperson(customerInfoPo.getSmecicustomerid());
//				smsRecordPo.setFsrreceipttel(customerInfoPo.getSmeciphone());
//				smsRecordPo.setFsrsendperson(personInfoPo.getId());
//				Date now = new Date(); 
//				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//
//				smsRecordPo.setFsrsenddate(dateFormat.format(now)); 
//				delaysReminderInformDao.insertSmsRecord(smsRecordPo);
//			}
//		}	
	}
	
	public void cornealContactlLensprint(String id){
		cornealContactlLensNDao.cornealContactlLensprint(id);
	}
	public void updateCornealContactlLensFlag(String id,SendNotePo snpo){
		
		cornealContactlLensNDao.updateCornealContactlLensFlag(id);
		
//		if (!"".equals(Utility.getName(snpo.getSnfurtherdate())) && !"".equals(Utility.getName(snpo.getSncustomerid()))){
//			sendNoteMgr.insertSendNoteContent(snpo);
//		}
		
	}

	public CustomerInfoPo getCustomerInfo(String id){
		return cornealContactlLensNDao.getCustomerInfo(id);
	}
	
	public CustomerInfoDao getCustomerInfoDao() {
		return customerInfoDao;
	}

	public void setCustomerInfoDao(CustomerInfoDao customerInfoDao) {
		this.customerInfoDao = customerInfoDao;
	}

	public DelaysReminderInformDao getDelaysReminderInformDao() {
		return delaysReminderInformDao;
	}

	public void setDelaysReminderInformDao(
			DelaysReminderInformDao delaysReminderInformDao) {
		this.delaysReminderInformDao = delaysReminderInformDao;
	}
}
