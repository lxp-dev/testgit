package com.pengsheng.eims.hydsycasehistory.mgr.impl;

import java.util.List;

import com.pengsheng.eims.components.dao.DelaysReminderInformDao;
import com.pengsheng.eims.hydsycasehistory.dao.CornealContactlLensHydsyDao;
import com.pengsheng.eims.hydsycasehistory.dao.OptometryBasicHydsyDao;
import com.pengsheng.eims.hydsycasehistory.mgr.CornealContactlLensHydsyMgr;
import com.pengsheng.eims.hydsycasehistory.persistence.CornealContactlLensPo;
import com.pengsheng.eims.hydsycasehistory.persistence.OptometryBasicPo;
import com.pengsheng.eims.hydsycasehistory.persistence.OptometryPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.dao.CustomerInfoDao;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.member.persistence.SmsRecordPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.SendNotePo;
import com.pengsheng.eims.util.tools.Utility;

public class CornealContactlLensHydsyMgrImpl implements  CornealContactlLensHydsyMgr
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
	private CornealContactlLensHydsyDao cornealContactlLensHydsyDao;
	public CornealContactlLensHydsyDao getCornealContactlLensHydsyDao() {
		return cornealContactlLensHydsyDao;
	}
	
	private CustomerInfoDao customerInfoDao;
	private DelaysReminderInformDao delaysReminderInformDao;
	private OptometryBasicHydsyDao optometryBasicHydsyDao;
	
	public OptometryBasicHydsyDao getOptometryBasicHydsyDao() {
		return optometryBasicHydsyDao;
	}

	public void setOptometryBasicHydsyDao(OptometryBasicHydsyDao optometryBasicHydsyDao) {
		this.optometryBasicHydsyDao = optometryBasicHydsyDao;
	}

	public void setCornealContactlLensHydsyDao(CornealContactlLensHydsyDao cornealContactlLensHydsyDao) {
		this.cornealContactlLensHydsyDao = cornealContactlLensHydsyDao;
	}

	public void cornealContactlLensInsert(CornealContactlLensPo cornealContactlLensPo,OptometryPo optometryPo,OptometryBasicPo optometryBasicPo) {
		this.cornealContactlLensHydsyDao.cornealContactlLensInsert(cornealContactlLensPo);
		
		if(optometryBasicPo!=null){
			if(this.optometryBasicHydsyDao.getOptometryBasicCount2(optometryBasicPo)==0){
				this.optometryBasicHydsyDao.optometryBasicInsert(optometryBasicPo);
			}else{
				
			}
		}	
		if(optometryPo!=null){
			if(this.optometryBasicHydsyDao.getOptometryCount2(optometryPo)==0){
				this.optometryBasicHydsyDao.optometryInsert(optometryPo);
			}else{	
				this.optometryBasicHydsyDao.optometryUpdate(optometryPo);
			}
		}
	}
	
	public void cornealContactlLensInsert(CornealContactlLensPo cornealContactlLensPo,OptometryPo optometryPo,OptometryBasicPo optometryBasicPo,LogisticsLogPo logPo) 
	{
		logisticsLogDao.insertLog(logPo);  //新增日志
		
		this.cornealContactlLensHydsyDao.cornealContactlLensInsert(cornealContactlLensPo);
		
		if(optometryBasicPo!=null){
			if(this.optometryBasicHydsyDao.getOptometryBasicCount2(optometryBasicPo)==0){
				this.optometryBasicHydsyDao.optometryBasicInsert(optometryBasicPo);
			}
		}
		
		if(optometryPo!=null){
			if(this.optometryBasicHydsyDao.getOptometryCount2(optometryPo)==0){
				this.optometryBasicHydsyDao.optometryInsert(optometryPo);
			}else{	
				this.optometryBasicHydsyDao.optometryUpdate(optometryPo);
			}
		}
		
		if(!Utility.getName(optometryPo.getSopoyoptometrybasicid()).equals("")){
			this.optometryBasicHydsyDao.updateOptoTime(optometryPo.getSopoyoptometrybasicid());
		}
		
		if(!Utility.getName(optometryPo.getSopoyoptometryid()).equals("")){
			this.optometryBasicHydsyDao.updateOptoTime1(optometryPo.getSopoyoptometryid());
		}
	}

	public void cornealContactlLensInsertMessage(CornealContactlLensPo cornealContactlLensPo,OptometryPo optometryPo,OptometryBasicPo optometryBasicPo,SmsRecordPo smsRecordPo,String isSend,PersonInfoPo personInfoPo,String customerID,LogisticsLogPo logPo) 
	{
		logisticsLogDao.insertLog(logPo);  //新增日志
		
		this.cornealContactlLensHydsyDao.cornealContactlLensInsert(cornealContactlLensPo);
		
		if(optometryBasicPo!=null){
			if(this.optometryBasicHydsyDao.getOptometryBasicCount2(optometryBasicPo)==0){
				this.optometryBasicHydsyDao.optometryBasicInsert(optometryBasicPo);
			}
		}
		
		if(optometryPo!=null){
			if(this.optometryBasicHydsyDao.getOptometryCount2(optometryPo)==0){
				this.optometryBasicHydsyDao.optometryInsert(optometryPo);
			}else{	
				this.optometryBasicHydsyDao.optometryUpdate(optometryPo);
			}
		}
		
		if(!Utility.getName(optometryPo.getSopoyoptometrybasicid()).equals("")){
			this.optometryBasicHydsyDao.updateOptoTime(optometryPo.getSopoyoptometrybasicid());
		}
		
		if(!Utility.getName(optometryPo.getSopoyoptometryid()).equals("")){
			this.optometryBasicHydsyDao.updateOptoTime1(optometryPo.getSopoyoptometryid());
		}
	}
	
	
	public void cornealContactlLensUpdate(CornealContactlLensPo cornealContactlLensPo) {
		this.cornealContactlLensHydsyDao.cornealContactlLensInsert(cornealContactlLensPo);

		
	}


	public List<CornealContactlLensPo> getCornealContactlLensList(CornealContactlLensPo cornealContactlLensPo) {
		return this.cornealContactlLensHydsyDao.getCornealContactlLensList(cornealContactlLensPo);
	}

	
	public void cornealContactlLensDelete(CornealContactlLensPo cornealContactlLensPo) {
		this.cornealContactlLensHydsyDao.cornealContactlLensDelete(cornealContactlLensPo);
	}

	
	public int getCornealContactlLensCount(OptometryPo optometryPo) {
		return this.cornealContactlLensHydsyDao.getCornealContactlLensCount(optometryPo);
	}

	
	public void cornealContactlLensUpdate(CornealContactlLensPo cornealContactlLensPo,
			OptometryPo optometryPo) {
		this.cornealContactlLensHydsyDao.cornealContactlLensDelete(cornealContactlLensPo);

		this.cornealContactlLensHydsyDao.cornealContactlLensInsert(cornealContactlLensPo);
		
		this.optometryBasicHydsyDao.optometryUpdate(optometryPo);
		if(!Utility.getName(optometryPo.getSopoyoptometrybasicid()).equals("")){
			this.optometryBasicHydsyDao.updateOptoTime(optometryPo.getSopoyoptometrybasicid());
		}
		if(!Utility.getName(optometryPo.getSopoyoptometryid()).equals("")){
			this.optometryBasicHydsyDao.updateOptoTime1(optometryPo.getSopoyoptometryid());
		}
		
	}
	
	public void cornealContactlLensUpdateMessage(CornealContactlLensPo cornealContactlLensPo,OptometryPo optometryPo,SmsRecordPo smsRecordPo,String isSend,PersonInfoPo personInfoPo,String customerID) {
		this.cornealContactlLensHydsyDao.cornealContactlLensDelete(cornealContactlLensPo);
		
		this.cornealContactlLensHydsyDao.cornealContactlLensInsert(cornealContactlLensPo);
		
		this.optometryBasicHydsyDao.optometryUpdate(optometryPo);
		if(!Utility.getName(optometryPo.getSopoyoptometrybasicid()).equals("")){
			this.optometryBasicHydsyDao.updateOptoTime(optometryPo.getSopoyoptometrybasicid());
		}
		if(!Utility.getName(optometryPo.getSopoyoptometryid()).equals("")){
			this.optometryBasicHydsyDao.updateOptoTime1(optometryPo.getSopoyoptometryid());
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
		cornealContactlLensHydsyDao.cornealContactlLensprint(id);
	}
	public void updateCornealContactlLensFlag(String id,SendNotePo snpo){
		cornealContactlLensHydsyDao.updateCornealContactlLensFlag(id);
	}

	public CustomerInfoPo getCustomerInfo(String id){
		return cornealContactlLensHydsyDao.getCustomerInfo(id);
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
