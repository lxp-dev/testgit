package com.pengsheng.eims.sales.mgr.impl;

import java.util.List;

import com.pengsheng.eims.components.dao.DelaysReminderInformDao;
import com.pengsheng.eims.logistics.mgr.LogisticsLogMgr;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.dao.CustomerInfoDao;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.member.persistence.SmsRecordPo;
import com.pengsheng.eims.sales.dao.CustomerComplainDao;
import com.pengsheng.eims.sales.mgr.CustomerComplainMgr;
import com.pengsheng.eims.sales.persistence.CustomerComplainPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.util.tools.Utility;

public class CustomerComplainMgrImpl implements CustomerComplainMgr{
	private LogisticsLogMgr logisticsLogMgr;
	private CustomerComplainDao customerComplainDao;
	private CustomerInfoDao customerInfoDao;
	private DelaysReminderInformDao delaysReminderInformDao;
	public void insertCustomerComplainPo(CustomerComplainPo po,SmsRecordPo smsRecordPo,String isSend,PersonInfoPo personInfoPo,LogisticsLogPo logisticsLogPo) 
	{
		//customerComplainPo.smecccustomermemberid
		customerComplainDao.insertCustomerComplainPo(po);
		
		if(!"".equals(Utility.getName(po.getHandletype()))){
			customerComplainDao.insertCustomerComplainHandlePo(po);
			customerComplainDao.updateCustomerComplainPo(po);
		}
		
		if(isSend.equals("1"))
		{
			CustomerInfoPo cpo = new CustomerInfoPo();
			cpo.setSmecimemberid(po.getSmecccustomermemberid());
			CustomerInfoPo customerInfoPo = customerInfoDao.getCustomerInfo(cpo);

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

		}
		logisticsLogMgr.insertLog(logisticsLogPo);
	}
	
	public int selectCustomerComplainCount(CustomerComplainPo po) {
		return customerComplainDao.selectCustomerComplainCount(po);
	}
	
	public List<CustomerComplainPo> selectCustomerComplainHandleList(
			CustomerComplainPo po) {
		return customerComplainDao.selectCustomerComplainHandleList(po);
	}
	
	public List<CustomerComplainPo> selectCustomerComplainList(
			CustomerComplainPo po, int start, int size) {
		return customerComplainDao.selectCustomerComplainList(po, start, size);
	}
	
	public CustomerComplainPo selectCustomerComplainPo(CustomerComplainPo po) {
		return customerComplainDao.selectCustomerComplainPo(po);
	}
	
	public void updateCustomerComplainPo(CustomerComplainPo po,
			LogisticsLogPo logisticsLogPo) {
		customerComplainDao.updateCustomerComplainPo(po);
		customerComplainDao.insertCustomerComplainHandlePo(po);
	}
	/**
	 * 会员详细链接LIST
	 * @param po
	 * @return
	 */
	public List<CustomerComplainPo> getCustomerComplainListByCustomer(String id,int start, int size) 
	{
		return customerComplainDao.getCustomerComplainListByCustomer(id, start, size);
	}
	/**
	 * 会员详细链接总数
	 * @param po
	 * @return
	 */
	public int getCustomerComplainCountByCustomer(String id) 
	{
		return customerComplainDao.getCustomerComplainCountByCustomer(id);
	}
	
	/**
	 * 删除投诉
	 * @param po
	 */
	public void deleteCustomerComplain(CustomerComplainPo po,LogisticsLogPo logisticsLogPo){
		customerComplainDao.deleteCustomerComplain(po);
		logisticsLogMgr.insertLog(logisticsLogPo);
	}
	
	/**
	 * 获取改配镜单的投诉总数
	 * @param po
	 * @return
	 */
	public int getCustomerComplainBySalesBillCount (CustomerComplainPo po){
		return customerComplainDao.getCustomerComplainBySalesBillCount(po);
	}
	
	public LogisticsLogMgr getLogisticsLogMgr() {
		return logisticsLogMgr;
	}
	public void setLogisticsLogMgr(LogisticsLogMgr logisticsLogMgr) {
		this.logisticsLogMgr = logisticsLogMgr;
	}
	public CustomerComplainDao getCustomerComplainDao() {
		return customerComplainDao;
	}
	public void setCustomerComplainDao(CustomerComplainDao customerComplainDao) {
		this.customerComplainDao = customerComplainDao;
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
