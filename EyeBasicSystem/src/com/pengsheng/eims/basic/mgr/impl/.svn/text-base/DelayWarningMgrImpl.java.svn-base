package com.pengsheng.eims.basic.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.dao.DelayWarningDao;
import com.pengsheng.eims.basic.mgr.DelayWarningMgr;
import com.pengsheng.eims.basic.persistence.DelayNoticePo;
import com.pengsheng.eims.basic.persistence.DelayWarningPo;
import com.pengsheng.eims.components.dao.DelaysReminderInformDao;
import com.pengsheng.eims.components.dao.InTransitDetailsDao;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.dao.CustomerInfoDao;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.system.mgr.SendNoteMgr;
import com.pengsheng.eims.system.persistence.SendNotePo;
import com.pengsheng.eims.util.tools.Utility;

public class DelayWarningMgrImpl implements DelayWarningMgr {
	
	private LogisticsLogDao logisticsLogDao;
	private DelayWarningDao delayWarningDao; 
	private CustomerInfoDao customerInfoDao;
	private DelaysReminderInformDao delaysReminderInformDao;
	private SendNoteMgr sendNoteMgr = null;
	private InTransitDetailsDao inTransitDetailsDao;
	
	public InTransitDetailsDao getInTransitDetailsDao() {
		return inTransitDetailsDao;
	}

	public void setInTransitDetailsDao(InTransitDetailsDao inTransitDetailsDao) {
		this.inTransitDetailsDao = inTransitDetailsDao;
	}

	public SendNoteMgr getSendNoteMgr() {
		return sendNoteMgr;
	}

	public void setSendNoteMgr(SendNoteMgr sendNoteMgr) {
		this.sendNoteMgr = sendNoteMgr;
	}

	public DelaysReminderInformDao getDelaysReminderInformDao() {
		return delaysReminderInformDao;
	}

	public void setDelaysReminderInformDao(
			DelaysReminderInformDao delaysReminderInformDao) {
		this.delaysReminderInformDao = delaysReminderInformDao;
	}

	public CustomerInfoDao getCustomerInfoDao() {
		return customerInfoDao;
	}

	public void setCustomerInfoDao(CustomerInfoDao customerInfoDao) {
		this.customerInfoDao = customerInfoDao;
	}

	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	/**
	 * 加载误期提醒Po
	 * @return
	 */
	public DelayWarningPo selectDelayWarningPo(){
		return delayWarningDao.selectDelayWarningPo();
	}
	
	/**
	 * 插入误期提醒
	 * @param po
	 */
	public void insertDelayWarning(DelayWarningPo po,LogisticsLogPo logPo){
		delayWarningDao.insertDelayWarning(po);
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	/**
	 * 更新误期提醒
	 * @param po
	 */
	public void updateDelayWarning(DelayWarningPo po,LogisticsLogPo logPo){
		delayWarningDao.updateDelayWarning(po);
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	/**
	 * 委外预误期查询count
	 * @param po
	 */
	public int selectDelayWarningCount(DelayWarningPo po){
		return delayWarningDao.selectDelayWarningCount(po);
	}
	
	/**
	 * 委外预误期查询list
	 * @param po
	 */
	public List<DelayWarningPo> selectDelayWarningList(DelayWarningPo po, int start,int size){
		return delayWarningDao.selectDelayWarningList(po, start, size);
	}

	public DelayWarningDao getDelayWarningDao() {
		return delayWarningDao;
	}

	public void setDelayWarningDao(DelayWarningDao delayWarningDao) {
		this.delayWarningDao = delayWarningDao;
	}
	
	/**
	 * 委外预误期加载po
	 * @param po
	 */
	public DelayNoticePo selectDelayNoticePo(DelayNoticePo po){
		return delayWarningDao.selectDelayNoticePo(po);
	}
	
	/**
	 * 委外预误期通知新增
	 * @param po
	 */
	public void insertDelayNotice(DelayNoticePo po,SendNotePo snpo)
	{		
		
		delayWarningDao.insertDelayNotice(po);

		//发送短信
		CustomerInfoPo cpo = new CustomerInfoPo();
		cpo.setSmecicustomerid(Utility.getName(snpo.getSncustomerid()));
		cpo = customerInfoDao.getCustomerInfo(cpo);
		
		snpo.setSncustomername(Utility.getName(cpo.getSmeciname()));
		snpo.setSnsex(Utility.getName(cpo.getSmecisex()).equals("0") ? "先生" : (Utility.getName(cpo.getSmecisex()).equals("1") ? "女士" : ""));
		
		SalesBasicPo salesBasicPo = new SalesBasicPo();
		salesBasicPo.setSsesbsalesid(Utility.getName(snpo.getSnbillid()));
		salesBasicPo = inTransitDetailsDao.getCustomerInfo(salesBasicPo);
		
		snpo.setSnshopcodephone(Utility.getName(salesBasicPo.getSsesbsalestelphone()));
		
		sendNoteMgr.insertSendNoteContent(snpo);
	}
	
	/**
	 * 委外预误期通知更新
	 * @param po
	 */
	public void updateDelayNotice(DelayNoticePo po){
		delayWarningDao.updateDelayNotice(po);
	}
}
