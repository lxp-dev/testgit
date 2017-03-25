package com.pengsheng.eims.sales.mgr.impl;

import java.util.List;

import com.pengsheng.eims.components.dao.DelaysReminderInformDao;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.dao.CustomerInfoDao;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.member.persistence.SmsRecordPo;
import com.pengsheng.eims.sales.dao.InspectionDao;
import com.pengsheng.eims.sales.dao.OptometryBasicDao;
import com.pengsheng.eims.sales.mgr.InspectionMgr;
import com.pengsheng.eims.sales.persistence.InspectionPo;
import com.pengsheng.eims.sales.persistence.OptometryBasicPo;
import com.pengsheng.eims.sales.persistence.OptometryPo;
import com.pengsheng.eims.system.mgr.SendNoteMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.SendNotePo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.tools.TurnSphCyl;
import com.pengsheng.eims.util.tools.Utility;

public class InspectionMrgImpl implements InspectionMgr{
	
	private LogisticsLogDao logisticsLogDao;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private SendNoteMgr sendNoteMgr = null;
	
	public SendNoteMgr getSendNoteMgr() {
		return sendNoteMgr;
	}

	public void setSendNoteMgr(SendNoteMgr sendNoteMgr) {
		this.sendNoteMgr = sendNoteMgr;
	}

	public SystemParameterMgr getSystemParameterMgr() {
		return systemParameterMgr;
	}

	public void setSystemParameterMgr(SystemParameterMgr systemParameterMgr) {
		this.systemParameterMgr = systemParameterMgr;
	}

	public SystemParameterPo getSystemParameterPo() {
		return systemParameterPo;
	}

	public void setSystemParameterPo(SystemParameterPo systemParameterPo) {
		this.systemParameterPo = systemParameterPo;
	}

	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}
	private InspectionDao inspectionDao;
	public InspectionDao getInspectionDao() {
		return inspectionDao;
	}
	
	private CustomerInfoDao customerInfoDao;
	private DelaysReminderInformDao delaysReminderInformDao;
	private OptometryBasicDao optometryBasicDao;
	public OptometryBasicDao getOptometryBasicDao() {
		return optometryBasicDao;
	}

	public void setOptometryBasicDao(OptometryBasicDao optometryBasicDao) {
		this.optometryBasicDao = optometryBasicDao;
	}

	public void setInspectionDao(InspectionDao inspectionDao) {
		this.inspectionDao = inspectionDao;
	}

	public void inspectionInsert(InspectionPo inspectionPo,OptometryPo optometryPo,OptometryBasicPo optometryBasicPo) {
		this.inspectionDao.inspectionInsert(inspectionPo);
		
		if(optometryBasicPo!=null){
			if(this.optometryBasicDao.getOptometryBasicCount2(optometryBasicPo)==0){
				this.optometryBasicDao.optometryBasicInsert(optometryBasicPo);
			}else{
				
			}
		}	
		if(optometryPo!=null){
			if(this.optometryBasicDao.getOptometryCount2(optometryPo)==0){
				this.optometryBasicDao.optometryInsert(optometryPo);
			}else{	
				this.optometryBasicDao.optometryUpdate(optometryPo);
			}
		}
	}
	
	public void inspectionInsert(List<InspectionPo> inspectionPos,OptometryPo optometryPo,OptometryBasicPo optometryBasicPo,LogisticsLogPo logPo) 
	{
		logisticsLogDao.insertLog(logPo);  //新增日志
		
		for(int i=0;i<inspectionPos.size();i++){
			if(!"".equals(Utility.getName(inspectionPos.get(i).getSopipglasstype()))){
				this.inspectionDao.inspectionInsert(inspectionPos.get(i));
			}
		}
		
		if(optometryBasicPo!=null){
			if(this.optometryBasicDao.getOptometryBasicCount2(optometryBasicPo)==0){
				this.optometryBasicDao.optometryBasicInsert(optometryBasicPo);
			}else{
				
			}
		}
		
		if(optometryPo!=null){
			if(this.optometryBasicDao.getOptometryCount2(optometryPo)==0){
				this.optometryBasicDao.optometryInsert(optometryPo);
			}else{	
				this.optometryBasicDao.optometryUpdate(optometryPo);
			}
		}
		
		if(optometryPo != null && !Utility.getName(optometryPo.getSopoyoptometrybasicid()).equals("")){
			this.optometryBasicDao.updateOptoTime(optometryPo.getSopoyoptometrybasicid());
		}
		
		if(optometryPo != null && !Utility.getName(optometryPo.getSopoyoptometryid()).equals("")){
			this.optometryBasicDao.updateOptoTime1(optometryPo.getSopoyoptometryid());
		}
	}

	public void inspectionInsertMessage(List<InspectionPo> inspectionPos,OptometryPo optometryPo,OptometryBasicPo optometryBasicPo,SmsRecordPo smsRecordPo,String isSend,PersonInfoPo personInfoPo,String customerID,LogisticsLogPo logPo) 
	{
		logisticsLogDao.insertLog(logPo);  //新增日志
		
		for(int i=0;i<inspectionPos.size();i++){
			if(!"".equals(Utility.getName(inspectionPos.get(i).getSopipglasstype()))){
				if("1".equals(Utility.getName(systemParameterMgr.getSystemParameterPo().getFspothernegative()))){
					inspectionPos.get(i).setSopipballglassod(TurnSphCyl.changeSph(inspectionPos.get(i).getSopipballglassod(), inspectionPos.get(i).getSopippostglassod()));
					inspectionPos.get(i).setSopipballglassos(TurnSphCyl.changeSph(inspectionPos.get(i).getSopipballglassos(), inspectionPos.get(i).getSopippostglassos()));
					inspectionPos.get(i).setSopippostglassod(TurnSphCyl.changeCyl(inspectionPos.get(i).getSopipballglassod(), inspectionPos.get(i).getSopippostglassod()));
					inspectionPos.get(i).setSopippostglassos(TurnSphCyl.changeCyl(inspectionPos.get(i).getSopipballglassos(), inspectionPos.get(i).getSopippostglassos()));
				}
				this.inspectionDao.inspectionInsert(inspectionPos.get(i));
			}
		}
		
		if(optometryBasicPo!=null){
			if(this.optometryBasicDao.getOptometryBasicCount2(optometryBasicPo)==0){
				this.optometryBasicDao.optometryBasicInsert(optometryBasicPo);
			}else{
				
			}
		}
		
		if(optometryPo!=null){
			if(this.optometryBasicDao.getOptometryCount2(optometryPo)==0){
				this.optometryBasicDao.optometryInsert(optometryPo);
			}else{	
				this.optometryBasicDao.optometryUpdate(optometryPo);
			}
		}
		
		if(!Utility.getName(optometryPo.getSopoyoptometrybasicid()).equals("")){
			this.optometryBasicDao.updateOptoTime(optometryPo.getSopoyoptometrybasicid());
		}
		
		if(!Utility.getName(optometryPo.getSopoyoptometryid()).equals("")){
			this.optometryBasicDao.updateOptoTime1(optometryPo.getSopoyoptometryid());
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
		this.inspectionDao.inspectionInsert(inspectionPo);

		
	}


	public List<InspectionPo> getInspectionList(InspectionPo inspectionPo) {
		// TODO Auto-generated method stub
		return this.inspectionDao.getInspectionList(inspectionPo);
	}

	
	public void inspectionDelete(InspectionPo inspectionPo) {
		// TODO Auto-generated method stub
		this.inspectionDao.inspectionDelete(inspectionPo);
	}

	
	public int getInspectionCount(OptometryPo optometryPo) {
		// TODO Auto-generated method stub
		return this.inspectionDao.getInspectionCount(optometryPo);
	}

	
//	public void inspectionUpdate(InspectionPo inspectionPo,
//			OptometryPo optometryPo) {
//		// TODO Auto-generated method stub
//		this.inspectionDao.inspectionInsert(inspectionPo);
//		this.optometryBasicDao.optometryUpdate(optometryPo);
//	}
	public void inspectionUpdate(List<InspectionPo> inspectionPos,
			OptometryPo optometryPo) {
		// TODO Auto-generated method stub
		this.inspectionDao.inspectionDelete(inspectionPos.get(0));

		
		for(int i=0;i<inspectionPos.size();i++){
			if(!"".equals(Utility.getName(inspectionPos.get(i).getSopipglasstype()))){
				this.inspectionDao.inspectionInsert(inspectionPos.get(i));
			}
		}
		this.optometryBasicDao.optometryUpdate(optometryPo);
		if(!Utility.getName(optometryPo.getSopoyoptometrybasicid()).equals("")){
			this.optometryBasicDao.updateOptoTime(optometryPo.getSopoyoptometrybasicid());
		}
		if(!Utility.getName(optometryPo.getSopoyoptometryid()).equals("")){
			this.optometryBasicDao.updateOptoTime1(optometryPo.getSopoyoptometryid());
		}
		
	}
	
	public void inspectionUpdateMessage(List<InspectionPo> inspectionPos,OptometryPo optometryPo,SmsRecordPo smsRecordPo,String isSend,PersonInfoPo personInfoPo,String customerID) {
		// TODO Auto-generated method stub
		this.inspectionDao.inspectionDelete(inspectionPos.get(0));

		
		for(int i=0;i<inspectionPos.size();i++){
			if(!"".equals(Utility.getName(inspectionPos.get(i).getSopipglasstype()))){
				this.inspectionDao.inspectionInsert(inspectionPos.get(i));
			}
		}
		this.optometryBasicDao.optometryUpdate(optometryPo);
		if(!Utility.getName(optometryPo.getSopoyoptometrybasicid()).equals("")){
			this.optometryBasicDao.updateOptoTime(optometryPo.getSopoyoptometrybasicid());
		}
		if(!Utility.getName(optometryPo.getSopoyoptometryid()).equals("")){
			this.optometryBasicDao.updateOptoTime1(optometryPo.getSopoyoptometryid());
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
		inspectionDao.inspectionprint(id);
	}
	public void updateInspectionFlag(String id,SendNotePo snpo){
		
		inspectionDao.updateInspectionFlag(id);
		
		if (!"".equals(Utility.getName(snpo.getSnfurtherdate())) && !"".equals(Utility.getName(snpo.getSncustomerid()))){
			sendNoteMgr.insertSendNoteContent(snpo);
		}
		
	}

	public CustomerInfoPo getCustomerInfo(String id){
		return inspectionDao.getCustomerInfo(id);
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
