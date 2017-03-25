package com.pengsheng.eims.bjtrhistory.mgr.impl;

import java.util.List;

import com.pengsheng.eims.components.dao.DelaysReminderInformDao;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.dao.CustomerInfoDao;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.member.persistence.SmsRecordPo;
import com.pengsheng.eims.bjtrhistory.dao.InspectionBjtrDao;
import com.pengsheng.eims.bjtrhistory.dao.OptometryBasicBjtrDao;
import com.pengsheng.eims.bjtrhistory.mgr.InspectionBjtrMgr;
import com.pengsheng.eims.bjtrhistory.persistence.InspectionPo;
import com.pengsheng.eims.bjtrhistory.persistence.OptometryBasicPo;
import com.pengsheng.eims.bjtrhistory.persistence.OptometryPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.SendNotePo;
import com.pengsheng.eims.util.tools.Utility;

public class InspectionBjtrMrgImpl implements InspectionBjtrMgr{
	
	private LogisticsLogDao logisticsLogDao;

	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}
	private InspectionBjtrDao inspectionBjtrDao;
	private CustomerInfoDao customerInfoDao;
	private DelaysReminderInformDao delaysReminderInformDao;
	private OptometryBasicBjtrDao optometryBasicBjtrDao;

	public InspectionBjtrDao getInspectionBjtrDao() {
		return inspectionBjtrDao;
	}

	public void setInspectionBjtrDao(InspectionBjtrDao inspectionBjtrDao) {
		this.inspectionBjtrDao = inspectionBjtrDao;
	}

	public OptometryBasicBjtrDao getOptometryBasicBjtrDao() {
		return optometryBasicBjtrDao;
	}

	public void setOptometryBasicBjtrDao(OptometryBasicBjtrDao optometryBasicBjtrDao) {
		this.optometryBasicBjtrDao = optometryBasicBjtrDao;
	}

	public void inspectionInsert(InspectionPo inspectionPo,OptometryPo optometryPo,OptometryBasicPo optometryBasicPo) {
		this.inspectionBjtrDao.inspectionInsert(inspectionPo);
		
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
	
	public void inspectionInsert(List<InspectionPo> inspectionPos,OptometryPo optometryPo,OptometryBasicPo optometryBasicPo,LogisticsLogPo logPo) 
	{
		logisticsLogDao.insertLog(logPo);  //新增日志
		
		for(int i=0;i<inspectionPos.size();i++){
			if(!"".equals(Utility.getName(inspectionPos.get(i).getSopipglasstype()))){
				this.inspectionBjtrDao.inspectionInsert(inspectionPos.get(i));
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
				
				this.inspectionBjtrDao.inspectionInsert(inspectionPos.get(i));
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
		this.inspectionBjtrDao.inspectionInsert(inspectionPo);

		
	}


	public List<InspectionPo> getInspectionList(InspectionPo inspectionPo) {
		return this.inspectionBjtrDao.getInspectionList(inspectionPo);
	}

	
	public void inspectionDelete(InspectionPo inspectionPo) {
		this.inspectionBjtrDao.inspectionDelete(inspectionPo);
	}

	
	public int getInspectionCount(OptometryPo optometryPo) {
		return this.inspectionBjtrDao.getInspectionCount(optometryPo);
	}

	
	public void inspectionUpdate(List<InspectionPo> inspectionPos,
			OptometryPo optometryPo) {
		this.inspectionBjtrDao.inspectionDelete(inspectionPos.get(0));

		
		for(int i=0;i<inspectionPos.size();i++){
			if(!"".equals(Utility.getName(inspectionPos.get(i).getSopipglasstype()))){
				this.inspectionBjtrDao.inspectionInsert(inspectionPos.get(i));
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
	
	public void inspectionUpdateMessage(List<InspectionPo> inspectionPos,OptometryPo optometryPo,SmsRecordPo smsRecordPo,String isSend,PersonInfoPo personInfoPo,String customerID) {
		this.inspectionBjtrDao.inspectionDelete(inspectionPos.get(0));

		
		for(int i=0;i<inspectionPos.size();i++){
			if(!"".equals(Utility.getName(inspectionPos.get(i).getSopipglasstype()))){
				this.inspectionBjtrDao.inspectionInsert(inspectionPos.get(i));
			}
		}
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
	
	public void inspectionprint(String id){
		inspectionBjtrDao.inspectionprint(id);
	}
	public void updateInspectionFlag(String id,SendNotePo snpo){
		
		inspectionBjtrDao.updateInspectionFlag(id);
		
//		if (!"".equals(Utility.getName(snpo.getSnfurtherdate())) && !"".equals(Utility.getName(snpo.getSncustomerid()))){
//			sendNoteMgr.insertSendNoteContent(snpo);
//		}
		
	}

	public CustomerInfoPo getCustomerInfo(String id){
		return inspectionBjtrDao.getCustomerInfo(id);
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
