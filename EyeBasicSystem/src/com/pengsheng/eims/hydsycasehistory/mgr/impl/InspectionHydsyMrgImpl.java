package com.pengsheng.eims.hydsycasehistory.mgr.impl;

import java.util.List;

import com.pengsheng.eims.components.dao.DelaysReminderInformDao;
import com.pengsheng.eims.hydsycasehistory.dao.InspectionHydsyDao;
import com.pengsheng.eims.hydsycasehistory.dao.OptometryBasicHydsyDao;
import com.pengsheng.eims.hydsycasehistory.mgr.InspectionHydsyMgr;
import com.pengsheng.eims.hydsycasehistory.persistence.InspectionPo;
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

public class InspectionHydsyMrgImpl implements InspectionHydsyMgr{
	
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
	private InspectionHydsyDao inspectionHydsyDao;
	public InspectionHydsyDao getInspectionHydsyDao() {
		return inspectionHydsyDao;
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

	public void setInspectionHydsyDao(InspectionHydsyDao inspectionHydsyDao) {
		this.inspectionHydsyDao = inspectionHydsyDao;
	}

	public void inspectionInsert(InspectionPo inspectionPo,OptometryPo optometryPo,OptometryBasicPo optometryBasicPo) {
		this.inspectionHydsyDao.inspectionInsert(inspectionPo);
		
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
	
	public void inspectionInsert(List<InspectionPo> inspectionPos,OptometryPo optometryPo,OptometryBasicPo optometryBasicPo,LogisticsLogPo logPo) 
	{
		logisticsLogDao.insertLog(logPo);  //新增日志
		
		for(int i=0;i<inspectionPos.size();i++){
			if(!"".equals(Utility.getName(inspectionPos.get(i).getSopipglasstype()))){
				this.inspectionHydsyDao.inspectionInsert(inspectionPos.get(i));
			}
		}
		
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
		
		if(!Utility.getName(optometryPo.getSopoyoptometrybasicid()).equals("")){
			this.optometryBasicHydsyDao.updateOptoTime(optometryPo.getSopoyoptometrybasicid());
		}
		
		if(!Utility.getName(optometryPo.getSopoyoptometryid()).equals("")){
			this.optometryBasicHydsyDao.updateOptoTime1(optometryPo.getSopoyoptometryid());
		}
	}

	public void inspectionInsertMessage(List<InspectionPo> inspectionPos,OptometryPo optometryPo,OptometryBasicPo optometryBasicPo,SmsRecordPo smsRecordPo,String isSend,PersonInfoPo personInfoPo,String customerID,LogisticsLogPo logPo) 
	{
		logisticsLogDao.insertLog(logPo);  //新增日志
		
		for(int i=0;i<inspectionPos.size();i++){
			if(!"".equals(Utility.getName(inspectionPos.get(i).getSopipglasstype()))){
				this.inspectionHydsyDao.inspectionInsert(inspectionPos.get(i));
			}
		}
		
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
	
	
	public void inspectionUpdate(InspectionPo inspectionPo) {
		this.inspectionHydsyDao.inspectionInsert(inspectionPo);

		
	}


	public List<InspectionPo> getInspectionList(InspectionPo inspectionPo) {
		return this.inspectionHydsyDao.getInspectionList(inspectionPo);
	}

	
	public void inspectionDelete(InspectionPo inspectionPo) {
		this.inspectionHydsyDao.inspectionDelete(inspectionPo);
	}

	
	public int getInspectionCount(OptometryPo optometryPo) {
		return this.inspectionHydsyDao.getInspectionCount(optometryPo);
	}

	
	public void inspectionUpdate(List<InspectionPo> inspectionPos,
			OptometryPo optometryPo) {
		this.inspectionHydsyDao.inspectionDelete(inspectionPos.get(0));

		
		for(int i=0;i<inspectionPos.size();i++){
			if(!"".equals(Utility.getName(inspectionPos.get(i).getSopipglasstype()))){
				this.inspectionHydsyDao.inspectionInsert(inspectionPos.get(i));
			}
		}
		this.optometryBasicHydsyDao.optometryUpdate(optometryPo);
		if(!Utility.getName(optometryPo.getSopoyoptometrybasicid()).equals("")){
			this.optometryBasicHydsyDao.updateOptoTime(optometryPo.getSopoyoptometrybasicid());
		}
		if(!Utility.getName(optometryPo.getSopoyoptometryid()).equals("")){
			this.optometryBasicHydsyDao.updateOptoTime1(optometryPo.getSopoyoptometryid());
		}
		
	}
	
	public void inspectionUpdateMessage(List<InspectionPo> inspectionPos,OptometryPo optometryPo,SmsRecordPo smsRecordPo,String isSend,PersonInfoPo personInfoPo,String customerID) {
		this.inspectionHydsyDao.inspectionDelete(inspectionPos.get(0));

		
		for(int i=0;i<inspectionPos.size();i++){
			if(!"".equals(Utility.getName(inspectionPos.get(i).getSopipglasstype()))){
				this.inspectionHydsyDao.inspectionInsert(inspectionPos.get(i));
			}
		}
		this.optometryBasicHydsyDao.optometryUpdate(optometryPo);
		if(!Utility.getName(optometryPo.getSopoyoptometrybasicid()).equals("")){
			this.optometryBasicHydsyDao.updateOptoTime(optometryPo.getSopoyoptometrybasicid());
		}
		if(!Utility.getName(optometryPo.getSopoyoptometryid()).equals("")){
			this.optometryBasicHydsyDao.updateOptoTime1(optometryPo.getSopoyoptometryid());
		}
	}
	
	public void inspectionprint(String id){
		inspectionHydsyDao.inspectionprint(id);
	}
	public void updateInspectionFlag(String id,SendNotePo snpo){		
		inspectionHydsyDao.updateInspectionFlag(id);
	}

	public CustomerInfoPo getCustomerInfo(String id){
		return inspectionHydsyDao.getCustomerInfo(id);
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
