package com.pengsheng.eims.bjtrhistory.mgr.impl;

import java.util.List;

import com.pengsheng.eims.components.dao.DelaysReminderInformDao;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.dao.CustomerInfoDao;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.member.persistence.SmsRecordPo;
import com.pengsheng.eims.bjtrhistory.dao.ContactGlassBjtrDao;
import com.pengsheng.eims.bjtrhistory.dao.OptometryBasicBjtrDao;
import com.pengsheng.eims.bjtrhistory.mgr.ContactGlassBjtrMgr;
import com.pengsheng.eims.bjtrhistory.persistence.ContactGlassPo;
import com.pengsheng.eims.bjtrhistory.persistence.OptometryBasicPo;
import com.pengsheng.eims.bjtrhistory.persistence.OptometryPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.util.tools.Utility;

public class ContactGlassBjtrMgrImpl implements ContactGlassBjtrMgr
{
	private LogisticsLogDao logisticsLogDao;
	private CustomerInfoDao customerInfoDao;
	private DelaysReminderInformDao delaysReminderInformDao;
	private OptometryBasicBjtrDao optometryBasicBjtrDao;
	private ContactGlassBjtrDao contactGlassBjtrDao;

	public OptometryBasicBjtrDao getOptometryBasicBjtrDao() {
		return optometryBasicBjtrDao;
	}

	public void setOptometryBasicBjtrDao(OptometryBasicBjtrDao optometryBasicBjtrDao) {
		this.optometryBasicBjtrDao = optometryBasicBjtrDao;
	}

	public ContactGlassBjtrDao getContactGlassBjtrDao() {
		return contactGlassBjtrDao;
	}

	public void setContactGlassBjtrDao(ContactGlassBjtrDao contactGlassBjtrDao) {
		this.contactGlassBjtrDao = contactGlassBjtrDao;
	}

	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}


	public void contactGlassInsert(ContactGlassPo contactGlassPo,OptometryPo optometryPo,OptometryBasicPo optometryBasicPo) {
		this.contactGlassBjtrDao.contactGlassInsert(contactGlassPo);
		
		if(optometryBasicPo!=null){
			if(this.optometryBasicBjtrDao.getOptometryBasicCount2(optometryBasicPo)==0){
				this.optometryBasicBjtrDao.optometryBasicInsert(optometryBasicPo);
			}else{
				
			}
		}	
		if(optometryPo!=null){
			if(this.optometryBasicBjtrDao.getOptometryCount2(optometryPo)==0){
				this.optometryBasicBjtrDao.optometryInsert(optometryPo);
			}else{	
				this.optometryBasicBjtrDao.optometryUpdate(optometryPo);
			}
		}
	}
	
	public void contactGlassInsert(List<ContactGlassPo> contactGlassPos,OptometryPo optometryPo,OptometryBasicPo optometryBasicPo,LogisticsLogPo logPo) 
	{
		logisticsLogDao.insertLog(logPo);  //新增日志
		
		for(int i=0;i<contactGlassPos.size();i++)
		{
			this.contactGlassBjtrDao.contactGlassInsert(contactGlassPos.get(i));
			
		}
		
		if(optometryBasicPo!=null){
			if(this.optometryBasicBjtrDao.getOptometryBasicCount2(optometryBasicPo)==0){
				this.optometryBasicBjtrDao.optometryBasicInsert(optometryBasicPo);
			}else{
				
			}
		}
		
		if(optometryPo!=null){
			if(this.optometryBasicBjtrDao.getOptometryCount2(optometryPo)==0){
				this.optometryBasicBjtrDao.optometryInsert(optometryPo);
			}else{	
				this.optometryBasicBjtrDao.optometryUpdate(optometryPo);
			}
		}
		
		if(!Utility.getName(optometryPo.getSopoyoptometrybasicid()).equals("")){
			this.optometryBasicBjtrDao.updateOptoTime(optometryPo.getSopoyoptometrybasicid());
		}
		
		if(!Utility.getName(optometryPo.getSopoyoptometryid()).equals("")){
			this.optometryBasicBjtrDao.updateOptoTime1(optometryPo.getSopoyoptometryid());
		}
	}

	public void contactGlassInsertMessage(List<ContactGlassPo> contactGlassPos,OptometryPo optometryPo,OptometryBasicPo optometryBasicPo,SmsRecordPo smsRecordPo,String isSend,PersonInfoPo personInfoPo,String customerID,LogisticsLogPo logPo) 
	{
		logisticsLogDao.insertLog(logPo);  //新增日志
		if(contactGlassPos!=null)
		{
			for(int i=0;i<contactGlassPos.size();i++)
			{
				this.contactGlassBjtrDao.contactGlassInsert(contactGlassPos.get(i));
			}
		}
		if(optometryBasicPo!=null){
			if(this.optometryBasicBjtrDao.getOptometryBasicCount2(optometryBasicPo)==0){
				this.optometryBasicBjtrDao.optometryBasicInsert(optometryBasicPo);
			}else{
				
			}
		}
		
		if(optometryPo!=null){
			if(this.optometryBasicBjtrDao.getOptometryCount2(optometryPo)==0){
				this.optometryBasicBjtrDao.optometryInsert(optometryPo);
			}else{	
				this.optometryBasicBjtrDao.optometryUpdate(optometryPo);
			}
		}
		
		if(!Utility.getName(optometryPo.getSopoyoptometrybasicid()).equals("")){
			this.optometryBasicBjtrDao.updateOptoTime(optometryPo.getSopoyoptometrybasicid());
		}
		
		if(!Utility.getName(optometryPo.getSopoyoptometryid()).equals("")){
			this.optometryBasicBjtrDao.updateOptoTime1(optometryPo.getSopoyoptometryid());
		}
	}
	
	
	public void contactGlassUpdate(ContactGlassPo contactGlassPo) {
		this.contactGlassBjtrDao.contactGlassInsert(contactGlassPo);

		
	}


	public List<ContactGlassPo> getContactGlassList(ContactGlassPo contactGlassPo) {
		return this.contactGlassBjtrDao.getContactGlassList(contactGlassPo);
	}

	
	public void contactGlassDelete(ContactGlassPo contactGlassPo) {
		this.contactGlassBjtrDao.contactGlassDelete(contactGlassPo);
	}

	
	public int getcontactGlassCount(OptometryPo optometryPo) {
		return this.contactGlassBjtrDao.getContactGlassCount(optometryPo);
	}

	
	public void contactGlassUpdate(List<ContactGlassPo> contactGlassPos,
			OptometryPo optometryPo) {
		this.contactGlassBjtrDao.contactGlassDelete(contactGlassPos.get(0));

		
		for(int i=0;i<contactGlassPos.size();i++){
			
				this.contactGlassBjtrDao.contactGlassInsert(contactGlassPos.get(i));
			
		}
		this.optometryBasicBjtrDao.optometryUpdate(optometryPo);
		if(!Utility.getName(optometryPo.getSopoyoptometrybasicid()).equals("")){
			this.optometryBasicBjtrDao.updateOptoTime(optometryPo.getSopoyoptometrybasicid());
		}
		if(!Utility.getName(optometryPo.getSopoyoptometryid()).equals("")){
			this.optometryBasicBjtrDao.updateOptoTime1(optometryPo.getSopoyoptometryid());
		}
		
	}
	
	public void contactGlassUpdateMessage(List<ContactGlassPo> contactGlassPos,OptometryPo optometryPo,SmsRecordPo smsRecordPo,String isSend,PersonInfoPo personInfoPo,String customerID) {
		if(contactGlassPos!=null)
		{
			this.contactGlassBjtrDao.contactGlassDelete(contactGlassPos.get(0));
			for(int i=0;i<contactGlassPos.size();i++)
			{			
				if(contactGlassPos.get(i)!=null)
				{
					
					if(null!=contactGlassPos.get(i).getSopcgindex() && contactGlassPos.get(i).getSopcgindex().equals("a"))
					{
						this.contactGlassBjtrDao.contactGlassInsert(contactGlassPos.get(i));
					}
				}
			}
		}
		this.optometryBasicBjtrDao.optometryUpdate(optometryPo);
		if(!Utility.getName(optometryPo.getSopoyoptometrybasicid()).equals("")){
			this.optometryBasicBjtrDao.updateOptoTime(optometryPo.getSopoyoptometrybasicid());
		}
		if(!Utility.getName(optometryPo.getSopoyoptometryid()).equals("")){
			this.optometryBasicBjtrDao.updateOptoTime1(optometryPo.getSopoyoptometryid());
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
		return contactGlassBjtrDao.getCustomerInfo(id);
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
