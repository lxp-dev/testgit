package com.pengsheng.eims.sales.mgr.impl;

import java.util.List;

import com.pengsheng.eims.components.dao.DelaysReminderInformDao;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.dao.CustomerInfoDao;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.member.persistence.SmsRecordPo;
import com.pengsheng.eims.sales.dao.ToMailDao;
import com.pengsheng.eims.sales.mgr.ToMailMgr;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.ToMailPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.util.dao.BaseJdbcDaoSupport;
import com.pengsheng.eims.util.tools.Utility;

public class ToMailMgrImpl extends BaseJdbcDaoSupport implements ToMailMgr{
	
	private ToMailDao toMailDao;

	private LogisticsLogDao logisticsLogDao; 
	private CustomerInfoDao customerInfoDao;
	private DelaysReminderInformDao delaysReminderInformDao;
	
	public int getSalesBasicCount(SalesBasicPo po){
		return toMailDao.getSalesBasicCount(po);
	}
	
	public int getComplainSalesBasicCount(SalesBasicPo po){
		return toMailDao.getComplainSalesBasicCount(po);
	}

	/**
	 * 遍历销售结帐基表信息
	 */
	public List<SalesBasicPo> getSalesBasicList(SalesBasicPo po, int start,int size){
		return toMailDao.getSalesBasicList(po, start, size);
	}
	
	public List<SalesBasicPo> getComplainSalesBasicList(SalesBasicPo po, int start,int size){
		return toMailDao.getComplainSalesBasicList(po, start, size);
	}
	
	public void updateToMail(ToMailPo toMailPo,LogisticsLogPo logPo){
		logisticsLogDao.insertLog(logPo);  //新增日志
		toMailDao.updateToMail(toMailPo);
		if("1".equals(Utility.getName(toMailPo.getSsetmmaiilaudit()))){
			toMailDao.updateToMailSend(toMailPo);
		}
	}
	
	public void insertToMailMessage(ToMailPo toMailPo,SmsRecordPo smsRecordPo,String isSend,PersonInfoPo personInfoPo,LogisticsLogPo logPo){
		logisticsLogDao.insertLog(logPo);  //新增日志
		
		toMailPo.setSsetmuuid(this.uuid.generate());
		toMailDao.insertToMail(toMailPo);
		if("1".equals(Utility.getName(toMailPo.getSsetmmaiilaudit()))){
			toMailDao.updateToMailSend(toMailPo);
		}
		if(isSend.equals("1"))
		{
			CustomerInfoPo cpo = new CustomerInfoPo();
			cpo.setSmecimemberid(toMailPo.getSsetmmemberid());
			CustomerInfoPo customerInfoPo = customerInfoDao.getCustomerInfo(cpo);
		}
		
	}
	public void updateToMailDetail(ToMailPo toMailPo,LogisticsLogPo logPo){
		
		logisticsLogDao.insertLog(logPo);  //新增日志
		
		toMailDao.updateToMailDetail(toMailPo);

	}
	
	public void insertToMail(ToMailPo toMailPo,LogisticsLogPo logPo)
	{
		logisticsLogDao.insertLog(logPo);  //新增日志
		
		toMailPo.setSsetmuuid(this.uuid.generate());
		toMailDao.insertToMail(toMailPo);
		if("1".equals(Utility.getName(toMailPo.getSsetmmaiilaudit()))){
			toMailDao.updateToMailSend(toMailPo);
		}
	}
	
	public ToMailPo selectToMailPo(ToMailPo toMailPo){
		return toMailDao.selectToMailPo(toMailPo);
	}
	
	public int selectToMailPosCount(ToMailPo toMailPo){
		return toMailDao.selectToMailPosCount(toMailPo);
	}
	
	public List<ToMailPo> selectToMailPos(ToMailPo toMailPo, int start,int size){
		return toMailDao.selectToMailPos(toMailPo,start,size);
	}
	
	public void deleteToMailPo(ToMailPo toMailPo,LogisticsLogPo logPo){
		logisticsLogDao.insertLog(logPo);  //新增日志
		toMailDao.deleteToMailPo(toMailPo);
	}
	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	public ToMailDao getToMailDao() {
		return toMailDao;
	}

	public void setToMailDao(ToMailDao toMailDao) {
		this.toMailDao = toMailDao;
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
