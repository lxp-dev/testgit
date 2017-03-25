package com.pengsheng.eims.casehistory.mgr.impl;

import java.util.List;

import com.pengsheng.eims.components.dao.DelaysReminderInformDao;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.dao.CustomerInfoDao;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.member.persistence.SmsRecordPo;
import com.pengsheng.eims.casehistory.dao.ContactGlassNDao;
import com.pengsheng.eims.casehistory.dao.OptometryBasicNDao;
import com.pengsheng.eims.casehistory.mgr.ContactGlassNMgr;
import com.pengsheng.eims.casehistory.persistence.ContactGlassPo;
import com.pengsheng.eims.casehistory.persistence.OptometryBasicPo;
import com.pengsheng.eims.casehistory.persistence.OptometryPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.util.tools.Utility;

public class ContactGlassNMgrImpl implements ContactGlassNMgr
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
	
	
	private CustomerInfoDao customerInfoDao;
	private DelaysReminderInformDao delaysReminderInformDao;
	private OptometryBasicNDao optometryBasicNDao;
	private ContactGlassNDao contactGlassNDao;
	
	
	

	public OptometryBasicNDao getOptometryBasicNDao() {
		return optometryBasicNDao;
	}

	public void setOptometryBasicNDao(OptometryBasicNDao optometryBasicNDao) {
		this.optometryBasicNDao = optometryBasicNDao;
	}

	public ContactGlassNDao getContactGlassNDao() {
		return contactGlassNDao;
	}

	public void setContactGlassNDao(ContactGlassNDao contactGlassNDao) {
		this.contactGlassNDao = contactGlassNDao;
	}

	public void contactGlassInsert(ContactGlassPo contactGlassPo,OptometryPo optometryPo,OptometryBasicPo optometryBasicPo) {
		this.contactGlassNDao.contactGlassInsert(contactGlassPo);
		
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
	
	public void contactGlassInsert(List<ContactGlassPo> contactGlassPos,OptometryPo optometryPo,OptometryBasicPo optometryBasicPo,LogisticsLogPo logPo) 
	{
		logisticsLogDao.insertLog(logPo);  //新增日志
		
		for(int i=0;i<contactGlassPos.size();i++)
		{
			this.contactGlassNDao.contactGlassInsert(contactGlassPos.get(i));
			
		}
		
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
		
		if(!Utility.getName(optometryPo.getSopoyoptometrybasicid()).equals("")){
			this.optometryBasicNDao.updateOptoTime(optometryPo.getSopoyoptometrybasicid());
		}
		
		if(!Utility.getName(optometryPo.getSopoyoptometryid()).equals("")){
			this.optometryBasicNDao.updateOptoTime1(optometryPo.getSopoyoptometryid());
		}
	}

	public void contactGlassInsertMessage(List<ContactGlassPo> contactGlassPos,OptometryPo optometryPo,OptometryBasicPo optometryBasicPo,SmsRecordPo smsRecordPo,String isSend,PersonInfoPo personInfoPo,String customerID,LogisticsLogPo logPo) 
	{
		logisticsLogDao.insertLog(logPo);  //新增日志
		if(contactGlassPos!=null)
		{
			for(int i=0;i<contactGlassPos.size();i++)
			{
				this.contactGlassNDao.contactGlassInsert(contactGlassPos.get(i));
			}
		}
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
		
		if(!Utility.getName(optometryPo.getSopoyoptometrybasicid()).equals("")){
			this.optometryBasicNDao.updateOptoTime(optometryPo.getSopoyoptometrybasicid());
		}
		
		if(!Utility.getName(optometryPo.getSopoyoptometryid()).equals("")){
			this.optometryBasicNDao.updateOptoTime1(optometryPo.getSopoyoptometryid());
		}
	}
	
	
	public void contactGlassUpdate(ContactGlassPo contactGlassPo) {
		this.contactGlassNDao.contactGlassInsert(contactGlassPo);

		
	}


	public List<ContactGlassPo> getContactGlassList(ContactGlassPo contactGlassPo) {
		return this.contactGlassNDao.getContactGlassList(contactGlassPo);
	}

	
	public void contactGlassDelete(ContactGlassPo contactGlassPo) {
		this.contactGlassNDao.contactGlassDelete(contactGlassPo);
	}

	
	public int getcontactGlassCount(OptometryPo optometryPo) {
		return this.contactGlassNDao.getContactGlassCount(optometryPo);
	}

	
	public void contactGlassUpdate(List<ContactGlassPo> contactGlassPos,
			OptometryPo optometryPo) {
		this.contactGlassNDao.contactGlassDelete(contactGlassPos.get(0));

		
		for(int i=0;i<contactGlassPos.size();i++){
			
				this.contactGlassNDao.contactGlassInsert(contactGlassPos.get(i));
			
		}
		this.optometryBasicNDao.optometryUpdate(optometryPo);
		if(!Utility.getName(optometryPo.getSopoyoptometrybasicid()).equals("")){
			this.optometryBasicNDao.updateOptoTime(optometryPo.getSopoyoptometrybasicid());
		}
		if(!Utility.getName(optometryPo.getSopoyoptometryid()).equals("")){
			this.optometryBasicNDao.updateOptoTime1(optometryPo.getSopoyoptometryid());
		}
		
	}
	
	public void contactGlassUpdateMessage(List<ContactGlassPo> contactGlassPos,OptometryPo optometryPo,SmsRecordPo smsRecordPo,String isSend,PersonInfoPo personInfoPo,String customerID) {
		if(contactGlassPos!=null)
		{
			this.contactGlassNDao.contactGlassDelete(contactGlassPos.get(0));
			for(int i=0;i<contactGlassPos.size();i++)
			{			
				if(contactGlassPos.get(i)!=null)
				{
					
					if(null!=contactGlassPos.get(i).getSopcgindex() && contactGlassPos.get(i).getSopcgindex().equals("a"))
					{
						this.contactGlassNDao.contactGlassInsert(contactGlassPos.get(i));
					}
				}
			}
		}
		this.optometryBasicNDao.optometryUpdate(optometryPo);
		if(!Utility.getName(optometryPo.getSopoyoptometrybasicid()).equals("")){
			this.optometryBasicNDao.updateOptoTime(optometryPo.getSopoyoptometrybasicid());
		}
		if(!Utility.getName(optometryPo.getSopoyoptometryid()).equals("")){
			this.optometryBasicNDao.updateOptoTime1(optometryPo.getSopoyoptometryid());
		}
	}
	
//	public void inspectionprint(String id){
//		inspectionNDao.inspectionprint(id);
//	}
//	public void updateInspectionFlag(String id,SendNotePo snpo){
//		
//		inspectionNDao.updateInspectionFlag(id);
//		
////		if (!"".equals(Utility.getName(snpo.getSnfurtherdate())) && !"".equals(Utility.getName(snpo.getSncustomerid()))){
////			sendNoteMgr.insertSendNoteContent(snpo);
////		}
//		
//	}

	public CustomerInfoPo getCustomerInfo(String id){
		return contactGlassNDao.getCustomerInfo(id);
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
