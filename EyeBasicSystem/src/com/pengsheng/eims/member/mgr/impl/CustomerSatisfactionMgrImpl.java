package com.pengsheng.eims.member.mgr.impl;

import java.util.List;

import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.dao.CustomerSatisfactionDao;
import com.pengsheng.eims.member.mgr.CustomerSatisfactionMgr;
import com.pengsheng.eims.member.persistence.CustomerSatisfactionPo;

public class CustomerSatisfactionMgrImpl implements CustomerSatisfactionMgr {
	private LogisticsLogDao logisticsLogDao;

	private CustomerSatisfactionDao customerSatisfactionDao;

	public CustomerSatisfactionPo getCustomerSatisfaction(
			CustomerSatisfactionPo po) {
		return this.customerSatisfactionDao.getCustomerSatisfaction(po);
	}

	public List<CustomerSatisfactionPo> getCustomerSatisfactionList() {
		return this.customerSatisfactionDao.getCustomerSatisfactionList();
	}
	public int getCustomerSatisfactionsCount() 
	{
		return this.customerSatisfactionDao.getCustomerSatisfactionsCount();
	}
	
	public List<CustomerSatisfactionPo> getCustomerSatisfactionsList(int start, int size)
	{
		return this.customerSatisfactionDao.getCustomerSatisfactionsList(start, size);
	}
	public void insertCustomerSatisfaction(CustomerSatisfactionPo po,LogisticsLogPo logPo) {
		logisticsLogDao.insertLog(logPo);
		this.customerSatisfactionDao.insertCustomerSatisfaction(po);
	}
	
	public void deleteCustomerSatisfaction(CustomerSatisfactionPo po,LogisticsLogPo logPo) {
		logisticsLogDao.insertLog(logPo);
		this.customerSatisfactionDao.deleteCustomerSatisfaction(po);
	}

	public CustomerSatisfactionDao getCustomerSatisfactionDao() {
		return customerSatisfactionDao;
	}

	public void setCustomerSatisfactionDao(
			CustomerSatisfactionDao customerSatisfactionDao) {
		this.customerSatisfactionDao = customerSatisfactionDao;
	}

	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}
	
	public int getCustomerSatisfactionPoName(CustomerSatisfactionPo po) 
	{
		return customerSatisfactionDao.getCustomerSatisfactionPoName(po);
	}
	public int getCustomerSatisfactionPoNameUpdate(CustomerSatisfactionPo po) 
	{
		return customerSatisfactionDao.getCustomerSatisfactionPoNameUpdate(po);
	}
	
}
