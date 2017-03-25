package com.pengsheng.eims.casehistory.mgr.impl;

import java.util.List;

import com.pengsheng.eims.components.dao.DelaysReminderInformDao;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.dao.CustomerInfoDao;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.member.persistence.SmsRecordPo;
import com.pengsheng.eims.casehistory.dao.InspectionNDao;
import com.pengsheng.eims.casehistory.dao.OptometryBasicNDao;
import com.pengsheng.eims.casehistory.mgr.InspectionNMgr;
import com.pengsheng.eims.casehistory.persistence.InspectionPo;
import com.pengsheng.eims.casehistory.persistence.OptometryBasicPo;
import com.pengsheng.eims.casehistory.persistence.OptometryPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.SendNotePo;
import com.pengsheng.eims.util.tools.Utility;

public class InspectionNMrgImpl implements InspectionNMgr{
	
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
	private InspectionNDao inspectionNDao;
	public InspectionNDao getInspectionNDao() {
		return inspectionNDao;
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

	public void setInspectionNDao(InspectionNDao inspectionNDao) {
		this.inspectionNDao = inspectionNDao;
	}

	public void inspectionInsert(InspectionPo inspectionPo,OptometryPo optometryPo,OptometryBasicPo optometryBasicPo) {
		this.inspectionNDao.inspectionInsert(inspectionPo);
		
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
	
	public void inspectionInsert(List<InspectionPo> inspectionPos,OptometryPo optometryPo,OptometryBasicPo optometryBasicPo,LogisticsLogPo logPo) 
	{
		logisticsLogDao.insertLog(logPo);  //新增日志
		
		for(int i=0;i<inspectionPos.size();i++){
			if(!"".equals(Utility.getName(inspectionPos.get(i).getSopipglasstype()))){
				this.inspectionNDao.inspectionInsert(inspectionPos.get(i));
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

	public void inspectionInsertMessage(List<InspectionPo> inspectionPos,OptometryPo optometryPo,OptometryBasicPo optometryBasicPo,SmsRecordPo smsRecordPo,String isSend,PersonInfoPo personInfoPo,String customerID,LogisticsLogPo logPo) 
	{
		logisticsLogDao.insertLog(logPo);  //新增日志
		
		for(int i=0;i<inspectionPos.size();i++){
			if(!"".equals(Utility.getName(inspectionPos.get(i).getSopipglasstype()))){
				/*if("1".equals(Utility.getName(systemParameterMgr.getSystemParameterPo().getFspothernegative()))){
					inspectionPos.get(i).setSopipballglassod(TurnSphCyl.changeSph(inspectionPos.get(i).getSopipballglassod(), inspectionPos.get(i).getSopippostglassod()));
					inspectionPos.get(i).setSopipballglassos(TurnSphCyl.changeSph(inspectionPos.get(i).getSopipballglassos(), inspectionPos.get(i).getSopippostglassos()));
					inspectionPos.get(i).setSopippostglassod(TurnSphCyl.changeCyl(inspectionPos.get(i).getSopipballglassod(), inspectionPos.get(i).getSopippostglassod()));
					inspectionPos.get(i).setSopippostglassos(TurnSphCyl.changeCyl(inspectionPos.get(i).getSopipballglassos(), inspectionPos.get(i).getSopippostglassos()));
				}*/
				
				this.inspectionNDao.inspectionInsert(inspectionPos.get(i));
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
		this.inspectionNDao.inspectionInsert(inspectionPo);

		
	}


	public List<InspectionPo> getInspectionList(InspectionPo inspectionPo) {
		return this.inspectionNDao.getInspectionList(inspectionPo);
	}

	
	public void inspectionDelete(InspectionPo inspectionPo) {
		this.inspectionNDao.inspectionDelete(inspectionPo);
	}

	
	public int getInspectionCount(OptometryPo optometryPo) {
		return this.inspectionNDao.getInspectionCount(optometryPo);
	}

	
	public void inspectionUpdate(List<InspectionPo> inspectionPos,
			OptometryPo optometryPo) {
		this.inspectionNDao.inspectionDelete(inspectionPos.get(0));

		
		for(int i=0;i<inspectionPos.size();i++){
			if(!"".equals(Utility.getName(inspectionPos.get(i).getSopipglasstype()))){
				this.inspectionNDao.inspectionInsert(inspectionPos.get(i));
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
	
	public void inspectionUpdateMessage(List<InspectionPo> inspectionPos,OptometryPo optometryPo,SmsRecordPo smsRecordPo,String isSend,PersonInfoPo personInfoPo,String customerID) {
		this.inspectionNDao.inspectionDelete(inspectionPos.get(0));

		
		for(int i=0;i<inspectionPos.size();i++){
			if(!"".equals(Utility.getName(inspectionPos.get(i).getSopipglasstype()))){
				this.inspectionNDao.inspectionInsert(inspectionPos.get(i));
			}
		}
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
	
	public void inspectionprint(String id){
		inspectionNDao.inspectionprint(id);
	}
	public void updateInspectionFlag(String id,SendNotePo snpo){
		
		inspectionNDao.updateInspectionFlag(id);
		
//		if (!"".equals(Utility.getName(snpo.getSnfurtherdate())) && !"".equals(Utility.getName(snpo.getSncustomerid()))){
//			sendNoteMgr.insertSendNoteContent(snpo);
//		}
		
	}

	public CustomerInfoPo getCustomerInfo(String id){
		return inspectionNDao.getCustomerInfo(id);
	}
	
	/**
	 * 获得最后一次的检查结论
	 */
	public InspectionPo getLastInspectionPo(String customerID){
		return inspectionNDao.getLastInspectionPo(customerID);
	}
	
	
	/**
	 * 获得由某验光师最后一次的检查结论
	 */
	public InspectionPo getLastInspectionPo(String customerID,String doctorID){
		return inspectionNDao.getLastInspectionPo(customerID,doctorID);
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
