package com.pengsheng.eims.bjtrhistory.mgr.impl;

import java.util.List;

import com.pengsheng.eims.components.dao.DelaysReminderInformDao;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.dao.CustomerInfoDao;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.member.persistence.SmsRecordPo;
import com.pengsheng.eims.bjtrhistory.dao.CornealContactlLensBjtrDao;
import com.pengsheng.eims.bjtrhistory.dao.OptometryBasicBjtrDao;
import com.pengsheng.eims.bjtrhistory.mgr.CornealContactlLensBjtrMgr;
import com.pengsheng.eims.bjtrhistory.persistence.CornealContactlLensPo;
import com.pengsheng.eims.bjtrhistory.persistence.OptometryBasicPo;
import com.pengsheng.eims.bjtrhistory.persistence.OptometryPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.SendNotePo;
import com.pengsheng.eims.util.tools.Utility;

public class CornealContactlLensBjtrMgrImpl implements  CornealContactlLensBjtrMgr
{
	private LogisticsLogDao logisticsLogDao;
	private CustomerInfoDao customerInfoDao;
	private DelaysReminderInformDao delaysReminderInformDao;
	private OptometryBasicBjtrDao optometryBasicBjtrDao;
	private CornealContactlLensBjtrDao cornealContactlLensBjtrDao;
	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	public OptometryBasicBjtrDao getOptometryBasicBjtrDao() {
		return optometryBasicBjtrDao;
	}

	public void setOptometryBasicBjtrDao(OptometryBasicBjtrDao optometryBasicBjtrDao) {
		this.optometryBasicBjtrDao = optometryBasicBjtrDao;
	}

	public CornealContactlLensBjtrDao getCornealContactlLensBjtrDao() {
		return cornealContactlLensBjtrDao;
	}

	public void setCornealContactlLensBjtrDao(
			CornealContactlLensBjtrDao cornealContactlLensBjtrDao) {
		this.cornealContactlLensBjtrDao = cornealContactlLensBjtrDao;
	}

	public void cornealContactlLensInsert(CornealContactlLensPo cornealContactlLensPo,OptometryPo optometryPo,OptometryBasicPo optometryBasicPo) {
		this.cornealContactlLensBjtrDao.cornealContactlLensInsert(cornealContactlLensPo);
		
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
	
	public void cornealContactlLensInsert(CornealContactlLensPo cornealContactlLensPo,OptometryPo optometryPo,OptometryBasicPo optometryBasicPo,LogisticsLogPo logPo) 
	{
		logisticsLogDao.insertLog(logPo);  //新增日志
		
		this.cornealContactlLensBjtrDao.cornealContactlLensInsert(cornealContactlLensPo);
		
		if(optometryBasicPo!=null){
			if(this.optometryBasicBjtrDao.getOptometryBasicCount2(optometryBasicPo)==0){
				this.optometryBasicBjtrDao.optometryBasicInsert(optometryBasicPo);
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

	public void cornealContactlLensInsertMessage(CornealContactlLensPo cornealContactlLensPo,OptometryPo optometryPo,OptometryBasicPo optometryBasicPo,SmsRecordPo smsRecordPo,String isSend,PersonInfoPo personInfoPo,String customerID,LogisticsLogPo logPo) 
	{
		logisticsLogDao.insertLog(logPo);  //新增日志
		
		this.cornealContactlLensBjtrDao.cornealContactlLensInsert(cornealContactlLensPo);
		
		if(optometryBasicPo!=null){
			if(this.optometryBasicBjtrDao.getOptometryBasicCount2(optometryBasicPo)==0){
				this.optometryBasicBjtrDao.optometryBasicInsert(optometryBasicPo);
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
	
	
	public void cornealContactlLensUpdate(CornealContactlLensPo cornealContactlLensPo) {
		this.cornealContactlLensBjtrDao.cornealContactlLensInsert(cornealContactlLensPo);

		
	}


	public List<CornealContactlLensPo> getCornealContactlLensList(CornealContactlLensPo cornealContactlLensPo) {
		return this.cornealContactlLensBjtrDao.getCornealContactlLensList(cornealContactlLensPo);
	}

	
	public void cornealContactlLensDelete(CornealContactlLensPo cornealContactlLensPo) {
		this.cornealContactlLensBjtrDao.cornealContactlLensDelete(cornealContactlLensPo);
	}

	
	public int getCornealContactlLensCount(OptometryPo optometryPo) {
		return this.cornealContactlLensBjtrDao.getCornealContactlLensCount(optometryPo);
	}

	
	public void cornealContactlLensUpdate(CornealContactlLensPo cornealContactlLensPo,
			OptometryPo optometryPo) {
		this.cornealContactlLensBjtrDao.cornealContactlLensDelete(cornealContactlLensPo);

		this.cornealContactlLensBjtrDao.cornealContactlLensInsert(cornealContactlLensPo);
		
		this.optometryBasicBjtrDao.optometryUpdate(optometryPo);
		if(!Utility.getName(optometryPo.getSopoyoptometrybasicid()).equals("")){
			this.optometryBasicBjtrDao.updateOptoTime(optometryPo.getSopoyoptometrybasicid());
		}
		if(!Utility.getName(optometryPo.getSopoyoptometryid()).equals("")){
			this.optometryBasicBjtrDao.updateOptoTime1(optometryPo.getSopoyoptometryid());
		}
		
	}
	
	public void cornealContactlLensUpdateMessage(CornealContactlLensPo cornealContactlLensPo,OptometryPo optometryPo,SmsRecordPo smsRecordPo,String isSend,PersonInfoPo personInfoPo,String customerID) {
		this.cornealContactlLensBjtrDao.cornealContactlLensDelete(cornealContactlLensPo);
		
		this.cornealContactlLensBjtrDao.cornealContactlLensInsert(cornealContactlLensPo);
		
		this.optometryBasicBjtrDao.optometryUpdate(optometryPo);
		if(!Utility.getName(optometryPo.getSopoyoptometrybasicid()).equals("")){
			this.optometryBasicBjtrDao.updateOptoTime(optometryPo.getSopoyoptometrybasicid());
		}
		if(!Utility.getName(optometryPo.getSopoyoptometryid()).equals("")){
			this.optometryBasicBjtrDao.updateOptoTime1(optometryPo.getSopoyoptometryid());
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
		cornealContactlLensBjtrDao.cornealContactlLensprint(id);
	}
	public void updateCornealContactlLensFlag(String id,SendNotePo snpo){
		
		cornealContactlLensBjtrDao.updateCornealContactlLensFlag(id);
		
//		if (!"".equals(Utility.getName(snpo.getSnfurtherdate())) && !"".equals(Utility.getName(snpo.getSncustomerid()))){
//			sendNoteMgr.insertSendNoteContent(snpo);
//		}
		
	}

	public CustomerInfoPo getCustomerInfo(String id){
		return cornealContactlLensBjtrDao.getCustomerInfo(id);
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
